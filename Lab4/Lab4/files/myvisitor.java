import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class myvisitor extends DepthFirstAdapter 
{
	private static Hashtable symtable;	
	private static Hashtable funcParam;
	private static Hashtable funcVariables;

	private String funcName = "";

	private boolean inAFuncDef = false;
	private boolean errorInFunc = false;
	private boolean errorInEqualValue = false;
	private boolean foundEqualValue = false;

	public ANumberValue numVal;
	public AStringValue strVal;

	public static int errorCounter = 0;
	
	myvisitor(Hashtable symtable) 
	{
		this.symtable = symtable;
		funcParam = new Hashtable();
		funcVariables = new Hashtable();
	}

	public void inADefArgFunction(ADefArgFunction node) {
		String name = node.getId().toString();
		if (!symtable.containsKey(name)) {
			funcName = name;
			inAFuncDef = true;
		}
	}

	public void outADefArgFunction(ADefArgFunction node) {
		String name = node.getId().toString();
		int line = ((TId) node.getId()).getLine();
		if (putInSymtable(name, line, "Function"))
		{
			if (!errorInFunc)
				symtable.put(name, node);
		}
		funcName = "";
		inAFuncDef = false;
		errorInFunc = false;
		errorInEqualValue = false;
		foundEqualValue = false;
	}

	public void inAArgumentArgument(AArgumentArgument node)
	{
		String name = node.getId().toString();
		Hashtable temp = putFuncInParam();
		temp.put(name, node);
		funcParam.put(funcName, temp);
	}

	private Hashtable putFuncInParam()
	{
		Hashtable temp = new Hashtable();
		if (funcParam.containsKey(funcName))
			temp = ((Hashtable) funcParam.get(funcName));
		return temp;
	}

	private Hashtable putFuncInVar() {
		Hashtable temp = new Hashtable();
		if (funcVariables.containsKey(funcName)) temp = ((Hashtable) funcVariables.get(funcName));
		return temp;
	}
	private boolean putInSymtable(String name, int line, String op) {
		if (symtable.containsKey(name))
		{
			errorCounter++;
			System.out.println("Line " + (line+1)/2 + ": "+op+" " + name +"is already defined.");
			return false;
		}
		return true;
	}

	public void outAFunctionCallExpression(AFunctionCallExpression node) {
		String func = node.getFunctionCall().toString();
		String[] func_split = func.split("\\s");

		String str = funcVariables.get(func_split[0]).toString();

		if (str.equals("integer")) setIn(node, numVal);
		if (str.equals("string")) setIn(node, strVal);

	}

	public void inAFunctionCallFunctionCall(AFunctionCallFunctionCall node) {
		String name = node.getId().toString();
		int line = ((TId) node.getId()).getLine();

		boolean exists = false;

		if (inAFuncDef) {
			if (funcParam.containsKey(funcName)) {
				Hashtable symbols = (Hashtable)funcParam.get(funcName);
				if (symbols.containsKey(name)) {
					exists = true;
				}
			}
			if (funcVariables.containsKey(funcName)) {
				Hashtable symbols = (Hashtable)funcVariables.get(funcName);
				if (symbols.containsKey(name)) exists = true;
			}
		}

		if (symtable.containsKey(name)) {
			try {
				ADefArgFunction adaf = (ADefArgFunction) symtable.get(name);
				exists = true;
			} catch(ClassCastException e) {

			}
		}

		if (!exists) {
			errorCounter++; 
			System.out.println("Line " + (line+1)/2 + ": method " + name + "is not defined!");
			return;
		}

 

	}

	public void inANumberValue(ANumberValue node) {
		numVal = node;
	}

	public void inAStringValue(AStringValue node) {
		strVal = node;
	}

	
	public void inAIdentifierExpression(AIdentifierExpression exp)
	{
		String name = exp.getId().toString();
		int line = ((TId) exp.getId()).getLine();
		
		boolean exists = false;
		if (inAFuncDef)
		{
			if (funcParam.containsKey(funcName))
			{
				Hashtable symbols = (Hashtable)funcParam.get(funcName);
				if (symbols.containsKey(name))
					exists = true;
			}
			if (funcVariables.containsKey(funcName))
			{
				Hashtable symbols = (Hashtable)funcVariables.get(funcName);
				if (symbols.containsKey(name))
					exists = true;
			}
		}
		if (exists)
			return;
		if (symtable.containsKey(name))
		{
			try
			{
		
				AEqualStatement es = (AEqualStatement)symtable.get(name);
				return;
			}
			catch (ClassCastException e)
			{ }
		}
		errorCounter++;
		if (inAFuncDef)
		{
			errorInFunc = true;
			System.out.println("Line " + (line+1)/2 + ": variable " + name +"is NOT defined in function "+funcName);
		}
		else
		{
			System.out.println("Line " + (line+1)/2 + ": variable " + name +"is NOT defined.");
		}
	
	}

	public void outAEqualStatement(AEqualStatement node) {
		String varName = node.getId().toString();
		int line = ((TId) node.getId()).getLine();
		if (!symtable.containsKey(varName)) {

			if (inAFuncDef) {
				Hashtable temp = putFuncInVar();
				temp.put(varName, node);
				funcVariables.put(funcName, temp);
			} else {
				symtable.put(varName, node);
			}

		}
	}
	public void outAMeqStatement(AMeqStatement node) {
		String varName = node.getId().toString();
		int line = ((TId) node.getId()).getLine();

		if (!symtable.containsKey(varName)) {
			if (inAFuncDef) {
				Hashtable temp = putFuncInVar();
				temp.put(varName, node);
				funcVariables.put(funcName, temp);
			} else {
				symtable.put(varName, node);
			}
		}
	}
	public void outADeqStatement(ADeqStatement node) {
		String varName = node.getId().toString();
		int line = ((TId) node.getId()).getLine();
		if (!symtable.containsKey(varName)) {
			if (inAFuncDef) {
				Hashtable temp = putFuncInVar();
				temp.put(varName, node);
				funcVariables.put(funcName, temp);
			} else {
				symtable.put(varName, node);
			}
		}
	}
	
	public void inAIdExprExpression(AIdExprExpression node) {
		
		String varName = node.getId().toString();
		int line = ((TId) node.getId()).getLine();
		if (!symtable.containsKey(varName)) {
			System.out.println("Line " + line + ": " +"Variable " + varName + " is not defined!");
			errorCounter++;
		}
	}
	
	public int getErrors() {
		return errorCounter;
	}

	public static Hashtable getSymtable() {
		return symtable;
	}
	public static Hashtable getFuncVariables() {
		return funcVariables;
	}
	public static Hashtable getFuncParam() {
		return funcParam;
	}


}
