grammar Interface;

/*------------------------------------------------------------------
 * HEADER
 *------------------------------------------------------------------*/
@lexer::header { 
	package org.se.lab.parser; 
	import org.se.lab.metamodel.*;  
}

@parser::header { 
	package org.se.lab.parser; 
	import org.se.lab.metamodel.*;  
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

// MPackage
package_def returns [MPackage pkg]
	: PACKAGE qualifiedName SEMI interface_list
	{
		$pkg = new MPackage($qualifiedName.text);
		pkg.setInterfaces($interface_list.list);
	}
	;

// MInterface
interface_list returns [List<MInterface> list]
	@init
	{
		$list = new ArrayList<MInterface>();
	}
	: (ife = interface_def {$list.add($ife.ife);})*
	;
 
interface_def returns [MInterface ife]
	: type_modifier? INTERFACE IDENTIFIER  LCURLY opl=operation_list RCURLY
 	{
		$ife = new MInterface($IDENTIFIER.text);
		ife.setPublic("public".equals($type_modifier.text));
		ife.setOperations(opl);
	}
	;

// MOperation
operation_list returns [List<MOperation> list]
	@init
	{
		$list = new ArrayList<MOperation>();
	}
	: (op = operation_def {$list.add($op.op);})*
	;

operation_def returns [MOperation op]
	: type_def IDENTIFIER LPAREN parameter_list RPAREN SEMI
	{
		$op = new MOperation($IDENTIFIER.text, $type_def.type);
		op.setParameters($parameter_list.list);
	}
	;

// MParameter
parameter_list returns [List<MParameter> list]
	@init
	{
	$list = new ArrayList<MParameter>();
	}
	: p1=parameter_def? 
	{
		if ($p1.param != null) $list.add($p1.param);
	}
	(COMMA pn=parameter_def {$list.add($pn.param);} )*
	;

parameter_def returns [MParameter param]
	: type_def IDENTIFIER
	{
		$param = new MParameter($IDENTIFIER.text, $type_def.type);
	}
	;

// MTyp	
type_def returns [MType type]
  :   type_specifier
    {
      $type = new MType($type_specifier.text);
    }   
  ;



type_specifier
	: 'void'
	| 'char'
	| 'short'
	| 'int'
	| 'long'
	| 'float'
	| 'double'
	| 'boolean'
	// ...
	;
	
type_modifier
	: 'public'
	| 'private'
	| 'protected'
	;	
	
qualifiedName
	: IDENTIFIER (DOT IDENTIFIER)*
	;
	
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

COMMA		: ',' ;
SEMI		: ';' ;
LPAREN		: '(' ;
RPAREN		: ')' ;
LCURLY		: '{';
RCURLY		: '}';
DOT			: '.';
UNDER		: '_';
PACKAGE		: 'package';
INTERFACE	: 'interface';



fragment SMALLLETTER
	: ('a'..'z')
	; 

fragment BIGLETTER
	: ('A'..'Z')
	; 

fragment NUMBER
	: ('0'..'9')
	;
	
fragment LETTER
	: BIGLETTER
	| SMALLLETTER
	| UNDER
	;

IDENTIFIER
	: LETTER (LETTER|NUMBER)*
	;	

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {skip();}
    ;
