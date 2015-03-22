package com.github.begleyalan;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SomeCraicTest {

    @Test
    public void shouldReverseWord(){
        SomeCraic someCraic = new SomeCraic();
        String reversedWord = someCraic.reverseEveryOtherWord("Reverse");
        assertThat(reversedWord, is("esreveR"));
    }

    @Test
    public void shouldReverseEveryOtherWord(){
        SomeCraic someCraic = new SomeCraic();
        String reversedWords = someCraic.reverseEveryOtherWord("There is no place like home");
        assertThat(reversedWords, is("erehT is on place ekil home"));

        reversedWords = someCraic.reverseEveryOtherWord("Mary had a little lamb blah blah");
        assertThat(reversedWords, is("yraM had a little bmal blah halb"));
    }

}