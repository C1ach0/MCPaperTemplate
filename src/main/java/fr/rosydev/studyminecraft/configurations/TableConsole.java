package fr.rosydev.studyminecraft.configurations;

import de.vandermeer.asciitable.AsciiTable;

import java.util.ArrayList;

public class TableConsole {
    private AsciiTable at = new AsciiTable();
    public TableConsole(String title, ArrayList<String> list) {
        at.addRule();
        at.addRow(title);
        at.addRule();
        for(String f : list) {
            at.addRow(f);
        }
        at.addRule();
        String rend = at.render();
        System.out.println("\n"+rend);
    }
}
