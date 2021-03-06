/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextFactoryImpl.java,v 1.19 2010/04/06 14:09:54 sefftinge Exp $
 */
package org.eclipse.xtext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextFactoryImpl extends EFactoryImpl implements XtextFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XtextFactory init() {
		try {
			XtextFactory theXtextFactory = (XtextFactory)EPackage.Registry.INSTANCE.getEFactory(XtextPackage.eNS_URI);
			if (theXtextFactory != null) {
				return theXtextFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XtextFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XtextPackage.GRAMMAR: return createGrammar();
			case XtextPackage.ABSTRACT_RULE: return createAbstractRule();
			case XtextPackage.ABSTRACT_METAMODEL_DECLARATION: return createAbstractMetamodelDeclaration();
			case XtextPackage.GENERATED_METAMODEL: return createGeneratedMetamodel();
			case XtextPackage.REFERENCED_METAMODEL: return createReferencedMetamodel();
			case XtextPackage.PARSER_RULE: return createParserRule();
			case XtextPackage.TYPE_REF: return createTypeRef();
			case XtextPackage.ABSTRACT_ELEMENT: return createAbstractElement();
			case XtextPackage.ACTION: return createAction();
			case XtextPackage.KEYWORD: return createKeyword();
			case XtextPackage.RULE_CALL: return createRuleCall();
			case XtextPackage.ASSIGNMENT: return createAssignment();
			case XtextPackage.CROSS_REFERENCE: return createCrossReference();
			case XtextPackage.TERMINAL_RULE: return createTerminalRule();
			case XtextPackage.ABSTRACT_NEGATED_TOKEN: return createAbstractNegatedToken();
			case XtextPackage.NEGATED_TOKEN: return createNegatedToken();
			case XtextPackage.UNTIL_TOKEN: return createUntilToken();
			case XtextPackage.WILDCARD: return createWildcard();
			case XtextPackage.ENUM_RULE: return createEnumRule();
			case XtextPackage.ENUM_LITERAL_DECLARATION: return createEnumLiteralDeclaration();
			case XtextPackage.ALTERNATIVES: return createAlternatives();
			case XtextPackage.UNORDERED_GROUP: return createUnorderedGroup();
			case XtextPackage.GROUP: return createGroup();
			case XtextPackage.CHARACTER_RANGE: return createCharacterRange();
			case XtextPackage.COMPOUND_ELEMENT: return createCompoundElement();
			case XtextPackage.EOF: return createEOF();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Grammar createGrammar() {
		GrammarImpl grammar = new GrammarImpl();
		return grammar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractRule createAbstractRule() {
		AbstractRuleImpl abstractRule = new AbstractRuleImpl();
		return abstractRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractMetamodelDeclaration createAbstractMetamodelDeclaration() {
		AbstractMetamodelDeclarationImpl abstractMetamodelDeclaration = new AbstractMetamodelDeclarationImpl();
		return abstractMetamodelDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedMetamodel createGeneratedMetamodel() {
		GeneratedMetamodelImpl generatedMetamodel = new GeneratedMetamodelImpl();
		return generatedMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencedMetamodel createReferencedMetamodel() {
		ReferencedMetamodelImpl referencedMetamodel = new ReferencedMetamodelImpl();
		return referencedMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParserRule createParserRule() {
		ParserRuleImpl parserRule = new ParserRuleImpl();
		return parserRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRef createTypeRef() {
		TypeRefImpl typeRef = new TypeRefImpl();
		return typeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractElement createAbstractElement() {
		AbstractElementImpl abstractElement = new AbstractElementImpl();
		return abstractElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Keyword createKeyword() {
		KeywordImpl keyword = new KeywordImpl();
		return keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleCall createRuleCall() {
		RuleCallImpl ruleCall = new RuleCallImpl();
		return ruleCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrossReference createCrossReference() {
		CrossReferenceImpl crossReference = new CrossReferenceImpl();
		return crossReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminalRule createTerminalRule() {
		TerminalRuleImpl terminalRule = new TerminalRuleImpl();
		return terminalRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNegatedToken createAbstractNegatedToken() {
		AbstractNegatedTokenImpl abstractNegatedToken = new AbstractNegatedTokenImpl();
		return abstractNegatedToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegatedToken createNegatedToken() {
		NegatedTokenImpl negatedToken = new NegatedTokenImpl();
		return negatedToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UntilToken createUntilToken() {
		UntilTokenImpl untilToken = new UntilTokenImpl();
		return untilToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wildcard createWildcard() {
		WildcardImpl wildcard = new WildcardImpl();
		return wildcard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 2.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOF createEOF() {
		EOFImpl eof = new EOFImpl();
		return eof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumRule createEnumRule() {
		EnumRuleImpl enumRule = new EnumRuleImpl();
		return enumRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralDeclaration createEnumLiteralDeclaration() {
		EnumLiteralDeclarationImpl enumLiteralDeclaration = new EnumLiteralDeclarationImpl();
		return enumLiteralDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alternatives createAlternatives() {
		AlternativesImpl alternatives = new AlternativesImpl();
		return alternatives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnorderedGroup createUnorderedGroup() {
		UnorderedGroupImpl unorderedGroup = new UnorderedGroupImpl();
		return unorderedGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterRange createCharacterRange() {
		CharacterRangeImpl characterRange = new CharacterRangeImpl();
		return characterRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundElement createCompoundElement() {
		CompoundElementImpl compoundElement = new CompoundElementImpl();
		return compoundElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextPackage getXtextPackage() {
		return (XtextPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated the package should not be accessed statically.
	 * @generated
	 */
	@Deprecated
	public static XtextPackage getPackage() {
		return XtextPackage.eINSTANCE;
	}

} //XtextFactoryImpl
