

package com.adolfo.analizadores;
import java_cup.runtime.Symbol; 

%% 
%class Lexico
%public 
%line 
%char 
%cup 
%unicode
%ignorecase

%init{ 
    yyline = 1; 
    yychar = 1; 
%init} 
 

BLANCOS=[ \r\t]+
D=[0-9]+
ID = [A-Za-z]+[0-9A-Za-z]*

%%
<YYINITIAL> { 
 

";" {return new Symbol(sym.PTCOMA,yyline,yycolumn, yytext());} 
"(" {return new Symbol(sym.PARIZQ,yyline,yycolumn, yytext());} 
")" {return new Symbol(sym.PARDER,yyline,yycolumn, yytext());} 

"+" {return new Symbol(sym.MAS,yyline,yycolumn, yytext());} 
"-" {return new Symbol(sym.MENOS,yyline,yycolumn, yytext());} 
"*" {return new Symbol(sym.POR,yyline,yycolumn, yytext());} 
"/" {return new Symbol(sym.DIVIDIDO,yyline,yycolumn, yytext());} 
"=" {return new Symbol(sym.IGUAL,yyline,yycolumn, yytext());} 
\n {yychar=1;}

{BLANCOS} {} 
{D} {return new Symbol(sym.ENTERO,yyline,yycolumn, yytext());} 
{ID}  {return new Symbol(sym.ID,yyline,yycolumn, yytext());} 

. {
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "
    + yyline + ", en la columna: "+yycolumn);
}
}