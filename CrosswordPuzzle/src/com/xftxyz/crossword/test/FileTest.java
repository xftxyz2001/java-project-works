package com.xftxyz.crossword.test;

import java.util.Arrays;

import com.xftxyz.crossword.domain.Book;
import com.xftxyz.crossword.utils.MyFileReader;

import org.junit.Test;

public class FileTest {
    @Test
    public void testFileRead() {
        Book[] books = MyFileReader.read();
        System.out.println(System.currentTimeMillis() + Arrays.toString(books));
    }
}
