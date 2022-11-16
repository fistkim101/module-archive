/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.module.archive.app;

import com.module.archive.list.LinkedList;

import static com.module.archive.utilities.StringUtils.join;
import static com.module.archive.utilities.StringUtils.split;
import static com.module.archive.app.MessageUtils.getMessage;

import org.apache.commons.text.WordUtils;

public class App {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        String result = join(tokens);
        System.out.println(WordUtils.capitalize(result));
    }
}