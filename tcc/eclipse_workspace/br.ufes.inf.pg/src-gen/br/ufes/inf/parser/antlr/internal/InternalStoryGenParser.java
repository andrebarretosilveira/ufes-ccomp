package br.ufes.inf.parser.antlr.internal;

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
import br.ufes.inf.services.StoryGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStoryGenParser extends AbstractInternalAntlrParser {
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


        public InternalStoryGenParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStoryGenParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStoryGenParser.tokenNames; }
    public String getGrammarFileName() { return "InternalStoryGen.g"; }



     	private StoryGenGrammarAccess grammarAccess;

        public InternalStoryGenParser(TokenStream input, StoryGenGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Story";
       	}

       	@Override
       	protected StoryGenGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleStory"
    // InternalStoryGen.g:65:1: entryRuleStory returns [EObject current=null] : iv_ruleStory= ruleStory EOF ;
    public final EObject entryRuleStory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStory = null;


        try {
            // InternalStoryGen.g:65:46: (iv_ruleStory= ruleStory EOF )
            // InternalStoryGen.g:66:2: iv_ruleStory= ruleStory EOF
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
    // InternalStoryGen.g:72:1: ruleStory returns [EObject current=null] : ( ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )* ) ;
    public final EObject ruleStory() throws RecognitionException {
        EObject current = null;

        EObject lv_world_0_0 = null;

        EObject lv_events_1_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:78:2: ( ( ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )* ) )
            // InternalStoryGen.g:79:2: ( ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )* )
            {
            // InternalStoryGen.g:79:2: ( ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )* )
            // InternalStoryGen.g:80:3: ( (lv_world_0_0= ruleWorld ) ) ( (lv_events_1_0= ruleEvent ) )*
            {
            // InternalStoryGen.g:80:3: ( (lv_world_0_0= ruleWorld ) )
            // InternalStoryGen.g:81:4: (lv_world_0_0= ruleWorld )
            {
            // InternalStoryGen.g:81:4: (lv_world_0_0= ruleWorld )
            // InternalStoryGen.g:82:5: lv_world_0_0= ruleWorld
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
            						"br.ufes.inf.StoryGen.World");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:99:3: ( (lv_events_1_0= ruleEvent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=14 && LA1_0<=15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalStoryGen.g:100:4: (lv_events_1_0= ruleEvent )
            	    {
            	    // InternalStoryGen.g:100:4: (lv_events_1_0= ruleEvent )
            	    // InternalStoryGen.g:101:5: lv_events_1_0= ruleEvent
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
            	    						"br.ufes.inf.StoryGen.Event");
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
    // InternalStoryGen.g:122:1: entryRuleWorld returns [EObject current=null] : iv_ruleWorld= ruleWorld EOF ;
    public final EObject entryRuleWorld() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorld = null;


        try {
            // InternalStoryGen.g:122:46: (iv_ruleWorld= ruleWorld EOF )
            // InternalStoryGen.g:123:2: iv_ruleWorld= ruleWorld EOF
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
    // InternalStoryGen.g:129:1: ruleWorld returns [EObject current=null] : ( () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) ;
    public final EObject ruleWorld() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:135:2: ( ( () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) )
            // InternalStoryGen.g:136:2: ( () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            {
            // InternalStoryGen.g:136:2: ( () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            // InternalStoryGen.g:137:3: () otherlv_1= 'World' otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}'
            {
            // InternalStoryGen.g:137:3: ()
            // InternalStoryGen.g:138:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getWorldAccess().getWorldAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getWorldAccess().getWorldKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getWorldAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalStoryGen.g:152:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=21 && LA2_0<=22)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalStoryGen.g:153:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalStoryGen.g:153:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalStoryGen.g:154:5: lv_attributes_3_0= ruleAttribute
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
            	    						"br.ufes.inf.StoryGen.Attribute");
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
    // InternalStoryGen.g:179:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalStoryGen.g:179:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalStoryGen.g:180:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalStoryGen.g:186:1: ruleAttribute returns [EObject current=null] : ( ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Enumerator lv_attrType_0_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:192:2: ( ( ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalStoryGen.g:193:2: ( ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalStoryGen.g:193:2: ( ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalStoryGen.g:194:3: ( (lv_attrType_0_0= ruleAttrType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalStoryGen.g:194:3: ( (lv_attrType_0_0= ruleAttrType ) )
            // InternalStoryGen.g:195:4: (lv_attrType_0_0= ruleAttrType )
            {
            // InternalStoryGen.g:195:4: (lv_attrType_0_0= ruleAttrType )
            // InternalStoryGen.g:196:5: lv_attrType_0_0= ruleAttrType
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
            						"br.ufes.inf.StoryGen.AttrType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:213:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStoryGen.g:214:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStoryGen.g:214:4: (lv_name_1_0= RULE_ID )
            // InternalStoryGen.g:215:5: lv_name_1_0= RULE_ID
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
    // InternalStoryGen.g:235:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalStoryGen.g:235:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalStoryGen.g:236:2: iv_ruleEvent= ruleEvent EOF
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
    // InternalStoryGen.g:242:1: ruleEvent returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}' ) ;
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
            // InternalStoryGen.g:248:2: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}' ) )
            // InternalStoryGen.g:249:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}' )
            {
            // InternalStoryGen.g:249:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}' )
            // InternalStoryGen.g:250:3: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'event' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( (lv_conditions_6_0= ruleCondition ) )* otherlv_7= '}'
            {
            // InternalStoryGen.g:250:3: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalStoryGen.g:251:4: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalStoryGen.g:251:4: (lv_abstract_0_0= 'abstract' )
                    // InternalStoryGen.g:252:5: lv_abstract_0_0= 'abstract'
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
            		
            // InternalStoryGen.g:268:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalStoryGen.g:269:4: (lv_name_2_0= RULE_ID )
            {
            // InternalStoryGen.g:269:4: (lv_name_2_0= RULE_ID )
            // InternalStoryGen.g:270:5: lv_name_2_0= RULE_ID
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

            // InternalStoryGen.g:286:3: (otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalStoryGen.g:287:4: otherlv_3= 'is' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getEventAccess().getIsKeyword_3_0());
                    			
                    // InternalStoryGen.g:291:4: ( (otherlv_4= RULE_ID ) )
                    // InternalStoryGen.g:292:5: (otherlv_4= RULE_ID )
                    {
                    // InternalStoryGen.g:292:5: (otherlv_4= RULE_ID )
                    // InternalStoryGen.g:293:6: otherlv_4= RULE_ID
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
            		
            // InternalStoryGen.g:309:3: ( (lv_conditions_6_0= ruleCondition ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalStoryGen.g:310:4: (lv_conditions_6_0= ruleCondition )
            	    {
            	    // InternalStoryGen.g:310:4: (lv_conditions_6_0= ruleCondition )
            	    // InternalStoryGen.g:311:5: lv_conditions_6_0= ruleCondition
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
            	    						"br.ufes.inf.StoryGen.Condition");
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
    // InternalStoryGen.g:336:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalStoryGen.g:336:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalStoryGen.g:337:2: iv_ruleCondition= ruleCondition EOF
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
    // InternalStoryGen.g:343:1: ruleCondition returns [EObject current=null] : (otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) ) ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_boolExp_1_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:349:2: ( (otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) ) ) )
            // InternalStoryGen.g:350:2: (otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) ) )
            {
            // InternalStoryGen.g:350:2: (otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) ) )
            // InternalStoryGen.g:351:3: otherlv_0= 'requires' ( (lv_boolExp_1_0= ruleBoolExp ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getRequiresKeyword_0());
            		
            // InternalStoryGen.g:355:3: ( (lv_boolExp_1_0= ruleBoolExp ) )
            // InternalStoryGen.g:356:4: (lv_boolExp_1_0= ruleBoolExp )
            {
            // InternalStoryGen.g:356:4: (lv_boolExp_1_0= ruleBoolExp )
            // InternalStoryGen.g:357:5: lv_boolExp_1_0= ruleBoolExp
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
            						"br.ufes.inf.StoryGen.BoolExp");
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
    // InternalStoryGen.g:378:1: entryRuleBoolExp returns [EObject current=null] : iv_ruleBoolExp= ruleBoolExp EOF ;
    public final EObject entryRuleBoolExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolExp = null;


        try {
            // InternalStoryGen.g:378:48: (iv_ruleBoolExp= ruleBoolExp EOF )
            // InternalStoryGen.g:379:2: iv_ruleBoolExp= ruleBoolExp EOF
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
    // InternalStoryGen.g:385:1: ruleBoolExp returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_left_1_0= ruleBoolExp ) ) otherlv_2= ')' ( (lv_boolOp_3_0= ruleBoolOp ) ) otherlv_4= '(' ( (lv_right_5_0= ruleBoolExp ) ) otherlv_6= ')' ) | ( (lv_binaryBool_7_0= ruleBinaryBoolExp ) ) | ( (lv_binaryQnty_8_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_9_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_10_0= ruleUnaryBoolExp ) ) ) ;
    public final EObject ruleBoolExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_left_1_0 = null;

        Enumerator lv_boolOp_3_0 = null;

        EObject lv_right_5_0 = null;

        EObject lv_binaryBool_7_0 = null;

        EObject lv_binaryQnty_8_0 = null;

        EObject lv_negateBoolExp_9_0 = null;

        EObject lv_unaryBool_10_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:391:2: ( ( (otherlv_0= '(' ( (lv_left_1_0= ruleBoolExp ) ) otherlv_2= ')' ( (lv_boolOp_3_0= ruleBoolOp ) ) otherlv_4= '(' ( (lv_right_5_0= ruleBoolExp ) ) otherlv_6= ')' ) | ( (lv_binaryBool_7_0= ruleBinaryBoolExp ) ) | ( (lv_binaryQnty_8_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_9_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_10_0= ruleUnaryBoolExp ) ) ) )
            // InternalStoryGen.g:392:2: ( (otherlv_0= '(' ( (lv_left_1_0= ruleBoolExp ) ) otherlv_2= ')' ( (lv_boolOp_3_0= ruleBoolOp ) ) otherlv_4= '(' ( (lv_right_5_0= ruleBoolExp ) ) otherlv_6= ')' ) | ( (lv_binaryBool_7_0= ruleBinaryBoolExp ) ) | ( (lv_binaryQnty_8_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_9_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_10_0= ruleUnaryBoolExp ) ) )
            {
            // InternalStoryGen.g:392:2: ( (otherlv_0= '(' ( (lv_left_1_0= ruleBoolExp ) ) otherlv_2= ')' ( (lv_boolOp_3_0= ruleBoolOp ) ) otherlv_4= '(' ( (lv_right_5_0= ruleBoolExp ) ) otherlv_6= ')' ) | ( (lv_binaryBool_7_0= ruleBinaryBoolExp ) ) | ( (lv_binaryQnty_8_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_9_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_10_0= ruleUnaryBoolExp ) ) )
            int alt6=5;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalStoryGen.g:393:3: (otherlv_0= '(' ( (lv_left_1_0= ruleBoolExp ) ) otherlv_2= ')' ( (lv_boolOp_3_0= ruleBoolOp ) ) otherlv_4= '(' ( (lv_right_5_0= ruleBoolExp ) ) otherlv_6= ')' )
                    {
                    // InternalStoryGen.g:393:3: (otherlv_0= '(' ( (lv_left_1_0= ruleBoolExp ) ) otherlv_2= ')' ( (lv_boolOp_3_0= ruleBoolOp ) ) otherlv_4= '(' ( (lv_right_5_0= ruleBoolExp ) ) otherlv_6= ')' )
                    // InternalStoryGen.g:394:4: otherlv_0= '(' ( (lv_left_1_0= ruleBoolExp ) ) otherlv_2= ')' ( (lv_boolOp_3_0= ruleBoolOp ) ) otherlv_4= '(' ( (lv_right_5_0= ruleBoolExp ) ) otherlv_6= ')'
                    {
                    otherlv_0=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_0, grammarAccess.getBoolExpAccess().getLeftParenthesisKeyword_0_0());
                    			
                    // InternalStoryGen.g:398:4: ( (lv_left_1_0= ruleBoolExp ) )
                    // InternalStoryGen.g:399:5: (lv_left_1_0= ruleBoolExp )
                    {
                    // InternalStoryGen.g:399:5: (lv_left_1_0= ruleBoolExp )
                    // InternalStoryGen.g:400:6: lv_left_1_0= ruleBoolExp
                    {

                    						newCompositeNode(grammarAccess.getBoolExpAccess().getLeftBoolExpParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_left_1_0=ruleBoolExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_1_0,
                    							"br.ufes.inf.StoryGen.BoolExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_2, grammarAccess.getBoolExpAccess().getRightParenthesisKeyword_0_2());
                    			
                    // InternalStoryGen.g:421:4: ( (lv_boolOp_3_0= ruleBoolOp ) )
                    // InternalStoryGen.g:422:5: (lv_boolOp_3_0= ruleBoolOp )
                    {
                    // InternalStoryGen.g:422:5: (lv_boolOp_3_0= ruleBoolOp )
                    // InternalStoryGen.g:423:6: lv_boolOp_3_0= ruleBoolOp
                    {

                    						newCompositeNode(grammarAccess.getBoolExpAccess().getBoolOpBoolOpEnumRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_boolOp_3_0=ruleBoolOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    						}
                    						set(
                    							current,
                    							"boolOp",
                    							lv_boolOp_3_0,
                    							"br.ufes.inf.StoryGen.BoolOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getBoolExpAccess().getLeftParenthesisKeyword_0_4());
                    			
                    // InternalStoryGen.g:444:4: ( (lv_right_5_0= ruleBoolExp ) )
                    // InternalStoryGen.g:445:5: (lv_right_5_0= ruleBoolExp )
                    {
                    // InternalStoryGen.g:445:5: (lv_right_5_0= ruleBoolExp )
                    // InternalStoryGen.g:446:6: lv_right_5_0= ruleBoolExp
                    {

                    						newCompositeNode(grammarAccess.getBoolExpAccess().getRightBoolExpParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_right_5_0=ruleBoolExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_5_0,
                    							"br.ufes.inf.StoryGen.BoolExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getBoolExpAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:469:3: ( (lv_binaryBool_7_0= ruleBinaryBoolExp ) )
                    {
                    // InternalStoryGen.g:469:3: ( (lv_binaryBool_7_0= ruleBinaryBoolExp ) )
                    // InternalStoryGen.g:470:4: (lv_binaryBool_7_0= ruleBinaryBoolExp )
                    {
                    // InternalStoryGen.g:470:4: (lv_binaryBool_7_0= ruleBinaryBoolExp )
                    // InternalStoryGen.g:471:5: lv_binaryBool_7_0= ruleBinaryBoolExp
                    {

                    					newCompositeNode(grammarAccess.getBoolExpAccess().getBinaryBoolBinaryBoolExpParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_binaryBool_7_0=ruleBinaryBoolExp();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    					}
                    					set(
                    						current,
                    						"binaryBool",
                    						lv_binaryBool_7_0,
                    						"br.ufes.inf.StoryGen.BinaryBoolExp");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:489:3: ( (lv_binaryQnty_8_0= ruleBinaryQntyExp ) )
                    {
                    // InternalStoryGen.g:489:3: ( (lv_binaryQnty_8_0= ruleBinaryQntyExp ) )
                    // InternalStoryGen.g:490:4: (lv_binaryQnty_8_0= ruleBinaryQntyExp )
                    {
                    // InternalStoryGen.g:490:4: (lv_binaryQnty_8_0= ruleBinaryQntyExp )
                    // InternalStoryGen.g:491:5: lv_binaryQnty_8_0= ruleBinaryQntyExp
                    {

                    					newCompositeNode(grammarAccess.getBoolExpAccess().getBinaryQntyBinaryQntyExpParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_binaryQnty_8_0=ruleBinaryQntyExp();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    					}
                    					set(
                    						current,
                    						"binaryQnty",
                    						lv_binaryQnty_8_0,
                    						"br.ufes.inf.StoryGen.BinaryQntyExp");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:509:3: ( (lv_negateBoolExp_9_0= ruleNegateBoolExp ) )
                    {
                    // InternalStoryGen.g:509:3: ( (lv_negateBoolExp_9_0= ruleNegateBoolExp ) )
                    // InternalStoryGen.g:510:4: (lv_negateBoolExp_9_0= ruleNegateBoolExp )
                    {
                    // InternalStoryGen.g:510:4: (lv_negateBoolExp_9_0= ruleNegateBoolExp )
                    // InternalStoryGen.g:511:5: lv_negateBoolExp_9_0= ruleNegateBoolExp
                    {

                    					newCompositeNode(grammarAccess.getBoolExpAccess().getNegateBoolExpNegateBoolExpParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_negateBoolExp_9_0=ruleNegateBoolExp();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    					}
                    					set(
                    						current,
                    						"negateBoolExp",
                    						lv_negateBoolExp_9_0,
                    						"br.ufes.inf.StoryGen.NegateBoolExp");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGen.g:529:3: ( (lv_unaryBool_10_0= ruleUnaryBoolExp ) )
                    {
                    // InternalStoryGen.g:529:3: ( (lv_unaryBool_10_0= ruleUnaryBoolExp ) )
                    // InternalStoryGen.g:530:4: (lv_unaryBool_10_0= ruleUnaryBoolExp )
                    {
                    // InternalStoryGen.g:530:4: (lv_unaryBool_10_0= ruleUnaryBoolExp )
                    // InternalStoryGen.g:531:5: lv_unaryBool_10_0= ruleUnaryBoolExp
                    {

                    					newCompositeNode(grammarAccess.getBoolExpAccess().getUnaryBoolUnaryBoolExpParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_unaryBool_10_0=ruleUnaryBoolExp();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBoolExpRule());
                    					}
                    					set(
                    						current,
                    						"unaryBool",
                    						lv_unaryBool_10_0,
                    						"br.ufes.inf.StoryGen.UnaryBoolExp");
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
    // InternalStoryGen.g:552:1: entryRuleBinaryBoolExp returns [EObject current=null] : iv_ruleBinaryBoolExp= ruleBinaryBoolExp EOF ;
    public final EObject entryRuleBinaryBoolExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryBoolExp = null;


        try {
            // InternalStoryGen.g:552:54: (iv_ruleBinaryBoolExp= ruleBinaryBoolExp EOF )
            // InternalStoryGen.g:553:2: iv_ruleBinaryBoolExp= ruleBinaryBoolExp EOF
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
    // InternalStoryGen.g:559:1: ruleBinaryBoolExp returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) ) ) ;
    public final EObject ruleBinaryBoolExp() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        Enumerator lv_boolOp_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:565:2: ( ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) ) ) )
            // InternalStoryGen.g:566:2: ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) ) )
            {
            // InternalStoryGen.g:566:2: ( ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) ) )
            // InternalStoryGen.g:567:3: ( (lv_left_0_0= ruleUnaryBoolExp ) ) ( (lv_boolOp_1_0= ruleBoolOp ) ) ( (lv_right_2_0= ruleUnaryBoolExp ) )
            {
            // InternalStoryGen.g:567:3: ( (lv_left_0_0= ruleUnaryBoolExp ) )
            // InternalStoryGen.g:568:4: (lv_left_0_0= ruleUnaryBoolExp )
            {
            // InternalStoryGen.g:568:4: (lv_left_0_0= ruleUnaryBoolExp )
            // InternalStoryGen.g:569:5: lv_left_0_0= ruleUnaryBoolExp
            {

            					newCompositeNode(grammarAccess.getBinaryBoolExpAccess().getLeftUnaryBoolExpParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_left_0_0=ruleUnaryBoolExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryBoolExpRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_0_0,
            						"br.ufes.inf.StoryGen.UnaryBoolExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:586:3: ( (lv_boolOp_1_0= ruleBoolOp ) )
            // InternalStoryGen.g:587:4: (lv_boolOp_1_0= ruleBoolOp )
            {
            // InternalStoryGen.g:587:4: (lv_boolOp_1_0= ruleBoolOp )
            // InternalStoryGen.g:588:5: lv_boolOp_1_0= ruleBoolOp
            {

            					newCompositeNode(grammarAccess.getBinaryBoolExpAccess().getBoolOpBoolOpEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_14);
            lv_boolOp_1_0=ruleBoolOp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryBoolExpRule());
            					}
            					set(
            						current,
            						"boolOp",
            						lv_boolOp_1_0,
            						"br.ufes.inf.StoryGen.BoolOp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:605:3: ( (lv_right_2_0= ruleUnaryBoolExp ) )
            // InternalStoryGen.g:606:4: (lv_right_2_0= ruleUnaryBoolExp )
            {
            // InternalStoryGen.g:606:4: (lv_right_2_0= ruleUnaryBoolExp )
            // InternalStoryGen.g:607:5: lv_right_2_0= ruleUnaryBoolExp
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
            						"br.ufes.inf.StoryGen.UnaryBoolExp");
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
    // InternalStoryGen.g:628:1: entryRuleBinaryQntyExp returns [EObject current=null] : iv_ruleBinaryQntyExp= ruleBinaryQntyExp EOF ;
    public final EObject entryRuleBinaryQntyExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryQntyExp = null;


        try {
            // InternalStoryGen.g:628:54: (iv_ruleBinaryQntyExp= ruleBinaryQntyExp EOF )
            // InternalStoryGen.g:629:2: iv_ruleBinaryQntyExp= ruleBinaryQntyExp EOF
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
    // InternalStoryGen.g:635:1: ruleBinaryQntyExp returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) ) ) ;
    public final EObject ruleBinaryQntyExp() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        Enumerator lv_numOp_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:641:2: ( ( ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) ) ) )
            // InternalStoryGen.g:642:2: ( ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) ) )
            {
            // InternalStoryGen.g:642:2: ( ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) ) )
            // InternalStoryGen.g:643:3: ( (lv_left_0_0= ruleUnaryQuantityExp ) ) ( (lv_numOp_1_0= ruleNumOp ) ) ( (lv_right_2_0= ruleUnaryQuantityExp ) )
            {
            // InternalStoryGen.g:643:3: ( (lv_left_0_0= ruleUnaryQuantityExp ) )
            // InternalStoryGen.g:644:4: (lv_left_0_0= ruleUnaryQuantityExp )
            {
            // InternalStoryGen.g:644:4: (lv_left_0_0= ruleUnaryQuantityExp )
            // InternalStoryGen.g:645:5: lv_left_0_0= ruleUnaryQuantityExp
            {

            					newCompositeNode(grammarAccess.getBinaryQntyExpAccess().getLeftUnaryQuantityExpParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_15);
            lv_left_0_0=ruleUnaryQuantityExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryQntyExpRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_0_0,
            						"br.ufes.inf.StoryGen.UnaryQuantityExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:662:3: ( (lv_numOp_1_0= ruleNumOp ) )
            // InternalStoryGen.g:663:4: (lv_numOp_1_0= ruleNumOp )
            {
            // InternalStoryGen.g:663:4: (lv_numOp_1_0= ruleNumOp )
            // InternalStoryGen.g:664:5: lv_numOp_1_0= ruleNumOp
            {

            					newCompositeNode(grammarAccess.getBinaryQntyExpAccess().getNumOpNumOpEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_numOp_1_0=ruleNumOp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryQntyExpRule());
            					}
            					set(
            						current,
            						"numOp",
            						lv_numOp_1_0,
            						"br.ufes.inf.StoryGen.NumOp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:681:3: ( (lv_right_2_0= ruleUnaryQuantityExp ) )
            // InternalStoryGen.g:682:4: (lv_right_2_0= ruleUnaryQuantityExp )
            {
            // InternalStoryGen.g:682:4: (lv_right_2_0= ruleUnaryQuantityExp )
            // InternalStoryGen.g:683:5: lv_right_2_0= ruleUnaryQuantityExp
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
            						"br.ufes.inf.StoryGen.UnaryQuantityExp");
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
    // InternalStoryGen.g:704:1: entryRuleUnaryBoolExp returns [EObject current=null] : iv_ruleUnaryBoolExp= ruleUnaryBoolExp EOF ;
    public final EObject entryRuleUnaryBoolExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryBoolExp = null;


        try {
            // InternalStoryGen.g:704:53: (iv_ruleUnaryBoolExp= ruleUnaryBoolExp EOF )
            // InternalStoryGen.g:705:2: iv_ruleUnaryBoolExp= ruleUnaryBoolExp EOF
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
    // InternalStoryGen.g:711:1: ruleUnaryBoolExp returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= ruleBooleanValue ) ) ) ;
    public final EObject ruleUnaryBoolExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:717:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= ruleBooleanValue ) ) ) )
            // InternalStoryGen.g:718:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= ruleBooleanValue ) ) )
            {
            // InternalStoryGen.g:718:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= ruleBooleanValue ) ) )
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
                    // InternalStoryGen.g:719:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalStoryGen.g:719:3: ( (otherlv_0= RULE_ID ) )
                    // InternalStoryGen.g:720:4: (otherlv_0= RULE_ID )
                    {
                    // InternalStoryGen.g:720:4: (otherlv_0= RULE_ID )
                    // InternalStoryGen.g:721:5: otherlv_0= RULE_ID
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
                    // InternalStoryGen.g:733:3: ( (lv_value_1_0= ruleBooleanValue ) )
                    {
                    // InternalStoryGen.g:733:3: ( (lv_value_1_0= ruleBooleanValue ) )
                    // InternalStoryGen.g:734:4: (lv_value_1_0= ruleBooleanValue )
                    {
                    // InternalStoryGen.g:734:4: (lv_value_1_0= ruleBooleanValue )
                    // InternalStoryGen.g:735:5: lv_value_1_0= ruleBooleanValue
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
                    						"br.ufes.inf.StoryGen.BooleanValue");
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
    // InternalStoryGen.g:756:1: entryRuleNegateBoolExp returns [EObject current=null] : iv_ruleNegateBoolExp= ruleNegateBoolExp EOF ;
    public final EObject entryRuleNegateBoolExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegateBoolExp = null;


        try {
            // InternalStoryGen.g:756:54: (iv_ruleNegateBoolExp= ruleNegateBoolExp EOF )
            // InternalStoryGen.g:757:2: iv_ruleNegateBoolExp= ruleNegateBoolExp EOF
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
    // InternalStoryGen.g:763:1: ruleNegateBoolExp returns [EObject current=null] : (otherlv_0= 'not' this_BoolExp_1= ruleBoolExp ) ;
    public final EObject ruleNegateBoolExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_BoolExp_1 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:769:2: ( (otherlv_0= 'not' this_BoolExp_1= ruleBoolExp ) )
            // InternalStoryGen.g:770:2: (otherlv_0= 'not' this_BoolExp_1= ruleBoolExp )
            {
            // InternalStoryGen.g:770:2: (otherlv_0= 'not' this_BoolExp_1= ruleBoolExp )
            // InternalStoryGen.g:771:3: otherlv_0= 'not' this_BoolExp_1= ruleBoolExp
            {
            otherlv_0=(Token)match(input,20,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getNegateBoolExpAccess().getNotKeyword_0());
            		

            			newCompositeNode(grammarAccess.getNegateBoolExpAccess().getBoolExpParserRuleCall_1());
            		
            pushFollow(FOLLOW_2);
            this_BoolExp_1=ruleBoolExp();

            state._fsp--;


            			current = this_BoolExp_1;
            			afterParserOrEnumRuleCall();
            		

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
    // InternalStoryGen.g:787:1: entryRuleUnaryQuantityExp returns [EObject current=null] : iv_ruleUnaryQuantityExp= ruleUnaryQuantityExp EOF ;
    public final EObject entryRuleUnaryQuantityExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryQuantityExp = null;


        try {
            // InternalStoryGen.g:787:57: (iv_ruleUnaryQuantityExp= ruleUnaryQuantityExp EOF )
            // InternalStoryGen.g:788:2: iv_ruleUnaryQuantityExp= ruleUnaryQuantityExp EOF
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
    // InternalStoryGen.g:794:1: ruleUnaryQuantityExp returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleUnaryQuantityExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalStoryGen.g:800:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalStoryGen.g:801:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalStoryGen.g:801:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_value_1_0= RULE_INT ) ) )
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
                    // InternalStoryGen.g:802:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalStoryGen.g:802:3: ( (otherlv_0= RULE_ID ) )
                    // InternalStoryGen.g:803:4: (otherlv_0= RULE_ID )
                    {
                    // InternalStoryGen.g:803:4: (otherlv_0= RULE_ID )
                    // InternalStoryGen.g:804:5: otherlv_0= RULE_ID
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
                    // InternalStoryGen.g:816:3: ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalStoryGen.g:816:3: ( (lv_value_1_0= RULE_INT ) )
                    // InternalStoryGen.g:817:4: (lv_value_1_0= RULE_INT )
                    {
                    // InternalStoryGen.g:817:4: (lv_value_1_0= RULE_INT )
                    // InternalStoryGen.g:818:5: lv_value_1_0= RULE_INT
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
    // InternalStoryGen.g:838:1: ruleAttrType returns [Enumerator current=null] : ( (enumLiteral_0= 'fact' ) | (enumLiteral_1= 'quantity' ) ) ;
    public final Enumerator ruleAttrType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalStoryGen.g:844:2: ( ( (enumLiteral_0= 'fact' ) | (enumLiteral_1= 'quantity' ) ) )
            // InternalStoryGen.g:845:2: ( (enumLiteral_0= 'fact' ) | (enumLiteral_1= 'quantity' ) )
            {
            // InternalStoryGen.g:845:2: ( (enumLiteral_0= 'fact' ) | (enumLiteral_1= 'quantity' ) )
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
                    // InternalStoryGen.g:846:3: (enumLiteral_0= 'fact' )
                    {
                    // InternalStoryGen.g:846:3: (enumLiteral_0= 'fact' )
                    // InternalStoryGen.g:847:4: enumLiteral_0= 'fact'
                    {
                    enumLiteral_0=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getAttrTypeAccess().getFACTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAttrTypeAccess().getFACTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:854:3: (enumLiteral_1= 'quantity' )
                    {
                    // InternalStoryGen.g:854:3: (enumLiteral_1= 'quantity' )
                    // InternalStoryGen.g:855:4: enumLiteral_1= 'quantity'
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
    // InternalStoryGen.g:865:1: ruleBooleanValue returns [Enumerator current=null] : ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) ;
    public final Enumerator ruleBooleanValue() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalStoryGen.g:871:2: ( ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) )
            // InternalStoryGen.g:872:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            {
            // InternalStoryGen.g:872:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
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
                    // InternalStoryGen.g:873:3: (enumLiteral_0= 'true' )
                    {
                    // InternalStoryGen.g:873:3: (enumLiteral_0= 'true' )
                    // InternalStoryGen.g:874:4: enumLiteral_0= 'true'
                    {
                    enumLiteral_0=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getBooleanValueAccess().getTRUEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBooleanValueAccess().getTRUEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:881:3: (enumLiteral_1= 'false' )
                    {
                    // InternalStoryGen.g:881:3: (enumLiteral_1= 'false' )
                    // InternalStoryGen.g:882:4: enumLiteral_1= 'false'
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
    // InternalStoryGen.g:892:1: ruleNumOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) ) ;
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
            // InternalStoryGen.g:898:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) ) )
            // InternalStoryGen.g:899:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) )
            {
            // InternalStoryGen.g:899:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '<' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '<=' ) )
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
                    // InternalStoryGen.g:900:3: (enumLiteral_0= '==' )
                    {
                    // InternalStoryGen.g:900:3: (enumLiteral_0= '==' )
                    // InternalStoryGen.g:901:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNumOpAccess().getEQEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:908:3: (enumLiteral_1= '!=' )
                    {
                    // InternalStoryGen.g:908:3: (enumLiteral_1= '!=' )
                    // InternalStoryGen.g:909:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getNEQEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNumOpAccess().getNEQEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:916:3: (enumLiteral_2= '>' )
                    {
                    // InternalStoryGen.g:916:3: (enumLiteral_2= '>' )
                    // InternalStoryGen.g:917:4: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getGTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getNumOpAccess().getGTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:924:3: (enumLiteral_3= '<' )
                    {
                    // InternalStoryGen.g:924:3: (enumLiteral_3= '<' )
                    // InternalStoryGen.g:925:4: enumLiteral_3= '<'
                    {
                    enumLiteral_3=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getLTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getNumOpAccess().getLTEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGen.g:932:3: (enumLiteral_4= '>=' )
                    {
                    // InternalStoryGen.g:932:3: (enumLiteral_4= '>=' )
                    // InternalStoryGen.g:933:4: enumLiteral_4= '>='
                    {
                    enumLiteral_4=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getNumOpAccess().getGEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getNumOpAccess().getGEEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalStoryGen.g:940:3: (enumLiteral_5= '<=' )
                    {
                    // InternalStoryGen.g:940:3: (enumLiteral_5= '<=' )
                    // InternalStoryGen.g:941:4: enumLiteral_5= '<='
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
    // InternalStoryGen.g:951:1: ruleBoolOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'and' ) | (enumLiteral_3= 'or' ) ) ;
    public final Enumerator ruleBoolOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalStoryGen.g:957:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'and' ) | (enumLiteral_3= 'or' ) ) )
            // InternalStoryGen.g:958:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'and' ) | (enumLiteral_3= 'or' ) )
            {
            // InternalStoryGen.g:958:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'and' ) | (enumLiteral_3= 'or' ) )
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
                    // InternalStoryGen.g:959:3: (enumLiteral_0= '==' )
                    {
                    // InternalStoryGen.g:959:3: (enumLiteral_0= '==' )
                    // InternalStoryGen.g:960:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getBoolOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBoolOpAccess().getEQEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:967:3: (enumLiteral_1= '!=' )
                    {
                    // InternalStoryGen.g:967:3: (enumLiteral_1= '!=' )
                    // InternalStoryGen.g:968:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getBoolOpAccess().getNEQEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBoolOpAccess().getNEQEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:975:3: (enumLiteral_2= 'and' )
                    {
                    // InternalStoryGen.g:975:3: (enumLiteral_2= 'and' )
                    // InternalStoryGen.g:976:4: enumLiteral_2= 'and'
                    {
                    enumLiteral_2=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:983:3: (enumLiteral_3= 'or' )
                    {
                    // InternalStoryGen.g:983:3: (enumLiteral_3= 'or' )
                    // InternalStoryGen.g:984:4: enumLiteral_3= 'or'
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
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\2\uffff\3\12\7\uffff";
    static final String dfa_3s = "\1\4\1\uffff\3\15\2\uffff\2\4\3\uffff";
    static final String dfa_4s = "\1\30\1\uffff\3\40\2\uffff\2\30\3\uffff";
    static final String dfa_5s = "\1\uffff\1\1\3\uffff\1\3\1\4\2\uffff\1\2\1\5\1\2";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\5\14\uffff\1\1\1\uffff\1\6\2\uffff\1\3\1\4",
            "",
            "\1\12\3\uffff\1\12\1\uffff\1\12\5\uffff\1\7\1\10\4\5\2\11",
            "\1\12\3\uffff\1\12\1\uffff\1\12\5\uffff\2\11\4\uffff\2\11",
            "\1\12\3\uffff\1\12\1\uffff\1\12\5\uffff\2\11\4\uffff\2\11",
            "",
            "",
            "\1\13\1\5\21\uffff\2\13",
            "\1\13\1\5\21\uffff\2\13",
            "",
            "",
            ""
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
            return "392:2: ( (otherlv_0= '(' ( (lv_left_1_0= ruleBoolExp ) ) otherlv_2= ')' ( (lv_boolOp_3_0= ruleBoolOp ) ) otherlv_4= '(' ( (lv_right_5_0= ruleBoolExp ) ) otherlv_6= ')' ) | ( (lv_binaryBool_7_0= ruleBinaryBoolExp ) ) | ( (lv_binaryQnty_8_0= ruleBinaryQntyExp ) ) | ( (lv_negateBoolExp_9_0= ruleNegateBoolExp ) ) | ( (lv_unaryBool_10_0= ruleUnaryBoolExp ) ) )";
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
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000186000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001800010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000007E000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000030L});

}