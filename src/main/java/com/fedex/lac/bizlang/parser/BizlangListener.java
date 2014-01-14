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
	 * Enter a parse tree produced by {@link BizlangParser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void enterMathExpr(@NotNull BizlangParser.MathExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void exitMathExpr(@NotNull BizlangParser.MathExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#paramLst}.
	 * @param ctx the parse tree
	 */
	void enterParamLst(@NotNull BizlangParser.ParamLstContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#paramLst}.
	 * @param ctx the parse tree
	 */
	void exitParamLst(@NotNull BizlangParser.ParamLstContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull BizlangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull BizlangParser.BlockContext ctx);

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
	 * Enter a parse tree produced by {@link BizlangParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicOp(@NotNull BizlangParser.LogicOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicOp(@NotNull BizlangParser.LogicOpContext ctx);

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
	 * Enter a parse tree produced by {@link BizlangParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(@NotNull BizlangParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(@NotNull BizlangParser.ConditionalContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(@NotNull BizlangParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(@NotNull BizlangParser.CommentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#elseBlk}.
	 * @param ctx the parse tree
	 */
	void enterElseBlk(@NotNull BizlangParser.ElseBlkContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#elseBlk}.
	 * @param ctx the parse tree
	 */
	void exitElseBlk(@NotNull BizlangParser.ElseBlkContext ctx);

	/**
	 * Enter a parse tree produced by {@link BizlangParser#fnctCall}.
	 * @param ctx the parse tree
	 */
	void enterFnctCall(@NotNull BizlangParser.FnctCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BizlangParser#fnctCall}.
	 * @param ctx the parse tree
	 */
	void exitFnctCall(@NotNull BizlangParser.FnctCallContext ctx);
}