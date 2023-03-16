package org.exapmle.enums;

public enum ClientContainerHeader {
    CONSUMERS_LOANS("Потребительские кредиты"),
    CASH_LOAN("Кредит наличными"),
    PAYROLL_CLIENTS("Зарплатным клиентам"),
    CAR_LOAN("Кредит на автомобиль"),
    REFINANCING("Рефинансирование"),
    REPAYMENT_LOAN("Погашение кредита"),
    REDUCING_THE_FINANCIAL_BURDEN("Снижение финансовой нагрузки"),
    QUESTIONS_AND_ANSWERS_ON_CASH_LOANS("Вопросы и ответы по кредиту наличными для действующих клиентов");

    private String name;

    ClientContainerHeader(String nameContainerHeader) {
        this.name = nameContainerHeader;
    }

    public String getName() {
        return name;
    }
}
