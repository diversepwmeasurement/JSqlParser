/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.util.deparser;

import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.statement.select.Values;

public class ValuesStatementDeParser extends AbstractDeParser<Values> {

    private final ExpressionVisitor expressionVisitor;

    public ValuesStatementDeParser(ExpressionVisitor expressionVisitor, StringBuilder buffer) {
        super(buffer);
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public void deParse(Values values) {
        buffer.append("VALUES ");
        values.getExpressions().accept(expressionVisitor);
        if (values.getAlias() != null) {
            buffer.append(" ").append(values.getAlias());
        }
    }
}
