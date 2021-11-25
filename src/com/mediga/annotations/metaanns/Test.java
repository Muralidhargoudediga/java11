package com.mediga.annotations.metaanns;

public class Test {
    public void processData() throws @Fatal Exception {
        double value = getValue();
        int roundedValue = (@NonZero int) value;
        Test t = new @Fatal Test();
        // More code goes here
    }

    public double getValue() { double value = 189.98;
        // More code goes here
        return value;
    }

    public static void main(String[] args) {
        assert true;
        System.out.println("Test...");
        System.out.println(new String() instanceof Object);
        System.out.println( (int)"SortingSpecs".hashCode() );
    }
}

/*
 UseDialog,
    DialogTitle,
    HtmlHeader,
    Datapath,
    KeyColumn,
    ColumnMapping,
    ColumnLayouts,
    DialogWidth,
    DialogHeight,
    SortingSpecs,
 */