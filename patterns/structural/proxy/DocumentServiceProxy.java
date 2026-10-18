package patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Proxy: controls access to the real service.
 * - Protection proxy: only allowed users may read documents.
 * - Caching proxy: repeated reads do not hit the slow real service again.
 * - Lazy creation: the real service is created only when first needed.
 */
public class DocumentServiceProxy implements DocumentService {
    private static final Set<String> ALLOWED_ROLES = Set.of("ADMIN", "EDITOR");

    private final String userRole;
    private final Map<String, String> cache = new HashMap<>();
    private RealDocumentService realService;   // created lazily

    public DocumentServiceProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String readDocument(String documentId) {
        if (!ALLOWED_ROLES.contains(userRole)) {
            throw new SecurityException("Role '" + userRole + "' is not allowed to read documents");
        }
        if (cache.containsKey(documentId)) {
            System.out.println("  [Proxy] returning '" + documentId + "' from cache");
            return cache.get(documentId);
        }
        if (realService == null) {
            realService = new RealDocumentService();
        }
        String content = realService.readDocument(documentId);
        cache.put(documentId, content);
        return content;
    }
}
