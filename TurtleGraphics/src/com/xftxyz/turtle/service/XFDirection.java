package com.xftxyz.turtle.service;

public enum XFDirection {
    东, 南, 西, 北;

    public XFDirection turnLeft() {
        switch (this) {
        case 东:
            return 北;
        case 北:
            return 西;
        case 西:
            return 南;
        case 南:
            return 东;
        default:
            return null;
        }
    }

    public XFDirection turnRight() {
        switch (this) {
        case 东:
            return 南;
        case 南:
            return 西;
        case 西:
            return 北;
        case 北:
            return 东;
        default:
            return null;
        }
    }
}
