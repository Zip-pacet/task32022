package ourqueue;

import ourqueue.SimpleLinkedList;

public class SimpleLinkedListQueue extends SimpleLinkedList implements SimpleQueue<Integer> {


    @Override
    public void add(Integer value) {
        this.addLast(value);
    }

    @Override
    public Integer remove() throws Exception {
        Integer result = this.element();
        this.removeFirst();
        return result;
    }

    @Override
    public Integer element() throws Exception {
        if (this.empty()) {
            throw new Exception("Queue is empty");
        }
        return this.getFirst();
    }

    @Override
    public int count() {
        return this.size();
    }

    @Override
    public boolean empty() {
        return this.count() == 0;
    }
}
