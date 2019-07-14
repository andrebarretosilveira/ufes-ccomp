package br.ufes.inf.pg.parser.antlr.internal;

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
import br.ufes.inf.pg.services.StoryGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStoryGenParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Story'", "'data'", "'{'", "'}'", "'Space'", "'Plot'", "'player'", "'actor'", "'name:'", "'object'", "'fact'", "'='", "'('", "')'", "'quantity'", "'['", "']'", "'increments'", "'decrements'", "'by'", "'opening'", "'ending'", "'event'", "'priority:'", "'description:'", "'short-description:'", "'triggers:'", "'may-trigger:'", "','", "'action'", "'type:'", "'actor:'", "'require:'", "'be-triggered'", "'change:'", "'.'", "'or'", "'and'", "'not'", "'true'", "'false'", "'visual'", "'interaction'", "'movement'", "'communication'", "'combat'", "'idle'", "'<'", "'<='", "'=='", "'!='", "'>='", "'>'", "'+='", "'-='", "'after'", "'before'", "'every event'", "'every happening'", "'every action'", "'every player action'", "'normal'", "'high'", "'veryHigh'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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
    // InternalStoryGen.g:72:1: ruleStory returns [EObject current=null] : ( ( (lv_data_0_0= ruleStoryData ) ) ( (lv_space_1_0= ruleSpace ) ) ( (lv_plot_2_0= rulePlot ) ) ) ;
    public final EObject ruleStory() throws RecognitionException {
        EObject current = null;

        EObject lv_data_0_0 = null;

        EObject lv_space_1_0 = null;

        EObject lv_plot_2_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:78:2: ( ( ( (lv_data_0_0= ruleStoryData ) ) ( (lv_space_1_0= ruleSpace ) ) ( (lv_plot_2_0= rulePlot ) ) ) )
            // InternalStoryGen.g:79:2: ( ( (lv_data_0_0= ruleStoryData ) ) ( (lv_space_1_0= ruleSpace ) ) ( (lv_plot_2_0= rulePlot ) ) )
            {
            // InternalStoryGen.g:79:2: ( ( (lv_data_0_0= ruleStoryData ) ) ( (lv_space_1_0= ruleSpace ) ) ( (lv_plot_2_0= rulePlot ) ) )
            // InternalStoryGen.g:80:3: ( (lv_data_0_0= ruleStoryData ) ) ( (lv_space_1_0= ruleSpace ) ) ( (lv_plot_2_0= rulePlot ) )
            {
            // InternalStoryGen.g:80:3: ( (lv_data_0_0= ruleStoryData ) )
            // InternalStoryGen.g:81:4: (lv_data_0_0= ruleStoryData )
            {
            // InternalStoryGen.g:81:4: (lv_data_0_0= ruleStoryData )
            // InternalStoryGen.g:82:5: lv_data_0_0= ruleStoryData
            {

            					newCompositeNode(grammarAccess.getStoryAccess().getDataStoryDataParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_data_0_0=ruleStoryData();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStoryRule());
            					}
            					set(
            						current,
            						"data",
            						lv_data_0_0,
            						"br.ufes.inf.pg.StoryGen.StoryData");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:99:3: ( (lv_space_1_0= ruleSpace ) )
            // InternalStoryGen.g:100:4: (lv_space_1_0= ruleSpace )
            {
            // InternalStoryGen.g:100:4: (lv_space_1_0= ruleSpace )
            // InternalStoryGen.g:101:5: lv_space_1_0= ruleSpace
            {

            					newCompositeNode(grammarAccess.getStoryAccess().getSpaceSpaceParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_space_1_0=ruleSpace();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStoryRule());
            					}
            					set(
            						current,
            						"space",
            						lv_space_1_0,
            						"br.ufes.inf.pg.StoryGen.Space");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:118:3: ( (lv_plot_2_0= rulePlot ) )
            // InternalStoryGen.g:119:4: (lv_plot_2_0= rulePlot )
            {
            // InternalStoryGen.g:119:4: (lv_plot_2_0= rulePlot )
            // InternalStoryGen.g:120:5: lv_plot_2_0= rulePlot
            {

            					newCompositeNode(grammarAccess.getStoryAccess().getPlotPlotParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_plot_2_0=rulePlot();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStoryRule());
            					}
            					set(
            						current,
            						"plot",
            						lv_plot_2_0,
            						"br.ufes.inf.pg.StoryGen.Plot");
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
    // $ANTLR end "ruleStory"


    // $ANTLR start "entryRuleStoryData"
    // InternalStoryGen.g:141:1: entryRuleStoryData returns [EObject current=null] : iv_ruleStoryData= ruleStoryData EOF ;
    public final EObject entryRuleStoryData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStoryData = null;


        try {
            // InternalStoryGen.g:141:50: (iv_ruleStoryData= ruleStoryData EOF )
            // InternalStoryGen.g:142:2: iv_ruleStoryData= ruleStoryData EOF
            {
             newCompositeNode(grammarAccess.getStoryDataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStoryData=ruleStoryData();

            state._fsp--;

             current =iv_ruleStoryData; 
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
    // $ANTLR end "entryRuleStoryData"


    // $ANTLR start "ruleStoryData"
    // InternalStoryGen.g:148:1: ruleStoryData returns [EObject current=null] : ( () otherlv_1= 'Story' otherlv_2= 'data' otherlv_3= '{' ( (lv_attributes_4_0= ruleAttribute ) )* otherlv_5= '}' ) ;
    public final EObject ruleStoryData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_attributes_4_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:154:2: ( ( () otherlv_1= 'Story' otherlv_2= 'data' otherlv_3= '{' ( (lv_attributes_4_0= ruleAttribute ) )* otherlv_5= '}' ) )
            // InternalStoryGen.g:155:2: ( () otherlv_1= 'Story' otherlv_2= 'data' otherlv_3= '{' ( (lv_attributes_4_0= ruleAttribute ) )* otherlv_5= '}' )
            {
            // InternalStoryGen.g:155:2: ( () otherlv_1= 'Story' otherlv_2= 'data' otherlv_3= '{' ( (lv_attributes_4_0= ruleAttribute ) )* otherlv_5= '}' )
            // InternalStoryGen.g:156:3: () otherlv_1= 'Story' otherlv_2= 'data' otherlv_3= '{' ( (lv_attributes_4_0= ruleAttribute ) )* otherlv_5= '}'
            {
            // InternalStoryGen.g:156:3: ()
            // InternalStoryGen.g:157:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStoryDataAccess().getStoryDataAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getStoryDataAccess().getStoryKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getStoryDataAccess().getDataKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getStoryDataAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalStoryGen.g:175:3: ( (lv_attributes_4_0= ruleAttribute ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==21||LA1_0==25) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalStoryGen.g:176:4: (lv_attributes_4_0= ruleAttribute )
            	    {
            	    // InternalStoryGen.g:176:4: (lv_attributes_4_0= ruleAttribute )
            	    // InternalStoryGen.g:177:5: lv_attributes_4_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getStoryDataAccess().getAttributesAttributeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_attributes_4_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStoryDataRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_4_0,
            	    						"br.ufes.inf.pg.StoryGen.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getStoryDataAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleStoryData"


    // $ANTLR start "entryRuleSpace"
    // InternalStoryGen.g:202:1: entryRuleSpace returns [EObject current=null] : iv_ruleSpace= ruleSpace EOF ;
    public final EObject entryRuleSpace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpace = null;


        try {
            // InternalStoryGen.g:202:46: (iv_ruleSpace= ruleSpace EOF )
            // InternalStoryGen.g:203:2: iv_ruleSpace= ruleSpace EOF
            {
             newCompositeNode(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpace=ruleSpace();

            state._fsp--;

             current =iv_ruleSpace; 
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
    // $ANTLR end "entryRuleSpace"


    // $ANTLR start "ruleSpace"
    // InternalStoryGen.g:209:1: ruleSpace returns [EObject current=null] : ( () otherlv_1= 'Space' otherlv_2= '{' ( (lv_existents_3_0= ruleExistent ) )* otherlv_4= '}' ) ;
    public final EObject ruleSpace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_existents_3_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:215:2: ( ( () otherlv_1= 'Space' otherlv_2= '{' ( (lv_existents_3_0= ruleExistent ) )* otherlv_4= '}' ) )
            // InternalStoryGen.g:216:2: ( () otherlv_1= 'Space' otherlv_2= '{' ( (lv_existents_3_0= ruleExistent ) )* otherlv_4= '}' )
            {
            // InternalStoryGen.g:216:2: ( () otherlv_1= 'Space' otherlv_2= '{' ( (lv_existents_3_0= ruleExistent ) )* otherlv_4= '}' )
            // InternalStoryGen.g:217:3: () otherlv_1= 'Space' otherlv_2= '{' ( (lv_existents_3_0= ruleExistent ) )* otherlv_4= '}'
            {
            // InternalStoryGen.g:217:3: ()
            // InternalStoryGen.g:218:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSpaceAccess().getSpaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getSpaceAccess().getSpaceKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getSpaceAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalStoryGen.g:232:3: ( (lv_existents_3_0= ruleExistent ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=17 && LA2_0<=18)||LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalStoryGen.g:233:4: (lv_existents_3_0= ruleExistent )
            	    {
            	    // InternalStoryGen.g:233:4: (lv_existents_3_0= ruleExistent )
            	    // InternalStoryGen.g:234:5: lv_existents_3_0= ruleExistent
            	    {

            	    					newCompositeNode(grammarAccess.getSpaceAccess().getExistentsExistentParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_existents_3_0=ruleExistent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSpaceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"existents",
            	    						lv_existents_3_0,
            	    						"br.ufes.inf.pg.StoryGen.Existent");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSpaceAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleSpace"


    // $ANTLR start "entryRulePlot"
    // InternalStoryGen.g:259:1: entryRulePlot returns [EObject current=null] : iv_rulePlot= rulePlot EOF ;
    public final EObject entryRulePlot() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlot = null;


        try {
            // InternalStoryGen.g:259:45: (iv_rulePlot= rulePlot EOF )
            // InternalStoryGen.g:260:2: iv_rulePlot= rulePlot EOF
            {
             newCompositeNode(grammarAccess.getPlotRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlot=rulePlot();

            state._fsp--;

             current =iv_rulePlot; 
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
    // $ANTLR end "entryRulePlot"


    // $ANTLR start "rulePlot"
    // InternalStoryGen.g:266:1: rulePlot returns [EObject current=null] : ( () otherlv_1= 'Plot' otherlv_2= '{' ( (lv_events_3_0= ruleEvent ) )* otherlv_4= '}' ) ;
    public final EObject rulePlot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_events_3_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:272:2: ( ( () otherlv_1= 'Plot' otherlv_2= '{' ( (lv_events_3_0= ruleEvent ) )* otherlv_4= '}' ) )
            // InternalStoryGen.g:273:2: ( () otherlv_1= 'Plot' otherlv_2= '{' ( (lv_events_3_0= ruleEvent ) )* otherlv_4= '}' )
            {
            // InternalStoryGen.g:273:2: ( () otherlv_1= 'Plot' otherlv_2= '{' ( (lv_events_3_0= ruleEvent ) )* otherlv_4= '}' )
            // InternalStoryGen.g:274:3: () otherlv_1= 'Plot' otherlv_2= '{' ( (lv_events_3_0= ruleEvent ) )* otherlv_4= '}'
            {
            // InternalStoryGen.g:274:3: ()
            // InternalStoryGen.g:275:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPlotAccess().getPlotAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getPlotAccess().getPlotKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getPlotAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalStoryGen.g:289:3: ( (lv_events_3_0= ruleEvent ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=31 && LA3_0<=33)||LA3_0==40) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalStoryGen.g:290:4: (lv_events_3_0= ruleEvent )
            	    {
            	    // InternalStoryGen.g:290:4: (lv_events_3_0= ruleEvent )
            	    // InternalStoryGen.g:291:5: lv_events_3_0= ruleEvent
            	    {

            	    					newCompositeNode(grammarAccess.getPlotAccess().getEventsEventParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_events_3_0=ruleEvent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPlotRule());
            	    					}
            	    					add(
            	    						current,
            	    						"events",
            	    						lv_events_3_0,
            	    						"br.ufes.inf.pg.StoryGen.Event");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPlotAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "rulePlot"


    // $ANTLR start "entryRuleExistent"
    // InternalStoryGen.g:316:1: entryRuleExistent returns [EObject current=null] : iv_ruleExistent= ruleExistent EOF ;
    public final EObject entryRuleExistent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExistent = null;


        try {
            // InternalStoryGen.g:316:49: (iv_ruleExistent= ruleExistent EOF )
            // InternalStoryGen.g:317:2: iv_ruleExistent= ruleExistent EOF
            {
             newCompositeNode(grammarAccess.getExistentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExistent=ruleExistent();

            state._fsp--;

             current =iv_ruleExistent; 
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
    // $ANTLR end "entryRuleExistent"


    // $ANTLR start "ruleExistent"
    // InternalStoryGen.g:323:1: ruleExistent returns [EObject current=null] : (this_Actor_0= ruleActor | this_Object_1= ruleObject ) ;
    public final EObject ruleExistent() throws RecognitionException {
        EObject current = null;

        EObject this_Actor_0 = null;

        EObject this_Object_1 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:329:2: ( (this_Actor_0= ruleActor | this_Object_1= ruleObject ) )
            // InternalStoryGen.g:330:2: (this_Actor_0= ruleActor | this_Object_1= ruleObject )
            {
            // InternalStoryGen.g:330:2: (this_Actor_0= ruleActor | this_Object_1= ruleObject )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=17 && LA4_0<=18)) ) {
                alt4=1;
            }
            else if ( (LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalStoryGen.g:331:3: this_Actor_0= ruleActor
                    {

                    			newCompositeNode(grammarAccess.getExistentAccess().getActorParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Actor_0=ruleActor();

                    state._fsp--;


                    			current = this_Actor_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:340:3: this_Object_1= ruleObject
                    {

                    			newCompositeNode(grammarAccess.getExistentAccess().getObjectParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Object_1=ruleObject();

                    state._fsp--;


                    			current = this_Object_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleExistent"


    // $ANTLR start "entryRuleActor"
    // InternalStoryGen.g:352:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalStoryGen.g:352:46: (iv_ruleActor= ruleActor EOF )
            // InternalStoryGen.g:353:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
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
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalStoryGen.g:359:1: ruleActor returns [EObject current=null] : ( ( (lv_playable_0_0= 'player' ) )? otherlv_1= 'actor' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'name:' ( (lv_displayName_5_0= RULE_STRING ) ) ( (lv_attributes_6_0= ruleAttribute ) )* otherlv_7= '}' ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token lv_playable_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_displayName_5_0=null;
        Token otherlv_7=null;
        EObject lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:365:2: ( ( ( (lv_playable_0_0= 'player' ) )? otherlv_1= 'actor' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'name:' ( (lv_displayName_5_0= RULE_STRING ) ) ( (lv_attributes_6_0= ruleAttribute ) )* otherlv_7= '}' ) )
            // InternalStoryGen.g:366:2: ( ( (lv_playable_0_0= 'player' ) )? otherlv_1= 'actor' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'name:' ( (lv_displayName_5_0= RULE_STRING ) ) ( (lv_attributes_6_0= ruleAttribute ) )* otherlv_7= '}' )
            {
            // InternalStoryGen.g:366:2: ( ( (lv_playable_0_0= 'player' ) )? otherlv_1= 'actor' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'name:' ( (lv_displayName_5_0= RULE_STRING ) ) ( (lv_attributes_6_0= ruleAttribute ) )* otherlv_7= '}' )
            // InternalStoryGen.g:367:3: ( (lv_playable_0_0= 'player' ) )? otherlv_1= 'actor' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'name:' ( (lv_displayName_5_0= RULE_STRING ) ) ( (lv_attributes_6_0= ruleAttribute ) )* otherlv_7= '}'
            {
            // InternalStoryGen.g:367:3: ( (lv_playable_0_0= 'player' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalStoryGen.g:368:4: (lv_playable_0_0= 'player' )
                    {
                    // InternalStoryGen.g:368:4: (lv_playable_0_0= 'player' )
                    // InternalStoryGen.g:369:5: lv_playable_0_0= 'player'
                    {
                    lv_playable_0_0=(Token)match(input,17,FOLLOW_10); 

                    					newLeafNode(lv_playable_0_0, grammarAccess.getActorAccess().getPlayablePlayerKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getActorRule());
                    					}
                    					setWithLastConsumed(current, "playable", true, "player");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getActorAccess().getActorKeyword_1());
            		
            // InternalStoryGen.g:385:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalStoryGen.g:386:4: (lv_name_2_0= RULE_ID )
            {
            // InternalStoryGen.g:386:4: (lv_name_2_0= RULE_ID )
            // InternalStoryGen.g:387:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_2_0, grammarAccess.getActorAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getActorAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getActorAccess().getNameKeyword_4());
            		
            // InternalStoryGen.g:411:3: ( (lv_displayName_5_0= RULE_STRING ) )
            // InternalStoryGen.g:412:4: (lv_displayName_5_0= RULE_STRING )
            {
            // InternalStoryGen.g:412:4: (lv_displayName_5_0= RULE_STRING )
            // InternalStoryGen.g:413:5: lv_displayName_5_0= RULE_STRING
            {
            lv_displayName_5_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_displayName_5_0, grammarAccess.getActorAccess().getDisplayNameSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"displayName",
            						lv_displayName_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalStoryGen.g:429:3: ( (lv_attributes_6_0= ruleAttribute ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==21||LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalStoryGen.g:430:4: (lv_attributes_6_0= ruleAttribute )
            	    {
            	    // InternalStoryGen.g:430:4: (lv_attributes_6_0= ruleAttribute )
            	    // InternalStoryGen.g:431:5: lv_attributes_6_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getActorAccess().getAttributesAttributeParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_attributes_6_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_6_0,
            	    						"br.ufes.inf.pg.StoryGen.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getActorAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleObject"
    // InternalStoryGen.g:456:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // InternalStoryGen.g:456:47: (iv_ruleObject= ruleObject EOF )
            // InternalStoryGen.g:457:2: iv_ruleObject= ruleObject EOF
            {
             newCompositeNode(grammarAccess.getObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObject=ruleObject();

            state._fsp--;

             current =iv_ruleObject; 
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
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalStoryGen.g:463:1: ruleObject returns [EObject current=null] : (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:469:2: ( (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' ) )
            // InternalStoryGen.g:470:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            {
            // InternalStoryGen.g:470:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}' )
            // InternalStoryGen.g:471:3: otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getObjectAccess().getObjectKeyword_0());
            		
            // InternalStoryGen.g:475:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStoryGen.g:476:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStoryGen.g:476:4: (lv_name_1_0= RULE_ID )
            // InternalStoryGen.g:477:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalStoryGen.g:497:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21||LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalStoryGen.g:498:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalStoryGen.g:498:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalStoryGen.g:499:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getObjectAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getObjectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"br.ufes.inf.pg.StoryGen.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleAttribute"
    // InternalStoryGen.g:524:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalStoryGen.g:524:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalStoryGen.g:525:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalStoryGen.g:531:1: ruleAttribute returns [EObject current=null] : (this_FactAttribute_0= ruleFactAttribute | this_QuantityAttribute_1= ruleQuantityAttribute ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_FactAttribute_0 = null;

        EObject this_QuantityAttribute_1 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:537:2: ( (this_FactAttribute_0= ruleFactAttribute | this_QuantityAttribute_1= ruleQuantityAttribute ) )
            // InternalStoryGen.g:538:2: (this_FactAttribute_0= ruleFactAttribute | this_QuantityAttribute_1= ruleQuantityAttribute )
            {
            // InternalStoryGen.g:538:2: (this_FactAttribute_0= ruleFactAttribute | this_QuantityAttribute_1= ruleQuantityAttribute )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            else if ( (LA8_0==25) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalStoryGen.g:539:3: this_FactAttribute_0= ruleFactAttribute
                    {

                    			newCompositeNode(grammarAccess.getAttributeAccess().getFactAttributeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FactAttribute_0=ruleFactAttribute();

                    state._fsp--;


                    			current = this_FactAttribute_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:548:3: this_QuantityAttribute_1= ruleQuantityAttribute
                    {

                    			newCompositeNode(grammarAccess.getAttributeAccess().getQuantityAttributeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_QuantityAttribute_1=ruleQuantityAttribute();

                    state._fsp--;


                    			current = this_QuantityAttribute_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleFactAttribute"
    // InternalStoryGen.g:560:1: entryRuleFactAttribute returns [EObject current=null] : iv_ruleFactAttribute= ruleFactAttribute EOF ;
    public final EObject entryRuleFactAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFactAttribute = null;


        try {
            // InternalStoryGen.g:560:54: (iv_ruleFactAttribute= ruleFactAttribute EOF )
            // InternalStoryGen.g:561:2: iv_ruleFactAttribute= ruleFactAttribute EOF
            {
             newCompositeNode(grammarAccess.getFactAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFactAttribute=ruleFactAttribute();

            state._fsp--;

             current =iv_ruleFactAttribute; 
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
    // $ANTLR end "entryRuleFactAttribute"


    // $ANTLR start "ruleFactAttribute"
    // InternalStoryGen.g:567:1: ruleFactAttribute returns [EObject current=null] : (otherlv_0= 'fact' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_initValue_3_0= ruleBooleanTerm ) ) | (otherlv_4= '(' ( (lv_macroExp_5_0= ruleExpression ) ) otherlv_6= ')' ) ) ) ;
    public final EObject ruleFactAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_initValue_3_0 = null;

        EObject lv_macroExp_5_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:573:2: ( (otherlv_0= 'fact' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_initValue_3_0= ruleBooleanTerm ) ) | (otherlv_4= '(' ( (lv_macroExp_5_0= ruleExpression ) ) otherlv_6= ')' ) ) ) )
            // InternalStoryGen.g:574:2: (otherlv_0= 'fact' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_initValue_3_0= ruleBooleanTerm ) ) | (otherlv_4= '(' ( (lv_macroExp_5_0= ruleExpression ) ) otherlv_6= ')' ) ) )
            {
            // InternalStoryGen.g:574:2: (otherlv_0= 'fact' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_initValue_3_0= ruleBooleanTerm ) ) | (otherlv_4= '(' ( (lv_macroExp_5_0= ruleExpression ) ) otherlv_6= ')' ) ) )
            // InternalStoryGen.g:575:3: otherlv_0= 'fact' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_initValue_3_0= ruleBooleanTerm ) ) | (otherlv_4= '(' ( (lv_macroExp_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getFactAttributeAccess().getFactKeyword_0());
            		
            // InternalStoryGen.g:579:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStoryGen.g:580:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStoryGen.g:580:4: (lv_name_1_0= RULE_ID )
            // InternalStoryGen.g:581:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFactAttributeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFactAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getFactAttributeAccess().getEqualsSignKeyword_2());
            		
            // InternalStoryGen.g:601:3: ( ( (lv_initValue_3_0= ruleBooleanTerm ) ) | (otherlv_4= '(' ( (lv_macroExp_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=50 && LA9_0<=51)) ) {
                alt9=1;
            }
            else if ( (LA9_0==23) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalStoryGen.g:602:4: ( (lv_initValue_3_0= ruleBooleanTerm ) )
                    {
                    // InternalStoryGen.g:602:4: ( (lv_initValue_3_0= ruleBooleanTerm ) )
                    // InternalStoryGen.g:603:5: (lv_initValue_3_0= ruleBooleanTerm )
                    {
                    // InternalStoryGen.g:603:5: (lv_initValue_3_0= ruleBooleanTerm )
                    // InternalStoryGen.g:604:6: lv_initValue_3_0= ruleBooleanTerm
                    {

                    						newCompositeNode(grammarAccess.getFactAttributeAccess().getInitValueBooleanTermParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_initValue_3_0=ruleBooleanTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFactAttributeRule());
                    						}
                    						set(
                    							current,
                    							"initValue",
                    							lv_initValue_3_0,
                    							"br.ufes.inf.pg.StoryGen.BooleanTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:622:4: (otherlv_4= '(' ( (lv_macroExp_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalStoryGen.g:622:4: (otherlv_4= '(' ( (lv_macroExp_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalStoryGen.g:623:5: otherlv_4= '(' ( (lv_macroExp_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_16); 

                    					newLeafNode(otherlv_4, grammarAccess.getFactAttributeAccess().getLeftParenthesisKeyword_3_1_0());
                    				
                    // InternalStoryGen.g:627:5: ( (lv_macroExp_5_0= ruleExpression ) )
                    // InternalStoryGen.g:628:6: (lv_macroExp_5_0= ruleExpression )
                    {
                    // InternalStoryGen.g:628:6: (lv_macroExp_5_0= ruleExpression )
                    // InternalStoryGen.g:629:7: lv_macroExp_5_0= ruleExpression
                    {

                    							newCompositeNode(grammarAccess.getFactAttributeAccess().getMacroExpExpressionParserRuleCall_3_1_1_0());
                    						
                    pushFollow(FOLLOW_17);
                    lv_macroExp_5_0=ruleExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFactAttributeRule());
                    							}
                    							set(
                    								current,
                    								"macroExp",
                    								lv_macroExp_5_0,
                    								"br.ufes.inf.pg.StoryGen.Expression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_6=(Token)match(input,24,FOLLOW_2); 

                    					newLeafNode(otherlv_6, grammarAccess.getFactAttributeAccess().getRightParenthesisKeyword_3_1_2());
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleFactAttribute"


    // $ANTLR start "entryRuleQuantityAttribute"
    // InternalStoryGen.g:656:1: entryRuleQuantityAttribute returns [EObject current=null] : iv_ruleQuantityAttribute= ruleQuantityAttribute EOF ;
    public final EObject entryRuleQuantityAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantityAttribute = null;


        try {
            // InternalStoryGen.g:656:58: (iv_ruleQuantityAttribute= ruleQuantityAttribute EOF )
            // InternalStoryGen.g:657:2: iv_ruleQuantityAttribute= ruleQuantityAttribute EOF
            {
             newCompositeNode(grammarAccess.getQuantityAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuantityAttribute=ruleQuantityAttribute();

            state._fsp--;

             current =iv_ruleQuantityAttribute; 
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
    // $ANTLR end "entryRuleQuantityAttribute"


    // $ANTLR start "ruleQuantityAttribute"
    // InternalStoryGen.g:663:1: ruleQuantityAttribute returns [EObject current=null] : (otherlv_0= 'quantity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_initValue_3_0= ruleIntegerTerm ) ) (otherlv_4= '[' ( (lv_setting_5_0= ruleAttributeSetting ) ) otherlv_6= ']' )? ) ;
    public final EObject ruleQuantityAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_initValue_3_0 = null;

        EObject lv_setting_5_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:669:2: ( (otherlv_0= 'quantity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_initValue_3_0= ruleIntegerTerm ) ) (otherlv_4= '[' ( (lv_setting_5_0= ruleAttributeSetting ) ) otherlv_6= ']' )? ) )
            // InternalStoryGen.g:670:2: (otherlv_0= 'quantity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_initValue_3_0= ruleIntegerTerm ) ) (otherlv_4= '[' ( (lv_setting_5_0= ruleAttributeSetting ) ) otherlv_6= ']' )? )
            {
            // InternalStoryGen.g:670:2: (otherlv_0= 'quantity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_initValue_3_0= ruleIntegerTerm ) ) (otherlv_4= '[' ( (lv_setting_5_0= ruleAttributeSetting ) ) otherlv_6= ']' )? )
            // InternalStoryGen.g:671:3: otherlv_0= 'quantity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_initValue_3_0= ruleIntegerTerm ) ) (otherlv_4= '[' ( (lv_setting_5_0= ruleAttributeSetting ) ) otherlv_6= ']' )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getQuantityAttributeAccess().getQuantityKeyword_0());
            		
            // InternalStoryGen.g:675:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStoryGen.g:676:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStoryGen.g:676:4: (lv_name_1_0= RULE_ID )
            // InternalStoryGen.g:677:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getQuantityAttributeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQuantityAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getQuantityAttributeAccess().getEqualsSignKeyword_2());
            		
            // InternalStoryGen.g:697:3: ( (lv_initValue_3_0= ruleIntegerTerm ) )
            // InternalStoryGen.g:698:4: (lv_initValue_3_0= ruleIntegerTerm )
            {
            // InternalStoryGen.g:698:4: (lv_initValue_3_0= ruleIntegerTerm )
            // InternalStoryGen.g:699:5: lv_initValue_3_0= ruleIntegerTerm
            {

            					newCompositeNode(grammarAccess.getQuantityAttributeAccess().getInitValueIntegerTermParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_19);
            lv_initValue_3_0=ruleIntegerTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQuantityAttributeRule());
            					}
            					set(
            						current,
            						"initValue",
            						lv_initValue_3_0,
            						"br.ufes.inf.pg.StoryGen.IntegerTerm");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:716:3: (otherlv_4= '[' ( (lv_setting_5_0= ruleAttributeSetting ) ) otherlv_6= ']' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalStoryGen.g:717:4: otherlv_4= '[' ( (lv_setting_5_0= ruleAttributeSetting ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_20); 

                    				newLeafNode(otherlv_4, grammarAccess.getQuantityAttributeAccess().getLeftSquareBracketKeyword_4_0());
                    			
                    // InternalStoryGen.g:721:4: ( (lv_setting_5_0= ruleAttributeSetting ) )
                    // InternalStoryGen.g:722:5: (lv_setting_5_0= ruleAttributeSetting )
                    {
                    // InternalStoryGen.g:722:5: (lv_setting_5_0= ruleAttributeSetting )
                    // InternalStoryGen.g:723:6: lv_setting_5_0= ruleAttributeSetting
                    {

                    						newCompositeNode(grammarAccess.getQuantityAttributeAccess().getSettingAttributeSettingParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_setting_5_0=ruleAttributeSetting();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQuantityAttributeRule());
                    						}
                    						set(
                    							current,
                    							"setting",
                    							lv_setting_5_0,
                    							"br.ufes.inf.pg.StoryGen.AttributeSetting");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getQuantityAttributeAccess().getRightSquareBracketKeyword_4_2());
                    			

                    }
                    break;

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
    // $ANTLR end "ruleQuantityAttribute"


    // $ANTLR start "entryRuleAttributeSetting"
    // InternalStoryGen.g:749:1: entryRuleAttributeSetting returns [EObject current=null] : iv_ruleAttributeSetting= ruleAttributeSetting EOF ;
    public final EObject entryRuleAttributeSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSetting = null;


        try {
            // InternalStoryGen.g:749:57: (iv_ruleAttributeSetting= ruleAttributeSetting EOF )
            // InternalStoryGen.g:750:2: iv_ruleAttributeSetting= ruleAttributeSetting EOF
            {
             newCompositeNode(grammarAccess.getAttributeSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeSetting=ruleAttributeSetting();

            state._fsp--;

             current =iv_ruleAttributeSetting; 
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
    // $ANTLR end "entryRuleAttributeSetting"


    // $ANTLR start "ruleAttributeSetting"
    // InternalStoryGen.g:756:1: ruleAttributeSetting returns [EObject current=null] : ( ( ( (lv_positive_0_0= 'increments' ) ) | ( (lv_negative_1_0= 'decrements' ) ) ) otherlv_2= 'by' ( (lv_amount_3_0= RULE_INT ) ) ( (lv_frequency_4_0= ruleAttributeSettingFrequency ) ) ) ;
    public final EObject ruleAttributeSetting() throws RecognitionException {
        EObject current = null;

        Token lv_positive_0_0=null;
        Token lv_negative_1_0=null;
        Token otherlv_2=null;
        Token lv_amount_3_0=null;
        Enumerator lv_frequency_4_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:762:2: ( ( ( ( (lv_positive_0_0= 'increments' ) ) | ( (lv_negative_1_0= 'decrements' ) ) ) otherlv_2= 'by' ( (lv_amount_3_0= RULE_INT ) ) ( (lv_frequency_4_0= ruleAttributeSettingFrequency ) ) ) )
            // InternalStoryGen.g:763:2: ( ( ( (lv_positive_0_0= 'increments' ) ) | ( (lv_negative_1_0= 'decrements' ) ) ) otherlv_2= 'by' ( (lv_amount_3_0= RULE_INT ) ) ( (lv_frequency_4_0= ruleAttributeSettingFrequency ) ) )
            {
            // InternalStoryGen.g:763:2: ( ( ( (lv_positive_0_0= 'increments' ) ) | ( (lv_negative_1_0= 'decrements' ) ) ) otherlv_2= 'by' ( (lv_amount_3_0= RULE_INT ) ) ( (lv_frequency_4_0= ruleAttributeSettingFrequency ) ) )
            // InternalStoryGen.g:764:3: ( ( (lv_positive_0_0= 'increments' ) ) | ( (lv_negative_1_0= 'decrements' ) ) ) otherlv_2= 'by' ( (lv_amount_3_0= RULE_INT ) ) ( (lv_frequency_4_0= ruleAttributeSettingFrequency ) )
            {
            // InternalStoryGen.g:764:3: ( ( (lv_positive_0_0= 'increments' ) ) | ( (lv_negative_1_0= 'decrements' ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            else if ( (LA11_0==29) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalStoryGen.g:765:4: ( (lv_positive_0_0= 'increments' ) )
                    {
                    // InternalStoryGen.g:765:4: ( (lv_positive_0_0= 'increments' ) )
                    // InternalStoryGen.g:766:5: (lv_positive_0_0= 'increments' )
                    {
                    // InternalStoryGen.g:766:5: (lv_positive_0_0= 'increments' )
                    // InternalStoryGen.g:767:6: lv_positive_0_0= 'increments'
                    {
                    lv_positive_0_0=(Token)match(input,28,FOLLOW_22); 

                    						newLeafNode(lv_positive_0_0, grammarAccess.getAttributeSettingAccess().getPositiveIncrementsKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeSettingRule());
                    						}
                    						setWithLastConsumed(current, "positive", true, "increments");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:780:4: ( (lv_negative_1_0= 'decrements' ) )
                    {
                    // InternalStoryGen.g:780:4: ( (lv_negative_1_0= 'decrements' ) )
                    // InternalStoryGen.g:781:5: (lv_negative_1_0= 'decrements' )
                    {
                    // InternalStoryGen.g:781:5: (lv_negative_1_0= 'decrements' )
                    // InternalStoryGen.g:782:6: lv_negative_1_0= 'decrements'
                    {
                    lv_negative_1_0=(Token)match(input,29,FOLLOW_22); 

                    						newLeafNode(lv_negative_1_0, grammarAccess.getAttributeSettingAccess().getNegativeDecrementsKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeSettingRule());
                    						}
                    						setWithLastConsumed(current, "negative", true, "decrements");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,30,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getAttributeSettingAccess().getByKeyword_1());
            		
            // InternalStoryGen.g:799:3: ( (lv_amount_3_0= RULE_INT ) )
            // InternalStoryGen.g:800:4: (lv_amount_3_0= RULE_INT )
            {
            // InternalStoryGen.g:800:4: (lv_amount_3_0= RULE_INT )
            // InternalStoryGen.g:801:5: lv_amount_3_0= RULE_INT
            {
            lv_amount_3_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            					newLeafNode(lv_amount_3_0, grammarAccess.getAttributeSettingAccess().getAmountINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeSettingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"amount",
            						lv_amount_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalStoryGen.g:817:3: ( (lv_frequency_4_0= ruleAttributeSettingFrequency ) )
            // InternalStoryGen.g:818:4: (lv_frequency_4_0= ruleAttributeSettingFrequency )
            {
            // InternalStoryGen.g:818:4: (lv_frequency_4_0= ruleAttributeSettingFrequency )
            // InternalStoryGen.g:819:5: lv_frequency_4_0= ruleAttributeSettingFrequency
            {

            					newCompositeNode(grammarAccess.getAttributeSettingAccess().getFrequencyAttributeSettingFrequencyEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_frequency_4_0=ruleAttributeSettingFrequency();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeSettingRule());
            					}
            					set(
            						current,
            						"frequency",
            						lv_frequency_4_0,
            						"br.ufes.inf.pg.StoryGen.AttributeSettingFrequency");
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
    // $ANTLR end "ruleAttributeSetting"


    // $ANTLR start "entryRuleEvent"
    // InternalStoryGen.g:840:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalStoryGen.g:840:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalStoryGen.g:841:2: iv_ruleEvent= ruleEvent EOF
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
    // InternalStoryGen.g:847:1: ruleEvent returns [EObject current=null] : (this_HappeningEvent_0= ruleHappeningEvent | this_ActionEvent_1= ruleActionEvent ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        EObject this_HappeningEvent_0 = null;

        EObject this_ActionEvent_1 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:853:2: ( (this_HappeningEvent_0= ruleHappeningEvent | this_ActionEvent_1= ruleActionEvent ) )
            // InternalStoryGen.g:854:2: (this_HappeningEvent_0= ruleHappeningEvent | this_ActionEvent_1= ruleActionEvent )
            {
            // InternalStoryGen.g:854:2: (this_HappeningEvent_0= ruleHappeningEvent | this_ActionEvent_1= ruleActionEvent )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=31 && LA12_0<=33)) ) {
                alt12=1;
            }
            else if ( (LA12_0==40) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalStoryGen.g:855:3: this_HappeningEvent_0= ruleHappeningEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getHappeningEventParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_HappeningEvent_0=ruleHappeningEvent();

                    state._fsp--;


                    			current = this_HappeningEvent_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:864:3: this_ActionEvent_1= ruleActionEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getActionEventParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ActionEvent_1=ruleActionEvent();

                    state._fsp--;


                    			current = this_ActionEvent_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleHappeningEvent"
    // InternalStoryGen.g:876:1: entryRuleHappeningEvent returns [EObject current=null] : iv_ruleHappeningEvent= ruleHappeningEvent EOF ;
    public final EObject entryRuleHappeningEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHappeningEvent = null;


        try {
            // InternalStoryGen.g:876:55: (iv_ruleHappeningEvent= ruleHappeningEvent EOF )
            // InternalStoryGen.g:877:2: iv_ruleHappeningEvent= ruleHappeningEvent EOF
            {
             newCompositeNode(grammarAccess.getHappeningEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHappeningEvent=ruleHappeningEvent();

            state._fsp--;

             current =iv_ruleHappeningEvent; 
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
    // $ANTLR end "entryRuleHappeningEvent"


    // $ANTLR start "ruleHappeningEvent"
    // InternalStoryGen.g:883:1: ruleHappeningEvent returns [EObject current=null] : ( ( ( (lv_opening_0_0= 'opening' ) ) | ( (lv_ending_1_0= 'ending' ) ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'priority:' ( (lv_priority_6_0= ruleEventPriority ) ) )? otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? (otherlv_11= 'triggers:' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'may-trigger:' ( ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' )* ( (otherlv_16= RULE_ID ) ) )? ( (lv_conditions_17_0= ruleCondition ) )* ( (lv_changes_18_0= ruleChange ) )* otherlv_19= '}' ) ;
    public final EObject ruleHappeningEvent() throws RecognitionException {
        EObject current = null;

        Token lv_opening_0_0=null;
        Token lv_ending_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_description_8_0=null;
        Token otherlv_9=null;
        Token lv_shortDescription_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        Enumerator lv_priority_6_0 = null;

        EObject lv_conditions_17_0 = null;

        EObject lv_changes_18_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:889:2: ( ( ( ( (lv_opening_0_0= 'opening' ) ) | ( (lv_ending_1_0= 'ending' ) ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'priority:' ( (lv_priority_6_0= ruleEventPriority ) ) )? otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? (otherlv_11= 'triggers:' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'may-trigger:' ( ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' )* ( (otherlv_16= RULE_ID ) ) )? ( (lv_conditions_17_0= ruleCondition ) )* ( (lv_changes_18_0= ruleChange ) )* otherlv_19= '}' ) )
            // InternalStoryGen.g:890:2: ( ( ( (lv_opening_0_0= 'opening' ) ) | ( (lv_ending_1_0= 'ending' ) ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'priority:' ( (lv_priority_6_0= ruleEventPriority ) ) )? otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? (otherlv_11= 'triggers:' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'may-trigger:' ( ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' )* ( (otherlv_16= RULE_ID ) ) )? ( (lv_conditions_17_0= ruleCondition ) )* ( (lv_changes_18_0= ruleChange ) )* otherlv_19= '}' )
            {
            // InternalStoryGen.g:890:2: ( ( ( (lv_opening_0_0= 'opening' ) ) | ( (lv_ending_1_0= 'ending' ) ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'priority:' ( (lv_priority_6_0= ruleEventPriority ) ) )? otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? (otherlv_11= 'triggers:' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'may-trigger:' ( ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' )* ( (otherlv_16= RULE_ID ) ) )? ( (lv_conditions_17_0= ruleCondition ) )* ( (lv_changes_18_0= ruleChange ) )* otherlv_19= '}' )
            // InternalStoryGen.g:891:3: ( ( (lv_opening_0_0= 'opening' ) ) | ( (lv_ending_1_0= 'ending' ) ) )? otherlv_2= 'event' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' (otherlv_5= 'priority:' ( (lv_priority_6_0= ruleEventPriority ) ) )? otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? (otherlv_11= 'triggers:' ( (otherlv_12= RULE_ID ) ) )? (otherlv_13= 'may-trigger:' ( ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' )* ( (otherlv_16= RULE_ID ) ) )? ( (lv_conditions_17_0= ruleCondition ) )* ( (lv_changes_18_0= ruleChange ) )* otherlv_19= '}'
            {
            // InternalStoryGen.g:891:3: ( ( (lv_opening_0_0= 'opening' ) ) | ( (lv_ending_1_0= 'ending' ) ) )?
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==31) ) {
                alt13=1;
            }
            else if ( (LA13_0==32) ) {
                alt13=2;
            }
            switch (alt13) {
                case 1 :
                    // InternalStoryGen.g:892:4: ( (lv_opening_0_0= 'opening' ) )
                    {
                    // InternalStoryGen.g:892:4: ( (lv_opening_0_0= 'opening' ) )
                    // InternalStoryGen.g:893:5: (lv_opening_0_0= 'opening' )
                    {
                    // InternalStoryGen.g:893:5: (lv_opening_0_0= 'opening' )
                    // InternalStoryGen.g:894:6: lv_opening_0_0= 'opening'
                    {
                    lv_opening_0_0=(Token)match(input,31,FOLLOW_24); 

                    						newLeafNode(lv_opening_0_0, grammarAccess.getHappeningEventAccess().getOpeningOpeningKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHappeningEventRule());
                    						}
                    						setWithLastConsumed(current, "opening", true, "opening");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:907:4: ( (lv_ending_1_0= 'ending' ) )
                    {
                    // InternalStoryGen.g:907:4: ( (lv_ending_1_0= 'ending' ) )
                    // InternalStoryGen.g:908:5: (lv_ending_1_0= 'ending' )
                    {
                    // InternalStoryGen.g:908:5: (lv_ending_1_0= 'ending' )
                    // InternalStoryGen.g:909:6: lv_ending_1_0= 'ending'
                    {
                    lv_ending_1_0=(Token)match(input,32,FOLLOW_24); 

                    						newLeafNode(lv_ending_1_0, grammarAccess.getHappeningEventAccess().getEndingEndingKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHappeningEventRule());
                    						}
                    						setWithLastConsumed(current, "ending", true, "ending");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,33,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getHappeningEventAccess().getEventKeyword_1());
            		
            // InternalStoryGen.g:926:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalStoryGen.g:927:4: (lv_name_3_0= RULE_ID )
            {
            // InternalStoryGen.g:927:4: (lv_name_3_0= RULE_ID )
            // InternalStoryGen.g:928:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_3_0, grammarAccess.getHappeningEventAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHappeningEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_25); 

            			newLeafNode(otherlv_4, grammarAccess.getHappeningEventAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalStoryGen.g:948:3: (otherlv_5= 'priority:' ( (lv_priority_6_0= ruleEventPriority ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==34) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalStoryGen.g:949:4: otherlv_5= 'priority:' ( (lv_priority_6_0= ruleEventPriority ) )
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_26); 

                    				newLeafNode(otherlv_5, grammarAccess.getHappeningEventAccess().getPriorityKeyword_4_0());
                    			
                    // InternalStoryGen.g:953:4: ( (lv_priority_6_0= ruleEventPriority ) )
                    // InternalStoryGen.g:954:5: (lv_priority_6_0= ruleEventPriority )
                    {
                    // InternalStoryGen.g:954:5: (lv_priority_6_0= ruleEventPriority )
                    // InternalStoryGen.g:955:6: lv_priority_6_0= ruleEventPriority
                    {

                    						newCompositeNode(grammarAccess.getHappeningEventAccess().getPriorityEventPriorityEnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_priority_6_0=ruleEventPriority();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHappeningEventRule());
                    						}
                    						set(
                    							current,
                    							"priority",
                    							lv_priority_6_0,
                    							"br.ufes.inf.pg.StoryGen.EventPriority");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,35,FOLLOW_13); 

            			newLeafNode(otherlv_7, grammarAccess.getHappeningEventAccess().getDescriptionKeyword_5());
            		
            // InternalStoryGen.g:977:3: ( (lv_description_8_0= RULE_STRING ) )
            // InternalStoryGen.g:978:4: (lv_description_8_0= RULE_STRING )
            {
            // InternalStoryGen.g:978:4: (lv_description_8_0= RULE_STRING )
            // InternalStoryGen.g:979:5: lv_description_8_0= RULE_STRING
            {
            lv_description_8_0=(Token)match(input,RULE_STRING,FOLLOW_28); 

            					newLeafNode(lv_description_8_0, grammarAccess.getHappeningEventAccess().getDescriptionSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHappeningEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalStoryGen.g:995:3: (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==36) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalStoryGen.g:996:4: otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,36,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getHappeningEventAccess().getShortDescriptionKeyword_7_0());
                    			
                    // InternalStoryGen.g:1000:4: ( (lv_shortDescription_10_0= RULE_STRING ) )
                    // InternalStoryGen.g:1001:5: (lv_shortDescription_10_0= RULE_STRING )
                    {
                    // InternalStoryGen.g:1001:5: (lv_shortDescription_10_0= RULE_STRING )
                    // InternalStoryGen.g:1002:6: lv_shortDescription_10_0= RULE_STRING
                    {
                    lv_shortDescription_10_0=(Token)match(input,RULE_STRING,FOLLOW_29); 

                    						newLeafNode(lv_shortDescription_10_0, grammarAccess.getHappeningEventAccess().getShortDescriptionSTRINGTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHappeningEventRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"shortDescription",
                    							lv_shortDescription_10_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStoryGen.g:1019:3: (otherlv_11= 'triggers:' ( (otherlv_12= RULE_ID ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==37) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalStoryGen.g:1020:4: otherlv_11= 'triggers:' ( (otherlv_12= RULE_ID ) )
                    {
                    otherlv_11=(Token)match(input,37,FOLLOW_11); 

                    				newLeafNode(otherlv_11, grammarAccess.getHappeningEventAccess().getTriggersKeyword_8_0());
                    			
                    // InternalStoryGen.g:1024:4: ( (otherlv_12= RULE_ID ) )
                    // InternalStoryGen.g:1025:5: (otherlv_12= RULE_ID )
                    {
                    // InternalStoryGen.g:1025:5: (otherlv_12= RULE_ID )
                    // InternalStoryGen.g:1026:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHappeningEventRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(otherlv_12, grammarAccess.getHappeningEventAccess().getTriggerEventCrossReference_8_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStoryGen.g:1038:3: (otherlv_13= 'may-trigger:' ( ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' )* ( (otherlv_16= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==38) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalStoryGen.g:1039:4: otherlv_13= 'may-trigger:' ( ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' )* ( (otherlv_16= RULE_ID ) )
                    {
                    otherlv_13=(Token)match(input,38,FOLLOW_11); 

                    				newLeafNode(otherlv_13, grammarAccess.getHappeningEventAccess().getMayTriggerKeyword_9_0());
                    			
                    // InternalStoryGen.g:1043:4: ( ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID) ) {
                            int LA17_1 = input.LA(2);

                            if ( (LA17_1==39) ) {
                                alt17=1;
                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalStoryGen.g:1044:5: ( (otherlv_14= RULE_ID ) ) otherlv_15= ','
                    	    {
                    	    // InternalStoryGen.g:1044:5: ( (otherlv_14= RULE_ID ) )
                    	    // InternalStoryGen.g:1045:6: (otherlv_14= RULE_ID )
                    	    {
                    	    // InternalStoryGen.g:1045:6: (otherlv_14= RULE_ID )
                    	    // InternalStoryGen.g:1046:7: otherlv_14= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getHappeningEventRule());
                    	    							}
                    	    						
                    	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_31); 

                    	    							newLeafNode(otherlv_14, grammarAccess.getHappeningEventAccess().getMayTriggersEventCrossReference_9_1_0_0());
                    	    						

                    	    }


                    	    }

                    	    otherlv_15=(Token)match(input,39,FOLLOW_11); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getHappeningEventAccess().getCommaKeyword_9_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // InternalStoryGen.g:1062:4: ( (otherlv_16= RULE_ID ) )
                    // InternalStoryGen.g:1063:5: (otherlv_16= RULE_ID )
                    {
                    // InternalStoryGen.g:1063:5: (otherlv_16= RULE_ID )
                    // InternalStoryGen.g:1064:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHappeningEventRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_16, grammarAccess.getHappeningEventAccess().getMayTriggersEventCrossReference_9_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStoryGen.g:1076:3: ( (lv_conditions_17_0= ruleCondition ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==43) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalStoryGen.g:1077:4: (lv_conditions_17_0= ruleCondition )
            	    {
            	    // InternalStoryGen.g:1077:4: (lv_conditions_17_0= ruleCondition )
            	    // InternalStoryGen.g:1078:5: lv_conditions_17_0= ruleCondition
            	    {

            	    					newCompositeNode(grammarAccess.getHappeningEventAccess().getConditionsConditionParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_conditions_17_0=ruleCondition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHappeningEventRule());
            	    					}
            	    					add(
            	    						current,
            	    						"conditions",
            	    						lv_conditions_17_0,
            	    						"br.ufes.inf.pg.StoryGen.Condition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalStoryGen.g:1095:3: ( (lv_changes_18_0= ruleChange ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==45) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalStoryGen.g:1096:4: (lv_changes_18_0= ruleChange )
            	    {
            	    // InternalStoryGen.g:1096:4: (lv_changes_18_0= ruleChange )
            	    // InternalStoryGen.g:1097:5: lv_changes_18_0= ruleChange
            	    {

            	    					newCompositeNode(grammarAccess.getHappeningEventAccess().getChangesChangeParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_33);
            	    lv_changes_18_0=ruleChange();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHappeningEventRule());
            	    					}
            	    					add(
            	    						current,
            	    						"changes",
            	    						lv_changes_18_0,
            	    						"br.ufes.inf.pg.StoryGen.Change");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_19=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getHappeningEventAccess().getRightCurlyBracketKeyword_12());
            		

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
    // $ANTLR end "ruleHappeningEvent"


    // $ANTLR start "entryRuleActionEvent"
    // InternalStoryGen.g:1122:1: entryRuleActionEvent returns [EObject current=null] : iv_ruleActionEvent= ruleActionEvent EOF ;
    public final EObject entryRuleActionEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionEvent = null;


        try {
            // InternalStoryGen.g:1122:52: (iv_ruleActionEvent= ruleActionEvent EOF )
            // InternalStoryGen.g:1123:2: iv_ruleActionEvent= ruleActionEvent EOF
            {
             newCompositeNode(grammarAccess.getActionEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionEvent=ruleActionEvent();

            state._fsp--;

             current =iv_ruleActionEvent; 
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
    // $ANTLR end "entryRuleActionEvent"


    // $ANTLR start "ruleActionEvent"
    // InternalStoryGen.g:1129:1: ruleActionEvent returns [EObject current=null] : (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'priority:' ( (lv_priority_4_0= ruleEventPriority ) ) )? otherlv_5= 'type:' ( (lv_type_6_0= ruleActionType ) ) otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? otherlv_11= 'actor:' ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'triggers:' ( (otherlv_14= RULE_ID ) ) )? (otherlv_15= 'may-trigger:' ( ( (otherlv_16= RULE_ID ) ) otherlv_17= ',' )* ( (otherlv_18= RULE_ID ) ) )? ( (lv_conditions_19_0= ruleCondition ) )* ( (lv_changes_20_0= ruleChange ) )* otherlv_21= '}' ) ;
    public final EObject ruleActionEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_description_8_0=null;
        Token otherlv_9=null;
        Token lv_shortDescription_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_21=null;
        Enumerator lv_priority_4_0 = null;

        Enumerator lv_type_6_0 = null;

        EObject lv_conditions_19_0 = null;

        EObject lv_changes_20_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:1135:2: ( (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'priority:' ( (lv_priority_4_0= ruleEventPriority ) ) )? otherlv_5= 'type:' ( (lv_type_6_0= ruleActionType ) ) otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? otherlv_11= 'actor:' ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'triggers:' ( (otherlv_14= RULE_ID ) ) )? (otherlv_15= 'may-trigger:' ( ( (otherlv_16= RULE_ID ) ) otherlv_17= ',' )* ( (otherlv_18= RULE_ID ) ) )? ( (lv_conditions_19_0= ruleCondition ) )* ( (lv_changes_20_0= ruleChange ) )* otherlv_21= '}' ) )
            // InternalStoryGen.g:1136:2: (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'priority:' ( (lv_priority_4_0= ruleEventPriority ) ) )? otherlv_5= 'type:' ( (lv_type_6_0= ruleActionType ) ) otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? otherlv_11= 'actor:' ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'triggers:' ( (otherlv_14= RULE_ID ) ) )? (otherlv_15= 'may-trigger:' ( ( (otherlv_16= RULE_ID ) ) otherlv_17= ',' )* ( (otherlv_18= RULE_ID ) ) )? ( (lv_conditions_19_0= ruleCondition ) )* ( (lv_changes_20_0= ruleChange ) )* otherlv_21= '}' )
            {
            // InternalStoryGen.g:1136:2: (otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'priority:' ( (lv_priority_4_0= ruleEventPriority ) ) )? otherlv_5= 'type:' ( (lv_type_6_0= ruleActionType ) ) otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? otherlv_11= 'actor:' ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'triggers:' ( (otherlv_14= RULE_ID ) ) )? (otherlv_15= 'may-trigger:' ( ( (otherlv_16= RULE_ID ) ) otherlv_17= ',' )* ( (otherlv_18= RULE_ID ) ) )? ( (lv_conditions_19_0= ruleCondition ) )* ( (lv_changes_20_0= ruleChange ) )* otherlv_21= '}' )
            // InternalStoryGen.g:1137:3: otherlv_0= 'action' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'priority:' ( (lv_priority_4_0= ruleEventPriority ) ) )? otherlv_5= 'type:' ( (lv_type_6_0= ruleActionType ) ) otherlv_7= 'description:' ( (lv_description_8_0= RULE_STRING ) ) (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )? otherlv_11= 'actor:' ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'triggers:' ( (otherlv_14= RULE_ID ) ) )? (otherlv_15= 'may-trigger:' ( ( (otherlv_16= RULE_ID ) ) otherlv_17= ',' )* ( (otherlv_18= RULE_ID ) ) )? ( (lv_conditions_19_0= ruleCondition ) )* ( (lv_changes_20_0= ruleChange ) )* otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getActionEventAccess().getActionKeyword_0());
            		
            // InternalStoryGen.g:1141:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalStoryGen.g:1142:4: (lv_name_1_0= RULE_ID )
            {
            // InternalStoryGen.g:1142:4: (lv_name_1_0= RULE_ID )
            // InternalStoryGen.g:1143:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActionEventAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_34); 

            			newLeafNode(otherlv_2, grammarAccess.getActionEventAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalStoryGen.g:1163:3: (otherlv_3= 'priority:' ( (lv_priority_4_0= ruleEventPriority ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalStoryGen.g:1164:4: otherlv_3= 'priority:' ( (lv_priority_4_0= ruleEventPriority ) )
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_26); 

                    				newLeafNode(otherlv_3, grammarAccess.getActionEventAccess().getPriorityKeyword_3_0());
                    			
                    // InternalStoryGen.g:1168:4: ( (lv_priority_4_0= ruleEventPriority ) )
                    // InternalStoryGen.g:1169:5: (lv_priority_4_0= ruleEventPriority )
                    {
                    // InternalStoryGen.g:1169:5: (lv_priority_4_0= ruleEventPriority )
                    // InternalStoryGen.g:1170:6: lv_priority_4_0= ruleEventPriority
                    {

                    						newCompositeNode(grammarAccess.getActionEventAccess().getPriorityEventPriorityEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_priority_4_0=ruleEventPriority();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionEventRule());
                    						}
                    						set(
                    							current,
                    							"priority",
                    							lv_priority_4_0,
                    							"br.ufes.inf.pg.StoryGen.EventPriority");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,41,FOLLOW_36); 

            			newLeafNode(otherlv_5, grammarAccess.getActionEventAccess().getTypeKeyword_4());
            		
            // InternalStoryGen.g:1192:3: ( (lv_type_6_0= ruleActionType ) )
            // InternalStoryGen.g:1193:4: (lv_type_6_0= ruleActionType )
            {
            // InternalStoryGen.g:1193:4: (lv_type_6_0= ruleActionType )
            // InternalStoryGen.g:1194:5: lv_type_6_0= ruleActionType
            {

            					newCompositeNode(grammarAccess.getActionEventAccess().getTypeActionTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_27);
            lv_type_6_0=ruleActionType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionEventRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"br.ufes.inf.pg.StoryGen.ActionType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,35,FOLLOW_13); 

            			newLeafNode(otherlv_7, grammarAccess.getActionEventAccess().getDescriptionKeyword_6());
            		
            // InternalStoryGen.g:1215:3: ( (lv_description_8_0= RULE_STRING ) )
            // InternalStoryGen.g:1216:4: (lv_description_8_0= RULE_STRING )
            {
            // InternalStoryGen.g:1216:4: (lv_description_8_0= RULE_STRING )
            // InternalStoryGen.g:1217:5: lv_description_8_0= RULE_STRING
            {
            lv_description_8_0=(Token)match(input,RULE_STRING,FOLLOW_37); 

            					newLeafNode(lv_description_8_0, grammarAccess.getActionEventAccess().getDescriptionSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalStoryGen.g:1233:3: (otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==36) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalStoryGen.g:1234:4: otherlv_9= 'short-description:' ( (lv_shortDescription_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,36,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getActionEventAccess().getShortDescriptionKeyword_8_0());
                    			
                    // InternalStoryGen.g:1238:4: ( (lv_shortDescription_10_0= RULE_STRING ) )
                    // InternalStoryGen.g:1239:5: (lv_shortDescription_10_0= RULE_STRING )
                    {
                    // InternalStoryGen.g:1239:5: (lv_shortDescription_10_0= RULE_STRING )
                    // InternalStoryGen.g:1240:6: lv_shortDescription_10_0= RULE_STRING
                    {
                    lv_shortDescription_10_0=(Token)match(input,RULE_STRING,FOLLOW_38); 

                    						newLeafNode(lv_shortDescription_10_0, grammarAccess.getActionEventAccess().getShortDescriptionSTRINGTerminalRuleCall_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionEventRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"shortDescription",
                    							lv_shortDescription_10_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,42,FOLLOW_11); 

            			newLeafNode(otherlv_11, grammarAccess.getActionEventAccess().getActorKeyword_9());
            		
            // InternalStoryGen.g:1261:3: ( (otherlv_12= RULE_ID ) )
            // InternalStoryGen.g:1262:4: (otherlv_12= RULE_ID )
            {
            // InternalStoryGen.g:1262:4: (otherlv_12= RULE_ID )
            // InternalStoryGen.g:1263:5: otherlv_12= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionEventRule());
            					}
            				
            otherlv_12=(Token)match(input,RULE_ID,FOLLOW_29); 

            					newLeafNode(otherlv_12, grammarAccess.getActionEventAccess().getActorActorCrossReference_10_0());
            				

            }


            }

            // InternalStoryGen.g:1274:3: (otherlv_13= 'triggers:' ( (otherlv_14= RULE_ID ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==37) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalStoryGen.g:1275:4: otherlv_13= 'triggers:' ( (otherlv_14= RULE_ID ) )
                    {
                    otherlv_13=(Token)match(input,37,FOLLOW_11); 

                    				newLeafNode(otherlv_13, grammarAccess.getActionEventAccess().getTriggersKeyword_11_0());
                    			
                    // InternalStoryGen.g:1279:4: ( (otherlv_14= RULE_ID ) )
                    // InternalStoryGen.g:1280:5: (otherlv_14= RULE_ID )
                    {
                    // InternalStoryGen.g:1280:5: (otherlv_14= RULE_ID )
                    // InternalStoryGen.g:1281:6: otherlv_14= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionEventRule());
                    						}
                    					
                    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(otherlv_14, grammarAccess.getActionEventAccess().getTriggerEventCrossReference_11_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStoryGen.g:1293:3: (otherlv_15= 'may-trigger:' ( ( (otherlv_16= RULE_ID ) ) otherlv_17= ',' )* ( (otherlv_18= RULE_ID ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==38) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalStoryGen.g:1294:4: otherlv_15= 'may-trigger:' ( ( (otherlv_16= RULE_ID ) ) otherlv_17= ',' )* ( (otherlv_18= RULE_ID ) )
                    {
                    otherlv_15=(Token)match(input,38,FOLLOW_11); 

                    				newLeafNode(otherlv_15, grammarAccess.getActionEventAccess().getMayTriggerKeyword_12_0());
                    			
                    // InternalStoryGen.g:1298:4: ( ( (otherlv_16= RULE_ID ) ) otherlv_17= ',' )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_ID) ) {
                            int LA24_1 = input.LA(2);

                            if ( (LA24_1==39) ) {
                                alt24=1;
                            }


                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalStoryGen.g:1299:5: ( (otherlv_16= RULE_ID ) ) otherlv_17= ','
                    	    {
                    	    // InternalStoryGen.g:1299:5: ( (otherlv_16= RULE_ID ) )
                    	    // InternalStoryGen.g:1300:6: (otherlv_16= RULE_ID )
                    	    {
                    	    // InternalStoryGen.g:1300:6: (otherlv_16= RULE_ID )
                    	    // InternalStoryGen.g:1301:7: otherlv_16= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getActionEventRule());
                    	    							}
                    	    						
                    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_31); 

                    	    							newLeafNode(otherlv_16, grammarAccess.getActionEventAccess().getMayTriggersEventCrossReference_12_1_0_0());
                    	    						

                    	    }


                    	    }

                    	    otherlv_17=(Token)match(input,39,FOLLOW_11); 

                    	    					newLeafNode(otherlv_17, grammarAccess.getActionEventAccess().getCommaKeyword_12_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    // InternalStoryGen.g:1317:4: ( (otherlv_18= RULE_ID ) )
                    // InternalStoryGen.g:1318:5: (otherlv_18= RULE_ID )
                    {
                    // InternalStoryGen.g:1318:5: (otherlv_18= RULE_ID )
                    // InternalStoryGen.g:1319:6: otherlv_18= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionEventRule());
                    						}
                    					
                    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_18, grammarAccess.getActionEventAccess().getMayTriggersEventCrossReference_12_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalStoryGen.g:1331:3: ( (lv_conditions_19_0= ruleCondition ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==43) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalStoryGen.g:1332:4: (lv_conditions_19_0= ruleCondition )
            	    {
            	    // InternalStoryGen.g:1332:4: (lv_conditions_19_0= ruleCondition )
            	    // InternalStoryGen.g:1333:5: lv_conditions_19_0= ruleCondition
            	    {

            	    					newCompositeNode(grammarAccess.getActionEventAccess().getConditionsConditionParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_conditions_19_0=ruleCondition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActionEventRule());
            	    					}
            	    					add(
            	    						current,
            	    						"conditions",
            	    						lv_conditions_19_0,
            	    						"br.ufes.inf.pg.StoryGen.Condition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // InternalStoryGen.g:1350:3: ( (lv_changes_20_0= ruleChange ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==45) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalStoryGen.g:1351:4: (lv_changes_20_0= ruleChange )
            	    {
            	    // InternalStoryGen.g:1351:4: (lv_changes_20_0= ruleChange )
            	    // InternalStoryGen.g:1352:5: lv_changes_20_0= ruleChange
            	    {

            	    					newCompositeNode(grammarAccess.getActionEventAccess().getChangesChangeParserRuleCall_14_0());
            	    				
            	    pushFollow(FOLLOW_33);
            	    lv_changes_20_0=ruleChange();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActionEventRule());
            	    					}
            	    					add(
            	    						current,
            	    						"changes",
            	    						lv_changes_20_0,
            	    						"br.ufes.inf.pg.StoryGen.Change");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_21=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getActionEventAccess().getRightCurlyBracketKeyword_15());
            		

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
    // $ANTLR end "ruleActionEvent"


    // $ANTLR start "entryRuleCondition"
    // InternalStoryGen.g:1377:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalStoryGen.g:1377:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalStoryGen.g:1378:2: iv_ruleCondition= ruleCondition EOF
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
    // InternalStoryGen.g:1384:1: ruleCondition returns [EObject current=null] : (this_ExpressionCondition_0= ruleExpressionCondition | this_OrderCondition_1= ruleOrderCondition | this_TriggerCondition_2= ruleTriggerCondition ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        EObject this_ExpressionCondition_0 = null;

        EObject this_OrderCondition_1 = null;

        EObject this_TriggerCondition_2 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:1390:2: ( (this_ExpressionCondition_0= ruleExpressionCondition | this_OrderCondition_1= ruleOrderCondition | this_TriggerCondition_2= ruleTriggerCondition ) )
            // InternalStoryGen.g:1391:2: (this_ExpressionCondition_0= ruleExpressionCondition | this_OrderCondition_1= ruleOrderCondition | this_TriggerCondition_2= ruleTriggerCondition )
            {
            // InternalStoryGen.g:1391:2: (this_ExpressionCondition_0= ruleExpressionCondition | this_OrderCondition_1= ruleOrderCondition | this_TriggerCondition_2= ruleTriggerCondition )
            int alt28=3;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==43) ) {
                switch ( input.LA(2) ) {
                case 44:
                    {
                    alt28=3;
                    }
                    break;
                case RULE_ID:
                case RULE_INT:
                case 11:
                case 23:
                case 49:
                case 50:
                case 51:
                    {
                    alt28=1;
                    }
                    break;
                case 66:
                case 67:
                    {
                    alt28=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalStoryGen.g:1392:3: this_ExpressionCondition_0= ruleExpressionCondition
                    {

                    			newCompositeNode(grammarAccess.getConditionAccess().getExpressionConditionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExpressionCondition_0=ruleExpressionCondition();

                    state._fsp--;


                    			current = this_ExpressionCondition_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1401:3: this_OrderCondition_1= ruleOrderCondition
                    {

                    			newCompositeNode(grammarAccess.getConditionAccess().getOrderConditionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OrderCondition_1=ruleOrderCondition();

                    state._fsp--;


                    			current = this_OrderCondition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1410:3: this_TriggerCondition_2= ruleTriggerCondition
                    {

                    			newCompositeNode(grammarAccess.getConditionAccess().getTriggerConditionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_TriggerCondition_2=ruleTriggerCondition();

                    state._fsp--;


                    			current = this_TriggerCondition_2;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleExpressionCondition"
    // InternalStoryGen.g:1422:1: entryRuleExpressionCondition returns [EObject current=null] : iv_ruleExpressionCondition= ruleExpressionCondition EOF ;
    public final EObject entryRuleExpressionCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionCondition = null;


        try {
            // InternalStoryGen.g:1422:60: (iv_ruleExpressionCondition= ruleExpressionCondition EOF )
            // InternalStoryGen.g:1423:2: iv_ruleExpressionCondition= ruleExpressionCondition EOF
            {
             newCompositeNode(grammarAccess.getExpressionConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionCondition=ruleExpressionCondition();

            state._fsp--;

             current =iv_ruleExpressionCondition; 
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
    // $ANTLR end "entryRuleExpressionCondition"


    // $ANTLR start "ruleExpressionCondition"
    // InternalStoryGen.g:1429:1: ruleExpressionCondition returns [EObject current=null] : (otherlv_0= 'require:' ( (lv_exp_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExpressionCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:1435:2: ( (otherlv_0= 'require:' ( (lv_exp_1_0= ruleExpression ) ) ) )
            // InternalStoryGen.g:1436:2: (otherlv_0= 'require:' ( (lv_exp_1_0= ruleExpression ) ) )
            {
            // InternalStoryGen.g:1436:2: (otherlv_0= 'require:' ( (lv_exp_1_0= ruleExpression ) ) )
            // InternalStoryGen.g:1437:3: otherlv_0= 'require:' ( (lv_exp_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getExpressionConditionAccess().getRequireKeyword_0());
            		
            // InternalStoryGen.g:1441:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalStoryGen.g:1442:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalStoryGen.g:1442:4: (lv_exp_1_0= ruleExpression )
            // InternalStoryGen.g:1443:5: lv_exp_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getExpressionConditionAccess().getExpExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_1_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpressionConditionRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_1_0,
            						"br.ufes.inf.pg.StoryGen.Expression");
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
    // $ANTLR end "ruleExpressionCondition"


    // $ANTLR start "entryRuleOrderCondition"
    // InternalStoryGen.g:1464:1: entryRuleOrderCondition returns [EObject current=null] : iv_ruleOrderCondition= ruleOrderCondition EOF ;
    public final EObject entryRuleOrderCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrderCondition = null;


        try {
            // InternalStoryGen.g:1464:55: (iv_ruleOrderCondition= ruleOrderCondition EOF )
            // InternalStoryGen.g:1465:2: iv_ruleOrderCondition= ruleOrderCondition EOF
            {
             newCompositeNode(grammarAccess.getOrderConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrderCondition=ruleOrderCondition();

            state._fsp--;

             current =iv_ruleOrderCondition; 
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
    // $ANTLR end "entryRuleOrderCondition"


    // $ANTLR start "ruleOrderCondition"
    // InternalStoryGen.g:1471:1: ruleOrderCondition returns [EObject current=null] : (otherlv_0= 'require:' ( (lv_order_1_0= ruleOrder ) ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleOrderCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_order_1_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:1477:2: ( (otherlv_0= 'require:' ( (lv_order_1_0= ruleOrder ) ) ( (otherlv_2= RULE_ID ) ) ) )
            // InternalStoryGen.g:1478:2: (otherlv_0= 'require:' ( (lv_order_1_0= ruleOrder ) ) ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalStoryGen.g:1478:2: (otherlv_0= 'require:' ( (lv_order_1_0= ruleOrder ) ) ( (otherlv_2= RULE_ID ) ) )
            // InternalStoryGen.g:1479:3: otherlv_0= 'require:' ( (lv_order_1_0= ruleOrder ) ) ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_39); 

            			newLeafNode(otherlv_0, grammarAccess.getOrderConditionAccess().getRequireKeyword_0());
            		
            // InternalStoryGen.g:1483:3: ( (lv_order_1_0= ruleOrder ) )
            // InternalStoryGen.g:1484:4: (lv_order_1_0= ruleOrder )
            {
            // InternalStoryGen.g:1484:4: (lv_order_1_0= ruleOrder )
            // InternalStoryGen.g:1485:5: lv_order_1_0= ruleOrder
            {

            					newCompositeNode(grammarAccess.getOrderConditionAccess().getOrderOrderEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
            lv_order_1_0=ruleOrder();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrderConditionRule());
            					}
            					set(
            						current,
            						"order",
            						lv_order_1_0,
            						"br.ufes.inf.pg.StoryGen.Order");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:1502:3: ( (otherlv_2= RULE_ID ) )
            // InternalStoryGen.g:1503:4: (otherlv_2= RULE_ID )
            {
            // InternalStoryGen.g:1503:4: (otherlv_2= RULE_ID )
            // InternalStoryGen.g:1504:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOrderConditionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getOrderConditionAccess().getEventEventCrossReference_2_0());
            				

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
    // $ANTLR end "ruleOrderCondition"


    // $ANTLR start "entryRuleTriggerCondition"
    // InternalStoryGen.g:1519:1: entryRuleTriggerCondition returns [EObject current=null] : iv_ruleTriggerCondition= ruleTriggerCondition EOF ;
    public final EObject entryRuleTriggerCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerCondition = null;


        try {
            // InternalStoryGen.g:1519:57: (iv_ruleTriggerCondition= ruleTriggerCondition EOF )
            // InternalStoryGen.g:1520:2: iv_ruleTriggerCondition= ruleTriggerCondition EOF
            {
             newCompositeNode(grammarAccess.getTriggerConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTriggerCondition=ruleTriggerCondition();

            state._fsp--;

             current =iv_ruleTriggerCondition; 
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
    // $ANTLR end "entryRuleTriggerCondition"


    // $ANTLR start "ruleTriggerCondition"
    // InternalStoryGen.g:1526:1: ruleTriggerCondition returns [EObject current=null] : (otherlv_0= 'require:' ( (lv_trigger_1_0= 'be-triggered' ) ) ) ;
    public final EObject ruleTriggerCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_trigger_1_0=null;


        	enterRule();

        try {
            // InternalStoryGen.g:1532:2: ( (otherlv_0= 'require:' ( (lv_trigger_1_0= 'be-triggered' ) ) ) )
            // InternalStoryGen.g:1533:2: (otherlv_0= 'require:' ( (lv_trigger_1_0= 'be-triggered' ) ) )
            {
            // InternalStoryGen.g:1533:2: (otherlv_0= 'require:' ( (lv_trigger_1_0= 'be-triggered' ) ) )
            // InternalStoryGen.g:1534:3: otherlv_0= 'require:' ( (lv_trigger_1_0= 'be-triggered' ) )
            {
            otherlv_0=(Token)match(input,43,FOLLOW_40); 

            			newLeafNode(otherlv_0, grammarAccess.getTriggerConditionAccess().getRequireKeyword_0());
            		
            // InternalStoryGen.g:1538:3: ( (lv_trigger_1_0= 'be-triggered' ) )
            // InternalStoryGen.g:1539:4: (lv_trigger_1_0= 'be-triggered' )
            {
            // InternalStoryGen.g:1539:4: (lv_trigger_1_0= 'be-triggered' )
            // InternalStoryGen.g:1540:5: lv_trigger_1_0= 'be-triggered'
            {
            lv_trigger_1_0=(Token)match(input,44,FOLLOW_2); 

            					newLeafNode(lv_trigger_1_0, grammarAccess.getTriggerConditionAccess().getTriggerBeTriggeredKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTriggerConditionRule());
            					}
            					setWithLastConsumed(current, "trigger", true, "be-triggered");
            				

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
    // $ANTLR end "ruleTriggerCondition"


    // $ANTLR start "entryRuleChange"
    // InternalStoryGen.g:1556:1: entryRuleChange returns [EObject current=null] : iv_ruleChange= ruleChange EOF ;
    public final EObject entryRuleChange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChange = null;


        try {
            // InternalStoryGen.g:1556:47: (iv_ruleChange= ruleChange EOF )
            // InternalStoryGen.g:1557:2: iv_ruleChange= ruleChange EOF
            {
             newCompositeNode(grammarAccess.getChangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChange=ruleChange();

            state._fsp--;

             current =iv_ruleChange; 
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
    // $ANTLR end "entryRuleChange"


    // $ANTLR start "ruleChange"
    // InternalStoryGen.g:1563:1: ruleChange returns [EObject current=null] : (this_ExistentChange_0= ruleExistentChange | this_StoryDataChange_1= ruleStoryDataChange ) ;
    public final EObject ruleChange() throws RecognitionException {
        EObject current = null;

        EObject this_ExistentChange_0 = null;

        EObject this_StoryDataChange_1 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:1569:2: ( (this_ExistentChange_0= ruleExistentChange | this_StoryDataChange_1= ruleStoryDataChange ) )
            // InternalStoryGen.g:1570:2: (this_ExistentChange_0= ruleExistentChange | this_StoryDataChange_1= ruleStoryDataChange )
            {
            // InternalStoryGen.g:1570:2: (this_ExistentChange_0= ruleExistentChange | this_StoryDataChange_1= ruleStoryDataChange )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==45) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==RULE_ID) ) {
                    alt29=1;
                }
                else if ( (LA29_1==11) ) {
                    alt29=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalStoryGen.g:1571:3: this_ExistentChange_0= ruleExistentChange
                    {

                    			newCompositeNode(grammarAccess.getChangeAccess().getExistentChangeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExistentChange_0=ruleExistentChange();

                    state._fsp--;


                    			current = this_ExistentChange_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1580:3: this_StoryDataChange_1= ruleStoryDataChange
                    {

                    			newCompositeNode(grammarAccess.getChangeAccess().getStoryDataChangeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StoryDataChange_1=ruleStoryDataChange();

                    state._fsp--;


                    			current = this_StoryDataChange_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleChange"


    // $ANTLR start "entryRuleExistentChange"
    // InternalStoryGen.g:1592:1: entryRuleExistentChange returns [EObject current=null] : iv_ruleExistentChange= ruleExistentChange EOF ;
    public final EObject entryRuleExistentChange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExistentChange = null;


        try {
            // InternalStoryGen.g:1592:55: (iv_ruleExistentChange= ruleExistentChange EOF )
            // InternalStoryGen.g:1593:2: iv_ruleExistentChange= ruleExistentChange EOF
            {
             newCompositeNode(grammarAccess.getExistentChangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExistentChange=ruleExistentChange();

            state._fsp--;

             current =iv_ruleExistentChange; 
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
    // $ANTLR end "entryRuleExistentChange"


    // $ANTLR start "ruleExistentChange"
    // InternalStoryGen.g:1599:1: ruleExistentChange returns [EObject current=null] : (otherlv_0= 'change:' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) ) ) ;
    public final EObject ruleExistentChange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_op_4_0 = null;

        EObject lv_term_5_1 = null;

        EObject lv_term_5_2 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:1605:2: ( (otherlv_0= 'change:' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) ) ) )
            // InternalStoryGen.g:1606:2: (otherlv_0= 'change:' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) ) )
            {
            // InternalStoryGen.g:1606:2: (otherlv_0= 'change:' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) ) )
            // InternalStoryGen.g:1607:3: otherlv_0= 'change:' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getExistentChangeAccess().getChangeKeyword_0());
            		
            // InternalStoryGen.g:1611:3: ( (otherlv_1= RULE_ID ) )
            // InternalStoryGen.g:1612:4: (otherlv_1= RULE_ID )
            {
            // InternalStoryGen.g:1612:4: (otherlv_1= RULE_ID )
            // InternalStoryGen.g:1613:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExistentChangeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(otherlv_1, grammarAccess.getExistentChangeAccess().getExistentExistentCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getExistentChangeAccess().getFullStopKeyword_2());
            		
            // InternalStoryGen.g:1628:3: ( (otherlv_3= RULE_ID ) )
            // InternalStoryGen.g:1629:4: (otherlv_3= RULE_ID )
            {
            // InternalStoryGen.g:1629:4: (otherlv_3= RULE_ID )
            // InternalStoryGen.g:1630:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExistentChangeRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_3, grammarAccess.getExistentChangeAccess().getAttributeAttributeCrossReference_3_0());
            				

            }


            }

            // InternalStoryGen.g:1641:3: ( (lv_op_4_0= ruleAttributionOperator ) )
            // InternalStoryGen.g:1642:4: (lv_op_4_0= ruleAttributionOperator )
            {
            // InternalStoryGen.g:1642:4: (lv_op_4_0= ruleAttributionOperator )
            // InternalStoryGen.g:1643:5: lv_op_4_0= ruleAttributionOperator
            {

            					newCompositeNode(grammarAccess.getExistentChangeAccess().getOpAttributionOperatorEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_43);
            lv_op_4_0=ruleAttributionOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistentChangeRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_4_0,
            						"br.ufes.inf.pg.StoryGen.AttributionOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:1660:3: ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) )
            // InternalStoryGen.g:1661:4: ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) )
            {
            // InternalStoryGen.g:1661:4: ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) )
            // InternalStoryGen.g:1662:5: (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm )
            {
            // InternalStoryGen.g:1662:5: (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_INT) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=50 && LA30_0<=51)) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalStoryGen.g:1663:6: lv_term_5_1= ruleIntegerTerm
                    {

                    						newCompositeNode(grammarAccess.getExistentChangeAccess().getTermIntegerTermParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_term_5_1=ruleIntegerTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExistentChangeRule());
                    						}
                    						set(
                    							current,
                    							"term",
                    							lv_term_5_1,
                    							"br.ufes.inf.pg.StoryGen.IntegerTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1679:6: lv_term_5_2= ruleBooleanTerm
                    {

                    						newCompositeNode(grammarAccess.getExistentChangeAccess().getTermBooleanTermParserRuleCall_5_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_term_5_2=ruleBooleanTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExistentChangeRule());
                    						}
                    						set(
                    							current,
                    							"term",
                    							lv_term_5_2,
                    							"br.ufes.inf.pg.StoryGen.BooleanTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


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
    // $ANTLR end "ruleExistentChange"


    // $ANTLR start "entryRuleStoryDataChange"
    // InternalStoryGen.g:1701:1: entryRuleStoryDataChange returns [EObject current=null] : iv_ruleStoryDataChange= ruleStoryDataChange EOF ;
    public final EObject entryRuleStoryDataChange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStoryDataChange = null;


        try {
            // InternalStoryGen.g:1701:56: (iv_ruleStoryDataChange= ruleStoryDataChange EOF )
            // InternalStoryGen.g:1702:2: iv_ruleStoryDataChange= ruleStoryDataChange EOF
            {
             newCompositeNode(grammarAccess.getStoryDataChangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStoryDataChange=ruleStoryDataChange();

            state._fsp--;

             current =iv_ruleStoryDataChange; 
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
    // $ANTLR end "entryRuleStoryDataChange"


    // $ANTLR start "ruleStoryDataChange"
    // InternalStoryGen.g:1708:1: ruleStoryDataChange returns [EObject current=null] : (otherlv_0= 'change:' otherlv_1= 'Story' otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) ) ) ;
    public final EObject ruleStoryDataChange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_op_4_0 = null;

        EObject lv_term_5_1 = null;

        EObject lv_term_5_2 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:1714:2: ( (otherlv_0= 'change:' otherlv_1= 'Story' otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) ) ) )
            // InternalStoryGen.g:1715:2: (otherlv_0= 'change:' otherlv_1= 'Story' otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) ) )
            {
            // InternalStoryGen.g:1715:2: (otherlv_0= 'change:' otherlv_1= 'Story' otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) ) )
            // InternalStoryGen.g:1716:3: otherlv_0= 'change:' otherlv_1= 'Story' otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( (lv_op_4_0= ruleAttributionOperator ) ) ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_44); 

            			newLeafNode(otherlv_0, grammarAccess.getStoryDataChangeAccess().getChangeKeyword_0());
            		
            otherlv_1=(Token)match(input,11,FOLLOW_41); 

            			newLeafNode(otherlv_1, grammarAccess.getStoryDataChangeAccess().getStoryKeyword_1());
            		
            otherlv_2=(Token)match(input,46,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getStoryDataChangeAccess().getFullStopKeyword_2());
            		
            // InternalStoryGen.g:1728:3: ( (otherlv_3= RULE_ID ) )
            // InternalStoryGen.g:1729:4: (otherlv_3= RULE_ID )
            {
            // InternalStoryGen.g:1729:4: (otherlv_3= RULE_ID )
            // InternalStoryGen.g:1730:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStoryDataChangeRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_3, grammarAccess.getStoryDataChangeAccess().getAttributeAttributeCrossReference_3_0());
            				

            }


            }

            // InternalStoryGen.g:1741:3: ( (lv_op_4_0= ruleAttributionOperator ) )
            // InternalStoryGen.g:1742:4: (lv_op_4_0= ruleAttributionOperator )
            {
            // InternalStoryGen.g:1742:4: (lv_op_4_0= ruleAttributionOperator )
            // InternalStoryGen.g:1743:5: lv_op_4_0= ruleAttributionOperator
            {

            					newCompositeNode(grammarAccess.getStoryDataChangeAccess().getOpAttributionOperatorEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_43);
            lv_op_4_0=ruleAttributionOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStoryDataChangeRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_4_0,
            						"br.ufes.inf.pg.StoryGen.AttributionOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalStoryGen.g:1760:3: ( ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) ) )
            // InternalStoryGen.g:1761:4: ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) )
            {
            // InternalStoryGen.g:1761:4: ( (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm ) )
            // InternalStoryGen.g:1762:5: (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm )
            {
            // InternalStoryGen.g:1762:5: (lv_term_5_1= ruleIntegerTerm | lv_term_5_2= ruleBooleanTerm )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_INT) ) {
                alt31=1;
            }
            else if ( ((LA31_0>=50 && LA31_0<=51)) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalStoryGen.g:1763:6: lv_term_5_1= ruleIntegerTerm
                    {

                    						newCompositeNode(grammarAccess.getStoryDataChangeAccess().getTermIntegerTermParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_term_5_1=ruleIntegerTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStoryDataChangeRule());
                    						}
                    						set(
                    							current,
                    							"term",
                    							lv_term_5_1,
                    							"br.ufes.inf.pg.StoryGen.IntegerTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1779:6: lv_term_5_2= ruleBooleanTerm
                    {

                    						newCompositeNode(grammarAccess.getStoryDataChangeAccess().getTermBooleanTermParserRuleCall_5_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_term_5_2=ruleBooleanTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStoryDataChangeRule());
                    						}
                    						set(
                    							current,
                    							"term",
                    							lv_term_5_2,
                    							"br.ufes.inf.pg.StoryGen.BooleanTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


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
    // $ANTLR end "ruleStoryDataChange"


    // $ANTLR start "entryRuleExpression"
    // InternalStoryGen.g:1801:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalStoryGen.g:1801:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalStoryGen.g:1802:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalStoryGen.g:1808:1: ruleExpression returns [EObject current=null] : this_BinaryExpression_0= ruleBinaryExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BinaryExpression_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:1814:2: (this_BinaryExpression_0= ruleBinaryExpression )
            // InternalStoryGen.g:1815:2: this_BinaryExpression_0= ruleBinaryExpression
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getBinaryExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_BinaryExpression_0=ruleBinaryExpression();

            state._fsp--;


            		current = this_BinaryExpression_0;
            		afterParserOrEnumRuleCall();
            	

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleBinaryExpression"
    // InternalStoryGen.g:1826:1: entryRuleBinaryExpression returns [EObject current=null] : iv_ruleBinaryExpression= ruleBinaryExpression EOF ;
    public final EObject entryRuleBinaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryExpression = null;


        try {
            // InternalStoryGen.g:1826:57: (iv_ruleBinaryExpression= ruleBinaryExpression EOF )
            // InternalStoryGen.g:1827:2: iv_ruleBinaryExpression= ruleBinaryExpression EOF
            {
             newCompositeNode(grammarAccess.getBinaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryExpression=ruleBinaryExpression();

            state._fsp--;

             current =iv_ruleBinaryExpression; 
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
    // $ANTLR end "entryRuleBinaryExpression"


    // $ANTLR start "ruleBinaryExpression"
    // InternalStoryGen.g:1833:1: ruleBinaryExpression returns [EObject current=null] : (this_UnitExpression_0= ruleUnitExpression ( ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleUnitExpression ) ) (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )* ) | ( () otherlv_7= 'and' ( (lv_operands_8_0= ruleUnitExpression ) ) (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )* ) | ( () ( (lv_operator_12_0= ruleComparisonOperator ) ) ( (lv_right_13_0= ruleUnitExpression ) ) ) )? ) ;
    public final EObject ruleBinaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject this_UnitExpression_0 = null;

        EObject lv_operands_3_0 = null;

        EObject lv_operands_5_0 = null;

        EObject lv_operands_8_0 = null;

        EObject lv_operands_10_0 = null;

        Enumerator lv_operator_12_0 = null;

        EObject lv_right_13_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:1839:2: ( (this_UnitExpression_0= ruleUnitExpression ( ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleUnitExpression ) ) (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )* ) | ( () otherlv_7= 'and' ( (lv_operands_8_0= ruleUnitExpression ) ) (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )* ) | ( () ( (lv_operator_12_0= ruleComparisonOperator ) ) ( (lv_right_13_0= ruleUnitExpression ) ) ) )? ) )
            // InternalStoryGen.g:1840:2: (this_UnitExpression_0= ruleUnitExpression ( ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleUnitExpression ) ) (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )* ) | ( () otherlv_7= 'and' ( (lv_operands_8_0= ruleUnitExpression ) ) (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )* ) | ( () ( (lv_operator_12_0= ruleComparisonOperator ) ) ( (lv_right_13_0= ruleUnitExpression ) ) ) )? )
            {
            // InternalStoryGen.g:1840:2: (this_UnitExpression_0= ruleUnitExpression ( ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleUnitExpression ) ) (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )* ) | ( () otherlv_7= 'and' ( (lv_operands_8_0= ruleUnitExpression ) ) (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )* ) | ( () ( (lv_operator_12_0= ruleComparisonOperator ) ) ( (lv_right_13_0= ruleUnitExpression ) ) ) )? )
            // InternalStoryGen.g:1841:3: this_UnitExpression_0= ruleUnitExpression ( ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleUnitExpression ) ) (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )* ) | ( () otherlv_7= 'and' ( (lv_operands_8_0= ruleUnitExpression ) ) (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )* ) | ( () ( (lv_operator_12_0= ruleComparisonOperator ) ) ( (lv_right_13_0= ruleUnitExpression ) ) ) )?
            {

            			newCompositeNode(grammarAccess.getBinaryExpressionAccess().getUnitExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_45);
            this_UnitExpression_0=ruleUnitExpression();

            state._fsp--;


            			current = this_UnitExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalStoryGen.g:1849:3: ( ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleUnitExpression ) ) (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )* ) | ( () otherlv_7= 'and' ( (lv_operands_8_0= ruleUnitExpression ) ) (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )* ) | ( () ( (lv_operator_12_0= ruleComparisonOperator ) ) ( (lv_right_13_0= ruleUnitExpression ) ) ) )?
            int alt34=4;
            switch ( input.LA(1) ) {
                case 47:
                    {
                    alt34=1;
                    }
                    break;
                case 48:
                    {
                    alt34=2;
                    }
                    break;
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                    {
                    alt34=3;
                    }
                    break;
            }

            switch (alt34) {
                case 1 :
                    // InternalStoryGen.g:1850:4: ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleUnitExpression ) ) (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )* )
                    {
                    // InternalStoryGen.g:1850:4: ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleUnitExpression ) ) (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )* )
                    // InternalStoryGen.g:1851:5: () otherlv_2= 'or' ( (lv_operands_3_0= ruleUnitExpression ) ) (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )*
                    {
                    // InternalStoryGen.g:1851:5: ()
                    // InternalStoryGen.g:1852:6: 
                    {

                    						current = forceCreateModelElementAndAdd(
                    							grammarAccess.getBinaryExpressionAccess().getOrExpressionOperandsAction_1_0_0(),
                    							current);
                    					

                    }

                    otherlv_2=(Token)match(input,47,FOLLOW_16); 

                    					newLeafNode(otherlv_2, grammarAccess.getBinaryExpressionAccess().getOrKeyword_1_0_1());
                    				
                    // InternalStoryGen.g:1862:5: ( (lv_operands_3_0= ruleUnitExpression ) )
                    // InternalStoryGen.g:1863:6: (lv_operands_3_0= ruleUnitExpression )
                    {
                    // InternalStoryGen.g:1863:6: (lv_operands_3_0= ruleUnitExpression )
                    // InternalStoryGen.g:1864:7: lv_operands_3_0= ruleUnitExpression
                    {

                    							newCompositeNode(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_0_2_0());
                    						
                    pushFollow(FOLLOW_46);
                    lv_operands_3_0=ruleUnitExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getBinaryExpressionRule());
                    							}
                    							add(
                    								current,
                    								"operands",
                    								lv_operands_3_0,
                    								"br.ufes.inf.pg.StoryGen.UnitExpression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalStoryGen.g:1881:5: (otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==47) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalStoryGen.g:1882:6: otherlv_4= 'or' ( (lv_operands_5_0= ruleUnitExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,47,FOLLOW_16); 

                    	    						newLeafNode(otherlv_4, grammarAccess.getBinaryExpressionAccess().getOrKeyword_1_0_3_0());
                    	    					
                    	    // InternalStoryGen.g:1886:6: ( (lv_operands_5_0= ruleUnitExpression ) )
                    	    // InternalStoryGen.g:1887:7: (lv_operands_5_0= ruleUnitExpression )
                    	    {
                    	    // InternalStoryGen.g:1887:7: (lv_operands_5_0= ruleUnitExpression )
                    	    // InternalStoryGen.g:1888:8: lv_operands_5_0= ruleUnitExpression
                    	    {

                    	    								newCompositeNode(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_0_3_1_0());
                    	    							
                    	    pushFollow(FOLLOW_46);
                    	    lv_operands_5_0=ruleUnitExpression();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getBinaryExpressionRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"operands",
                    	    									lv_operands_5_0,
                    	    									"br.ufes.inf.pg.StoryGen.UnitExpression");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1908:4: ( () otherlv_7= 'and' ( (lv_operands_8_0= ruleUnitExpression ) ) (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )* )
                    {
                    // InternalStoryGen.g:1908:4: ( () otherlv_7= 'and' ( (lv_operands_8_0= ruleUnitExpression ) ) (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )* )
                    // InternalStoryGen.g:1909:5: () otherlv_7= 'and' ( (lv_operands_8_0= ruleUnitExpression ) ) (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )*
                    {
                    // InternalStoryGen.g:1909:5: ()
                    // InternalStoryGen.g:1910:6: 
                    {

                    						current = forceCreateModelElementAndAdd(
                    							grammarAccess.getBinaryExpressionAccess().getAndExpressionOperandsAction_1_1_0(),
                    							current);
                    					

                    }

                    otherlv_7=(Token)match(input,48,FOLLOW_16); 

                    					newLeafNode(otherlv_7, grammarAccess.getBinaryExpressionAccess().getAndKeyword_1_1_1());
                    				
                    // InternalStoryGen.g:1920:5: ( (lv_operands_8_0= ruleUnitExpression ) )
                    // InternalStoryGen.g:1921:6: (lv_operands_8_0= ruleUnitExpression )
                    {
                    // InternalStoryGen.g:1921:6: (lv_operands_8_0= ruleUnitExpression )
                    // InternalStoryGen.g:1922:7: lv_operands_8_0= ruleUnitExpression
                    {

                    							newCompositeNode(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_1_2_0());
                    						
                    pushFollow(FOLLOW_47);
                    lv_operands_8_0=ruleUnitExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getBinaryExpressionRule());
                    							}
                    							add(
                    								current,
                    								"operands",
                    								lv_operands_8_0,
                    								"br.ufes.inf.pg.StoryGen.UnitExpression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalStoryGen.g:1939:5: (otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==48) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalStoryGen.g:1940:6: otherlv_9= 'and' ( (lv_operands_10_0= ruleUnitExpression ) )
                    	    {
                    	    otherlv_9=(Token)match(input,48,FOLLOW_16); 

                    	    						newLeafNode(otherlv_9, grammarAccess.getBinaryExpressionAccess().getAndKeyword_1_1_3_0());
                    	    					
                    	    // InternalStoryGen.g:1944:6: ( (lv_operands_10_0= ruleUnitExpression ) )
                    	    // InternalStoryGen.g:1945:7: (lv_operands_10_0= ruleUnitExpression )
                    	    {
                    	    // InternalStoryGen.g:1945:7: (lv_operands_10_0= ruleUnitExpression )
                    	    // InternalStoryGen.g:1946:8: lv_operands_10_0= ruleUnitExpression
                    	    {

                    	    								newCompositeNode(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_1_3_1_0());
                    	    							
                    	    pushFollow(FOLLOW_47);
                    	    lv_operands_10_0=ruleUnitExpression();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getBinaryExpressionRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"operands",
                    	    									lv_operands_10_0,
                    	    									"br.ufes.inf.pg.StoryGen.UnitExpression");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1966:4: ( () ( (lv_operator_12_0= ruleComparisonOperator ) ) ( (lv_right_13_0= ruleUnitExpression ) ) )
                    {
                    // InternalStoryGen.g:1966:4: ( () ( (lv_operator_12_0= ruleComparisonOperator ) ) ( (lv_right_13_0= ruleUnitExpression ) ) )
                    // InternalStoryGen.g:1967:5: () ( (lv_operator_12_0= ruleComparisonOperator ) ) ( (lv_right_13_0= ruleUnitExpression ) )
                    {
                    // InternalStoryGen.g:1967:5: ()
                    // InternalStoryGen.g:1968:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getBinaryExpressionAccess().getComparisonExpressionLeftAction_1_2_0(),
                    							current);
                    					

                    }

                    // InternalStoryGen.g:1974:5: ( (lv_operator_12_0= ruleComparisonOperator ) )
                    // InternalStoryGen.g:1975:6: (lv_operator_12_0= ruleComparisonOperator )
                    {
                    // InternalStoryGen.g:1975:6: (lv_operator_12_0= ruleComparisonOperator )
                    // InternalStoryGen.g:1976:7: lv_operator_12_0= ruleComparisonOperator
                    {

                    							newCompositeNode(grammarAccess.getBinaryExpressionAccess().getOperatorComparisonOperatorEnumRuleCall_1_2_1_0());
                    						
                    pushFollow(FOLLOW_16);
                    lv_operator_12_0=ruleComparisonOperator();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getBinaryExpressionRule());
                    							}
                    							set(
                    								current,
                    								"operator",
                    								lv_operator_12_0,
                    								"br.ufes.inf.pg.StoryGen.ComparisonOperator");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalStoryGen.g:1993:5: ( (lv_right_13_0= ruleUnitExpression ) )
                    // InternalStoryGen.g:1994:6: (lv_right_13_0= ruleUnitExpression )
                    {
                    // InternalStoryGen.g:1994:6: (lv_right_13_0= ruleUnitExpression )
                    // InternalStoryGen.g:1995:7: lv_right_13_0= ruleUnitExpression
                    {

                    							newCompositeNode(grammarAccess.getBinaryExpressionAccess().getRightUnitExpressionParserRuleCall_1_2_2_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_right_13_0=ruleUnitExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getBinaryExpressionRule());
                    							}
                    							set(
                    								current,
                    								"right",
                    								lv_right_13_0,
                    								"br.ufes.inf.pg.StoryGen.UnitExpression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleBinaryExpression"


    // $ANTLR start "entryRuleUnitExpression"
    // InternalStoryGen.g:2018:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // InternalStoryGen.g:2018:55: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // InternalStoryGen.g:2019:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
             newCompositeNode(grammarAccess.getUnitExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitExpression=ruleUnitExpression();

            state._fsp--;

             current =iv_ruleUnitExpression; 
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
    // $ANTLR end "entryRuleUnitExpression"


    // $ANTLR start "ruleUnitExpression"
    // InternalStoryGen.g:2025:1: ruleUnitExpression returns [EObject current=null] : (this_NegationExpression_0= ruleNegationExpression | this_UnitaryExpression_1= ruleUnitaryExpression ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NegationExpression_0 = null;

        EObject this_UnitaryExpression_1 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:2031:2: ( (this_NegationExpression_0= ruleNegationExpression | this_UnitaryExpression_1= ruleUnitaryExpression ) )
            // InternalStoryGen.g:2032:2: (this_NegationExpression_0= ruleNegationExpression | this_UnitaryExpression_1= ruleUnitaryExpression )
            {
            // InternalStoryGen.g:2032:2: (this_NegationExpression_0= ruleNegationExpression | this_UnitaryExpression_1= ruleUnitaryExpression )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==49) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_ID||LA35_0==RULE_INT||LA35_0==11||LA35_0==23||(LA35_0>=50 && LA35_0<=51)) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalStoryGen.g:2033:3: this_NegationExpression_0= ruleNegationExpression
                    {

                    			newCompositeNode(grammarAccess.getUnitExpressionAccess().getNegationExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NegationExpression_0=ruleNegationExpression();

                    state._fsp--;


                    			current = this_NegationExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2042:3: this_UnitaryExpression_1= ruleUnitaryExpression
                    {

                    			newCompositeNode(grammarAccess.getUnitExpressionAccess().getUnitaryExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitaryExpression_1=ruleUnitaryExpression();

                    state._fsp--;


                    			current = this_UnitaryExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleUnitExpression"


    // $ANTLR start "entryRuleNegationExpression"
    // InternalStoryGen.g:2054:1: entryRuleNegationExpression returns [EObject current=null] : iv_ruleNegationExpression= ruleNegationExpression EOF ;
    public final EObject entryRuleNegationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegationExpression = null;


        try {
            // InternalStoryGen.g:2054:59: (iv_ruleNegationExpression= ruleNegationExpression EOF )
            // InternalStoryGen.g:2055:2: iv_ruleNegationExpression= ruleNegationExpression EOF
            {
             newCompositeNode(grammarAccess.getNegationExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNegationExpression=ruleNegationExpression();

            state._fsp--;

             current =iv_ruleNegationExpression; 
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
    // $ANTLR end "entryRuleNegationExpression"


    // $ANTLR start "ruleNegationExpression"
    // InternalStoryGen.g:2061:1: ruleNegationExpression returns [EObject current=null] : ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleUnitExpression ) ) ) ;
    public final EObject ruleNegationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand_2_0 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:2067:2: ( ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleUnitExpression ) ) ) )
            // InternalStoryGen.g:2068:2: ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleUnitExpression ) ) )
            {
            // InternalStoryGen.g:2068:2: ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleUnitExpression ) ) )
            // InternalStoryGen.g:2069:3: () otherlv_1= 'not' ( (lv_operand_2_0= ruleUnitExpression ) )
            {
            // InternalStoryGen.g:2069:3: ()
            // InternalStoryGen.g:2070:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNegationExpressionAccess().getNegationExpressionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,49,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getNegationExpressionAccess().getNotKeyword_1());
            		
            // InternalStoryGen.g:2080:3: ( (lv_operand_2_0= ruleUnitExpression ) )
            // InternalStoryGen.g:2081:4: (lv_operand_2_0= ruleUnitExpression )
            {
            // InternalStoryGen.g:2081:4: (lv_operand_2_0= ruleUnitExpression )
            // InternalStoryGen.g:2082:5: lv_operand_2_0= ruleUnitExpression
            {

            					newCompositeNode(grammarAccess.getNegationExpressionAccess().getOperandUnitExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_operand_2_0=ruleUnitExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNegationExpressionRule());
            					}
            					set(
            						current,
            						"operand",
            						lv_operand_2_0,
            						"br.ufes.inf.pg.StoryGen.UnitExpression");
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
    // $ANTLR end "ruleNegationExpression"


    // $ANTLR start "entryRuleUnitaryExpression"
    // InternalStoryGen.g:2103:1: entryRuleUnitaryExpression returns [EObject current=null] : iv_ruleUnitaryExpression= ruleUnitaryExpression EOF ;
    public final EObject entryRuleUnitaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitaryExpression = null;


        try {
            // InternalStoryGen.g:2103:58: (iv_ruleUnitaryExpression= ruleUnitaryExpression EOF )
            // InternalStoryGen.g:2104:2: iv_ruleUnitaryExpression= ruleUnitaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnitaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitaryExpression=ruleUnitaryExpression();

            state._fsp--;

             current =iv_ruleUnitaryExpression; 
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
    // $ANTLR end "entryRuleUnitaryExpression"


    // $ANTLR start "ruleUnitaryExpression"
    // InternalStoryGen.g:2110:1: ruleUnitaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Term_3= ruleTerm ) ;
    public final EObject ruleUnitaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;

        EObject this_Term_3 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:2116:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Term_3= ruleTerm ) )
            // InternalStoryGen.g:2117:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Term_3= ruleTerm )
            {
            // InternalStoryGen.g:2117:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Term_3= ruleTerm )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==23) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_ID||LA36_0==RULE_INT||LA36_0==11||(LA36_0>=50 && LA36_0<=51)) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalStoryGen.g:2118:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalStoryGen.g:2118:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalStoryGen.g:2119:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_16); 

                    				newLeafNode(otherlv_0, grammarAccess.getUnitaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getUnitaryExpressionAccess().getExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_17);
                    this_Expression_1=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,24,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getUnitaryExpressionAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2137:3: this_Term_3= ruleTerm
                    {

                    			newCompositeNode(grammarAccess.getUnitaryExpressionAccess().getTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Term_3=ruleTerm();

                    state._fsp--;


                    			current = this_Term_3;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleUnitaryExpression"


    // $ANTLR start "entryRuleTerm"
    // InternalStoryGen.g:2149:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalStoryGen.g:2149:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalStoryGen.g:2150:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalStoryGen.g:2156:1: ruleTerm returns [EObject current=null] : (this_ExistentAttributeTerm_0= ruleExistentAttributeTerm | this_StoryAttributeTerm_1= ruleStoryAttributeTerm | this_IntegerTerm_2= ruleIntegerTerm | this_BooleanTerm_3= ruleBooleanTerm ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_ExistentAttributeTerm_0 = null;

        EObject this_StoryAttributeTerm_1 = null;

        EObject this_IntegerTerm_2 = null;

        EObject this_BooleanTerm_3 = null;



        	enterRule();

        try {
            // InternalStoryGen.g:2162:2: ( (this_ExistentAttributeTerm_0= ruleExistentAttributeTerm | this_StoryAttributeTerm_1= ruleStoryAttributeTerm | this_IntegerTerm_2= ruleIntegerTerm | this_BooleanTerm_3= ruleBooleanTerm ) )
            // InternalStoryGen.g:2163:2: (this_ExistentAttributeTerm_0= ruleExistentAttributeTerm | this_StoryAttributeTerm_1= ruleStoryAttributeTerm | this_IntegerTerm_2= ruleIntegerTerm | this_BooleanTerm_3= ruleBooleanTerm )
            {
            // InternalStoryGen.g:2163:2: (this_ExistentAttributeTerm_0= ruleExistentAttributeTerm | this_StoryAttributeTerm_1= ruleStoryAttributeTerm | this_IntegerTerm_2= ruleIntegerTerm | this_BooleanTerm_3= ruleBooleanTerm )
            int alt37=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt37=1;
                }
                break;
            case 11:
                {
                alt37=2;
                }
                break;
            case RULE_INT:
                {
                alt37=3;
                }
                break;
            case 50:
            case 51:
                {
                alt37=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalStoryGen.g:2164:3: this_ExistentAttributeTerm_0= ruleExistentAttributeTerm
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getExistentAttributeTermParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExistentAttributeTerm_0=ruleExistentAttributeTerm();

                    state._fsp--;


                    			current = this_ExistentAttributeTerm_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2173:3: this_StoryAttributeTerm_1= ruleStoryAttributeTerm
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getStoryAttributeTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StoryAttributeTerm_1=ruleStoryAttributeTerm();

                    state._fsp--;


                    			current = this_StoryAttributeTerm_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:2182:3: this_IntegerTerm_2= ruleIntegerTerm
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getIntegerTermParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerTerm_2=ruleIntegerTerm();

                    state._fsp--;


                    			current = this_IntegerTerm_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:2191:3: this_BooleanTerm_3= ruleBooleanTerm
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getBooleanTermParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanTerm_3=ruleBooleanTerm();

                    state._fsp--;


                    			current = this_BooleanTerm_3;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleExistentAttributeTerm"
    // InternalStoryGen.g:2203:1: entryRuleExistentAttributeTerm returns [EObject current=null] : iv_ruleExistentAttributeTerm= ruleExistentAttributeTerm EOF ;
    public final EObject entryRuleExistentAttributeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExistentAttributeTerm = null;


        try {
            // InternalStoryGen.g:2203:62: (iv_ruleExistentAttributeTerm= ruleExistentAttributeTerm EOF )
            // InternalStoryGen.g:2204:2: iv_ruleExistentAttributeTerm= ruleExistentAttributeTerm EOF
            {
             newCompositeNode(grammarAccess.getExistentAttributeTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExistentAttributeTerm=ruleExistentAttributeTerm();

            state._fsp--;

             current =iv_ruleExistentAttributeTerm; 
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
    // $ANTLR end "entryRuleExistentAttributeTerm"


    // $ANTLR start "ruleExistentAttributeTerm"
    // InternalStoryGen.g:2210:1: ruleExistentAttributeTerm returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleExistentAttributeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2216:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalStoryGen.g:2217:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalStoryGen.g:2217:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // InternalStoryGen.g:2218:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // InternalStoryGen.g:2218:3: ( (otherlv_0= RULE_ID ) )
            // InternalStoryGen.g:2219:4: (otherlv_0= RULE_ID )
            {
            // InternalStoryGen.g:2219:4: (otherlv_0= RULE_ID )
            // InternalStoryGen.g:2220:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExistentAttributeTermRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(otherlv_0, grammarAccess.getExistentAttributeTermAccess().getExistentExistentCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,46,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getExistentAttributeTermAccess().getFullStopKeyword_1());
            		
            // InternalStoryGen.g:2235:3: ( (otherlv_2= RULE_ID ) )
            // InternalStoryGen.g:2236:4: (otherlv_2= RULE_ID )
            {
            // InternalStoryGen.g:2236:4: (otherlv_2= RULE_ID )
            // InternalStoryGen.g:2237:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExistentAttributeTermRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getExistentAttributeTermAccess().getAttributeAttributeCrossReference_2_0());
            				

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
    // $ANTLR end "ruleExistentAttributeTerm"


    // $ANTLR start "entryRuleStoryAttributeTerm"
    // InternalStoryGen.g:2252:1: entryRuleStoryAttributeTerm returns [EObject current=null] : iv_ruleStoryAttributeTerm= ruleStoryAttributeTerm EOF ;
    public final EObject entryRuleStoryAttributeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStoryAttributeTerm = null;


        try {
            // InternalStoryGen.g:2252:59: (iv_ruleStoryAttributeTerm= ruleStoryAttributeTerm EOF )
            // InternalStoryGen.g:2253:2: iv_ruleStoryAttributeTerm= ruleStoryAttributeTerm EOF
            {
             newCompositeNode(grammarAccess.getStoryAttributeTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStoryAttributeTerm=ruleStoryAttributeTerm();

            state._fsp--;

             current =iv_ruleStoryAttributeTerm; 
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
    // $ANTLR end "entryRuleStoryAttributeTerm"


    // $ANTLR start "ruleStoryAttributeTerm"
    // InternalStoryGen.g:2259:1: ruleStoryAttributeTerm returns [EObject current=null] : (otherlv_0= 'Story' otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleStoryAttributeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2265:2: ( (otherlv_0= 'Story' otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalStoryGen.g:2266:2: (otherlv_0= 'Story' otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalStoryGen.g:2266:2: (otherlv_0= 'Story' otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // InternalStoryGen.g:2267:3: otherlv_0= 'Story' otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getStoryAttributeTermAccess().getStoryKeyword_0());
            		
            otherlv_1=(Token)match(input,46,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getStoryAttributeTermAccess().getFullStopKeyword_1());
            		
            // InternalStoryGen.g:2275:3: ( (otherlv_2= RULE_ID ) )
            // InternalStoryGen.g:2276:4: (otherlv_2= RULE_ID )
            {
            // InternalStoryGen.g:2276:4: (otherlv_2= RULE_ID )
            // InternalStoryGen.g:2277:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStoryAttributeTermRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getStoryAttributeTermAccess().getAttributeAttributeCrossReference_2_0());
            				

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
    // $ANTLR end "ruleStoryAttributeTerm"


    // $ANTLR start "entryRuleIntegerTerm"
    // InternalStoryGen.g:2292:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalStoryGen.g:2292:52: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalStoryGen.g:2293:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
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
    // $ANTLR end "entryRuleIntegerTerm"


    // $ANTLR start "ruleIntegerTerm"
    // InternalStoryGen.g:2299:1: ruleIntegerTerm returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2305:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalStoryGen.g:2306:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalStoryGen.g:2306:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalStoryGen.g:2307:3: (lv_value_0_0= RULE_INT )
            {
            // InternalStoryGen.g:2307:3: (lv_value_0_0= RULE_INT )
            // InternalStoryGen.g:2308:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIntegerTermAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIntegerTermRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

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
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleBooleanTerm"
    // InternalStoryGen.g:2327:1: entryRuleBooleanTerm returns [EObject current=null] : iv_ruleBooleanTerm= ruleBooleanTerm EOF ;
    public final EObject entryRuleBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTerm = null;


        try {
            // InternalStoryGen.g:2327:52: (iv_ruleBooleanTerm= ruleBooleanTerm EOF )
            // InternalStoryGen.g:2328:2: iv_ruleBooleanTerm= ruleBooleanTerm EOF
            {
             newCompositeNode(grammarAccess.getBooleanTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanTerm=ruleBooleanTerm();

            state._fsp--;

             current =iv_ruleBooleanTerm; 
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
    // $ANTLR end "entryRuleBooleanTerm"


    // $ANTLR start "ruleBooleanTerm"
    // InternalStoryGen.g:2334:1: ruleBooleanTerm returns [EObject current=null] : ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) ;
    public final EObject ruleBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2340:2: ( ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) )
            // InternalStoryGen.g:2341:2: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
            {
            // InternalStoryGen.g:2341:2: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
            // InternalStoryGen.g:2342:3: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
            {
            // InternalStoryGen.g:2342:3: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
            // InternalStoryGen.g:2343:4: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
            {
            // InternalStoryGen.g:2343:4: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==50) ) {
                alt38=1;
            }
            else if ( (LA38_0==51) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalStoryGen.g:2344:5: lv_value_0_1= 'true'
                    {
                    lv_value_0_1=(Token)match(input,50,FOLLOW_2); 

                    					newLeafNode(lv_value_0_1, grammarAccess.getBooleanTermAccess().getValueTrueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanTermRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2355:5: lv_value_0_2= 'false'
                    {
                    lv_value_0_2=(Token)match(input,51,FOLLOW_2); 

                    					newLeafNode(lv_value_0_2, grammarAccess.getBooleanTermAccess().getValueFalseKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanTermRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_2, null);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleBooleanTerm"


    // $ANTLR start "ruleActionType"
    // InternalStoryGen.g:2371:1: ruleActionType returns [Enumerator current=null] : ( (enumLiteral_0= 'visual' ) | (enumLiteral_1= 'interaction' ) | (enumLiteral_2= 'movement' ) | (enumLiteral_3= 'communication' ) | (enumLiteral_4= 'combat' ) | (enumLiteral_5= 'idle' ) ) ;
    public final Enumerator ruleActionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2377:2: ( ( (enumLiteral_0= 'visual' ) | (enumLiteral_1= 'interaction' ) | (enumLiteral_2= 'movement' ) | (enumLiteral_3= 'communication' ) | (enumLiteral_4= 'combat' ) | (enumLiteral_5= 'idle' ) ) )
            // InternalStoryGen.g:2378:2: ( (enumLiteral_0= 'visual' ) | (enumLiteral_1= 'interaction' ) | (enumLiteral_2= 'movement' ) | (enumLiteral_3= 'communication' ) | (enumLiteral_4= 'combat' ) | (enumLiteral_5= 'idle' ) )
            {
            // InternalStoryGen.g:2378:2: ( (enumLiteral_0= 'visual' ) | (enumLiteral_1= 'interaction' ) | (enumLiteral_2= 'movement' ) | (enumLiteral_3= 'communication' ) | (enumLiteral_4= 'combat' ) | (enumLiteral_5= 'idle' ) )
            int alt39=6;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt39=1;
                }
                break;
            case 53:
                {
                alt39=2;
                }
                break;
            case 54:
                {
                alt39=3;
                }
                break;
            case 55:
                {
                alt39=4;
                }
                break;
            case 56:
                {
                alt39=5;
                }
                break;
            case 57:
                {
                alt39=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalStoryGen.g:2379:3: (enumLiteral_0= 'visual' )
                    {
                    // InternalStoryGen.g:2379:3: (enumLiteral_0= 'visual' )
                    // InternalStoryGen.g:2380:4: enumLiteral_0= 'visual'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getActionTypeAccess().getVISUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getActionTypeAccess().getVISUALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2387:3: (enumLiteral_1= 'interaction' )
                    {
                    // InternalStoryGen.g:2387:3: (enumLiteral_1= 'interaction' )
                    // InternalStoryGen.g:2388:4: enumLiteral_1= 'interaction'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getActionTypeAccess().getINTERACTIONEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getActionTypeAccess().getINTERACTIONEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:2395:3: (enumLiteral_2= 'movement' )
                    {
                    // InternalStoryGen.g:2395:3: (enumLiteral_2= 'movement' )
                    // InternalStoryGen.g:2396:4: enumLiteral_2= 'movement'
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getActionTypeAccess().getMOVEMENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getActionTypeAccess().getMOVEMENTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:2403:3: (enumLiteral_3= 'communication' )
                    {
                    // InternalStoryGen.g:2403:3: (enumLiteral_3= 'communication' )
                    // InternalStoryGen.g:2404:4: enumLiteral_3= 'communication'
                    {
                    enumLiteral_3=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getActionTypeAccess().getCOMMUNICATIONEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getActionTypeAccess().getCOMMUNICATIONEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGen.g:2411:3: (enumLiteral_4= 'combat' )
                    {
                    // InternalStoryGen.g:2411:3: (enumLiteral_4= 'combat' )
                    // InternalStoryGen.g:2412:4: enumLiteral_4= 'combat'
                    {
                    enumLiteral_4=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getActionTypeAccess().getCOMBATEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getActionTypeAccess().getCOMBATEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalStoryGen.g:2419:3: (enumLiteral_5= 'idle' )
                    {
                    // InternalStoryGen.g:2419:3: (enumLiteral_5= 'idle' )
                    // InternalStoryGen.g:2420:4: enumLiteral_5= 'idle'
                    {
                    enumLiteral_5=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getActionTypeAccess().getIDLEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getActionTypeAccess().getIDLEEnumLiteralDeclaration_5());
                    			

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
    // $ANTLR end "ruleActionType"


    // $ANTLR start "ruleComparisonOperator"
    // InternalStoryGen.g:2430:1: ruleComparisonOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '>' ) ) ;
    public final Enumerator ruleComparisonOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2436:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '>' ) ) )
            // InternalStoryGen.g:2437:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '>' ) )
            {
            // InternalStoryGen.g:2437:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '>=' ) | (enumLiteral_5= '>' ) )
            int alt40=6;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt40=1;
                }
                break;
            case 59:
                {
                alt40=2;
                }
                break;
            case 60:
                {
                alt40=3;
                }
                break;
            case 61:
                {
                alt40=4;
                }
                break;
            case 62:
                {
                alt40=5;
                }
                break;
            case 63:
                {
                alt40=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalStoryGen.g:2438:3: (enumLiteral_0= '<' )
                    {
                    // InternalStoryGen.g:2438:3: (enumLiteral_0= '<' )
                    // InternalStoryGen.g:2439:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2446:3: (enumLiteral_1= '<=' )
                    {
                    // InternalStoryGen.g:2446:3: (enumLiteral_1= '<=' )
                    // InternalStoryGen.g:2447:4: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorAccess().getLEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:2454:3: (enumLiteral_2= '==' )
                    {
                    // InternalStoryGen.g:2454:3: (enumLiteral_2= '==' )
                    // InternalStoryGen.g:2455:4: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:2462:3: (enumLiteral_3= '!=' )
                    {
                    // InternalStoryGen.g:2462:3: (enumLiteral_3= '!=' )
                    // InternalStoryGen.g:2463:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGen.g:2470:3: (enumLiteral_4= '>=' )
                    {
                    // InternalStoryGen.g:2470:3: (enumLiteral_4= '>=' )
                    // InternalStoryGen.g:2471:4: enumLiteral_4= '>='
                    {
                    enumLiteral_4=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getGEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorAccess().getGEEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalStoryGen.g:2478:3: (enumLiteral_5= '>' )
                    {
                    // InternalStoryGen.g:2478:3: (enumLiteral_5= '>' )
                    // InternalStoryGen.g:2479:4: enumLiteral_5= '>'
                    {
                    enumLiteral_5=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_5());
                    			

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
    // $ANTLR end "ruleComparisonOperator"


    // $ANTLR start "ruleAttributionOperator"
    // InternalStoryGen.g:2489:1: ruleAttributionOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) ) ;
    public final Enumerator ruleAttributionOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2495:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) ) )
            // InternalStoryGen.g:2496:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) )
            {
            // InternalStoryGen.g:2496:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt41=1;
                }
                break;
            case 64:
                {
                alt41=2;
                }
                break;
            case 65:
                {
                alt41=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalStoryGen.g:2497:3: (enumLiteral_0= '=' )
                    {
                    // InternalStoryGen.g:2497:3: (enumLiteral_0= '=' )
                    // InternalStoryGen.g:2498:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getAttributionOperatorAccess().getASSIGNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAttributionOperatorAccess().getASSIGNEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2505:3: (enumLiteral_1= '+=' )
                    {
                    // InternalStoryGen.g:2505:3: (enumLiteral_1= '+=' )
                    // InternalStoryGen.g:2506:4: enumLiteral_1= '+='
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getAttributionOperatorAccess().getINCREMENTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAttributionOperatorAccess().getINCREMENTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:2513:3: (enumLiteral_2= '-=' )
                    {
                    // InternalStoryGen.g:2513:3: (enumLiteral_2= '-=' )
                    // InternalStoryGen.g:2514:4: enumLiteral_2= '-='
                    {
                    enumLiteral_2=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getAttributionOperatorAccess().getDECREMENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAttributionOperatorAccess().getDECREMENTEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleAttributionOperator"


    // $ANTLR start "ruleOrder"
    // InternalStoryGen.g:2524:1: ruleOrder returns [Enumerator current=null] : ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'before' ) ) ;
    public final Enumerator ruleOrder() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2530:2: ( ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'before' ) ) )
            // InternalStoryGen.g:2531:2: ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'before' ) )
            {
            // InternalStoryGen.g:2531:2: ( (enumLiteral_0= 'after' ) | (enumLiteral_1= 'before' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==66) ) {
                alt42=1;
            }
            else if ( (LA42_0==67) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalStoryGen.g:2532:3: (enumLiteral_0= 'after' )
                    {
                    // InternalStoryGen.g:2532:3: (enumLiteral_0= 'after' )
                    // InternalStoryGen.g:2533:4: enumLiteral_0= 'after'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getAFTEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOrderAccess().getAFTEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2540:3: (enumLiteral_1= 'before' )
                    {
                    // InternalStoryGen.g:2540:3: (enumLiteral_1= 'before' )
                    // InternalStoryGen.g:2541:4: enumLiteral_1= 'before'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getOrderAccess().getBEFOREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOrderAccess().getBEFOREEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleOrder"


    // $ANTLR start "ruleAttributeSettingFrequency"
    // InternalStoryGen.g:2551:1: ruleAttributeSettingFrequency returns [Enumerator current=null] : ( (enumLiteral_0= 'every event' ) | (enumLiteral_1= 'every happening' ) | (enumLiteral_2= 'every action' ) | (enumLiteral_3= 'every player action' ) ) ;
    public final Enumerator ruleAttributeSettingFrequency() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2557:2: ( ( (enumLiteral_0= 'every event' ) | (enumLiteral_1= 'every happening' ) | (enumLiteral_2= 'every action' ) | (enumLiteral_3= 'every player action' ) ) )
            // InternalStoryGen.g:2558:2: ( (enumLiteral_0= 'every event' ) | (enumLiteral_1= 'every happening' ) | (enumLiteral_2= 'every action' ) | (enumLiteral_3= 'every player action' ) )
            {
            // InternalStoryGen.g:2558:2: ( (enumLiteral_0= 'every event' ) | (enumLiteral_1= 'every happening' ) | (enumLiteral_2= 'every action' ) | (enumLiteral_3= 'every player action' ) )
            int alt43=4;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt43=1;
                }
                break;
            case 69:
                {
                alt43=2;
                }
                break;
            case 70:
                {
                alt43=3;
                }
                break;
            case 71:
                {
                alt43=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalStoryGen.g:2559:3: (enumLiteral_0= 'every event' )
                    {
                    // InternalStoryGen.g:2559:3: (enumLiteral_0= 'every event' )
                    // InternalStoryGen.g:2560:4: enumLiteral_0= 'every event'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_EVENTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_EVENTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2567:3: (enumLiteral_1= 'every happening' )
                    {
                    // InternalStoryGen.g:2567:3: (enumLiteral_1= 'every happening' )
                    // InternalStoryGen.g:2568:4: enumLiteral_1= 'every happening'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_HAPPENINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_HAPPENINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:2575:3: (enumLiteral_2= 'every action' )
                    {
                    // InternalStoryGen.g:2575:3: (enumLiteral_2= 'every action' )
                    // InternalStoryGen.g:2576:4: enumLiteral_2= 'every action'
                    {
                    enumLiteral_2=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_ACTIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_ACTIONEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:2583:3: (enumLiteral_3= 'every player action' )
                    {
                    // InternalStoryGen.g:2583:3: (enumLiteral_3= 'every player action' )
                    // InternalStoryGen.g:2584:4: enumLiteral_3= 'every player action'
                    {
                    enumLiteral_3=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_PLAYER_ACTIONEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_PLAYER_ACTIONEnumLiteralDeclaration_3());
                    			

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
    // $ANTLR end "ruleAttributeSettingFrequency"


    // $ANTLR start "ruleEventPriority"
    // InternalStoryGen.g:2594:1: ruleEventPriority returns [Enumerator current=null] : ( (enumLiteral_0= 'normal' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'veryHigh' ) ) ;
    public final Enumerator ruleEventPriority() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalStoryGen.g:2600:2: ( ( (enumLiteral_0= 'normal' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'veryHigh' ) ) )
            // InternalStoryGen.g:2601:2: ( (enumLiteral_0= 'normal' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'veryHigh' ) )
            {
            // InternalStoryGen.g:2601:2: ( (enumLiteral_0= 'normal' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'veryHigh' ) )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt44=1;
                }
                break;
            case 73:
                {
                alt44=2;
                }
                break;
            case 74:
                {
                alt44=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalStoryGen.g:2602:3: (enumLiteral_0= 'normal' )
                    {
                    // InternalStoryGen.g:2602:3: (enumLiteral_0= 'normal' )
                    // InternalStoryGen.g:2603:4: enumLiteral_0= 'normal'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getEventPriorityAccess().getNORMALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEventPriorityAccess().getNORMALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:2610:3: (enumLiteral_1= 'high' )
                    {
                    // InternalStoryGen.g:2610:3: (enumLiteral_1= 'high' )
                    // InternalStoryGen.g:2611:4: enumLiteral_1= 'high'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getEventPriorityAccess().getHIGHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEventPriorityAccess().getHIGHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:2618:3: (enumLiteral_2= 'veryHigh' )
                    {
                    // InternalStoryGen.g:2618:3: (enumLiteral_2= 'veryHigh' )
                    // InternalStoryGen.g:2619:4: enumLiteral_2= 'veryHigh'
                    {
                    enumLiteral_2=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getEventPriorityAccess().getVERY_HIGHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getEventPriorityAccess().getVERY_HIGHEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleEventPriority"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002204000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000164000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000010380004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000C000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000E000000800850L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000F0L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000700L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000287000004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000286000004000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000284000004000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000280000004000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000200000004000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020400000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x03F0000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000041000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000003L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x000C000000000040L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0xFC01800000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0001000000000002L});

}