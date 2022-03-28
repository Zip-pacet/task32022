package ourqueue;

public interface SimpleQueue<Integer> {
    void add(Integer value);
    Integer remove() throws Exception;
    Integer element() throws Exception;
    int count();
    boolean empty();
}