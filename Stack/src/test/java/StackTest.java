package test.java;

import main.java.StackOfItem;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StackTest {

    StackOfItem<String> stackOfItem;

    @Before
    public void stackSetup() {
        stackOfItem = new StackOfItem<String>();
    }

    @Test
    public void stackIsEmptyWhenCreated() {
        assertThat(stackOfItem.empty(), is(true));

    }

    @Test
    public void pushItemToStack() {
        stackOfItem.push("one");
        assertThat(stackOfItem.empty(), is(false));
    }

    @Test
    public void pushMultipleItemToStack() {
        stackOfItem.push("one");
        stackOfItem.push("two");
        stackOfItem.push("three");
        assertThat(stackOfItem.pop(), is("three"));
    }

    @Test
    public void popMostRecentItemFromStack() {
        stackOfItem.push("one");
        stackOfItem.push("two");
        stackOfItem.push("three");
        stackOfItem.pop();
        stackOfItem.push("four");
        stackOfItem.pop();
        assertThat(stackOfItem.pop(), is("two"));
    }

    @Test
    public void stackIsEmptyWhenAllItemsPop() {
        stackOfItem.push("one");
        stackOfItem.push("two");
        stackOfItem.push("three");
        stackOfItem.pop();
        stackOfItem.pop();
        stackOfItem.pop();
        assertThat(stackOfItem.empty(), is(true));
    }
}
