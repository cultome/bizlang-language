// Generated from Bizlang.g4 by ANTLR 4.1
package com.fedex.lac.bizlang.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BizlangParser}.
 */
public interface BizlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BizlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull BizlangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull BizlangParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#fnct}.
	 * @param ctx the parse tree
	 */
	void enterFnct(@NotNull BizlangParser.FnctContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#fnct}.
	 * @param ctx the parse tree
	 */
	void exitFnct(@NotNull BizlangParser.FnctContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#param_lst}.
	 * @param ctx the parse tree
	 */
	void enterParam_lst(@NotNull BizlangParser.Param_lstContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#param_lst}.
	 * @param ctx the parse tree
	 */
	void exitParam_lst(@NotNull BizlangParser.Param_lstContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#math_expr}.
	 * @param ctx the parse tree
	 */
	void enterMath_expr(@NotNull BizlangParser.Math_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#math_expr}.
	 * @param ctx the parse tree
	 */
	void exitMath_expr(@NotNull BizlangParser.Math_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(@NotNull BizlangParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(@NotNull BizlangParser.AssignationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#fnct_call}.
	 * @param ctx the parse tree
	 */
	void enterFnct_call(@NotNull BizlangParser.Fnct_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#fnct_call}.
	 * @param ctx the parse tree
	 */
	void exitFnct_call(@NotNull BizlangParser.Fnct_callContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull BizlangParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull BizlangParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(@NotNull BizlangParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(@NotNull BizlangParser.ScriptContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(@NotNull BizlangParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(@NotNull BizlangParser.ExpressionsContext ctx);
}