/* Generated By:JavaCC: Do not edit this line. LuaParser.java */
package analizador.cvs;

public class LuaParser implements LuaParserConstants {

  public static void main(String args[]) throws ParseException {
    LuaParser parser = new LuaParser(System.in);
    parser.Chunk();
  }

  public static final int VAR  = 0;
  public static final int CALL = 1;

/** Root production. */
  final public void Chunk() throws ParseException {
    Block();
    jj_consume_token(0);
  }

  final public void Block() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DO:
      case FOR:
      case FUNCTION:
      case IF:
      case LOCAL:
      case REPEAT:
      case WHILE:
      case NAME:
      case 69:
        ;
        break;
      default:
        break label_1;
      }
      Stat();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 64:
        jj_consume_token(64);
        break;
      default:
        ;
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
    case RETURN:
      LastStat();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 64:
        jj_consume_token(64);
        break;
      default:
        ;
      }
      break;
    default:
      ;
    }
  }

  final public void Stat() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DO:
      jj_consume_token(DO);
      Block();
      jj_consume_token(END);
      break;
    case WHILE:
      jj_consume_token(WHILE);
      Exp();
      jj_consume_token(DO);
      Block();
      jj_consume_token(END);
      break;
    case REPEAT:
      jj_consume_token(REPEAT);
      Block();
      jj_consume_token(UNTIL);
      Exp();
      break;
    case IF:
      jj_consume_token(IF);
      Exp();
      jj_consume_token(THEN);
      Block();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ELSEIF:
          ;
          break;
        default:
          break label_2;
        }
        jj_consume_token(ELSEIF);
        Exp();
        jj_consume_token(THEN);
        Block();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELSE:
        jj_consume_token(ELSE);
        Block();
        break;
      default:
        ;
      }
      jj_consume_token(END);
      break;
    default:
      if (jj_2_1(3)) {
        jj_consume_token(FOR);
        jj_consume_token(NAME);
        jj_consume_token(65);
        Exp();
        jj_consume_token(66);
        Exp();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 66:
          jj_consume_token(66);
          Exp();
          break;
        default:
          ;
        }
        jj_consume_token(DO);
        Block();
        jj_consume_token(END);
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case FOR:
          jj_consume_token(FOR);
          NameList();
          jj_consume_token(IN);
          ExpList();
          jj_consume_token(DO);
          Block();
          jj_consume_token(END);
          break;
        case FUNCTION:
          jj_consume_token(FUNCTION);
          FuncName();
          FuncBody();
          break;
        default:
          if (jj_2_2(2)) {
            jj_consume_token(LOCAL);
            jj_consume_token(FUNCTION);
            jj_consume_token(NAME);
            FuncBody();
          } else {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case LOCAL:
              jj_consume_token(LOCAL);
              NameList();
              switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
              case 65:
                jj_consume_token(65);
                ExpList();
                break;
              default:
                ;
              }
              break;
            case NAME:
            case 69:
              ExprStat();
              break;
            default:
              jj_consume_token(-1);
              throw new ParseException();
            }
          }
        }
      }
    }
  }

  final public void LastStat() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
      jj_consume_token(BREAK);
      break;
    case RETURN:
      jj_consume_token(RETURN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LONGSTRING0:
      case LONGSTRING1:
      case LONGSTRING2:
      case LONGSTRING3:
      case LONGSTRINGN:
      case FALSE:
      case FUNCTION:
      case NIL:
      case NOT:
      case TRUE:
      case NAME:
      case NUMBER:
      case STRING:
      case CHARSTRING:
      case 69:
      case 73:
      case 74:
      case 77:
      case 89:
        ExpList();
        break;
      default:
        ;
      }
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ExprStat() throws ParseException {
        int type,need=CALL;
    type = PrimaryExp();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 65:
    case 66:
      Assign();
                                       need=VAR;
      break;
    default:
      ;
    }
          if ( type!=need ) {if (true) throw new ParseException("expected function call or assignment");}
  }

  final public void Assign() throws ParseException {
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 66:
        ;
        break;
      default:
        break label_3;
      }
      jj_consume_token(66);
      VarExp();
    }
    jj_consume_token(65);
    ExpList();
  }

  final public void VarExp() throws ParseException {
        int type;
    type = PrimaryExp();
          if ( type!=VAR ) {if (true) throw new ParseException("expected variable expression");}
  }

  final public void FuncName() throws ParseException {
    jj_consume_token(NAME);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 67:
        ;
        break;
      default:
        break label_4;
      }
      jj_consume_token(67);
      jj_consume_token(NAME);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 68:
      jj_consume_token(68);
      jj_consume_token(NAME);
      break;
    default:
      ;
    }
  }

  final public void PrefixExp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NAME:
      jj_consume_token(NAME);
      break;
    case 69:
      ParenExp();
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ParenExp() throws ParseException {
    jj_consume_token(69);
    Exp();
    jj_consume_token(70);
  }

  final public int PrimaryExp() throws ParseException {
        int type=VAR;
    PrefixExp();
    label_5:
    while (true) {
      if (jj_2_3(2)) {
        ;
      } else {
        break label_5;
      }
      type = PostfixOp();
    }
                                                         {if (true) return type;}
    throw new Error("Missing return statement in function");
  }

  final public int PostfixOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 67:
    case 71:
      FieldOp();
                    {if (true) return VAR;}
      break;
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case STRING:
    case CHARSTRING:
    case 68:
    case 69:
    case 74:
      FuncOp();
                    {if (true) return CALL;}
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void FieldOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 67:
      jj_consume_token(67);
      jj_consume_token(NAME);
      break;
    case 71:
      jj_consume_token(71);
      Exp();
      jj_consume_token(72);
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void FuncOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 68:
      jj_consume_token(68);
      jj_consume_token(NAME);
      FuncArgs();
      break;
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case STRING:
    case CHARSTRING:
    case 69:
    case 74:
      FuncArgs();
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void FuncArgs() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 69:
      jj_consume_token(69);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LONGSTRING0:
      case LONGSTRING1:
      case LONGSTRING2:
      case LONGSTRING3:
      case LONGSTRINGN:
      case FALSE:
      case FUNCTION:
      case NIL:
      case NOT:
      case TRUE:
      case NAME:
      case NUMBER:
      case STRING:
      case CHARSTRING:
      case 69:
      case 73:
      case 74:
      case 77:
      case 89:
        ExpList();
        break;
      default:
        ;
      }
      jj_consume_token(70);
      break;
    case 74:
      TableConstructor();
      break;
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case STRING:
    case CHARSTRING:
      Str();
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void NameList() throws ParseException {
    jj_consume_token(NAME);
    label_6:
    while (true) {
      if (jj_2_4(2)) {
        ;
      } else {
        break label_6;
      }
      jj_consume_token(66);
      jj_consume_token(NAME);
    }
  }

  final public void ExpList() throws ParseException {
    Exp();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 66:
        ;
        break;
      default:
        break label_7;
      }
      jj_consume_token(66);
      Exp();
    }
  }

  final public void SimpleExp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NIL:
      jj_consume_token(NIL);
      break;
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case STRING:
    case CHARSTRING:
      Str();
      break;
    case 73:
      jj_consume_token(73);
      break;
    case 74:
      TableConstructor();
      break;
    case FUNCTION:
      Function();
      break;
    case NAME:
    case 69:
      PrimaryExp();
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Str() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      jj_consume_token(STRING);
      break;
    case CHARSTRING:
      jj_consume_token(CHARSTRING);
      break;
    case LONGSTRING0:
      jj_consume_token(LONGSTRING0);
      break;
    case LONGSTRING1:
      jj_consume_token(LONGSTRING1);
      break;
    case LONGSTRING2:
      jj_consume_token(LONGSTRING2);
      break;
    case LONGSTRING3:
      jj_consume_token(LONGSTRING3);
      break;
    case LONGSTRINGN:
      jj_consume_token(LONGSTRINGN);
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Exp() throws ParseException {
    SubExp();
  }

  final public void SubExp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case FALSE:
    case FUNCTION:
    case NIL:
    case TRUE:
    case NAME:
    case NUMBER:
    case STRING:
    case CHARSTRING:
    case 69:
    case 73:
    case 74:
      SimpleExp();
      break;
    case NOT:
    case 77:
    case 89:
      Unop();
      SubExp();
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_8:
    while (true) {
      if (jj_2_5(2)) {
        ;
      } else {
        break label_8;
      }
      Binop();
      SubExp();
    }
  }

  final public void Function() throws ParseException {
    jj_consume_token(FUNCTION);
    FuncBody();
  }

  final public void FuncBody() throws ParseException {
    jj_consume_token(69);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NAME:
    case 73:
      ParList();
      break;
    default:
      ;
    }
    jj_consume_token(70);
    Block();
    jj_consume_token(END);
  }

  final public void ParList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NAME:
      NameList();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 66:
        jj_consume_token(66);
        jj_consume_token(73);
        break;
      default:
        ;
      }
      break;
    case 73:
      jj_consume_token(73);
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void TableConstructor() throws ParseException {
    jj_consume_token(74);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LONGSTRING0:
    case LONGSTRING1:
    case LONGSTRING2:
    case LONGSTRING3:
    case LONGSTRINGN:
    case FALSE:
    case FUNCTION:
    case NIL:
    case NOT:
    case TRUE:
    case NAME:
    case NUMBER:
    case STRING:
    case CHARSTRING:
    case 69:
    case 71:
    case 73:
    case 74:
    case 77:
    case 89:
      FieldList();
      break;
    default:
      ;
    }
    jj_consume_token(75);
  }

  final public void FieldList() throws ParseException {
    Field();
    label_9:
    while (true) {
      if (jj_2_6(2)) {
        ;
      } else {
        break label_9;
      }
      FieldSep();
      Field();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 64:
    case 66:
      FieldSep();
      break;
    default:
      ;
    }
  }

  final public void Field() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 71:
      jj_consume_token(71);
      Exp();
      jj_consume_token(72);
      jj_consume_token(65);
      Exp();
      break;
    default:
      if (jj_2_7(2)) {
        jj_consume_token(NAME);
        jj_consume_token(65);
        Exp();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LONGSTRING0:
        case LONGSTRING1:
        case LONGSTRING2:
        case LONGSTRING3:
        case LONGSTRINGN:
        case FALSE:
        case FUNCTION:
        case NIL:
        case NOT:
        case TRUE:
        case NAME:
        case NUMBER:
        case STRING:
        case CHARSTRING:
        case 69:
        case 73:
        case 74:
        case 77:
        case 89:
          Exp();
          break;
        default:
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  final public void FieldSep() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 66:
      jj_consume_token(66);
      break;
    case 64:
      jj_consume_token(64);
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Binop() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 76:
      jj_consume_token(76);
      break;
    case 77:
      jj_consume_token(77);
      break;
    case 78:
      jj_consume_token(78);
      break;
    case 79:
      jj_consume_token(79);
      break;
    case 80:
      jj_consume_token(80);
      break;
    case 81:
      jj_consume_token(81);
      break;
    case 82:
      jj_consume_token(82);
      break;
    case 83:
      jj_consume_token(83);
      break;
    case 84:
      jj_consume_token(84);
      break;
    case 85:
      jj_consume_token(85);
      break;
    case 86:
      jj_consume_token(86);
      break;
    case 87:
      jj_consume_token(87);
      break;
    case 88:
      jj_consume_token(88);
      break;
    case AND:
      jj_consume_token(AND);
      break;
    case OR:
      jj_consume_token(OR);
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Unop() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 77:
      jj_consume_token(77);
      break;
    case NOT:
      jj_consume_token(NOT);
      break;
    case 89:
      jj_consume_token(89);
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_3R_25() {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_35() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(57)) {
    jj_scanpos = xsp;
    if (jj_scan_token(58)) {
    jj_scanpos = xsp;
    if (jj_scan_token(23)) {
    jj_scanpos = xsp;
    if (jj_scan_token(24)) {
    jj_scanpos = xsp;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(26)) {
    jj_scanpos = xsp;
    if (jj_scan_token(27)) return true;
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_33() {
    if (jj_3R_38()) return true;
    return false;
  }

  private boolean jj_3R_32() {
    if (jj_3R_37()) return true;
    return false;
  }

  private boolean jj_3R_31() {
    if (jj_3R_36()) return true;
    return false;
  }

  private boolean jj_3R_30() {
    if (jj_3R_35()) return true;
    return false;
  }

  private boolean jj_3R_23() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(35)) {
    jj_scanpos = xsp;
    if (jj_scan_token(51)) {
    jj_scanpos = xsp;
    if (jj_3R_30()) {
    jj_scanpos = xsp;
    if (jj_scan_token(73)) {
    jj_scanpos = xsp;
    if (jj_3R_31()) {
    jj_scanpos = xsp;
    if (jj_3R_32()) {
    jj_scanpos = xsp;
    if (jj_3R_33()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(66)) return true;
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(LOCAL)) return true;
    if (jj_scan_token(FUNCTION)) return true;
    return false;
  }

  private boolean jj_3R_45() {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_24() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(77)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) {
    jj_scanpos = xsp;
    if (jj_scan_token(89)) return true;
    }
    }
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(65)) return true;
    return false;
  }

  private boolean jj_3R_43() {
    if (jj_3R_45()) return true;
    return false;
  }

  private boolean jj_3R_41() {
    if (jj_3R_35()) return true;
    return false;
  }

  private boolean jj_3R_11() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(76)) {
    jj_scanpos = xsp;
    if (jj_scan_token(77)) {
    jj_scanpos = xsp;
    if (jj_scan_token(78)) {
    jj_scanpos = xsp;
    if (jj_scan_token(79)) {
    jj_scanpos = xsp;
    if (jj_scan_token(80)) {
    jj_scanpos = xsp;
    if (jj_scan_token(81)) {
    jj_scanpos = xsp;
    if (jj_scan_token(82)) {
    jj_scanpos = xsp;
    if (jj_scan_token(83)) {
    jj_scanpos = xsp;
    if (jj_scan_token(84)) {
    jj_scanpos = xsp;
    if (jj_scan_token(85)) {
    jj_scanpos = xsp;
    if (jj_scan_token(86)) {
    jj_scanpos = xsp;
    if (jj_scan_token(87)) {
    jj_scanpos = xsp;
    if (jj_scan_token(88)) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_scan_token(43)) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_40() {
    if (jj_3R_36()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(66)) {
    jj_scanpos = xsp;
    if (jj_scan_token(64)) return true;
    }
    return false;
  }

  private boolean jj_3R_39() {
    if (jj_scan_token(69)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_43()) jj_scanpos = xsp;
    if (jj_scan_token(70)) return true;
    return false;
  }

  private boolean jj_3R_34() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_39()) {
    jj_scanpos = xsp;
    if (jj_3R_40()) {
    jj_scanpos = xsp;
    if (jj_3R_41()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_6() {
    if (jj_3R_13()) return true;
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_20() {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_29() {
    if (jj_3R_34()) return true;
    return false;
  }

  private boolean jj_3_7() {
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(65)) return true;
    return false;
  }

  private boolean jj_3R_22() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_28()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) return true;
    }
    return false;
  }

  private boolean jj_3R_28() {
    if (jj_scan_token(68)) return true;
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  private boolean jj_3R_19() {
    if (jj_scan_token(71)) return true;
    return false;
  }

  private boolean jj_3R_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3_7()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_5() {
    if (jj_3R_11()) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_48() {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_46() {
    if (jj_3R_48()) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3R_27() {
    if (jj_scan_token(71)) return true;
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_21() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) return true;
    }
    return false;
  }

  private boolean jj_3R_26() {
    if (jj_scan_token(67)) return true;
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  private boolean jj_3R_36() {
    if (jj_scan_token(74)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_46()) jj_scanpos = xsp;
    if (jj_scan_token(75)) return true;
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_3R_22()) return true;
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_3R_21()) return true;
    return false;
  }

  private boolean jj_3R_10() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) return true;
    }
    return false;
  }

  private boolean jj_3R_38() {
    if (jj_3R_42()) return true;
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3R_47() {
    if (jj_scan_token(69)) return true;
    return false;
  }

  private boolean jj_3R_37() {
    if (jj_scan_token(FUNCTION)) return true;
    return false;
  }

  private boolean jj_3R_44() {
    if (jj_3R_47()) return true;
    return false;
  }

  private boolean jj_3R_42() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(50)) {
    jj_scanpos = xsp;
    if (jj_3R_44()) return true;
    }
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_3R_23()) return true;
    return false;
  }

  private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) return true;
    }
    return false;
  }

  /** Generated Token Manager. */
  public LuaParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  /** Whether we are looking ahead. */
  private boolean jj_lookingAhead = false;
  private boolean jj_semLA;

  /** Constructor with InputStream. */
  public LuaParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public LuaParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e.getMessage()); }
    token_source = new LuaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e.getMessage()); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Constructor. */
  public LuaParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LuaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Constructor with generated Token Manager. */
  public LuaParser(LuaParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
  }

  /** Reinitialise. */
  public void ReInit(LuaParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      return token;
    }
    token = oldToken;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = jj_lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    Token errortok = token.next;
    int line = errortok.beginLine, column = errortok.beginColumn;
    String mess = (errortok.kind == 0) ? tokenImage[0] : errortok.image;
    return new ParseException("Parse error at line " + line + ", column " + column + ".  Encountered: " + mess);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
