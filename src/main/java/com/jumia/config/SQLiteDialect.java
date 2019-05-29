package com.jumia.config;

import java.sql.Types;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.AbstractAnsiTrimEmulationFunction;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class SQLiteDialect extends Dialect {

  public SQLiteDialect() {
    registerColumnType(Types.BIT, "boolean");
    registerColumnType(Types.DECIMAL, "decimal");
    registerColumnType(Types.CHAR, "char");
    registerColumnType(Types.VARCHAR, "varchar");
    registerColumnType(Types.LONGVARCHAR, "longvarchar");
    registerColumnType(Types.TIMESTAMP, "datetime");
    registerColumnType(Types.BINARY, "blob");
    registerColumnType(Types.VARBINARY, "blob");
    registerColumnType(Types.LONGVARBINARY, "blob");

    registerFunction("concat", new VarArgsSQLFunction(StandardBasicTypes.STRING, "", "||", ""));
    registerFunction("mod", new SQLFunctionTemplate(StandardBasicTypes.INTEGER, "?1 % ?2"));
    registerFunction("quote", new StandardSQLFunction("quote", StandardBasicTypes.STRING));
    registerFunction("random", new NoArgSQLFunction("random", StandardBasicTypes.INTEGER));
    registerFunction("round", new StandardSQLFunction("round"));
    registerFunction("substr", new StandardSQLFunction("substr", StandardBasicTypes.STRING));
    registerFunction("trim", new AbstractAnsiTrimEmulationFunction() {
      @Override
      protected SQLFunction resolveBothSpaceTrimFunction() {
        return new SQLFunctionTemplate(StandardBasicTypes.STRING, "trim(?1)");
      }

      @Override
      protected SQLFunction resolveBothSpaceTrimFromFunction() {
        return new SQLFunctionTemplate(StandardBasicTypes.STRING, "trim(?2)");
      }

      @Override
      protected SQLFunction resolveLeadingSpaceTrimFunction() {
        return new SQLFunctionTemplate(StandardBasicTypes.STRING, "ltrim(?1)");
      }

      @Override
      protected SQLFunction resolveTrailingSpaceTrimFunction() {
        return new SQLFunctionTemplate(StandardBasicTypes.STRING, "rtrim(?1)");
      }

      @Override
      protected SQLFunction resolveBothTrimFunction() {
        return new SQLFunctionTemplate(StandardBasicTypes.STRING, "trim(?1, ?2)");
      }

      @Override
      protected SQLFunction resolveLeadingTrimFunction() {
        return new SQLFunctionTemplate(StandardBasicTypes.STRING, "ltrim(?1, ?2)");
      }

      @Override
      protected SQLFunction resolveTrailingTrimFunction() {
        return new SQLFunctionTemplate(StandardBasicTypes.STRING, "rtrim(?1, ?2)");
      }
    });
  }
}