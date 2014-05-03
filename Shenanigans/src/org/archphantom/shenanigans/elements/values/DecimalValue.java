package org.archphantom.shenanigans.elements.values;
import java.math.BigDecimal;

import org.archphantom.shenanigans.elements.Program;
import org.archphantom.shenanigans.elements.variables.VarTable;

public class DecimalValue extends Value {
	private static final long serialVersionUID = -5727395708519872329L;
	private BigDecimal val;
	
	public DecimalValue (double val) {
		this.val = new BigDecimal(val);
	}
	
	public DecimalValue (String val) {
		this.val = new BigDecimal(val);
	}
	
	public DecimalValue (BigDecimal val) {
		this.val = val;
	}
	
	public BigDecimal getValue (VarTable vars, Program program) {
		return val;
	}
	
}
