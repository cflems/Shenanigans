package org.archphantom.shenanigans.parser;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tokenizer {
	private BufferedReader readme;
	private Object lastRead;
	private Token lastReadType;
	
	public Tokenizer (String input) throws IOException {
		this(new ByteArrayInputStream(input.getBytes()));
	}
	
	public Tokenizer (InputStream input) throws IOException {
		this.readme = new BufferedReader(new InputStreamReader(input));
		read();
	}
	
	private void read () throws IOException {
		this.lastRead = null;
		boolean ident = false;
		boolean number = false;
		while (true) {
			char c = (char) readme.read();
			if (ident && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '.' || c == '_')) {
				readme.mark(1);
				this.lastRead = ((String) lastRead) + c;
			} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_') {
				ident = true;
				readme.mark(1);
				this.lastRead = c+"";
			} else if (c >= '0' && c <= '9' && number) {
				readme.mark(1);
				this.lastRead = (Integer) (((Integer) lastRead)*10+(c-'0'));
			} else if (c >= '0' && c <= '9') {
				number = true;
				readme.mark(1);
				this.lastRead = Integer.valueOf(c-'0');
			} else {
				if (ident) {
					readme.reset();
					this.lastReadType = Token.Ident;
					return;
				} else if (number) {
					readme.reset();
					this.lastReadType = Token.Number;
					return;
				}
				switch (c) {
				case '.':
					this.lastReadType = Token.Decimal;
					return;
				case '$':
					this.lastReadType = Token.EOS;
					return;
				case '+':
					this.lastReadType = Token.Plus;
					return;
				case '-':
					this.lastReadType = Token.Minus;
					return;
				case '*':
					this.lastReadType = Token.Times;
					return;
				case '/':
					this.lastReadType = Token.Divide;
					return;
				case '%':
					this.lastReadType = Token.Modulo;
					return;
				case '(':
					this.lastReadType = Token.LParen;
					return;
				case ')':
					this.lastReadType = Token.RParen;
					return;
				case '[':
					this.lastReadType = Token.LBrace;
					return;
				case ']':
					this.lastReadType = Token.RBrace;
					return;
				case '{':
					this.lastReadType = Token.LCBracket;
					return;
				case '}':
					this.lastReadType = Token.RCBracket;
					return;
				case ';':
					this.lastReadType = Token.Semicolon;
					return;
				case '\'':
					this.lastReadType = Token.Quote;
					return;
				case '\"':
					this.lastReadType = Token.DQuote;
					return;
				case '&':
					this.lastReadType = Token.And;
					return;
				case '|':
					this.lastReadType = Token.Or;
					return;
				case '!':
					this.lastReadType = Token.Not;
					return;
				case '^':
					this.lastReadType = Token.XOr;
					return;
				case '<':
					this.lastReadType = Token.Less;
					return;
				case '>':
					this.lastReadType = Token.Greater;
					return;
				case '=':
					this.lastReadType = Token.Equal;
					return;
				case '@':
					this.lastReadType = Token.Count;
					return;
				case ':':
					this.lastReadType = Token.NSCall;
					return;
				case '#':
					readme.readLine();
					return;
				}
			}
		}
	}
	
	public Token peak () {
		return lastReadType;
	}
	
	public Object peakVal () {
		return lastRead;
	}
	
	public Token pop () throws IOException {
		Token lrt = lastReadType;
		read();
		return lrt;
	}
	
}
