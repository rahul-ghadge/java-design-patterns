package patterns.structural.proxy;

import java.util.Map;

/** Real subject: expensive to call (think of a slow database or remote server). */
public class RealDocumentService implements DocumentService {
    private final Map<String, String> storage = Map.of(
            "doc-1", "Quarterly report: revenue is up 12%.",
            "doc-2", "Salary table: confidential.");

    @Override
    public String readDocument(String documentId) {
        System.out.println("  [RealDocumentService] loading '" + documentId + "' (slow operation)...");
        String content = storage.get(documentId);
        if (content == null) {
            throw new IllegalArgumentException("Document not found: " + documentId);
        }
        return content;
    }
}
