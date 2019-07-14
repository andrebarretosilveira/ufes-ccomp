package br.ufes.inf.mdd.trab2.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import br.ufes.inf.mdd.trab2.services.StoryGeneratorGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStoryGeneratorParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'World'", "'{'", "'}'", "'abstract'", "'event'", "'is'", "'requires'", "'('", "')'", "'not'", "'fact'", "'quantity'", "'true'", "'false'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'and'", "'or'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalStoryGeneratorParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStoryGeneratorParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStoryGeneratorParser.tokenNames; }
    public String getGrammarFileName() { return "InternalStoryGenerator.g"; }



     	private StoryGeneratorGrammarAccess grammarAccess;

        public InternalStoryGeneratorParser(TokenStream input, StoryGeneratorGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Story";
       	}

       	@Override
       	protected StoryGeneratorGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleStory"
    // InternalStoryGenerator.g:65:1: entryRuleStory returns [EObject current=null] : iv_ruleStory= ruleStory EOF ;
    public final EObject entryRuleStory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStory = null;


        try {
            // InternalStoryGenerator.g:65:46: (iv_ruleStory= ruleStory EOF )
            // InternalStoryGenerator.g:66:2: iv_ruleStory= ruleStory EOF
            {
             newCompositeNode(grammarAccess.getStoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStory=ruleStory();

            state._fsp--;

             current =iv_ruleStory; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStory"


    // $ANTLR start "ruleStory"
    // InternalStoryGenerator.g:72:1: ruleStory returns [EObject current=null] : ( ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )* ) ;
    public final EObject ruleStory() throws RecognitionException {
        EObject current = null;

        EObject lv_world_0_0 = null;

        EObject lv_events_1_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:78:2: ( ( ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )* ) )
            // InternalStoryGenerator.g:79:2: ( ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )* )
            {
            // InternalStoryGenerator.g:79:2: ( ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )* )
            // InternalStoryGenerator.g:80:3: ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )*
            {
            // InternalStoryGenerator.g:80:3: ( (lv_world_0_0= ruleWorld ) )
            // InternalStoryGenerator.g:81:4: (lv_world_0_0= ruleWorld )
            {
            // InternalStoryGenerator.g:81:4: (lv_world_0_0= ruleWorld )
            // InternalStoryGenerator.g:82:5: lv_world_0_0= ruleWorld
            {

            					newCompositeNode(grammarAccess.getStoryAccess().getWorldWorldParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_world_0_0=ruleWorld();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStoryRule());
            					}
            					set(
            						current,
            						"world",
            						lv_world_0_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.World");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGenerator.g:99:3: ( (lv_events_1_0= ruleEvent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=14 && LA1_0<=15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalStoryGenerator.g:100:4: (lv_events_1_0= ruleEvent )
            	    {
            	    // InternalStoryGenerator.g:100:4: (lv_events_1_0= ruleEvent )
            	    // InternalStoryGenerator.g:101:5: lv_events_1_0= ruleEvent
            	    {

            	    					newCompositeNode(grammarAccess.getStoryAccess().getEventsEventParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_events_1_0=ruleEvent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStoryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"events",
            	    						lv_events_1_0,
            	    						"br.ufes.inf.mdd.trab2.StoryGenerator.Event");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStory"


    // $ANTLR start "entryRuleWorld"
    // InternalStoryGenerator.g:122:1: entryRuleWorld returns [EObject current=null] : iv_ruleWorld= ruleWorld EOF ;
    public final EObject entryRuleWorld() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorld = null;


        try {
            // InternalStoryGenerator.g:122:46: (iv_ruleWorld= ruleWorld EOF )
            // InternalStoryGenerator.g:123:2: iv_ruleWorld= ruleWorld EOF
            {
             newCompositeNode(grammarAccess.getWorldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorld=ruleWorld();

            state._fsp--;

             current =iv_ruleWorld; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorld"


    // $ANTLR start "ruleWorld"
    // InternalStoryGenerator.g:129:1: ruleWorld returns [EObject current=null] : ( () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) ;
    public final EObject ruleWorld() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:135:2: ( ( () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) )
            // InternalStoryGenerator.g:136:2: ( () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            {
            // InternalStoryGenerator.g:136:2: ( () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            // InternalStoryGenerator.g:137:3: () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}'
            {
            // InternalStoryGenerator.g:137:3: ()
            // InternalStoryGenerator.g:138:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getWorldAccess().getWorldAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getWorldAccess().getWorldKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getWorldAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalStoryGenerator.g:152:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=21 && LA2_0<=22)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalStoryGenerator.g:153:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalStoryGenerator.g:153:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalStoryGenerator.g:154:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getWorldAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getWorldRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"br.ufes.inf.mdd.trab2.StoryGenerator.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getWorldAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorld"


    // $ANTLR start "entryRuleAttribute"
    // InternalStoryGenerator.g:179:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalStoryGenerator.g:179:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalStoryGenerator.g:180:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalStoryGenerator.g:186:1: ruleAttribute returns [EObject current=null] : ( ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Enumerator lv_attrType_0_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:192:2: ( ( ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalStoryGenerator.g:193:2: ( ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalStoryGenerator.g:193:2: ( ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalStoryGenerator.g:194:3: ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalStoryGenerator.g:194:3: ( (lv_attrType_0_0= ruleAttrType ) )
            // InternalStoryGenerator.g:195:4: (lv_attrType_0_0= ruleAttrType )
            {
            // InternalStoryGenerator.g:195:4: (lv_attrType_0_0= ruleAttrType )
            // InternalStoryGenerator.g:196:5: lv_attrType_0_0= ruleAttrType
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getAttrTypeAttrTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_6);
            lv_attrType_0_0=ruleAttrType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"attrType",
            						lv_attrType_0_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.AttrType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGenerator.g:213:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStoryGenerator.g:214:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStoryGenerator.g:214:4: (lv_name_1_0= RULE_ID )
            // InternalStoryGenerator.g:215:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleEvent"
    // InternalStoryGenerator.g:235:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalStoryGenerator.g:235:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalStoryGenerator.g:236:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalStoryGenerator.g:242:1: ruleEvent returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}' ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_conditions_6_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:248:2: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}' ) )
            // InternalStoryGenerator.g:249:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}' )
            {
            // InternalStoryGenerator.g:249:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}' )
            // InternalStoryGenerator.g:250:3: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}'
            {
            // InternalStoryGenerator.g:250:3: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalStoryGenerator.g:251:4: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalStoryGenerator.g:251:4: (lv_abstract_0_0= 'abstract' )
                    // InternalStoryGenerator.g:252:5: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,14,FOLLOW_7); 

                    					newLeafNode(lv_abstract_0_0, grammarAccess.getEventAccess().getAbstractAbstractKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEventRule());
                    					}
                    					setWithLastConsumed(current, "abstract", true, "abstract");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getEventAccess().getEventKeyword_1());
            		
            // InternalStoryGenerator.g:268:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalStoryGenerator.g:269:4: (lv_name_2_0= RULE_ID )
            {
            // InternalStoryGenerator.g:269:4: (lv_name_2_0= RULE_ID )
            // InternalStoryGenerator.g:270:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_2_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalStoryGenerator.g:286:3: (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalStoryGenerator.g:287:4: otherlv_3= 'is' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getEventAccess().getIsKeyword_3_0());
                    			
                    // InternalStoryGenerator.g:291:4: ( (otherlv_4= RULE_ID ) )
                    // InternalStoryGenerator.g:292:5: (otherlv_4= RULE_ID )
                    {
                    // InternalStoryGenerator.g:292:5: (otherlv_4= RULE_ID )
                    // InternalStoryGenerator.g:293:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEventRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_4); 

                    						newLeafNode(otherlv_4, grammarAccess.getEventAccess().getSuperTypeEventCrossReference_3_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getEventAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalStoryGenerator.g:309:3: ( (lv_conditions_6_0= ruleCondition ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalStoryGenerator.g:310:4: (lv_conditions_6_0= ruleCondition )
            	    {
            	    // InternalStoryGenerator.g:310:4: (lv_conditions_6_0= ruleCondition )
            	    // InternalStoryGenerator.g:311:5: lv_conditions_6_0= ruleCondition
            	    {

            	    					newCompositeNode(grammarAccess.getEventAccess().getConditionsConditionParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_conditions_6_0=ruleCondition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEventRule());
            	    					}
            	    					add(
            	    						current,
            	    						"conditions",
            	    						lv_conditions_6_0,
            	    						"br.ufes.inf.mdd.trab2.StoryGenerator.Condition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getEventAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleCondition"
    // InternalStoryGenerator.g:336:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalStoryGenerator.g:336:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalStoryGenerator.g:337:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalStoryGenerator.g:343:1: ruleCondition returns [EObject current=null] : (otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) ) ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_boolExp_1_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:349:2: ( (otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) ) ) )
            // InternalStoryGenerator.g:350:2: (otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) ) )
            {
            // InternalStoryGenerator.g:350:2: (otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) ) )
            // InternalStoryGenerator.g:351:3: otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getRequiresKeyword_0());
            		
            // InternalStoryGenerator.g:355:3: ( (lv_boolExp_1_0= ruleBoolExp ) )
            // InternalStoryGenerator.g:356:4: (lv_boolExp_1_0= ruleBoolExp )
            {
            // InternalStoryGenerator.g:356:4: (lv_boolExp_1_0= ruleBoolExp )
            // InternalStoryGenerator.g:357:5: lv_boolExp_1_0= ruleBoolExp
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getBoolExpBoolExpParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_boolExp_1_0=ruleBoolExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"boolExp",
            						lv_boolExp_1_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.BoolExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleBoolExp"
    // InternalStoryGenerator.g:378:1: entryRuleBoolExp returns [EObject current=null] : iv_ruleBoolExp= ruleBoolExp EOF ;
    public final EObject entryRuleBoolExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolExp = null;


        try {
            // InternalStoryGenerator.g:378:48: (iv_ruleBoolExp= ruleBoolExp EOF )
            // InternalStoryGenerator.g:379:2: iv_ruleBoolExp= ruleBoolExp EOF
            {
             newCompositeNode(grammarAccess.getBoolExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolExp=ruleBoolExp();

            state._fsp--;

             current =iv_ruleBoolExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolExp"


    // $ANTLR start "ruleBoolExp"
    // InternalStoryGenerator.g:385:1: ruleBoolExp returns [EObject current=null] : ( ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleBoolExp ) ) ) | (otherlv_3= '(' ( (lv_parBoolExp_4_0= ruleBoolExp ) ) otherlv_5= ')' ( (lv_binaryBool_6_0= ruleBinaryBoolExp ) ) ) | ( (lv_binaryQnty_7_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_8_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_9_0= ruleUnaryBoolExp ) ) ) ;
    public final EObject ruleBoolExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_left_0_0 = null;

        Enumerator lv_boolOp_1_0 = null;

        EObject lv_right_2_0 = null;

        EObject lv_parBoolExp_4_0 = null;

        EObject lv_binaryBool_6_0 = null;

        EObject lv_binaryQnty_7_0 = null;

        EObject lv_negateBoolExp_8_0 = null;

        EObject lv_unaryBool_9_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:391:2: ( ( ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleBoolExp ) ) ) | (otherlv_3= '(' ( (lv_parBoolExp_4_0= ruleBoolExp ) ) otherlv_5= ')' ( (lv_binaryBool_6_0= ruleBinaryBoolExp ) ) ) | ( (lv_binaryQnty_7_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_8_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_9_0= ruleUnaryBoolExp ) ) ) )
            // InternalStoryGenerator.g:392:2: ( ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleBoolExp ) ) ) | (otherlv_3= '(' ( (lv_parBoolExp_4_0= ruleBoolExp ) ) otherlv_5= ')' ( (lv_binaryBool_6_0= ruleBinaryBoolExp ) ) ) | ( (lv_binaryQnty_7_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_8_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_9_0= ruleUnaryBoolExp ) ) )
            {
            // InternalStoryGenerator.g:392:2: ( ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleBoolExp ) ) ) | (otherlv_3= '(' ( (lv_parBoolExp_4_0= ruleBoolExp ) ) otherlv_5= ')' ( (lv_binaryBool_6_0= ruleBinaryBoolExp ) ) ) | ( (lv_binaryQnty_7_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_8_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_9_0= ruleUnaryBoolExp ) ) )
            int alt6=5;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalStoryGenerator.g:393:3: ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleBoolExp ) ) )
                    {
                    // InternalStoryGenerator.g:393:3: ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleBoolExp ) ) )
                    // InternalStoryGenerator.g:394:4: ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleBoolExp ) )
                    {
                    // InternalStoryGenerator.g:394:4: ( (lv_left_0_0= ruleUnaryBoolExp ) )
                    // InternalStoryGenerator.g:395:5: (lv_left_0_0= ruleUnaryBoolExp )
                    {
                    // InternalStoryGenerator.g:395:5: (lv_left_0_0= ruleUnaryBoolExp )
                    // InternalStoryGenerator.g:396:6: lv_left_0_0= ruleUnaryBoolExp
                    {

                    						newCompositeNode(grammarAccess.getBoolExpAccess().getLeftUnaryBoolExpParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_left_0_0=ruleUnaryBoolExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_0_0,
                    							"br.ufes.inf.mdd.trab2.StoryGenerator.UnaryBoolExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalStoryGenerator.g:413:4: ( (lv_boolOp_1_0= ruleBoolOp ) )
                    // InternalStoryGenerator.g:414:5: (lv_boolOp_1_0= ruleBoolOp )
                    {
                    // InternalStoryGenerator.g:414:5: (lv_boolOp_1_0= ruleBoolOp )
                    // InternalStoryGenerator.g:415:6: lv_boolOp_1_0= ruleBoolOp
                    {

                    						newCompositeNode(grammarAccess.getBoolExpAccess().getBoolOpBoolOpEnumRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_boolOp_1_0=ruleBoolOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    						}
                    						set(
                    							current,
                    							"boolOp",
                    							lv_boolOp_1_0,
                    							"br.ufes.inf.mdd.trab2.StoryGenerator.BoolOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalStoryGenerator.g:432:4: ( (lv_right_2_0= ruleBoolExp ) )
                    // InternalStoryGenerator.g:433:5: (lv_right_2_0= ruleBoolExp )
                    {
                    // InternalStoryGenerator.g:433:5: (lv_right_2_0= ruleBoolExp )
                    // InternalStoryGenerator.g:434:6: lv_right_2_0= ruleBoolExp
                    {

                    						newCompositeNode(grammarAccess.getBoolExpAccess().getRightBoolExpParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_2_0=ruleBoolExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_2_0,
                    							"br.ufes.inf.mdd.trab2.StoryGenerator.BoolExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGenerator.g:453:3: (otherlv_3= '(' ( (lv_parBoolExp_4_0= ruleBoolExp ) ) otherlv_5= ')' ( (lv_binaryBool_6_0= ruleBinaryBoolExp ) ) )
                    {
                    // InternalStoryGenerator.g:453:3: (otherlv_3= '(' ( (lv_parBoolExp_4_0= ruleBoolExp ) ) otherlv_5= ')' ( (lv_binaryBool_6_0= ruleBinaryBoolExp ) ) )
                    // InternalStoryGenerator.g:454:4: otherlv_3= '(' ( (lv_parBoolExp_4_0= ruleBoolExp ) ) otherlv_5= ')' ( (lv_binaryBool_6_0= ruleBinaryBoolExp ) )
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_3, grammarAccess.getBoolExpAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalStoryGenerator.g:458:4: ( (lv_parBoolExp_4_0= ruleBoolExp ) )
                    // InternalStoryGenerator.g:459:5: (lv_parBoolExp_4_0= ruleBoolExp )
                    {
                    // InternalStoryGenerator.g:459:5: (lv_parBoolExp_4_0= ruleBoolExp )
                    // InternalStoryGenerator.g:460:6: lv_parBoolExp_4_0= ruleBoolExp
                    {

                    						newCompositeNode(grammarAccess.getBoolExpAccess().getParBoolExpBoolExpParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_parBoolExp_4_0=ruleBoolExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    						}
                    						set(
                    							current,
                    							"parBoolExp",
                    							lv_parBoolExp_4_0,
                    							"br.ufes.inf.mdd.trab2.StoryGenerator.BoolExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_13); 

                    				newLeafNode(otherlv_5, grammarAccess.getBoolExpAccess().getRightParenthesisKeyword_1_2());
                    			
                    // InternalStoryGenerator.g:481:4: ( (lv_binaryBool_6_0= ruleBinaryBoolExp ) )
                    // InternalStoryGenerator.g:482:5: (lv_binaryBool_6_0= ruleBinaryBoolExp )
                    {
                    // InternalStoryGenerator.g:482:5: (lv_binaryBool_6_0= ruleBinaryBoolExp )
                    // InternalStoryGenerator.g:483:6: lv_binaryBool_6_0= ruleBinaryBoolExp
                    {

                    						newCompositeNode(grammarAccess.getBoolExpAccess().getBinaryBoolBinaryBoolExpParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_binaryBool_6_0=ruleBinaryBoolExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    						}
                    						set(
                    							current,
                    							"binaryBool",
                    							lv_binaryBool_6_0,
                    							"br.ufes.inf.mdd.trab2.StoryGenerator.BinaryBoolExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGenerator.g:502:3: ( (lv_binaryQnty_7_0= ruleBinaryQntyExp ) )
                    {
                    // InternalStoryGenerator.g:502:3: ( (lv_binaryQnty_7_0= ruleBinaryQntyExp ) )
                    // InternalStoryGenerator.g:503:4: (lv_binaryQnty_7_0= ruleBinaryQntyExp )
                    {
                    // InternalStoryGenerator.g:503:4: (lv_binaryQnty_7_0= ruleBinaryQntyExp )
                    // InternalStoryGenerator.g:504:5: lv_binaryQnty_7_0= ruleBinaryQntyExp
                    {

                    					newCompositeNode(grammarAccess.getBoolExpAccess().getBinaryQntyBinaryQntyExpParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_binaryQnty_7_0=ruleBinaryQntyExp();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    					}
                    					set(
                    						current,
                    						"binaryQnty",
                    						lv_binaryQnty_7_0,
                    						"br.ufes.inf.mdd.trab2.StoryGenerator.BinaryQntyExp");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGenerator.g:522:3: ( (lv_negateBoolExp_8_0= ruleNegateBoolExp ) )
                    {
                    // InternalStoryGenerator.g:522:3: ( (lv_negateBoolExp_8_0= ruleNegateBoolExp ) )
                    // InternalStoryGenerator.g:523:4: (lv_negateBoolExp_8_0= ruleNegateBoolExp )
                    {
                    // InternalStoryGenerator.g:523:4: (lv_negateBoolExp_8_0= ruleNegateBoolExp )
                    // InternalStoryGenerator.g:524:5: lv_negateBoolExp_8_0= ruleNegateBoolExp
                    {

                    					newCompositeNode(grammarAccess.getBoolExpAccess().getNegateBoolExpNegateBoolExpParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_negateBoolExp_8_0=ruleNegateBoolExp();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    					}
                    					set(
                    						current,
                    						"negateBoolExp",
                    						lv_negateBoolExp_8_0,
                    						"br.ufes.inf.mdd.trab2.StoryGenerator.NegateBoolExp");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGenerator.g:542:3: ( (lv_unaryBool_9_0= ruleUnaryBoolExp ) )
                    {
                    // InternalStoryGenerator.g:542:3: ( (lv_unaryBool_9_0= ruleUnaryBoolExp ) )
                    // InternalStoryGenerator.g:543:4: (lv_unaryBool_9_0= ruleUnaryBoolExp )
                    {
                    // InternalStoryGenerator.g:543:4: (lv_unaryBool_9_0= ruleUnaryBoolExp )
                    // InternalStoryGenerator.g:544:5: lv_unaryBool_9_0= ruleUnaryBoolExp
                    {

                    					newCompositeNode(grammarAccess.getBoolExpAccess().getUnaryBoolUnaryBoolExpParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_unaryBool_9_0=ruleUnaryBoolExp();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    					}
                    					set(
                    						current,
                    						"unaryBool",
                    						lv_unaryBool_9_0,
                    						"br.ufes.inf.mdd.trab2.StoryGenerator.UnaryBoolExp");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolExp"


    // $ANTLR start "entryRuleBinaryBoolExp"
    // InternalStoryGenerator.g:565:1: entryRuleBinaryBoolExp returns [EObject current=null] : iv_ruleBinaryBoolExp= ruleBinaryBoolExp EOF ;
    public final EObject entryRuleBinaryBoolExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryBoolExp = null;


        try {
            // InternalStoryGenerator.g:565:54: (iv_ruleBinaryBoolExp= ruleBinaryBoolExp EOF )
            // InternalStoryGenerator.g:566:2: iv_ruleBinaryBoolExp= ruleBinaryBoolExp EOF
            {
             newCompositeNode(grammarAccess.getBinaryBoolExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryBoolExp=ruleBinaryBoolExp();

            state._fsp--;

             current =iv_ruleBinaryBoolExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryBoolExp"


    // $ANTLR start "ruleBinaryBoolExp"
    // InternalStoryGenerator.g:572:1: ruleBinaryBoolExp returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) ) ) ;
    public final EObject ruleBinaryBoolExp() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        Enumerator lv_boolOp_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:578:2: ( ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) ) ) )
            // InternalStoryGenerator.g:579:2: ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) ) )
            {
            // InternalStoryGenerator.g:579:2: ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) ) )
            // InternalStoryGenerator.g:580:3: ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) )
            {
            // InternalStoryGenerator.g:580:3: ( (lv_left_0_0= ruleUnaryBoolExp ) )
            // InternalStoryGenerator.g:581:4: (lv_left_0_0= ruleUnaryBoolExp )
            {
            // InternalStoryGenerator.g:581:4: (lv_left_0_0= ruleUnaryBoolExp )
            // InternalStoryGenerator.g:582:5: lv_left_0_0= ruleUnaryBoolExp
            {

            					newCompositeNode(grammarAccess.getBinaryBoolExpAccess().getLeftUnaryBoolExpParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_left_0_0=ruleUnaryBoolExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryBoolExpRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_0_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.UnaryBoolExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGenerator.g:599:3: ( (lv_boolOp_1_0= ruleBoolOp ) )
            // InternalStoryGenerator.g:600:4: (lv_boolOp_1_0= ruleBoolOp )
            {
            // InternalStoryGenerator.g:600:4: (lv_boolOp_1_0= ruleBoolOp )
            // InternalStoryGenerator.g:601:5: lv_boolOp_1_0= ruleBoolOp
            {

            					newCompositeNode(grammarAccess.getBinaryBoolExpAccess().getBoolOpBoolOpEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_boolOp_1_0=ruleBoolOp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryBoolExpRule());
            					}
            					set(
            						current,
            						"boolOp",
            						lv_boolOp_1_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.BoolOp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGenerator.g:618:3: ( (lv_right_2_0= ruleUnaryBoolExp ) )
            // InternalStoryGenerator.g:619:4: (lv_right_2_0= ruleUnaryBoolExp )
            {
            // InternalStoryGenerator.g:619:4: (lv_right_2_0= ruleUnaryBoolExp )
            // InternalStoryGenerator.g:620:5: lv_right_2_0= ruleUnaryBoolExp
            {

            					newCompositeNode(grammarAccess.getBinaryBoolExpAccess().getRightUnaryBoolExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_right_2_0=ruleUnaryBoolExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryBoolExpRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_2_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.UnaryBoolExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryBoolExp"


    // $ANTLR start "entryRuleBinaryQntyExp"
    // InternalStoryGenerator.g:641:1: entryRuleBinaryQntyExp returns [EObject current=null] : iv_ruleBinaryQntyExp= ruleBinaryQntyExp EOF ;
    public final EObject entryRuleBinaryQntyExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryQntyExp = null;


        try {
            // InternalStoryGenerator.g:641:54: (iv_ruleBinaryQntyExp= ruleBinaryQntyExp EOF )
            // InternalStoryGenerator.g:642:2: iv_ruleBinaryQntyExp= ruleBinaryQntyExp EOF
            {
             newCompositeNode(grammarAccess.getBinaryQntyExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryQntyExp=ruleBinaryQntyExp();

            state._fsp--;

             current =iv_ruleBinaryQntyExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryQntyExp"


    // $ANTLR start "ruleBinaryQntyExp"
    // InternalStoryGenerator.g:648:1: ruleBinaryQntyExp returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) ) ) ;
    public final EObject ruleBinaryQntyExp() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        Enumerator lv_numOp_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:654:2: ( ( ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) ) ) )
            // InternalStoryGenerator.g:655:2: ( ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) ) )
            {
            // InternalStoryGenerator.g:655:2: ( ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) ) )
            // InternalStoryGenerator.g:656:3: ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) )
            {
            // InternalStoryGenerator.g:656:3: ( (lv_left_0_0= ruleUnaryQuantityExp ) )
            // InternalStoryGenerator.g:657:4: (lv_left_0_0= ruleUnaryQuantityExp )
            {
            // InternalStoryGenerator.g:657:4: (lv_left_0_0= ruleUnaryQuantityExp )
            // InternalStoryGenerator.g:658:5: lv_left_0_0= ruleUnaryQuantityExp
            {

            					newCompositeNode(grammarAccess.getBinaryQntyExpAccess().getLeftUnaryQuantityExpParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_14);
            lv_left_0_0=ruleUnaryQuantityExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryQntyExpRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_0_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.UnaryQuantityExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGenerator.g:675:3: ( (lv_numOp_1_0= ruleNumOp ) )
            // InternalStoryGenerator.g:676:4: (lv_numOp_1_0= ruleNumOp )
            {
            // InternalStoryGenerator.g:676:4: (lv_numOp_1_0= ruleNumOp )
            // InternalStoryGenerator.g:677:5: lv_numOp_1_0= ruleNumOp
            {

            					newCompositeNode(grammarAccess.getBinaryQntyExpAccess().getNumOpNumOpEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_15);
            lv_numOp_1_0=ruleNumOp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryQntyExpRule());
            					}
            					set(
            						current,
            						"numOp",
            						lv_numOp_1_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.NumOp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGenerator.g:694:3: ( (lv_right_2_0= ruleUnaryQuantityExp ) )
            // InternalStoryGenerator.g:695:4: (lv_right_2_0= ruleUnaryQuantityExp )
            {
            // InternalStoryGenerator.g:695:4: (lv_right_2_0= ruleUnaryQuantityExp )
            // InternalStoryGenerator.g:696:5: lv_right_2_0= ruleUnaryQuantityExp
            {

            					newCompositeNode(grammarAccess.getBinaryQntyExpAccess().getRightUnaryQuantityExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_right_2_0=ruleUnaryQuantityExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryQntyExpRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_2_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.UnaryQuantityExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryQntyExp"


    // $ANTLR start "entryRuleUnaryBoolExp"
    // InternalStoryGenerator.g:717:1: entryRuleUnaryBoolExp returns [EObject current=null] : iv_ruleUnaryBoolExp= ruleUnaryBoolExp EOF ;
    public final EObject entryRuleUnaryBoolExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryBoolExp = null;


        try {
            // InternalStoryGenerator.g:717:53: (iv_ruleUnaryBoolExp= ruleUnaryBoolExp EOF )
            // InternalStoryGenerator.g:718:2: iv_ruleUnaryBoolExp= ruleUnaryBoolExp EOF
            {
             newCompositeNode(grammarAccess.getUnaryBoolExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryBoolExp=ruleUnaryBoolExp();

            state._fsp--;

             current =iv_ruleUnaryBoolExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryBoolExp"


    // $ANTLR start "ruleUnaryBoolExp"
    // InternalStoryGenerator.g:724:1: ruleUnaryBoolExp returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= ruleBooleanValue ) ) ) ;
    public final EObject ruleUnaryBoolExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:730:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= ruleBooleanValue ) ) ) )
            // InternalStoryGenerator.g:731:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= ruleBooleanValue ) ) )
            {
            // InternalStoryGenerator.g:731:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= ruleBooleanValue ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=23 && LA7_0<=24)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalStoryGenerator.g:732:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalStoryGenerator.g:732:3: ( (otherlv_0= RULE_ID ) )
                    // InternalStoryGenerator.g:733:4: (otherlv_0= RULE_ID )
                    {
                    // InternalStoryGenerator.g:733:4: (otherlv_0= RULE_ID )
                    // InternalStoryGenerator.g:734:5: otherlv_0= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryBoolExpRule());
                    					}
                    				
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_0, grammarAccess.getUnaryBoolExpAccess().getIdAttributeCrossReference_0_0());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGenerator.g:746:3: ( (lv_value_1_0= ruleBooleanValue ) )
                    {
                    // InternalStoryGenerator.g:746:3: ( (lv_value_1_0= ruleBooleanValue ) )
                    // InternalStoryGenerator.g:747:4: (lv_value_1_0= ruleBooleanValue )
                    {
                    // InternalStoryGenerator.g:747:4: (lv_value_1_0= ruleBooleanValue )
                    // InternalStoryGenerator.g:748:5: lv_value_1_0= ruleBooleanValue
                    {

                    					newCompositeNode(grammarAccess.getUnaryBoolExpAccess().getValueBooleanValueEnumRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleBooleanValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getUnaryBoolExpRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_1_0,
                    						"br.ufes.inf.mdd.trab2.StoryGenerator.BooleanValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryBoolExp"


    // $ANTLR start "entryRuleNegateBoolExp"
    // InternalStoryGenerator.g:769:1: entryRuleNegateBoolExp returns [EObject current=null] : iv_ruleNegateBoolExp= ruleNegateBoolExp EOF ;
    public final EObject entryRuleNegateBoolExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegateBoolExp = null;


        try {
            // InternalStoryGenerator.g:769:54: (iv_ruleNegateBoolExp= ruleNegateBoolExp EOF )
            // InternalStoryGenerator.g:770:2: iv_ruleNegateBoolExp= ruleNegateBoolExp EOF
            {
             newCompositeNode(grammarAccess.getNegateBoolExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNegateBoolExp=ruleNegateBoolExp();

            state._fsp--;

             current =iv_ruleNegateBoolExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegateBoolExp"


    // $ANTLR start "ruleNegateBoolExp"
    // InternalStoryGenerator.g:776:1: ruleNegateBoolExp returns [EObject current=null] : (otherlv_0= 'not' ( (lv_boolExp_1_0= ruleBoolExp ) ) ) ;
    public final EObject ruleNegateBoolExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_boolExp_1_0 = null;



        	enterRule();

        try {
            // InternalStoryGenerator.g:782:2: ( (otherlv_0= 'not' ( (lv_boolExp_1_0= ruleBoolExp ) ) ) )
            // InternalStoryGenerator.g:783:2: (otherlv_0= 'not' ( (lv_boolExp_1_0= ruleBoolExp ) ) )
            {
            // InternalStoryGenerator.g:783:2: (otherlv_0= 'not' ( (lv_boolExp_1_0= ruleBoolExp ) ) )
            // InternalStoryGenerator.g:784:3: otherlv_0= 'not' ( (lv_boolExp_1_0= ruleBoolExp ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getNegateBoolExpAccess().getNotKeyword_0());
            		
            // InternalStoryGenerator.g:788:3: ( (lv_boolExp_1_0= ruleBoolExp ) )
            // InternalStoryGenerator.g:789:4: (lv_boolExp_1_0= ruleBoolExp )
            {
            // InternalStoryGenerator.g:789:4: (lv_boolExp_1_0= ruleBoolExp )
            // InternalStoryGenerator.g:790:5: lv_boolExp_1_0= ruleBoolExp
            {

            					newCompositeNode(grammarAccess.getNegateBoolExpAccess().getBoolExpBoolExpParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_boolExp_1_0=ruleBoolExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNegateBoolExpRule());
            					}
            					set(
            						current,
            						"boolExp",
            						lv_boolExp_1_0,
            						"br.ufes.inf.mdd.trab2.StoryGenerator.BoolExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegateBoolExp"


    // $ANTLR start "entryRuleUnaryQuantityExp"
    // InternalStoryGenerator.g:811:1: entryRuleUnaryQuantityExp returns [EObject current=null] : iv_ruleUnaryQuantityExp= ruleUnaryQuantityExp EOF ;
    public final EObject entryRuleUnaryQuantityExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryQuantityExp = null;


        try {
            // InternalStoryGenerator.g:811:57: (iv_ruleUnaryQuantityExp= ruleUnaryQuantityExp EOF )
            // InternalStoryGenerator.g:812:2: iv_ruleUnaryQuantityExp= ruleUnaryQuantityExp EOF
            {
             newCompositeNode(grammarAccess.getUnaryQuantityExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryQuantityExp=ruleUnaryQuantityExp();

            state._fsp--;

             current =iv_ruleUnaryQuantityExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryQuantityExp"


    // $ANTLR start "ruleUnaryQuantityExp"
    // InternalStoryGenerator.g:818:1: ruleUnaryQuantityExp returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleUnaryQuantityExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalStoryGenerator.g:824:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalStoryGenerator.g:825:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalStoryGenerator.g:825:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= RULE_INT ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_INT) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalStoryGenerator.g:826:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalStoryGenerator.g:826:3: ( (otherlv_0= RULE_ID ) )
                    // InternalStoryGenerator.g:827:4: (otherlv_0= RULE_ID )
                    {
                    // InternalStoryGenerator.g:827:4: (otherlv_0= RULE_ID )
                    // InternalStoryGenerator.g:828:5: otherlv_0= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryQuantityExpRule());
                    					}
                    				
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_0, grammarAccess.getUnaryQuantityExpAccess().getIdAttributeCrossReference_0_0());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGenerator.g:840:3: ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalStoryGenerator.g:840:3: ( (lv_value_1_0= RULE_INT ) )
                    // InternalStoryGenerator.g:841:4: (lv_value_1_0= RULE_INT )
                    {
                    // InternalStoryGenerator.g:841:4: (lv_value_1_0= RULE_INT )
                    // InternalStoryGenerator.g:842:5: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    					newLeafNode(lv_value_1_0, grammarAccess.getUnaryQuantityExpAccess().getValueINTTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryQuantityExpRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"value",
                    						lv_value_1_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryQuantityExp"


    // $ANTLR start "ruleAttrType"
    // InternalStoryGenerator.g:862:1: ruleAttrType returns [Enumerator current=null] : ( (enumLiteral_0= 'fact' ) | (enumLiteral_1= 'quantity' ) ) ;
    public final Enumerator ruleAttrType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalStoryGenerator.g:868:2: ( ( (enumLiteral_0= 'fact' ) | (enumLiteral_1= 'quantity' ) ) )
            // InternalStoryGenerator.g:869:2: ( (enumLiteral_0= 'fact' ) | (enumLiteral_1= 'quantity' ) )
            {
            // InternalStoryGenerator.g:869:2: ( (enumLiteral_0= 'fact' ) | (enumLiteral_1= 'quantity' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            else if ( (LA9_0==22) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalStoryGenerator.g:870:3: (enumLiteral_0= 'fact' )
                    {
                    // InternalStoryGenerator.g:870:3: (enumLiteral_0= 'fact' )
                    // InternalStoryGenerator.g:871:4: enumLiteral_0= 'fact'
                    {
                    enumLiteral_0=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getAttrTypeAccess().getFACTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAttrTypeAccess().getFACTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGenerator.g:878:3: (enumLiteral_1= 'quantity' )
                    {
                    // InternalStoryGenerator.g:878:3: (enumLiteral_1= 'quantity' )
                    // InternalStoryGenerator.g:879:4: enumLiteral_1= 'quantity'
                    {
                    enumLiteral_1=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getAttrTypeAccess().getQUANTITYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAttrTypeAccess().getQUANTITYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttrType"


    // $ANTLR start "ruleBooleanValue"
    // InternalStoryGenerator.g:889:1: ruleBooleanValue returns [Enumerator current=null] : ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) ;
    public final Enumerator ruleBooleanValue() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalStoryGenerator.g:895:2: ( ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) )
            // InternalStoryGenerator.g:896:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            {
            // InternalStoryGenerator.g:896:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            else if ( (LA10_0==24) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalStoryGenerator.g:897:3: (enumLiteral_0= 'true' )
                    {
                    // InternalStoryGenerator.g:897:3: (enumLiteral_0= 'true' )
                    // InternalStoryGenerator.g:898:4: enumLiteral_0= 'true'
                    {
                    enumLiteral_0=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getBooleanValueAccess().getTRUEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBooleanValueAccess().getTRUEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGenerator.g:905:3: (enumLiteral_1= 'false' )
                    {
                    // InternalStoryGenerator.g:905:3: (enumLiteral_1= 'false' )
                    // InternalStoryGenerator.g:906:4: enumLiteral_1= 'false'
                    {
                    enumLiteral_1=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getBooleanValueAccess().getFALSEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBooleanValueAccess().getFALSEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "ruleNumOp"
    // InternalStoryGenerator.g:916:1: ruleNumOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) ) ;
    public final Enumerator ruleNumOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalStoryGenerator.g:922:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) ) )
            // InternalStoryGenerator.g:923:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalStoryGenerator.g:923:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) )
            int alt11=6;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt11=1;
                }
                break;
            case 26:
                {
                alt11=2;
                }
                break;
            case 27:
                {
                alt11=3;
                }
                break;
            case 28:
                {
                alt11=4;
                }
                break;
            case 29:
                {
                alt11=5;
                }
                break;
            case 30:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalStoryGenerator.g:924:3: (enumLiteral_0= '==' )
                    {
                    // InternalStoryGenerator.g:924:3: (enumLiteral_0= '==' )
                    // InternalStoryGenerator.g:925:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNumOpAccess().getEQEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGenerator.g:932:3: (enumLiteral_1= '!=' )
                    {
                    // InternalStoryGenerator.g:932:3: (enumLiteral_1= '!=' )
                    // InternalStoryGenerator.g:933:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getNEQEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNumOpAccess().getNEQEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGenerator.g:940:3: (enumLiteral_2= '>' )
                    {
                    // InternalStoryGenerator.g:940:3: (enumLiteral_2= '>' )
                    // InternalStoryGenerator.g:941:4: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getGTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getNumOpAccess().getGTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGenerator.g:948:3: (enumLiteral_3= '<' )
                    {
                    // InternalStoryGenerator.g:948:3: (enumLiteral_3= '<' )
                    // InternalStoryGenerator.g:949:4: enumLiteral_3= '<'
                    {
                    enumLiteral_3=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getLTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getNumOpAccess().getLTEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGenerator.g:956:3: (enumLiteral_4= '>=' )
                    {
                    // InternalStoryGenerator.g:956:3: (enumLiteral_4= '>=' )
                    // InternalStoryGenerator.g:957:4: enumLiteral_4= '>='
                    {
                    enumLiteral_4=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getGEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getNumOpAccess().getGEEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalStoryGenerator.g:964:3: (enumLiteral_5= '<=' )
                    {
                    // InternalStoryGenerator.g:964:3: (enumLiteral_5= '<=' )
                    // InternalStoryGenerator.g:965:4: enumLiteral_5= '<='
                    {
                    enumLiteral_5=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getLEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getNumOpAccess().getLEEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumOp"


    // $ANTLR start "ruleBoolOp"
    // InternalStoryGenerator.g:975:1: ruleBoolOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'and' ) | (enumLiteral_3= 'or' ) ) ;
    public final Enumerator ruleBoolOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalStoryGenerator.g:981:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'and' ) | (enumLiteral_3= 'or' ) ) )
            // InternalStoryGenerator.g:982:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'and' ) | (enumLiteral_3= 'or' ) )
            {
            // InternalStoryGenerator.g:982:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'and' ) | (enumLiteral_3= 'or' ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt12=1;
                }
                break;
            case 26:
                {
                alt12=2;
                }
                break;
            case 31:
                {
                alt12=3;
                }
                break;
            case 32:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalStoryGenerator.g:983:3: (enumLiteral_0= '==' )
                    {
                    // InternalStoryGenerator.g:983:3: (enumLiteral_0= '==' )
                    // InternalStoryGenerator.g:984:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getBoolOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBoolOpAccess().getEQEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGenerator.g:991:3: (enumLiteral_1= '!=' )
                    {
                    // InternalStoryGenerator.g:991:3: (enumLiteral_1= '!=' )
                    // InternalStoryGenerator.g:992:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getBoolOpAccess().getNEQEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBoolOpAccess().getNEQEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGenerator.g:999:3: (enumLiteral_2= 'and' )
                    {
                    // InternalStoryGenerator.g:999:3: (enumLiteral_2= 'and' )
                    // InternalStoryGenerator.g:1000:4: enumLiteral_2= 'and'
                    {
                    enumLiteral_2=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGenerator.g:1007:3: (enumLiteral_3= 'or' )
                    {
                    // InternalStoryGenerator.g:1007:3: (enumLiteral_3= 'or' )
                    // InternalStoryGenerator.g:1008:4: enumLiteral_3= 'or'
                    {
                    enumLiteral_3=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getBoolOpAccess().getOREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getBoolOpAccess().getOREnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolOp"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\uffff\3\12\10\uffff\1\5";
    static final String dfa_3s = "\1\4\3\15\3\uffff\2\4\3\uffff\1\15";
    static final String dfa_4s = "\1\30\3\40\3\uffff\2\30\3\uffff\1\36";
    static final String dfa_5s = "\4\uffff\1\2\1\3\1\4\2\uffff\1\1\1\5\1\1\1\uffff";
    static final String dfa_6s = "\15\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\5\14\uffff\1\4\1\uffff\1\6\2\uffff\1\2\1\3",
            "\1\12\3\uffff\1\12\1\uffff\1\12\5\uffff\1\7\1\10\4\5\2\11",
            "\1\12\3\uffff\1\12\1\uffff\1\12\5\uffff\2\11\4\uffff\2\11",
            "\1\12\3\uffff\1\12\1\uffff\1\12\5\uffff\2\11\4\uffff\2\11",
            "",
            "",
            "",
            "\1\13\1\14\14\uffff\1\13\1\uffff\1\13\2\uffff\2\13",
            "\1\13\1\14\14\uffff\1\13\1\uffff\1\13\2\uffff\2\13",
            "",
            "",
            "",
            "\1\5\3\uffff\1\5\1\uffff\1\5\5\uffff\6\13"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "392:2: ( ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleBoolExp ) ) ) | (otherlv_3= '(' ( (lv_parBoolExp_4_0= ruleBoolExp ) ) otherlv_5= ')' ( (lv_binaryBool_6_0= ruleBinaryBoolExp ) ) ) | ( (lv_binaryQnty_7_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_8_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_9_0= ruleUnaryBoolExp ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000602000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001940030L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000186000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001800010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000007E000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000030L});

}