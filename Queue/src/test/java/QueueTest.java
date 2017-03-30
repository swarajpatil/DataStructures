package test.java;

import main.java.QueueOfItem;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueueTest {

    QueueOfItem<String> queueOfItem;

    @Before
    public void queueSetUp() {
        queueOfItem = new QueueOfItem<>();
    }

    @Test
    public void queueIsEmptyWhenCreated() {
        assertThat(queueOfItem.isEmpty(), is(true));
    }

    @Test
    public void addItemToQueue() {
        queueOfItem.enqueue("one");
        assertThat(queueOfItem.isEmpty(), is(false));
    }

    @Test
    public void removeItemFromQueue() {
        queueOfItem.enqueue("one");
        queueOfItem.enqueue("two");
        assertThat(queueOfItem.dequeue(), is("one"));
    }

    @Test
    public void removeMultipleItemFromQueue() {
        queueOfItem.enqueue("one");
        queueOfItem.enqueue("two");
        queueOfItem.enqueue("three");
        queueOfItem.enqueue("four");
        queueOfItem.dequeue();
        queueOfItem.dequeue();
        assertThat(queueOfItem.dequeue(), is("three"));
    }

    @Test
    public void queueIsEmptyWhenAllItemsRemoved() {
        queueOfItem.enqueue("one");
        queueOfItem.enqueue("two");
        queueOfItem.enqueue("three");
        queueOfItem.dequeue();
        queueOfItem.dequeue();
        queueOfItem.dequeue();
        assertThat(queueOfItem.isEmpty(), is(true));
    }
}
