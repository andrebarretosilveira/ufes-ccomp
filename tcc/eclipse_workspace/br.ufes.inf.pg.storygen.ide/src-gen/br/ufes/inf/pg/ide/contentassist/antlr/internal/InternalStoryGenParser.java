package br.ufes.inf.pg.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import br.ufes.inf.pg.services.StoryGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStoryGenParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'visual'", "'interaction'", "'movement'", "'communication'", "'combat'", "'idle'", "'<'", "'<='", "'=='", "'!='", "'>='", "'>'", "'='", "'+='", "'-='", "'after'", "'before'", "'every event'", "'every happening'", "'every action'", "'every player action'", "'normal'", "'high'", "'veryHigh'", "'Story'", "'data'", "'{'", "'}'", "'Space'", "'Plot'", "'actor'", "'name:'", "'object'", "'fact'", "'('", "')'", "'quantity'", "'['", "']'", "'by'", "'event'", "'description:'", "'priority:'", "'short-description:'", "'triggers:'", "'may-trigger:'", "','", "'action'", "'type:'", "'actor:'", "'require:'", "'change:'", "'.'", "'or'", "'and'", "'not'", "'player'", "'increments'", "'decrements'", "'opening'", "'ending'", "'be-triggered'"
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

    	public void setGrammarAccess(StoryGenGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleStory"
    // InternalStoryGen.g:53:1: entryRuleStory : ruleStory EOF ;
    public final void entryRuleStory() throws RecognitionException {
        try {
            // InternalStoryGen.g:54:1: ( ruleStory EOF )
            // InternalStoryGen.g:55:1: ruleStory EOF
            {
             before(grammarAccess.getStoryRule()); 
            pushFollow(FOLLOW_1);
            ruleStory();

            state._fsp--;

             after(grammarAccess.getStoryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStory"


    // $ANTLR start "ruleStory"
    // InternalStoryGen.g:62:1: ruleStory : ( ( rule__Story__Group__0 ) ) ;
    public final void ruleStory() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:66:2: ( ( ( rule__Story__Group__0 ) ) )
            // InternalStoryGen.g:67:2: ( ( rule__Story__Group__0 ) )
            {
            // InternalStoryGen.g:67:2: ( ( rule__Story__Group__0 ) )
            // InternalStoryGen.g:68:3: ( rule__Story__Group__0 )
            {
             before(grammarAccess.getStoryAccess().getGroup()); 
            // InternalStoryGen.g:69:3: ( rule__Story__Group__0 )
            // InternalStoryGen.g:69:4: rule__Story__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Story__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStory"


    // $ANTLR start "entryRuleStoryData"
    // InternalStoryGen.g:78:1: entryRuleStoryData : ruleStoryData EOF ;
    public final void entryRuleStoryData() throws RecognitionException {
        try {
            // InternalStoryGen.g:79:1: ( ruleStoryData EOF )
            // InternalStoryGen.g:80:1: ruleStoryData EOF
            {
             before(grammarAccess.getStoryDataRule()); 
            pushFollow(FOLLOW_1);
            ruleStoryData();

            state._fsp--;

             after(grammarAccess.getStoryDataRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStoryData"


    // $ANTLR start "ruleStoryData"
    // InternalStoryGen.g:87:1: ruleStoryData : ( ( rule__StoryData__Group__0 ) ) ;
    public final void ruleStoryData() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:91:2: ( ( ( rule__StoryData__Group__0 ) ) )
            // InternalStoryGen.g:92:2: ( ( rule__StoryData__Group__0 ) )
            {
            // InternalStoryGen.g:92:2: ( ( rule__StoryData__Group__0 ) )
            // InternalStoryGen.g:93:3: ( rule__StoryData__Group__0 )
            {
             before(grammarAccess.getStoryDataAccess().getGroup()); 
            // InternalStoryGen.g:94:3: ( rule__StoryData__Group__0 )
            // InternalStoryGen.g:94:4: rule__StoryData__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StoryData__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStoryDataAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStoryData"


    // $ANTLR start "entryRuleSpace"
    // InternalStoryGen.g:103:1: entryRuleSpace : ruleSpace EOF ;
    public final void entryRuleSpace() throws RecognitionException {
        try {
            // InternalStoryGen.g:104:1: ( ruleSpace EOF )
            // InternalStoryGen.g:105:1: ruleSpace EOF
            {
             before(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_1);
            ruleSpace();

            state._fsp--;

             after(grammarAccess.getSpaceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSpace"


    // $ANTLR start "ruleSpace"
    // InternalStoryGen.g:112:1: ruleSpace : ( ( rule__Space__Group__0 ) ) ;
    public final void ruleSpace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:116:2: ( ( ( rule__Space__Group__0 ) ) )
            // InternalStoryGen.g:117:2: ( ( rule__Space__Group__0 ) )
            {
            // InternalStoryGen.g:117:2: ( ( rule__Space__Group__0 ) )
            // InternalStoryGen.g:118:3: ( rule__Space__Group__0 )
            {
             before(grammarAccess.getSpaceAccess().getGroup()); 
            // InternalStoryGen.g:119:3: ( rule__Space__Group__0 )
            // InternalStoryGen.g:119:4: rule__Space__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Space__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSpaceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpace"


    // $ANTLR start "entryRulePlot"
    // InternalStoryGen.g:128:1: entryRulePlot : rulePlot EOF ;
    public final void entryRulePlot() throws RecognitionException {
        try {
            // InternalStoryGen.g:129:1: ( rulePlot EOF )
            // InternalStoryGen.g:130:1: rulePlot EOF
            {
             before(grammarAccess.getPlotRule()); 
            pushFollow(FOLLOW_1);
            rulePlot();

            state._fsp--;

             after(grammarAccess.getPlotRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePlot"


    // $ANTLR start "rulePlot"
    // InternalStoryGen.g:137:1: rulePlot : ( ( rule__Plot__Group__0 ) ) ;
    public final void rulePlot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:141:2: ( ( ( rule__Plot__Group__0 ) ) )
            // InternalStoryGen.g:142:2: ( ( rule__Plot__Group__0 ) )
            {
            // InternalStoryGen.g:142:2: ( ( rule__Plot__Group__0 ) )
            // InternalStoryGen.g:143:3: ( rule__Plot__Group__0 )
            {
             before(grammarAccess.getPlotAccess().getGroup()); 
            // InternalStoryGen.g:144:3: ( rule__Plot__Group__0 )
            // InternalStoryGen.g:144:4: rule__Plot__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Plot__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPlotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePlot"


    // $ANTLR start "entryRuleExistent"
    // InternalStoryGen.g:153:1: entryRuleExistent : ruleExistent EOF ;
    public final void entryRuleExistent() throws RecognitionException {
        try {
            // InternalStoryGen.g:154:1: ( ruleExistent EOF )
            // InternalStoryGen.g:155:1: ruleExistent EOF
            {
             before(grammarAccess.getExistentRule()); 
            pushFollow(FOLLOW_1);
            ruleExistent();

            state._fsp--;

             after(grammarAccess.getExistentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExistent"


    // $ANTLR start "ruleExistent"
    // InternalStoryGen.g:162:1: ruleExistent : ( ( rule__Existent__Alternatives ) ) ;
    public final void ruleExistent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:166:2: ( ( ( rule__Existent__Alternatives ) ) )
            // InternalStoryGen.g:167:2: ( ( rule__Existent__Alternatives ) )
            {
            // InternalStoryGen.g:167:2: ( ( rule__Existent__Alternatives ) )
            // InternalStoryGen.g:168:3: ( rule__Existent__Alternatives )
            {
             before(grammarAccess.getExistentAccess().getAlternatives()); 
            // InternalStoryGen.g:169:3: ( rule__Existent__Alternatives )
            // InternalStoryGen.g:169:4: rule__Existent__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Existent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExistentAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExistent"


    // $ANTLR start "entryRuleActor"
    // InternalStoryGen.g:178:1: entryRuleActor : ruleActor EOF ;
    public final void entryRuleActor() throws RecognitionException {
        try {
            // InternalStoryGen.g:179:1: ( ruleActor EOF )
            // InternalStoryGen.g:180:1: ruleActor EOF
            {
             before(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            ruleActor();

            state._fsp--;

             after(grammarAccess.getActorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalStoryGen.g:187:1: ruleActor : ( ( rule__Actor__Group__0 ) ) ;
    public final void ruleActor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:191:2: ( ( ( rule__Actor__Group__0 ) ) )
            // InternalStoryGen.g:192:2: ( ( rule__Actor__Group__0 ) )
            {
            // InternalStoryGen.g:192:2: ( ( rule__Actor__Group__0 ) )
            // InternalStoryGen.g:193:3: ( rule__Actor__Group__0 )
            {
             before(grammarAccess.getActorAccess().getGroup()); 
            // InternalStoryGen.g:194:3: ( rule__Actor__Group__0 )
            // InternalStoryGen.g:194:4: rule__Actor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Actor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleObject"
    // InternalStoryGen.g:203:1: entryRuleObject : ruleObject EOF ;
    public final void entryRuleObject() throws RecognitionException {
        try {
            // InternalStoryGen.g:204:1: ( ruleObject EOF )
            // InternalStoryGen.g:205:1: ruleObject EOF
            {
             before(grammarAccess.getObjectRule()); 
            pushFollow(FOLLOW_1);
            ruleObject();

            state._fsp--;

             after(grammarAccess.getObjectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalStoryGen.g:212:1: ruleObject : ( ( rule__Object__Group__0 ) ) ;
    public final void ruleObject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:216:2: ( ( ( rule__Object__Group__0 ) ) )
            // InternalStoryGen.g:217:2: ( ( rule__Object__Group__0 ) )
            {
            // InternalStoryGen.g:217:2: ( ( rule__Object__Group__0 ) )
            // InternalStoryGen.g:218:3: ( rule__Object__Group__0 )
            {
             before(grammarAccess.getObjectAccess().getGroup()); 
            // InternalStoryGen.g:219:3: ( rule__Object__Group__0 )
            // InternalStoryGen.g:219:4: rule__Object__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Object__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleAttribute"
    // InternalStoryGen.g:228:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalStoryGen.g:229:1: ( ruleAttribute EOF )
            // InternalStoryGen.g:230:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalStoryGen.g:237:1: ruleAttribute : ( ( rule__Attribute__Alternatives ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:241:2: ( ( ( rule__Attribute__Alternatives ) ) )
            // InternalStoryGen.g:242:2: ( ( rule__Attribute__Alternatives ) )
            {
            // InternalStoryGen.g:242:2: ( ( rule__Attribute__Alternatives ) )
            // InternalStoryGen.g:243:3: ( rule__Attribute__Alternatives )
            {
             before(grammarAccess.getAttributeAccess().getAlternatives()); 
            // InternalStoryGen.g:244:3: ( rule__Attribute__Alternatives )
            // InternalStoryGen.g:244:4: rule__Attribute__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleFactAttribute"
    // InternalStoryGen.g:253:1: entryRuleFactAttribute : ruleFactAttribute EOF ;
    public final void entryRuleFactAttribute() throws RecognitionException {
        try {
            // InternalStoryGen.g:254:1: ( ruleFactAttribute EOF )
            // InternalStoryGen.g:255:1: ruleFactAttribute EOF
            {
             before(grammarAccess.getFactAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleFactAttribute();

            state._fsp--;

             after(grammarAccess.getFactAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFactAttribute"


    // $ANTLR start "ruleFactAttribute"
    // InternalStoryGen.g:262:1: ruleFactAttribute : ( ( rule__FactAttribute__Group__0 ) ) ;
    public final void ruleFactAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:266:2: ( ( ( rule__FactAttribute__Group__0 ) ) )
            // InternalStoryGen.g:267:2: ( ( rule__FactAttribute__Group__0 ) )
            {
            // InternalStoryGen.g:267:2: ( ( rule__FactAttribute__Group__0 ) )
            // InternalStoryGen.g:268:3: ( rule__FactAttribute__Group__0 )
            {
             before(grammarAccess.getFactAttributeAccess().getGroup()); 
            // InternalStoryGen.g:269:3: ( rule__FactAttribute__Group__0 )
            // InternalStoryGen.g:269:4: rule__FactAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FactAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFactAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFactAttribute"


    // $ANTLR start "entryRuleQuantityAttribute"
    // InternalStoryGen.g:278:1: entryRuleQuantityAttribute : ruleQuantityAttribute EOF ;
    public final void entryRuleQuantityAttribute() throws RecognitionException {
        try {
            // InternalStoryGen.g:279:1: ( ruleQuantityAttribute EOF )
            // InternalStoryGen.g:280:1: ruleQuantityAttribute EOF
            {
             before(grammarAccess.getQuantityAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleQuantityAttribute();

            state._fsp--;

             after(grammarAccess.getQuantityAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuantityAttribute"


    // $ANTLR start "ruleQuantityAttribute"
    // InternalStoryGen.g:287:1: ruleQuantityAttribute : ( ( rule__QuantityAttribute__Group__0 ) ) ;
    public final void ruleQuantityAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:291:2: ( ( ( rule__QuantityAttribute__Group__0 ) ) )
            // InternalStoryGen.g:292:2: ( ( rule__QuantityAttribute__Group__0 ) )
            {
            // InternalStoryGen.g:292:2: ( ( rule__QuantityAttribute__Group__0 ) )
            // InternalStoryGen.g:293:3: ( rule__QuantityAttribute__Group__0 )
            {
             before(grammarAccess.getQuantityAttributeAccess().getGroup()); 
            // InternalStoryGen.g:294:3: ( rule__QuantityAttribute__Group__0 )
            // InternalStoryGen.g:294:4: rule__QuantityAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQuantityAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuantityAttribute"


    // $ANTLR start "entryRuleAttributeSetting"
    // InternalStoryGen.g:303:1: entryRuleAttributeSetting : ruleAttributeSetting EOF ;
    public final void entryRuleAttributeSetting() throws RecognitionException {
        try {
            // InternalStoryGen.g:304:1: ( ruleAttributeSetting EOF )
            // InternalStoryGen.g:305:1: ruleAttributeSetting EOF
            {
             before(grammarAccess.getAttributeSettingRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeSetting();

            state._fsp--;

             after(grammarAccess.getAttributeSettingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeSetting"


    // $ANTLR start "ruleAttributeSetting"
    // InternalStoryGen.g:312:1: ruleAttributeSetting : ( ( rule__AttributeSetting__Group__0 ) ) ;
    public final void ruleAttributeSetting() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:316:2: ( ( ( rule__AttributeSetting__Group__0 ) ) )
            // InternalStoryGen.g:317:2: ( ( rule__AttributeSetting__Group__0 ) )
            {
            // InternalStoryGen.g:317:2: ( ( rule__AttributeSetting__Group__0 ) )
            // InternalStoryGen.g:318:3: ( rule__AttributeSetting__Group__0 )
            {
             before(grammarAccess.getAttributeSettingAccess().getGroup()); 
            // InternalStoryGen.g:319:3: ( rule__AttributeSetting__Group__0 )
            // InternalStoryGen.g:319:4: rule__AttributeSetting__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeSetting__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeSettingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeSetting"


    // $ANTLR start "entryRuleEvent"
    // InternalStoryGen.g:328:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // InternalStoryGen.g:329:1: ( ruleEvent EOF )
            // InternalStoryGen.g:330:1: ruleEvent EOF
            {
             before(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getEventRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalStoryGen.g:337:1: ruleEvent : ( ( rule__Event__Alternatives ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:341:2: ( ( ( rule__Event__Alternatives ) ) )
            // InternalStoryGen.g:342:2: ( ( rule__Event__Alternatives ) )
            {
            // InternalStoryGen.g:342:2: ( ( rule__Event__Alternatives ) )
            // InternalStoryGen.g:343:3: ( rule__Event__Alternatives )
            {
             before(grammarAccess.getEventAccess().getAlternatives()); 
            // InternalStoryGen.g:344:3: ( rule__Event__Alternatives )
            // InternalStoryGen.g:344:4: rule__Event__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Event__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleHappeningEvent"
    // InternalStoryGen.g:353:1: entryRuleHappeningEvent : ruleHappeningEvent EOF ;
    public final void entryRuleHappeningEvent() throws RecognitionException {
        try {
            // InternalStoryGen.g:354:1: ( ruleHappeningEvent EOF )
            // InternalStoryGen.g:355:1: ruleHappeningEvent EOF
            {
             before(grammarAccess.getHappeningEventRule()); 
            pushFollow(FOLLOW_1);
            ruleHappeningEvent();

            state._fsp--;

             after(grammarAccess.getHappeningEventRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHappeningEvent"


    // $ANTLR start "ruleHappeningEvent"
    // InternalStoryGen.g:362:1: ruleHappeningEvent : ( ( rule__HappeningEvent__Group__0 ) ) ;
    public final void ruleHappeningEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:366:2: ( ( ( rule__HappeningEvent__Group__0 ) ) )
            // InternalStoryGen.g:367:2: ( ( rule__HappeningEvent__Group__0 ) )
            {
            // InternalStoryGen.g:367:2: ( ( rule__HappeningEvent__Group__0 ) )
            // InternalStoryGen.g:368:3: ( rule__HappeningEvent__Group__0 )
            {
             before(grammarAccess.getHappeningEventAccess().getGroup()); 
            // InternalStoryGen.g:369:3: ( rule__HappeningEvent__Group__0 )
            // InternalStoryGen.g:369:4: rule__HappeningEvent__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHappeningEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHappeningEvent"


    // $ANTLR start "entryRuleActionEvent"
    // InternalStoryGen.g:378:1: entryRuleActionEvent : ruleActionEvent EOF ;
    public final void entryRuleActionEvent() throws RecognitionException {
        try {
            // InternalStoryGen.g:379:1: ( ruleActionEvent EOF )
            // InternalStoryGen.g:380:1: ruleActionEvent EOF
            {
             before(grammarAccess.getActionEventRule()); 
            pushFollow(FOLLOW_1);
            ruleActionEvent();

            state._fsp--;

             after(grammarAccess.getActionEventRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleActionEvent"


    // $ANTLR start "ruleActionEvent"
    // InternalStoryGen.g:387:1: ruleActionEvent : ( ( rule__ActionEvent__Group__0 ) ) ;
    public final void ruleActionEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:391:2: ( ( ( rule__ActionEvent__Group__0 ) ) )
            // InternalStoryGen.g:392:2: ( ( rule__ActionEvent__Group__0 ) )
            {
            // InternalStoryGen.g:392:2: ( ( rule__ActionEvent__Group__0 ) )
            // InternalStoryGen.g:393:3: ( rule__ActionEvent__Group__0 )
            {
             before(grammarAccess.getActionEventAccess().getGroup()); 
            // InternalStoryGen.g:394:3: ( rule__ActionEvent__Group__0 )
            // InternalStoryGen.g:394:4: rule__ActionEvent__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActionEvent"


    // $ANTLR start "entryRuleCondition"
    // InternalStoryGen.g:403:1: entryRuleCondition : ruleCondition EOF ;
    public final void entryRuleCondition() throws RecognitionException {
        try {
            // InternalStoryGen.g:404:1: ( ruleCondition EOF )
            // InternalStoryGen.g:405:1: ruleCondition EOF
            {
             before(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalStoryGen.g:412:1: ruleCondition : ( ( rule__Condition__Alternatives ) ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:416:2: ( ( ( rule__Condition__Alternatives ) ) )
            // InternalStoryGen.g:417:2: ( ( rule__Condition__Alternatives ) )
            {
            // InternalStoryGen.g:417:2: ( ( rule__Condition__Alternatives ) )
            // InternalStoryGen.g:418:3: ( rule__Condition__Alternatives )
            {
             before(grammarAccess.getConditionAccess().getAlternatives()); 
            // InternalStoryGen.g:419:3: ( rule__Condition__Alternatives )
            // InternalStoryGen.g:419:4: rule__Condition__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleExpressionCondition"
    // InternalStoryGen.g:428:1: entryRuleExpressionCondition : ruleExpressionCondition EOF ;
    public final void entryRuleExpressionCondition() throws RecognitionException {
        try {
            // InternalStoryGen.g:429:1: ( ruleExpressionCondition EOF )
            // InternalStoryGen.g:430:1: ruleExpressionCondition EOF
            {
             before(grammarAccess.getExpressionConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpressionCondition();

            state._fsp--;

             after(grammarAccess.getExpressionConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpressionCondition"


    // $ANTLR start "ruleExpressionCondition"
    // InternalStoryGen.g:437:1: ruleExpressionCondition : ( ( rule__ExpressionCondition__Group__0 ) ) ;
    public final void ruleExpressionCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:441:2: ( ( ( rule__ExpressionCondition__Group__0 ) ) )
            // InternalStoryGen.g:442:2: ( ( rule__ExpressionCondition__Group__0 ) )
            {
            // InternalStoryGen.g:442:2: ( ( rule__ExpressionCondition__Group__0 ) )
            // InternalStoryGen.g:443:3: ( rule__ExpressionCondition__Group__0 )
            {
             before(grammarAccess.getExpressionConditionAccess().getGroup()); 
            // InternalStoryGen.g:444:3: ( rule__ExpressionCondition__Group__0 )
            // InternalStoryGen.g:444:4: rule__ExpressionCondition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpressionCondition"


    // $ANTLR start "entryRuleOrderCondition"
    // InternalStoryGen.g:453:1: entryRuleOrderCondition : ruleOrderCondition EOF ;
    public final void entryRuleOrderCondition() throws RecognitionException {
        try {
            // InternalStoryGen.g:454:1: ( ruleOrderCondition EOF )
            // InternalStoryGen.g:455:1: ruleOrderCondition EOF
            {
             before(grammarAccess.getOrderConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleOrderCondition();

            state._fsp--;

             after(grammarAccess.getOrderConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrderCondition"


    // $ANTLR start "ruleOrderCondition"
    // InternalStoryGen.g:462:1: ruleOrderCondition : ( ( rule__OrderCondition__Group__0 ) ) ;
    public final void ruleOrderCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:466:2: ( ( ( rule__OrderCondition__Group__0 ) ) )
            // InternalStoryGen.g:467:2: ( ( rule__OrderCondition__Group__0 ) )
            {
            // InternalStoryGen.g:467:2: ( ( rule__OrderCondition__Group__0 ) )
            // InternalStoryGen.g:468:3: ( rule__OrderCondition__Group__0 )
            {
             before(grammarAccess.getOrderConditionAccess().getGroup()); 
            // InternalStoryGen.g:469:3: ( rule__OrderCondition__Group__0 )
            // InternalStoryGen.g:469:4: rule__OrderCondition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrderCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrderConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrderCondition"


    // $ANTLR start "entryRuleTriggerCondition"
    // InternalStoryGen.g:478:1: entryRuleTriggerCondition : ruleTriggerCondition EOF ;
    public final void entryRuleTriggerCondition() throws RecognitionException {
        try {
            // InternalStoryGen.g:479:1: ( ruleTriggerCondition EOF )
            // InternalStoryGen.g:480:1: ruleTriggerCondition EOF
            {
             before(grammarAccess.getTriggerConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleTriggerCondition();

            state._fsp--;

             after(grammarAccess.getTriggerConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTriggerCondition"


    // $ANTLR start "ruleTriggerCondition"
    // InternalStoryGen.g:487:1: ruleTriggerCondition : ( ( rule__TriggerCondition__Group__0 ) ) ;
    public final void ruleTriggerCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:491:2: ( ( ( rule__TriggerCondition__Group__0 ) ) )
            // InternalStoryGen.g:492:2: ( ( rule__TriggerCondition__Group__0 ) )
            {
            // InternalStoryGen.g:492:2: ( ( rule__TriggerCondition__Group__0 ) )
            // InternalStoryGen.g:493:3: ( rule__TriggerCondition__Group__0 )
            {
             before(grammarAccess.getTriggerConditionAccess().getGroup()); 
            // InternalStoryGen.g:494:3: ( rule__TriggerCondition__Group__0 )
            // InternalStoryGen.g:494:4: rule__TriggerCondition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TriggerCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTriggerConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTriggerCondition"


    // $ANTLR start "entryRuleChange"
    // InternalStoryGen.g:503:1: entryRuleChange : ruleChange EOF ;
    public final void entryRuleChange() throws RecognitionException {
        try {
            // InternalStoryGen.g:504:1: ( ruleChange EOF )
            // InternalStoryGen.g:505:1: ruleChange EOF
            {
             before(grammarAccess.getChangeRule()); 
            pushFollow(FOLLOW_1);
            ruleChange();

            state._fsp--;

             after(grammarAccess.getChangeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleChange"


    // $ANTLR start "ruleChange"
    // InternalStoryGen.g:512:1: ruleChange : ( ( rule__Change__Alternatives ) ) ;
    public final void ruleChange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:516:2: ( ( ( rule__Change__Alternatives ) ) )
            // InternalStoryGen.g:517:2: ( ( rule__Change__Alternatives ) )
            {
            // InternalStoryGen.g:517:2: ( ( rule__Change__Alternatives ) )
            // InternalStoryGen.g:518:3: ( rule__Change__Alternatives )
            {
             before(grammarAccess.getChangeAccess().getAlternatives()); 
            // InternalStoryGen.g:519:3: ( rule__Change__Alternatives )
            // InternalStoryGen.g:519:4: rule__Change__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Change__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getChangeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChange"


    // $ANTLR start "entryRuleExistentChange"
    // InternalStoryGen.g:528:1: entryRuleExistentChange : ruleExistentChange EOF ;
    public final void entryRuleExistentChange() throws RecognitionException {
        try {
            // InternalStoryGen.g:529:1: ( ruleExistentChange EOF )
            // InternalStoryGen.g:530:1: ruleExistentChange EOF
            {
             before(grammarAccess.getExistentChangeRule()); 
            pushFollow(FOLLOW_1);
            ruleExistentChange();

            state._fsp--;

             after(grammarAccess.getExistentChangeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExistentChange"


    // $ANTLR start "ruleExistentChange"
    // InternalStoryGen.g:537:1: ruleExistentChange : ( ( rule__ExistentChange__Group__0 ) ) ;
    public final void ruleExistentChange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:541:2: ( ( ( rule__ExistentChange__Group__0 ) ) )
            // InternalStoryGen.g:542:2: ( ( rule__ExistentChange__Group__0 ) )
            {
            // InternalStoryGen.g:542:2: ( ( rule__ExistentChange__Group__0 ) )
            // InternalStoryGen.g:543:3: ( rule__ExistentChange__Group__0 )
            {
             before(grammarAccess.getExistentChangeAccess().getGroup()); 
            // InternalStoryGen.g:544:3: ( rule__ExistentChange__Group__0 )
            // InternalStoryGen.g:544:4: rule__ExistentChange__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExistentChange__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExistentChangeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExistentChange"


    // $ANTLR start "entryRuleStoryDataChange"
    // InternalStoryGen.g:553:1: entryRuleStoryDataChange : ruleStoryDataChange EOF ;
    public final void entryRuleStoryDataChange() throws RecognitionException {
        try {
            // InternalStoryGen.g:554:1: ( ruleStoryDataChange EOF )
            // InternalStoryGen.g:555:1: ruleStoryDataChange EOF
            {
             before(grammarAccess.getStoryDataChangeRule()); 
            pushFollow(FOLLOW_1);
            ruleStoryDataChange();

            state._fsp--;

             after(grammarAccess.getStoryDataChangeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStoryDataChange"


    // $ANTLR start "ruleStoryDataChange"
    // InternalStoryGen.g:562:1: ruleStoryDataChange : ( ( rule__StoryDataChange__Group__0 ) ) ;
    public final void ruleStoryDataChange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:566:2: ( ( ( rule__StoryDataChange__Group__0 ) ) )
            // InternalStoryGen.g:567:2: ( ( rule__StoryDataChange__Group__0 ) )
            {
            // InternalStoryGen.g:567:2: ( ( rule__StoryDataChange__Group__0 ) )
            // InternalStoryGen.g:568:3: ( rule__StoryDataChange__Group__0 )
            {
             before(grammarAccess.getStoryDataChangeAccess().getGroup()); 
            // InternalStoryGen.g:569:3: ( rule__StoryDataChange__Group__0 )
            // InternalStoryGen.g:569:4: rule__StoryDataChange__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StoryDataChange__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStoryDataChangeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStoryDataChange"


    // $ANTLR start "entryRuleExpression"
    // InternalStoryGen.g:578:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalStoryGen.g:579:1: ( ruleExpression EOF )
            // InternalStoryGen.g:580:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalStoryGen.g:587:1: ruleExpression : ( ruleBinaryExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:591:2: ( ( ruleBinaryExpression ) )
            // InternalStoryGen.g:592:2: ( ruleBinaryExpression )
            {
            // InternalStoryGen.g:592:2: ( ruleBinaryExpression )
            // InternalStoryGen.g:593:3: ruleBinaryExpression
            {
             before(grammarAccess.getExpressionAccess().getBinaryExpressionParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleBinaryExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getBinaryExpressionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleBinaryExpression"
    // InternalStoryGen.g:603:1: entryRuleBinaryExpression : ruleBinaryExpression EOF ;
    public final void entryRuleBinaryExpression() throws RecognitionException {
        try {
            // InternalStoryGen.g:604:1: ( ruleBinaryExpression EOF )
            // InternalStoryGen.g:605:1: ruleBinaryExpression EOF
            {
             before(grammarAccess.getBinaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleBinaryExpression();

            state._fsp--;

             after(grammarAccess.getBinaryExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBinaryExpression"


    // $ANTLR start "ruleBinaryExpression"
    // InternalStoryGen.g:612:1: ruleBinaryExpression : ( ( rule__BinaryExpression__Group__0 ) ) ;
    public final void ruleBinaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:616:2: ( ( ( rule__BinaryExpression__Group__0 ) ) )
            // InternalStoryGen.g:617:2: ( ( rule__BinaryExpression__Group__0 ) )
            {
            // InternalStoryGen.g:617:2: ( ( rule__BinaryExpression__Group__0 ) )
            // InternalStoryGen.g:618:3: ( rule__BinaryExpression__Group__0 )
            {
             before(grammarAccess.getBinaryExpressionAccess().getGroup()); 
            // InternalStoryGen.g:619:3: ( rule__BinaryExpression__Group__0 )
            // InternalStoryGen.g:619:4: rule__BinaryExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBinaryExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinaryExpression"


    // $ANTLR start "entryRuleUnitExpression"
    // InternalStoryGen.g:628:1: entryRuleUnitExpression : ruleUnitExpression EOF ;
    public final void entryRuleUnitExpression() throws RecognitionException {
        try {
            // InternalStoryGen.g:629:1: ( ruleUnitExpression EOF )
            // InternalStoryGen.g:630:1: ruleUnitExpression EOF
            {
             before(grammarAccess.getUnitExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleUnitExpression();

            state._fsp--;

             after(grammarAccess.getUnitExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnitExpression"


    // $ANTLR start "ruleUnitExpression"
    // InternalStoryGen.g:637:1: ruleUnitExpression : ( ( rule__UnitExpression__Alternatives ) ) ;
    public final void ruleUnitExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:641:2: ( ( ( rule__UnitExpression__Alternatives ) ) )
            // InternalStoryGen.g:642:2: ( ( rule__UnitExpression__Alternatives ) )
            {
            // InternalStoryGen.g:642:2: ( ( rule__UnitExpression__Alternatives ) )
            // InternalStoryGen.g:643:3: ( rule__UnitExpression__Alternatives )
            {
             before(grammarAccess.getUnitExpressionAccess().getAlternatives()); 
            // InternalStoryGen.g:644:3: ( rule__UnitExpression__Alternatives )
            // InternalStoryGen.g:644:4: rule__UnitExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__UnitExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnitExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnitExpression"


    // $ANTLR start "entryRuleNegationExpression"
    // InternalStoryGen.g:653:1: entryRuleNegationExpression : ruleNegationExpression EOF ;
    public final void entryRuleNegationExpression() throws RecognitionException {
        try {
            // InternalStoryGen.g:654:1: ( ruleNegationExpression EOF )
            // InternalStoryGen.g:655:1: ruleNegationExpression EOF
            {
             before(grammarAccess.getNegationExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleNegationExpression();

            state._fsp--;

             after(grammarAccess.getNegationExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNegationExpression"


    // $ANTLR start "ruleNegationExpression"
    // InternalStoryGen.g:662:1: ruleNegationExpression : ( ( rule__NegationExpression__Group__0 ) ) ;
    public final void ruleNegationExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:666:2: ( ( ( rule__NegationExpression__Group__0 ) ) )
            // InternalStoryGen.g:667:2: ( ( rule__NegationExpression__Group__0 ) )
            {
            // InternalStoryGen.g:667:2: ( ( rule__NegationExpression__Group__0 ) )
            // InternalStoryGen.g:668:3: ( rule__NegationExpression__Group__0 )
            {
             before(grammarAccess.getNegationExpressionAccess().getGroup()); 
            // InternalStoryGen.g:669:3: ( rule__NegationExpression__Group__0 )
            // InternalStoryGen.g:669:4: rule__NegationExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NegationExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNegationExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegationExpression"


    // $ANTLR start "entryRuleUnitaryExpression"
    // InternalStoryGen.g:678:1: entryRuleUnitaryExpression : ruleUnitaryExpression EOF ;
    public final void entryRuleUnitaryExpression() throws RecognitionException {
        try {
            // InternalStoryGen.g:679:1: ( ruleUnitaryExpression EOF )
            // InternalStoryGen.g:680:1: ruleUnitaryExpression EOF
            {
             before(grammarAccess.getUnitaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleUnitaryExpression();

            state._fsp--;

             after(grammarAccess.getUnitaryExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnitaryExpression"


    // $ANTLR start "ruleUnitaryExpression"
    // InternalStoryGen.g:687:1: ruleUnitaryExpression : ( ( rule__UnitaryExpression__Alternatives ) ) ;
    public final void ruleUnitaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:691:2: ( ( ( rule__UnitaryExpression__Alternatives ) ) )
            // InternalStoryGen.g:692:2: ( ( rule__UnitaryExpression__Alternatives ) )
            {
            // InternalStoryGen.g:692:2: ( ( rule__UnitaryExpression__Alternatives ) )
            // InternalStoryGen.g:693:3: ( rule__UnitaryExpression__Alternatives )
            {
             before(grammarAccess.getUnitaryExpressionAccess().getAlternatives()); 
            // InternalStoryGen.g:694:3: ( rule__UnitaryExpression__Alternatives )
            // InternalStoryGen.g:694:4: rule__UnitaryExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__UnitaryExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnitaryExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnitaryExpression"


    // $ANTLR start "entryRuleTerm"
    // InternalStoryGen.g:703:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // InternalStoryGen.g:704:1: ( ruleTerm EOF )
            // InternalStoryGen.g:705:1: ruleTerm EOF
            {
             before(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            ruleTerm();

            state._fsp--;

             after(grammarAccess.getTermRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalStoryGen.g:712:1: ruleTerm : ( ( rule__Term__Alternatives ) ) ;
    public final void ruleTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:716:2: ( ( ( rule__Term__Alternatives ) ) )
            // InternalStoryGen.g:717:2: ( ( rule__Term__Alternatives ) )
            {
            // InternalStoryGen.g:717:2: ( ( rule__Term__Alternatives ) )
            // InternalStoryGen.g:718:3: ( rule__Term__Alternatives )
            {
             before(grammarAccess.getTermAccess().getAlternatives()); 
            // InternalStoryGen.g:719:3: ( rule__Term__Alternatives )
            // InternalStoryGen.g:719:4: rule__Term__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Term__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTermAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleExistentAttributeTerm"
    // InternalStoryGen.g:728:1: entryRuleExistentAttributeTerm : ruleExistentAttributeTerm EOF ;
    public final void entryRuleExistentAttributeTerm() throws RecognitionException {
        try {
            // InternalStoryGen.g:729:1: ( ruleExistentAttributeTerm EOF )
            // InternalStoryGen.g:730:1: ruleExistentAttributeTerm EOF
            {
             before(grammarAccess.getExistentAttributeTermRule()); 
            pushFollow(FOLLOW_1);
            ruleExistentAttributeTerm();

            state._fsp--;

             after(grammarAccess.getExistentAttributeTermRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExistentAttributeTerm"


    // $ANTLR start "ruleExistentAttributeTerm"
    // InternalStoryGen.g:737:1: ruleExistentAttributeTerm : ( ( rule__ExistentAttributeTerm__Group__0 ) ) ;
    public final void ruleExistentAttributeTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:741:2: ( ( ( rule__ExistentAttributeTerm__Group__0 ) ) )
            // InternalStoryGen.g:742:2: ( ( rule__ExistentAttributeTerm__Group__0 ) )
            {
            // InternalStoryGen.g:742:2: ( ( rule__ExistentAttributeTerm__Group__0 ) )
            // InternalStoryGen.g:743:3: ( rule__ExistentAttributeTerm__Group__0 )
            {
             before(grammarAccess.getExistentAttributeTermAccess().getGroup()); 
            // InternalStoryGen.g:744:3: ( rule__ExistentAttributeTerm__Group__0 )
            // InternalStoryGen.g:744:4: rule__ExistentAttributeTerm__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExistentAttributeTerm__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExistentAttributeTermAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExistentAttributeTerm"


    // $ANTLR start "entryRuleStoryAttributeTerm"
    // InternalStoryGen.g:753:1: entryRuleStoryAttributeTerm : ruleStoryAttributeTerm EOF ;
    public final void entryRuleStoryAttributeTerm() throws RecognitionException {
        try {
            // InternalStoryGen.g:754:1: ( ruleStoryAttributeTerm EOF )
            // InternalStoryGen.g:755:1: ruleStoryAttributeTerm EOF
            {
             before(grammarAccess.getStoryAttributeTermRule()); 
            pushFollow(FOLLOW_1);
            ruleStoryAttributeTerm();

            state._fsp--;

             after(grammarAccess.getStoryAttributeTermRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStoryAttributeTerm"


    // $ANTLR start "ruleStoryAttributeTerm"
    // InternalStoryGen.g:762:1: ruleStoryAttributeTerm : ( ( rule__StoryAttributeTerm__Group__0 ) ) ;
    public final void ruleStoryAttributeTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:766:2: ( ( ( rule__StoryAttributeTerm__Group__0 ) ) )
            // InternalStoryGen.g:767:2: ( ( rule__StoryAttributeTerm__Group__0 ) )
            {
            // InternalStoryGen.g:767:2: ( ( rule__StoryAttributeTerm__Group__0 ) )
            // InternalStoryGen.g:768:3: ( rule__StoryAttributeTerm__Group__0 )
            {
             before(grammarAccess.getStoryAttributeTermAccess().getGroup()); 
            // InternalStoryGen.g:769:3: ( rule__StoryAttributeTerm__Group__0 )
            // InternalStoryGen.g:769:4: rule__StoryAttributeTerm__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StoryAttributeTerm__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStoryAttributeTermAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStoryAttributeTerm"


    // $ANTLR start "entryRuleIntegerTerm"
    // InternalStoryGen.g:778:1: entryRuleIntegerTerm : ruleIntegerTerm EOF ;
    public final void entryRuleIntegerTerm() throws RecognitionException {
        try {
            // InternalStoryGen.g:779:1: ( ruleIntegerTerm EOF )
            // InternalStoryGen.g:780:1: ruleIntegerTerm EOF
            {
             before(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_1);
            ruleIntegerTerm();

            state._fsp--;

             after(grammarAccess.getIntegerTermRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntegerTerm"


    // $ANTLR start "ruleIntegerTerm"
    // InternalStoryGen.g:787:1: ruleIntegerTerm : ( ( rule__IntegerTerm__ValueAssignment ) ) ;
    public final void ruleIntegerTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:791:2: ( ( ( rule__IntegerTerm__ValueAssignment ) ) )
            // InternalStoryGen.g:792:2: ( ( rule__IntegerTerm__ValueAssignment ) )
            {
            // InternalStoryGen.g:792:2: ( ( rule__IntegerTerm__ValueAssignment ) )
            // InternalStoryGen.g:793:3: ( rule__IntegerTerm__ValueAssignment )
            {
             before(grammarAccess.getIntegerTermAccess().getValueAssignment()); 
            // InternalStoryGen.g:794:3: ( rule__IntegerTerm__ValueAssignment )
            // InternalStoryGen.g:794:4: rule__IntegerTerm__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IntegerTerm__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntegerTermAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleBooleanTerm"
    // InternalStoryGen.g:803:1: entryRuleBooleanTerm : ruleBooleanTerm EOF ;
    public final void entryRuleBooleanTerm() throws RecognitionException {
        try {
            // InternalStoryGen.g:804:1: ( ruleBooleanTerm EOF )
            // InternalStoryGen.g:805:1: ruleBooleanTerm EOF
            {
             before(grammarAccess.getBooleanTermRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanTerm();

            state._fsp--;

             after(grammarAccess.getBooleanTermRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanTerm"


    // $ANTLR start "ruleBooleanTerm"
    // InternalStoryGen.g:812:1: ruleBooleanTerm : ( ( rule__BooleanTerm__ValueAssignment ) ) ;
    public final void ruleBooleanTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:816:2: ( ( ( rule__BooleanTerm__ValueAssignment ) ) )
            // InternalStoryGen.g:817:2: ( ( rule__BooleanTerm__ValueAssignment ) )
            {
            // InternalStoryGen.g:817:2: ( ( rule__BooleanTerm__ValueAssignment ) )
            // InternalStoryGen.g:818:3: ( rule__BooleanTerm__ValueAssignment )
            {
             before(grammarAccess.getBooleanTermAccess().getValueAssignment()); 
            // InternalStoryGen.g:819:3: ( rule__BooleanTerm__ValueAssignment )
            // InternalStoryGen.g:819:4: rule__BooleanTerm__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__BooleanTerm__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBooleanTermAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanTerm"


    // $ANTLR start "ruleActionType"
    // InternalStoryGen.g:828:1: ruleActionType : ( ( rule__ActionType__Alternatives ) ) ;
    public final void ruleActionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:832:1: ( ( ( rule__ActionType__Alternatives ) ) )
            // InternalStoryGen.g:833:2: ( ( rule__ActionType__Alternatives ) )
            {
            // InternalStoryGen.g:833:2: ( ( rule__ActionType__Alternatives ) )
            // InternalStoryGen.g:834:3: ( rule__ActionType__Alternatives )
            {
             before(grammarAccess.getActionTypeAccess().getAlternatives()); 
            // InternalStoryGen.g:835:3: ( rule__ActionType__Alternatives )
            // InternalStoryGen.g:835:4: rule__ActionType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ActionType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getActionTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActionType"


    // $ANTLR start "ruleComparisonOperator"
    // InternalStoryGen.g:844:1: ruleComparisonOperator : ( ( rule__ComparisonOperator__Alternatives ) ) ;
    public final void ruleComparisonOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:848:1: ( ( ( rule__ComparisonOperator__Alternatives ) ) )
            // InternalStoryGen.g:849:2: ( ( rule__ComparisonOperator__Alternatives ) )
            {
            // InternalStoryGen.g:849:2: ( ( rule__ComparisonOperator__Alternatives ) )
            // InternalStoryGen.g:850:3: ( rule__ComparisonOperator__Alternatives )
            {
             before(grammarAccess.getComparisonOperatorAccess().getAlternatives()); 
            // InternalStoryGen.g:851:3: ( rule__ComparisonOperator__Alternatives )
            // InternalStoryGen.g:851:4: rule__ComparisonOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getComparisonOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparisonOperator"


    // $ANTLR start "ruleAttributionOperator"
    // InternalStoryGen.g:860:1: ruleAttributionOperator : ( ( rule__AttributionOperator__Alternatives ) ) ;
    public final void ruleAttributionOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:864:1: ( ( ( rule__AttributionOperator__Alternatives ) ) )
            // InternalStoryGen.g:865:2: ( ( rule__AttributionOperator__Alternatives ) )
            {
            // InternalStoryGen.g:865:2: ( ( rule__AttributionOperator__Alternatives ) )
            // InternalStoryGen.g:866:3: ( rule__AttributionOperator__Alternatives )
            {
             before(grammarAccess.getAttributionOperatorAccess().getAlternatives()); 
            // InternalStoryGen.g:867:3: ( rule__AttributionOperator__Alternatives )
            // InternalStoryGen.g:867:4: rule__AttributionOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AttributionOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAttributionOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributionOperator"


    // $ANTLR start "ruleOrder"
    // InternalStoryGen.g:876:1: ruleOrder : ( ( rule__Order__Alternatives ) ) ;
    public final void ruleOrder() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:880:1: ( ( ( rule__Order__Alternatives ) ) )
            // InternalStoryGen.g:881:2: ( ( rule__Order__Alternatives ) )
            {
            // InternalStoryGen.g:881:2: ( ( rule__Order__Alternatives ) )
            // InternalStoryGen.g:882:3: ( rule__Order__Alternatives )
            {
             before(grammarAccess.getOrderAccess().getAlternatives()); 
            // InternalStoryGen.g:883:3: ( rule__Order__Alternatives )
            // InternalStoryGen.g:883:4: rule__Order__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Order__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOrderAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrder"


    // $ANTLR start "ruleAttributeSettingFrequency"
    // InternalStoryGen.g:892:1: ruleAttributeSettingFrequency : ( ( rule__AttributeSettingFrequency__Alternatives ) ) ;
    public final void ruleAttributeSettingFrequency() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:896:1: ( ( ( rule__AttributeSettingFrequency__Alternatives ) ) )
            // InternalStoryGen.g:897:2: ( ( rule__AttributeSettingFrequency__Alternatives ) )
            {
            // InternalStoryGen.g:897:2: ( ( rule__AttributeSettingFrequency__Alternatives ) )
            // InternalStoryGen.g:898:3: ( rule__AttributeSettingFrequency__Alternatives )
            {
             before(grammarAccess.getAttributeSettingFrequencyAccess().getAlternatives()); 
            // InternalStoryGen.g:899:3: ( rule__AttributeSettingFrequency__Alternatives )
            // InternalStoryGen.g:899:4: rule__AttributeSettingFrequency__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AttributeSettingFrequency__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAttributeSettingFrequencyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeSettingFrequency"


    // $ANTLR start "ruleEventPriority"
    // InternalStoryGen.g:908:1: ruleEventPriority : ( ( rule__EventPriority__Alternatives ) ) ;
    public final void ruleEventPriority() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:912:1: ( ( ( rule__EventPriority__Alternatives ) ) )
            // InternalStoryGen.g:913:2: ( ( rule__EventPriority__Alternatives ) )
            {
            // InternalStoryGen.g:913:2: ( ( rule__EventPriority__Alternatives ) )
            // InternalStoryGen.g:914:3: ( rule__EventPriority__Alternatives )
            {
             before(grammarAccess.getEventPriorityAccess().getAlternatives()); 
            // InternalStoryGen.g:915:3: ( rule__EventPriority__Alternatives )
            // InternalStoryGen.g:915:4: rule__EventPriority__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EventPriority__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEventPriorityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEventPriority"


    // $ANTLR start "rule__Existent__Alternatives"
    // InternalStoryGen.g:923:1: rule__Existent__Alternatives : ( ( ruleActor ) | ( ruleObject ) );
    public final void rule__Existent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:927:1: ( ( ruleActor ) | ( ruleObject ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==43||LA1_0==69) ) {
                alt1=1;
            }
            else if ( (LA1_0==45) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalStoryGen.g:928:2: ( ruleActor )
                    {
                    // InternalStoryGen.g:928:2: ( ruleActor )
                    // InternalStoryGen.g:929:3: ruleActor
                    {
                     before(grammarAccess.getExistentAccess().getActorParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleActor();

                    state._fsp--;

                     after(grammarAccess.getExistentAccess().getActorParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:934:2: ( ruleObject )
                    {
                    // InternalStoryGen.g:934:2: ( ruleObject )
                    // InternalStoryGen.g:935:3: ruleObject
                    {
                     before(grammarAccess.getExistentAccess().getObjectParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleObject();

                    state._fsp--;

                     after(grammarAccess.getExistentAccess().getObjectParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Existent__Alternatives"


    // $ANTLR start "rule__Attribute__Alternatives"
    // InternalStoryGen.g:944:1: rule__Attribute__Alternatives : ( ( ruleFactAttribute ) | ( ruleQuantityAttribute ) );
    public final void rule__Attribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:948:1: ( ( ruleFactAttribute ) | ( ruleQuantityAttribute ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==46) ) {
                alt2=1;
            }
            else if ( (LA2_0==49) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalStoryGen.g:949:2: ( ruleFactAttribute )
                    {
                    // InternalStoryGen.g:949:2: ( ruleFactAttribute )
                    // InternalStoryGen.g:950:3: ruleFactAttribute
                    {
                     before(grammarAccess.getAttributeAccess().getFactAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleFactAttribute();

                    state._fsp--;

                     after(grammarAccess.getAttributeAccess().getFactAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:955:2: ( ruleQuantityAttribute )
                    {
                    // InternalStoryGen.g:955:2: ( ruleQuantityAttribute )
                    // InternalStoryGen.g:956:3: ruleQuantityAttribute
                    {
                     before(grammarAccess.getAttributeAccess().getQuantityAttributeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleQuantityAttribute();

                    state._fsp--;

                     after(grammarAccess.getAttributeAccess().getQuantityAttributeParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Alternatives"


    // $ANTLR start "rule__FactAttribute__Alternatives_3"
    // InternalStoryGen.g:965:1: rule__FactAttribute__Alternatives_3 : ( ( ( rule__FactAttribute__InitValueAssignment_3_0 ) ) | ( ( rule__FactAttribute__Group_3_1__0 ) ) );
    public final void rule__FactAttribute__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:969:1: ( ( ( rule__FactAttribute__InitValueAssignment_3_0 ) ) | ( ( rule__FactAttribute__Group_3_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=11 && LA3_0<=12)) ) {
                alt3=1;
            }
            else if ( (LA3_0==47) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalStoryGen.g:970:2: ( ( rule__FactAttribute__InitValueAssignment_3_0 ) )
                    {
                    // InternalStoryGen.g:970:2: ( ( rule__FactAttribute__InitValueAssignment_3_0 ) )
                    // InternalStoryGen.g:971:3: ( rule__FactAttribute__InitValueAssignment_3_0 )
                    {
                     before(grammarAccess.getFactAttributeAccess().getInitValueAssignment_3_0()); 
                    // InternalStoryGen.g:972:3: ( rule__FactAttribute__InitValueAssignment_3_0 )
                    // InternalStoryGen.g:972:4: rule__FactAttribute__InitValueAssignment_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FactAttribute__InitValueAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFactAttributeAccess().getInitValueAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:976:2: ( ( rule__FactAttribute__Group_3_1__0 ) )
                    {
                    // InternalStoryGen.g:976:2: ( ( rule__FactAttribute__Group_3_1__0 ) )
                    // InternalStoryGen.g:977:3: ( rule__FactAttribute__Group_3_1__0 )
                    {
                     before(grammarAccess.getFactAttributeAccess().getGroup_3_1()); 
                    // InternalStoryGen.g:978:3: ( rule__FactAttribute__Group_3_1__0 )
                    // InternalStoryGen.g:978:4: rule__FactAttribute__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FactAttribute__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFactAttributeAccess().getGroup_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Alternatives_3"


    // $ANTLR start "rule__AttributeSetting__Alternatives_0"
    // InternalStoryGen.g:986:1: rule__AttributeSetting__Alternatives_0 : ( ( ( rule__AttributeSetting__PositiveAssignment_0_0 ) ) | ( ( rule__AttributeSetting__NegativeAssignment_0_1 ) ) );
    public final void rule__AttributeSetting__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:990:1: ( ( ( rule__AttributeSetting__PositiveAssignment_0_0 ) ) | ( ( rule__AttributeSetting__NegativeAssignment_0_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==70) ) {
                alt4=1;
            }
            else if ( (LA4_0==71) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalStoryGen.g:991:2: ( ( rule__AttributeSetting__PositiveAssignment_0_0 ) )
                    {
                    // InternalStoryGen.g:991:2: ( ( rule__AttributeSetting__PositiveAssignment_0_0 ) )
                    // InternalStoryGen.g:992:3: ( rule__AttributeSetting__PositiveAssignment_0_0 )
                    {
                     before(grammarAccess.getAttributeSettingAccess().getPositiveAssignment_0_0()); 
                    // InternalStoryGen.g:993:3: ( rule__AttributeSetting__PositiveAssignment_0_0 )
                    // InternalStoryGen.g:993:4: rule__AttributeSetting__PositiveAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttributeSetting__PositiveAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeSettingAccess().getPositiveAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:997:2: ( ( rule__AttributeSetting__NegativeAssignment_0_1 ) )
                    {
                    // InternalStoryGen.g:997:2: ( ( rule__AttributeSetting__NegativeAssignment_0_1 ) )
                    // InternalStoryGen.g:998:3: ( rule__AttributeSetting__NegativeAssignment_0_1 )
                    {
                     before(grammarAccess.getAttributeSettingAccess().getNegativeAssignment_0_1()); 
                    // InternalStoryGen.g:999:3: ( rule__AttributeSetting__NegativeAssignment_0_1 )
                    // InternalStoryGen.g:999:4: rule__AttributeSetting__NegativeAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttributeSetting__NegativeAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeSettingAccess().getNegativeAssignment_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__Alternatives_0"


    // $ANTLR start "rule__Event__Alternatives"
    // InternalStoryGen.g:1007:1: rule__Event__Alternatives : ( ( ruleHappeningEvent ) | ( ruleActionEvent ) );
    public final void rule__Event__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1011:1: ( ( ruleHappeningEvent ) | ( ruleActionEvent ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==53||(LA5_0>=72 && LA5_0<=73)) ) {
                alt5=1;
            }
            else if ( (LA5_0==60) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalStoryGen.g:1012:2: ( ruleHappeningEvent )
                    {
                    // InternalStoryGen.g:1012:2: ( ruleHappeningEvent )
                    // InternalStoryGen.g:1013:3: ruleHappeningEvent
                    {
                     before(grammarAccess.getEventAccess().getHappeningEventParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleHappeningEvent();

                    state._fsp--;

                     after(grammarAccess.getEventAccess().getHappeningEventParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1018:2: ( ruleActionEvent )
                    {
                    // InternalStoryGen.g:1018:2: ( ruleActionEvent )
                    // InternalStoryGen.g:1019:3: ruleActionEvent
                    {
                     before(grammarAccess.getEventAccess().getActionEventParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleActionEvent();

                    state._fsp--;

                     after(grammarAccess.getEventAccess().getActionEventParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Alternatives"


    // $ANTLR start "rule__HappeningEvent__Alternatives_0"
    // InternalStoryGen.g:1028:1: rule__HappeningEvent__Alternatives_0 : ( ( ( rule__HappeningEvent__OpeningAssignment_0_0 ) ) | ( ( rule__HappeningEvent__EndingAssignment_0_1 ) ) );
    public final void rule__HappeningEvent__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1032:1: ( ( ( rule__HappeningEvent__OpeningAssignment_0_0 ) ) | ( ( rule__HappeningEvent__EndingAssignment_0_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==72) ) {
                alt6=1;
            }
            else if ( (LA6_0==73) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalStoryGen.g:1033:2: ( ( rule__HappeningEvent__OpeningAssignment_0_0 ) )
                    {
                    // InternalStoryGen.g:1033:2: ( ( rule__HappeningEvent__OpeningAssignment_0_0 ) )
                    // InternalStoryGen.g:1034:3: ( rule__HappeningEvent__OpeningAssignment_0_0 )
                    {
                     before(grammarAccess.getHappeningEventAccess().getOpeningAssignment_0_0()); 
                    // InternalStoryGen.g:1035:3: ( rule__HappeningEvent__OpeningAssignment_0_0 )
                    // InternalStoryGen.g:1035:4: rule__HappeningEvent__OpeningAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HappeningEvent__OpeningAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getHappeningEventAccess().getOpeningAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1039:2: ( ( rule__HappeningEvent__EndingAssignment_0_1 ) )
                    {
                    // InternalStoryGen.g:1039:2: ( ( rule__HappeningEvent__EndingAssignment_0_1 ) )
                    // InternalStoryGen.g:1040:3: ( rule__HappeningEvent__EndingAssignment_0_1 )
                    {
                     before(grammarAccess.getHappeningEventAccess().getEndingAssignment_0_1()); 
                    // InternalStoryGen.g:1041:3: ( rule__HappeningEvent__EndingAssignment_0_1 )
                    // InternalStoryGen.g:1041:4: rule__HappeningEvent__EndingAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__HappeningEvent__EndingAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getHappeningEventAccess().getEndingAssignment_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Alternatives_0"


    // $ANTLR start "rule__Condition__Alternatives"
    // InternalStoryGen.g:1049:1: rule__Condition__Alternatives : ( ( ruleExpressionCondition ) | ( ruleOrderCondition ) | ( ruleTriggerCondition ) );
    public final void rule__Condition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1053:1: ( ( ruleExpressionCondition ) | ( ruleOrderCondition ) | ( ruleTriggerCondition ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==63) ) {
                switch ( input.LA(2) ) {
                case 28:
                case 29:
                    {
                    alt7=2;
                    }
                    break;
                case RULE_ID:
                case RULE_INT:
                case 11:
                case 12:
                case 37:
                case 47:
                case 68:
                    {
                    alt7=1;
                    }
                    break;
                case 74:
                    {
                    alt7=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalStoryGen.g:1054:2: ( ruleExpressionCondition )
                    {
                    // InternalStoryGen.g:1054:2: ( ruleExpressionCondition )
                    // InternalStoryGen.g:1055:3: ruleExpressionCondition
                    {
                     before(grammarAccess.getConditionAccess().getExpressionConditionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleExpressionCondition();

                    state._fsp--;

                     after(grammarAccess.getConditionAccess().getExpressionConditionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1060:2: ( ruleOrderCondition )
                    {
                    // InternalStoryGen.g:1060:2: ( ruleOrderCondition )
                    // InternalStoryGen.g:1061:3: ruleOrderCondition
                    {
                     before(grammarAccess.getConditionAccess().getOrderConditionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleOrderCondition();

                    state._fsp--;

                     after(grammarAccess.getConditionAccess().getOrderConditionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1066:2: ( ruleTriggerCondition )
                    {
                    // InternalStoryGen.g:1066:2: ( ruleTriggerCondition )
                    // InternalStoryGen.g:1067:3: ruleTriggerCondition
                    {
                     before(grammarAccess.getConditionAccess().getTriggerConditionParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleTriggerCondition();

                    state._fsp--;

                     after(grammarAccess.getConditionAccess().getTriggerConditionParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Alternatives"


    // $ANTLR start "rule__Change__Alternatives"
    // InternalStoryGen.g:1076:1: rule__Change__Alternatives : ( ( ruleExistentChange ) | ( ruleStoryDataChange ) );
    public final void rule__Change__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1080:1: ( ( ruleExistentChange ) | ( ruleStoryDataChange ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==64) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==37) ) {
                    alt8=2;
                }
                else if ( (LA8_1==RULE_ID) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalStoryGen.g:1081:2: ( ruleExistentChange )
                    {
                    // InternalStoryGen.g:1081:2: ( ruleExistentChange )
                    // InternalStoryGen.g:1082:3: ruleExistentChange
                    {
                     before(grammarAccess.getChangeAccess().getExistentChangeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleExistentChange();

                    state._fsp--;

                     after(grammarAccess.getChangeAccess().getExistentChangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1087:2: ( ruleStoryDataChange )
                    {
                    // InternalStoryGen.g:1087:2: ( ruleStoryDataChange )
                    // InternalStoryGen.g:1088:3: ruleStoryDataChange
                    {
                     before(grammarAccess.getChangeAccess().getStoryDataChangeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleStoryDataChange();

                    state._fsp--;

                     after(grammarAccess.getChangeAccess().getStoryDataChangeParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Change__Alternatives"


    // $ANTLR start "rule__ExistentChange__TermAlternatives_5_0"
    // InternalStoryGen.g:1097:1: rule__ExistentChange__TermAlternatives_5_0 : ( ( ruleIntegerTerm ) | ( ruleBooleanTerm ) );
    public final void rule__ExistentChange__TermAlternatives_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1101:1: ( ( ruleIntegerTerm ) | ( ruleBooleanTerm ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=11 && LA9_0<=12)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalStoryGen.g:1102:2: ( ruleIntegerTerm )
                    {
                    // InternalStoryGen.g:1102:2: ( ruleIntegerTerm )
                    // InternalStoryGen.g:1103:3: ruleIntegerTerm
                    {
                     before(grammarAccess.getExistentChangeAccess().getTermIntegerTermParserRuleCall_5_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIntegerTerm();

                    state._fsp--;

                     after(grammarAccess.getExistentChangeAccess().getTermIntegerTermParserRuleCall_5_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1108:2: ( ruleBooleanTerm )
                    {
                    // InternalStoryGen.g:1108:2: ( ruleBooleanTerm )
                    // InternalStoryGen.g:1109:3: ruleBooleanTerm
                    {
                     before(grammarAccess.getExistentChangeAccess().getTermBooleanTermParserRuleCall_5_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanTerm();

                    state._fsp--;

                     after(grammarAccess.getExistentChangeAccess().getTermBooleanTermParserRuleCall_5_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__TermAlternatives_5_0"


    // $ANTLR start "rule__StoryDataChange__TermAlternatives_5_0"
    // InternalStoryGen.g:1118:1: rule__StoryDataChange__TermAlternatives_5_0 : ( ( ruleIntegerTerm ) | ( ruleBooleanTerm ) );
    public final void rule__StoryDataChange__TermAlternatives_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1122:1: ( ( ruleIntegerTerm ) | ( ruleBooleanTerm ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=11 && LA10_0<=12)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalStoryGen.g:1123:2: ( ruleIntegerTerm )
                    {
                    // InternalStoryGen.g:1123:2: ( ruleIntegerTerm )
                    // InternalStoryGen.g:1124:3: ruleIntegerTerm
                    {
                     before(grammarAccess.getStoryDataChangeAccess().getTermIntegerTermParserRuleCall_5_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIntegerTerm();

                    state._fsp--;

                     after(grammarAccess.getStoryDataChangeAccess().getTermIntegerTermParserRuleCall_5_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1129:2: ( ruleBooleanTerm )
                    {
                    // InternalStoryGen.g:1129:2: ( ruleBooleanTerm )
                    // InternalStoryGen.g:1130:3: ruleBooleanTerm
                    {
                     before(grammarAccess.getStoryDataChangeAccess().getTermBooleanTermParserRuleCall_5_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanTerm();

                    state._fsp--;

                     after(grammarAccess.getStoryDataChangeAccess().getTermBooleanTermParserRuleCall_5_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__TermAlternatives_5_0"


    // $ANTLR start "rule__BinaryExpression__Alternatives_1"
    // InternalStoryGen.g:1139:1: rule__BinaryExpression__Alternatives_1 : ( ( ( rule__BinaryExpression__Group_1_0__0 ) ) | ( ( rule__BinaryExpression__Group_1_1__0 ) ) | ( ( rule__BinaryExpression__Group_1_2__0 ) ) );
    public final void rule__BinaryExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1143:1: ( ( ( rule__BinaryExpression__Group_1_0__0 ) ) | ( ( rule__BinaryExpression__Group_1_1__0 ) ) | ( ( rule__BinaryExpression__Group_1_2__0 ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt11=1;
                }
                break;
            case 67:
                {
                alt11=2;
                }
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalStoryGen.g:1144:2: ( ( rule__BinaryExpression__Group_1_0__0 ) )
                    {
                    // InternalStoryGen.g:1144:2: ( ( rule__BinaryExpression__Group_1_0__0 ) )
                    // InternalStoryGen.g:1145:3: ( rule__BinaryExpression__Group_1_0__0 )
                    {
                     before(grammarAccess.getBinaryExpressionAccess().getGroup_1_0()); 
                    // InternalStoryGen.g:1146:3: ( rule__BinaryExpression__Group_1_0__0 )
                    // InternalStoryGen.g:1146:4: rule__BinaryExpression__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BinaryExpression__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBinaryExpressionAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1150:2: ( ( rule__BinaryExpression__Group_1_1__0 ) )
                    {
                    // InternalStoryGen.g:1150:2: ( ( rule__BinaryExpression__Group_1_1__0 ) )
                    // InternalStoryGen.g:1151:3: ( rule__BinaryExpression__Group_1_1__0 )
                    {
                     before(grammarAccess.getBinaryExpressionAccess().getGroup_1_1()); 
                    // InternalStoryGen.g:1152:3: ( rule__BinaryExpression__Group_1_1__0 )
                    // InternalStoryGen.g:1152:4: rule__BinaryExpression__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BinaryExpression__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBinaryExpressionAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1156:2: ( ( rule__BinaryExpression__Group_1_2__0 ) )
                    {
                    // InternalStoryGen.g:1156:2: ( ( rule__BinaryExpression__Group_1_2__0 ) )
                    // InternalStoryGen.g:1157:3: ( rule__BinaryExpression__Group_1_2__0 )
                    {
                     before(grammarAccess.getBinaryExpressionAccess().getGroup_1_2()); 
                    // InternalStoryGen.g:1158:3: ( rule__BinaryExpression__Group_1_2__0 )
                    // InternalStoryGen.g:1158:4: rule__BinaryExpression__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BinaryExpression__Group_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBinaryExpressionAccess().getGroup_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Alternatives_1"


    // $ANTLR start "rule__UnitExpression__Alternatives"
    // InternalStoryGen.g:1166:1: rule__UnitExpression__Alternatives : ( ( ruleNegationExpression ) | ( ruleUnitaryExpression ) );
    public final void rule__UnitExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1170:1: ( ( ruleNegationExpression ) | ( ruleUnitaryExpression ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==68) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID||LA12_0==RULE_INT||(LA12_0>=11 && LA12_0<=12)||LA12_0==37||LA12_0==47) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalStoryGen.g:1171:2: ( ruleNegationExpression )
                    {
                    // InternalStoryGen.g:1171:2: ( ruleNegationExpression )
                    // InternalStoryGen.g:1172:3: ruleNegationExpression
                    {
                     before(grammarAccess.getUnitExpressionAccess().getNegationExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNegationExpression();

                    state._fsp--;

                     after(grammarAccess.getUnitExpressionAccess().getNegationExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1177:2: ( ruleUnitaryExpression )
                    {
                    // InternalStoryGen.g:1177:2: ( ruleUnitaryExpression )
                    // InternalStoryGen.g:1178:3: ruleUnitaryExpression
                    {
                     before(grammarAccess.getUnitExpressionAccess().getUnitaryExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleUnitaryExpression();

                    state._fsp--;

                     after(grammarAccess.getUnitExpressionAccess().getUnitaryExpressionParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitExpression__Alternatives"


    // $ANTLR start "rule__UnitaryExpression__Alternatives"
    // InternalStoryGen.g:1187:1: rule__UnitaryExpression__Alternatives : ( ( ( rule__UnitaryExpression__Group_0__0 ) ) | ( ruleTerm ) );
    public final void rule__UnitaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1191:1: ( ( ( rule__UnitaryExpression__Group_0__0 ) ) | ( ruleTerm ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==47) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID||LA13_0==RULE_INT||(LA13_0>=11 && LA13_0<=12)||LA13_0==37) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalStoryGen.g:1192:2: ( ( rule__UnitaryExpression__Group_0__0 ) )
                    {
                    // InternalStoryGen.g:1192:2: ( ( rule__UnitaryExpression__Group_0__0 ) )
                    // InternalStoryGen.g:1193:3: ( rule__UnitaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getUnitaryExpressionAccess().getGroup_0()); 
                    // InternalStoryGen.g:1194:3: ( rule__UnitaryExpression__Group_0__0 )
                    // InternalStoryGen.g:1194:4: rule__UnitaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnitaryExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnitaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1198:2: ( ruleTerm )
                    {
                    // InternalStoryGen.g:1198:2: ( ruleTerm )
                    // InternalStoryGen.g:1199:3: ruleTerm
                    {
                     before(grammarAccess.getUnitaryExpressionAccess().getTermParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleTerm();

                    state._fsp--;

                     after(grammarAccess.getUnitaryExpressionAccess().getTermParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitaryExpression__Alternatives"


    // $ANTLR start "rule__Term__Alternatives"
    // InternalStoryGen.g:1208:1: rule__Term__Alternatives : ( ( ruleExistentAttributeTerm ) | ( ruleStoryAttributeTerm ) | ( ruleIntegerTerm ) | ( ruleBooleanTerm ) );
    public final void rule__Term__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1212:1: ( ( ruleExistentAttributeTerm ) | ( ruleStoryAttributeTerm ) | ( ruleIntegerTerm ) | ( ruleBooleanTerm ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt14=1;
                }
                break;
            case 37:
                {
                alt14=2;
                }
                break;
            case RULE_INT:
                {
                alt14=3;
                }
                break;
            case 11:
            case 12:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalStoryGen.g:1213:2: ( ruleExistentAttributeTerm )
                    {
                    // InternalStoryGen.g:1213:2: ( ruleExistentAttributeTerm )
                    // InternalStoryGen.g:1214:3: ruleExistentAttributeTerm
                    {
                     before(grammarAccess.getTermAccess().getExistentAttributeTermParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleExistentAttributeTerm();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getExistentAttributeTermParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1219:2: ( ruleStoryAttributeTerm )
                    {
                    // InternalStoryGen.g:1219:2: ( ruleStoryAttributeTerm )
                    // InternalStoryGen.g:1220:3: ruleStoryAttributeTerm
                    {
                     before(grammarAccess.getTermAccess().getStoryAttributeTermParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleStoryAttributeTerm();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getStoryAttributeTermParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1225:2: ( ruleIntegerTerm )
                    {
                    // InternalStoryGen.g:1225:2: ( ruleIntegerTerm )
                    // InternalStoryGen.g:1226:3: ruleIntegerTerm
                    {
                     before(grammarAccess.getTermAccess().getIntegerTermParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleIntegerTerm();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getIntegerTermParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:1231:2: ( ruleBooleanTerm )
                    {
                    // InternalStoryGen.g:1231:2: ( ruleBooleanTerm )
                    // InternalStoryGen.g:1232:3: ruleBooleanTerm
                    {
                     before(grammarAccess.getTermAccess().getBooleanTermParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanTerm();

                    state._fsp--;

                     after(grammarAccess.getTermAccess().getBooleanTermParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Alternatives"


    // $ANTLR start "rule__BooleanTerm__ValueAlternatives_0"
    // InternalStoryGen.g:1241:1: rule__BooleanTerm__ValueAlternatives_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BooleanTerm__ValueAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1245:1: ( ( 'true' ) | ( 'false' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==11) ) {
                alt15=1;
            }
            else if ( (LA15_0==12) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalStoryGen.g:1246:2: ( 'true' )
                    {
                    // InternalStoryGen.g:1246:2: ( 'true' )
                    // InternalStoryGen.g:1247:3: 'true'
                    {
                     before(grammarAccess.getBooleanTermAccess().getValueTrueKeyword_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getBooleanTermAccess().getValueTrueKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1252:2: ( 'false' )
                    {
                    // InternalStoryGen.g:1252:2: ( 'false' )
                    // InternalStoryGen.g:1253:3: 'false'
                    {
                     before(grammarAccess.getBooleanTermAccess().getValueFalseKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getBooleanTermAccess().getValueFalseKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanTerm__ValueAlternatives_0"


    // $ANTLR start "rule__ActionType__Alternatives"
    // InternalStoryGen.g:1262:1: rule__ActionType__Alternatives : ( ( ( 'visual' ) ) | ( ( 'interaction' ) ) | ( ( 'movement' ) ) | ( ( 'communication' ) ) | ( ( 'combat' ) ) | ( ( 'idle' ) ) );
    public final void rule__ActionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1266:1: ( ( ( 'visual' ) ) | ( ( 'interaction' ) ) | ( ( 'movement' ) ) | ( ( 'communication' ) ) | ( ( 'combat' ) ) | ( ( 'idle' ) ) )
            int alt16=6;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt16=1;
                }
                break;
            case 14:
                {
                alt16=2;
                }
                break;
            case 15:
                {
                alt16=3;
                }
                break;
            case 16:
                {
                alt16=4;
                }
                break;
            case 17:
                {
                alt16=5;
                }
                break;
            case 18:
                {
                alt16=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalStoryGen.g:1267:2: ( ( 'visual' ) )
                    {
                    // InternalStoryGen.g:1267:2: ( ( 'visual' ) )
                    // InternalStoryGen.g:1268:3: ( 'visual' )
                    {
                     before(grammarAccess.getActionTypeAccess().getVISUALEnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:1269:3: ( 'visual' )
                    // InternalStoryGen.g:1269:4: 'visual'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionTypeAccess().getVISUALEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1273:2: ( ( 'interaction' ) )
                    {
                    // InternalStoryGen.g:1273:2: ( ( 'interaction' ) )
                    // InternalStoryGen.g:1274:3: ( 'interaction' )
                    {
                     before(grammarAccess.getActionTypeAccess().getINTERACTIONEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:1275:3: ( 'interaction' )
                    // InternalStoryGen.g:1275:4: 'interaction'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionTypeAccess().getINTERACTIONEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1279:2: ( ( 'movement' ) )
                    {
                    // InternalStoryGen.g:1279:2: ( ( 'movement' ) )
                    // InternalStoryGen.g:1280:3: ( 'movement' )
                    {
                     before(grammarAccess.getActionTypeAccess().getMOVEMENTEnumLiteralDeclaration_2()); 
                    // InternalStoryGen.g:1281:3: ( 'movement' )
                    // InternalStoryGen.g:1281:4: 'movement'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionTypeAccess().getMOVEMENTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:1285:2: ( ( 'communication' ) )
                    {
                    // InternalStoryGen.g:1285:2: ( ( 'communication' ) )
                    // InternalStoryGen.g:1286:3: ( 'communication' )
                    {
                     before(grammarAccess.getActionTypeAccess().getCOMMUNICATIONEnumLiteralDeclaration_3()); 
                    // InternalStoryGen.g:1287:3: ( 'communication' )
                    // InternalStoryGen.g:1287:4: 'communication'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionTypeAccess().getCOMMUNICATIONEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGen.g:1291:2: ( ( 'combat' ) )
                    {
                    // InternalStoryGen.g:1291:2: ( ( 'combat' ) )
                    // InternalStoryGen.g:1292:3: ( 'combat' )
                    {
                     before(grammarAccess.getActionTypeAccess().getCOMBATEnumLiteralDeclaration_4()); 
                    // InternalStoryGen.g:1293:3: ( 'combat' )
                    // InternalStoryGen.g:1293:4: 'combat'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionTypeAccess().getCOMBATEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalStoryGen.g:1297:2: ( ( 'idle' ) )
                    {
                    // InternalStoryGen.g:1297:2: ( ( 'idle' ) )
                    // InternalStoryGen.g:1298:3: ( 'idle' )
                    {
                     before(grammarAccess.getActionTypeAccess().getIDLEEnumLiteralDeclaration_5()); 
                    // InternalStoryGen.g:1299:3: ( 'idle' )
                    // InternalStoryGen.g:1299:4: 'idle'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getActionTypeAccess().getIDLEEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionType__Alternatives"


    // $ANTLR start "rule__ComparisonOperator__Alternatives"
    // InternalStoryGen.g:1307:1: rule__ComparisonOperator__Alternatives : ( ( ( '<' ) ) | ( ( '<=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '>=' ) ) | ( ( '>' ) ) );
    public final void rule__ComparisonOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1311:1: ( ( ( '<' ) ) | ( ( '<=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '>=' ) ) | ( ( '>' ) ) )
            int alt17=6;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt17=1;
                }
                break;
            case 20:
                {
                alt17=2;
                }
                break;
            case 21:
                {
                alt17=3;
                }
                break;
            case 22:
                {
                alt17=4;
                }
                break;
            case 23:
                {
                alt17=5;
                }
                break;
            case 24:
                {
                alt17=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalStoryGen.g:1312:2: ( ( '<' ) )
                    {
                    // InternalStoryGen.g:1312:2: ( ( '<' ) )
                    // InternalStoryGen.g:1313:3: ( '<' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:1314:3: ( '<' )
                    // InternalStoryGen.g:1314:4: '<'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1318:2: ( ( '<=' ) )
                    {
                    // InternalStoryGen.g:1318:2: ( ( '<=' ) )
                    // InternalStoryGen.g:1319:3: ( '<=' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getLEEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:1320:3: ( '<=' )
                    // InternalStoryGen.g:1320:4: '<='
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getLEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1324:2: ( ( '==' ) )
                    {
                    // InternalStoryGen.g:1324:2: ( ( '==' ) )
                    // InternalStoryGen.g:1325:3: ( '==' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2()); 
                    // InternalStoryGen.g:1326:3: ( '==' )
                    // InternalStoryGen.g:1326:4: '=='
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:1330:2: ( ( '!=' ) )
                    {
                    // InternalStoryGen.g:1330:2: ( ( '!=' ) )
                    // InternalStoryGen.g:1331:3: ( '!=' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3()); 
                    // InternalStoryGen.g:1332:3: ( '!=' )
                    // InternalStoryGen.g:1332:4: '!='
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGen.g:1336:2: ( ( '>=' ) )
                    {
                    // InternalStoryGen.g:1336:2: ( ( '>=' ) )
                    // InternalStoryGen.g:1337:3: ( '>=' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getGEEnumLiteralDeclaration_4()); 
                    // InternalStoryGen.g:1338:3: ( '>=' )
                    // InternalStoryGen.g:1338:4: '>='
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getGEEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalStoryGen.g:1342:2: ( ( '>' ) )
                    {
                    // InternalStoryGen.g:1342:2: ( ( '>' ) )
                    // InternalStoryGen.g:1343:3: ( '>' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_5()); 
                    // InternalStoryGen.g:1344:3: ( '>' )
                    // InternalStoryGen.g:1344:4: '>'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOperator__Alternatives"


    // $ANTLR start "rule__AttributionOperator__Alternatives"
    // InternalStoryGen.g:1352:1: rule__AttributionOperator__Alternatives : ( ( ( '=' ) ) | ( ( '+=' ) ) | ( ( '-=' ) ) );
    public final void rule__AttributionOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1356:1: ( ( ( '=' ) ) | ( ( '+=' ) ) | ( ( '-=' ) ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt18=1;
                }
                break;
            case 26:
                {
                alt18=2;
                }
                break;
            case 27:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalStoryGen.g:1357:2: ( ( '=' ) )
                    {
                    // InternalStoryGen.g:1357:2: ( ( '=' ) )
                    // InternalStoryGen.g:1358:3: ( '=' )
                    {
                     before(grammarAccess.getAttributionOperatorAccess().getASSIGNEnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:1359:3: ( '=' )
                    // InternalStoryGen.g:1359:4: '='
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getAttributionOperatorAccess().getASSIGNEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1363:2: ( ( '+=' ) )
                    {
                    // InternalStoryGen.g:1363:2: ( ( '+=' ) )
                    // InternalStoryGen.g:1364:3: ( '+=' )
                    {
                     before(grammarAccess.getAttributionOperatorAccess().getINCREMENTEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:1365:3: ( '+=' )
                    // InternalStoryGen.g:1365:4: '+='
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getAttributionOperatorAccess().getINCREMENTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1369:2: ( ( '-=' ) )
                    {
                    // InternalStoryGen.g:1369:2: ( ( '-=' ) )
                    // InternalStoryGen.g:1370:3: ( '-=' )
                    {
                     before(grammarAccess.getAttributionOperatorAccess().getDECREMENTEnumLiteralDeclaration_2()); 
                    // InternalStoryGen.g:1371:3: ( '-=' )
                    // InternalStoryGen.g:1371:4: '-='
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getAttributionOperatorAccess().getDECREMENTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributionOperator__Alternatives"


    // $ANTLR start "rule__Order__Alternatives"
    // InternalStoryGen.g:1379:1: rule__Order__Alternatives : ( ( ( 'after' ) ) | ( ( 'before' ) ) );
    public final void rule__Order__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1383:1: ( ( ( 'after' ) ) | ( ( 'before' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            else if ( (LA19_0==29) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalStoryGen.g:1384:2: ( ( 'after' ) )
                    {
                    // InternalStoryGen.g:1384:2: ( ( 'after' ) )
                    // InternalStoryGen.g:1385:3: ( 'after' )
                    {
                     before(grammarAccess.getOrderAccess().getAFTEREnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:1386:3: ( 'after' )
                    // InternalStoryGen.g:1386:4: 'after'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getAFTEREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1390:2: ( ( 'before' ) )
                    {
                    // InternalStoryGen.g:1390:2: ( ( 'before' ) )
                    // InternalStoryGen.g:1391:3: ( 'before' )
                    {
                     before(grammarAccess.getOrderAccess().getBEFOREEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:1392:3: ( 'before' )
                    // InternalStoryGen.g:1392:4: 'before'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getBEFOREEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Order__Alternatives"


    // $ANTLR start "rule__AttributeSettingFrequency__Alternatives"
    // InternalStoryGen.g:1400:1: rule__AttributeSettingFrequency__Alternatives : ( ( ( 'every event' ) ) | ( ( 'every happening' ) ) | ( ( 'every action' ) ) | ( ( 'every player action' ) ) );
    public final void rule__AttributeSettingFrequency__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1404:1: ( ( ( 'every event' ) ) | ( ( 'every happening' ) ) | ( ( 'every action' ) ) | ( ( 'every player action' ) ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt20=1;
                }
                break;
            case 31:
                {
                alt20=2;
                }
                break;
            case 32:
                {
                alt20=3;
                }
                break;
            case 33:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalStoryGen.g:1405:2: ( ( 'every event' ) )
                    {
                    // InternalStoryGen.g:1405:2: ( ( 'every event' ) )
                    // InternalStoryGen.g:1406:3: ( 'every event' )
                    {
                     before(grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_EVENTEnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:1407:3: ( 'every event' )
                    // InternalStoryGen.g:1407:4: 'every event'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_EVENTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1411:2: ( ( 'every happening' ) )
                    {
                    // InternalStoryGen.g:1411:2: ( ( 'every happening' ) )
                    // InternalStoryGen.g:1412:3: ( 'every happening' )
                    {
                     before(grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_HAPPENINGEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:1413:3: ( 'every happening' )
                    // InternalStoryGen.g:1413:4: 'every happening'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_HAPPENINGEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1417:2: ( ( 'every action' ) )
                    {
                    // InternalStoryGen.g:1417:2: ( ( 'every action' ) )
                    // InternalStoryGen.g:1418:3: ( 'every action' )
                    {
                     before(grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_ACTIONEnumLiteralDeclaration_2()); 
                    // InternalStoryGen.g:1419:3: ( 'every action' )
                    // InternalStoryGen.g:1419:4: 'every action'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_ACTIONEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:1423:2: ( ( 'every player action' ) )
                    {
                    // InternalStoryGen.g:1423:2: ( ( 'every player action' ) )
                    // InternalStoryGen.g:1424:3: ( 'every player action' )
                    {
                     before(grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_PLAYER_ACTIONEnumLiteralDeclaration_3()); 
                    // InternalStoryGen.g:1425:3: ( 'every player action' )
                    // InternalStoryGen.g:1425:4: 'every player action'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getAttributeSettingFrequencyAccess().getEVERY_PLAYER_ACTIONEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSettingFrequency__Alternatives"


    // $ANTLR start "rule__EventPriority__Alternatives"
    // InternalStoryGen.g:1433:1: rule__EventPriority__Alternatives : ( ( ( 'normal' ) ) | ( ( 'high' ) ) | ( ( 'veryHigh' ) ) );
    public final void rule__EventPriority__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1437:1: ( ( ( 'normal' ) ) | ( ( 'high' ) ) | ( ( 'veryHigh' ) ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt21=1;
                }
                break;
            case 35:
                {
                alt21=2;
                }
                break;
            case 36:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalStoryGen.g:1438:2: ( ( 'normal' ) )
                    {
                    // InternalStoryGen.g:1438:2: ( ( 'normal' ) )
                    // InternalStoryGen.g:1439:3: ( 'normal' )
                    {
                     before(grammarAccess.getEventPriorityAccess().getNORMALEnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:1440:3: ( 'normal' )
                    // InternalStoryGen.g:1440:4: 'normal'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getEventPriorityAccess().getNORMALEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:1444:2: ( ( 'high' ) )
                    {
                    // InternalStoryGen.g:1444:2: ( ( 'high' ) )
                    // InternalStoryGen.g:1445:3: ( 'high' )
                    {
                     before(grammarAccess.getEventPriorityAccess().getHIGHEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:1446:3: ( 'high' )
                    // InternalStoryGen.g:1446:4: 'high'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getEventPriorityAccess().getHIGHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:1450:2: ( ( 'veryHigh' ) )
                    {
                    // InternalStoryGen.g:1450:2: ( ( 'veryHigh' ) )
                    // InternalStoryGen.g:1451:3: ( 'veryHigh' )
                    {
                     before(grammarAccess.getEventPriorityAccess().getVERY_HIGHEnumLiteralDeclaration_2()); 
                    // InternalStoryGen.g:1452:3: ( 'veryHigh' )
                    // InternalStoryGen.g:1452:4: 'veryHigh'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getEventPriorityAccess().getVERY_HIGHEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventPriority__Alternatives"


    // $ANTLR start "rule__Story__Group__0"
    // InternalStoryGen.g:1460:1: rule__Story__Group__0 : rule__Story__Group__0__Impl rule__Story__Group__1 ;
    public final void rule__Story__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1464:1: ( rule__Story__Group__0__Impl rule__Story__Group__1 )
            // InternalStoryGen.g:1465:2: rule__Story__Group__0__Impl rule__Story__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Story__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Story__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__0"


    // $ANTLR start "rule__Story__Group__0__Impl"
    // InternalStoryGen.g:1472:1: rule__Story__Group__0__Impl : ( ( rule__Story__DataAssignment_0 ) ) ;
    public final void rule__Story__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1476:1: ( ( ( rule__Story__DataAssignment_0 ) ) )
            // InternalStoryGen.g:1477:1: ( ( rule__Story__DataAssignment_0 ) )
            {
            // InternalStoryGen.g:1477:1: ( ( rule__Story__DataAssignment_0 ) )
            // InternalStoryGen.g:1478:2: ( rule__Story__DataAssignment_0 )
            {
             before(grammarAccess.getStoryAccess().getDataAssignment_0()); 
            // InternalStoryGen.g:1479:2: ( rule__Story__DataAssignment_0 )
            // InternalStoryGen.g:1479:3: rule__Story__DataAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Story__DataAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getStoryAccess().getDataAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__0__Impl"


    // $ANTLR start "rule__Story__Group__1"
    // InternalStoryGen.g:1487:1: rule__Story__Group__1 : rule__Story__Group__1__Impl rule__Story__Group__2 ;
    public final void rule__Story__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1491:1: ( rule__Story__Group__1__Impl rule__Story__Group__2 )
            // InternalStoryGen.g:1492:2: rule__Story__Group__1__Impl rule__Story__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Story__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Story__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__1"


    // $ANTLR start "rule__Story__Group__1__Impl"
    // InternalStoryGen.g:1499:1: rule__Story__Group__1__Impl : ( ( rule__Story__SpaceAssignment_1 ) ) ;
    public final void rule__Story__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1503:1: ( ( ( rule__Story__SpaceAssignment_1 ) ) )
            // InternalStoryGen.g:1504:1: ( ( rule__Story__SpaceAssignment_1 ) )
            {
            // InternalStoryGen.g:1504:1: ( ( rule__Story__SpaceAssignment_1 ) )
            // InternalStoryGen.g:1505:2: ( rule__Story__SpaceAssignment_1 )
            {
             before(grammarAccess.getStoryAccess().getSpaceAssignment_1()); 
            // InternalStoryGen.g:1506:2: ( rule__Story__SpaceAssignment_1 )
            // InternalStoryGen.g:1506:3: rule__Story__SpaceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Story__SpaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStoryAccess().getSpaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__1__Impl"


    // $ANTLR start "rule__Story__Group__2"
    // InternalStoryGen.g:1514:1: rule__Story__Group__2 : rule__Story__Group__2__Impl ;
    public final void rule__Story__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1518:1: ( rule__Story__Group__2__Impl )
            // InternalStoryGen.g:1519:2: rule__Story__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Story__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__2"


    // $ANTLR start "rule__Story__Group__2__Impl"
    // InternalStoryGen.g:1525:1: rule__Story__Group__2__Impl : ( ( rule__Story__PlotAssignment_2 ) ) ;
    public final void rule__Story__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1529:1: ( ( ( rule__Story__PlotAssignment_2 ) ) )
            // InternalStoryGen.g:1530:1: ( ( rule__Story__PlotAssignment_2 ) )
            {
            // InternalStoryGen.g:1530:1: ( ( rule__Story__PlotAssignment_2 ) )
            // InternalStoryGen.g:1531:2: ( rule__Story__PlotAssignment_2 )
            {
             before(grammarAccess.getStoryAccess().getPlotAssignment_2()); 
            // InternalStoryGen.g:1532:2: ( rule__Story__PlotAssignment_2 )
            // InternalStoryGen.g:1532:3: rule__Story__PlotAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Story__PlotAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStoryAccess().getPlotAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__Group__2__Impl"


    // $ANTLR start "rule__StoryData__Group__0"
    // InternalStoryGen.g:1541:1: rule__StoryData__Group__0 : rule__StoryData__Group__0__Impl rule__StoryData__Group__1 ;
    public final void rule__StoryData__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1545:1: ( rule__StoryData__Group__0__Impl rule__StoryData__Group__1 )
            // InternalStoryGen.g:1546:2: rule__StoryData__Group__0__Impl rule__StoryData__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__StoryData__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryData__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__0"


    // $ANTLR start "rule__StoryData__Group__0__Impl"
    // InternalStoryGen.g:1553:1: rule__StoryData__Group__0__Impl : ( () ) ;
    public final void rule__StoryData__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1557:1: ( ( () ) )
            // InternalStoryGen.g:1558:1: ( () )
            {
            // InternalStoryGen.g:1558:1: ( () )
            // InternalStoryGen.g:1559:2: ()
            {
             before(grammarAccess.getStoryDataAccess().getStoryDataAction_0()); 
            // InternalStoryGen.g:1560:2: ()
            // InternalStoryGen.g:1560:3: 
            {
            }

             after(grammarAccess.getStoryDataAccess().getStoryDataAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__0__Impl"


    // $ANTLR start "rule__StoryData__Group__1"
    // InternalStoryGen.g:1568:1: rule__StoryData__Group__1 : rule__StoryData__Group__1__Impl rule__StoryData__Group__2 ;
    public final void rule__StoryData__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1572:1: ( rule__StoryData__Group__1__Impl rule__StoryData__Group__2 )
            // InternalStoryGen.g:1573:2: rule__StoryData__Group__1__Impl rule__StoryData__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__StoryData__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryData__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__1"


    // $ANTLR start "rule__StoryData__Group__1__Impl"
    // InternalStoryGen.g:1580:1: rule__StoryData__Group__1__Impl : ( 'Story' ) ;
    public final void rule__StoryData__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1584:1: ( ( 'Story' ) )
            // InternalStoryGen.g:1585:1: ( 'Story' )
            {
            // InternalStoryGen.g:1585:1: ( 'Story' )
            // InternalStoryGen.g:1586:2: 'Story'
            {
             before(grammarAccess.getStoryDataAccess().getStoryKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getStoryDataAccess().getStoryKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__1__Impl"


    // $ANTLR start "rule__StoryData__Group__2"
    // InternalStoryGen.g:1595:1: rule__StoryData__Group__2 : rule__StoryData__Group__2__Impl rule__StoryData__Group__3 ;
    public final void rule__StoryData__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1599:1: ( rule__StoryData__Group__2__Impl rule__StoryData__Group__3 )
            // InternalStoryGen.g:1600:2: rule__StoryData__Group__2__Impl rule__StoryData__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__StoryData__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryData__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__2"


    // $ANTLR start "rule__StoryData__Group__2__Impl"
    // InternalStoryGen.g:1607:1: rule__StoryData__Group__2__Impl : ( 'data' ) ;
    public final void rule__StoryData__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1611:1: ( ( 'data' ) )
            // InternalStoryGen.g:1612:1: ( 'data' )
            {
            // InternalStoryGen.g:1612:1: ( 'data' )
            // InternalStoryGen.g:1613:2: 'data'
            {
             before(grammarAccess.getStoryDataAccess().getDataKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getStoryDataAccess().getDataKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__2__Impl"


    // $ANTLR start "rule__StoryData__Group__3"
    // InternalStoryGen.g:1622:1: rule__StoryData__Group__3 : rule__StoryData__Group__3__Impl rule__StoryData__Group__4 ;
    public final void rule__StoryData__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1626:1: ( rule__StoryData__Group__3__Impl rule__StoryData__Group__4 )
            // InternalStoryGen.g:1627:2: rule__StoryData__Group__3__Impl rule__StoryData__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__StoryData__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryData__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__3"


    // $ANTLR start "rule__StoryData__Group__3__Impl"
    // InternalStoryGen.g:1634:1: rule__StoryData__Group__3__Impl : ( '{' ) ;
    public final void rule__StoryData__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1638:1: ( ( '{' ) )
            // InternalStoryGen.g:1639:1: ( '{' )
            {
            // InternalStoryGen.g:1639:1: ( '{' )
            // InternalStoryGen.g:1640:2: '{'
            {
             before(grammarAccess.getStoryDataAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getStoryDataAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__3__Impl"


    // $ANTLR start "rule__StoryData__Group__4"
    // InternalStoryGen.g:1649:1: rule__StoryData__Group__4 : rule__StoryData__Group__4__Impl rule__StoryData__Group__5 ;
    public final void rule__StoryData__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1653:1: ( rule__StoryData__Group__4__Impl rule__StoryData__Group__5 )
            // InternalStoryGen.g:1654:2: rule__StoryData__Group__4__Impl rule__StoryData__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__StoryData__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryData__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__4"


    // $ANTLR start "rule__StoryData__Group__4__Impl"
    // InternalStoryGen.g:1661:1: rule__StoryData__Group__4__Impl : ( ( rule__StoryData__AttributesAssignment_4 )* ) ;
    public final void rule__StoryData__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1665:1: ( ( ( rule__StoryData__AttributesAssignment_4 )* ) )
            // InternalStoryGen.g:1666:1: ( ( rule__StoryData__AttributesAssignment_4 )* )
            {
            // InternalStoryGen.g:1666:1: ( ( rule__StoryData__AttributesAssignment_4 )* )
            // InternalStoryGen.g:1667:2: ( rule__StoryData__AttributesAssignment_4 )*
            {
             before(grammarAccess.getStoryDataAccess().getAttributesAssignment_4()); 
            // InternalStoryGen.g:1668:2: ( rule__StoryData__AttributesAssignment_4 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==46||LA22_0==49) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalStoryGen.g:1668:3: rule__StoryData__AttributesAssignment_4
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__StoryData__AttributesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getStoryDataAccess().getAttributesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__4__Impl"


    // $ANTLR start "rule__StoryData__Group__5"
    // InternalStoryGen.g:1676:1: rule__StoryData__Group__5 : rule__StoryData__Group__5__Impl ;
    public final void rule__StoryData__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1680:1: ( rule__StoryData__Group__5__Impl )
            // InternalStoryGen.g:1681:2: rule__StoryData__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StoryData__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__5"


    // $ANTLR start "rule__StoryData__Group__5__Impl"
    // InternalStoryGen.g:1687:1: rule__StoryData__Group__5__Impl : ( '}' ) ;
    public final void rule__StoryData__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1691:1: ( ( '}' ) )
            // InternalStoryGen.g:1692:1: ( '}' )
            {
            // InternalStoryGen.g:1692:1: ( '}' )
            // InternalStoryGen.g:1693:2: '}'
            {
             before(grammarAccess.getStoryDataAccess().getRightCurlyBracketKeyword_5()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getStoryDataAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__Group__5__Impl"


    // $ANTLR start "rule__Space__Group__0"
    // InternalStoryGen.g:1703:1: rule__Space__Group__0 : rule__Space__Group__0__Impl rule__Space__Group__1 ;
    public final void rule__Space__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1707:1: ( rule__Space__Group__0__Impl rule__Space__Group__1 )
            // InternalStoryGen.g:1708:2: rule__Space__Group__0__Impl rule__Space__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Space__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Space__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__0"


    // $ANTLR start "rule__Space__Group__0__Impl"
    // InternalStoryGen.g:1715:1: rule__Space__Group__0__Impl : ( () ) ;
    public final void rule__Space__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1719:1: ( ( () ) )
            // InternalStoryGen.g:1720:1: ( () )
            {
            // InternalStoryGen.g:1720:1: ( () )
            // InternalStoryGen.g:1721:2: ()
            {
             before(grammarAccess.getSpaceAccess().getSpaceAction_0()); 
            // InternalStoryGen.g:1722:2: ()
            // InternalStoryGen.g:1722:3: 
            {
            }

             after(grammarAccess.getSpaceAccess().getSpaceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__0__Impl"


    // $ANTLR start "rule__Space__Group__1"
    // InternalStoryGen.g:1730:1: rule__Space__Group__1 : rule__Space__Group__1__Impl rule__Space__Group__2 ;
    public final void rule__Space__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1734:1: ( rule__Space__Group__1__Impl rule__Space__Group__2 )
            // InternalStoryGen.g:1735:2: rule__Space__Group__1__Impl rule__Space__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Space__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Space__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__1"


    // $ANTLR start "rule__Space__Group__1__Impl"
    // InternalStoryGen.g:1742:1: rule__Space__Group__1__Impl : ( 'Space' ) ;
    public final void rule__Space__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1746:1: ( ( 'Space' ) )
            // InternalStoryGen.g:1747:1: ( 'Space' )
            {
            // InternalStoryGen.g:1747:1: ( 'Space' )
            // InternalStoryGen.g:1748:2: 'Space'
            {
             before(grammarAccess.getSpaceAccess().getSpaceKeyword_1()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getSpaceAccess().getSpaceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__1__Impl"


    // $ANTLR start "rule__Space__Group__2"
    // InternalStoryGen.g:1757:1: rule__Space__Group__2 : rule__Space__Group__2__Impl rule__Space__Group__3 ;
    public final void rule__Space__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1761:1: ( rule__Space__Group__2__Impl rule__Space__Group__3 )
            // InternalStoryGen.g:1762:2: rule__Space__Group__2__Impl rule__Space__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__Space__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Space__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__2"


    // $ANTLR start "rule__Space__Group__2__Impl"
    // InternalStoryGen.g:1769:1: rule__Space__Group__2__Impl : ( '{' ) ;
    public final void rule__Space__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1773:1: ( ( '{' ) )
            // InternalStoryGen.g:1774:1: ( '{' )
            {
            // InternalStoryGen.g:1774:1: ( '{' )
            // InternalStoryGen.g:1775:2: '{'
            {
             before(grammarAccess.getSpaceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getSpaceAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__2__Impl"


    // $ANTLR start "rule__Space__Group__3"
    // InternalStoryGen.g:1784:1: rule__Space__Group__3 : rule__Space__Group__3__Impl rule__Space__Group__4 ;
    public final void rule__Space__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1788:1: ( rule__Space__Group__3__Impl rule__Space__Group__4 )
            // InternalStoryGen.g:1789:2: rule__Space__Group__3__Impl rule__Space__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__Space__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Space__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__3"


    // $ANTLR start "rule__Space__Group__3__Impl"
    // InternalStoryGen.g:1796:1: rule__Space__Group__3__Impl : ( ( rule__Space__ExistentsAssignment_3 )* ) ;
    public final void rule__Space__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1800:1: ( ( ( rule__Space__ExistentsAssignment_3 )* ) )
            // InternalStoryGen.g:1801:1: ( ( rule__Space__ExistentsAssignment_3 )* )
            {
            // InternalStoryGen.g:1801:1: ( ( rule__Space__ExistentsAssignment_3 )* )
            // InternalStoryGen.g:1802:2: ( rule__Space__ExistentsAssignment_3 )*
            {
             before(grammarAccess.getSpaceAccess().getExistentsAssignment_3()); 
            // InternalStoryGen.g:1803:2: ( rule__Space__ExistentsAssignment_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==43||LA23_0==45||LA23_0==69) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalStoryGen.g:1803:3: rule__Space__ExistentsAssignment_3
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Space__ExistentsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getSpaceAccess().getExistentsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__3__Impl"


    // $ANTLR start "rule__Space__Group__4"
    // InternalStoryGen.g:1811:1: rule__Space__Group__4 : rule__Space__Group__4__Impl ;
    public final void rule__Space__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1815:1: ( rule__Space__Group__4__Impl )
            // InternalStoryGen.g:1816:2: rule__Space__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Space__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__4"


    // $ANTLR start "rule__Space__Group__4__Impl"
    // InternalStoryGen.g:1822:1: rule__Space__Group__4__Impl : ( '}' ) ;
    public final void rule__Space__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1826:1: ( ( '}' ) )
            // InternalStoryGen.g:1827:1: ( '}' )
            {
            // InternalStoryGen.g:1827:1: ( '}' )
            // InternalStoryGen.g:1828:2: '}'
            {
             before(grammarAccess.getSpaceAccess().getRightCurlyBracketKeyword_4()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getSpaceAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group__4__Impl"


    // $ANTLR start "rule__Plot__Group__0"
    // InternalStoryGen.g:1838:1: rule__Plot__Group__0 : rule__Plot__Group__0__Impl rule__Plot__Group__1 ;
    public final void rule__Plot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1842:1: ( rule__Plot__Group__0__Impl rule__Plot__Group__1 )
            // InternalStoryGen.g:1843:2: rule__Plot__Group__0__Impl rule__Plot__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Plot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Plot__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__0"


    // $ANTLR start "rule__Plot__Group__0__Impl"
    // InternalStoryGen.g:1850:1: rule__Plot__Group__0__Impl : ( () ) ;
    public final void rule__Plot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1854:1: ( ( () ) )
            // InternalStoryGen.g:1855:1: ( () )
            {
            // InternalStoryGen.g:1855:1: ( () )
            // InternalStoryGen.g:1856:2: ()
            {
             before(grammarAccess.getPlotAccess().getPlotAction_0()); 
            // InternalStoryGen.g:1857:2: ()
            // InternalStoryGen.g:1857:3: 
            {
            }

             after(grammarAccess.getPlotAccess().getPlotAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__0__Impl"


    // $ANTLR start "rule__Plot__Group__1"
    // InternalStoryGen.g:1865:1: rule__Plot__Group__1 : rule__Plot__Group__1__Impl rule__Plot__Group__2 ;
    public final void rule__Plot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1869:1: ( rule__Plot__Group__1__Impl rule__Plot__Group__2 )
            // InternalStoryGen.g:1870:2: rule__Plot__Group__1__Impl rule__Plot__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Plot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Plot__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__1"


    // $ANTLR start "rule__Plot__Group__1__Impl"
    // InternalStoryGen.g:1877:1: rule__Plot__Group__1__Impl : ( 'Plot' ) ;
    public final void rule__Plot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1881:1: ( ( 'Plot' ) )
            // InternalStoryGen.g:1882:1: ( 'Plot' )
            {
            // InternalStoryGen.g:1882:1: ( 'Plot' )
            // InternalStoryGen.g:1883:2: 'Plot'
            {
             before(grammarAccess.getPlotAccess().getPlotKeyword_1()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getPlotAccess().getPlotKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__1__Impl"


    // $ANTLR start "rule__Plot__Group__2"
    // InternalStoryGen.g:1892:1: rule__Plot__Group__2 : rule__Plot__Group__2__Impl rule__Plot__Group__3 ;
    public final void rule__Plot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1896:1: ( rule__Plot__Group__2__Impl rule__Plot__Group__3 )
            // InternalStoryGen.g:1897:2: rule__Plot__Group__2__Impl rule__Plot__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__Plot__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Plot__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__2"


    // $ANTLR start "rule__Plot__Group__2__Impl"
    // InternalStoryGen.g:1904:1: rule__Plot__Group__2__Impl : ( '{' ) ;
    public final void rule__Plot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1908:1: ( ( '{' ) )
            // InternalStoryGen.g:1909:1: ( '{' )
            {
            // InternalStoryGen.g:1909:1: ( '{' )
            // InternalStoryGen.g:1910:2: '{'
            {
             before(grammarAccess.getPlotAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getPlotAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__2__Impl"


    // $ANTLR start "rule__Plot__Group__3"
    // InternalStoryGen.g:1919:1: rule__Plot__Group__3 : rule__Plot__Group__3__Impl rule__Plot__Group__4 ;
    public final void rule__Plot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1923:1: ( rule__Plot__Group__3__Impl rule__Plot__Group__4 )
            // InternalStoryGen.g:1924:2: rule__Plot__Group__3__Impl rule__Plot__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__Plot__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Plot__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__3"


    // $ANTLR start "rule__Plot__Group__3__Impl"
    // InternalStoryGen.g:1931:1: rule__Plot__Group__3__Impl : ( ( rule__Plot__EventsAssignment_3 )* ) ;
    public final void rule__Plot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1935:1: ( ( ( rule__Plot__EventsAssignment_3 )* ) )
            // InternalStoryGen.g:1936:1: ( ( rule__Plot__EventsAssignment_3 )* )
            {
            // InternalStoryGen.g:1936:1: ( ( rule__Plot__EventsAssignment_3 )* )
            // InternalStoryGen.g:1937:2: ( rule__Plot__EventsAssignment_3 )*
            {
             before(grammarAccess.getPlotAccess().getEventsAssignment_3()); 
            // InternalStoryGen.g:1938:2: ( rule__Plot__EventsAssignment_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==53||LA24_0==60||(LA24_0>=72 && LA24_0<=73)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalStoryGen.g:1938:3: rule__Plot__EventsAssignment_3
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Plot__EventsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getPlotAccess().getEventsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__3__Impl"


    // $ANTLR start "rule__Plot__Group__4"
    // InternalStoryGen.g:1946:1: rule__Plot__Group__4 : rule__Plot__Group__4__Impl ;
    public final void rule__Plot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1950:1: ( rule__Plot__Group__4__Impl )
            // InternalStoryGen.g:1951:2: rule__Plot__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Plot__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__4"


    // $ANTLR start "rule__Plot__Group__4__Impl"
    // InternalStoryGen.g:1957:1: rule__Plot__Group__4__Impl : ( '}' ) ;
    public final void rule__Plot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1961:1: ( ( '}' ) )
            // InternalStoryGen.g:1962:1: ( '}' )
            {
            // InternalStoryGen.g:1962:1: ( '}' )
            // InternalStoryGen.g:1963:2: '}'
            {
             before(grammarAccess.getPlotAccess().getRightCurlyBracketKeyword_4()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getPlotAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__Group__4__Impl"


    // $ANTLR start "rule__Actor__Group__0"
    // InternalStoryGen.g:1973:1: rule__Actor__Group__0 : rule__Actor__Group__0__Impl rule__Actor__Group__1 ;
    public final void rule__Actor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1977:1: ( rule__Actor__Group__0__Impl rule__Actor__Group__1 )
            // InternalStoryGen.g:1978:2: rule__Actor__Group__0__Impl rule__Actor__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Actor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Actor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__0"


    // $ANTLR start "rule__Actor__Group__0__Impl"
    // InternalStoryGen.g:1985:1: rule__Actor__Group__0__Impl : ( ( rule__Actor__PlayableAssignment_0 )? ) ;
    public final void rule__Actor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1989:1: ( ( ( rule__Actor__PlayableAssignment_0 )? ) )
            // InternalStoryGen.g:1990:1: ( ( rule__Actor__PlayableAssignment_0 )? )
            {
            // InternalStoryGen.g:1990:1: ( ( rule__Actor__PlayableAssignment_0 )? )
            // InternalStoryGen.g:1991:2: ( rule__Actor__PlayableAssignment_0 )?
            {
             before(grammarAccess.getActorAccess().getPlayableAssignment_0()); 
            // InternalStoryGen.g:1992:2: ( rule__Actor__PlayableAssignment_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==69) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalStoryGen.g:1992:3: rule__Actor__PlayableAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Actor__PlayableAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActorAccess().getPlayableAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__0__Impl"


    // $ANTLR start "rule__Actor__Group__1"
    // InternalStoryGen.g:2000:1: rule__Actor__Group__1 : rule__Actor__Group__1__Impl rule__Actor__Group__2 ;
    public final void rule__Actor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2004:1: ( rule__Actor__Group__1__Impl rule__Actor__Group__2 )
            // InternalStoryGen.g:2005:2: rule__Actor__Group__1__Impl rule__Actor__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__Actor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Actor__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__1"


    // $ANTLR start "rule__Actor__Group__1__Impl"
    // InternalStoryGen.g:2012:1: rule__Actor__Group__1__Impl : ( 'actor' ) ;
    public final void rule__Actor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2016:1: ( ( 'actor' ) )
            // InternalStoryGen.g:2017:1: ( 'actor' )
            {
            // InternalStoryGen.g:2017:1: ( 'actor' )
            // InternalStoryGen.g:2018:2: 'actor'
            {
             before(grammarAccess.getActorAccess().getActorKeyword_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getActorAccess().getActorKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__1__Impl"


    // $ANTLR start "rule__Actor__Group__2"
    // InternalStoryGen.g:2027:1: rule__Actor__Group__2 : rule__Actor__Group__2__Impl rule__Actor__Group__3 ;
    public final void rule__Actor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2031:1: ( rule__Actor__Group__2__Impl rule__Actor__Group__3 )
            // InternalStoryGen.g:2032:2: rule__Actor__Group__2__Impl rule__Actor__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Actor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Actor__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__2"


    // $ANTLR start "rule__Actor__Group__2__Impl"
    // InternalStoryGen.g:2039:1: rule__Actor__Group__2__Impl : ( ( rule__Actor__NameAssignment_2 ) ) ;
    public final void rule__Actor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2043:1: ( ( ( rule__Actor__NameAssignment_2 ) ) )
            // InternalStoryGen.g:2044:1: ( ( rule__Actor__NameAssignment_2 ) )
            {
            // InternalStoryGen.g:2044:1: ( ( rule__Actor__NameAssignment_2 ) )
            // InternalStoryGen.g:2045:2: ( rule__Actor__NameAssignment_2 )
            {
             before(grammarAccess.getActorAccess().getNameAssignment_2()); 
            // InternalStoryGen.g:2046:2: ( rule__Actor__NameAssignment_2 )
            // InternalStoryGen.g:2046:3: rule__Actor__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Actor__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getActorAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__2__Impl"


    // $ANTLR start "rule__Actor__Group__3"
    // InternalStoryGen.g:2054:1: rule__Actor__Group__3 : rule__Actor__Group__3__Impl rule__Actor__Group__4 ;
    public final void rule__Actor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2058:1: ( rule__Actor__Group__3__Impl rule__Actor__Group__4 )
            // InternalStoryGen.g:2059:2: rule__Actor__Group__3__Impl rule__Actor__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__Actor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Actor__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__3"


    // $ANTLR start "rule__Actor__Group__3__Impl"
    // InternalStoryGen.g:2066:1: rule__Actor__Group__3__Impl : ( '{' ) ;
    public final void rule__Actor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2070:1: ( ( '{' ) )
            // InternalStoryGen.g:2071:1: ( '{' )
            {
            // InternalStoryGen.g:2071:1: ( '{' )
            // InternalStoryGen.g:2072:2: '{'
            {
             before(grammarAccess.getActorAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getActorAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__3__Impl"


    // $ANTLR start "rule__Actor__Group__4"
    // InternalStoryGen.g:2081:1: rule__Actor__Group__4 : rule__Actor__Group__4__Impl rule__Actor__Group__5 ;
    public final void rule__Actor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2085:1: ( rule__Actor__Group__4__Impl rule__Actor__Group__5 )
            // InternalStoryGen.g:2086:2: rule__Actor__Group__4__Impl rule__Actor__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__Actor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Actor__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__4"


    // $ANTLR start "rule__Actor__Group__4__Impl"
    // InternalStoryGen.g:2093:1: rule__Actor__Group__4__Impl : ( 'name:' ) ;
    public final void rule__Actor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2097:1: ( ( 'name:' ) )
            // InternalStoryGen.g:2098:1: ( 'name:' )
            {
            // InternalStoryGen.g:2098:1: ( 'name:' )
            // InternalStoryGen.g:2099:2: 'name:'
            {
             before(grammarAccess.getActorAccess().getNameKeyword_4()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getActorAccess().getNameKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__4__Impl"


    // $ANTLR start "rule__Actor__Group__5"
    // InternalStoryGen.g:2108:1: rule__Actor__Group__5 : rule__Actor__Group__5__Impl rule__Actor__Group__6 ;
    public final void rule__Actor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2112:1: ( rule__Actor__Group__5__Impl rule__Actor__Group__6 )
            // InternalStoryGen.g:2113:2: rule__Actor__Group__5__Impl rule__Actor__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__Actor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Actor__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__5"


    // $ANTLR start "rule__Actor__Group__5__Impl"
    // InternalStoryGen.g:2120:1: rule__Actor__Group__5__Impl : ( ( rule__Actor__DisplayNameAssignment_5 ) ) ;
    public final void rule__Actor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2124:1: ( ( ( rule__Actor__DisplayNameAssignment_5 ) ) )
            // InternalStoryGen.g:2125:1: ( ( rule__Actor__DisplayNameAssignment_5 ) )
            {
            // InternalStoryGen.g:2125:1: ( ( rule__Actor__DisplayNameAssignment_5 ) )
            // InternalStoryGen.g:2126:2: ( rule__Actor__DisplayNameAssignment_5 )
            {
             before(grammarAccess.getActorAccess().getDisplayNameAssignment_5()); 
            // InternalStoryGen.g:2127:2: ( rule__Actor__DisplayNameAssignment_5 )
            // InternalStoryGen.g:2127:3: rule__Actor__DisplayNameAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Actor__DisplayNameAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getActorAccess().getDisplayNameAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__5__Impl"


    // $ANTLR start "rule__Actor__Group__6"
    // InternalStoryGen.g:2135:1: rule__Actor__Group__6 : rule__Actor__Group__6__Impl rule__Actor__Group__7 ;
    public final void rule__Actor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2139:1: ( rule__Actor__Group__6__Impl rule__Actor__Group__7 )
            // InternalStoryGen.g:2140:2: rule__Actor__Group__6__Impl rule__Actor__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__Actor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Actor__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__6"


    // $ANTLR start "rule__Actor__Group__6__Impl"
    // InternalStoryGen.g:2147:1: rule__Actor__Group__6__Impl : ( ( rule__Actor__AttributesAssignment_6 )* ) ;
    public final void rule__Actor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2151:1: ( ( ( rule__Actor__AttributesAssignment_6 )* ) )
            // InternalStoryGen.g:2152:1: ( ( rule__Actor__AttributesAssignment_6 )* )
            {
            // InternalStoryGen.g:2152:1: ( ( rule__Actor__AttributesAssignment_6 )* )
            // InternalStoryGen.g:2153:2: ( rule__Actor__AttributesAssignment_6 )*
            {
             before(grammarAccess.getActorAccess().getAttributesAssignment_6()); 
            // InternalStoryGen.g:2154:2: ( rule__Actor__AttributesAssignment_6 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==46||LA26_0==49) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalStoryGen.g:2154:3: rule__Actor__AttributesAssignment_6
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Actor__AttributesAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getActorAccess().getAttributesAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__6__Impl"


    // $ANTLR start "rule__Actor__Group__7"
    // InternalStoryGen.g:2162:1: rule__Actor__Group__7 : rule__Actor__Group__7__Impl ;
    public final void rule__Actor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2166:1: ( rule__Actor__Group__7__Impl )
            // InternalStoryGen.g:2167:2: rule__Actor__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Actor__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__7"


    // $ANTLR start "rule__Actor__Group__7__Impl"
    // InternalStoryGen.g:2173:1: rule__Actor__Group__7__Impl : ( '}' ) ;
    public final void rule__Actor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2177:1: ( ( '}' ) )
            // InternalStoryGen.g:2178:1: ( '}' )
            {
            // InternalStoryGen.g:2178:1: ( '}' )
            // InternalStoryGen.g:2179:2: '}'
            {
             before(grammarAccess.getActorAccess().getRightCurlyBracketKeyword_7()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getActorAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__Group__7__Impl"


    // $ANTLR start "rule__Object__Group__0"
    // InternalStoryGen.g:2189:1: rule__Object__Group__0 : rule__Object__Group__0__Impl rule__Object__Group__1 ;
    public final void rule__Object__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2193:1: ( rule__Object__Group__0__Impl rule__Object__Group__1 )
            // InternalStoryGen.g:2194:2: rule__Object__Group__0__Impl rule__Object__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Object__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Object__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__0"


    // $ANTLR start "rule__Object__Group__0__Impl"
    // InternalStoryGen.g:2201:1: rule__Object__Group__0__Impl : ( 'object' ) ;
    public final void rule__Object__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2205:1: ( ( 'object' ) )
            // InternalStoryGen.g:2206:1: ( 'object' )
            {
            // InternalStoryGen.g:2206:1: ( 'object' )
            // InternalStoryGen.g:2207:2: 'object'
            {
             before(grammarAccess.getObjectAccess().getObjectKeyword_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getObjectAccess().getObjectKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__0__Impl"


    // $ANTLR start "rule__Object__Group__1"
    // InternalStoryGen.g:2216:1: rule__Object__Group__1 : rule__Object__Group__1__Impl rule__Object__Group__2 ;
    public final void rule__Object__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2220:1: ( rule__Object__Group__1__Impl rule__Object__Group__2 )
            // InternalStoryGen.g:2221:2: rule__Object__Group__1__Impl rule__Object__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Object__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Object__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__1"


    // $ANTLR start "rule__Object__Group__1__Impl"
    // InternalStoryGen.g:2228:1: rule__Object__Group__1__Impl : ( ( rule__Object__NameAssignment_1 ) ) ;
    public final void rule__Object__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2232:1: ( ( ( rule__Object__NameAssignment_1 ) ) )
            // InternalStoryGen.g:2233:1: ( ( rule__Object__NameAssignment_1 ) )
            {
            // InternalStoryGen.g:2233:1: ( ( rule__Object__NameAssignment_1 ) )
            // InternalStoryGen.g:2234:2: ( rule__Object__NameAssignment_1 )
            {
             before(grammarAccess.getObjectAccess().getNameAssignment_1()); 
            // InternalStoryGen.g:2235:2: ( rule__Object__NameAssignment_1 )
            // InternalStoryGen.g:2235:3: rule__Object__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Object__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getObjectAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__1__Impl"


    // $ANTLR start "rule__Object__Group__2"
    // InternalStoryGen.g:2243:1: rule__Object__Group__2 : rule__Object__Group__2__Impl rule__Object__Group__3 ;
    public final void rule__Object__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2247:1: ( rule__Object__Group__2__Impl rule__Object__Group__3 )
            // InternalStoryGen.g:2248:2: rule__Object__Group__2__Impl rule__Object__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Object__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Object__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__2"


    // $ANTLR start "rule__Object__Group__2__Impl"
    // InternalStoryGen.g:2255:1: rule__Object__Group__2__Impl : ( '{' ) ;
    public final void rule__Object__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2259:1: ( ( '{' ) )
            // InternalStoryGen.g:2260:1: ( '{' )
            {
            // InternalStoryGen.g:2260:1: ( '{' )
            // InternalStoryGen.g:2261:2: '{'
            {
             before(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__2__Impl"


    // $ANTLR start "rule__Object__Group__3"
    // InternalStoryGen.g:2270:1: rule__Object__Group__3 : rule__Object__Group__3__Impl rule__Object__Group__4 ;
    public final void rule__Object__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2274:1: ( rule__Object__Group__3__Impl rule__Object__Group__4 )
            // InternalStoryGen.g:2275:2: rule__Object__Group__3__Impl rule__Object__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__Object__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Object__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__3"


    // $ANTLR start "rule__Object__Group__3__Impl"
    // InternalStoryGen.g:2282:1: rule__Object__Group__3__Impl : ( ( rule__Object__AttributesAssignment_3 )* ) ;
    public final void rule__Object__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2286:1: ( ( ( rule__Object__AttributesAssignment_3 )* ) )
            // InternalStoryGen.g:2287:1: ( ( rule__Object__AttributesAssignment_3 )* )
            {
            // InternalStoryGen.g:2287:1: ( ( rule__Object__AttributesAssignment_3 )* )
            // InternalStoryGen.g:2288:2: ( rule__Object__AttributesAssignment_3 )*
            {
             before(grammarAccess.getObjectAccess().getAttributesAssignment_3()); 
            // InternalStoryGen.g:2289:2: ( rule__Object__AttributesAssignment_3 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==46||LA27_0==49) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalStoryGen.g:2289:3: rule__Object__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Object__AttributesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getObjectAccess().getAttributesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__3__Impl"


    // $ANTLR start "rule__Object__Group__4"
    // InternalStoryGen.g:2297:1: rule__Object__Group__4 : rule__Object__Group__4__Impl ;
    public final void rule__Object__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2301:1: ( rule__Object__Group__4__Impl )
            // InternalStoryGen.g:2302:2: rule__Object__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Object__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__4"


    // $ANTLR start "rule__Object__Group__4__Impl"
    // InternalStoryGen.g:2308:1: rule__Object__Group__4__Impl : ( '}' ) ;
    public final void rule__Object__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2312:1: ( ( '}' ) )
            // InternalStoryGen.g:2313:1: ( '}' )
            {
            // InternalStoryGen.g:2313:1: ( '}' )
            // InternalStoryGen.g:2314:2: '}'
            {
             before(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_4()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__4__Impl"


    // $ANTLR start "rule__FactAttribute__Group__0"
    // InternalStoryGen.g:2324:1: rule__FactAttribute__Group__0 : rule__FactAttribute__Group__0__Impl rule__FactAttribute__Group__1 ;
    public final void rule__FactAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2328:1: ( rule__FactAttribute__Group__0__Impl rule__FactAttribute__Group__1 )
            // InternalStoryGen.g:2329:2: rule__FactAttribute__Group__0__Impl rule__FactAttribute__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__FactAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FactAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group__0"


    // $ANTLR start "rule__FactAttribute__Group__0__Impl"
    // InternalStoryGen.g:2336:1: rule__FactAttribute__Group__0__Impl : ( 'fact' ) ;
    public final void rule__FactAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2340:1: ( ( 'fact' ) )
            // InternalStoryGen.g:2341:1: ( 'fact' )
            {
            // InternalStoryGen.g:2341:1: ( 'fact' )
            // InternalStoryGen.g:2342:2: 'fact'
            {
             before(grammarAccess.getFactAttributeAccess().getFactKeyword_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getFactAttributeAccess().getFactKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group__0__Impl"


    // $ANTLR start "rule__FactAttribute__Group__1"
    // InternalStoryGen.g:2351:1: rule__FactAttribute__Group__1 : rule__FactAttribute__Group__1__Impl rule__FactAttribute__Group__2 ;
    public final void rule__FactAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2355:1: ( rule__FactAttribute__Group__1__Impl rule__FactAttribute__Group__2 )
            // InternalStoryGen.g:2356:2: rule__FactAttribute__Group__1__Impl rule__FactAttribute__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__FactAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FactAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group__1"


    // $ANTLR start "rule__FactAttribute__Group__1__Impl"
    // InternalStoryGen.g:2363:1: rule__FactAttribute__Group__1__Impl : ( ( rule__FactAttribute__NameAssignment_1 ) ) ;
    public final void rule__FactAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2367:1: ( ( ( rule__FactAttribute__NameAssignment_1 ) ) )
            // InternalStoryGen.g:2368:1: ( ( rule__FactAttribute__NameAssignment_1 ) )
            {
            // InternalStoryGen.g:2368:1: ( ( rule__FactAttribute__NameAssignment_1 ) )
            // InternalStoryGen.g:2369:2: ( rule__FactAttribute__NameAssignment_1 )
            {
             before(grammarAccess.getFactAttributeAccess().getNameAssignment_1()); 
            // InternalStoryGen.g:2370:2: ( rule__FactAttribute__NameAssignment_1 )
            // InternalStoryGen.g:2370:3: rule__FactAttribute__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FactAttribute__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFactAttributeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group__1__Impl"


    // $ANTLR start "rule__FactAttribute__Group__2"
    // InternalStoryGen.g:2378:1: rule__FactAttribute__Group__2 : rule__FactAttribute__Group__2__Impl rule__FactAttribute__Group__3 ;
    public final void rule__FactAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2382:1: ( rule__FactAttribute__Group__2__Impl rule__FactAttribute__Group__3 )
            // InternalStoryGen.g:2383:2: rule__FactAttribute__Group__2__Impl rule__FactAttribute__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__FactAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FactAttribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group__2"


    // $ANTLR start "rule__FactAttribute__Group__2__Impl"
    // InternalStoryGen.g:2390:1: rule__FactAttribute__Group__2__Impl : ( '=' ) ;
    public final void rule__FactAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2394:1: ( ( '=' ) )
            // InternalStoryGen.g:2395:1: ( '=' )
            {
            // InternalStoryGen.g:2395:1: ( '=' )
            // InternalStoryGen.g:2396:2: '='
            {
             before(grammarAccess.getFactAttributeAccess().getEqualsSignKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getFactAttributeAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group__2__Impl"


    // $ANTLR start "rule__FactAttribute__Group__3"
    // InternalStoryGen.g:2405:1: rule__FactAttribute__Group__3 : rule__FactAttribute__Group__3__Impl ;
    public final void rule__FactAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2409:1: ( rule__FactAttribute__Group__3__Impl )
            // InternalStoryGen.g:2410:2: rule__FactAttribute__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FactAttribute__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group__3"


    // $ANTLR start "rule__FactAttribute__Group__3__Impl"
    // InternalStoryGen.g:2416:1: rule__FactAttribute__Group__3__Impl : ( ( rule__FactAttribute__Alternatives_3 ) ) ;
    public final void rule__FactAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2420:1: ( ( ( rule__FactAttribute__Alternatives_3 ) ) )
            // InternalStoryGen.g:2421:1: ( ( rule__FactAttribute__Alternatives_3 ) )
            {
            // InternalStoryGen.g:2421:1: ( ( rule__FactAttribute__Alternatives_3 ) )
            // InternalStoryGen.g:2422:2: ( rule__FactAttribute__Alternatives_3 )
            {
             before(grammarAccess.getFactAttributeAccess().getAlternatives_3()); 
            // InternalStoryGen.g:2423:2: ( rule__FactAttribute__Alternatives_3 )
            // InternalStoryGen.g:2423:3: rule__FactAttribute__Alternatives_3
            {
            pushFollow(FOLLOW_2);
            rule__FactAttribute__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getFactAttributeAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group__3__Impl"


    // $ANTLR start "rule__FactAttribute__Group_3_1__0"
    // InternalStoryGen.g:2432:1: rule__FactAttribute__Group_3_1__0 : rule__FactAttribute__Group_3_1__0__Impl rule__FactAttribute__Group_3_1__1 ;
    public final void rule__FactAttribute__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2436:1: ( rule__FactAttribute__Group_3_1__0__Impl rule__FactAttribute__Group_3_1__1 )
            // InternalStoryGen.g:2437:2: rule__FactAttribute__Group_3_1__0__Impl rule__FactAttribute__Group_3_1__1
            {
            pushFollow(FOLLOW_20);
            rule__FactAttribute__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FactAttribute__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group_3_1__0"


    // $ANTLR start "rule__FactAttribute__Group_3_1__0__Impl"
    // InternalStoryGen.g:2444:1: rule__FactAttribute__Group_3_1__0__Impl : ( '(' ) ;
    public final void rule__FactAttribute__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2448:1: ( ( '(' ) )
            // InternalStoryGen.g:2449:1: ( '(' )
            {
            // InternalStoryGen.g:2449:1: ( '(' )
            // InternalStoryGen.g:2450:2: '('
            {
             before(grammarAccess.getFactAttributeAccess().getLeftParenthesisKeyword_3_1_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getFactAttributeAccess().getLeftParenthesisKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group_3_1__0__Impl"


    // $ANTLR start "rule__FactAttribute__Group_3_1__1"
    // InternalStoryGen.g:2459:1: rule__FactAttribute__Group_3_1__1 : rule__FactAttribute__Group_3_1__1__Impl rule__FactAttribute__Group_3_1__2 ;
    public final void rule__FactAttribute__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2463:1: ( rule__FactAttribute__Group_3_1__1__Impl rule__FactAttribute__Group_3_1__2 )
            // InternalStoryGen.g:2464:2: rule__FactAttribute__Group_3_1__1__Impl rule__FactAttribute__Group_3_1__2
            {
            pushFollow(FOLLOW_21);
            rule__FactAttribute__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FactAttribute__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group_3_1__1"


    // $ANTLR start "rule__FactAttribute__Group_3_1__1__Impl"
    // InternalStoryGen.g:2471:1: rule__FactAttribute__Group_3_1__1__Impl : ( ( rule__FactAttribute__MacroExpAssignment_3_1_1 ) ) ;
    public final void rule__FactAttribute__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2475:1: ( ( ( rule__FactAttribute__MacroExpAssignment_3_1_1 ) ) )
            // InternalStoryGen.g:2476:1: ( ( rule__FactAttribute__MacroExpAssignment_3_1_1 ) )
            {
            // InternalStoryGen.g:2476:1: ( ( rule__FactAttribute__MacroExpAssignment_3_1_1 ) )
            // InternalStoryGen.g:2477:2: ( rule__FactAttribute__MacroExpAssignment_3_1_1 )
            {
             before(grammarAccess.getFactAttributeAccess().getMacroExpAssignment_3_1_1()); 
            // InternalStoryGen.g:2478:2: ( rule__FactAttribute__MacroExpAssignment_3_1_1 )
            // InternalStoryGen.g:2478:3: rule__FactAttribute__MacroExpAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__FactAttribute__MacroExpAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFactAttributeAccess().getMacroExpAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group_3_1__1__Impl"


    // $ANTLR start "rule__FactAttribute__Group_3_1__2"
    // InternalStoryGen.g:2486:1: rule__FactAttribute__Group_3_1__2 : rule__FactAttribute__Group_3_1__2__Impl ;
    public final void rule__FactAttribute__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2490:1: ( rule__FactAttribute__Group_3_1__2__Impl )
            // InternalStoryGen.g:2491:2: rule__FactAttribute__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FactAttribute__Group_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group_3_1__2"


    // $ANTLR start "rule__FactAttribute__Group_3_1__2__Impl"
    // InternalStoryGen.g:2497:1: rule__FactAttribute__Group_3_1__2__Impl : ( ')' ) ;
    public final void rule__FactAttribute__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2501:1: ( ( ')' ) )
            // InternalStoryGen.g:2502:1: ( ')' )
            {
            // InternalStoryGen.g:2502:1: ( ')' )
            // InternalStoryGen.g:2503:2: ')'
            {
             before(grammarAccess.getFactAttributeAccess().getRightParenthesisKeyword_3_1_2()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getFactAttributeAccess().getRightParenthesisKeyword_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__Group_3_1__2__Impl"


    // $ANTLR start "rule__QuantityAttribute__Group__0"
    // InternalStoryGen.g:2513:1: rule__QuantityAttribute__Group__0 : rule__QuantityAttribute__Group__0__Impl rule__QuantityAttribute__Group__1 ;
    public final void rule__QuantityAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2517:1: ( rule__QuantityAttribute__Group__0__Impl rule__QuantityAttribute__Group__1 )
            // InternalStoryGen.g:2518:2: rule__QuantityAttribute__Group__0__Impl rule__QuantityAttribute__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__QuantityAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__0"


    // $ANTLR start "rule__QuantityAttribute__Group__0__Impl"
    // InternalStoryGen.g:2525:1: rule__QuantityAttribute__Group__0__Impl : ( 'quantity' ) ;
    public final void rule__QuantityAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2529:1: ( ( 'quantity' ) )
            // InternalStoryGen.g:2530:1: ( 'quantity' )
            {
            // InternalStoryGen.g:2530:1: ( 'quantity' )
            // InternalStoryGen.g:2531:2: 'quantity'
            {
             before(grammarAccess.getQuantityAttributeAccess().getQuantityKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getQuantityAttributeAccess().getQuantityKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__0__Impl"


    // $ANTLR start "rule__QuantityAttribute__Group__1"
    // InternalStoryGen.g:2540:1: rule__QuantityAttribute__Group__1 : rule__QuantityAttribute__Group__1__Impl rule__QuantityAttribute__Group__2 ;
    public final void rule__QuantityAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2544:1: ( rule__QuantityAttribute__Group__1__Impl rule__QuantityAttribute__Group__2 )
            // InternalStoryGen.g:2545:2: rule__QuantityAttribute__Group__1__Impl rule__QuantityAttribute__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__QuantityAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__1"


    // $ANTLR start "rule__QuantityAttribute__Group__1__Impl"
    // InternalStoryGen.g:2552:1: rule__QuantityAttribute__Group__1__Impl : ( ( rule__QuantityAttribute__NameAssignment_1 ) ) ;
    public final void rule__QuantityAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2556:1: ( ( ( rule__QuantityAttribute__NameAssignment_1 ) ) )
            // InternalStoryGen.g:2557:1: ( ( rule__QuantityAttribute__NameAssignment_1 ) )
            {
            // InternalStoryGen.g:2557:1: ( ( rule__QuantityAttribute__NameAssignment_1 ) )
            // InternalStoryGen.g:2558:2: ( rule__QuantityAttribute__NameAssignment_1 )
            {
             before(grammarAccess.getQuantityAttributeAccess().getNameAssignment_1()); 
            // InternalStoryGen.g:2559:2: ( rule__QuantityAttribute__NameAssignment_1 )
            // InternalStoryGen.g:2559:3: rule__QuantityAttribute__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQuantityAttributeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__1__Impl"


    // $ANTLR start "rule__QuantityAttribute__Group__2"
    // InternalStoryGen.g:2567:1: rule__QuantityAttribute__Group__2 : rule__QuantityAttribute__Group__2__Impl rule__QuantityAttribute__Group__3 ;
    public final void rule__QuantityAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2571:1: ( rule__QuantityAttribute__Group__2__Impl rule__QuantityAttribute__Group__3 )
            // InternalStoryGen.g:2572:2: rule__QuantityAttribute__Group__2__Impl rule__QuantityAttribute__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__QuantityAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__2"


    // $ANTLR start "rule__QuantityAttribute__Group__2__Impl"
    // InternalStoryGen.g:2579:1: rule__QuantityAttribute__Group__2__Impl : ( '=' ) ;
    public final void rule__QuantityAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2583:1: ( ( '=' ) )
            // InternalStoryGen.g:2584:1: ( '=' )
            {
            // InternalStoryGen.g:2584:1: ( '=' )
            // InternalStoryGen.g:2585:2: '='
            {
             before(grammarAccess.getQuantityAttributeAccess().getEqualsSignKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getQuantityAttributeAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__2__Impl"


    // $ANTLR start "rule__QuantityAttribute__Group__3"
    // InternalStoryGen.g:2594:1: rule__QuantityAttribute__Group__3 : rule__QuantityAttribute__Group__3__Impl rule__QuantityAttribute__Group__4 ;
    public final void rule__QuantityAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2598:1: ( rule__QuantityAttribute__Group__3__Impl rule__QuantityAttribute__Group__4 )
            // InternalStoryGen.g:2599:2: rule__QuantityAttribute__Group__3__Impl rule__QuantityAttribute__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__QuantityAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__3"


    // $ANTLR start "rule__QuantityAttribute__Group__3__Impl"
    // InternalStoryGen.g:2606:1: rule__QuantityAttribute__Group__3__Impl : ( ( rule__QuantityAttribute__InitValueAssignment_3 ) ) ;
    public final void rule__QuantityAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2610:1: ( ( ( rule__QuantityAttribute__InitValueAssignment_3 ) ) )
            // InternalStoryGen.g:2611:1: ( ( rule__QuantityAttribute__InitValueAssignment_3 ) )
            {
            // InternalStoryGen.g:2611:1: ( ( rule__QuantityAttribute__InitValueAssignment_3 ) )
            // InternalStoryGen.g:2612:2: ( rule__QuantityAttribute__InitValueAssignment_3 )
            {
             before(grammarAccess.getQuantityAttributeAccess().getInitValueAssignment_3()); 
            // InternalStoryGen.g:2613:2: ( rule__QuantityAttribute__InitValueAssignment_3 )
            // InternalStoryGen.g:2613:3: rule__QuantityAttribute__InitValueAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__InitValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getQuantityAttributeAccess().getInitValueAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__3__Impl"


    // $ANTLR start "rule__QuantityAttribute__Group__4"
    // InternalStoryGen.g:2621:1: rule__QuantityAttribute__Group__4 : rule__QuantityAttribute__Group__4__Impl ;
    public final void rule__QuantityAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2625:1: ( rule__QuantityAttribute__Group__4__Impl )
            // InternalStoryGen.g:2626:2: rule__QuantityAttribute__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__4"


    // $ANTLR start "rule__QuantityAttribute__Group__4__Impl"
    // InternalStoryGen.g:2632:1: rule__QuantityAttribute__Group__4__Impl : ( ( rule__QuantityAttribute__Group_4__0 )? ) ;
    public final void rule__QuantityAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2636:1: ( ( ( rule__QuantityAttribute__Group_4__0 )? ) )
            // InternalStoryGen.g:2637:1: ( ( rule__QuantityAttribute__Group_4__0 )? )
            {
            // InternalStoryGen.g:2637:1: ( ( rule__QuantityAttribute__Group_4__0 )? )
            // InternalStoryGen.g:2638:2: ( rule__QuantityAttribute__Group_4__0 )?
            {
             before(grammarAccess.getQuantityAttributeAccess().getGroup_4()); 
            // InternalStoryGen.g:2639:2: ( rule__QuantityAttribute__Group_4__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==50) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalStoryGen.g:2639:3: rule__QuantityAttribute__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QuantityAttribute__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQuantityAttributeAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group__4__Impl"


    // $ANTLR start "rule__QuantityAttribute__Group_4__0"
    // InternalStoryGen.g:2648:1: rule__QuantityAttribute__Group_4__0 : rule__QuantityAttribute__Group_4__0__Impl rule__QuantityAttribute__Group_4__1 ;
    public final void rule__QuantityAttribute__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2652:1: ( rule__QuantityAttribute__Group_4__0__Impl rule__QuantityAttribute__Group_4__1 )
            // InternalStoryGen.g:2653:2: rule__QuantityAttribute__Group_4__0__Impl rule__QuantityAttribute__Group_4__1
            {
            pushFollow(FOLLOW_24);
            rule__QuantityAttribute__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group_4__0"


    // $ANTLR start "rule__QuantityAttribute__Group_4__0__Impl"
    // InternalStoryGen.g:2660:1: rule__QuantityAttribute__Group_4__0__Impl : ( '[' ) ;
    public final void rule__QuantityAttribute__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2664:1: ( ( '[' ) )
            // InternalStoryGen.g:2665:1: ( '[' )
            {
            // InternalStoryGen.g:2665:1: ( '[' )
            // InternalStoryGen.g:2666:2: '['
            {
             before(grammarAccess.getQuantityAttributeAccess().getLeftSquareBracketKeyword_4_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getQuantityAttributeAccess().getLeftSquareBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group_4__0__Impl"


    // $ANTLR start "rule__QuantityAttribute__Group_4__1"
    // InternalStoryGen.g:2675:1: rule__QuantityAttribute__Group_4__1 : rule__QuantityAttribute__Group_4__1__Impl rule__QuantityAttribute__Group_4__2 ;
    public final void rule__QuantityAttribute__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2679:1: ( rule__QuantityAttribute__Group_4__1__Impl rule__QuantityAttribute__Group_4__2 )
            // InternalStoryGen.g:2680:2: rule__QuantityAttribute__Group_4__1__Impl rule__QuantityAttribute__Group_4__2
            {
            pushFollow(FOLLOW_25);
            rule__QuantityAttribute__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group_4__1"


    // $ANTLR start "rule__QuantityAttribute__Group_4__1__Impl"
    // InternalStoryGen.g:2687:1: rule__QuantityAttribute__Group_4__1__Impl : ( ( rule__QuantityAttribute__SettingAssignment_4_1 ) ) ;
    public final void rule__QuantityAttribute__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2691:1: ( ( ( rule__QuantityAttribute__SettingAssignment_4_1 ) ) )
            // InternalStoryGen.g:2692:1: ( ( rule__QuantityAttribute__SettingAssignment_4_1 ) )
            {
            // InternalStoryGen.g:2692:1: ( ( rule__QuantityAttribute__SettingAssignment_4_1 ) )
            // InternalStoryGen.g:2693:2: ( rule__QuantityAttribute__SettingAssignment_4_1 )
            {
             before(grammarAccess.getQuantityAttributeAccess().getSettingAssignment_4_1()); 
            // InternalStoryGen.g:2694:2: ( rule__QuantityAttribute__SettingAssignment_4_1 )
            // InternalStoryGen.g:2694:3: rule__QuantityAttribute__SettingAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__SettingAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getQuantityAttributeAccess().getSettingAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group_4__1__Impl"


    // $ANTLR start "rule__QuantityAttribute__Group_4__2"
    // InternalStoryGen.g:2702:1: rule__QuantityAttribute__Group_4__2 : rule__QuantityAttribute__Group_4__2__Impl ;
    public final void rule__QuantityAttribute__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2706:1: ( rule__QuantityAttribute__Group_4__2__Impl )
            // InternalStoryGen.g:2707:2: rule__QuantityAttribute__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QuantityAttribute__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group_4__2"


    // $ANTLR start "rule__QuantityAttribute__Group_4__2__Impl"
    // InternalStoryGen.g:2713:1: rule__QuantityAttribute__Group_4__2__Impl : ( ']' ) ;
    public final void rule__QuantityAttribute__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2717:1: ( ( ']' ) )
            // InternalStoryGen.g:2718:1: ( ']' )
            {
            // InternalStoryGen.g:2718:1: ( ']' )
            // InternalStoryGen.g:2719:2: ']'
            {
             before(grammarAccess.getQuantityAttributeAccess().getRightSquareBracketKeyword_4_2()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getQuantityAttributeAccess().getRightSquareBracketKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__Group_4__2__Impl"


    // $ANTLR start "rule__AttributeSetting__Group__0"
    // InternalStoryGen.g:2729:1: rule__AttributeSetting__Group__0 : rule__AttributeSetting__Group__0__Impl rule__AttributeSetting__Group__1 ;
    public final void rule__AttributeSetting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2733:1: ( rule__AttributeSetting__Group__0__Impl rule__AttributeSetting__Group__1 )
            // InternalStoryGen.g:2734:2: rule__AttributeSetting__Group__0__Impl rule__AttributeSetting__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__AttributeSetting__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeSetting__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__Group__0"


    // $ANTLR start "rule__AttributeSetting__Group__0__Impl"
    // InternalStoryGen.g:2741:1: rule__AttributeSetting__Group__0__Impl : ( ( rule__AttributeSetting__Alternatives_0 ) ) ;
    public final void rule__AttributeSetting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2745:1: ( ( ( rule__AttributeSetting__Alternatives_0 ) ) )
            // InternalStoryGen.g:2746:1: ( ( rule__AttributeSetting__Alternatives_0 ) )
            {
            // InternalStoryGen.g:2746:1: ( ( rule__AttributeSetting__Alternatives_0 ) )
            // InternalStoryGen.g:2747:2: ( rule__AttributeSetting__Alternatives_0 )
            {
             before(grammarAccess.getAttributeSettingAccess().getAlternatives_0()); 
            // InternalStoryGen.g:2748:2: ( rule__AttributeSetting__Alternatives_0 )
            // InternalStoryGen.g:2748:3: rule__AttributeSetting__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeSetting__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeSettingAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__Group__0__Impl"


    // $ANTLR start "rule__AttributeSetting__Group__1"
    // InternalStoryGen.g:2756:1: rule__AttributeSetting__Group__1 : rule__AttributeSetting__Group__1__Impl rule__AttributeSetting__Group__2 ;
    public final void rule__AttributeSetting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2760:1: ( rule__AttributeSetting__Group__1__Impl rule__AttributeSetting__Group__2 )
            // InternalStoryGen.g:2761:2: rule__AttributeSetting__Group__1__Impl rule__AttributeSetting__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__AttributeSetting__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeSetting__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__Group__1"


    // $ANTLR start "rule__AttributeSetting__Group__1__Impl"
    // InternalStoryGen.g:2768:1: rule__AttributeSetting__Group__1__Impl : ( 'by' ) ;
    public final void rule__AttributeSetting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2772:1: ( ( 'by' ) )
            // InternalStoryGen.g:2773:1: ( 'by' )
            {
            // InternalStoryGen.g:2773:1: ( 'by' )
            // InternalStoryGen.g:2774:2: 'by'
            {
             before(grammarAccess.getAttributeSettingAccess().getByKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getAttributeSettingAccess().getByKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__Group__1__Impl"


    // $ANTLR start "rule__AttributeSetting__Group__2"
    // InternalStoryGen.g:2783:1: rule__AttributeSetting__Group__2 : rule__AttributeSetting__Group__2__Impl rule__AttributeSetting__Group__3 ;
    public final void rule__AttributeSetting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2787:1: ( rule__AttributeSetting__Group__2__Impl rule__AttributeSetting__Group__3 )
            // InternalStoryGen.g:2788:2: rule__AttributeSetting__Group__2__Impl rule__AttributeSetting__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__AttributeSetting__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeSetting__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__Group__2"


    // $ANTLR start "rule__AttributeSetting__Group__2__Impl"
    // InternalStoryGen.g:2795:1: rule__AttributeSetting__Group__2__Impl : ( ( rule__AttributeSetting__AmountAssignment_2 ) ) ;
    public final void rule__AttributeSetting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2799:1: ( ( ( rule__AttributeSetting__AmountAssignment_2 ) ) )
            // InternalStoryGen.g:2800:1: ( ( rule__AttributeSetting__AmountAssignment_2 ) )
            {
            // InternalStoryGen.g:2800:1: ( ( rule__AttributeSetting__AmountAssignment_2 ) )
            // InternalStoryGen.g:2801:2: ( rule__AttributeSetting__AmountAssignment_2 )
            {
             before(grammarAccess.getAttributeSettingAccess().getAmountAssignment_2()); 
            // InternalStoryGen.g:2802:2: ( rule__AttributeSetting__AmountAssignment_2 )
            // InternalStoryGen.g:2802:3: rule__AttributeSetting__AmountAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AttributeSetting__AmountAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeSettingAccess().getAmountAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__Group__2__Impl"


    // $ANTLR start "rule__AttributeSetting__Group__3"
    // InternalStoryGen.g:2810:1: rule__AttributeSetting__Group__3 : rule__AttributeSetting__Group__3__Impl ;
    public final void rule__AttributeSetting__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2814:1: ( rule__AttributeSetting__Group__3__Impl )
            // InternalStoryGen.g:2815:2: rule__AttributeSetting__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeSetting__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__Group__3"


    // $ANTLR start "rule__AttributeSetting__Group__3__Impl"
    // InternalStoryGen.g:2821:1: rule__AttributeSetting__Group__3__Impl : ( ( rule__AttributeSetting__FrequencyAssignment_3 ) ) ;
    public final void rule__AttributeSetting__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2825:1: ( ( ( rule__AttributeSetting__FrequencyAssignment_3 ) ) )
            // InternalStoryGen.g:2826:1: ( ( rule__AttributeSetting__FrequencyAssignment_3 ) )
            {
            // InternalStoryGen.g:2826:1: ( ( rule__AttributeSetting__FrequencyAssignment_3 ) )
            // InternalStoryGen.g:2827:2: ( rule__AttributeSetting__FrequencyAssignment_3 )
            {
             before(grammarAccess.getAttributeSettingAccess().getFrequencyAssignment_3()); 
            // InternalStoryGen.g:2828:2: ( rule__AttributeSetting__FrequencyAssignment_3 )
            // InternalStoryGen.g:2828:3: rule__AttributeSetting__FrequencyAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__AttributeSetting__FrequencyAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAttributeSettingAccess().getFrequencyAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__Group__3__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__0"
    // InternalStoryGen.g:2837:1: rule__HappeningEvent__Group__0 : rule__HappeningEvent__Group__0__Impl rule__HappeningEvent__Group__1 ;
    public final void rule__HappeningEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2841:1: ( rule__HappeningEvent__Group__0__Impl rule__HappeningEvent__Group__1 )
            // InternalStoryGen.g:2842:2: rule__HappeningEvent__Group__0__Impl rule__HappeningEvent__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__HappeningEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__0"


    // $ANTLR start "rule__HappeningEvent__Group__0__Impl"
    // InternalStoryGen.g:2849:1: rule__HappeningEvent__Group__0__Impl : ( ( rule__HappeningEvent__Alternatives_0 )? ) ;
    public final void rule__HappeningEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2853:1: ( ( ( rule__HappeningEvent__Alternatives_0 )? ) )
            // InternalStoryGen.g:2854:1: ( ( rule__HappeningEvent__Alternatives_0 )? )
            {
            // InternalStoryGen.g:2854:1: ( ( rule__HappeningEvent__Alternatives_0 )? )
            // InternalStoryGen.g:2855:2: ( rule__HappeningEvent__Alternatives_0 )?
            {
             before(grammarAccess.getHappeningEventAccess().getAlternatives_0()); 
            // InternalStoryGen.g:2856:2: ( rule__HappeningEvent__Alternatives_0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=72 && LA29_0<=73)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalStoryGen.g:2856:3: rule__HappeningEvent__Alternatives_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HappeningEvent__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHappeningEventAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__0__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__1"
    // InternalStoryGen.g:2864:1: rule__HappeningEvent__Group__1 : rule__HappeningEvent__Group__1__Impl rule__HappeningEvent__Group__2 ;
    public final void rule__HappeningEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2868:1: ( rule__HappeningEvent__Group__1__Impl rule__HappeningEvent__Group__2 )
            // InternalStoryGen.g:2869:2: rule__HappeningEvent__Group__1__Impl rule__HappeningEvent__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__HappeningEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__1"


    // $ANTLR start "rule__HappeningEvent__Group__1__Impl"
    // InternalStoryGen.g:2876:1: rule__HappeningEvent__Group__1__Impl : ( 'event' ) ;
    public final void rule__HappeningEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2880:1: ( ( 'event' ) )
            // InternalStoryGen.g:2881:1: ( 'event' )
            {
            // InternalStoryGen.g:2881:1: ( 'event' )
            // InternalStoryGen.g:2882:2: 'event'
            {
             before(grammarAccess.getHappeningEventAccess().getEventKeyword_1()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getEventKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__1__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__2"
    // InternalStoryGen.g:2891:1: rule__HappeningEvent__Group__2 : rule__HappeningEvent__Group__2__Impl rule__HappeningEvent__Group__3 ;
    public final void rule__HappeningEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2895:1: ( rule__HappeningEvent__Group__2__Impl rule__HappeningEvent__Group__3 )
            // InternalStoryGen.g:2896:2: rule__HappeningEvent__Group__2__Impl rule__HappeningEvent__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__HappeningEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__2"


    // $ANTLR start "rule__HappeningEvent__Group__2__Impl"
    // InternalStoryGen.g:2903:1: rule__HappeningEvent__Group__2__Impl : ( ( rule__HappeningEvent__NameAssignment_2 ) ) ;
    public final void rule__HappeningEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2907:1: ( ( ( rule__HappeningEvent__NameAssignment_2 ) ) )
            // InternalStoryGen.g:2908:1: ( ( rule__HappeningEvent__NameAssignment_2 ) )
            {
            // InternalStoryGen.g:2908:1: ( ( rule__HappeningEvent__NameAssignment_2 ) )
            // InternalStoryGen.g:2909:2: ( rule__HappeningEvent__NameAssignment_2 )
            {
             before(grammarAccess.getHappeningEventAccess().getNameAssignment_2()); 
            // InternalStoryGen.g:2910:2: ( rule__HappeningEvent__NameAssignment_2 )
            // InternalStoryGen.g:2910:3: rule__HappeningEvent__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getHappeningEventAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__2__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__3"
    // InternalStoryGen.g:2918:1: rule__HappeningEvent__Group__3 : rule__HappeningEvent__Group__3__Impl rule__HappeningEvent__Group__4 ;
    public final void rule__HappeningEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2922:1: ( rule__HappeningEvent__Group__3__Impl rule__HappeningEvent__Group__4 )
            // InternalStoryGen.g:2923:2: rule__HappeningEvent__Group__3__Impl rule__HappeningEvent__Group__4
            {
            pushFollow(FOLLOW_29);
            rule__HappeningEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__3"


    // $ANTLR start "rule__HappeningEvent__Group__3__Impl"
    // InternalStoryGen.g:2930:1: rule__HappeningEvent__Group__3__Impl : ( '{' ) ;
    public final void rule__HappeningEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2934:1: ( ( '{' ) )
            // InternalStoryGen.g:2935:1: ( '{' )
            {
            // InternalStoryGen.g:2935:1: ( '{' )
            // InternalStoryGen.g:2936:2: '{'
            {
             before(grammarAccess.getHappeningEventAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__3__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__4"
    // InternalStoryGen.g:2945:1: rule__HappeningEvent__Group__4 : rule__HappeningEvent__Group__4__Impl rule__HappeningEvent__Group__5 ;
    public final void rule__HappeningEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2949:1: ( rule__HappeningEvent__Group__4__Impl rule__HappeningEvent__Group__5 )
            // InternalStoryGen.g:2950:2: rule__HappeningEvent__Group__4__Impl rule__HappeningEvent__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__HappeningEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__4"


    // $ANTLR start "rule__HappeningEvent__Group__4__Impl"
    // InternalStoryGen.g:2957:1: rule__HappeningEvent__Group__4__Impl : ( ( rule__HappeningEvent__Group_4__0 )? ) ;
    public final void rule__HappeningEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2961:1: ( ( ( rule__HappeningEvent__Group_4__0 )? ) )
            // InternalStoryGen.g:2962:1: ( ( rule__HappeningEvent__Group_4__0 )? )
            {
            // InternalStoryGen.g:2962:1: ( ( rule__HappeningEvent__Group_4__0 )? )
            // InternalStoryGen.g:2963:2: ( rule__HappeningEvent__Group_4__0 )?
            {
             before(grammarAccess.getHappeningEventAccess().getGroup_4()); 
            // InternalStoryGen.g:2964:2: ( rule__HappeningEvent__Group_4__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==55) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalStoryGen.g:2964:3: rule__HappeningEvent__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HappeningEvent__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHappeningEventAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__4__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__5"
    // InternalStoryGen.g:2972:1: rule__HappeningEvent__Group__5 : rule__HappeningEvent__Group__5__Impl rule__HappeningEvent__Group__6 ;
    public final void rule__HappeningEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2976:1: ( rule__HappeningEvent__Group__5__Impl rule__HappeningEvent__Group__6 )
            // InternalStoryGen.g:2977:2: rule__HappeningEvent__Group__5__Impl rule__HappeningEvent__Group__6
            {
            pushFollow(FOLLOW_17);
            rule__HappeningEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__5"


    // $ANTLR start "rule__HappeningEvent__Group__5__Impl"
    // InternalStoryGen.g:2984:1: rule__HappeningEvent__Group__5__Impl : ( 'description:' ) ;
    public final void rule__HappeningEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:2988:1: ( ( 'description:' ) )
            // InternalStoryGen.g:2989:1: ( 'description:' )
            {
            // InternalStoryGen.g:2989:1: ( 'description:' )
            // InternalStoryGen.g:2990:2: 'description:'
            {
             before(grammarAccess.getHappeningEventAccess().getDescriptionKeyword_5()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getDescriptionKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__5__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__6"
    // InternalStoryGen.g:2999:1: rule__HappeningEvent__Group__6 : rule__HappeningEvent__Group__6__Impl rule__HappeningEvent__Group__7 ;
    public final void rule__HappeningEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3003:1: ( rule__HappeningEvent__Group__6__Impl rule__HappeningEvent__Group__7 )
            // InternalStoryGen.g:3004:2: rule__HappeningEvent__Group__6__Impl rule__HappeningEvent__Group__7
            {
            pushFollow(FOLLOW_30);
            rule__HappeningEvent__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__6"


    // $ANTLR start "rule__HappeningEvent__Group__6__Impl"
    // InternalStoryGen.g:3011:1: rule__HappeningEvent__Group__6__Impl : ( ( rule__HappeningEvent__DescriptionAssignment_6 ) ) ;
    public final void rule__HappeningEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3015:1: ( ( ( rule__HappeningEvent__DescriptionAssignment_6 ) ) )
            // InternalStoryGen.g:3016:1: ( ( rule__HappeningEvent__DescriptionAssignment_6 ) )
            {
            // InternalStoryGen.g:3016:1: ( ( rule__HappeningEvent__DescriptionAssignment_6 ) )
            // InternalStoryGen.g:3017:2: ( rule__HappeningEvent__DescriptionAssignment_6 )
            {
             before(grammarAccess.getHappeningEventAccess().getDescriptionAssignment_6()); 
            // InternalStoryGen.g:3018:2: ( rule__HappeningEvent__DescriptionAssignment_6 )
            // InternalStoryGen.g:3018:3: rule__HappeningEvent__DescriptionAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__DescriptionAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getHappeningEventAccess().getDescriptionAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__6__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__7"
    // InternalStoryGen.g:3026:1: rule__HappeningEvent__Group__7 : rule__HappeningEvent__Group__7__Impl rule__HappeningEvent__Group__8 ;
    public final void rule__HappeningEvent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3030:1: ( rule__HappeningEvent__Group__7__Impl rule__HappeningEvent__Group__8 )
            // InternalStoryGen.g:3031:2: rule__HappeningEvent__Group__7__Impl rule__HappeningEvent__Group__8
            {
            pushFollow(FOLLOW_30);
            rule__HappeningEvent__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__7"


    // $ANTLR start "rule__HappeningEvent__Group__7__Impl"
    // InternalStoryGen.g:3038:1: rule__HappeningEvent__Group__7__Impl : ( ( rule__HappeningEvent__Group_7__0 )? ) ;
    public final void rule__HappeningEvent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3042:1: ( ( ( rule__HappeningEvent__Group_7__0 )? ) )
            // InternalStoryGen.g:3043:1: ( ( rule__HappeningEvent__Group_7__0 )? )
            {
            // InternalStoryGen.g:3043:1: ( ( rule__HappeningEvent__Group_7__0 )? )
            // InternalStoryGen.g:3044:2: ( rule__HappeningEvent__Group_7__0 )?
            {
             before(grammarAccess.getHappeningEventAccess().getGroup_7()); 
            // InternalStoryGen.g:3045:2: ( rule__HappeningEvent__Group_7__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==56) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalStoryGen.g:3045:3: rule__HappeningEvent__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HappeningEvent__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHappeningEventAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__7__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__8"
    // InternalStoryGen.g:3053:1: rule__HappeningEvent__Group__8 : rule__HappeningEvent__Group__8__Impl rule__HappeningEvent__Group__9 ;
    public final void rule__HappeningEvent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3057:1: ( rule__HappeningEvent__Group__8__Impl rule__HappeningEvent__Group__9 )
            // InternalStoryGen.g:3058:2: rule__HappeningEvent__Group__8__Impl rule__HappeningEvent__Group__9
            {
            pushFollow(FOLLOW_30);
            rule__HappeningEvent__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__8"


    // $ANTLR start "rule__HappeningEvent__Group__8__Impl"
    // InternalStoryGen.g:3065:1: rule__HappeningEvent__Group__8__Impl : ( ( rule__HappeningEvent__Group_8__0 )? ) ;
    public final void rule__HappeningEvent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3069:1: ( ( ( rule__HappeningEvent__Group_8__0 )? ) )
            // InternalStoryGen.g:3070:1: ( ( rule__HappeningEvent__Group_8__0 )? )
            {
            // InternalStoryGen.g:3070:1: ( ( rule__HappeningEvent__Group_8__0 )? )
            // InternalStoryGen.g:3071:2: ( rule__HappeningEvent__Group_8__0 )?
            {
             before(grammarAccess.getHappeningEventAccess().getGroup_8()); 
            // InternalStoryGen.g:3072:2: ( rule__HappeningEvent__Group_8__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==57) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalStoryGen.g:3072:3: rule__HappeningEvent__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HappeningEvent__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHappeningEventAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__8__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__9"
    // InternalStoryGen.g:3080:1: rule__HappeningEvent__Group__9 : rule__HappeningEvent__Group__9__Impl rule__HappeningEvent__Group__10 ;
    public final void rule__HappeningEvent__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3084:1: ( rule__HappeningEvent__Group__9__Impl rule__HappeningEvent__Group__10 )
            // InternalStoryGen.g:3085:2: rule__HappeningEvent__Group__9__Impl rule__HappeningEvent__Group__10
            {
            pushFollow(FOLLOW_30);
            rule__HappeningEvent__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__9"


    // $ANTLR start "rule__HappeningEvent__Group__9__Impl"
    // InternalStoryGen.g:3092:1: rule__HappeningEvent__Group__9__Impl : ( ( rule__HappeningEvent__Group_9__0 )? ) ;
    public final void rule__HappeningEvent__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3096:1: ( ( ( rule__HappeningEvent__Group_9__0 )? ) )
            // InternalStoryGen.g:3097:1: ( ( rule__HappeningEvent__Group_9__0 )? )
            {
            // InternalStoryGen.g:3097:1: ( ( rule__HappeningEvent__Group_9__0 )? )
            // InternalStoryGen.g:3098:2: ( rule__HappeningEvent__Group_9__0 )?
            {
             before(grammarAccess.getHappeningEventAccess().getGroup_9()); 
            // InternalStoryGen.g:3099:2: ( rule__HappeningEvent__Group_9__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==58) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalStoryGen.g:3099:3: rule__HappeningEvent__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HappeningEvent__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHappeningEventAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__9__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__10"
    // InternalStoryGen.g:3107:1: rule__HappeningEvent__Group__10 : rule__HappeningEvent__Group__10__Impl rule__HappeningEvent__Group__11 ;
    public final void rule__HappeningEvent__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3111:1: ( rule__HappeningEvent__Group__10__Impl rule__HappeningEvent__Group__11 )
            // InternalStoryGen.g:3112:2: rule__HappeningEvent__Group__10__Impl rule__HappeningEvent__Group__11
            {
            pushFollow(FOLLOW_30);
            rule__HappeningEvent__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__10"


    // $ANTLR start "rule__HappeningEvent__Group__10__Impl"
    // InternalStoryGen.g:3119:1: rule__HappeningEvent__Group__10__Impl : ( ( rule__HappeningEvent__ConditionsAssignment_10 )* ) ;
    public final void rule__HappeningEvent__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3123:1: ( ( ( rule__HappeningEvent__ConditionsAssignment_10 )* ) )
            // InternalStoryGen.g:3124:1: ( ( rule__HappeningEvent__ConditionsAssignment_10 )* )
            {
            // InternalStoryGen.g:3124:1: ( ( rule__HappeningEvent__ConditionsAssignment_10 )* )
            // InternalStoryGen.g:3125:2: ( rule__HappeningEvent__ConditionsAssignment_10 )*
            {
             before(grammarAccess.getHappeningEventAccess().getConditionsAssignment_10()); 
            // InternalStoryGen.g:3126:2: ( rule__HappeningEvent__ConditionsAssignment_10 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==63) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalStoryGen.g:3126:3: rule__HappeningEvent__ConditionsAssignment_10
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__HappeningEvent__ConditionsAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getHappeningEventAccess().getConditionsAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__10__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__11"
    // InternalStoryGen.g:3134:1: rule__HappeningEvent__Group__11 : rule__HappeningEvent__Group__11__Impl rule__HappeningEvent__Group__12 ;
    public final void rule__HappeningEvent__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3138:1: ( rule__HappeningEvent__Group__11__Impl rule__HappeningEvent__Group__12 )
            // InternalStoryGen.g:3139:2: rule__HappeningEvent__Group__11__Impl rule__HappeningEvent__Group__12
            {
            pushFollow(FOLLOW_30);
            rule__HappeningEvent__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__11"


    // $ANTLR start "rule__HappeningEvent__Group__11__Impl"
    // InternalStoryGen.g:3146:1: rule__HappeningEvent__Group__11__Impl : ( ( rule__HappeningEvent__ChangesAssignment_11 )* ) ;
    public final void rule__HappeningEvent__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3150:1: ( ( ( rule__HappeningEvent__ChangesAssignment_11 )* ) )
            // InternalStoryGen.g:3151:1: ( ( rule__HappeningEvent__ChangesAssignment_11 )* )
            {
            // InternalStoryGen.g:3151:1: ( ( rule__HappeningEvent__ChangesAssignment_11 )* )
            // InternalStoryGen.g:3152:2: ( rule__HappeningEvent__ChangesAssignment_11 )*
            {
             before(grammarAccess.getHappeningEventAccess().getChangesAssignment_11()); 
            // InternalStoryGen.g:3153:2: ( rule__HappeningEvent__ChangesAssignment_11 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==64) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalStoryGen.g:3153:3: rule__HappeningEvent__ChangesAssignment_11
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__HappeningEvent__ChangesAssignment_11();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getHappeningEventAccess().getChangesAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__11__Impl"


    // $ANTLR start "rule__HappeningEvent__Group__12"
    // InternalStoryGen.g:3161:1: rule__HappeningEvent__Group__12 : rule__HappeningEvent__Group__12__Impl ;
    public final void rule__HappeningEvent__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3165:1: ( rule__HappeningEvent__Group__12__Impl )
            // InternalStoryGen.g:3166:2: rule__HappeningEvent__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__12"


    // $ANTLR start "rule__HappeningEvent__Group__12__Impl"
    // InternalStoryGen.g:3172:1: rule__HappeningEvent__Group__12__Impl : ( '}' ) ;
    public final void rule__HappeningEvent__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3176:1: ( ( '}' ) )
            // InternalStoryGen.g:3177:1: ( '}' )
            {
            // InternalStoryGen.g:3177:1: ( '}' )
            // InternalStoryGen.g:3178:2: '}'
            {
             before(grammarAccess.getHappeningEventAccess().getRightCurlyBracketKeyword_12()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group__12__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_4__0"
    // InternalStoryGen.g:3188:1: rule__HappeningEvent__Group_4__0 : rule__HappeningEvent__Group_4__0__Impl rule__HappeningEvent__Group_4__1 ;
    public final void rule__HappeningEvent__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3192:1: ( rule__HappeningEvent__Group_4__0__Impl rule__HappeningEvent__Group_4__1 )
            // InternalStoryGen.g:3193:2: rule__HappeningEvent__Group_4__0__Impl rule__HappeningEvent__Group_4__1
            {
            pushFollow(FOLLOW_33);
            rule__HappeningEvent__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_4__0"


    // $ANTLR start "rule__HappeningEvent__Group_4__0__Impl"
    // InternalStoryGen.g:3200:1: rule__HappeningEvent__Group_4__0__Impl : ( 'priority:' ) ;
    public final void rule__HappeningEvent__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3204:1: ( ( 'priority:' ) )
            // InternalStoryGen.g:3205:1: ( 'priority:' )
            {
            // InternalStoryGen.g:3205:1: ( 'priority:' )
            // InternalStoryGen.g:3206:2: 'priority:'
            {
             before(grammarAccess.getHappeningEventAccess().getPriorityKeyword_4_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getPriorityKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_4__0__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_4__1"
    // InternalStoryGen.g:3215:1: rule__HappeningEvent__Group_4__1 : rule__HappeningEvent__Group_4__1__Impl ;
    public final void rule__HappeningEvent__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3219:1: ( rule__HappeningEvent__Group_4__1__Impl )
            // InternalStoryGen.g:3220:2: rule__HappeningEvent__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_4__1"


    // $ANTLR start "rule__HappeningEvent__Group_4__1__Impl"
    // InternalStoryGen.g:3226:1: rule__HappeningEvent__Group_4__1__Impl : ( ( rule__HappeningEvent__PriorityAssignment_4_1 ) ) ;
    public final void rule__HappeningEvent__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3230:1: ( ( ( rule__HappeningEvent__PriorityAssignment_4_1 ) ) )
            // InternalStoryGen.g:3231:1: ( ( rule__HappeningEvent__PriorityAssignment_4_1 ) )
            {
            // InternalStoryGen.g:3231:1: ( ( rule__HappeningEvent__PriorityAssignment_4_1 ) )
            // InternalStoryGen.g:3232:2: ( rule__HappeningEvent__PriorityAssignment_4_1 )
            {
             before(grammarAccess.getHappeningEventAccess().getPriorityAssignment_4_1()); 
            // InternalStoryGen.g:3233:2: ( rule__HappeningEvent__PriorityAssignment_4_1 )
            // InternalStoryGen.g:3233:3: rule__HappeningEvent__PriorityAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__PriorityAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getHappeningEventAccess().getPriorityAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_4__1__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_7__0"
    // InternalStoryGen.g:3242:1: rule__HappeningEvent__Group_7__0 : rule__HappeningEvent__Group_7__0__Impl rule__HappeningEvent__Group_7__1 ;
    public final void rule__HappeningEvent__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3246:1: ( rule__HappeningEvent__Group_7__0__Impl rule__HappeningEvent__Group_7__1 )
            // InternalStoryGen.g:3247:2: rule__HappeningEvent__Group_7__0__Impl rule__HappeningEvent__Group_7__1
            {
            pushFollow(FOLLOW_17);
            rule__HappeningEvent__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_7__0"


    // $ANTLR start "rule__HappeningEvent__Group_7__0__Impl"
    // InternalStoryGen.g:3254:1: rule__HappeningEvent__Group_7__0__Impl : ( 'short-description:' ) ;
    public final void rule__HappeningEvent__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3258:1: ( ( 'short-description:' ) )
            // InternalStoryGen.g:3259:1: ( 'short-description:' )
            {
            // InternalStoryGen.g:3259:1: ( 'short-description:' )
            // InternalStoryGen.g:3260:2: 'short-description:'
            {
             before(grammarAccess.getHappeningEventAccess().getShortDescriptionKeyword_7_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getShortDescriptionKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_7__0__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_7__1"
    // InternalStoryGen.g:3269:1: rule__HappeningEvent__Group_7__1 : rule__HappeningEvent__Group_7__1__Impl ;
    public final void rule__HappeningEvent__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3273:1: ( rule__HappeningEvent__Group_7__1__Impl )
            // InternalStoryGen.g:3274:2: rule__HappeningEvent__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_7__1"


    // $ANTLR start "rule__HappeningEvent__Group_7__1__Impl"
    // InternalStoryGen.g:3280:1: rule__HappeningEvent__Group_7__1__Impl : ( ( rule__HappeningEvent__ShortDescriptionAssignment_7_1 ) ) ;
    public final void rule__HappeningEvent__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3284:1: ( ( ( rule__HappeningEvent__ShortDescriptionAssignment_7_1 ) ) )
            // InternalStoryGen.g:3285:1: ( ( rule__HappeningEvent__ShortDescriptionAssignment_7_1 ) )
            {
            // InternalStoryGen.g:3285:1: ( ( rule__HappeningEvent__ShortDescriptionAssignment_7_1 ) )
            // InternalStoryGen.g:3286:2: ( rule__HappeningEvent__ShortDescriptionAssignment_7_1 )
            {
             before(grammarAccess.getHappeningEventAccess().getShortDescriptionAssignment_7_1()); 
            // InternalStoryGen.g:3287:2: ( rule__HappeningEvent__ShortDescriptionAssignment_7_1 )
            // InternalStoryGen.g:3287:3: rule__HappeningEvent__ShortDescriptionAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__ShortDescriptionAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getHappeningEventAccess().getShortDescriptionAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_7__1__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_8__0"
    // InternalStoryGen.g:3296:1: rule__HappeningEvent__Group_8__0 : rule__HappeningEvent__Group_8__0__Impl rule__HappeningEvent__Group_8__1 ;
    public final void rule__HappeningEvent__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3300:1: ( rule__HappeningEvent__Group_8__0__Impl rule__HappeningEvent__Group_8__1 )
            // InternalStoryGen.g:3301:2: rule__HappeningEvent__Group_8__0__Impl rule__HappeningEvent__Group_8__1
            {
            pushFollow(FOLLOW_15);
            rule__HappeningEvent__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_8__0"


    // $ANTLR start "rule__HappeningEvent__Group_8__0__Impl"
    // InternalStoryGen.g:3308:1: rule__HappeningEvent__Group_8__0__Impl : ( 'triggers:' ) ;
    public final void rule__HappeningEvent__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3312:1: ( ( 'triggers:' ) )
            // InternalStoryGen.g:3313:1: ( 'triggers:' )
            {
            // InternalStoryGen.g:3313:1: ( 'triggers:' )
            // InternalStoryGen.g:3314:2: 'triggers:'
            {
             before(grammarAccess.getHappeningEventAccess().getTriggersKeyword_8_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getTriggersKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_8__0__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_8__1"
    // InternalStoryGen.g:3323:1: rule__HappeningEvent__Group_8__1 : rule__HappeningEvent__Group_8__1__Impl ;
    public final void rule__HappeningEvent__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3327:1: ( rule__HappeningEvent__Group_8__1__Impl )
            // InternalStoryGen.g:3328:2: rule__HappeningEvent__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_8__1"


    // $ANTLR start "rule__HappeningEvent__Group_8__1__Impl"
    // InternalStoryGen.g:3334:1: rule__HappeningEvent__Group_8__1__Impl : ( ( rule__HappeningEvent__TriggerAssignment_8_1 ) ) ;
    public final void rule__HappeningEvent__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3338:1: ( ( ( rule__HappeningEvent__TriggerAssignment_8_1 ) ) )
            // InternalStoryGen.g:3339:1: ( ( rule__HappeningEvent__TriggerAssignment_8_1 ) )
            {
            // InternalStoryGen.g:3339:1: ( ( rule__HappeningEvent__TriggerAssignment_8_1 ) )
            // InternalStoryGen.g:3340:2: ( rule__HappeningEvent__TriggerAssignment_8_1 )
            {
             before(grammarAccess.getHappeningEventAccess().getTriggerAssignment_8_1()); 
            // InternalStoryGen.g:3341:2: ( rule__HappeningEvent__TriggerAssignment_8_1 )
            // InternalStoryGen.g:3341:3: rule__HappeningEvent__TriggerAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__TriggerAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getHappeningEventAccess().getTriggerAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_8__1__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_9__0"
    // InternalStoryGen.g:3350:1: rule__HappeningEvent__Group_9__0 : rule__HappeningEvent__Group_9__0__Impl rule__HappeningEvent__Group_9__1 ;
    public final void rule__HappeningEvent__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3354:1: ( rule__HappeningEvent__Group_9__0__Impl rule__HappeningEvent__Group_9__1 )
            // InternalStoryGen.g:3355:2: rule__HappeningEvent__Group_9__0__Impl rule__HappeningEvent__Group_9__1
            {
            pushFollow(FOLLOW_15);
            rule__HappeningEvent__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9__0"


    // $ANTLR start "rule__HappeningEvent__Group_9__0__Impl"
    // InternalStoryGen.g:3362:1: rule__HappeningEvent__Group_9__0__Impl : ( 'may-trigger:' ) ;
    public final void rule__HappeningEvent__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3366:1: ( ( 'may-trigger:' ) )
            // InternalStoryGen.g:3367:1: ( 'may-trigger:' )
            {
            // InternalStoryGen.g:3367:1: ( 'may-trigger:' )
            // InternalStoryGen.g:3368:2: 'may-trigger:'
            {
             before(grammarAccess.getHappeningEventAccess().getMayTriggerKeyword_9_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getMayTriggerKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9__0__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_9__1"
    // InternalStoryGen.g:3377:1: rule__HappeningEvent__Group_9__1 : rule__HappeningEvent__Group_9__1__Impl rule__HappeningEvent__Group_9__2 ;
    public final void rule__HappeningEvent__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3381:1: ( rule__HappeningEvent__Group_9__1__Impl rule__HappeningEvent__Group_9__2 )
            // InternalStoryGen.g:3382:2: rule__HappeningEvent__Group_9__1__Impl rule__HappeningEvent__Group_9__2
            {
            pushFollow(FOLLOW_15);
            rule__HappeningEvent__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9__1"


    // $ANTLR start "rule__HappeningEvent__Group_9__1__Impl"
    // InternalStoryGen.g:3389:1: rule__HappeningEvent__Group_9__1__Impl : ( ( rule__HappeningEvent__Group_9_1__0 )* ) ;
    public final void rule__HappeningEvent__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3393:1: ( ( ( rule__HappeningEvent__Group_9_1__0 )* ) )
            // InternalStoryGen.g:3394:1: ( ( rule__HappeningEvent__Group_9_1__0 )* )
            {
            // InternalStoryGen.g:3394:1: ( ( rule__HappeningEvent__Group_9_1__0 )* )
            // InternalStoryGen.g:3395:2: ( rule__HappeningEvent__Group_9_1__0 )*
            {
             before(grammarAccess.getHappeningEventAccess().getGroup_9_1()); 
            // InternalStoryGen.g:3396:2: ( rule__HappeningEvent__Group_9_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1==59) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // InternalStoryGen.g:3396:3: rule__HappeningEvent__Group_9_1__0
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__HappeningEvent__Group_9_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getHappeningEventAccess().getGroup_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9__1__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_9__2"
    // InternalStoryGen.g:3404:1: rule__HappeningEvent__Group_9__2 : rule__HappeningEvent__Group_9__2__Impl ;
    public final void rule__HappeningEvent__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3408:1: ( rule__HappeningEvent__Group_9__2__Impl )
            // InternalStoryGen.g:3409:2: rule__HappeningEvent__Group_9__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_9__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9__2"


    // $ANTLR start "rule__HappeningEvent__Group_9__2__Impl"
    // InternalStoryGen.g:3415:1: rule__HappeningEvent__Group_9__2__Impl : ( ( rule__HappeningEvent__MayTriggersAssignment_9_2 ) ) ;
    public final void rule__HappeningEvent__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3419:1: ( ( ( rule__HappeningEvent__MayTriggersAssignment_9_2 ) ) )
            // InternalStoryGen.g:3420:1: ( ( rule__HappeningEvent__MayTriggersAssignment_9_2 ) )
            {
            // InternalStoryGen.g:3420:1: ( ( rule__HappeningEvent__MayTriggersAssignment_9_2 ) )
            // InternalStoryGen.g:3421:2: ( rule__HappeningEvent__MayTriggersAssignment_9_2 )
            {
             before(grammarAccess.getHappeningEventAccess().getMayTriggersAssignment_9_2()); 
            // InternalStoryGen.g:3422:2: ( rule__HappeningEvent__MayTriggersAssignment_9_2 )
            // InternalStoryGen.g:3422:3: rule__HappeningEvent__MayTriggersAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__MayTriggersAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getHappeningEventAccess().getMayTriggersAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9__2__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_9_1__0"
    // InternalStoryGen.g:3431:1: rule__HappeningEvent__Group_9_1__0 : rule__HappeningEvent__Group_9_1__0__Impl rule__HappeningEvent__Group_9_1__1 ;
    public final void rule__HappeningEvent__Group_9_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3435:1: ( rule__HappeningEvent__Group_9_1__0__Impl rule__HappeningEvent__Group_9_1__1 )
            // InternalStoryGen.g:3436:2: rule__HappeningEvent__Group_9_1__0__Impl rule__HappeningEvent__Group_9_1__1
            {
            pushFollow(FOLLOW_35);
            rule__HappeningEvent__Group_9_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_9_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9_1__0"


    // $ANTLR start "rule__HappeningEvent__Group_9_1__0__Impl"
    // InternalStoryGen.g:3443:1: rule__HappeningEvent__Group_9_1__0__Impl : ( ( rule__HappeningEvent__MayTriggersAssignment_9_1_0 ) ) ;
    public final void rule__HappeningEvent__Group_9_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3447:1: ( ( ( rule__HappeningEvent__MayTriggersAssignment_9_1_0 ) ) )
            // InternalStoryGen.g:3448:1: ( ( rule__HappeningEvent__MayTriggersAssignment_9_1_0 ) )
            {
            // InternalStoryGen.g:3448:1: ( ( rule__HappeningEvent__MayTriggersAssignment_9_1_0 ) )
            // InternalStoryGen.g:3449:2: ( rule__HappeningEvent__MayTriggersAssignment_9_1_0 )
            {
             before(grammarAccess.getHappeningEventAccess().getMayTriggersAssignment_9_1_0()); 
            // InternalStoryGen.g:3450:2: ( rule__HappeningEvent__MayTriggersAssignment_9_1_0 )
            // InternalStoryGen.g:3450:3: rule__HappeningEvent__MayTriggersAssignment_9_1_0
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__MayTriggersAssignment_9_1_0();

            state._fsp--;


            }

             after(grammarAccess.getHappeningEventAccess().getMayTriggersAssignment_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9_1__0__Impl"


    // $ANTLR start "rule__HappeningEvent__Group_9_1__1"
    // InternalStoryGen.g:3458:1: rule__HappeningEvent__Group_9_1__1 : rule__HappeningEvent__Group_9_1__1__Impl ;
    public final void rule__HappeningEvent__Group_9_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3462:1: ( rule__HappeningEvent__Group_9_1__1__Impl )
            // InternalStoryGen.g:3463:2: rule__HappeningEvent__Group_9_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HappeningEvent__Group_9_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9_1__1"


    // $ANTLR start "rule__HappeningEvent__Group_9_1__1__Impl"
    // InternalStoryGen.g:3469:1: rule__HappeningEvent__Group_9_1__1__Impl : ( ',' ) ;
    public final void rule__HappeningEvent__Group_9_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3473:1: ( ( ',' ) )
            // InternalStoryGen.g:3474:1: ( ',' )
            {
            // InternalStoryGen.g:3474:1: ( ',' )
            // InternalStoryGen.g:3475:2: ','
            {
             before(grammarAccess.getHappeningEventAccess().getCommaKeyword_9_1_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getCommaKeyword_9_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__Group_9_1__1__Impl"


    // $ANTLR start "rule__ActionEvent__Group__0"
    // InternalStoryGen.g:3485:1: rule__ActionEvent__Group__0 : rule__ActionEvent__Group__0__Impl rule__ActionEvent__Group__1 ;
    public final void rule__ActionEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3489:1: ( rule__ActionEvent__Group__0__Impl rule__ActionEvent__Group__1 )
            // InternalStoryGen.g:3490:2: rule__ActionEvent__Group__0__Impl rule__ActionEvent__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__ActionEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__0"


    // $ANTLR start "rule__ActionEvent__Group__0__Impl"
    // InternalStoryGen.g:3497:1: rule__ActionEvent__Group__0__Impl : ( 'action' ) ;
    public final void rule__ActionEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3501:1: ( ( 'action' ) )
            // InternalStoryGen.g:3502:1: ( 'action' )
            {
            // InternalStoryGen.g:3502:1: ( 'action' )
            // InternalStoryGen.g:3503:2: 'action'
            {
             before(grammarAccess.getActionEventAccess().getActionKeyword_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getActionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__0__Impl"


    // $ANTLR start "rule__ActionEvent__Group__1"
    // InternalStoryGen.g:3512:1: rule__ActionEvent__Group__1 : rule__ActionEvent__Group__1__Impl rule__ActionEvent__Group__2 ;
    public final void rule__ActionEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3516:1: ( rule__ActionEvent__Group__1__Impl rule__ActionEvent__Group__2 )
            // InternalStoryGen.g:3517:2: rule__ActionEvent__Group__1__Impl rule__ActionEvent__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__ActionEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__1"


    // $ANTLR start "rule__ActionEvent__Group__1__Impl"
    // InternalStoryGen.g:3524:1: rule__ActionEvent__Group__1__Impl : ( ( rule__ActionEvent__NameAssignment_1 ) ) ;
    public final void rule__ActionEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3528:1: ( ( ( rule__ActionEvent__NameAssignment_1 ) ) )
            // InternalStoryGen.g:3529:1: ( ( rule__ActionEvent__NameAssignment_1 ) )
            {
            // InternalStoryGen.g:3529:1: ( ( rule__ActionEvent__NameAssignment_1 ) )
            // InternalStoryGen.g:3530:2: ( rule__ActionEvent__NameAssignment_1 )
            {
             before(grammarAccess.getActionEventAccess().getNameAssignment_1()); 
            // InternalStoryGen.g:3531:2: ( rule__ActionEvent__NameAssignment_1 )
            // InternalStoryGen.g:3531:3: rule__ActionEvent__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__1__Impl"


    // $ANTLR start "rule__ActionEvent__Group__2"
    // InternalStoryGen.g:3539:1: rule__ActionEvent__Group__2 : rule__ActionEvent__Group__2__Impl rule__ActionEvent__Group__3 ;
    public final void rule__ActionEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3543:1: ( rule__ActionEvent__Group__2__Impl rule__ActionEvent__Group__3 )
            // InternalStoryGen.g:3544:2: rule__ActionEvent__Group__2__Impl rule__ActionEvent__Group__3
            {
            pushFollow(FOLLOW_36);
            rule__ActionEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__2"


    // $ANTLR start "rule__ActionEvent__Group__2__Impl"
    // InternalStoryGen.g:3551:1: rule__ActionEvent__Group__2__Impl : ( '{' ) ;
    public final void rule__ActionEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3555:1: ( ( '{' ) )
            // InternalStoryGen.g:3556:1: ( '{' )
            {
            // InternalStoryGen.g:3556:1: ( '{' )
            // InternalStoryGen.g:3557:2: '{'
            {
             before(grammarAccess.getActionEventAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__2__Impl"


    // $ANTLR start "rule__ActionEvent__Group__3"
    // InternalStoryGen.g:3566:1: rule__ActionEvent__Group__3 : rule__ActionEvent__Group__3__Impl rule__ActionEvent__Group__4 ;
    public final void rule__ActionEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3570:1: ( rule__ActionEvent__Group__3__Impl rule__ActionEvent__Group__4 )
            // InternalStoryGen.g:3571:2: rule__ActionEvent__Group__3__Impl rule__ActionEvent__Group__4
            {
            pushFollow(FOLLOW_36);
            rule__ActionEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__3"


    // $ANTLR start "rule__ActionEvent__Group__3__Impl"
    // InternalStoryGen.g:3578:1: rule__ActionEvent__Group__3__Impl : ( ( rule__ActionEvent__Group_3__0 )? ) ;
    public final void rule__ActionEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3582:1: ( ( ( rule__ActionEvent__Group_3__0 )? ) )
            // InternalStoryGen.g:3583:1: ( ( rule__ActionEvent__Group_3__0 )? )
            {
            // InternalStoryGen.g:3583:1: ( ( rule__ActionEvent__Group_3__0 )? )
            // InternalStoryGen.g:3584:2: ( rule__ActionEvent__Group_3__0 )?
            {
             before(grammarAccess.getActionEventAccess().getGroup_3()); 
            // InternalStoryGen.g:3585:2: ( rule__ActionEvent__Group_3__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==55) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalStoryGen.g:3585:3: rule__ActionEvent__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ActionEvent__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionEventAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__3__Impl"


    // $ANTLR start "rule__ActionEvent__Group__4"
    // InternalStoryGen.g:3593:1: rule__ActionEvent__Group__4 : rule__ActionEvent__Group__4__Impl rule__ActionEvent__Group__5 ;
    public final void rule__ActionEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3597:1: ( rule__ActionEvent__Group__4__Impl rule__ActionEvent__Group__5 )
            // InternalStoryGen.g:3598:2: rule__ActionEvent__Group__4__Impl rule__ActionEvent__Group__5
            {
            pushFollow(FOLLOW_37);
            rule__ActionEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__4"


    // $ANTLR start "rule__ActionEvent__Group__4__Impl"
    // InternalStoryGen.g:3605:1: rule__ActionEvent__Group__4__Impl : ( 'type:' ) ;
    public final void rule__ActionEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3609:1: ( ( 'type:' ) )
            // InternalStoryGen.g:3610:1: ( 'type:' )
            {
            // InternalStoryGen.g:3610:1: ( 'type:' )
            // InternalStoryGen.g:3611:2: 'type:'
            {
             before(grammarAccess.getActionEventAccess().getTypeKeyword_4()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getTypeKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__4__Impl"


    // $ANTLR start "rule__ActionEvent__Group__5"
    // InternalStoryGen.g:3620:1: rule__ActionEvent__Group__5 : rule__ActionEvent__Group__5__Impl rule__ActionEvent__Group__6 ;
    public final void rule__ActionEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3624:1: ( rule__ActionEvent__Group__5__Impl rule__ActionEvent__Group__6 )
            // InternalStoryGen.g:3625:2: rule__ActionEvent__Group__5__Impl rule__ActionEvent__Group__6
            {
            pushFollow(FOLLOW_38);
            rule__ActionEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__5"


    // $ANTLR start "rule__ActionEvent__Group__5__Impl"
    // InternalStoryGen.g:3632:1: rule__ActionEvent__Group__5__Impl : ( ( rule__ActionEvent__TypeAssignment_5 ) ) ;
    public final void rule__ActionEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3636:1: ( ( ( rule__ActionEvent__TypeAssignment_5 ) ) )
            // InternalStoryGen.g:3637:1: ( ( rule__ActionEvent__TypeAssignment_5 ) )
            {
            // InternalStoryGen.g:3637:1: ( ( rule__ActionEvent__TypeAssignment_5 ) )
            // InternalStoryGen.g:3638:2: ( rule__ActionEvent__TypeAssignment_5 )
            {
             before(grammarAccess.getActionEventAccess().getTypeAssignment_5()); 
            // InternalStoryGen.g:3639:2: ( rule__ActionEvent__TypeAssignment_5 )
            // InternalStoryGen.g:3639:3: rule__ActionEvent__TypeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__TypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getTypeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__5__Impl"


    // $ANTLR start "rule__ActionEvent__Group__6"
    // InternalStoryGen.g:3647:1: rule__ActionEvent__Group__6 : rule__ActionEvent__Group__6__Impl rule__ActionEvent__Group__7 ;
    public final void rule__ActionEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3651:1: ( rule__ActionEvent__Group__6__Impl rule__ActionEvent__Group__7 )
            // InternalStoryGen.g:3652:2: rule__ActionEvent__Group__6__Impl rule__ActionEvent__Group__7
            {
            pushFollow(FOLLOW_17);
            rule__ActionEvent__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__6"


    // $ANTLR start "rule__ActionEvent__Group__6__Impl"
    // InternalStoryGen.g:3659:1: rule__ActionEvent__Group__6__Impl : ( 'description:' ) ;
    public final void rule__ActionEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3663:1: ( ( 'description:' ) )
            // InternalStoryGen.g:3664:1: ( 'description:' )
            {
            // InternalStoryGen.g:3664:1: ( 'description:' )
            // InternalStoryGen.g:3665:2: 'description:'
            {
             before(grammarAccess.getActionEventAccess().getDescriptionKeyword_6()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getDescriptionKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__6__Impl"


    // $ANTLR start "rule__ActionEvent__Group__7"
    // InternalStoryGen.g:3674:1: rule__ActionEvent__Group__7 : rule__ActionEvent__Group__7__Impl rule__ActionEvent__Group__8 ;
    public final void rule__ActionEvent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3678:1: ( rule__ActionEvent__Group__7__Impl rule__ActionEvent__Group__8 )
            // InternalStoryGen.g:3679:2: rule__ActionEvent__Group__7__Impl rule__ActionEvent__Group__8
            {
            pushFollow(FOLLOW_39);
            rule__ActionEvent__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__7"


    // $ANTLR start "rule__ActionEvent__Group__7__Impl"
    // InternalStoryGen.g:3686:1: rule__ActionEvent__Group__7__Impl : ( ( rule__ActionEvent__DescriptionAssignment_7 ) ) ;
    public final void rule__ActionEvent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3690:1: ( ( ( rule__ActionEvent__DescriptionAssignment_7 ) ) )
            // InternalStoryGen.g:3691:1: ( ( rule__ActionEvent__DescriptionAssignment_7 ) )
            {
            // InternalStoryGen.g:3691:1: ( ( rule__ActionEvent__DescriptionAssignment_7 ) )
            // InternalStoryGen.g:3692:2: ( rule__ActionEvent__DescriptionAssignment_7 )
            {
             before(grammarAccess.getActionEventAccess().getDescriptionAssignment_7()); 
            // InternalStoryGen.g:3693:2: ( rule__ActionEvent__DescriptionAssignment_7 )
            // InternalStoryGen.g:3693:3: rule__ActionEvent__DescriptionAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__DescriptionAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getDescriptionAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__7__Impl"


    // $ANTLR start "rule__ActionEvent__Group__8"
    // InternalStoryGen.g:3701:1: rule__ActionEvent__Group__8 : rule__ActionEvent__Group__8__Impl rule__ActionEvent__Group__9 ;
    public final void rule__ActionEvent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3705:1: ( rule__ActionEvent__Group__8__Impl rule__ActionEvent__Group__9 )
            // InternalStoryGen.g:3706:2: rule__ActionEvent__Group__8__Impl rule__ActionEvent__Group__9
            {
            pushFollow(FOLLOW_39);
            rule__ActionEvent__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__8"


    // $ANTLR start "rule__ActionEvent__Group__8__Impl"
    // InternalStoryGen.g:3713:1: rule__ActionEvent__Group__8__Impl : ( ( rule__ActionEvent__Group_8__0 )? ) ;
    public final void rule__ActionEvent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3717:1: ( ( ( rule__ActionEvent__Group_8__0 )? ) )
            // InternalStoryGen.g:3718:1: ( ( rule__ActionEvent__Group_8__0 )? )
            {
            // InternalStoryGen.g:3718:1: ( ( rule__ActionEvent__Group_8__0 )? )
            // InternalStoryGen.g:3719:2: ( rule__ActionEvent__Group_8__0 )?
            {
             before(grammarAccess.getActionEventAccess().getGroup_8()); 
            // InternalStoryGen.g:3720:2: ( rule__ActionEvent__Group_8__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==56) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalStoryGen.g:3720:3: rule__ActionEvent__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ActionEvent__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionEventAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__8__Impl"


    // $ANTLR start "rule__ActionEvent__Group__9"
    // InternalStoryGen.g:3728:1: rule__ActionEvent__Group__9 : rule__ActionEvent__Group__9__Impl rule__ActionEvent__Group__10 ;
    public final void rule__ActionEvent__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3732:1: ( rule__ActionEvent__Group__9__Impl rule__ActionEvent__Group__10 )
            // InternalStoryGen.g:3733:2: rule__ActionEvent__Group__9__Impl rule__ActionEvent__Group__10
            {
            pushFollow(FOLLOW_15);
            rule__ActionEvent__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__9"


    // $ANTLR start "rule__ActionEvent__Group__9__Impl"
    // InternalStoryGen.g:3740:1: rule__ActionEvent__Group__9__Impl : ( 'actor:' ) ;
    public final void rule__ActionEvent__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3744:1: ( ( 'actor:' ) )
            // InternalStoryGen.g:3745:1: ( 'actor:' )
            {
            // InternalStoryGen.g:3745:1: ( 'actor:' )
            // InternalStoryGen.g:3746:2: 'actor:'
            {
             before(grammarAccess.getActionEventAccess().getActorKeyword_9()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getActorKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__9__Impl"


    // $ANTLR start "rule__ActionEvent__Group__10"
    // InternalStoryGen.g:3755:1: rule__ActionEvent__Group__10 : rule__ActionEvent__Group__10__Impl rule__ActionEvent__Group__11 ;
    public final void rule__ActionEvent__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3759:1: ( rule__ActionEvent__Group__10__Impl rule__ActionEvent__Group__11 )
            // InternalStoryGen.g:3760:2: rule__ActionEvent__Group__10__Impl rule__ActionEvent__Group__11
            {
            pushFollow(FOLLOW_40);
            rule__ActionEvent__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__10"


    // $ANTLR start "rule__ActionEvent__Group__10__Impl"
    // InternalStoryGen.g:3767:1: rule__ActionEvent__Group__10__Impl : ( ( rule__ActionEvent__ActorAssignment_10 ) ) ;
    public final void rule__ActionEvent__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3771:1: ( ( ( rule__ActionEvent__ActorAssignment_10 ) ) )
            // InternalStoryGen.g:3772:1: ( ( rule__ActionEvent__ActorAssignment_10 ) )
            {
            // InternalStoryGen.g:3772:1: ( ( rule__ActionEvent__ActorAssignment_10 ) )
            // InternalStoryGen.g:3773:2: ( rule__ActionEvent__ActorAssignment_10 )
            {
             before(grammarAccess.getActionEventAccess().getActorAssignment_10()); 
            // InternalStoryGen.g:3774:2: ( rule__ActionEvent__ActorAssignment_10 )
            // InternalStoryGen.g:3774:3: rule__ActionEvent__ActorAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__ActorAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getActorAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__10__Impl"


    // $ANTLR start "rule__ActionEvent__Group__11"
    // InternalStoryGen.g:3782:1: rule__ActionEvent__Group__11 : rule__ActionEvent__Group__11__Impl rule__ActionEvent__Group__12 ;
    public final void rule__ActionEvent__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3786:1: ( rule__ActionEvent__Group__11__Impl rule__ActionEvent__Group__12 )
            // InternalStoryGen.g:3787:2: rule__ActionEvent__Group__11__Impl rule__ActionEvent__Group__12
            {
            pushFollow(FOLLOW_40);
            rule__ActionEvent__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__11"


    // $ANTLR start "rule__ActionEvent__Group__11__Impl"
    // InternalStoryGen.g:3794:1: rule__ActionEvent__Group__11__Impl : ( ( rule__ActionEvent__Group_11__0 )? ) ;
    public final void rule__ActionEvent__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3798:1: ( ( ( rule__ActionEvent__Group_11__0 )? ) )
            // InternalStoryGen.g:3799:1: ( ( rule__ActionEvent__Group_11__0 )? )
            {
            // InternalStoryGen.g:3799:1: ( ( rule__ActionEvent__Group_11__0 )? )
            // InternalStoryGen.g:3800:2: ( rule__ActionEvent__Group_11__0 )?
            {
             before(grammarAccess.getActionEventAccess().getGroup_11()); 
            // InternalStoryGen.g:3801:2: ( rule__ActionEvent__Group_11__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==57) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalStoryGen.g:3801:3: rule__ActionEvent__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ActionEvent__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionEventAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__11__Impl"


    // $ANTLR start "rule__ActionEvent__Group__12"
    // InternalStoryGen.g:3809:1: rule__ActionEvent__Group__12 : rule__ActionEvent__Group__12__Impl rule__ActionEvent__Group__13 ;
    public final void rule__ActionEvent__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3813:1: ( rule__ActionEvent__Group__12__Impl rule__ActionEvent__Group__13 )
            // InternalStoryGen.g:3814:2: rule__ActionEvent__Group__12__Impl rule__ActionEvent__Group__13
            {
            pushFollow(FOLLOW_40);
            rule__ActionEvent__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__12"


    // $ANTLR start "rule__ActionEvent__Group__12__Impl"
    // InternalStoryGen.g:3821:1: rule__ActionEvent__Group__12__Impl : ( ( rule__ActionEvent__Group_12__0 )? ) ;
    public final void rule__ActionEvent__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3825:1: ( ( ( rule__ActionEvent__Group_12__0 )? ) )
            // InternalStoryGen.g:3826:1: ( ( rule__ActionEvent__Group_12__0 )? )
            {
            // InternalStoryGen.g:3826:1: ( ( rule__ActionEvent__Group_12__0 )? )
            // InternalStoryGen.g:3827:2: ( rule__ActionEvent__Group_12__0 )?
            {
             before(grammarAccess.getActionEventAccess().getGroup_12()); 
            // InternalStoryGen.g:3828:2: ( rule__ActionEvent__Group_12__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==58) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalStoryGen.g:3828:3: rule__ActionEvent__Group_12__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ActionEvent__Group_12__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionEventAccess().getGroup_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__12__Impl"


    // $ANTLR start "rule__ActionEvent__Group__13"
    // InternalStoryGen.g:3836:1: rule__ActionEvent__Group__13 : rule__ActionEvent__Group__13__Impl rule__ActionEvent__Group__14 ;
    public final void rule__ActionEvent__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3840:1: ( rule__ActionEvent__Group__13__Impl rule__ActionEvent__Group__14 )
            // InternalStoryGen.g:3841:2: rule__ActionEvent__Group__13__Impl rule__ActionEvent__Group__14
            {
            pushFollow(FOLLOW_40);
            rule__ActionEvent__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__13"


    // $ANTLR start "rule__ActionEvent__Group__13__Impl"
    // InternalStoryGen.g:3848:1: rule__ActionEvent__Group__13__Impl : ( ( rule__ActionEvent__ConditionsAssignment_13 )* ) ;
    public final void rule__ActionEvent__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3852:1: ( ( ( rule__ActionEvent__ConditionsAssignment_13 )* ) )
            // InternalStoryGen.g:3853:1: ( ( rule__ActionEvent__ConditionsAssignment_13 )* )
            {
            // InternalStoryGen.g:3853:1: ( ( rule__ActionEvent__ConditionsAssignment_13 )* )
            // InternalStoryGen.g:3854:2: ( rule__ActionEvent__ConditionsAssignment_13 )*
            {
             before(grammarAccess.getActionEventAccess().getConditionsAssignment_13()); 
            // InternalStoryGen.g:3855:2: ( rule__ActionEvent__ConditionsAssignment_13 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==63) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalStoryGen.g:3855:3: rule__ActionEvent__ConditionsAssignment_13
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__ActionEvent__ConditionsAssignment_13();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getActionEventAccess().getConditionsAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__13__Impl"


    // $ANTLR start "rule__ActionEvent__Group__14"
    // InternalStoryGen.g:3863:1: rule__ActionEvent__Group__14 : rule__ActionEvent__Group__14__Impl rule__ActionEvent__Group__15 ;
    public final void rule__ActionEvent__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3867:1: ( rule__ActionEvent__Group__14__Impl rule__ActionEvent__Group__15 )
            // InternalStoryGen.g:3868:2: rule__ActionEvent__Group__14__Impl rule__ActionEvent__Group__15
            {
            pushFollow(FOLLOW_40);
            rule__ActionEvent__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__14"


    // $ANTLR start "rule__ActionEvent__Group__14__Impl"
    // InternalStoryGen.g:3875:1: rule__ActionEvent__Group__14__Impl : ( ( rule__ActionEvent__ChangesAssignment_14 )* ) ;
    public final void rule__ActionEvent__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3879:1: ( ( ( rule__ActionEvent__ChangesAssignment_14 )* ) )
            // InternalStoryGen.g:3880:1: ( ( rule__ActionEvent__ChangesAssignment_14 )* )
            {
            // InternalStoryGen.g:3880:1: ( ( rule__ActionEvent__ChangesAssignment_14 )* )
            // InternalStoryGen.g:3881:2: ( rule__ActionEvent__ChangesAssignment_14 )*
            {
             before(grammarAccess.getActionEventAccess().getChangesAssignment_14()); 
            // InternalStoryGen.g:3882:2: ( rule__ActionEvent__ChangesAssignment_14 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==64) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalStoryGen.g:3882:3: rule__ActionEvent__ChangesAssignment_14
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__ActionEvent__ChangesAssignment_14();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getActionEventAccess().getChangesAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__14__Impl"


    // $ANTLR start "rule__ActionEvent__Group__15"
    // InternalStoryGen.g:3890:1: rule__ActionEvent__Group__15 : rule__ActionEvent__Group__15__Impl ;
    public final void rule__ActionEvent__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3894:1: ( rule__ActionEvent__Group__15__Impl )
            // InternalStoryGen.g:3895:2: rule__ActionEvent__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__15"


    // $ANTLR start "rule__ActionEvent__Group__15__Impl"
    // InternalStoryGen.g:3901:1: rule__ActionEvent__Group__15__Impl : ( '}' ) ;
    public final void rule__ActionEvent__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3905:1: ( ( '}' ) )
            // InternalStoryGen.g:3906:1: ( '}' )
            {
            // InternalStoryGen.g:3906:1: ( '}' )
            // InternalStoryGen.g:3907:2: '}'
            {
             before(grammarAccess.getActionEventAccess().getRightCurlyBracketKeyword_15()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getRightCurlyBracketKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group__15__Impl"


    // $ANTLR start "rule__ActionEvent__Group_3__0"
    // InternalStoryGen.g:3917:1: rule__ActionEvent__Group_3__0 : rule__ActionEvent__Group_3__0__Impl rule__ActionEvent__Group_3__1 ;
    public final void rule__ActionEvent__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3921:1: ( rule__ActionEvent__Group_3__0__Impl rule__ActionEvent__Group_3__1 )
            // InternalStoryGen.g:3922:2: rule__ActionEvent__Group_3__0__Impl rule__ActionEvent__Group_3__1
            {
            pushFollow(FOLLOW_33);
            rule__ActionEvent__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_3__0"


    // $ANTLR start "rule__ActionEvent__Group_3__0__Impl"
    // InternalStoryGen.g:3929:1: rule__ActionEvent__Group_3__0__Impl : ( 'priority:' ) ;
    public final void rule__ActionEvent__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3933:1: ( ( 'priority:' ) )
            // InternalStoryGen.g:3934:1: ( 'priority:' )
            {
            // InternalStoryGen.g:3934:1: ( 'priority:' )
            // InternalStoryGen.g:3935:2: 'priority:'
            {
             before(grammarAccess.getActionEventAccess().getPriorityKeyword_3_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getPriorityKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_3__0__Impl"


    // $ANTLR start "rule__ActionEvent__Group_3__1"
    // InternalStoryGen.g:3944:1: rule__ActionEvent__Group_3__1 : rule__ActionEvent__Group_3__1__Impl ;
    public final void rule__ActionEvent__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3948:1: ( rule__ActionEvent__Group_3__1__Impl )
            // InternalStoryGen.g:3949:2: rule__ActionEvent__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_3__1"


    // $ANTLR start "rule__ActionEvent__Group_3__1__Impl"
    // InternalStoryGen.g:3955:1: rule__ActionEvent__Group_3__1__Impl : ( ( rule__ActionEvent__PriorityAssignment_3_1 ) ) ;
    public final void rule__ActionEvent__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3959:1: ( ( ( rule__ActionEvent__PriorityAssignment_3_1 ) ) )
            // InternalStoryGen.g:3960:1: ( ( rule__ActionEvent__PriorityAssignment_3_1 ) )
            {
            // InternalStoryGen.g:3960:1: ( ( rule__ActionEvent__PriorityAssignment_3_1 ) )
            // InternalStoryGen.g:3961:2: ( rule__ActionEvent__PriorityAssignment_3_1 )
            {
             before(grammarAccess.getActionEventAccess().getPriorityAssignment_3_1()); 
            // InternalStoryGen.g:3962:2: ( rule__ActionEvent__PriorityAssignment_3_1 )
            // InternalStoryGen.g:3962:3: rule__ActionEvent__PriorityAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__PriorityAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getPriorityAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_3__1__Impl"


    // $ANTLR start "rule__ActionEvent__Group_8__0"
    // InternalStoryGen.g:3971:1: rule__ActionEvent__Group_8__0 : rule__ActionEvent__Group_8__0__Impl rule__ActionEvent__Group_8__1 ;
    public final void rule__ActionEvent__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3975:1: ( rule__ActionEvent__Group_8__0__Impl rule__ActionEvent__Group_8__1 )
            // InternalStoryGen.g:3976:2: rule__ActionEvent__Group_8__0__Impl rule__ActionEvent__Group_8__1
            {
            pushFollow(FOLLOW_17);
            rule__ActionEvent__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_8__0"


    // $ANTLR start "rule__ActionEvent__Group_8__0__Impl"
    // InternalStoryGen.g:3983:1: rule__ActionEvent__Group_8__0__Impl : ( 'short-description:' ) ;
    public final void rule__ActionEvent__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:3987:1: ( ( 'short-description:' ) )
            // InternalStoryGen.g:3988:1: ( 'short-description:' )
            {
            // InternalStoryGen.g:3988:1: ( 'short-description:' )
            // InternalStoryGen.g:3989:2: 'short-description:'
            {
             before(grammarAccess.getActionEventAccess().getShortDescriptionKeyword_8_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getShortDescriptionKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_8__0__Impl"


    // $ANTLR start "rule__ActionEvent__Group_8__1"
    // InternalStoryGen.g:3998:1: rule__ActionEvent__Group_8__1 : rule__ActionEvent__Group_8__1__Impl ;
    public final void rule__ActionEvent__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4002:1: ( rule__ActionEvent__Group_8__1__Impl )
            // InternalStoryGen.g:4003:2: rule__ActionEvent__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_8__1"


    // $ANTLR start "rule__ActionEvent__Group_8__1__Impl"
    // InternalStoryGen.g:4009:1: rule__ActionEvent__Group_8__1__Impl : ( ( rule__ActionEvent__ShortDescriptionAssignment_8_1 ) ) ;
    public final void rule__ActionEvent__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4013:1: ( ( ( rule__ActionEvent__ShortDescriptionAssignment_8_1 ) ) )
            // InternalStoryGen.g:4014:1: ( ( rule__ActionEvent__ShortDescriptionAssignment_8_1 ) )
            {
            // InternalStoryGen.g:4014:1: ( ( rule__ActionEvent__ShortDescriptionAssignment_8_1 ) )
            // InternalStoryGen.g:4015:2: ( rule__ActionEvent__ShortDescriptionAssignment_8_1 )
            {
             before(grammarAccess.getActionEventAccess().getShortDescriptionAssignment_8_1()); 
            // InternalStoryGen.g:4016:2: ( rule__ActionEvent__ShortDescriptionAssignment_8_1 )
            // InternalStoryGen.g:4016:3: rule__ActionEvent__ShortDescriptionAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__ShortDescriptionAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getShortDescriptionAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_8__1__Impl"


    // $ANTLR start "rule__ActionEvent__Group_11__0"
    // InternalStoryGen.g:4025:1: rule__ActionEvent__Group_11__0 : rule__ActionEvent__Group_11__0__Impl rule__ActionEvent__Group_11__1 ;
    public final void rule__ActionEvent__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4029:1: ( rule__ActionEvent__Group_11__0__Impl rule__ActionEvent__Group_11__1 )
            // InternalStoryGen.g:4030:2: rule__ActionEvent__Group_11__0__Impl rule__ActionEvent__Group_11__1
            {
            pushFollow(FOLLOW_15);
            rule__ActionEvent__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_11__0"


    // $ANTLR start "rule__ActionEvent__Group_11__0__Impl"
    // InternalStoryGen.g:4037:1: rule__ActionEvent__Group_11__0__Impl : ( 'triggers:' ) ;
    public final void rule__ActionEvent__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4041:1: ( ( 'triggers:' ) )
            // InternalStoryGen.g:4042:1: ( 'triggers:' )
            {
            // InternalStoryGen.g:4042:1: ( 'triggers:' )
            // InternalStoryGen.g:4043:2: 'triggers:'
            {
             before(grammarAccess.getActionEventAccess().getTriggersKeyword_11_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getTriggersKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_11__0__Impl"


    // $ANTLR start "rule__ActionEvent__Group_11__1"
    // InternalStoryGen.g:4052:1: rule__ActionEvent__Group_11__1 : rule__ActionEvent__Group_11__1__Impl ;
    public final void rule__ActionEvent__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4056:1: ( rule__ActionEvent__Group_11__1__Impl )
            // InternalStoryGen.g:4057:2: rule__ActionEvent__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_11__1"


    // $ANTLR start "rule__ActionEvent__Group_11__1__Impl"
    // InternalStoryGen.g:4063:1: rule__ActionEvent__Group_11__1__Impl : ( ( rule__ActionEvent__TriggerAssignment_11_1 ) ) ;
    public final void rule__ActionEvent__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4067:1: ( ( ( rule__ActionEvent__TriggerAssignment_11_1 ) ) )
            // InternalStoryGen.g:4068:1: ( ( rule__ActionEvent__TriggerAssignment_11_1 ) )
            {
            // InternalStoryGen.g:4068:1: ( ( rule__ActionEvent__TriggerAssignment_11_1 ) )
            // InternalStoryGen.g:4069:2: ( rule__ActionEvent__TriggerAssignment_11_1 )
            {
             before(grammarAccess.getActionEventAccess().getTriggerAssignment_11_1()); 
            // InternalStoryGen.g:4070:2: ( rule__ActionEvent__TriggerAssignment_11_1 )
            // InternalStoryGen.g:4070:3: rule__ActionEvent__TriggerAssignment_11_1
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__TriggerAssignment_11_1();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getTriggerAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_11__1__Impl"


    // $ANTLR start "rule__ActionEvent__Group_12__0"
    // InternalStoryGen.g:4079:1: rule__ActionEvent__Group_12__0 : rule__ActionEvent__Group_12__0__Impl rule__ActionEvent__Group_12__1 ;
    public final void rule__ActionEvent__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4083:1: ( rule__ActionEvent__Group_12__0__Impl rule__ActionEvent__Group_12__1 )
            // InternalStoryGen.g:4084:2: rule__ActionEvent__Group_12__0__Impl rule__ActionEvent__Group_12__1
            {
            pushFollow(FOLLOW_15);
            rule__ActionEvent__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_12__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12__0"


    // $ANTLR start "rule__ActionEvent__Group_12__0__Impl"
    // InternalStoryGen.g:4091:1: rule__ActionEvent__Group_12__0__Impl : ( 'may-trigger:' ) ;
    public final void rule__ActionEvent__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4095:1: ( ( 'may-trigger:' ) )
            // InternalStoryGen.g:4096:1: ( 'may-trigger:' )
            {
            // InternalStoryGen.g:4096:1: ( 'may-trigger:' )
            // InternalStoryGen.g:4097:2: 'may-trigger:'
            {
             before(grammarAccess.getActionEventAccess().getMayTriggerKeyword_12_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getMayTriggerKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12__0__Impl"


    // $ANTLR start "rule__ActionEvent__Group_12__1"
    // InternalStoryGen.g:4106:1: rule__ActionEvent__Group_12__1 : rule__ActionEvent__Group_12__1__Impl rule__ActionEvent__Group_12__2 ;
    public final void rule__ActionEvent__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4110:1: ( rule__ActionEvent__Group_12__1__Impl rule__ActionEvent__Group_12__2 )
            // InternalStoryGen.g:4111:2: rule__ActionEvent__Group_12__1__Impl rule__ActionEvent__Group_12__2
            {
            pushFollow(FOLLOW_15);
            rule__ActionEvent__Group_12__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_12__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12__1"


    // $ANTLR start "rule__ActionEvent__Group_12__1__Impl"
    // InternalStoryGen.g:4118:1: rule__ActionEvent__Group_12__1__Impl : ( ( rule__ActionEvent__Group_12_1__0 )* ) ;
    public final void rule__ActionEvent__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4122:1: ( ( ( rule__ActionEvent__Group_12_1__0 )* ) )
            // InternalStoryGen.g:4123:1: ( ( rule__ActionEvent__Group_12_1__0 )* )
            {
            // InternalStoryGen.g:4123:1: ( ( rule__ActionEvent__Group_12_1__0 )* )
            // InternalStoryGen.g:4124:2: ( rule__ActionEvent__Group_12_1__0 )*
            {
             before(grammarAccess.getActionEventAccess().getGroup_12_1()); 
            // InternalStoryGen.g:4125:2: ( rule__ActionEvent__Group_12_1__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID) ) {
                    int LA43_1 = input.LA(2);

                    if ( (LA43_1==59) ) {
                        alt43=1;
                    }


                }


                switch (alt43) {
            	case 1 :
            	    // InternalStoryGen.g:4125:3: rule__ActionEvent__Group_12_1__0
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__ActionEvent__Group_12_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getActionEventAccess().getGroup_12_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12__1__Impl"


    // $ANTLR start "rule__ActionEvent__Group_12__2"
    // InternalStoryGen.g:4133:1: rule__ActionEvent__Group_12__2 : rule__ActionEvent__Group_12__2__Impl ;
    public final void rule__ActionEvent__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4137:1: ( rule__ActionEvent__Group_12__2__Impl )
            // InternalStoryGen.g:4138:2: rule__ActionEvent__Group_12__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_12__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12__2"


    // $ANTLR start "rule__ActionEvent__Group_12__2__Impl"
    // InternalStoryGen.g:4144:1: rule__ActionEvent__Group_12__2__Impl : ( ( rule__ActionEvent__MayTriggersAssignment_12_2 ) ) ;
    public final void rule__ActionEvent__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4148:1: ( ( ( rule__ActionEvent__MayTriggersAssignment_12_2 ) ) )
            // InternalStoryGen.g:4149:1: ( ( rule__ActionEvent__MayTriggersAssignment_12_2 ) )
            {
            // InternalStoryGen.g:4149:1: ( ( rule__ActionEvent__MayTriggersAssignment_12_2 ) )
            // InternalStoryGen.g:4150:2: ( rule__ActionEvent__MayTriggersAssignment_12_2 )
            {
             before(grammarAccess.getActionEventAccess().getMayTriggersAssignment_12_2()); 
            // InternalStoryGen.g:4151:2: ( rule__ActionEvent__MayTriggersAssignment_12_2 )
            // InternalStoryGen.g:4151:3: rule__ActionEvent__MayTriggersAssignment_12_2
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__MayTriggersAssignment_12_2();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getMayTriggersAssignment_12_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12__2__Impl"


    // $ANTLR start "rule__ActionEvent__Group_12_1__0"
    // InternalStoryGen.g:4160:1: rule__ActionEvent__Group_12_1__0 : rule__ActionEvent__Group_12_1__0__Impl rule__ActionEvent__Group_12_1__1 ;
    public final void rule__ActionEvent__Group_12_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4164:1: ( rule__ActionEvent__Group_12_1__0__Impl rule__ActionEvent__Group_12_1__1 )
            // InternalStoryGen.g:4165:2: rule__ActionEvent__Group_12_1__0__Impl rule__ActionEvent__Group_12_1__1
            {
            pushFollow(FOLLOW_35);
            rule__ActionEvent__Group_12_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_12_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12_1__0"


    // $ANTLR start "rule__ActionEvent__Group_12_1__0__Impl"
    // InternalStoryGen.g:4172:1: rule__ActionEvent__Group_12_1__0__Impl : ( ( rule__ActionEvent__MayTriggersAssignment_12_1_0 ) ) ;
    public final void rule__ActionEvent__Group_12_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4176:1: ( ( ( rule__ActionEvent__MayTriggersAssignment_12_1_0 ) ) )
            // InternalStoryGen.g:4177:1: ( ( rule__ActionEvent__MayTriggersAssignment_12_1_0 ) )
            {
            // InternalStoryGen.g:4177:1: ( ( rule__ActionEvent__MayTriggersAssignment_12_1_0 ) )
            // InternalStoryGen.g:4178:2: ( rule__ActionEvent__MayTriggersAssignment_12_1_0 )
            {
             before(grammarAccess.getActionEventAccess().getMayTriggersAssignment_12_1_0()); 
            // InternalStoryGen.g:4179:2: ( rule__ActionEvent__MayTriggersAssignment_12_1_0 )
            // InternalStoryGen.g:4179:3: rule__ActionEvent__MayTriggersAssignment_12_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__MayTriggersAssignment_12_1_0();

            state._fsp--;


            }

             after(grammarAccess.getActionEventAccess().getMayTriggersAssignment_12_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12_1__0__Impl"


    // $ANTLR start "rule__ActionEvent__Group_12_1__1"
    // InternalStoryGen.g:4187:1: rule__ActionEvent__Group_12_1__1 : rule__ActionEvent__Group_12_1__1__Impl ;
    public final void rule__ActionEvent__Group_12_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4191:1: ( rule__ActionEvent__Group_12_1__1__Impl )
            // InternalStoryGen.g:4192:2: rule__ActionEvent__Group_12_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ActionEvent__Group_12_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12_1__1"


    // $ANTLR start "rule__ActionEvent__Group_12_1__1__Impl"
    // InternalStoryGen.g:4198:1: rule__ActionEvent__Group_12_1__1__Impl : ( ',' ) ;
    public final void rule__ActionEvent__Group_12_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4202:1: ( ( ',' ) )
            // InternalStoryGen.g:4203:1: ( ',' )
            {
            // InternalStoryGen.g:4203:1: ( ',' )
            // InternalStoryGen.g:4204:2: ','
            {
             before(grammarAccess.getActionEventAccess().getCommaKeyword_12_1_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getCommaKeyword_12_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__Group_12_1__1__Impl"


    // $ANTLR start "rule__ExpressionCondition__Group__0"
    // InternalStoryGen.g:4214:1: rule__ExpressionCondition__Group__0 : rule__ExpressionCondition__Group__0__Impl rule__ExpressionCondition__Group__1 ;
    public final void rule__ExpressionCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4218:1: ( rule__ExpressionCondition__Group__0__Impl rule__ExpressionCondition__Group__1 )
            // InternalStoryGen.g:4219:2: rule__ExpressionCondition__Group__0__Impl rule__ExpressionCondition__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__ExpressionCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExpressionCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionCondition__Group__0"


    // $ANTLR start "rule__ExpressionCondition__Group__0__Impl"
    // InternalStoryGen.g:4226:1: rule__ExpressionCondition__Group__0__Impl : ( 'require:' ) ;
    public final void rule__ExpressionCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4230:1: ( ( 'require:' ) )
            // InternalStoryGen.g:4231:1: ( 'require:' )
            {
            // InternalStoryGen.g:4231:1: ( 'require:' )
            // InternalStoryGen.g:4232:2: 'require:'
            {
             before(grammarAccess.getExpressionConditionAccess().getRequireKeyword_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getExpressionConditionAccess().getRequireKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionCondition__Group__0__Impl"


    // $ANTLR start "rule__ExpressionCondition__Group__1"
    // InternalStoryGen.g:4241:1: rule__ExpressionCondition__Group__1 : rule__ExpressionCondition__Group__1__Impl ;
    public final void rule__ExpressionCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4245:1: ( rule__ExpressionCondition__Group__1__Impl )
            // InternalStoryGen.g:4246:2: rule__ExpressionCondition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionCondition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionCondition__Group__1"


    // $ANTLR start "rule__ExpressionCondition__Group__1__Impl"
    // InternalStoryGen.g:4252:1: rule__ExpressionCondition__Group__1__Impl : ( ( rule__ExpressionCondition__ExpAssignment_1 ) ) ;
    public final void rule__ExpressionCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4256:1: ( ( ( rule__ExpressionCondition__ExpAssignment_1 ) ) )
            // InternalStoryGen.g:4257:1: ( ( rule__ExpressionCondition__ExpAssignment_1 ) )
            {
            // InternalStoryGen.g:4257:1: ( ( rule__ExpressionCondition__ExpAssignment_1 ) )
            // InternalStoryGen.g:4258:2: ( rule__ExpressionCondition__ExpAssignment_1 )
            {
             before(grammarAccess.getExpressionConditionAccess().getExpAssignment_1()); 
            // InternalStoryGen.g:4259:2: ( rule__ExpressionCondition__ExpAssignment_1 )
            // InternalStoryGen.g:4259:3: rule__ExpressionCondition__ExpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionCondition__ExpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionConditionAccess().getExpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionCondition__Group__1__Impl"


    // $ANTLR start "rule__OrderCondition__Group__0"
    // InternalStoryGen.g:4268:1: rule__OrderCondition__Group__0 : rule__OrderCondition__Group__0__Impl rule__OrderCondition__Group__1 ;
    public final void rule__OrderCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4272:1: ( rule__OrderCondition__Group__0__Impl rule__OrderCondition__Group__1 )
            // InternalStoryGen.g:4273:2: rule__OrderCondition__Group__0__Impl rule__OrderCondition__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__OrderCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrderCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderCondition__Group__0"


    // $ANTLR start "rule__OrderCondition__Group__0__Impl"
    // InternalStoryGen.g:4280:1: rule__OrderCondition__Group__0__Impl : ( 'require:' ) ;
    public final void rule__OrderCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4284:1: ( ( 'require:' ) )
            // InternalStoryGen.g:4285:1: ( 'require:' )
            {
            // InternalStoryGen.g:4285:1: ( 'require:' )
            // InternalStoryGen.g:4286:2: 'require:'
            {
             before(grammarAccess.getOrderConditionAccess().getRequireKeyword_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getOrderConditionAccess().getRequireKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderCondition__Group__0__Impl"


    // $ANTLR start "rule__OrderCondition__Group__1"
    // InternalStoryGen.g:4295:1: rule__OrderCondition__Group__1 : rule__OrderCondition__Group__1__Impl rule__OrderCondition__Group__2 ;
    public final void rule__OrderCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4299:1: ( rule__OrderCondition__Group__1__Impl rule__OrderCondition__Group__2 )
            // InternalStoryGen.g:4300:2: rule__OrderCondition__Group__1__Impl rule__OrderCondition__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__OrderCondition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrderCondition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderCondition__Group__1"


    // $ANTLR start "rule__OrderCondition__Group__1__Impl"
    // InternalStoryGen.g:4307:1: rule__OrderCondition__Group__1__Impl : ( ( rule__OrderCondition__OrderAssignment_1 ) ) ;
    public final void rule__OrderCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4311:1: ( ( ( rule__OrderCondition__OrderAssignment_1 ) ) )
            // InternalStoryGen.g:4312:1: ( ( rule__OrderCondition__OrderAssignment_1 ) )
            {
            // InternalStoryGen.g:4312:1: ( ( rule__OrderCondition__OrderAssignment_1 ) )
            // InternalStoryGen.g:4313:2: ( rule__OrderCondition__OrderAssignment_1 )
            {
             before(grammarAccess.getOrderConditionAccess().getOrderAssignment_1()); 
            // InternalStoryGen.g:4314:2: ( rule__OrderCondition__OrderAssignment_1 )
            // InternalStoryGen.g:4314:3: rule__OrderCondition__OrderAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__OrderCondition__OrderAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOrderConditionAccess().getOrderAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderCondition__Group__1__Impl"


    // $ANTLR start "rule__OrderCondition__Group__2"
    // InternalStoryGen.g:4322:1: rule__OrderCondition__Group__2 : rule__OrderCondition__Group__2__Impl ;
    public final void rule__OrderCondition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4326:1: ( rule__OrderCondition__Group__2__Impl )
            // InternalStoryGen.g:4327:2: rule__OrderCondition__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrderCondition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderCondition__Group__2"


    // $ANTLR start "rule__OrderCondition__Group__2__Impl"
    // InternalStoryGen.g:4333:1: rule__OrderCondition__Group__2__Impl : ( ( rule__OrderCondition__EventAssignment_2 ) ) ;
    public final void rule__OrderCondition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4337:1: ( ( ( rule__OrderCondition__EventAssignment_2 ) ) )
            // InternalStoryGen.g:4338:1: ( ( rule__OrderCondition__EventAssignment_2 ) )
            {
            // InternalStoryGen.g:4338:1: ( ( rule__OrderCondition__EventAssignment_2 ) )
            // InternalStoryGen.g:4339:2: ( rule__OrderCondition__EventAssignment_2 )
            {
             before(grammarAccess.getOrderConditionAccess().getEventAssignment_2()); 
            // InternalStoryGen.g:4340:2: ( rule__OrderCondition__EventAssignment_2 )
            // InternalStoryGen.g:4340:3: rule__OrderCondition__EventAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__OrderCondition__EventAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOrderConditionAccess().getEventAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderCondition__Group__2__Impl"


    // $ANTLR start "rule__TriggerCondition__Group__0"
    // InternalStoryGen.g:4349:1: rule__TriggerCondition__Group__0 : rule__TriggerCondition__Group__0__Impl rule__TriggerCondition__Group__1 ;
    public final void rule__TriggerCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4353:1: ( rule__TriggerCondition__Group__0__Impl rule__TriggerCondition__Group__1 )
            // InternalStoryGen.g:4354:2: rule__TriggerCondition__Group__0__Impl rule__TriggerCondition__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__TriggerCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TriggerCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TriggerCondition__Group__0"


    // $ANTLR start "rule__TriggerCondition__Group__0__Impl"
    // InternalStoryGen.g:4361:1: rule__TriggerCondition__Group__0__Impl : ( 'require:' ) ;
    public final void rule__TriggerCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4365:1: ( ( 'require:' ) )
            // InternalStoryGen.g:4366:1: ( 'require:' )
            {
            // InternalStoryGen.g:4366:1: ( 'require:' )
            // InternalStoryGen.g:4367:2: 'require:'
            {
             before(grammarAccess.getTriggerConditionAccess().getRequireKeyword_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getTriggerConditionAccess().getRequireKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TriggerCondition__Group__0__Impl"


    // $ANTLR start "rule__TriggerCondition__Group__1"
    // InternalStoryGen.g:4376:1: rule__TriggerCondition__Group__1 : rule__TriggerCondition__Group__1__Impl ;
    public final void rule__TriggerCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4380:1: ( rule__TriggerCondition__Group__1__Impl )
            // InternalStoryGen.g:4381:2: rule__TriggerCondition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TriggerCondition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TriggerCondition__Group__1"


    // $ANTLR start "rule__TriggerCondition__Group__1__Impl"
    // InternalStoryGen.g:4387:1: rule__TriggerCondition__Group__1__Impl : ( ( rule__TriggerCondition__TriggerAssignment_1 ) ) ;
    public final void rule__TriggerCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4391:1: ( ( ( rule__TriggerCondition__TriggerAssignment_1 ) ) )
            // InternalStoryGen.g:4392:1: ( ( rule__TriggerCondition__TriggerAssignment_1 ) )
            {
            // InternalStoryGen.g:4392:1: ( ( rule__TriggerCondition__TriggerAssignment_1 ) )
            // InternalStoryGen.g:4393:2: ( rule__TriggerCondition__TriggerAssignment_1 )
            {
             before(grammarAccess.getTriggerConditionAccess().getTriggerAssignment_1()); 
            // InternalStoryGen.g:4394:2: ( rule__TriggerCondition__TriggerAssignment_1 )
            // InternalStoryGen.g:4394:3: rule__TriggerCondition__TriggerAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TriggerCondition__TriggerAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTriggerConditionAccess().getTriggerAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TriggerCondition__Group__1__Impl"


    // $ANTLR start "rule__ExistentChange__Group__0"
    // InternalStoryGen.g:4403:1: rule__ExistentChange__Group__0 : rule__ExistentChange__Group__0__Impl rule__ExistentChange__Group__1 ;
    public final void rule__ExistentChange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4407:1: ( rule__ExistentChange__Group__0__Impl rule__ExistentChange__Group__1 )
            // InternalStoryGen.g:4408:2: rule__ExistentChange__Group__0__Impl rule__ExistentChange__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__ExistentChange__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExistentChange__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__0"


    // $ANTLR start "rule__ExistentChange__Group__0__Impl"
    // InternalStoryGen.g:4415:1: rule__ExistentChange__Group__0__Impl : ( 'change:' ) ;
    public final void rule__ExistentChange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4419:1: ( ( 'change:' ) )
            // InternalStoryGen.g:4420:1: ( 'change:' )
            {
            // InternalStoryGen.g:4420:1: ( 'change:' )
            // InternalStoryGen.g:4421:2: 'change:'
            {
             before(grammarAccess.getExistentChangeAccess().getChangeKeyword_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getExistentChangeAccess().getChangeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__0__Impl"


    // $ANTLR start "rule__ExistentChange__Group__1"
    // InternalStoryGen.g:4430:1: rule__ExistentChange__Group__1 : rule__ExistentChange__Group__1__Impl rule__ExistentChange__Group__2 ;
    public final void rule__ExistentChange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4434:1: ( rule__ExistentChange__Group__1__Impl rule__ExistentChange__Group__2 )
            // InternalStoryGen.g:4435:2: rule__ExistentChange__Group__1__Impl rule__ExistentChange__Group__2
            {
            pushFollow(FOLLOW_43);
            rule__ExistentChange__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExistentChange__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__1"


    // $ANTLR start "rule__ExistentChange__Group__1__Impl"
    // InternalStoryGen.g:4442:1: rule__ExistentChange__Group__1__Impl : ( ( rule__ExistentChange__ExistentAssignment_1 ) ) ;
    public final void rule__ExistentChange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4446:1: ( ( ( rule__ExistentChange__ExistentAssignment_1 ) ) )
            // InternalStoryGen.g:4447:1: ( ( rule__ExistentChange__ExistentAssignment_1 ) )
            {
            // InternalStoryGen.g:4447:1: ( ( rule__ExistentChange__ExistentAssignment_1 ) )
            // InternalStoryGen.g:4448:2: ( rule__ExistentChange__ExistentAssignment_1 )
            {
             before(grammarAccess.getExistentChangeAccess().getExistentAssignment_1()); 
            // InternalStoryGen.g:4449:2: ( rule__ExistentChange__ExistentAssignment_1 )
            // InternalStoryGen.g:4449:3: rule__ExistentChange__ExistentAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ExistentChange__ExistentAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExistentChangeAccess().getExistentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__1__Impl"


    // $ANTLR start "rule__ExistentChange__Group__2"
    // InternalStoryGen.g:4457:1: rule__ExistentChange__Group__2 : rule__ExistentChange__Group__2__Impl rule__ExistentChange__Group__3 ;
    public final void rule__ExistentChange__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4461:1: ( rule__ExistentChange__Group__2__Impl rule__ExistentChange__Group__3 )
            // InternalStoryGen.g:4462:2: rule__ExistentChange__Group__2__Impl rule__ExistentChange__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__ExistentChange__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExistentChange__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__2"


    // $ANTLR start "rule__ExistentChange__Group__2__Impl"
    // InternalStoryGen.g:4469:1: rule__ExistentChange__Group__2__Impl : ( '.' ) ;
    public final void rule__ExistentChange__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4473:1: ( ( '.' ) )
            // InternalStoryGen.g:4474:1: ( '.' )
            {
            // InternalStoryGen.g:4474:1: ( '.' )
            // InternalStoryGen.g:4475:2: '.'
            {
             before(grammarAccess.getExistentChangeAccess().getFullStopKeyword_2()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getExistentChangeAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__2__Impl"


    // $ANTLR start "rule__ExistentChange__Group__3"
    // InternalStoryGen.g:4484:1: rule__ExistentChange__Group__3 : rule__ExistentChange__Group__3__Impl rule__ExistentChange__Group__4 ;
    public final void rule__ExistentChange__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4488:1: ( rule__ExistentChange__Group__3__Impl rule__ExistentChange__Group__4 )
            // InternalStoryGen.g:4489:2: rule__ExistentChange__Group__3__Impl rule__ExistentChange__Group__4
            {
            pushFollow(FOLLOW_44);
            rule__ExistentChange__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExistentChange__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__3"


    // $ANTLR start "rule__ExistentChange__Group__3__Impl"
    // InternalStoryGen.g:4496:1: rule__ExistentChange__Group__3__Impl : ( ( rule__ExistentChange__AttributeAssignment_3 ) ) ;
    public final void rule__ExistentChange__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4500:1: ( ( ( rule__ExistentChange__AttributeAssignment_3 ) ) )
            // InternalStoryGen.g:4501:1: ( ( rule__ExistentChange__AttributeAssignment_3 ) )
            {
            // InternalStoryGen.g:4501:1: ( ( rule__ExistentChange__AttributeAssignment_3 ) )
            // InternalStoryGen.g:4502:2: ( rule__ExistentChange__AttributeAssignment_3 )
            {
             before(grammarAccess.getExistentChangeAccess().getAttributeAssignment_3()); 
            // InternalStoryGen.g:4503:2: ( rule__ExistentChange__AttributeAssignment_3 )
            // InternalStoryGen.g:4503:3: rule__ExistentChange__AttributeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ExistentChange__AttributeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getExistentChangeAccess().getAttributeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__3__Impl"


    // $ANTLR start "rule__ExistentChange__Group__4"
    // InternalStoryGen.g:4511:1: rule__ExistentChange__Group__4 : rule__ExistentChange__Group__4__Impl rule__ExistentChange__Group__5 ;
    public final void rule__ExistentChange__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4515:1: ( rule__ExistentChange__Group__4__Impl rule__ExistentChange__Group__5 )
            // InternalStoryGen.g:4516:2: rule__ExistentChange__Group__4__Impl rule__ExistentChange__Group__5
            {
            pushFollow(FOLLOW_45);
            rule__ExistentChange__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExistentChange__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__4"


    // $ANTLR start "rule__ExistentChange__Group__4__Impl"
    // InternalStoryGen.g:4523:1: rule__ExistentChange__Group__4__Impl : ( ( rule__ExistentChange__OpAssignment_4 ) ) ;
    public final void rule__ExistentChange__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4527:1: ( ( ( rule__ExistentChange__OpAssignment_4 ) ) )
            // InternalStoryGen.g:4528:1: ( ( rule__ExistentChange__OpAssignment_4 ) )
            {
            // InternalStoryGen.g:4528:1: ( ( rule__ExistentChange__OpAssignment_4 ) )
            // InternalStoryGen.g:4529:2: ( rule__ExistentChange__OpAssignment_4 )
            {
             before(grammarAccess.getExistentChangeAccess().getOpAssignment_4()); 
            // InternalStoryGen.g:4530:2: ( rule__ExistentChange__OpAssignment_4 )
            // InternalStoryGen.g:4530:3: rule__ExistentChange__OpAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ExistentChange__OpAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getExistentChangeAccess().getOpAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__4__Impl"


    // $ANTLR start "rule__ExistentChange__Group__5"
    // InternalStoryGen.g:4538:1: rule__ExistentChange__Group__5 : rule__ExistentChange__Group__5__Impl ;
    public final void rule__ExistentChange__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4542:1: ( rule__ExistentChange__Group__5__Impl )
            // InternalStoryGen.g:4543:2: rule__ExistentChange__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExistentChange__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__5"


    // $ANTLR start "rule__ExistentChange__Group__5__Impl"
    // InternalStoryGen.g:4549:1: rule__ExistentChange__Group__5__Impl : ( ( rule__ExistentChange__TermAssignment_5 ) ) ;
    public final void rule__ExistentChange__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4553:1: ( ( ( rule__ExistentChange__TermAssignment_5 ) ) )
            // InternalStoryGen.g:4554:1: ( ( rule__ExistentChange__TermAssignment_5 ) )
            {
            // InternalStoryGen.g:4554:1: ( ( rule__ExistentChange__TermAssignment_5 ) )
            // InternalStoryGen.g:4555:2: ( rule__ExistentChange__TermAssignment_5 )
            {
             before(grammarAccess.getExistentChangeAccess().getTermAssignment_5()); 
            // InternalStoryGen.g:4556:2: ( rule__ExistentChange__TermAssignment_5 )
            // InternalStoryGen.g:4556:3: rule__ExistentChange__TermAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__ExistentChange__TermAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getExistentChangeAccess().getTermAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__Group__5__Impl"


    // $ANTLR start "rule__StoryDataChange__Group__0"
    // InternalStoryGen.g:4565:1: rule__StoryDataChange__Group__0 : rule__StoryDataChange__Group__0__Impl rule__StoryDataChange__Group__1 ;
    public final void rule__StoryDataChange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4569:1: ( rule__StoryDataChange__Group__0__Impl rule__StoryDataChange__Group__1 )
            // InternalStoryGen.g:4570:2: rule__StoryDataChange__Group__0__Impl rule__StoryDataChange__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__StoryDataChange__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryDataChange__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__0"


    // $ANTLR start "rule__StoryDataChange__Group__0__Impl"
    // InternalStoryGen.g:4577:1: rule__StoryDataChange__Group__0__Impl : ( 'change:' ) ;
    public final void rule__StoryDataChange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4581:1: ( ( 'change:' ) )
            // InternalStoryGen.g:4582:1: ( 'change:' )
            {
            // InternalStoryGen.g:4582:1: ( 'change:' )
            // InternalStoryGen.g:4583:2: 'change:'
            {
             before(grammarAccess.getStoryDataChangeAccess().getChangeKeyword_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getStoryDataChangeAccess().getChangeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__0__Impl"


    // $ANTLR start "rule__StoryDataChange__Group__1"
    // InternalStoryGen.g:4592:1: rule__StoryDataChange__Group__1 : rule__StoryDataChange__Group__1__Impl rule__StoryDataChange__Group__2 ;
    public final void rule__StoryDataChange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4596:1: ( rule__StoryDataChange__Group__1__Impl rule__StoryDataChange__Group__2 )
            // InternalStoryGen.g:4597:2: rule__StoryDataChange__Group__1__Impl rule__StoryDataChange__Group__2
            {
            pushFollow(FOLLOW_43);
            rule__StoryDataChange__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryDataChange__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__1"


    // $ANTLR start "rule__StoryDataChange__Group__1__Impl"
    // InternalStoryGen.g:4604:1: rule__StoryDataChange__Group__1__Impl : ( 'Story' ) ;
    public final void rule__StoryDataChange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4608:1: ( ( 'Story' ) )
            // InternalStoryGen.g:4609:1: ( 'Story' )
            {
            // InternalStoryGen.g:4609:1: ( 'Story' )
            // InternalStoryGen.g:4610:2: 'Story'
            {
             before(grammarAccess.getStoryDataChangeAccess().getStoryKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getStoryDataChangeAccess().getStoryKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__1__Impl"


    // $ANTLR start "rule__StoryDataChange__Group__2"
    // InternalStoryGen.g:4619:1: rule__StoryDataChange__Group__2 : rule__StoryDataChange__Group__2__Impl rule__StoryDataChange__Group__3 ;
    public final void rule__StoryDataChange__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4623:1: ( rule__StoryDataChange__Group__2__Impl rule__StoryDataChange__Group__3 )
            // InternalStoryGen.g:4624:2: rule__StoryDataChange__Group__2__Impl rule__StoryDataChange__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__StoryDataChange__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryDataChange__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__2"


    // $ANTLR start "rule__StoryDataChange__Group__2__Impl"
    // InternalStoryGen.g:4631:1: rule__StoryDataChange__Group__2__Impl : ( '.' ) ;
    public final void rule__StoryDataChange__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4635:1: ( ( '.' ) )
            // InternalStoryGen.g:4636:1: ( '.' )
            {
            // InternalStoryGen.g:4636:1: ( '.' )
            // InternalStoryGen.g:4637:2: '.'
            {
             before(grammarAccess.getStoryDataChangeAccess().getFullStopKeyword_2()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getStoryDataChangeAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__2__Impl"


    // $ANTLR start "rule__StoryDataChange__Group__3"
    // InternalStoryGen.g:4646:1: rule__StoryDataChange__Group__3 : rule__StoryDataChange__Group__3__Impl rule__StoryDataChange__Group__4 ;
    public final void rule__StoryDataChange__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4650:1: ( rule__StoryDataChange__Group__3__Impl rule__StoryDataChange__Group__4 )
            // InternalStoryGen.g:4651:2: rule__StoryDataChange__Group__3__Impl rule__StoryDataChange__Group__4
            {
            pushFollow(FOLLOW_44);
            rule__StoryDataChange__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryDataChange__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__3"


    // $ANTLR start "rule__StoryDataChange__Group__3__Impl"
    // InternalStoryGen.g:4658:1: rule__StoryDataChange__Group__3__Impl : ( ( rule__StoryDataChange__AttributeAssignment_3 ) ) ;
    public final void rule__StoryDataChange__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4662:1: ( ( ( rule__StoryDataChange__AttributeAssignment_3 ) ) )
            // InternalStoryGen.g:4663:1: ( ( rule__StoryDataChange__AttributeAssignment_3 ) )
            {
            // InternalStoryGen.g:4663:1: ( ( rule__StoryDataChange__AttributeAssignment_3 ) )
            // InternalStoryGen.g:4664:2: ( rule__StoryDataChange__AttributeAssignment_3 )
            {
             before(grammarAccess.getStoryDataChangeAccess().getAttributeAssignment_3()); 
            // InternalStoryGen.g:4665:2: ( rule__StoryDataChange__AttributeAssignment_3 )
            // InternalStoryGen.g:4665:3: rule__StoryDataChange__AttributeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__StoryDataChange__AttributeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getStoryDataChangeAccess().getAttributeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__3__Impl"


    // $ANTLR start "rule__StoryDataChange__Group__4"
    // InternalStoryGen.g:4673:1: rule__StoryDataChange__Group__4 : rule__StoryDataChange__Group__4__Impl rule__StoryDataChange__Group__5 ;
    public final void rule__StoryDataChange__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4677:1: ( rule__StoryDataChange__Group__4__Impl rule__StoryDataChange__Group__5 )
            // InternalStoryGen.g:4678:2: rule__StoryDataChange__Group__4__Impl rule__StoryDataChange__Group__5
            {
            pushFollow(FOLLOW_45);
            rule__StoryDataChange__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryDataChange__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__4"


    // $ANTLR start "rule__StoryDataChange__Group__4__Impl"
    // InternalStoryGen.g:4685:1: rule__StoryDataChange__Group__4__Impl : ( ( rule__StoryDataChange__OpAssignment_4 ) ) ;
    public final void rule__StoryDataChange__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4689:1: ( ( ( rule__StoryDataChange__OpAssignment_4 ) ) )
            // InternalStoryGen.g:4690:1: ( ( rule__StoryDataChange__OpAssignment_4 ) )
            {
            // InternalStoryGen.g:4690:1: ( ( rule__StoryDataChange__OpAssignment_4 ) )
            // InternalStoryGen.g:4691:2: ( rule__StoryDataChange__OpAssignment_4 )
            {
             before(grammarAccess.getStoryDataChangeAccess().getOpAssignment_4()); 
            // InternalStoryGen.g:4692:2: ( rule__StoryDataChange__OpAssignment_4 )
            // InternalStoryGen.g:4692:3: rule__StoryDataChange__OpAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__StoryDataChange__OpAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getStoryDataChangeAccess().getOpAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__4__Impl"


    // $ANTLR start "rule__StoryDataChange__Group__5"
    // InternalStoryGen.g:4700:1: rule__StoryDataChange__Group__5 : rule__StoryDataChange__Group__5__Impl ;
    public final void rule__StoryDataChange__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4704:1: ( rule__StoryDataChange__Group__5__Impl )
            // InternalStoryGen.g:4705:2: rule__StoryDataChange__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StoryDataChange__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__5"


    // $ANTLR start "rule__StoryDataChange__Group__5__Impl"
    // InternalStoryGen.g:4711:1: rule__StoryDataChange__Group__5__Impl : ( ( rule__StoryDataChange__TermAssignment_5 ) ) ;
    public final void rule__StoryDataChange__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4715:1: ( ( ( rule__StoryDataChange__TermAssignment_5 ) ) )
            // InternalStoryGen.g:4716:1: ( ( rule__StoryDataChange__TermAssignment_5 ) )
            {
            // InternalStoryGen.g:4716:1: ( ( rule__StoryDataChange__TermAssignment_5 ) )
            // InternalStoryGen.g:4717:2: ( rule__StoryDataChange__TermAssignment_5 )
            {
             before(grammarAccess.getStoryDataChangeAccess().getTermAssignment_5()); 
            // InternalStoryGen.g:4718:2: ( rule__StoryDataChange__TermAssignment_5 )
            // InternalStoryGen.g:4718:3: rule__StoryDataChange__TermAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__StoryDataChange__TermAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getStoryDataChangeAccess().getTermAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__Group__5__Impl"


    // $ANTLR start "rule__BinaryExpression__Group__0"
    // InternalStoryGen.g:4727:1: rule__BinaryExpression__Group__0 : rule__BinaryExpression__Group__0__Impl rule__BinaryExpression__Group__1 ;
    public final void rule__BinaryExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4731:1: ( rule__BinaryExpression__Group__0__Impl rule__BinaryExpression__Group__1 )
            // InternalStoryGen.g:4732:2: rule__BinaryExpression__Group__0__Impl rule__BinaryExpression__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__BinaryExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group__0"


    // $ANTLR start "rule__BinaryExpression__Group__0__Impl"
    // InternalStoryGen.g:4739:1: rule__BinaryExpression__Group__0__Impl : ( ruleUnitExpression ) ;
    public final void rule__BinaryExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4743:1: ( ( ruleUnitExpression ) )
            // InternalStoryGen.g:4744:1: ( ruleUnitExpression )
            {
            // InternalStoryGen.g:4744:1: ( ruleUnitExpression )
            // InternalStoryGen.g:4745:2: ruleUnitExpression
            {
             before(grammarAccess.getBinaryExpressionAccess().getUnitExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleUnitExpression();

            state._fsp--;

             after(grammarAccess.getBinaryExpressionAccess().getUnitExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group__0__Impl"


    // $ANTLR start "rule__BinaryExpression__Group__1"
    // InternalStoryGen.g:4754:1: rule__BinaryExpression__Group__1 : rule__BinaryExpression__Group__1__Impl ;
    public final void rule__BinaryExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4758:1: ( rule__BinaryExpression__Group__1__Impl )
            // InternalStoryGen.g:4759:2: rule__BinaryExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group__1"


    // $ANTLR start "rule__BinaryExpression__Group__1__Impl"
    // InternalStoryGen.g:4765:1: rule__BinaryExpression__Group__1__Impl : ( ( rule__BinaryExpression__Alternatives_1 )? ) ;
    public final void rule__BinaryExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4769:1: ( ( ( rule__BinaryExpression__Alternatives_1 )? ) )
            // InternalStoryGen.g:4770:1: ( ( rule__BinaryExpression__Alternatives_1 )? )
            {
            // InternalStoryGen.g:4770:1: ( ( rule__BinaryExpression__Alternatives_1 )? )
            // InternalStoryGen.g:4771:2: ( rule__BinaryExpression__Alternatives_1 )?
            {
             before(grammarAccess.getBinaryExpressionAccess().getAlternatives_1()); 
            // InternalStoryGen.g:4772:2: ( rule__BinaryExpression__Alternatives_1 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=19 && LA44_0<=24)||(LA44_0>=66 && LA44_0<=67)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalStoryGen.g:4772:3: rule__BinaryExpression__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__BinaryExpression__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBinaryExpressionAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group__1__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_0__0"
    // InternalStoryGen.g:4781:1: rule__BinaryExpression__Group_1_0__0 : rule__BinaryExpression__Group_1_0__0__Impl rule__BinaryExpression__Group_1_0__1 ;
    public final void rule__BinaryExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4785:1: ( rule__BinaryExpression__Group_1_0__0__Impl rule__BinaryExpression__Group_1_0__1 )
            // InternalStoryGen.g:4786:2: rule__BinaryExpression__Group_1_0__0__Impl rule__BinaryExpression__Group_1_0__1
            {
            pushFollow(FOLLOW_47);
            rule__BinaryExpression__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0__0"


    // $ANTLR start "rule__BinaryExpression__Group_1_0__0__Impl"
    // InternalStoryGen.g:4793:1: rule__BinaryExpression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__BinaryExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4797:1: ( ( () ) )
            // InternalStoryGen.g:4798:1: ( () )
            {
            // InternalStoryGen.g:4798:1: ( () )
            // InternalStoryGen.g:4799:2: ()
            {
             before(grammarAccess.getBinaryExpressionAccess().getOrExpressionOperandsAction_1_0_0()); 
            // InternalStoryGen.g:4800:2: ()
            // InternalStoryGen.g:4800:3: 
            {
            }

             after(grammarAccess.getBinaryExpressionAccess().getOrExpressionOperandsAction_1_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_0__1"
    // InternalStoryGen.g:4808:1: rule__BinaryExpression__Group_1_0__1 : rule__BinaryExpression__Group_1_0__1__Impl rule__BinaryExpression__Group_1_0__2 ;
    public final void rule__BinaryExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4812:1: ( rule__BinaryExpression__Group_1_0__1__Impl rule__BinaryExpression__Group_1_0__2 )
            // InternalStoryGen.g:4813:2: rule__BinaryExpression__Group_1_0__1__Impl rule__BinaryExpression__Group_1_0__2
            {
            pushFollow(FOLLOW_20);
            rule__BinaryExpression__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0__1"


    // $ANTLR start "rule__BinaryExpression__Group_1_0__1__Impl"
    // InternalStoryGen.g:4820:1: rule__BinaryExpression__Group_1_0__1__Impl : ( 'or' ) ;
    public final void rule__BinaryExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4824:1: ( ( 'or' ) )
            // InternalStoryGen.g:4825:1: ( 'or' )
            {
            // InternalStoryGen.g:4825:1: ( 'or' )
            // InternalStoryGen.g:4826:2: 'or'
            {
             before(grammarAccess.getBinaryExpressionAccess().getOrKeyword_1_0_1()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getBinaryExpressionAccess().getOrKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0__1__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_0__2"
    // InternalStoryGen.g:4835:1: rule__BinaryExpression__Group_1_0__2 : rule__BinaryExpression__Group_1_0__2__Impl rule__BinaryExpression__Group_1_0__3 ;
    public final void rule__BinaryExpression__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4839:1: ( rule__BinaryExpression__Group_1_0__2__Impl rule__BinaryExpression__Group_1_0__3 )
            // InternalStoryGen.g:4840:2: rule__BinaryExpression__Group_1_0__2__Impl rule__BinaryExpression__Group_1_0__3
            {
            pushFollow(FOLLOW_47);
            rule__BinaryExpression__Group_1_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0__2"


    // $ANTLR start "rule__BinaryExpression__Group_1_0__2__Impl"
    // InternalStoryGen.g:4847:1: rule__BinaryExpression__Group_1_0__2__Impl : ( ( rule__BinaryExpression__OperandsAssignment_1_0_2 ) ) ;
    public final void rule__BinaryExpression__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4851:1: ( ( ( rule__BinaryExpression__OperandsAssignment_1_0_2 ) ) )
            // InternalStoryGen.g:4852:1: ( ( rule__BinaryExpression__OperandsAssignment_1_0_2 ) )
            {
            // InternalStoryGen.g:4852:1: ( ( rule__BinaryExpression__OperandsAssignment_1_0_2 ) )
            // InternalStoryGen.g:4853:2: ( rule__BinaryExpression__OperandsAssignment_1_0_2 )
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperandsAssignment_1_0_2()); 
            // InternalStoryGen.g:4854:2: ( rule__BinaryExpression__OperandsAssignment_1_0_2 )
            // InternalStoryGen.g:4854:3: rule__BinaryExpression__OperandsAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__OperandsAssignment_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getBinaryExpressionAccess().getOperandsAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0__2__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_0__3"
    // InternalStoryGen.g:4862:1: rule__BinaryExpression__Group_1_0__3 : rule__BinaryExpression__Group_1_0__3__Impl ;
    public final void rule__BinaryExpression__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4866:1: ( rule__BinaryExpression__Group_1_0__3__Impl )
            // InternalStoryGen.g:4867:2: rule__BinaryExpression__Group_1_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0__3"


    // $ANTLR start "rule__BinaryExpression__Group_1_0__3__Impl"
    // InternalStoryGen.g:4873:1: rule__BinaryExpression__Group_1_0__3__Impl : ( ( rule__BinaryExpression__Group_1_0_3__0 )* ) ;
    public final void rule__BinaryExpression__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4877:1: ( ( ( rule__BinaryExpression__Group_1_0_3__0 )* ) )
            // InternalStoryGen.g:4878:1: ( ( rule__BinaryExpression__Group_1_0_3__0 )* )
            {
            // InternalStoryGen.g:4878:1: ( ( rule__BinaryExpression__Group_1_0_3__0 )* )
            // InternalStoryGen.g:4879:2: ( rule__BinaryExpression__Group_1_0_3__0 )*
            {
             before(grammarAccess.getBinaryExpressionAccess().getGroup_1_0_3()); 
            // InternalStoryGen.g:4880:2: ( rule__BinaryExpression__Group_1_0_3__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==66) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalStoryGen.g:4880:3: rule__BinaryExpression__Group_1_0_3__0
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__BinaryExpression__Group_1_0_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getBinaryExpressionAccess().getGroup_1_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0__3__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_0_3__0"
    // InternalStoryGen.g:4889:1: rule__BinaryExpression__Group_1_0_3__0 : rule__BinaryExpression__Group_1_0_3__0__Impl rule__BinaryExpression__Group_1_0_3__1 ;
    public final void rule__BinaryExpression__Group_1_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4893:1: ( rule__BinaryExpression__Group_1_0_3__0__Impl rule__BinaryExpression__Group_1_0_3__1 )
            // InternalStoryGen.g:4894:2: rule__BinaryExpression__Group_1_0_3__0__Impl rule__BinaryExpression__Group_1_0_3__1
            {
            pushFollow(FOLLOW_20);
            rule__BinaryExpression__Group_1_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_0_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0_3__0"


    // $ANTLR start "rule__BinaryExpression__Group_1_0_3__0__Impl"
    // InternalStoryGen.g:4901:1: rule__BinaryExpression__Group_1_0_3__0__Impl : ( 'or' ) ;
    public final void rule__BinaryExpression__Group_1_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4905:1: ( ( 'or' ) )
            // InternalStoryGen.g:4906:1: ( 'or' )
            {
            // InternalStoryGen.g:4906:1: ( 'or' )
            // InternalStoryGen.g:4907:2: 'or'
            {
             before(grammarAccess.getBinaryExpressionAccess().getOrKeyword_1_0_3_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getBinaryExpressionAccess().getOrKeyword_1_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0_3__0__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_0_3__1"
    // InternalStoryGen.g:4916:1: rule__BinaryExpression__Group_1_0_3__1 : rule__BinaryExpression__Group_1_0_3__1__Impl ;
    public final void rule__BinaryExpression__Group_1_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4920:1: ( rule__BinaryExpression__Group_1_0_3__1__Impl )
            // InternalStoryGen.g:4921:2: rule__BinaryExpression__Group_1_0_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_0_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0_3__1"


    // $ANTLR start "rule__BinaryExpression__Group_1_0_3__1__Impl"
    // InternalStoryGen.g:4927:1: rule__BinaryExpression__Group_1_0_3__1__Impl : ( ( rule__BinaryExpression__OperandsAssignment_1_0_3_1 ) ) ;
    public final void rule__BinaryExpression__Group_1_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4931:1: ( ( ( rule__BinaryExpression__OperandsAssignment_1_0_3_1 ) ) )
            // InternalStoryGen.g:4932:1: ( ( rule__BinaryExpression__OperandsAssignment_1_0_3_1 ) )
            {
            // InternalStoryGen.g:4932:1: ( ( rule__BinaryExpression__OperandsAssignment_1_0_3_1 ) )
            // InternalStoryGen.g:4933:2: ( rule__BinaryExpression__OperandsAssignment_1_0_3_1 )
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperandsAssignment_1_0_3_1()); 
            // InternalStoryGen.g:4934:2: ( rule__BinaryExpression__OperandsAssignment_1_0_3_1 )
            // InternalStoryGen.g:4934:3: rule__BinaryExpression__OperandsAssignment_1_0_3_1
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__OperandsAssignment_1_0_3_1();

            state._fsp--;


            }

             after(grammarAccess.getBinaryExpressionAccess().getOperandsAssignment_1_0_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_0_3__1__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_1__0"
    // InternalStoryGen.g:4943:1: rule__BinaryExpression__Group_1_1__0 : rule__BinaryExpression__Group_1_1__0__Impl rule__BinaryExpression__Group_1_1__1 ;
    public final void rule__BinaryExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4947:1: ( rule__BinaryExpression__Group_1_1__0__Impl rule__BinaryExpression__Group_1_1__1 )
            // InternalStoryGen.g:4948:2: rule__BinaryExpression__Group_1_1__0__Impl rule__BinaryExpression__Group_1_1__1
            {
            pushFollow(FOLLOW_49);
            rule__BinaryExpression__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1__0"


    // $ANTLR start "rule__BinaryExpression__Group_1_1__0__Impl"
    // InternalStoryGen.g:4955:1: rule__BinaryExpression__Group_1_1__0__Impl : ( () ) ;
    public final void rule__BinaryExpression__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4959:1: ( ( () ) )
            // InternalStoryGen.g:4960:1: ( () )
            {
            // InternalStoryGen.g:4960:1: ( () )
            // InternalStoryGen.g:4961:2: ()
            {
             before(grammarAccess.getBinaryExpressionAccess().getAndExpressionOperandsAction_1_1_0()); 
            // InternalStoryGen.g:4962:2: ()
            // InternalStoryGen.g:4962:3: 
            {
            }

             after(grammarAccess.getBinaryExpressionAccess().getAndExpressionOperandsAction_1_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1__0__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_1__1"
    // InternalStoryGen.g:4970:1: rule__BinaryExpression__Group_1_1__1 : rule__BinaryExpression__Group_1_1__1__Impl rule__BinaryExpression__Group_1_1__2 ;
    public final void rule__BinaryExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4974:1: ( rule__BinaryExpression__Group_1_1__1__Impl rule__BinaryExpression__Group_1_1__2 )
            // InternalStoryGen.g:4975:2: rule__BinaryExpression__Group_1_1__1__Impl rule__BinaryExpression__Group_1_1__2
            {
            pushFollow(FOLLOW_20);
            rule__BinaryExpression__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1__1"


    // $ANTLR start "rule__BinaryExpression__Group_1_1__1__Impl"
    // InternalStoryGen.g:4982:1: rule__BinaryExpression__Group_1_1__1__Impl : ( 'and' ) ;
    public final void rule__BinaryExpression__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:4986:1: ( ( 'and' ) )
            // InternalStoryGen.g:4987:1: ( 'and' )
            {
            // InternalStoryGen.g:4987:1: ( 'and' )
            // InternalStoryGen.g:4988:2: 'and'
            {
             before(grammarAccess.getBinaryExpressionAccess().getAndKeyword_1_1_1()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getBinaryExpressionAccess().getAndKeyword_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1__1__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_1__2"
    // InternalStoryGen.g:4997:1: rule__BinaryExpression__Group_1_1__2 : rule__BinaryExpression__Group_1_1__2__Impl rule__BinaryExpression__Group_1_1__3 ;
    public final void rule__BinaryExpression__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5001:1: ( rule__BinaryExpression__Group_1_1__2__Impl rule__BinaryExpression__Group_1_1__3 )
            // InternalStoryGen.g:5002:2: rule__BinaryExpression__Group_1_1__2__Impl rule__BinaryExpression__Group_1_1__3
            {
            pushFollow(FOLLOW_49);
            rule__BinaryExpression__Group_1_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1__2"


    // $ANTLR start "rule__BinaryExpression__Group_1_1__2__Impl"
    // InternalStoryGen.g:5009:1: rule__BinaryExpression__Group_1_1__2__Impl : ( ( rule__BinaryExpression__OperandsAssignment_1_1_2 ) ) ;
    public final void rule__BinaryExpression__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5013:1: ( ( ( rule__BinaryExpression__OperandsAssignment_1_1_2 ) ) )
            // InternalStoryGen.g:5014:1: ( ( rule__BinaryExpression__OperandsAssignment_1_1_2 ) )
            {
            // InternalStoryGen.g:5014:1: ( ( rule__BinaryExpression__OperandsAssignment_1_1_2 ) )
            // InternalStoryGen.g:5015:2: ( rule__BinaryExpression__OperandsAssignment_1_1_2 )
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperandsAssignment_1_1_2()); 
            // InternalStoryGen.g:5016:2: ( rule__BinaryExpression__OperandsAssignment_1_1_2 )
            // InternalStoryGen.g:5016:3: rule__BinaryExpression__OperandsAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__OperandsAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getBinaryExpressionAccess().getOperandsAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1__2__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_1__3"
    // InternalStoryGen.g:5024:1: rule__BinaryExpression__Group_1_1__3 : rule__BinaryExpression__Group_1_1__3__Impl ;
    public final void rule__BinaryExpression__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5028:1: ( rule__BinaryExpression__Group_1_1__3__Impl )
            // InternalStoryGen.g:5029:2: rule__BinaryExpression__Group_1_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1__3"


    // $ANTLR start "rule__BinaryExpression__Group_1_1__3__Impl"
    // InternalStoryGen.g:5035:1: rule__BinaryExpression__Group_1_1__3__Impl : ( ( rule__BinaryExpression__Group_1_1_3__0 )* ) ;
    public final void rule__BinaryExpression__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5039:1: ( ( ( rule__BinaryExpression__Group_1_1_3__0 )* ) )
            // InternalStoryGen.g:5040:1: ( ( rule__BinaryExpression__Group_1_1_3__0 )* )
            {
            // InternalStoryGen.g:5040:1: ( ( rule__BinaryExpression__Group_1_1_3__0 )* )
            // InternalStoryGen.g:5041:2: ( rule__BinaryExpression__Group_1_1_3__0 )*
            {
             before(grammarAccess.getBinaryExpressionAccess().getGroup_1_1_3()); 
            // InternalStoryGen.g:5042:2: ( rule__BinaryExpression__Group_1_1_3__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==67) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalStoryGen.g:5042:3: rule__BinaryExpression__Group_1_1_3__0
            	    {
            	    pushFollow(FOLLOW_50);
            	    rule__BinaryExpression__Group_1_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getBinaryExpressionAccess().getGroup_1_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1__3__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_1_3__0"
    // InternalStoryGen.g:5051:1: rule__BinaryExpression__Group_1_1_3__0 : rule__BinaryExpression__Group_1_1_3__0__Impl rule__BinaryExpression__Group_1_1_3__1 ;
    public final void rule__BinaryExpression__Group_1_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5055:1: ( rule__BinaryExpression__Group_1_1_3__0__Impl rule__BinaryExpression__Group_1_1_3__1 )
            // InternalStoryGen.g:5056:2: rule__BinaryExpression__Group_1_1_3__0__Impl rule__BinaryExpression__Group_1_1_3__1
            {
            pushFollow(FOLLOW_20);
            rule__BinaryExpression__Group_1_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_1_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1_3__0"


    // $ANTLR start "rule__BinaryExpression__Group_1_1_3__0__Impl"
    // InternalStoryGen.g:5063:1: rule__BinaryExpression__Group_1_1_3__0__Impl : ( 'and' ) ;
    public final void rule__BinaryExpression__Group_1_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5067:1: ( ( 'and' ) )
            // InternalStoryGen.g:5068:1: ( 'and' )
            {
            // InternalStoryGen.g:5068:1: ( 'and' )
            // InternalStoryGen.g:5069:2: 'and'
            {
             before(grammarAccess.getBinaryExpressionAccess().getAndKeyword_1_1_3_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getBinaryExpressionAccess().getAndKeyword_1_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1_3__0__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_1_3__1"
    // InternalStoryGen.g:5078:1: rule__BinaryExpression__Group_1_1_3__1 : rule__BinaryExpression__Group_1_1_3__1__Impl ;
    public final void rule__BinaryExpression__Group_1_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5082:1: ( rule__BinaryExpression__Group_1_1_3__1__Impl )
            // InternalStoryGen.g:5083:2: rule__BinaryExpression__Group_1_1_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_1_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1_3__1"


    // $ANTLR start "rule__BinaryExpression__Group_1_1_3__1__Impl"
    // InternalStoryGen.g:5089:1: rule__BinaryExpression__Group_1_1_3__1__Impl : ( ( rule__BinaryExpression__OperandsAssignment_1_1_3_1 ) ) ;
    public final void rule__BinaryExpression__Group_1_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5093:1: ( ( ( rule__BinaryExpression__OperandsAssignment_1_1_3_1 ) ) )
            // InternalStoryGen.g:5094:1: ( ( rule__BinaryExpression__OperandsAssignment_1_1_3_1 ) )
            {
            // InternalStoryGen.g:5094:1: ( ( rule__BinaryExpression__OperandsAssignment_1_1_3_1 ) )
            // InternalStoryGen.g:5095:2: ( rule__BinaryExpression__OperandsAssignment_1_1_3_1 )
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperandsAssignment_1_1_3_1()); 
            // InternalStoryGen.g:5096:2: ( rule__BinaryExpression__OperandsAssignment_1_1_3_1 )
            // InternalStoryGen.g:5096:3: rule__BinaryExpression__OperandsAssignment_1_1_3_1
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__OperandsAssignment_1_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getBinaryExpressionAccess().getOperandsAssignment_1_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_1_3__1__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_2__0"
    // InternalStoryGen.g:5105:1: rule__BinaryExpression__Group_1_2__0 : rule__BinaryExpression__Group_1_2__0__Impl rule__BinaryExpression__Group_1_2__1 ;
    public final void rule__BinaryExpression__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5109:1: ( rule__BinaryExpression__Group_1_2__0__Impl rule__BinaryExpression__Group_1_2__1 )
            // InternalStoryGen.g:5110:2: rule__BinaryExpression__Group_1_2__0__Impl rule__BinaryExpression__Group_1_2__1
            {
            pushFollow(FOLLOW_46);
            rule__BinaryExpression__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_2__0"


    // $ANTLR start "rule__BinaryExpression__Group_1_2__0__Impl"
    // InternalStoryGen.g:5117:1: rule__BinaryExpression__Group_1_2__0__Impl : ( () ) ;
    public final void rule__BinaryExpression__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5121:1: ( ( () ) )
            // InternalStoryGen.g:5122:1: ( () )
            {
            // InternalStoryGen.g:5122:1: ( () )
            // InternalStoryGen.g:5123:2: ()
            {
             before(grammarAccess.getBinaryExpressionAccess().getComparisonExpressionLeftAction_1_2_0()); 
            // InternalStoryGen.g:5124:2: ()
            // InternalStoryGen.g:5124:3: 
            {
            }

             after(grammarAccess.getBinaryExpressionAccess().getComparisonExpressionLeftAction_1_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_2__0__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_2__1"
    // InternalStoryGen.g:5132:1: rule__BinaryExpression__Group_1_2__1 : rule__BinaryExpression__Group_1_2__1__Impl rule__BinaryExpression__Group_1_2__2 ;
    public final void rule__BinaryExpression__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5136:1: ( rule__BinaryExpression__Group_1_2__1__Impl rule__BinaryExpression__Group_1_2__2 )
            // InternalStoryGen.g:5137:2: rule__BinaryExpression__Group_1_2__1__Impl rule__BinaryExpression__Group_1_2__2
            {
            pushFollow(FOLLOW_20);
            rule__BinaryExpression__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_2__1"


    // $ANTLR start "rule__BinaryExpression__Group_1_2__1__Impl"
    // InternalStoryGen.g:5144:1: rule__BinaryExpression__Group_1_2__1__Impl : ( ( rule__BinaryExpression__OperatorAssignment_1_2_1 ) ) ;
    public final void rule__BinaryExpression__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5148:1: ( ( ( rule__BinaryExpression__OperatorAssignment_1_2_1 ) ) )
            // InternalStoryGen.g:5149:1: ( ( rule__BinaryExpression__OperatorAssignment_1_2_1 ) )
            {
            // InternalStoryGen.g:5149:1: ( ( rule__BinaryExpression__OperatorAssignment_1_2_1 ) )
            // InternalStoryGen.g:5150:2: ( rule__BinaryExpression__OperatorAssignment_1_2_1 )
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperatorAssignment_1_2_1()); 
            // InternalStoryGen.g:5151:2: ( rule__BinaryExpression__OperatorAssignment_1_2_1 )
            // InternalStoryGen.g:5151:3: rule__BinaryExpression__OperatorAssignment_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__OperatorAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getBinaryExpressionAccess().getOperatorAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_2__1__Impl"


    // $ANTLR start "rule__BinaryExpression__Group_1_2__2"
    // InternalStoryGen.g:5159:1: rule__BinaryExpression__Group_1_2__2 : rule__BinaryExpression__Group_1_2__2__Impl ;
    public final void rule__BinaryExpression__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5163:1: ( rule__BinaryExpression__Group_1_2__2__Impl )
            // InternalStoryGen.g:5164:2: rule__BinaryExpression__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__Group_1_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_2__2"


    // $ANTLR start "rule__BinaryExpression__Group_1_2__2__Impl"
    // InternalStoryGen.g:5170:1: rule__BinaryExpression__Group_1_2__2__Impl : ( ( rule__BinaryExpression__RightAssignment_1_2_2 ) ) ;
    public final void rule__BinaryExpression__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5174:1: ( ( ( rule__BinaryExpression__RightAssignment_1_2_2 ) ) )
            // InternalStoryGen.g:5175:1: ( ( rule__BinaryExpression__RightAssignment_1_2_2 ) )
            {
            // InternalStoryGen.g:5175:1: ( ( rule__BinaryExpression__RightAssignment_1_2_2 ) )
            // InternalStoryGen.g:5176:2: ( rule__BinaryExpression__RightAssignment_1_2_2 )
            {
             before(grammarAccess.getBinaryExpressionAccess().getRightAssignment_1_2_2()); 
            // InternalStoryGen.g:5177:2: ( rule__BinaryExpression__RightAssignment_1_2_2 )
            // InternalStoryGen.g:5177:3: rule__BinaryExpression__RightAssignment_1_2_2
            {
            pushFollow(FOLLOW_2);
            rule__BinaryExpression__RightAssignment_1_2_2();

            state._fsp--;


            }

             after(grammarAccess.getBinaryExpressionAccess().getRightAssignment_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__Group_1_2__2__Impl"


    // $ANTLR start "rule__NegationExpression__Group__0"
    // InternalStoryGen.g:5186:1: rule__NegationExpression__Group__0 : rule__NegationExpression__Group__0__Impl rule__NegationExpression__Group__1 ;
    public final void rule__NegationExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5190:1: ( rule__NegationExpression__Group__0__Impl rule__NegationExpression__Group__1 )
            // InternalStoryGen.g:5191:2: rule__NegationExpression__Group__0__Impl rule__NegationExpression__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__NegationExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NegationExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegationExpression__Group__0"


    // $ANTLR start "rule__NegationExpression__Group__0__Impl"
    // InternalStoryGen.g:5198:1: rule__NegationExpression__Group__0__Impl : ( () ) ;
    public final void rule__NegationExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5202:1: ( ( () ) )
            // InternalStoryGen.g:5203:1: ( () )
            {
            // InternalStoryGen.g:5203:1: ( () )
            // InternalStoryGen.g:5204:2: ()
            {
             before(grammarAccess.getNegationExpressionAccess().getNegationExpressionAction_0()); 
            // InternalStoryGen.g:5205:2: ()
            // InternalStoryGen.g:5205:3: 
            {
            }

             after(grammarAccess.getNegationExpressionAccess().getNegationExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegationExpression__Group__0__Impl"


    // $ANTLR start "rule__NegationExpression__Group__1"
    // InternalStoryGen.g:5213:1: rule__NegationExpression__Group__1 : rule__NegationExpression__Group__1__Impl rule__NegationExpression__Group__2 ;
    public final void rule__NegationExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5217:1: ( rule__NegationExpression__Group__1__Impl rule__NegationExpression__Group__2 )
            // InternalStoryGen.g:5218:2: rule__NegationExpression__Group__1__Impl rule__NegationExpression__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__NegationExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NegationExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegationExpression__Group__1"


    // $ANTLR start "rule__NegationExpression__Group__1__Impl"
    // InternalStoryGen.g:5225:1: rule__NegationExpression__Group__1__Impl : ( 'not' ) ;
    public final void rule__NegationExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5229:1: ( ( 'not' ) )
            // InternalStoryGen.g:5230:1: ( 'not' )
            {
            // InternalStoryGen.g:5230:1: ( 'not' )
            // InternalStoryGen.g:5231:2: 'not'
            {
             before(grammarAccess.getNegationExpressionAccess().getNotKeyword_1()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getNegationExpressionAccess().getNotKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegationExpression__Group__1__Impl"


    // $ANTLR start "rule__NegationExpression__Group__2"
    // InternalStoryGen.g:5240:1: rule__NegationExpression__Group__2 : rule__NegationExpression__Group__2__Impl ;
    public final void rule__NegationExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5244:1: ( rule__NegationExpression__Group__2__Impl )
            // InternalStoryGen.g:5245:2: rule__NegationExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NegationExpression__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegationExpression__Group__2"


    // $ANTLR start "rule__NegationExpression__Group__2__Impl"
    // InternalStoryGen.g:5251:1: rule__NegationExpression__Group__2__Impl : ( ( rule__NegationExpression__OperandAssignment_2 ) ) ;
    public final void rule__NegationExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5255:1: ( ( ( rule__NegationExpression__OperandAssignment_2 ) ) )
            // InternalStoryGen.g:5256:1: ( ( rule__NegationExpression__OperandAssignment_2 ) )
            {
            // InternalStoryGen.g:5256:1: ( ( rule__NegationExpression__OperandAssignment_2 ) )
            // InternalStoryGen.g:5257:2: ( rule__NegationExpression__OperandAssignment_2 )
            {
             before(grammarAccess.getNegationExpressionAccess().getOperandAssignment_2()); 
            // InternalStoryGen.g:5258:2: ( rule__NegationExpression__OperandAssignment_2 )
            // InternalStoryGen.g:5258:3: rule__NegationExpression__OperandAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__NegationExpression__OperandAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getNegationExpressionAccess().getOperandAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegationExpression__Group__2__Impl"


    // $ANTLR start "rule__UnitaryExpression__Group_0__0"
    // InternalStoryGen.g:5267:1: rule__UnitaryExpression__Group_0__0 : rule__UnitaryExpression__Group_0__0__Impl rule__UnitaryExpression__Group_0__1 ;
    public final void rule__UnitaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5271:1: ( rule__UnitaryExpression__Group_0__0__Impl rule__UnitaryExpression__Group_0__1 )
            // InternalStoryGen.g:5272:2: rule__UnitaryExpression__Group_0__0__Impl rule__UnitaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_20);
            rule__UnitaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnitaryExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitaryExpression__Group_0__0"


    // $ANTLR start "rule__UnitaryExpression__Group_0__0__Impl"
    // InternalStoryGen.g:5279:1: rule__UnitaryExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__UnitaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5283:1: ( ( '(' ) )
            // InternalStoryGen.g:5284:1: ( '(' )
            {
            // InternalStoryGen.g:5284:1: ( '(' )
            // InternalStoryGen.g:5285:2: '('
            {
             before(grammarAccess.getUnitaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getUnitaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitaryExpression__Group_0__0__Impl"


    // $ANTLR start "rule__UnitaryExpression__Group_0__1"
    // InternalStoryGen.g:5294:1: rule__UnitaryExpression__Group_0__1 : rule__UnitaryExpression__Group_0__1__Impl rule__UnitaryExpression__Group_0__2 ;
    public final void rule__UnitaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5298:1: ( rule__UnitaryExpression__Group_0__1__Impl rule__UnitaryExpression__Group_0__2 )
            // InternalStoryGen.g:5299:2: rule__UnitaryExpression__Group_0__1__Impl rule__UnitaryExpression__Group_0__2
            {
            pushFollow(FOLLOW_21);
            rule__UnitaryExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnitaryExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitaryExpression__Group_0__1"


    // $ANTLR start "rule__UnitaryExpression__Group_0__1__Impl"
    // InternalStoryGen.g:5306:1: rule__UnitaryExpression__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__UnitaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5310:1: ( ( ruleExpression ) )
            // InternalStoryGen.g:5311:1: ( ruleExpression )
            {
            // InternalStoryGen.g:5311:1: ( ruleExpression )
            // InternalStoryGen.g:5312:2: ruleExpression
            {
             before(grammarAccess.getUnitaryExpressionAccess().getExpressionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getUnitaryExpressionAccess().getExpressionParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitaryExpression__Group_0__1__Impl"


    // $ANTLR start "rule__UnitaryExpression__Group_0__2"
    // InternalStoryGen.g:5321:1: rule__UnitaryExpression__Group_0__2 : rule__UnitaryExpression__Group_0__2__Impl ;
    public final void rule__UnitaryExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5325:1: ( rule__UnitaryExpression__Group_0__2__Impl )
            // InternalStoryGen.g:5326:2: rule__UnitaryExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnitaryExpression__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitaryExpression__Group_0__2"


    // $ANTLR start "rule__UnitaryExpression__Group_0__2__Impl"
    // InternalStoryGen.g:5332:1: rule__UnitaryExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__UnitaryExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5336:1: ( ( ')' ) )
            // InternalStoryGen.g:5337:1: ( ')' )
            {
            // InternalStoryGen.g:5337:1: ( ')' )
            // InternalStoryGen.g:5338:2: ')'
            {
             before(grammarAccess.getUnitaryExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getUnitaryExpressionAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnitaryExpression__Group_0__2__Impl"


    // $ANTLR start "rule__ExistentAttributeTerm__Group__0"
    // InternalStoryGen.g:5348:1: rule__ExistentAttributeTerm__Group__0 : rule__ExistentAttributeTerm__Group__0__Impl rule__ExistentAttributeTerm__Group__1 ;
    public final void rule__ExistentAttributeTerm__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5352:1: ( rule__ExistentAttributeTerm__Group__0__Impl rule__ExistentAttributeTerm__Group__1 )
            // InternalStoryGen.g:5353:2: rule__ExistentAttributeTerm__Group__0__Impl rule__ExistentAttributeTerm__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__ExistentAttributeTerm__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExistentAttributeTerm__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentAttributeTerm__Group__0"


    // $ANTLR start "rule__ExistentAttributeTerm__Group__0__Impl"
    // InternalStoryGen.g:5360:1: rule__ExistentAttributeTerm__Group__0__Impl : ( ( rule__ExistentAttributeTerm__ExistentAssignment_0 ) ) ;
    public final void rule__ExistentAttributeTerm__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5364:1: ( ( ( rule__ExistentAttributeTerm__ExistentAssignment_0 ) ) )
            // InternalStoryGen.g:5365:1: ( ( rule__ExistentAttributeTerm__ExistentAssignment_0 ) )
            {
            // InternalStoryGen.g:5365:1: ( ( rule__ExistentAttributeTerm__ExistentAssignment_0 ) )
            // InternalStoryGen.g:5366:2: ( rule__ExistentAttributeTerm__ExistentAssignment_0 )
            {
             before(grammarAccess.getExistentAttributeTermAccess().getExistentAssignment_0()); 
            // InternalStoryGen.g:5367:2: ( rule__ExistentAttributeTerm__ExistentAssignment_0 )
            // InternalStoryGen.g:5367:3: rule__ExistentAttributeTerm__ExistentAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ExistentAttributeTerm__ExistentAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getExistentAttributeTermAccess().getExistentAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentAttributeTerm__Group__0__Impl"


    // $ANTLR start "rule__ExistentAttributeTerm__Group__1"
    // InternalStoryGen.g:5375:1: rule__ExistentAttributeTerm__Group__1 : rule__ExistentAttributeTerm__Group__1__Impl rule__ExistentAttributeTerm__Group__2 ;
    public final void rule__ExistentAttributeTerm__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5379:1: ( rule__ExistentAttributeTerm__Group__1__Impl rule__ExistentAttributeTerm__Group__2 )
            // InternalStoryGen.g:5380:2: rule__ExistentAttributeTerm__Group__1__Impl rule__ExistentAttributeTerm__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__ExistentAttributeTerm__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExistentAttributeTerm__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentAttributeTerm__Group__1"


    // $ANTLR start "rule__ExistentAttributeTerm__Group__1__Impl"
    // InternalStoryGen.g:5387:1: rule__ExistentAttributeTerm__Group__1__Impl : ( '.' ) ;
    public final void rule__ExistentAttributeTerm__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5391:1: ( ( '.' ) )
            // InternalStoryGen.g:5392:1: ( '.' )
            {
            // InternalStoryGen.g:5392:1: ( '.' )
            // InternalStoryGen.g:5393:2: '.'
            {
             before(grammarAccess.getExistentAttributeTermAccess().getFullStopKeyword_1()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getExistentAttributeTermAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentAttributeTerm__Group__1__Impl"


    // $ANTLR start "rule__ExistentAttributeTerm__Group__2"
    // InternalStoryGen.g:5402:1: rule__ExistentAttributeTerm__Group__2 : rule__ExistentAttributeTerm__Group__2__Impl ;
    public final void rule__ExistentAttributeTerm__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5406:1: ( rule__ExistentAttributeTerm__Group__2__Impl )
            // InternalStoryGen.g:5407:2: rule__ExistentAttributeTerm__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExistentAttributeTerm__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentAttributeTerm__Group__2"


    // $ANTLR start "rule__ExistentAttributeTerm__Group__2__Impl"
    // InternalStoryGen.g:5413:1: rule__ExistentAttributeTerm__Group__2__Impl : ( ( rule__ExistentAttributeTerm__AttributeAssignment_2 ) ) ;
    public final void rule__ExistentAttributeTerm__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5417:1: ( ( ( rule__ExistentAttributeTerm__AttributeAssignment_2 ) ) )
            // InternalStoryGen.g:5418:1: ( ( rule__ExistentAttributeTerm__AttributeAssignment_2 ) )
            {
            // InternalStoryGen.g:5418:1: ( ( rule__ExistentAttributeTerm__AttributeAssignment_2 ) )
            // InternalStoryGen.g:5419:2: ( rule__ExistentAttributeTerm__AttributeAssignment_2 )
            {
             before(grammarAccess.getExistentAttributeTermAccess().getAttributeAssignment_2()); 
            // InternalStoryGen.g:5420:2: ( rule__ExistentAttributeTerm__AttributeAssignment_2 )
            // InternalStoryGen.g:5420:3: rule__ExistentAttributeTerm__AttributeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ExistentAttributeTerm__AttributeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getExistentAttributeTermAccess().getAttributeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentAttributeTerm__Group__2__Impl"


    // $ANTLR start "rule__StoryAttributeTerm__Group__0"
    // InternalStoryGen.g:5429:1: rule__StoryAttributeTerm__Group__0 : rule__StoryAttributeTerm__Group__0__Impl rule__StoryAttributeTerm__Group__1 ;
    public final void rule__StoryAttributeTerm__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5433:1: ( rule__StoryAttributeTerm__Group__0__Impl rule__StoryAttributeTerm__Group__1 )
            // InternalStoryGen.g:5434:2: rule__StoryAttributeTerm__Group__0__Impl rule__StoryAttributeTerm__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__StoryAttributeTerm__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryAttributeTerm__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryAttributeTerm__Group__0"


    // $ANTLR start "rule__StoryAttributeTerm__Group__0__Impl"
    // InternalStoryGen.g:5441:1: rule__StoryAttributeTerm__Group__0__Impl : ( 'Story' ) ;
    public final void rule__StoryAttributeTerm__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5445:1: ( ( 'Story' ) )
            // InternalStoryGen.g:5446:1: ( 'Story' )
            {
            // InternalStoryGen.g:5446:1: ( 'Story' )
            // InternalStoryGen.g:5447:2: 'Story'
            {
             before(grammarAccess.getStoryAttributeTermAccess().getStoryKeyword_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getStoryAttributeTermAccess().getStoryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryAttributeTerm__Group__0__Impl"


    // $ANTLR start "rule__StoryAttributeTerm__Group__1"
    // InternalStoryGen.g:5456:1: rule__StoryAttributeTerm__Group__1 : rule__StoryAttributeTerm__Group__1__Impl rule__StoryAttributeTerm__Group__2 ;
    public final void rule__StoryAttributeTerm__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5460:1: ( rule__StoryAttributeTerm__Group__1__Impl rule__StoryAttributeTerm__Group__2 )
            // InternalStoryGen.g:5461:2: rule__StoryAttributeTerm__Group__1__Impl rule__StoryAttributeTerm__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__StoryAttributeTerm__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StoryAttributeTerm__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryAttributeTerm__Group__1"


    // $ANTLR start "rule__StoryAttributeTerm__Group__1__Impl"
    // InternalStoryGen.g:5468:1: rule__StoryAttributeTerm__Group__1__Impl : ( '.' ) ;
    public final void rule__StoryAttributeTerm__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5472:1: ( ( '.' ) )
            // InternalStoryGen.g:5473:1: ( '.' )
            {
            // InternalStoryGen.g:5473:1: ( '.' )
            // InternalStoryGen.g:5474:2: '.'
            {
             before(grammarAccess.getStoryAttributeTermAccess().getFullStopKeyword_1()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getStoryAttributeTermAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryAttributeTerm__Group__1__Impl"


    // $ANTLR start "rule__StoryAttributeTerm__Group__2"
    // InternalStoryGen.g:5483:1: rule__StoryAttributeTerm__Group__2 : rule__StoryAttributeTerm__Group__2__Impl ;
    public final void rule__StoryAttributeTerm__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5487:1: ( rule__StoryAttributeTerm__Group__2__Impl )
            // InternalStoryGen.g:5488:2: rule__StoryAttributeTerm__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StoryAttributeTerm__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryAttributeTerm__Group__2"


    // $ANTLR start "rule__StoryAttributeTerm__Group__2__Impl"
    // InternalStoryGen.g:5494:1: rule__StoryAttributeTerm__Group__2__Impl : ( ( rule__StoryAttributeTerm__AttributeAssignment_2 ) ) ;
    public final void rule__StoryAttributeTerm__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5498:1: ( ( ( rule__StoryAttributeTerm__AttributeAssignment_2 ) ) )
            // InternalStoryGen.g:5499:1: ( ( rule__StoryAttributeTerm__AttributeAssignment_2 ) )
            {
            // InternalStoryGen.g:5499:1: ( ( rule__StoryAttributeTerm__AttributeAssignment_2 ) )
            // InternalStoryGen.g:5500:2: ( rule__StoryAttributeTerm__AttributeAssignment_2 )
            {
             before(grammarAccess.getStoryAttributeTermAccess().getAttributeAssignment_2()); 
            // InternalStoryGen.g:5501:2: ( rule__StoryAttributeTerm__AttributeAssignment_2 )
            // InternalStoryGen.g:5501:3: rule__StoryAttributeTerm__AttributeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__StoryAttributeTerm__AttributeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStoryAttributeTermAccess().getAttributeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryAttributeTerm__Group__2__Impl"


    // $ANTLR start "rule__Story__DataAssignment_0"
    // InternalStoryGen.g:5510:1: rule__Story__DataAssignment_0 : ( ruleStoryData ) ;
    public final void rule__Story__DataAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5514:1: ( ( ruleStoryData ) )
            // InternalStoryGen.g:5515:2: ( ruleStoryData )
            {
            // InternalStoryGen.g:5515:2: ( ruleStoryData )
            // InternalStoryGen.g:5516:3: ruleStoryData
            {
             before(grammarAccess.getStoryAccess().getDataStoryDataParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleStoryData();

            state._fsp--;

             after(grammarAccess.getStoryAccess().getDataStoryDataParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__DataAssignment_0"


    // $ANTLR start "rule__Story__SpaceAssignment_1"
    // InternalStoryGen.g:5525:1: rule__Story__SpaceAssignment_1 : ( ruleSpace ) ;
    public final void rule__Story__SpaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5529:1: ( ( ruleSpace ) )
            // InternalStoryGen.g:5530:2: ( ruleSpace )
            {
            // InternalStoryGen.g:5530:2: ( ruleSpace )
            // InternalStoryGen.g:5531:3: ruleSpace
            {
             before(grammarAccess.getStoryAccess().getSpaceSpaceParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSpace();

            state._fsp--;

             after(grammarAccess.getStoryAccess().getSpaceSpaceParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__SpaceAssignment_1"


    // $ANTLR start "rule__Story__PlotAssignment_2"
    // InternalStoryGen.g:5540:1: rule__Story__PlotAssignment_2 : ( rulePlot ) ;
    public final void rule__Story__PlotAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5544:1: ( ( rulePlot ) )
            // InternalStoryGen.g:5545:2: ( rulePlot )
            {
            // InternalStoryGen.g:5545:2: ( rulePlot )
            // InternalStoryGen.g:5546:3: rulePlot
            {
             before(grammarAccess.getStoryAccess().getPlotPlotParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulePlot();

            state._fsp--;

             after(grammarAccess.getStoryAccess().getPlotPlotParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Story__PlotAssignment_2"


    // $ANTLR start "rule__StoryData__AttributesAssignment_4"
    // InternalStoryGen.g:5555:1: rule__StoryData__AttributesAssignment_4 : ( ruleAttribute ) ;
    public final void rule__StoryData__AttributesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5559:1: ( ( ruleAttribute ) )
            // InternalStoryGen.g:5560:2: ( ruleAttribute )
            {
            // InternalStoryGen.g:5560:2: ( ruleAttribute )
            // InternalStoryGen.g:5561:3: ruleAttribute
            {
             before(grammarAccess.getStoryDataAccess().getAttributesAttributeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getStoryDataAccess().getAttributesAttributeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryData__AttributesAssignment_4"


    // $ANTLR start "rule__Space__ExistentsAssignment_3"
    // InternalStoryGen.g:5570:1: rule__Space__ExistentsAssignment_3 : ( ruleExistent ) ;
    public final void rule__Space__ExistentsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5574:1: ( ( ruleExistent ) )
            // InternalStoryGen.g:5575:2: ( ruleExistent )
            {
            // InternalStoryGen.g:5575:2: ( ruleExistent )
            // InternalStoryGen.g:5576:3: ruleExistent
            {
             before(grammarAccess.getSpaceAccess().getExistentsExistentParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExistent();

            state._fsp--;

             after(grammarAccess.getSpaceAccess().getExistentsExistentParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__ExistentsAssignment_3"


    // $ANTLR start "rule__Plot__EventsAssignment_3"
    // InternalStoryGen.g:5585:1: rule__Plot__EventsAssignment_3 : ( ruleEvent ) ;
    public final void rule__Plot__EventsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5589:1: ( ( ruleEvent ) )
            // InternalStoryGen.g:5590:2: ( ruleEvent )
            {
            // InternalStoryGen.g:5590:2: ( ruleEvent )
            // InternalStoryGen.g:5591:3: ruleEvent
            {
             before(grammarAccess.getPlotAccess().getEventsEventParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getPlotAccess().getEventsEventParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plot__EventsAssignment_3"


    // $ANTLR start "rule__Actor__PlayableAssignment_0"
    // InternalStoryGen.g:5600:1: rule__Actor__PlayableAssignment_0 : ( ( 'player' ) ) ;
    public final void rule__Actor__PlayableAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5604:1: ( ( ( 'player' ) ) )
            // InternalStoryGen.g:5605:2: ( ( 'player' ) )
            {
            // InternalStoryGen.g:5605:2: ( ( 'player' ) )
            // InternalStoryGen.g:5606:3: ( 'player' )
            {
             before(grammarAccess.getActorAccess().getPlayablePlayerKeyword_0_0()); 
            // InternalStoryGen.g:5607:3: ( 'player' )
            // InternalStoryGen.g:5608:4: 'player'
            {
             before(grammarAccess.getActorAccess().getPlayablePlayerKeyword_0_0()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getActorAccess().getPlayablePlayerKeyword_0_0()); 

            }

             after(grammarAccess.getActorAccess().getPlayablePlayerKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__PlayableAssignment_0"


    // $ANTLR start "rule__Actor__NameAssignment_2"
    // InternalStoryGen.g:5619:1: rule__Actor__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Actor__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5623:1: ( ( RULE_ID ) )
            // InternalStoryGen.g:5624:2: ( RULE_ID )
            {
            // InternalStoryGen.g:5624:2: ( RULE_ID )
            // InternalStoryGen.g:5625:3: RULE_ID
            {
             before(grammarAccess.getActorAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActorAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__NameAssignment_2"


    // $ANTLR start "rule__Actor__DisplayNameAssignment_5"
    // InternalStoryGen.g:5634:1: rule__Actor__DisplayNameAssignment_5 : ( RULE_STRING ) ;
    public final void rule__Actor__DisplayNameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5638:1: ( ( RULE_STRING ) )
            // InternalStoryGen.g:5639:2: ( RULE_STRING )
            {
            // InternalStoryGen.g:5639:2: ( RULE_STRING )
            // InternalStoryGen.g:5640:3: RULE_STRING
            {
             before(grammarAccess.getActorAccess().getDisplayNameSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getActorAccess().getDisplayNameSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__DisplayNameAssignment_5"


    // $ANTLR start "rule__Actor__AttributesAssignment_6"
    // InternalStoryGen.g:5649:1: rule__Actor__AttributesAssignment_6 : ( ruleAttribute ) ;
    public final void rule__Actor__AttributesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5653:1: ( ( ruleAttribute ) )
            // InternalStoryGen.g:5654:2: ( ruleAttribute )
            {
            // InternalStoryGen.g:5654:2: ( ruleAttribute )
            // InternalStoryGen.g:5655:3: ruleAttribute
            {
             before(grammarAccess.getActorAccess().getAttributesAttributeParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getActorAccess().getAttributesAttributeParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Actor__AttributesAssignment_6"


    // $ANTLR start "rule__Object__NameAssignment_1"
    // InternalStoryGen.g:5664:1: rule__Object__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Object__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5668:1: ( ( RULE_ID ) )
            // InternalStoryGen.g:5669:2: ( RULE_ID )
            {
            // InternalStoryGen.g:5669:2: ( RULE_ID )
            // InternalStoryGen.g:5670:3: RULE_ID
            {
             before(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__NameAssignment_1"


    // $ANTLR start "rule__Object__AttributesAssignment_3"
    // InternalStoryGen.g:5679:1: rule__Object__AttributesAssignment_3 : ( ruleAttribute ) ;
    public final void rule__Object__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5683:1: ( ( ruleAttribute ) )
            // InternalStoryGen.g:5684:2: ( ruleAttribute )
            {
            // InternalStoryGen.g:5684:2: ( ruleAttribute )
            // InternalStoryGen.g:5685:3: ruleAttribute
            {
             before(grammarAccess.getObjectAccess().getAttributesAttributeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getObjectAccess().getAttributesAttributeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__AttributesAssignment_3"


    // $ANTLR start "rule__FactAttribute__NameAssignment_1"
    // InternalStoryGen.g:5694:1: rule__FactAttribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FactAttribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5698:1: ( ( RULE_ID ) )
            // InternalStoryGen.g:5699:2: ( RULE_ID )
            {
            // InternalStoryGen.g:5699:2: ( RULE_ID )
            // InternalStoryGen.g:5700:3: RULE_ID
            {
             before(grammarAccess.getFactAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFactAttributeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__NameAssignment_1"


    // $ANTLR start "rule__FactAttribute__InitValueAssignment_3_0"
    // InternalStoryGen.g:5709:1: rule__FactAttribute__InitValueAssignment_3_0 : ( ruleBooleanTerm ) ;
    public final void rule__FactAttribute__InitValueAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5713:1: ( ( ruleBooleanTerm ) )
            // InternalStoryGen.g:5714:2: ( ruleBooleanTerm )
            {
            // InternalStoryGen.g:5714:2: ( ruleBooleanTerm )
            // InternalStoryGen.g:5715:3: ruleBooleanTerm
            {
             before(grammarAccess.getFactAttributeAccess().getInitValueBooleanTermParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanTerm();

            state._fsp--;

             after(grammarAccess.getFactAttributeAccess().getInitValueBooleanTermParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__InitValueAssignment_3_0"


    // $ANTLR start "rule__FactAttribute__MacroExpAssignment_3_1_1"
    // InternalStoryGen.g:5724:1: rule__FactAttribute__MacroExpAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__FactAttribute__MacroExpAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5728:1: ( ( ruleExpression ) )
            // InternalStoryGen.g:5729:2: ( ruleExpression )
            {
            // InternalStoryGen.g:5729:2: ( ruleExpression )
            // InternalStoryGen.g:5730:3: ruleExpression
            {
             before(grammarAccess.getFactAttributeAccess().getMacroExpExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getFactAttributeAccess().getMacroExpExpressionParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FactAttribute__MacroExpAssignment_3_1_1"


    // $ANTLR start "rule__QuantityAttribute__NameAssignment_1"
    // InternalStoryGen.g:5739:1: rule__QuantityAttribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__QuantityAttribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5743:1: ( ( RULE_ID ) )
            // InternalStoryGen.g:5744:2: ( RULE_ID )
            {
            // InternalStoryGen.g:5744:2: ( RULE_ID )
            // InternalStoryGen.g:5745:3: RULE_ID
            {
             before(grammarAccess.getQuantityAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQuantityAttributeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__NameAssignment_1"


    // $ANTLR start "rule__QuantityAttribute__InitValueAssignment_3"
    // InternalStoryGen.g:5754:1: rule__QuantityAttribute__InitValueAssignment_3 : ( ruleIntegerTerm ) ;
    public final void rule__QuantityAttribute__InitValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5758:1: ( ( ruleIntegerTerm ) )
            // InternalStoryGen.g:5759:2: ( ruleIntegerTerm )
            {
            // InternalStoryGen.g:5759:2: ( ruleIntegerTerm )
            // InternalStoryGen.g:5760:3: ruleIntegerTerm
            {
             before(grammarAccess.getQuantityAttributeAccess().getInitValueIntegerTermParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleIntegerTerm();

            state._fsp--;

             after(grammarAccess.getQuantityAttributeAccess().getInitValueIntegerTermParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__InitValueAssignment_3"


    // $ANTLR start "rule__QuantityAttribute__SettingAssignment_4_1"
    // InternalStoryGen.g:5769:1: rule__QuantityAttribute__SettingAssignment_4_1 : ( ruleAttributeSetting ) ;
    public final void rule__QuantityAttribute__SettingAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5773:1: ( ( ruleAttributeSetting ) )
            // InternalStoryGen.g:5774:2: ( ruleAttributeSetting )
            {
            // InternalStoryGen.g:5774:2: ( ruleAttributeSetting )
            // InternalStoryGen.g:5775:3: ruleAttributeSetting
            {
             before(grammarAccess.getQuantityAttributeAccess().getSettingAttributeSettingParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeSetting();

            state._fsp--;

             after(grammarAccess.getQuantityAttributeAccess().getSettingAttributeSettingParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QuantityAttribute__SettingAssignment_4_1"


    // $ANTLR start "rule__AttributeSetting__PositiveAssignment_0_0"
    // InternalStoryGen.g:5784:1: rule__AttributeSetting__PositiveAssignment_0_0 : ( ( 'increments' ) ) ;
    public final void rule__AttributeSetting__PositiveAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5788:1: ( ( ( 'increments' ) ) )
            // InternalStoryGen.g:5789:2: ( ( 'increments' ) )
            {
            // InternalStoryGen.g:5789:2: ( ( 'increments' ) )
            // InternalStoryGen.g:5790:3: ( 'increments' )
            {
             before(grammarAccess.getAttributeSettingAccess().getPositiveIncrementsKeyword_0_0_0()); 
            // InternalStoryGen.g:5791:3: ( 'increments' )
            // InternalStoryGen.g:5792:4: 'increments'
            {
             before(grammarAccess.getAttributeSettingAccess().getPositiveIncrementsKeyword_0_0_0()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getAttributeSettingAccess().getPositiveIncrementsKeyword_0_0_0()); 

            }

             after(grammarAccess.getAttributeSettingAccess().getPositiveIncrementsKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__PositiveAssignment_0_0"


    // $ANTLR start "rule__AttributeSetting__NegativeAssignment_0_1"
    // InternalStoryGen.g:5803:1: rule__AttributeSetting__NegativeAssignment_0_1 : ( ( 'decrements' ) ) ;
    public final void rule__AttributeSetting__NegativeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5807:1: ( ( ( 'decrements' ) ) )
            // InternalStoryGen.g:5808:2: ( ( 'decrements' ) )
            {
            // InternalStoryGen.g:5808:2: ( ( 'decrements' ) )
            // InternalStoryGen.g:5809:3: ( 'decrements' )
            {
             before(grammarAccess.getAttributeSettingAccess().getNegativeDecrementsKeyword_0_1_0()); 
            // InternalStoryGen.g:5810:3: ( 'decrements' )
            // InternalStoryGen.g:5811:4: 'decrements'
            {
             before(grammarAccess.getAttributeSettingAccess().getNegativeDecrementsKeyword_0_1_0()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getAttributeSettingAccess().getNegativeDecrementsKeyword_0_1_0()); 

            }

             after(grammarAccess.getAttributeSettingAccess().getNegativeDecrementsKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__NegativeAssignment_0_1"


    // $ANTLR start "rule__AttributeSetting__AmountAssignment_2"
    // InternalStoryGen.g:5822:1: rule__AttributeSetting__AmountAssignment_2 : ( RULE_INT ) ;
    public final void rule__AttributeSetting__AmountAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5826:1: ( ( RULE_INT ) )
            // InternalStoryGen.g:5827:2: ( RULE_INT )
            {
            // InternalStoryGen.g:5827:2: ( RULE_INT )
            // InternalStoryGen.g:5828:3: RULE_INT
            {
             before(grammarAccess.getAttributeSettingAccess().getAmountINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getAttributeSettingAccess().getAmountINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__AmountAssignment_2"


    // $ANTLR start "rule__AttributeSetting__FrequencyAssignment_3"
    // InternalStoryGen.g:5837:1: rule__AttributeSetting__FrequencyAssignment_3 : ( ruleAttributeSettingFrequency ) ;
    public final void rule__AttributeSetting__FrequencyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5841:1: ( ( ruleAttributeSettingFrequency ) )
            // InternalStoryGen.g:5842:2: ( ruleAttributeSettingFrequency )
            {
            // InternalStoryGen.g:5842:2: ( ruleAttributeSettingFrequency )
            // InternalStoryGen.g:5843:3: ruleAttributeSettingFrequency
            {
             before(grammarAccess.getAttributeSettingAccess().getFrequencyAttributeSettingFrequencyEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeSettingFrequency();

            state._fsp--;

             after(grammarAccess.getAttributeSettingAccess().getFrequencyAttributeSettingFrequencyEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeSetting__FrequencyAssignment_3"


    // $ANTLR start "rule__HappeningEvent__OpeningAssignment_0_0"
    // InternalStoryGen.g:5852:1: rule__HappeningEvent__OpeningAssignment_0_0 : ( ( 'opening' ) ) ;
    public final void rule__HappeningEvent__OpeningAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5856:1: ( ( ( 'opening' ) ) )
            // InternalStoryGen.g:5857:2: ( ( 'opening' ) )
            {
            // InternalStoryGen.g:5857:2: ( ( 'opening' ) )
            // InternalStoryGen.g:5858:3: ( 'opening' )
            {
             before(grammarAccess.getHappeningEventAccess().getOpeningOpeningKeyword_0_0_0()); 
            // InternalStoryGen.g:5859:3: ( 'opening' )
            // InternalStoryGen.g:5860:4: 'opening'
            {
             before(grammarAccess.getHappeningEventAccess().getOpeningOpeningKeyword_0_0_0()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getOpeningOpeningKeyword_0_0_0()); 

            }

             after(grammarAccess.getHappeningEventAccess().getOpeningOpeningKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__OpeningAssignment_0_0"


    // $ANTLR start "rule__HappeningEvent__EndingAssignment_0_1"
    // InternalStoryGen.g:5871:1: rule__HappeningEvent__EndingAssignment_0_1 : ( ( 'ending' ) ) ;
    public final void rule__HappeningEvent__EndingAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5875:1: ( ( ( 'ending' ) ) )
            // InternalStoryGen.g:5876:2: ( ( 'ending' ) )
            {
            // InternalStoryGen.g:5876:2: ( ( 'ending' ) )
            // InternalStoryGen.g:5877:3: ( 'ending' )
            {
             before(grammarAccess.getHappeningEventAccess().getEndingEndingKeyword_0_1_0()); 
            // InternalStoryGen.g:5878:3: ( 'ending' )
            // InternalStoryGen.g:5879:4: 'ending'
            {
             before(grammarAccess.getHappeningEventAccess().getEndingEndingKeyword_0_1_0()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getEndingEndingKeyword_0_1_0()); 

            }

             after(grammarAccess.getHappeningEventAccess().getEndingEndingKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__EndingAssignment_0_1"


    // $ANTLR start "rule__HappeningEvent__NameAssignment_2"
    // InternalStoryGen.g:5890:1: rule__HappeningEvent__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__HappeningEvent__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5894:1: ( ( RULE_ID ) )
            // InternalStoryGen.g:5895:2: ( RULE_ID )
            {
            // InternalStoryGen.g:5895:2: ( RULE_ID )
            // InternalStoryGen.g:5896:3: RULE_ID
            {
             before(grammarAccess.getHappeningEventAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__NameAssignment_2"


    // $ANTLR start "rule__HappeningEvent__PriorityAssignment_4_1"
    // InternalStoryGen.g:5905:1: rule__HappeningEvent__PriorityAssignment_4_1 : ( ruleEventPriority ) ;
    public final void rule__HappeningEvent__PriorityAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5909:1: ( ( ruleEventPriority ) )
            // InternalStoryGen.g:5910:2: ( ruleEventPriority )
            {
            // InternalStoryGen.g:5910:2: ( ruleEventPriority )
            // InternalStoryGen.g:5911:3: ruleEventPriority
            {
             before(grammarAccess.getHappeningEventAccess().getPriorityEventPriorityEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEventPriority();

            state._fsp--;

             after(grammarAccess.getHappeningEventAccess().getPriorityEventPriorityEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__PriorityAssignment_4_1"


    // $ANTLR start "rule__HappeningEvent__DescriptionAssignment_6"
    // InternalStoryGen.g:5920:1: rule__HappeningEvent__DescriptionAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HappeningEvent__DescriptionAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5924:1: ( ( RULE_STRING ) )
            // InternalStoryGen.g:5925:2: ( RULE_STRING )
            {
            // InternalStoryGen.g:5925:2: ( RULE_STRING )
            // InternalStoryGen.g:5926:3: RULE_STRING
            {
             before(grammarAccess.getHappeningEventAccess().getDescriptionSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getDescriptionSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__DescriptionAssignment_6"


    // $ANTLR start "rule__HappeningEvent__ShortDescriptionAssignment_7_1"
    // InternalStoryGen.g:5935:1: rule__HappeningEvent__ShortDescriptionAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__HappeningEvent__ShortDescriptionAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5939:1: ( ( RULE_STRING ) )
            // InternalStoryGen.g:5940:2: ( RULE_STRING )
            {
            // InternalStoryGen.g:5940:2: ( RULE_STRING )
            // InternalStoryGen.g:5941:3: RULE_STRING
            {
             before(grammarAccess.getHappeningEventAccess().getShortDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getShortDescriptionSTRINGTerminalRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__ShortDescriptionAssignment_7_1"


    // $ANTLR start "rule__HappeningEvent__TriggerAssignment_8_1"
    // InternalStoryGen.g:5950:1: rule__HappeningEvent__TriggerAssignment_8_1 : ( ( RULE_ID ) ) ;
    public final void rule__HappeningEvent__TriggerAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5954:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:5955:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:5955:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:5956:3: ( RULE_ID )
            {
             before(grammarAccess.getHappeningEventAccess().getTriggerEventCrossReference_8_1_0()); 
            // InternalStoryGen.g:5957:3: ( RULE_ID )
            // InternalStoryGen.g:5958:4: RULE_ID
            {
             before(grammarAccess.getHappeningEventAccess().getTriggerEventIDTerminalRuleCall_8_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getTriggerEventIDTerminalRuleCall_8_1_0_1()); 

            }

             after(grammarAccess.getHappeningEventAccess().getTriggerEventCrossReference_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__TriggerAssignment_8_1"


    // $ANTLR start "rule__HappeningEvent__MayTriggersAssignment_9_1_0"
    // InternalStoryGen.g:5969:1: rule__HappeningEvent__MayTriggersAssignment_9_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__HappeningEvent__MayTriggersAssignment_9_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5973:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:5974:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:5974:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:5975:3: ( RULE_ID )
            {
             before(grammarAccess.getHappeningEventAccess().getMayTriggersEventCrossReference_9_1_0_0()); 
            // InternalStoryGen.g:5976:3: ( RULE_ID )
            // InternalStoryGen.g:5977:4: RULE_ID
            {
             before(grammarAccess.getHappeningEventAccess().getMayTriggersEventIDTerminalRuleCall_9_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getMayTriggersEventIDTerminalRuleCall_9_1_0_0_1()); 

            }

             after(grammarAccess.getHappeningEventAccess().getMayTriggersEventCrossReference_9_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__MayTriggersAssignment_9_1_0"


    // $ANTLR start "rule__HappeningEvent__MayTriggersAssignment_9_2"
    // InternalStoryGen.g:5988:1: rule__HappeningEvent__MayTriggersAssignment_9_2 : ( ( RULE_ID ) ) ;
    public final void rule__HappeningEvent__MayTriggersAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:5992:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:5993:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:5993:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:5994:3: ( RULE_ID )
            {
             before(grammarAccess.getHappeningEventAccess().getMayTriggersEventCrossReference_9_2_0()); 
            // InternalStoryGen.g:5995:3: ( RULE_ID )
            // InternalStoryGen.g:5996:4: RULE_ID
            {
             before(grammarAccess.getHappeningEventAccess().getMayTriggersEventIDTerminalRuleCall_9_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHappeningEventAccess().getMayTriggersEventIDTerminalRuleCall_9_2_0_1()); 

            }

             after(grammarAccess.getHappeningEventAccess().getMayTriggersEventCrossReference_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__MayTriggersAssignment_9_2"


    // $ANTLR start "rule__HappeningEvent__ConditionsAssignment_10"
    // InternalStoryGen.g:6007:1: rule__HappeningEvent__ConditionsAssignment_10 : ( ruleCondition ) ;
    public final void rule__HappeningEvent__ConditionsAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6011:1: ( ( ruleCondition ) )
            // InternalStoryGen.g:6012:2: ( ruleCondition )
            {
            // InternalStoryGen.g:6012:2: ( ruleCondition )
            // InternalStoryGen.g:6013:3: ruleCondition
            {
             before(grammarAccess.getHappeningEventAccess().getConditionsConditionParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getHappeningEventAccess().getConditionsConditionParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__ConditionsAssignment_10"


    // $ANTLR start "rule__HappeningEvent__ChangesAssignment_11"
    // InternalStoryGen.g:6022:1: rule__HappeningEvent__ChangesAssignment_11 : ( ruleChange ) ;
    public final void rule__HappeningEvent__ChangesAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6026:1: ( ( ruleChange ) )
            // InternalStoryGen.g:6027:2: ( ruleChange )
            {
            // InternalStoryGen.g:6027:2: ( ruleChange )
            // InternalStoryGen.g:6028:3: ruleChange
            {
             before(grammarAccess.getHappeningEventAccess().getChangesChangeParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleChange();

            state._fsp--;

             after(grammarAccess.getHappeningEventAccess().getChangesChangeParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HappeningEvent__ChangesAssignment_11"


    // $ANTLR start "rule__ActionEvent__NameAssignment_1"
    // InternalStoryGen.g:6037:1: rule__ActionEvent__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ActionEvent__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6041:1: ( ( RULE_ID ) )
            // InternalStoryGen.g:6042:2: ( RULE_ID )
            {
            // InternalStoryGen.g:6042:2: ( RULE_ID )
            // InternalStoryGen.g:6043:3: RULE_ID
            {
             before(grammarAccess.getActionEventAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__NameAssignment_1"


    // $ANTLR start "rule__ActionEvent__PriorityAssignment_3_1"
    // InternalStoryGen.g:6052:1: rule__ActionEvent__PriorityAssignment_3_1 : ( ruleEventPriority ) ;
    public final void rule__ActionEvent__PriorityAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6056:1: ( ( ruleEventPriority ) )
            // InternalStoryGen.g:6057:2: ( ruleEventPriority )
            {
            // InternalStoryGen.g:6057:2: ( ruleEventPriority )
            // InternalStoryGen.g:6058:3: ruleEventPriority
            {
             before(grammarAccess.getActionEventAccess().getPriorityEventPriorityEnumRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEventPriority();

            state._fsp--;

             after(grammarAccess.getActionEventAccess().getPriorityEventPriorityEnumRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__PriorityAssignment_3_1"


    // $ANTLR start "rule__ActionEvent__TypeAssignment_5"
    // InternalStoryGen.g:6067:1: rule__ActionEvent__TypeAssignment_5 : ( ruleActionType ) ;
    public final void rule__ActionEvent__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6071:1: ( ( ruleActionType ) )
            // InternalStoryGen.g:6072:2: ( ruleActionType )
            {
            // InternalStoryGen.g:6072:2: ( ruleActionType )
            // InternalStoryGen.g:6073:3: ruleActionType
            {
             before(grammarAccess.getActionEventAccess().getTypeActionTypeEnumRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleActionType();

            state._fsp--;

             after(grammarAccess.getActionEventAccess().getTypeActionTypeEnumRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__TypeAssignment_5"


    // $ANTLR start "rule__ActionEvent__DescriptionAssignment_7"
    // InternalStoryGen.g:6082:1: rule__ActionEvent__DescriptionAssignment_7 : ( RULE_STRING ) ;
    public final void rule__ActionEvent__DescriptionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6086:1: ( ( RULE_STRING ) )
            // InternalStoryGen.g:6087:2: ( RULE_STRING )
            {
            // InternalStoryGen.g:6087:2: ( RULE_STRING )
            // InternalStoryGen.g:6088:3: RULE_STRING
            {
             before(grammarAccess.getActionEventAccess().getDescriptionSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getDescriptionSTRINGTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__DescriptionAssignment_7"


    // $ANTLR start "rule__ActionEvent__ShortDescriptionAssignment_8_1"
    // InternalStoryGen.g:6097:1: rule__ActionEvent__ShortDescriptionAssignment_8_1 : ( RULE_STRING ) ;
    public final void rule__ActionEvent__ShortDescriptionAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6101:1: ( ( RULE_STRING ) )
            // InternalStoryGen.g:6102:2: ( RULE_STRING )
            {
            // InternalStoryGen.g:6102:2: ( RULE_STRING )
            // InternalStoryGen.g:6103:3: RULE_STRING
            {
             before(grammarAccess.getActionEventAccess().getShortDescriptionSTRINGTerminalRuleCall_8_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getShortDescriptionSTRINGTerminalRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__ShortDescriptionAssignment_8_1"


    // $ANTLR start "rule__ActionEvent__ActorAssignment_10"
    // InternalStoryGen.g:6112:1: rule__ActionEvent__ActorAssignment_10 : ( ( RULE_ID ) ) ;
    public final void rule__ActionEvent__ActorAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6116:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6117:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6117:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6118:3: ( RULE_ID )
            {
             before(grammarAccess.getActionEventAccess().getActorActorCrossReference_10_0()); 
            // InternalStoryGen.g:6119:3: ( RULE_ID )
            // InternalStoryGen.g:6120:4: RULE_ID
            {
             before(grammarAccess.getActionEventAccess().getActorActorIDTerminalRuleCall_10_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getActorActorIDTerminalRuleCall_10_0_1()); 

            }

             after(grammarAccess.getActionEventAccess().getActorActorCrossReference_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__ActorAssignment_10"


    // $ANTLR start "rule__ActionEvent__TriggerAssignment_11_1"
    // InternalStoryGen.g:6131:1: rule__ActionEvent__TriggerAssignment_11_1 : ( ( RULE_ID ) ) ;
    public final void rule__ActionEvent__TriggerAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6135:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6136:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6136:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6137:3: ( RULE_ID )
            {
             before(grammarAccess.getActionEventAccess().getTriggerEventCrossReference_11_1_0()); 
            // InternalStoryGen.g:6138:3: ( RULE_ID )
            // InternalStoryGen.g:6139:4: RULE_ID
            {
             before(grammarAccess.getActionEventAccess().getTriggerEventIDTerminalRuleCall_11_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getTriggerEventIDTerminalRuleCall_11_1_0_1()); 

            }

             after(grammarAccess.getActionEventAccess().getTriggerEventCrossReference_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__TriggerAssignment_11_1"


    // $ANTLR start "rule__ActionEvent__MayTriggersAssignment_12_1_0"
    // InternalStoryGen.g:6150:1: rule__ActionEvent__MayTriggersAssignment_12_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__ActionEvent__MayTriggersAssignment_12_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6154:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6155:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6155:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6156:3: ( RULE_ID )
            {
             before(grammarAccess.getActionEventAccess().getMayTriggersEventCrossReference_12_1_0_0()); 
            // InternalStoryGen.g:6157:3: ( RULE_ID )
            // InternalStoryGen.g:6158:4: RULE_ID
            {
             before(grammarAccess.getActionEventAccess().getMayTriggersEventIDTerminalRuleCall_12_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getMayTriggersEventIDTerminalRuleCall_12_1_0_0_1()); 

            }

             after(grammarAccess.getActionEventAccess().getMayTriggersEventCrossReference_12_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__MayTriggersAssignment_12_1_0"


    // $ANTLR start "rule__ActionEvent__MayTriggersAssignment_12_2"
    // InternalStoryGen.g:6169:1: rule__ActionEvent__MayTriggersAssignment_12_2 : ( ( RULE_ID ) ) ;
    public final void rule__ActionEvent__MayTriggersAssignment_12_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6173:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6174:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6174:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6175:3: ( RULE_ID )
            {
             before(grammarAccess.getActionEventAccess().getMayTriggersEventCrossReference_12_2_0()); 
            // InternalStoryGen.g:6176:3: ( RULE_ID )
            // InternalStoryGen.g:6177:4: RULE_ID
            {
             before(grammarAccess.getActionEventAccess().getMayTriggersEventIDTerminalRuleCall_12_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getActionEventAccess().getMayTriggersEventIDTerminalRuleCall_12_2_0_1()); 

            }

             after(grammarAccess.getActionEventAccess().getMayTriggersEventCrossReference_12_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__MayTriggersAssignment_12_2"


    // $ANTLR start "rule__ActionEvent__ConditionsAssignment_13"
    // InternalStoryGen.g:6188:1: rule__ActionEvent__ConditionsAssignment_13 : ( ruleCondition ) ;
    public final void rule__ActionEvent__ConditionsAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6192:1: ( ( ruleCondition ) )
            // InternalStoryGen.g:6193:2: ( ruleCondition )
            {
            // InternalStoryGen.g:6193:2: ( ruleCondition )
            // InternalStoryGen.g:6194:3: ruleCondition
            {
             before(grammarAccess.getActionEventAccess().getConditionsConditionParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getActionEventAccess().getConditionsConditionParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__ConditionsAssignment_13"


    // $ANTLR start "rule__ActionEvent__ChangesAssignment_14"
    // InternalStoryGen.g:6203:1: rule__ActionEvent__ChangesAssignment_14 : ( ruleChange ) ;
    public final void rule__ActionEvent__ChangesAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6207:1: ( ( ruleChange ) )
            // InternalStoryGen.g:6208:2: ( ruleChange )
            {
            // InternalStoryGen.g:6208:2: ( ruleChange )
            // InternalStoryGen.g:6209:3: ruleChange
            {
             before(grammarAccess.getActionEventAccess().getChangesChangeParserRuleCall_14_0()); 
            pushFollow(FOLLOW_2);
            ruleChange();

            state._fsp--;

             after(grammarAccess.getActionEventAccess().getChangesChangeParserRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ActionEvent__ChangesAssignment_14"


    // $ANTLR start "rule__ExpressionCondition__ExpAssignment_1"
    // InternalStoryGen.g:6218:1: rule__ExpressionCondition__ExpAssignment_1 : ( ruleExpression ) ;
    public final void rule__ExpressionCondition__ExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6222:1: ( ( ruleExpression ) )
            // InternalStoryGen.g:6223:2: ( ruleExpression )
            {
            // InternalStoryGen.g:6223:2: ( ruleExpression )
            // InternalStoryGen.g:6224:3: ruleExpression
            {
             before(grammarAccess.getExpressionConditionAccess().getExpExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionConditionAccess().getExpExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionCondition__ExpAssignment_1"


    // $ANTLR start "rule__OrderCondition__OrderAssignment_1"
    // InternalStoryGen.g:6233:1: rule__OrderCondition__OrderAssignment_1 : ( ruleOrder ) ;
    public final void rule__OrderCondition__OrderAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6237:1: ( ( ruleOrder ) )
            // InternalStoryGen.g:6238:2: ( ruleOrder )
            {
            // InternalStoryGen.g:6238:2: ( ruleOrder )
            // InternalStoryGen.g:6239:3: ruleOrder
            {
             before(grammarAccess.getOrderConditionAccess().getOrderOrderEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOrder();

            state._fsp--;

             after(grammarAccess.getOrderConditionAccess().getOrderOrderEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderCondition__OrderAssignment_1"


    // $ANTLR start "rule__OrderCondition__EventAssignment_2"
    // InternalStoryGen.g:6248:1: rule__OrderCondition__EventAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__OrderCondition__EventAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6252:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6253:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6253:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6254:3: ( RULE_ID )
            {
             before(grammarAccess.getOrderConditionAccess().getEventEventCrossReference_2_0()); 
            // InternalStoryGen.g:6255:3: ( RULE_ID )
            // InternalStoryGen.g:6256:4: RULE_ID
            {
             before(grammarAccess.getOrderConditionAccess().getEventEventIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOrderConditionAccess().getEventEventIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getOrderConditionAccess().getEventEventCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderCondition__EventAssignment_2"


    // $ANTLR start "rule__TriggerCondition__TriggerAssignment_1"
    // InternalStoryGen.g:6267:1: rule__TriggerCondition__TriggerAssignment_1 : ( ( 'be-triggered' ) ) ;
    public final void rule__TriggerCondition__TriggerAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6271:1: ( ( ( 'be-triggered' ) ) )
            // InternalStoryGen.g:6272:2: ( ( 'be-triggered' ) )
            {
            // InternalStoryGen.g:6272:2: ( ( 'be-triggered' ) )
            // InternalStoryGen.g:6273:3: ( 'be-triggered' )
            {
             before(grammarAccess.getTriggerConditionAccess().getTriggerBeTriggeredKeyword_1_0()); 
            // InternalStoryGen.g:6274:3: ( 'be-triggered' )
            // InternalStoryGen.g:6275:4: 'be-triggered'
            {
             before(grammarAccess.getTriggerConditionAccess().getTriggerBeTriggeredKeyword_1_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getTriggerConditionAccess().getTriggerBeTriggeredKeyword_1_0()); 

            }

             after(grammarAccess.getTriggerConditionAccess().getTriggerBeTriggeredKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TriggerCondition__TriggerAssignment_1"


    // $ANTLR start "rule__ExistentChange__ExistentAssignment_1"
    // InternalStoryGen.g:6286:1: rule__ExistentChange__ExistentAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ExistentChange__ExistentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6290:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6291:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6291:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6292:3: ( RULE_ID )
            {
             before(grammarAccess.getExistentChangeAccess().getExistentExistentCrossReference_1_0()); 
            // InternalStoryGen.g:6293:3: ( RULE_ID )
            // InternalStoryGen.g:6294:4: RULE_ID
            {
             before(grammarAccess.getExistentChangeAccess().getExistentExistentIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExistentChangeAccess().getExistentExistentIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getExistentChangeAccess().getExistentExistentCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__ExistentAssignment_1"


    // $ANTLR start "rule__ExistentChange__AttributeAssignment_3"
    // InternalStoryGen.g:6305:1: rule__ExistentChange__AttributeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ExistentChange__AttributeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6309:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6310:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6310:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6311:3: ( RULE_ID )
            {
             before(grammarAccess.getExistentChangeAccess().getAttributeAttributeCrossReference_3_0()); 
            // InternalStoryGen.g:6312:3: ( RULE_ID )
            // InternalStoryGen.g:6313:4: RULE_ID
            {
             before(grammarAccess.getExistentChangeAccess().getAttributeAttributeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExistentChangeAccess().getAttributeAttributeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getExistentChangeAccess().getAttributeAttributeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__AttributeAssignment_3"


    // $ANTLR start "rule__ExistentChange__OpAssignment_4"
    // InternalStoryGen.g:6324:1: rule__ExistentChange__OpAssignment_4 : ( ruleAttributionOperator ) ;
    public final void rule__ExistentChange__OpAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6328:1: ( ( ruleAttributionOperator ) )
            // InternalStoryGen.g:6329:2: ( ruleAttributionOperator )
            {
            // InternalStoryGen.g:6329:2: ( ruleAttributionOperator )
            // InternalStoryGen.g:6330:3: ruleAttributionOperator
            {
             before(grammarAccess.getExistentChangeAccess().getOpAttributionOperatorEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributionOperator();

            state._fsp--;

             after(grammarAccess.getExistentChangeAccess().getOpAttributionOperatorEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__OpAssignment_4"


    // $ANTLR start "rule__ExistentChange__TermAssignment_5"
    // InternalStoryGen.g:6339:1: rule__ExistentChange__TermAssignment_5 : ( ( rule__ExistentChange__TermAlternatives_5_0 ) ) ;
    public final void rule__ExistentChange__TermAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6343:1: ( ( ( rule__ExistentChange__TermAlternatives_5_0 ) ) )
            // InternalStoryGen.g:6344:2: ( ( rule__ExistentChange__TermAlternatives_5_0 ) )
            {
            // InternalStoryGen.g:6344:2: ( ( rule__ExistentChange__TermAlternatives_5_0 ) )
            // InternalStoryGen.g:6345:3: ( rule__ExistentChange__TermAlternatives_5_0 )
            {
             before(grammarAccess.getExistentChangeAccess().getTermAlternatives_5_0()); 
            // InternalStoryGen.g:6346:3: ( rule__ExistentChange__TermAlternatives_5_0 )
            // InternalStoryGen.g:6346:4: rule__ExistentChange__TermAlternatives_5_0
            {
            pushFollow(FOLLOW_2);
            rule__ExistentChange__TermAlternatives_5_0();

            state._fsp--;


            }

             after(grammarAccess.getExistentChangeAccess().getTermAlternatives_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentChange__TermAssignment_5"


    // $ANTLR start "rule__StoryDataChange__AttributeAssignment_3"
    // InternalStoryGen.g:6354:1: rule__StoryDataChange__AttributeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__StoryDataChange__AttributeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6358:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6359:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6359:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6360:3: ( RULE_ID )
            {
             before(grammarAccess.getStoryDataChangeAccess().getAttributeAttributeCrossReference_3_0()); 
            // InternalStoryGen.g:6361:3: ( RULE_ID )
            // InternalStoryGen.g:6362:4: RULE_ID
            {
             before(grammarAccess.getStoryDataChangeAccess().getAttributeAttributeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getStoryDataChangeAccess().getAttributeAttributeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getStoryDataChangeAccess().getAttributeAttributeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__AttributeAssignment_3"


    // $ANTLR start "rule__StoryDataChange__OpAssignment_4"
    // InternalStoryGen.g:6373:1: rule__StoryDataChange__OpAssignment_4 : ( ruleAttributionOperator ) ;
    public final void rule__StoryDataChange__OpAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6377:1: ( ( ruleAttributionOperator ) )
            // InternalStoryGen.g:6378:2: ( ruleAttributionOperator )
            {
            // InternalStoryGen.g:6378:2: ( ruleAttributionOperator )
            // InternalStoryGen.g:6379:3: ruleAttributionOperator
            {
             before(grammarAccess.getStoryDataChangeAccess().getOpAttributionOperatorEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributionOperator();

            state._fsp--;

             after(grammarAccess.getStoryDataChangeAccess().getOpAttributionOperatorEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__OpAssignment_4"


    // $ANTLR start "rule__StoryDataChange__TermAssignment_5"
    // InternalStoryGen.g:6388:1: rule__StoryDataChange__TermAssignment_5 : ( ( rule__StoryDataChange__TermAlternatives_5_0 ) ) ;
    public final void rule__StoryDataChange__TermAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6392:1: ( ( ( rule__StoryDataChange__TermAlternatives_5_0 ) ) )
            // InternalStoryGen.g:6393:2: ( ( rule__StoryDataChange__TermAlternatives_5_0 ) )
            {
            // InternalStoryGen.g:6393:2: ( ( rule__StoryDataChange__TermAlternatives_5_0 ) )
            // InternalStoryGen.g:6394:3: ( rule__StoryDataChange__TermAlternatives_5_0 )
            {
             before(grammarAccess.getStoryDataChangeAccess().getTermAlternatives_5_0()); 
            // InternalStoryGen.g:6395:3: ( rule__StoryDataChange__TermAlternatives_5_0 )
            // InternalStoryGen.g:6395:4: rule__StoryDataChange__TermAlternatives_5_0
            {
            pushFollow(FOLLOW_2);
            rule__StoryDataChange__TermAlternatives_5_0();

            state._fsp--;


            }

             after(grammarAccess.getStoryDataChangeAccess().getTermAlternatives_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryDataChange__TermAssignment_5"


    // $ANTLR start "rule__BinaryExpression__OperandsAssignment_1_0_2"
    // InternalStoryGen.g:6403:1: rule__BinaryExpression__OperandsAssignment_1_0_2 : ( ruleUnitExpression ) ;
    public final void rule__BinaryExpression__OperandsAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6407:1: ( ( ruleUnitExpression ) )
            // InternalStoryGen.g:6408:2: ( ruleUnitExpression )
            {
            // InternalStoryGen.g:6408:2: ( ruleUnitExpression )
            // InternalStoryGen.g:6409:3: ruleUnitExpression
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleUnitExpression();

            state._fsp--;

             after(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__OperandsAssignment_1_0_2"


    // $ANTLR start "rule__BinaryExpression__OperandsAssignment_1_0_3_1"
    // InternalStoryGen.g:6418:1: rule__BinaryExpression__OperandsAssignment_1_0_3_1 : ( ruleUnitExpression ) ;
    public final void rule__BinaryExpression__OperandsAssignment_1_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6422:1: ( ( ruleUnitExpression ) )
            // InternalStoryGen.g:6423:2: ( ruleUnitExpression )
            {
            // InternalStoryGen.g:6423:2: ( ruleUnitExpression )
            // InternalStoryGen.g:6424:3: ruleUnitExpression
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_0_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUnitExpression();

            state._fsp--;

             after(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__OperandsAssignment_1_0_3_1"


    // $ANTLR start "rule__BinaryExpression__OperandsAssignment_1_1_2"
    // InternalStoryGen.g:6433:1: rule__BinaryExpression__OperandsAssignment_1_1_2 : ( ruleUnitExpression ) ;
    public final void rule__BinaryExpression__OperandsAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6437:1: ( ( ruleUnitExpression ) )
            // InternalStoryGen.g:6438:2: ( ruleUnitExpression )
            {
            // InternalStoryGen.g:6438:2: ( ruleUnitExpression )
            // InternalStoryGen.g:6439:3: ruleUnitExpression
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleUnitExpression();

            state._fsp--;

             after(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__OperandsAssignment_1_1_2"


    // $ANTLR start "rule__BinaryExpression__OperandsAssignment_1_1_3_1"
    // InternalStoryGen.g:6448:1: rule__BinaryExpression__OperandsAssignment_1_1_3_1 : ( ruleUnitExpression ) ;
    public final void rule__BinaryExpression__OperandsAssignment_1_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6452:1: ( ( ruleUnitExpression ) )
            // InternalStoryGen.g:6453:2: ( ruleUnitExpression )
            {
            // InternalStoryGen.g:6453:2: ( ruleUnitExpression )
            // InternalStoryGen.g:6454:3: ruleUnitExpression
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_1_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUnitExpression();

            state._fsp--;

             after(grammarAccess.getBinaryExpressionAccess().getOperandsUnitExpressionParserRuleCall_1_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__OperandsAssignment_1_1_3_1"


    // $ANTLR start "rule__BinaryExpression__OperatorAssignment_1_2_1"
    // InternalStoryGen.g:6463:1: rule__BinaryExpression__OperatorAssignment_1_2_1 : ( ruleComparisonOperator ) ;
    public final void rule__BinaryExpression__OperatorAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6467:1: ( ( ruleComparisonOperator ) )
            // InternalStoryGen.g:6468:2: ( ruleComparisonOperator )
            {
            // InternalStoryGen.g:6468:2: ( ruleComparisonOperator )
            // InternalStoryGen.g:6469:3: ruleComparisonOperator
            {
             before(grammarAccess.getBinaryExpressionAccess().getOperatorComparisonOperatorEnumRuleCall_1_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonOperator();

            state._fsp--;

             after(grammarAccess.getBinaryExpressionAccess().getOperatorComparisonOperatorEnumRuleCall_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__OperatorAssignment_1_2_1"


    // $ANTLR start "rule__BinaryExpression__RightAssignment_1_2_2"
    // InternalStoryGen.g:6478:1: rule__BinaryExpression__RightAssignment_1_2_2 : ( ruleUnitExpression ) ;
    public final void rule__BinaryExpression__RightAssignment_1_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6482:1: ( ( ruleUnitExpression ) )
            // InternalStoryGen.g:6483:2: ( ruleUnitExpression )
            {
            // InternalStoryGen.g:6483:2: ( ruleUnitExpression )
            // InternalStoryGen.g:6484:3: ruleUnitExpression
            {
             before(grammarAccess.getBinaryExpressionAccess().getRightUnitExpressionParserRuleCall_1_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleUnitExpression();

            state._fsp--;

             after(grammarAccess.getBinaryExpressionAccess().getRightUnitExpressionParserRuleCall_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryExpression__RightAssignment_1_2_2"


    // $ANTLR start "rule__NegationExpression__OperandAssignment_2"
    // InternalStoryGen.g:6493:1: rule__NegationExpression__OperandAssignment_2 : ( ruleUnitExpression ) ;
    public final void rule__NegationExpression__OperandAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6497:1: ( ( ruleUnitExpression ) )
            // InternalStoryGen.g:6498:2: ( ruleUnitExpression )
            {
            // InternalStoryGen.g:6498:2: ( ruleUnitExpression )
            // InternalStoryGen.g:6499:3: ruleUnitExpression
            {
             before(grammarAccess.getNegationExpressionAccess().getOperandUnitExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleUnitExpression();

            state._fsp--;

             after(grammarAccess.getNegationExpressionAccess().getOperandUnitExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegationExpression__OperandAssignment_2"


    // $ANTLR start "rule__ExistentAttributeTerm__ExistentAssignment_0"
    // InternalStoryGen.g:6508:1: rule__ExistentAttributeTerm__ExistentAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ExistentAttributeTerm__ExistentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6512:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6513:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6513:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6514:3: ( RULE_ID )
            {
             before(grammarAccess.getExistentAttributeTermAccess().getExistentExistentCrossReference_0_0()); 
            // InternalStoryGen.g:6515:3: ( RULE_ID )
            // InternalStoryGen.g:6516:4: RULE_ID
            {
             before(grammarAccess.getExistentAttributeTermAccess().getExistentExistentIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExistentAttributeTermAccess().getExistentExistentIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getExistentAttributeTermAccess().getExistentExistentCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentAttributeTerm__ExistentAssignment_0"


    // $ANTLR start "rule__ExistentAttributeTerm__AttributeAssignment_2"
    // InternalStoryGen.g:6527:1: rule__ExistentAttributeTerm__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ExistentAttributeTerm__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6531:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6532:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6532:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6533:3: ( RULE_ID )
            {
             before(grammarAccess.getExistentAttributeTermAccess().getAttributeAttributeCrossReference_2_0()); 
            // InternalStoryGen.g:6534:3: ( RULE_ID )
            // InternalStoryGen.g:6535:4: RULE_ID
            {
             before(grammarAccess.getExistentAttributeTermAccess().getAttributeAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExistentAttributeTermAccess().getAttributeAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getExistentAttributeTermAccess().getAttributeAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExistentAttributeTerm__AttributeAssignment_2"


    // $ANTLR start "rule__StoryAttributeTerm__AttributeAssignment_2"
    // InternalStoryGen.g:6546:1: rule__StoryAttributeTerm__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__StoryAttributeTerm__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6550:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:6551:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:6551:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:6552:3: ( RULE_ID )
            {
             before(grammarAccess.getStoryAttributeTermAccess().getAttributeAttributeCrossReference_2_0()); 
            // InternalStoryGen.g:6553:3: ( RULE_ID )
            // InternalStoryGen.g:6554:4: RULE_ID
            {
             before(grammarAccess.getStoryAttributeTermAccess().getAttributeAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getStoryAttributeTermAccess().getAttributeAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getStoryAttributeTermAccess().getAttributeAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StoryAttributeTerm__AttributeAssignment_2"


    // $ANTLR start "rule__IntegerTerm__ValueAssignment"
    // InternalStoryGen.g:6565:1: rule__IntegerTerm__ValueAssignment : ( RULE_INT ) ;
    public final void rule__IntegerTerm__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6569:1: ( ( RULE_INT ) )
            // InternalStoryGen.g:6570:2: ( RULE_INT )
            {
            // InternalStoryGen.g:6570:2: ( RULE_INT )
            // InternalStoryGen.g:6571:3: RULE_INT
            {
             before(grammarAccess.getIntegerTermAccess().getValueINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getIntegerTermAccess().getValueINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerTerm__ValueAssignment"


    // $ANTLR start "rule__BooleanTerm__ValueAssignment"
    // InternalStoryGen.g:6580:1: rule__BooleanTerm__ValueAssignment : ( ( rule__BooleanTerm__ValueAlternatives_0 ) ) ;
    public final void rule__BooleanTerm__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:6584:1: ( ( ( rule__BooleanTerm__ValueAlternatives_0 ) ) )
            // InternalStoryGen.g:6585:2: ( ( rule__BooleanTerm__ValueAlternatives_0 ) )
            {
            // InternalStoryGen.g:6585:2: ( ( rule__BooleanTerm__ValueAlternatives_0 ) )
            // InternalStoryGen.g:6586:3: ( rule__BooleanTerm__ValueAlternatives_0 )
            {
             before(grammarAccess.getBooleanTermAccess().getValueAlternatives_0()); 
            // InternalStoryGen.g:6587:3: ( rule__BooleanTerm__ValueAlternatives_0 )
            // InternalStoryGen.g:6587:4: rule__BooleanTerm__ValueAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanTerm__ValueAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanTermAccess().getValueAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanTerm__ValueAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0002410000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0002400000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000290000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000280000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x1020010000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x1020000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000800000001800L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000802000001850L,0x0000000000000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000003C0000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x8700010000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001C00000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x2080000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000000000007E000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x4100000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x8600010000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000001840L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000001F80000L,0x000000000000000CL});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});

}