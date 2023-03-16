package org.exapmle.enums;

public enum ClientHeader {
    LOANS("Кредиты"),
    CARD("Карты"),
    MORTGAGE("Ипотека"),
    AUTO_CREDITS("Автокредиты"),
    DEPOSITS_AND_ACCOUNTS("Вклады и счета"),
    PAYMENTS("Платежи"),
    MORE("Еще");

    private String name;

    ClientHeader(String nameHeader) {
        this.name = nameHeader;
    }

    public String getName() {
        return name;
    }
}
