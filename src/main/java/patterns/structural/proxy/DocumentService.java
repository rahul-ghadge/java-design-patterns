package src.main.java.patterns.structural.proxy;

/** Subject: the interface shared by the real service and its proxy. */
public interface DocumentService {
    String readDocument(String documentId);
}
