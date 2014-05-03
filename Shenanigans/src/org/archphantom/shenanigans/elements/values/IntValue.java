package org.archphantom.shenanigans.elements.values;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class IntValue extends DecimalValue {
	private static final long serialVersionUID = 755770306873491835L;

	public IntValue (int val) {
		super(new BigDecimal(val));
	}
	
	public IntValue (String val) {
		super(new BigDecimal(val));
	}
	
	public IntValue(BigInteger val) {
		super(new BigDecimal(val));
	}
	
	public BigInteger intValue (VarTable vars, Program program) {
		return super.getValue(vars, program).toBigInteger();
	}
	
}
