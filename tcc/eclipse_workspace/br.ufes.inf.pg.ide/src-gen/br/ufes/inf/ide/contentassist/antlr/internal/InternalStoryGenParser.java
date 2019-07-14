package br.ufes.inf.ide.contentassist.antlr.internal;

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
import br.ufes.inf.services.StoryGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStoryGenParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'fact'", "'quantity'", "'true'", "'false'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'and'", "'or'", "'World'", "'{'", "'}'", "'event'", "'is'", "'requires'", "'('", "')'", "'not'", "'abstract'"
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


    // $ANTLR start "entryRuleWorld"
    // InternalStoryGen.g:78:1: entryRuleWorld : ruleWorld EOF ;
    public final void entryRuleWorld() throws RecognitionException {
        try {
            // InternalStoryGen.g:79:1: ( ruleWorld EOF )
            // InternalStoryGen.g:80:1: ruleWorld EOF
            {
             before(grammarAccess.getWorldRule()); 
            pushFollow(FOLLOW_1);
            ruleWorld();

            state._fsp--;

             after(grammarAccess.getWorldRule()); 
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
    // $ANTLR end "entryRuleWorld"


    // $ANTLR start "ruleWorld"
    // InternalStoryGen.g:87:1: ruleWorld : ( ( rule__World__Group__0 ) ) ;
    public final void ruleWorld() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:91:2: ( ( ( rule__World__Group__0 ) ) )
            // InternalStoryGen.g:92:2: ( ( rule__World__Group__0 ) )
            {
            // InternalStoryGen.g:92:2: ( ( rule__World__Group__0 ) )
            // InternalStoryGen.g:93:3: ( rule__World__Group__0 )
            {
             before(grammarAccess.getWorldAccess().getGroup()); 
            // InternalStoryGen.g:94:3: ( rule__World__Group__0 )
            // InternalStoryGen.g:94:4: rule__World__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__World__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorldAccess().getGroup()); 

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
    // $ANTLR end "ruleWorld"


    // $ANTLR start "entryRuleAttribute"
    // InternalStoryGen.g:103:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalStoryGen.g:104:1: ( ruleAttribute EOF )
            // InternalStoryGen.g:105:1: ruleAttribute EOF
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
    // InternalStoryGen.g:112:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:116:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalStoryGen.g:117:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalStoryGen.g:117:2: ( ( rule__Attribute__Group__0 ) )
            // InternalStoryGen.g:118:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalStoryGen.g:119:3: ( rule__Attribute__Group__0 )
            // InternalStoryGen.g:119:4: rule__Attribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

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


    // $ANTLR start "entryRuleEvent"
    // InternalStoryGen.g:128:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // InternalStoryGen.g:129:1: ( ruleEvent EOF )
            // InternalStoryGen.g:130:1: ruleEvent EOF
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
    // InternalStoryGen.g:137:1: ruleEvent : ( ( rule__Event__Group__0 ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:141:2: ( ( ( rule__Event__Group__0 ) ) )
            // InternalStoryGen.g:142:2: ( ( rule__Event__Group__0 ) )
            {
            // InternalStoryGen.g:142:2: ( ( rule__Event__Group__0 ) )
            // InternalStoryGen.g:143:3: ( rule__Event__Group__0 )
            {
             before(grammarAccess.getEventAccess().getGroup()); 
            // InternalStoryGen.g:144:3: ( rule__Event__Group__0 )
            // InternalStoryGen.g:144:4: rule__Event__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Event__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getGroup()); 

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


    // $ANTLR start "entryRuleCondition"
    // InternalStoryGen.g:153:1: entryRuleCondition : ruleCondition EOF ;
    public final void entryRuleCondition() throws RecognitionException {
        try {
            // InternalStoryGen.g:154:1: ( ruleCondition EOF )
            // InternalStoryGen.g:155:1: ruleCondition EOF
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
    // InternalStoryGen.g:162:1: ruleCondition : ( ( rule__Condition__Group__0 ) ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:166:2: ( ( ( rule__Condition__Group__0 ) ) )
            // InternalStoryGen.g:167:2: ( ( rule__Condition__Group__0 ) )
            {
            // InternalStoryGen.g:167:2: ( ( rule__Condition__Group__0 ) )
            // InternalStoryGen.g:168:3: ( rule__Condition__Group__0 )
            {
             before(grammarAccess.getConditionAccess().getGroup()); 
            // InternalStoryGen.g:169:3: ( rule__Condition__Group__0 )
            // InternalStoryGen.g:169:4: rule__Condition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getGroup()); 

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


    // $ANTLR start "entryRuleBoolExp"
    // InternalStoryGen.g:178:1: entryRuleBoolExp : ruleBoolExp EOF ;
    public final void entryRuleBoolExp() throws RecognitionException {
        try {
            // InternalStoryGen.g:179:1: ( ruleBoolExp EOF )
            // InternalStoryGen.g:180:1: ruleBoolExp EOF
            {
             before(grammarAccess.getBoolExpRule()); 
            pushFollow(FOLLOW_1);
            ruleBoolExp();

            state._fsp--;

             after(grammarAccess.getBoolExpRule()); 
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
    // $ANTLR end "entryRuleBoolExp"


    // $ANTLR start "ruleBoolExp"
    // InternalStoryGen.g:187:1: ruleBoolExp : ( ( rule__BoolExp__Alternatives ) ) ;
    public final void ruleBoolExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:191:2: ( ( ( rule__BoolExp__Alternatives ) ) )
            // InternalStoryGen.g:192:2: ( ( rule__BoolExp__Alternatives ) )
            {
            // InternalStoryGen.g:192:2: ( ( rule__BoolExp__Alternatives ) )
            // InternalStoryGen.g:193:3: ( rule__BoolExp__Alternatives )
            {
             before(grammarAccess.getBoolExpAccess().getAlternatives()); 
            // InternalStoryGen.g:194:3: ( rule__BoolExp__Alternatives )
            // InternalStoryGen.g:194:4: rule__BoolExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BoolExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBoolExpAccess().getAlternatives()); 

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
    // $ANTLR end "ruleBoolExp"


    // $ANTLR start "entryRuleBinaryBoolExp"
    // InternalStoryGen.g:203:1: entryRuleBinaryBoolExp : ruleBinaryBoolExp EOF ;
    public final void entryRuleBinaryBoolExp() throws RecognitionException {
        try {
            // InternalStoryGen.g:204:1: ( ruleBinaryBoolExp EOF )
            // InternalStoryGen.g:205:1: ruleBinaryBoolExp EOF
            {
             before(grammarAccess.getBinaryBoolExpRule()); 
            pushFollow(FOLLOW_1);
            ruleBinaryBoolExp();

            state._fsp--;

             after(grammarAccess.getBinaryBoolExpRule()); 
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
    // $ANTLR end "entryRuleBinaryBoolExp"


    // $ANTLR start "ruleBinaryBoolExp"
    // InternalStoryGen.g:212:1: ruleBinaryBoolExp : ( ( rule__BinaryBoolExp__Group__0 ) ) ;
    public final void ruleBinaryBoolExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:216:2: ( ( ( rule__BinaryBoolExp__Group__0 ) ) )
            // InternalStoryGen.g:217:2: ( ( rule__BinaryBoolExp__Group__0 ) )
            {
            // InternalStoryGen.g:217:2: ( ( rule__BinaryBoolExp__Group__0 ) )
            // InternalStoryGen.g:218:3: ( rule__BinaryBoolExp__Group__0 )
            {
             before(grammarAccess.getBinaryBoolExpAccess().getGroup()); 
            // InternalStoryGen.g:219:3: ( rule__BinaryBoolExp__Group__0 )
            // InternalStoryGen.g:219:4: rule__BinaryBoolExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BinaryBoolExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBinaryBoolExpAccess().getGroup()); 

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
    // $ANTLR end "ruleBinaryBoolExp"


    // $ANTLR start "entryRuleBinaryQntyExp"
    // InternalStoryGen.g:228:1: entryRuleBinaryQntyExp : ruleBinaryQntyExp EOF ;
    public final void entryRuleBinaryQntyExp() throws RecognitionException {
        try {
            // InternalStoryGen.g:229:1: ( ruleBinaryQntyExp EOF )
            // InternalStoryGen.g:230:1: ruleBinaryQntyExp EOF
            {
             before(grammarAccess.getBinaryQntyExpRule()); 
            pushFollow(FOLLOW_1);
            ruleBinaryQntyExp();

            state._fsp--;

             after(grammarAccess.getBinaryQntyExpRule()); 
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
    // $ANTLR end "entryRuleBinaryQntyExp"


    // $ANTLR start "ruleBinaryQntyExp"
    // InternalStoryGen.g:237:1: ruleBinaryQntyExp : ( ( rule__BinaryQntyExp__Group__0 ) ) ;
    public final void ruleBinaryQntyExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:241:2: ( ( ( rule__BinaryQntyExp__Group__0 ) ) )
            // InternalStoryGen.g:242:2: ( ( rule__BinaryQntyExp__Group__0 ) )
            {
            // InternalStoryGen.g:242:2: ( ( rule__BinaryQntyExp__Group__0 ) )
            // InternalStoryGen.g:243:3: ( rule__BinaryQntyExp__Group__0 )
            {
             before(grammarAccess.getBinaryQntyExpAccess().getGroup()); 
            // InternalStoryGen.g:244:3: ( rule__BinaryQntyExp__Group__0 )
            // InternalStoryGen.g:244:4: rule__BinaryQntyExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BinaryQntyExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBinaryQntyExpAccess().getGroup()); 

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
    // $ANTLR end "ruleBinaryQntyExp"


    // $ANTLR start "entryRuleUnaryBoolExp"
    // InternalStoryGen.g:253:1: entryRuleUnaryBoolExp : ruleUnaryBoolExp EOF ;
    public final void entryRuleUnaryBoolExp() throws RecognitionException {
        try {
            // InternalStoryGen.g:254:1: ( ruleUnaryBoolExp EOF )
            // InternalStoryGen.g:255:1: ruleUnaryBoolExp EOF
            {
             before(grammarAccess.getUnaryBoolExpRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryBoolExp();

            state._fsp--;

             after(grammarAccess.getUnaryBoolExpRule()); 
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
    // $ANTLR end "entryRuleUnaryBoolExp"


    // $ANTLR start "ruleUnaryBoolExp"
    // InternalStoryGen.g:262:1: ruleUnaryBoolExp : ( ( rule__UnaryBoolExp__Alternatives ) ) ;
    public final void ruleUnaryBoolExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:266:2: ( ( ( rule__UnaryBoolExp__Alternatives ) ) )
            // InternalStoryGen.g:267:2: ( ( rule__UnaryBoolExp__Alternatives ) )
            {
            // InternalStoryGen.g:267:2: ( ( rule__UnaryBoolExp__Alternatives ) )
            // InternalStoryGen.g:268:3: ( rule__UnaryBoolExp__Alternatives )
            {
             before(grammarAccess.getUnaryBoolExpAccess().getAlternatives()); 
            // InternalStoryGen.g:269:3: ( rule__UnaryBoolExp__Alternatives )
            // InternalStoryGen.g:269:4: rule__UnaryBoolExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__UnaryBoolExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnaryBoolExpAccess().getAlternatives()); 

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
    // $ANTLR end "ruleUnaryBoolExp"


    // $ANTLR start "entryRuleNegateBoolExp"
    // InternalStoryGen.g:278:1: entryRuleNegateBoolExp : ruleNegateBoolExp EOF ;
    public final void entryRuleNegateBoolExp() throws RecognitionException {
        try {
            // InternalStoryGen.g:279:1: ( ruleNegateBoolExp EOF )
            // InternalStoryGen.g:280:1: ruleNegateBoolExp EOF
            {
             before(grammarAccess.getNegateBoolExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNegateBoolExp();

            state._fsp--;

             after(grammarAccess.getNegateBoolExpRule()); 
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
    // $ANTLR end "entryRuleNegateBoolExp"


    // $ANTLR start "ruleNegateBoolExp"
    // InternalStoryGen.g:287:1: ruleNegateBoolExp : ( ( rule__NegateBoolExp__Group__0 ) ) ;
    public final void ruleNegateBoolExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:291:2: ( ( ( rule__NegateBoolExp__Group__0 ) ) )
            // InternalStoryGen.g:292:2: ( ( rule__NegateBoolExp__Group__0 ) )
            {
            // InternalStoryGen.g:292:2: ( ( rule__NegateBoolExp__Group__0 ) )
            // InternalStoryGen.g:293:3: ( rule__NegateBoolExp__Group__0 )
            {
             before(grammarAccess.getNegateBoolExpAccess().getGroup()); 
            // InternalStoryGen.g:294:3: ( rule__NegateBoolExp__Group__0 )
            // InternalStoryGen.g:294:4: rule__NegateBoolExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NegateBoolExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNegateBoolExpAccess().getGroup()); 

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
    // $ANTLR end "ruleNegateBoolExp"


    // $ANTLR start "entryRuleUnaryQuantityExp"
    // InternalStoryGen.g:303:1: entryRuleUnaryQuantityExp : ruleUnaryQuantityExp EOF ;
    public final void entryRuleUnaryQuantityExp() throws RecognitionException {
        try {
            // InternalStoryGen.g:304:1: ( ruleUnaryQuantityExp EOF )
            // InternalStoryGen.g:305:1: ruleUnaryQuantityExp EOF
            {
             before(grammarAccess.getUnaryQuantityExpRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryQuantityExp();

            state._fsp--;

             after(grammarAccess.getUnaryQuantityExpRule()); 
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
    // $ANTLR end "entryRuleUnaryQuantityExp"


    // $ANTLR start "ruleUnaryQuantityExp"
    // InternalStoryGen.g:312:1: ruleUnaryQuantityExp : ( ( rule__UnaryQuantityExp__Alternatives ) ) ;
    public final void ruleUnaryQuantityExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:316:2: ( ( ( rule__UnaryQuantityExp__Alternatives ) ) )
            // InternalStoryGen.g:317:2: ( ( rule__UnaryQuantityExp__Alternatives ) )
            {
            // InternalStoryGen.g:317:2: ( ( rule__UnaryQuantityExp__Alternatives ) )
            // InternalStoryGen.g:318:3: ( rule__UnaryQuantityExp__Alternatives )
            {
             before(grammarAccess.getUnaryQuantityExpAccess().getAlternatives()); 
            // InternalStoryGen.g:319:3: ( rule__UnaryQuantityExp__Alternatives )
            // InternalStoryGen.g:319:4: rule__UnaryQuantityExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__UnaryQuantityExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnaryQuantityExpAccess().getAlternatives()); 

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
    // $ANTLR end "ruleUnaryQuantityExp"


    // $ANTLR start "ruleAttrType"
    // InternalStoryGen.g:328:1: ruleAttrType : ( ( rule__AttrType__Alternatives ) ) ;
    public final void ruleAttrType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:332:1: ( ( ( rule__AttrType__Alternatives ) ) )
            // InternalStoryGen.g:333:2: ( ( rule__AttrType__Alternatives ) )
            {
            // InternalStoryGen.g:333:2: ( ( rule__AttrType__Alternatives ) )
            // InternalStoryGen.g:334:3: ( rule__AttrType__Alternatives )
            {
             before(grammarAccess.getAttrTypeAccess().getAlternatives()); 
            // InternalStoryGen.g:335:3: ( rule__AttrType__Alternatives )
            // InternalStoryGen.g:335:4: rule__AttrType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AttrType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAttrTypeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleAttrType"


    // $ANTLR start "ruleBooleanValue"
    // InternalStoryGen.g:344:1: ruleBooleanValue : ( ( rule__BooleanValue__Alternatives ) ) ;
    public final void ruleBooleanValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:348:1: ( ( ( rule__BooleanValue__Alternatives ) ) )
            // InternalStoryGen.g:349:2: ( ( rule__BooleanValue__Alternatives ) )
            {
            // InternalStoryGen.g:349:2: ( ( rule__BooleanValue__Alternatives ) )
            // InternalStoryGen.g:350:3: ( rule__BooleanValue__Alternatives )
            {
             before(grammarAccess.getBooleanValueAccess().getAlternatives()); 
            // InternalStoryGen.g:351:3: ( rule__BooleanValue__Alternatives )
            // InternalStoryGen.g:351:4: rule__BooleanValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BooleanValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanValueAccess().getAlternatives()); 

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
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "ruleNumOp"
    // InternalStoryGen.g:360:1: ruleNumOp : ( ( rule__NumOp__Alternatives ) ) ;
    public final void ruleNumOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:364:1: ( ( ( rule__NumOp__Alternatives ) ) )
            // InternalStoryGen.g:365:2: ( ( rule__NumOp__Alternatives ) )
            {
            // InternalStoryGen.g:365:2: ( ( rule__NumOp__Alternatives ) )
            // InternalStoryGen.g:366:3: ( rule__NumOp__Alternatives )
            {
             before(grammarAccess.getNumOpAccess().getAlternatives()); 
            // InternalStoryGen.g:367:3: ( rule__NumOp__Alternatives )
            // InternalStoryGen.g:367:4: rule__NumOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NumOp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNumOpAccess().getAlternatives()); 

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
    // $ANTLR end "ruleNumOp"


    // $ANTLR start "ruleBoolOp"
    // InternalStoryGen.g:376:1: ruleBoolOp : ( ( rule__BoolOp__Alternatives ) ) ;
    public final void ruleBoolOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:380:1: ( ( ( rule__BoolOp__Alternatives ) ) )
            // InternalStoryGen.g:381:2: ( ( rule__BoolOp__Alternatives ) )
            {
            // InternalStoryGen.g:381:2: ( ( rule__BoolOp__Alternatives ) )
            // InternalStoryGen.g:382:3: ( rule__BoolOp__Alternatives )
            {
             before(grammarAccess.getBoolOpAccess().getAlternatives()); 
            // InternalStoryGen.g:383:3: ( rule__BoolOp__Alternatives )
            // InternalStoryGen.g:383:4: rule__BoolOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BoolOp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBoolOpAccess().getAlternatives()); 

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
    // $ANTLR end "ruleBoolOp"


    // $ANTLR start "rule__BoolExp__Alternatives"
    // InternalStoryGen.g:391:1: rule__BoolExp__Alternatives : ( ( ( rule__BoolExp__Group_0__0 ) ) | ( ( rule__BoolExp__BinaryBoolAssignment_1 ) ) | ( ( rule__BoolExp__BinaryQntyAssignment_2 ) ) | ( ( rule__BoolExp__NegateBoolExpAssignment_3 ) ) | ( ( rule__BoolExp__UnaryBoolAssignment_4 ) ) );
    public final void rule__BoolExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:395:1: ( ( ( rule__BoolExp__Group_0__0 ) ) | ( ( rule__BoolExp__BinaryBoolAssignment_1 ) ) | ( ( rule__BoolExp__BinaryQntyAssignment_2 ) ) | ( ( rule__BoolExp__NegateBoolExpAssignment_3 ) ) | ( ( rule__BoolExp__UnaryBoolAssignment_4 ) ) )
            int alt1=5;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalStoryGen.g:396:2: ( ( rule__BoolExp__Group_0__0 ) )
                    {
                    // InternalStoryGen.g:396:2: ( ( rule__BoolExp__Group_0__0 ) )
                    // InternalStoryGen.g:397:3: ( rule__BoolExp__Group_0__0 )
                    {
                     before(grammarAccess.getBoolExpAccess().getGroup_0()); 
                    // InternalStoryGen.g:398:3: ( rule__BoolExp__Group_0__0 )
                    // InternalStoryGen.g:398:4: rule__BoolExp__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BoolExp__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBoolExpAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:402:2: ( ( rule__BoolExp__BinaryBoolAssignment_1 ) )
                    {
                    // InternalStoryGen.g:402:2: ( ( rule__BoolExp__BinaryBoolAssignment_1 ) )
                    // InternalStoryGen.g:403:3: ( rule__BoolExp__BinaryBoolAssignment_1 )
                    {
                     before(grammarAccess.getBoolExpAccess().getBinaryBoolAssignment_1()); 
                    // InternalStoryGen.g:404:3: ( rule__BoolExp__BinaryBoolAssignment_1 )
                    // InternalStoryGen.g:404:4: rule__BoolExp__BinaryBoolAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__BoolExp__BinaryBoolAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getBoolExpAccess().getBinaryBoolAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:408:2: ( ( rule__BoolExp__BinaryQntyAssignment_2 ) )
                    {
                    // InternalStoryGen.g:408:2: ( ( rule__BoolExp__BinaryQntyAssignment_2 ) )
                    // InternalStoryGen.g:409:3: ( rule__BoolExp__BinaryQntyAssignment_2 )
                    {
                     before(grammarAccess.getBoolExpAccess().getBinaryQntyAssignment_2()); 
                    // InternalStoryGen.g:410:3: ( rule__BoolExp__BinaryQntyAssignment_2 )
                    // InternalStoryGen.g:410:4: rule__BoolExp__BinaryQntyAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__BoolExp__BinaryQntyAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getBoolExpAccess().getBinaryQntyAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:414:2: ( ( rule__BoolExp__NegateBoolExpAssignment_3 ) )
                    {
                    // InternalStoryGen.g:414:2: ( ( rule__BoolExp__NegateBoolExpAssignment_3 ) )
                    // InternalStoryGen.g:415:3: ( rule__BoolExp__NegateBoolExpAssignment_3 )
                    {
                     before(grammarAccess.getBoolExpAccess().getNegateBoolExpAssignment_3()); 
                    // InternalStoryGen.g:416:3: ( rule__BoolExp__NegateBoolExpAssignment_3 )
                    // InternalStoryGen.g:416:4: rule__BoolExp__NegateBoolExpAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__BoolExp__NegateBoolExpAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getBoolExpAccess().getNegateBoolExpAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGen.g:420:2: ( ( rule__BoolExp__UnaryBoolAssignment_4 ) )
                    {
                    // InternalStoryGen.g:420:2: ( ( rule__BoolExp__UnaryBoolAssignment_4 ) )
                    // InternalStoryGen.g:421:3: ( rule__BoolExp__UnaryBoolAssignment_4 )
                    {
                     before(grammarAccess.getBoolExpAccess().getUnaryBoolAssignment_4()); 
                    // InternalStoryGen.g:422:3: ( rule__BoolExp__UnaryBoolAssignment_4 )
                    // InternalStoryGen.g:422:4: rule__BoolExp__UnaryBoolAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__BoolExp__UnaryBoolAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getBoolExpAccess().getUnaryBoolAssignment_4()); 

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
    // $ANTLR end "rule__BoolExp__Alternatives"


    // $ANTLR start "rule__UnaryBoolExp__Alternatives"
    // InternalStoryGen.g:430:1: rule__UnaryBoolExp__Alternatives : ( ( ( rule__UnaryBoolExp__IdAssignment_0 ) ) | ( ( rule__UnaryBoolExp__ValueAssignment_1 ) ) );
    public final void rule__UnaryBoolExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:434:1: ( ( ( rule__UnaryBoolExp__IdAssignment_0 ) ) | ( ( rule__UnaryBoolExp__ValueAssignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=13 && LA2_0<=14)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalStoryGen.g:435:2: ( ( rule__UnaryBoolExp__IdAssignment_0 ) )
                    {
                    // InternalStoryGen.g:435:2: ( ( rule__UnaryBoolExp__IdAssignment_0 ) )
                    // InternalStoryGen.g:436:3: ( rule__UnaryBoolExp__IdAssignment_0 )
                    {
                     before(grammarAccess.getUnaryBoolExpAccess().getIdAssignment_0()); 
                    // InternalStoryGen.g:437:3: ( rule__UnaryBoolExp__IdAssignment_0 )
                    // InternalStoryGen.g:437:4: rule__UnaryBoolExp__IdAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnaryBoolExp__IdAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryBoolExpAccess().getIdAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:441:2: ( ( rule__UnaryBoolExp__ValueAssignment_1 ) )
                    {
                    // InternalStoryGen.g:441:2: ( ( rule__UnaryBoolExp__ValueAssignment_1 ) )
                    // InternalStoryGen.g:442:3: ( rule__UnaryBoolExp__ValueAssignment_1 )
                    {
                     before(grammarAccess.getUnaryBoolExpAccess().getValueAssignment_1()); 
                    // InternalStoryGen.g:443:3: ( rule__UnaryBoolExp__ValueAssignment_1 )
                    // InternalStoryGen.g:443:4: rule__UnaryBoolExp__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnaryBoolExp__ValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryBoolExpAccess().getValueAssignment_1()); 

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
    // $ANTLR end "rule__UnaryBoolExp__Alternatives"


    // $ANTLR start "rule__UnaryQuantityExp__Alternatives"
    // InternalStoryGen.g:451:1: rule__UnaryQuantityExp__Alternatives : ( ( ( rule__UnaryQuantityExp__IdAssignment_0 ) ) | ( ( rule__UnaryQuantityExp__ValueAssignment_1 ) ) );
    public final void rule__UnaryQuantityExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:455:1: ( ( ( rule__UnaryQuantityExp__IdAssignment_0 ) ) | ( ( rule__UnaryQuantityExp__ValueAssignment_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_INT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalStoryGen.g:456:2: ( ( rule__UnaryQuantityExp__IdAssignment_0 ) )
                    {
                    // InternalStoryGen.g:456:2: ( ( rule__UnaryQuantityExp__IdAssignment_0 ) )
                    // InternalStoryGen.g:457:3: ( rule__UnaryQuantityExp__IdAssignment_0 )
                    {
                     before(grammarAccess.getUnaryQuantityExpAccess().getIdAssignment_0()); 
                    // InternalStoryGen.g:458:3: ( rule__UnaryQuantityExp__IdAssignment_0 )
                    // InternalStoryGen.g:458:4: rule__UnaryQuantityExp__IdAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnaryQuantityExp__IdAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryQuantityExpAccess().getIdAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:462:2: ( ( rule__UnaryQuantityExp__ValueAssignment_1 ) )
                    {
                    // InternalStoryGen.g:462:2: ( ( rule__UnaryQuantityExp__ValueAssignment_1 ) )
                    // InternalStoryGen.g:463:3: ( rule__UnaryQuantityExp__ValueAssignment_1 )
                    {
                     before(grammarAccess.getUnaryQuantityExpAccess().getValueAssignment_1()); 
                    // InternalStoryGen.g:464:3: ( rule__UnaryQuantityExp__ValueAssignment_1 )
                    // InternalStoryGen.g:464:4: rule__UnaryQuantityExp__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__UnaryQuantityExp__ValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryQuantityExpAccess().getValueAssignment_1()); 

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
    // $ANTLR end "rule__UnaryQuantityExp__Alternatives"


    // $ANTLR start "rule__AttrType__Alternatives"
    // InternalStoryGen.g:472:1: rule__AttrType__Alternatives : ( ( ( 'fact' ) ) | ( ( 'quantity' ) ) );
    public final void rule__AttrType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:476:1: ( ( ( 'fact' ) ) | ( ( 'quantity' ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalStoryGen.g:477:2: ( ( 'fact' ) )
                    {
                    // InternalStoryGen.g:477:2: ( ( 'fact' ) )
                    // InternalStoryGen.g:478:3: ( 'fact' )
                    {
                     before(grammarAccess.getAttrTypeAccess().getFACTEnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:479:3: ( 'fact' )
                    // InternalStoryGen.g:479:4: 'fact'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getAttrTypeAccess().getFACTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:483:2: ( ( 'quantity' ) )
                    {
                    // InternalStoryGen.g:483:2: ( ( 'quantity' ) )
                    // InternalStoryGen.g:484:3: ( 'quantity' )
                    {
                     before(grammarAccess.getAttrTypeAccess().getQUANTITYEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:485:3: ( 'quantity' )
                    // InternalStoryGen.g:485:4: 'quantity'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getAttrTypeAccess().getQUANTITYEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__AttrType__Alternatives"


    // $ANTLR start "rule__BooleanValue__Alternatives"
    // InternalStoryGen.g:493:1: rule__BooleanValue__Alternatives : ( ( ( 'true' ) ) | ( ( 'false' ) ) );
    public final void rule__BooleanValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:497:1: ( ( ( 'true' ) ) | ( ( 'false' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==14) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalStoryGen.g:498:2: ( ( 'true' ) )
                    {
                    // InternalStoryGen.g:498:2: ( ( 'true' ) )
                    // InternalStoryGen.g:499:3: ( 'true' )
                    {
                     before(grammarAccess.getBooleanValueAccess().getTRUEEnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:500:3: ( 'true' )
                    // InternalStoryGen.g:500:4: 'true'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getBooleanValueAccess().getTRUEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:504:2: ( ( 'false' ) )
                    {
                    // InternalStoryGen.g:504:2: ( ( 'false' ) )
                    // InternalStoryGen.g:505:3: ( 'false' )
                    {
                     before(grammarAccess.getBooleanValueAccess().getFALSEEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:506:3: ( 'false' )
                    // InternalStoryGen.g:506:4: 'false'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getBooleanValueAccess().getFALSEEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__BooleanValue__Alternatives"


    // $ANTLR start "rule__NumOp__Alternatives"
    // InternalStoryGen.g:514:1: rule__NumOp__Alternatives : ( ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '>' ) ) | ( ( '<' ) ) | ( ( '>=' ) ) | ( ( '<=' ) ) );
    public final void rule__NumOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:518:1: ( ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '>' ) ) | ( ( '<' ) ) | ( ( '>=' ) ) | ( ( '<=' ) ) )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt6=1;
                }
                break;
            case 16:
                {
                alt6=2;
                }
                break;
            case 17:
                {
                alt6=3;
                }
                break;
            case 18:
                {
                alt6=4;
                }
                break;
            case 19:
                {
                alt6=5;
                }
                break;
            case 20:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalStoryGen.g:519:2: ( ( '==' ) )
                    {
                    // InternalStoryGen.g:519:2: ( ( '==' ) )
                    // InternalStoryGen.g:520:3: ( '==' )
                    {
                     before(grammarAccess.getNumOpAccess().getEQEnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:521:3: ( '==' )
                    // InternalStoryGen.g:521:4: '=='
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getNumOpAccess().getEQEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:525:2: ( ( '!=' ) )
                    {
                    // InternalStoryGen.g:525:2: ( ( '!=' ) )
                    // InternalStoryGen.g:526:3: ( '!=' )
                    {
                     before(grammarAccess.getNumOpAccess().getNEQEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:527:3: ( '!=' )
                    // InternalStoryGen.g:527:4: '!='
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getNumOpAccess().getNEQEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:531:2: ( ( '>' ) )
                    {
                    // InternalStoryGen.g:531:2: ( ( '>' ) )
                    // InternalStoryGen.g:532:3: ( '>' )
                    {
                     before(grammarAccess.getNumOpAccess().getGTEnumLiteralDeclaration_2()); 
                    // InternalStoryGen.g:533:3: ( '>' )
                    // InternalStoryGen.g:533:4: '>'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getNumOpAccess().getGTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:537:2: ( ( '<' ) )
                    {
                    // InternalStoryGen.g:537:2: ( ( '<' ) )
                    // InternalStoryGen.g:538:3: ( '<' )
                    {
                     before(grammarAccess.getNumOpAccess().getLTEnumLiteralDeclaration_3()); 
                    // InternalStoryGen.g:539:3: ( '<' )
                    // InternalStoryGen.g:539:4: '<'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getNumOpAccess().getLTEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalStoryGen.g:543:2: ( ( '>=' ) )
                    {
                    // InternalStoryGen.g:543:2: ( ( '>=' ) )
                    // InternalStoryGen.g:544:3: ( '>=' )
                    {
                     before(grammarAccess.getNumOpAccess().getGEEnumLiteralDeclaration_4()); 
                    // InternalStoryGen.g:545:3: ( '>=' )
                    // InternalStoryGen.g:545:4: '>='
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getNumOpAccess().getGEEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalStoryGen.g:549:2: ( ( '<=' ) )
                    {
                    // InternalStoryGen.g:549:2: ( ( '<=' ) )
                    // InternalStoryGen.g:550:3: ( '<=' )
                    {
                     before(grammarAccess.getNumOpAccess().getLEEnumLiteralDeclaration_5()); 
                    // InternalStoryGen.g:551:3: ( '<=' )
                    // InternalStoryGen.g:551:4: '<='
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getNumOpAccess().getLEEnumLiteralDeclaration_5()); 

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
    // $ANTLR end "rule__NumOp__Alternatives"


    // $ANTLR start "rule__BoolOp__Alternatives"
    // InternalStoryGen.g:559:1: rule__BoolOp__Alternatives : ( ( ( '==' ) ) | ( ( '!=' ) ) | ( ( 'and' ) ) | ( ( 'or' ) ) );
    public final void rule__BoolOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:563:1: ( ( ( '==' ) ) | ( ( '!=' ) ) | ( ( 'and' ) ) | ( ( 'or' ) ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt7=1;
                }
                break;
            case 16:
                {
                alt7=2;
                }
                break;
            case 21:
                {
                alt7=3;
                }
                break;
            case 22:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalStoryGen.g:564:2: ( ( '==' ) )
                    {
                    // InternalStoryGen.g:564:2: ( ( '==' ) )
                    // InternalStoryGen.g:565:3: ( '==' )
                    {
                     before(grammarAccess.getBoolOpAccess().getEQEnumLiteralDeclaration_0()); 
                    // InternalStoryGen.g:566:3: ( '==' )
                    // InternalStoryGen.g:566:4: '=='
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getBoolOpAccess().getEQEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalStoryGen.g:570:2: ( ( '!=' ) )
                    {
                    // InternalStoryGen.g:570:2: ( ( '!=' ) )
                    // InternalStoryGen.g:571:3: ( '!=' )
                    {
                     before(grammarAccess.getBoolOpAccess().getNEQEnumLiteralDeclaration_1()); 
                    // InternalStoryGen.g:572:3: ( '!=' )
                    // InternalStoryGen.g:572:4: '!='
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getBoolOpAccess().getNEQEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalStoryGen.g:576:2: ( ( 'and' ) )
                    {
                    // InternalStoryGen.g:576:2: ( ( 'and' ) )
                    // InternalStoryGen.g:577:3: ( 'and' )
                    {
                     before(grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_2()); 
                    // InternalStoryGen.g:578:3: ( 'and' )
                    // InternalStoryGen.g:578:4: 'and'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalStoryGen.g:582:2: ( ( 'or' ) )
                    {
                    // InternalStoryGen.g:582:2: ( ( 'or' ) )
                    // InternalStoryGen.g:583:3: ( 'or' )
                    {
                     before(grammarAccess.getBoolOpAccess().getOREnumLiteralDeclaration_3()); 
                    // InternalStoryGen.g:584:3: ( 'or' )
                    // InternalStoryGen.g:584:4: 'or'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getBoolOpAccess().getOREnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__BoolOp__Alternatives"


    // $ANTLR start "rule__Story__Group__0"
    // InternalStoryGen.g:592:1: rule__Story__Group__0 : rule__Story__Group__0__Impl rule__Story__Group__1 ;
    public final void rule__Story__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:596:1: ( rule__Story__Group__0__Impl rule__Story__Group__1 )
            // InternalStoryGen.g:597:2: rule__Story__Group__0__Impl rule__Story__Group__1
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
    // InternalStoryGen.g:604:1: rule__Story__Group__0__Impl : ( ( rule__Story__WorldAssignment_0 ) ) ;
    public final void rule__Story__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:608:1: ( ( ( rule__Story__WorldAssignment_0 ) ) )
            // InternalStoryGen.g:609:1: ( ( rule__Story__WorldAssignment_0 ) )
            {
            // InternalStoryGen.g:609:1: ( ( rule__Story__WorldAssignment_0 ) )
            // InternalStoryGen.g:610:2: ( rule__Story__WorldAssignment_0 )
            {
             before(grammarAccess.getStoryAccess().getWorldAssignment_0()); 
            // InternalStoryGen.g:611:2: ( rule__Story__WorldAssignment_0 )
            // InternalStoryGen.g:611:3: rule__Story__WorldAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Story__WorldAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getStoryAccess().getWorldAssignment_0()); 

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
    // InternalStoryGen.g:619:1: rule__Story__Group__1 : rule__Story__Group__1__Impl ;
    public final void rule__Story__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:623:1: ( rule__Story__Group__1__Impl )
            // InternalStoryGen.g:624:2: rule__Story__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Story__Group__1__Impl();

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
    // InternalStoryGen.g:630:1: rule__Story__Group__1__Impl : ( ( rule__Story__EventsAssignment_1 )* ) ;
    public final void rule__Story__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:634:1: ( ( ( rule__Story__EventsAssignment_1 )* ) )
            // InternalStoryGen.g:635:1: ( ( rule__Story__EventsAssignment_1 )* )
            {
            // InternalStoryGen.g:635:1: ( ( rule__Story__EventsAssignment_1 )* )
            // InternalStoryGen.g:636:2: ( rule__Story__EventsAssignment_1 )*
            {
             before(grammarAccess.getStoryAccess().getEventsAssignment_1()); 
            // InternalStoryGen.g:637:2: ( rule__Story__EventsAssignment_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==26||LA8_0==32) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalStoryGen.g:637:3: rule__Story__EventsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Story__EventsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getStoryAccess().getEventsAssignment_1()); 

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


    // $ANTLR start "rule__World__Group__0"
    // InternalStoryGen.g:646:1: rule__World__Group__0 : rule__World__Group__0__Impl rule__World__Group__1 ;
    public final void rule__World__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:650:1: ( rule__World__Group__0__Impl rule__World__Group__1 )
            // InternalStoryGen.g:651:2: rule__World__Group__0__Impl rule__World__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__World__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__World__Group__1();

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
    // $ANTLR end "rule__World__Group__0"


    // $ANTLR start "rule__World__Group__0__Impl"
    // InternalStoryGen.g:658:1: rule__World__Group__0__Impl : ( () ) ;
    public final void rule__World__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:662:1: ( ( () ) )
            // InternalStoryGen.g:663:1: ( () )
            {
            // InternalStoryGen.g:663:1: ( () )
            // InternalStoryGen.g:664:2: ()
            {
             before(grammarAccess.getWorldAccess().getWorldAction_0()); 
            // InternalStoryGen.g:665:2: ()
            // InternalStoryGen.g:665:3: 
            {
            }

             after(grammarAccess.getWorldAccess().getWorldAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__World__Group__0__Impl"


    // $ANTLR start "rule__World__Group__1"
    // InternalStoryGen.g:673:1: rule__World__Group__1 : rule__World__Group__1__Impl rule__World__Group__2 ;
    public final void rule__World__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:677:1: ( rule__World__Group__1__Impl rule__World__Group__2 )
            // InternalStoryGen.g:678:2: rule__World__Group__1__Impl rule__World__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__World__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__World__Group__2();

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
    // $ANTLR end "rule__World__Group__1"


    // $ANTLR start "rule__World__Group__1__Impl"
    // InternalStoryGen.g:685:1: rule__World__Group__1__Impl : ( 'World' ) ;
    public final void rule__World__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:689:1: ( ( 'World' ) )
            // InternalStoryGen.g:690:1: ( 'World' )
            {
            // InternalStoryGen.g:690:1: ( 'World' )
            // InternalStoryGen.g:691:2: 'World'
            {
             before(grammarAccess.getWorldAccess().getWorldKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getWorldAccess().getWorldKeyword_1()); 

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
    // $ANTLR end "rule__World__Group__1__Impl"


    // $ANTLR start "rule__World__Group__2"
    // InternalStoryGen.g:700:1: rule__World__Group__2 : rule__World__Group__2__Impl rule__World__Group__3 ;
    public final void rule__World__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:704:1: ( rule__World__Group__2__Impl rule__World__Group__3 )
            // InternalStoryGen.g:705:2: rule__World__Group__2__Impl rule__World__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__World__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__World__Group__3();

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
    // $ANTLR end "rule__World__Group__2"


    // $ANTLR start "rule__World__Group__2__Impl"
    // InternalStoryGen.g:712:1: rule__World__Group__2__Impl : ( '{' ) ;
    public final void rule__World__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:716:1: ( ( '{' ) )
            // InternalStoryGen.g:717:1: ( '{' )
            {
            // InternalStoryGen.g:717:1: ( '{' )
            // InternalStoryGen.g:718:2: '{'
            {
             before(grammarAccess.getWorldAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getWorldAccess().getLeftCurlyBracketKeyword_2()); 

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
    // $ANTLR end "rule__World__Group__2__Impl"


    // $ANTLR start "rule__World__Group__3"
    // InternalStoryGen.g:727:1: rule__World__Group__3 : rule__World__Group__3__Impl rule__World__Group__4 ;
    public final void rule__World__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:731:1: ( rule__World__Group__3__Impl rule__World__Group__4 )
            // InternalStoryGen.g:732:2: rule__World__Group__3__Impl rule__World__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__World__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__World__Group__4();

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
    // $ANTLR end "rule__World__Group__3"


    // $ANTLR start "rule__World__Group__3__Impl"
    // InternalStoryGen.g:739:1: rule__World__Group__3__Impl : ( ( rule__World__AttributesAssignment_3 )* ) ;
    public final void rule__World__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:743:1: ( ( ( rule__World__AttributesAssignment_3 )* ) )
            // InternalStoryGen.g:744:1: ( ( rule__World__AttributesAssignment_3 )* )
            {
            // InternalStoryGen.g:744:1: ( ( rule__World__AttributesAssignment_3 )* )
            // InternalStoryGen.g:745:2: ( rule__World__AttributesAssignment_3 )*
            {
             before(grammarAccess.getWorldAccess().getAttributesAssignment_3()); 
            // InternalStoryGen.g:746:2: ( rule__World__AttributesAssignment_3 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=11 && LA9_0<=12)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalStoryGen.g:746:3: rule__World__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__World__AttributesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getWorldAccess().getAttributesAssignment_3()); 

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
    // $ANTLR end "rule__World__Group__3__Impl"


    // $ANTLR start "rule__World__Group__4"
    // InternalStoryGen.g:754:1: rule__World__Group__4 : rule__World__Group__4__Impl ;
    public final void rule__World__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:758:1: ( rule__World__Group__4__Impl )
            // InternalStoryGen.g:759:2: rule__World__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__World__Group__4__Impl();

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
    // $ANTLR end "rule__World__Group__4"


    // $ANTLR start "rule__World__Group__4__Impl"
    // InternalStoryGen.g:765:1: rule__World__Group__4__Impl : ( '}' ) ;
    public final void rule__World__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:769:1: ( ( '}' ) )
            // InternalStoryGen.g:770:1: ( '}' )
            {
            // InternalStoryGen.g:770:1: ( '}' )
            // InternalStoryGen.g:771:2: '}'
            {
             before(grammarAccess.getWorldAccess().getRightCurlyBracketKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getWorldAccess().getRightCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__World__Group__4__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalStoryGen.g:781:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:785:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalStoryGen.g:786:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__1();

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
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalStoryGen.g:793:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__AttrTypeAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:797:1: ( ( ( rule__Attribute__AttrTypeAssignment_0 ) ) )
            // InternalStoryGen.g:798:1: ( ( rule__Attribute__AttrTypeAssignment_0 ) )
            {
            // InternalStoryGen.g:798:1: ( ( rule__Attribute__AttrTypeAssignment_0 ) )
            // InternalStoryGen.g:799:2: ( rule__Attribute__AttrTypeAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getAttrTypeAssignment_0()); 
            // InternalStoryGen.g:800:2: ( rule__Attribute__AttrTypeAssignment_0 )
            // InternalStoryGen.g:800:3: rule__Attribute__AttrTypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__AttrTypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getAttrTypeAssignment_0()); 

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
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalStoryGen.g:808:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:812:1: ( rule__Attribute__Group__1__Impl )
            // InternalStoryGen.g:813:2: rule__Attribute__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__1__Impl();

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
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalStoryGen.g:819:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__NameAssignment_1 ) ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:823:1: ( ( ( rule__Attribute__NameAssignment_1 ) ) )
            // InternalStoryGen.g:824:1: ( ( rule__Attribute__NameAssignment_1 ) )
            {
            // InternalStoryGen.g:824:1: ( ( rule__Attribute__NameAssignment_1 ) )
            // InternalStoryGen.g:825:2: ( rule__Attribute__NameAssignment_1 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_1()); 
            // InternalStoryGen.g:826:2: ( rule__Attribute__NameAssignment_1 )
            // InternalStoryGen.g:826:3: rule__Attribute__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Event__Group__0"
    // InternalStoryGen.g:835:1: rule__Event__Group__0 : rule__Event__Group__0__Impl rule__Event__Group__1 ;
    public final void rule__Event__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:839:1: ( rule__Event__Group__0__Impl rule__Event__Group__1 )
            // InternalStoryGen.g:840:2: rule__Event__Group__0__Impl rule__Event__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Event__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Event__Group__1();

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
    // $ANTLR end "rule__Event__Group__0"


    // $ANTLR start "rule__Event__Group__0__Impl"
    // InternalStoryGen.g:847:1: rule__Event__Group__0__Impl : ( ( rule__Event__AbstractAssignment_0 )? ) ;
    public final void rule__Event__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:851:1: ( ( ( rule__Event__AbstractAssignment_0 )? ) )
            // InternalStoryGen.g:852:1: ( ( rule__Event__AbstractAssignment_0 )? )
            {
            // InternalStoryGen.g:852:1: ( ( rule__Event__AbstractAssignment_0 )? )
            // InternalStoryGen.g:853:2: ( rule__Event__AbstractAssignment_0 )?
            {
             before(grammarAccess.getEventAccess().getAbstractAssignment_0()); 
            // InternalStoryGen.g:854:2: ( rule__Event__AbstractAssignment_0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==32) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalStoryGen.g:854:3: rule__Event__AbstractAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Event__AbstractAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEventAccess().getAbstractAssignment_0()); 

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
    // $ANTLR end "rule__Event__Group__0__Impl"


    // $ANTLR start "rule__Event__Group__1"
    // InternalStoryGen.g:862:1: rule__Event__Group__1 : rule__Event__Group__1__Impl rule__Event__Group__2 ;
    public final void rule__Event__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:866:1: ( rule__Event__Group__1__Impl rule__Event__Group__2 )
            // InternalStoryGen.g:867:2: rule__Event__Group__1__Impl rule__Event__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__Event__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Event__Group__2();

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
    // $ANTLR end "rule__Event__Group__1"


    // $ANTLR start "rule__Event__Group__1__Impl"
    // InternalStoryGen.g:874:1: rule__Event__Group__1__Impl : ( 'event' ) ;
    public final void rule__Event__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:878:1: ( ( 'event' ) )
            // InternalStoryGen.g:879:1: ( 'event' )
            {
            // InternalStoryGen.g:879:1: ( 'event' )
            // InternalStoryGen.g:880:2: 'event'
            {
             before(grammarAccess.getEventAccess().getEventKeyword_1()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getEventAccess().getEventKeyword_1()); 

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
    // $ANTLR end "rule__Event__Group__1__Impl"


    // $ANTLR start "rule__Event__Group__2"
    // InternalStoryGen.g:889:1: rule__Event__Group__2 : rule__Event__Group__2__Impl rule__Event__Group__3 ;
    public final void rule__Event__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:893:1: ( rule__Event__Group__2__Impl rule__Event__Group__3 )
            // InternalStoryGen.g:894:2: rule__Event__Group__2__Impl rule__Event__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__Event__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Event__Group__3();

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
    // $ANTLR end "rule__Event__Group__2"


    // $ANTLR start "rule__Event__Group__2__Impl"
    // InternalStoryGen.g:901:1: rule__Event__Group__2__Impl : ( ( rule__Event__NameAssignment_2 ) ) ;
    public final void rule__Event__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:905:1: ( ( ( rule__Event__NameAssignment_2 ) ) )
            // InternalStoryGen.g:906:1: ( ( rule__Event__NameAssignment_2 ) )
            {
            // InternalStoryGen.g:906:1: ( ( rule__Event__NameAssignment_2 ) )
            // InternalStoryGen.g:907:2: ( rule__Event__NameAssignment_2 )
            {
             before(grammarAccess.getEventAccess().getNameAssignment_2()); 
            // InternalStoryGen.g:908:2: ( rule__Event__NameAssignment_2 )
            // InternalStoryGen.g:908:3: rule__Event__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Event__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__Event__Group__2__Impl"


    // $ANTLR start "rule__Event__Group__3"
    // InternalStoryGen.g:916:1: rule__Event__Group__3 : rule__Event__Group__3__Impl rule__Event__Group__4 ;
    public final void rule__Event__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:920:1: ( rule__Event__Group__3__Impl rule__Event__Group__4 )
            // InternalStoryGen.g:921:2: rule__Event__Group__3__Impl rule__Event__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__Event__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Event__Group__4();

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
    // $ANTLR end "rule__Event__Group__3"


    // $ANTLR start "rule__Event__Group__3__Impl"
    // InternalStoryGen.g:928:1: rule__Event__Group__3__Impl : ( ( rule__Event__Group_3__0 )? ) ;
    public final void rule__Event__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:932:1: ( ( ( rule__Event__Group_3__0 )? ) )
            // InternalStoryGen.g:933:1: ( ( rule__Event__Group_3__0 )? )
            {
            // InternalStoryGen.g:933:1: ( ( rule__Event__Group_3__0 )? )
            // InternalStoryGen.g:934:2: ( rule__Event__Group_3__0 )?
            {
             before(grammarAccess.getEventAccess().getGroup_3()); 
            // InternalStoryGen.g:935:2: ( rule__Event__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalStoryGen.g:935:3: rule__Event__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Event__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEventAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Event__Group__3__Impl"


    // $ANTLR start "rule__Event__Group__4"
    // InternalStoryGen.g:943:1: rule__Event__Group__4 : rule__Event__Group__4__Impl rule__Event__Group__5 ;
    public final void rule__Event__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:947:1: ( rule__Event__Group__4__Impl rule__Event__Group__5 )
            // InternalStoryGen.g:948:2: rule__Event__Group__4__Impl rule__Event__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__Event__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Event__Group__5();

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
    // $ANTLR end "rule__Event__Group__4"


    // $ANTLR start "rule__Event__Group__4__Impl"
    // InternalStoryGen.g:955:1: rule__Event__Group__4__Impl : ( '{' ) ;
    public final void rule__Event__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:959:1: ( ( '{' ) )
            // InternalStoryGen.g:960:1: ( '{' )
            {
            // InternalStoryGen.g:960:1: ( '{' )
            // InternalStoryGen.g:961:2: '{'
            {
             before(grammarAccess.getEventAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getEventAccess().getLeftCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__Event__Group__4__Impl"


    // $ANTLR start "rule__Event__Group__5"
    // InternalStoryGen.g:970:1: rule__Event__Group__5 : rule__Event__Group__5__Impl rule__Event__Group__6 ;
    public final void rule__Event__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:974:1: ( rule__Event__Group__5__Impl rule__Event__Group__6 )
            // InternalStoryGen.g:975:2: rule__Event__Group__5__Impl rule__Event__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__Event__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Event__Group__6();

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
    // $ANTLR end "rule__Event__Group__5"


    // $ANTLR start "rule__Event__Group__5__Impl"
    // InternalStoryGen.g:982:1: rule__Event__Group__5__Impl : ( ( rule__Event__ConditionsAssignment_5 )* ) ;
    public final void rule__Event__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:986:1: ( ( ( rule__Event__ConditionsAssignment_5 )* ) )
            // InternalStoryGen.g:987:1: ( ( rule__Event__ConditionsAssignment_5 )* )
            {
            // InternalStoryGen.g:987:1: ( ( rule__Event__ConditionsAssignment_5 )* )
            // InternalStoryGen.g:988:2: ( rule__Event__ConditionsAssignment_5 )*
            {
             before(grammarAccess.getEventAccess().getConditionsAssignment_5()); 
            // InternalStoryGen.g:989:2: ( rule__Event__ConditionsAssignment_5 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==28) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalStoryGen.g:989:3: rule__Event__ConditionsAssignment_5
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Event__ConditionsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getEventAccess().getConditionsAssignment_5()); 

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
    // $ANTLR end "rule__Event__Group__5__Impl"


    // $ANTLR start "rule__Event__Group__6"
    // InternalStoryGen.g:997:1: rule__Event__Group__6 : rule__Event__Group__6__Impl ;
    public final void rule__Event__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1001:1: ( rule__Event__Group__6__Impl )
            // InternalStoryGen.g:1002:2: rule__Event__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Event__Group__6__Impl();

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
    // $ANTLR end "rule__Event__Group__6"


    // $ANTLR start "rule__Event__Group__6__Impl"
    // InternalStoryGen.g:1008:1: rule__Event__Group__6__Impl : ( '}' ) ;
    public final void rule__Event__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1012:1: ( ( '}' ) )
            // InternalStoryGen.g:1013:1: ( '}' )
            {
            // InternalStoryGen.g:1013:1: ( '}' )
            // InternalStoryGen.g:1014:2: '}'
            {
             before(grammarAccess.getEventAccess().getRightCurlyBracketKeyword_6()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getEventAccess().getRightCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__Event__Group__6__Impl"


    // $ANTLR start "rule__Event__Group_3__0"
    // InternalStoryGen.g:1024:1: rule__Event__Group_3__0 : rule__Event__Group_3__0__Impl rule__Event__Group_3__1 ;
    public final void rule__Event__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1028:1: ( rule__Event__Group_3__0__Impl rule__Event__Group_3__1 )
            // InternalStoryGen.g:1029:2: rule__Event__Group_3__0__Impl rule__Event__Group_3__1
            {
            pushFollow(FOLLOW_9);
            rule__Event__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Event__Group_3__1();

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
    // $ANTLR end "rule__Event__Group_3__0"


    // $ANTLR start "rule__Event__Group_3__0__Impl"
    // InternalStoryGen.g:1036:1: rule__Event__Group_3__0__Impl : ( 'is' ) ;
    public final void rule__Event__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1040:1: ( ( 'is' ) )
            // InternalStoryGen.g:1041:1: ( 'is' )
            {
            // InternalStoryGen.g:1041:1: ( 'is' )
            // InternalStoryGen.g:1042:2: 'is'
            {
             before(grammarAccess.getEventAccess().getIsKeyword_3_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getEventAccess().getIsKeyword_3_0()); 

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
    // $ANTLR end "rule__Event__Group_3__0__Impl"


    // $ANTLR start "rule__Event__Group_3__1"
    // InternalStoryGen.g:1051:1: rule__Event__Group_3__1 : rule__Event__Group_3__1__Impl ;
    public final void rule__Event__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1055:1: ( rule__Event__Group_3__1__Impl )
            // InternalStoryGen.g:1056:2: rule__Event__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Event__Group_3__1__Impl();

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
    // $ANTLR end "rule__Event__Group_3__1"


    // $ANTLR start "rule__Event__Group_3__1__Impl"
    // InternalStoryGen.g:1062:1: rule__Event__Group_3__1__Impl : ( ( rule__Event__SuperTypeAssignment_3_1 ) ) ;
    public final void rule__Event__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1066:1: ( ( ( rule__Event__SuperTypeAssignment_3_1 ) ) )
            // InternalStoryGen.g:1067:1: ( ( rule__Event__SuperTypeAssignment_3_1 ) )
            {
            // InternalStoryGen.g:1067:1: ( ( rule__Event__SuperTypeAssignment_3_1 ) )
            // InternalStoryGen.g:1068:2: ( rule__Event__SuperTypeAssignment_3_1 )
            {
             before(grammarAccess.getEventAccess().getSuperTypeAssignment_3_1()); 
            // InternalStoryGen.g:1069:2: ( rule__Event__SuperTypeAssignment_3_1 )
            // InternalStoryGen.g:1069:3: rule__Event__SuperTypeAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Event__SuperTypeAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getSuperTypeAssignment_3_1()); 

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
    // $ANTLR end "rule__Event__Group_3__1__Impl"


    // $ANTLR start "rule__Condition__Group__0"
    // InternalStoryGen.g:1078:1: rule__Condition__Group__0 : rule__Condition__Group__0__Impl rule__Condition__Group__1 ;
    public final void rule__Condition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1082:1: ( rule__Condition__Group__0__Impl rule__Condition__Group__1 )
            // InternalStoryGen.g:1083:2: rule__Condition__Group__0__Impl rule__Condition__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__Condition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__1();

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
    // $ANTLR end "rule__Condition__Group__0"


    // $ANTLR start "rule__Condition__Group__0__Impl"
    // InternalStoryGen.g:1090:1: rule__Condition__Group__0__Impl : ( 'requires' ) ;
    public final void rule__Condition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1094:1: ( ( 'requires' ) )
            // InternalStoryGen.g:1095:1: ( 'requires' )
            {
            // InternalStoryGen.g:1095:1: ( 'requires' )
            // InternalStoryGen.g:1096:2: 'requires'
            {
             before(grammarAccess.getConditionAccess().getRequiresKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getRequiresKeyword_0()); 

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
    // $ANTLR end "rule__Condition__Group__0__Impl"


    // $ANTLR start "rule__Condition__Group__1"
    // InternalStoryGen.g:1105:1: rule__Condition__Group__1 : rule__Condition__Group__1__Impl ;
    public final void rule__Condition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1109:1: ( rule__Condition__Group__1__Impl )
            // InternalStoryGen.g:1110:2: rule__Condition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__1__Impl();

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
    // $ANTLR end "rule__Condition__Group__1"


    // $ANTLR start "rule__Condition__Group__1__Impl"
    // InternalStoryGen.g:1116:1: rule__Condition__Group__1__Impl : ( ( rule__Condition__BoolExpAssignment_1 ) ) ;
    public final void rule__Condition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1120:1: ( ( ( rule__Condition__BoolExpAssignment_1 ) ) )
            // InternalStoryGen.g:1121:1: ( ( rule__Condition__BoolExpAssignment_1 ) )
            {
            // InternalStoryGen.g:1121:1: ( ( rule__Condition__BoolExpAssignment_1 ) )
            // InternalStoryGen.g:1122:2: ( rule__Condition__BoolExpAssignment_1 )
            {
             before(grammarAccess.getConditionAccess().getBoolExpAssignment_1()); 
            // InternalStoryGen.g:1123:2: ( rule__Condition__BoolExpAssignment_1 )
            // InternalStoryGen.g:1123:3: rule__Condition__BoolExpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Condition__BoolExpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getBoolExpAssignment_1()); 

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
    // $ANTLR end "rule__Condition__Group__1__Impl"


    // $ANTLR start "rule__BoolExp__Group_0__0"
    // InternalStoryGen.g:1132:1: rule__BoolExp__Group_0__0 : rule__BoolExp__Group_0__0__Impl rule__BoolExp__Group_0__1 ;
    public final void rule__BoolExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1136:1: ( rule__BoolExp__Group_0__0__Impl rule__BoolExp__Group_0__1 )
            // InternalStoryGen.g:1137:2: rule__BoolExp__Group_0__0__Impl rule__BoolExp__Group_0__1
            {
            pushFollow(FOLLOW_13);
            rule__BoolExp__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolExp__Group_0__1();

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
    // $ANTLR end "rule__BoolExp__Group_0__0"


    // $ANTLR start "rule__BoolExp__Group_0__0__Impl"
    // InternalStoryGen.g:1144:1: rule__BoolExp__Group_0__0__Impl : ( '(' ) ;
    public final void rule__BoolExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1148:1: ( ( '(' ) )
            // InternalStoryGen.g:1149:1: ( '(' )
            {
            // InternalStoryGen.g:1149:1: ( '(' )
            // InternalStoryGen.g:1150:2: '('
            {
             before(grammarAccess.getBoolExpAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getBoolExpAccess().getLeftParenthesisKeyword_0_0()); 

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
    // $ANTLR end "rule__BoolExp__Group_0__0__Impl"


    // $ANTLR start "rule__BoolExp__Group_0__1"
    // InternalStoryGen.g:1159:1: rule__BoolExp__Group_0__1 : rule__BoolExp__Group_0__1__Impl rule__BoolExp__Group_0__2 ;
    public final void rule__BoolExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1163:1: ( rule__BoolExp__Group_0__1__Impl rule__BoolExp__Group_0__2 )
            // InternalStoryGen.g:1164:2: rule__BoolExp__Group_0__1__Impl rule__BoolExp__Group_0__2
            {
            pushFollow(FOLLOW_14);
            rule__BoolExp__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolExp__Group_0__2();

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
    // $ANTLR end "rule__BoolExp__Group_0__1"


    // $ANTLR start "rule__BoolExp__Group_0__1__Impl"
    // InternalStoryGen.g:1171:1: rule__BoolExp__Group_0__1__Impl : ( ( rule__BoolExp__LeftAssignment_0_1 ) ) ;
    public final void rule__BoolExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1175:1: ( ( ( rule__BoolExp__LeftAssignment_0_1 ) ) )
            // InternalStoryGen.g:1176:1: ( ( rule__BoolExp__LeftAssignment_0_1 ) )
            {
            // InternalStoryGen.g:1176:1: ( ( rule__BoolExp__LeftAssignment_0_1 ) )
            // InternalStoryGen.g:1177:2: ( rule__BoolExp__LeftAssignment_0_1 )
            {
             before(grammarAccess.getBoolExpAccess().getLeftAssignment_0_1()); 
            // InternalStoryGen.g:1178:2: ( rule__BoolExp__LeftAssignment_0_1 )
            // InternalStoryGen.g:1178:3: rule__BoolExp__LeftAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__BoolExp__LeftAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getBoolExpAccess().getLeftAssignment_0_1()); 

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
    // $ANTLR end "rule__BoolExp__Group_0__1__Impl"


    // $ANTLR start "rule__BoolExp__Group_0__2"
    // InternalStoryGen.g:1186:1: rule__BoolExp__Group_0__2 : rule__BoolExp__Group_0__2__Impl rule__BoolExp__Group_0__3 ;
    public final void rule__BoolExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1190:1: ( rule__BoolExp__Group_0__2__Impl rule__BoolExp__Group_0__3 )
            // InternalStoryGen.g:1191:2: rule__BoolExp__Group_0__2__Impl rule__BoolExp__Group_0__3
            {
            pushFollow(FOLLOW_15);
            rule__BoolExp__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolExp__Group_0__3();

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
    // $ANTLR end "rule__BoolExp__Group_0__2"


    // $ANTLR start "rule__BoolExp__Group_0__2__Impl"
    // InternalStoryGen.g:1198:1: rule__BoolExp__Group_0__2__Impl : ( ')' ) ;
    public final void rule__BoolExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1202:1: ( ( ')' ) )
            // InternalStoryGen.g:1203:1: ( ')' )
            {
            // InternalStoryGen.g:1203:1: ( ')' )
            // InternalStoryGen.g:1204:2: ')'
            {
             before(grammarAccess.getBoolExpAccess().getRightParenthesisKeyword_0_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getBoolExpAccess().getRightParenthesisKeyword_0_2()); 

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
    // $ANTLR end "rule__BoolExp__Group_0__2__Impl"


    // $ANTLR start "rule__BoolExp__Group_0__3"
    // InternalStoryGen.g:1213:1: rule__BoolExp__Group_0__3 : rule__BoolExp__Group_0__3__Impl rule__BoolExp__Group_0__4 ;
    public final void rule__BoolExp__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1217:1: ( rule__BoolExp__Group_0__3__Impl rule__BoolExp__Group_0__4 )
            // InternalStoryGen.g:1218:2: rule__BoolExp__Group_0__3__Impl rule__BoolExp__Group_0__4
            {
            pushFollow(FOLLOW_16);
            rule__BoolExp__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolExp__Group_0__4();

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
    // $ANTLR end "rule__BoolExp__Group_0__3"


    // $ANTLR start "rule__BoolExp__Group_0__3__Impl"
    // InternalStoryGen.g:1225:1: rule__BoolExp__Group_0__3__Impl : ( ( rule__BoolExp__BoolOpAssignment_0_3 ) ) ;
    public final void rule__BoolExp__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1229:1: ( ( ( rule__BoolExp__BoolOpAssignment_0_3 ) ) )
            // InternalStoryGen.g:1230:1: ( ( rule__BoolExp__BoolOpAssignment_0_3 ) )
            {
            // InternalStoryGen.g:1230:1: ( ( rule__BoolExp__BoolOpAssignment_0_3 ) )
            // InternalStoryGen.g:1231:2: ( rule__BoolExp__BoolOpAssignment_0_3 )
            {
             before(grammarAccess.getBoolExpAccess().getBoolOpAssignment_0_3()); 
            // InternalStoryGen.g:1232:2: ( rule__BoolExp__BoolOpAssignment_0_3 )
            // InternalStoryGen.g:1232:3: rule__BoolExp__BoolOpAssignment_0_3
            {
            pushFollow(FOLLOW_2);
            rule__BoolExp__BoolOpAssignment_0_3();

            state._fsp--;


            }

             after(grammarAccess.getBoolExpAccess().getBoolOpAssignment_0_3()); 

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
    // $ANTLR end "rule__BoolExp__Group_0__3__Impl"


    // $ANTLR start "rule__BoolExp__Group_0__4"
    // InternalStoryGen.g:1240:1: rule__BoolExp__Group_0__4 : rule__BoolExp__Group_0__4__Impl rule__BoolExp__Group_0__5 ;
    public final void rule__BoolExp__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1244:1: ( rule__BoolExp__Group_0__4__Impl rule__BoolExp__Group_0__5 )
            // InternalStoryGen.g:1245:2: rule__BoolExp__Group_0__4__Impl rule__BoolExp__Group_0__5
            {
            pushFollow(FOLLOW_13);
            rule__BoolExp__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolExp__Group_0__5();

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
    // $ANTLR end "rule__BoolExp__Group_0__4"


    // $ANTLR start "rule__BoolExp__Group_0__4__Impl"
    // InternalStoryGen.g:1252:1: rule__BoolExp__Group_0__4__Impl : ( '(' ) ;
    public final void rule__BoolExp__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1256:1: ( ( '(' ) )
            // InternalStoryGen.g:1257:1: ( '(' )
            {
            // InternalStoryGen.g:1257:1: ( '(' )
            // InternalStoryGen.g:1258:2: '('
            {
             before(grammarAccess.getBoolExpAccess().getLeftParenthesisKeyword_0_4()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getBoolExpAccess().getLeftParenthesisKeyword_0_4()); 

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
    // $ANTLR end "rule__BoolExp__Group_0__4__Impl"


    // $ANTLR start "rule__BoolExp__Group_0__5"
    // InternalStoryGen.g:1267:1: rule__BoolExp__Group_0__5 : rule__BoolExp__Group_0__5__Impl rule__BoolExp__Group_0__6 ;
    public final void rule__BoolExp__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1271:1: ( rule__BoolExp__Group_0__5__Impl rule__BoolExp__Group_0__6 )
            // InternalStoryGen.g:1272:2: rule__BoolExp__Group_0__5__Impl rule__BoolExp__Group_0__6
            {
            pushFollow(FOLLOW_14);
            rule__BoolExp__Group_0__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolExp__Group_0__6();

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
    // $ANTLR end "rule__BoolExp__Group_0__5"


    // $ANTLR start "rule__BoolExp__Group_0__5__Impl"
    // InternalStoryGen.g:1279:1: rule__BoolExp__Group_0__5__Impl : ( ( rule__BoolExp__RightAssignment_0_5 ) ) ;
    public final void rule__BoolExp__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1283:1: ( ( ( rule__BoolExp__RightAssignment_0_5 ) ) )
            // InternalStoryGen.g:1284:1: ( ( rule__BoolExp__RightAssignment_0_5 ) )
            {
            // InternalStoryGen.g:1284:1: ( ( rule__BoolExp__RightAssignment_0_5 ) )
            // InternalStoryGen.g:1285:2: ( rule__BoolExp__RightAssignment_0_5 )
            {
             before(grammarAccess.getBoolExpAccess().getRightAssignment_0_5()); 
            // InternalStoryGen.g:1286:2: ( rule__BoolExp__RightAssignment_0_5 )
            // InternalStoryGen.g:1286:3: rule__BoolExp__RightAssignment_0_5
            {
            pushFollow(FOLLOW_2);
            rule__BoolExp__RightAssignment_0_5();

            state._fsp--;


            }

             after(grammarAccess.getBoolExpAccess().getRightAssignment_0_5()); 

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
    // $ANTLR end "rule__BoolExp__Group_0__5__Impl"


    // $ANTLR start "rule__BoolExp__Group_0__6"
    // InternalStoryGen.g:1294:1: rule__BoolExp__Group_0__6 : rule__BoolExp__Group_0__6__Impl ;
    public final void rule__BoolExp__Group_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1298:1: ( rule__BoolExp__Group_0__6__Impl )
            // InternalStoryGen.g:1299:2: rule__BoolExp__Group_0__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BoolExp__Group_0__6__Impl();

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
    // $ANTLR end "rule__BoolExp__Group_0__6"


    // $ANTLR start "rule__BoolExp__Group_0__6__Impl"
    // InternalStoryGen.g:1305:1: rule__BoolExp__Group_0__6__Impl : ( ')' ) ;
    public final void rule__BoolExp__Group_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1309:1: ( ( ')' ) )
            // InternalStoryGen.g:1310:1: ( ')' )
            {
            // InternalStoryGen.g:1310:1: ( ')' )
            // InternalStoryGen.g:1311:2: ')'
            {
             before(grammarAccess.getBoolExpAccess().getRightParenthesisKeyword_0_6()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getBoolExpAccess().getRightParenthesisKeyword_0_6()); 

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
    // $ANTLR end "rule__BoolExp__Group_0__6__Impl"


    // $ANTLR start "rule__BinaryBoolExp__Group__0"
    // InternalStoryGen.g:1321:1: rule__BinaryBoolExp__Group__0 : rule__BinaryBoolExp__Group__0__Impl rule__BinaryBoolExp__Group__1 ;
    public final void rule__BinaryBoolExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1325:1: ( rule__BinaryBoolExp__Group__0__Impl rule__BinaryBoolExp__Group__1 )
            // InternalStoryGen.g:1326:2: rule__BinaryBoolExp__Group__0__Impl rule__BinaryBoolExp__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__BinaryBoolExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryBoolExp__Group__1();

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
    // $ANTLR end "rule__BinaryBoolExp__Group__0"


    // $ANTLR start "rule__BinaryBoolExp__Group__0__Impl"
    // InternalStoryGen.g:1333:1: rule__BinaryBoolExp__Group__0__Impl : ( ( rule__BinaryBoolExp__LeftAssignment_0 ) ) ;
    public final void rule__BinaryBoolExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1337:1: ( ( ( rule__BinaryBoolExp__LeftAssignment_0 ) ) )
            // InternalStoryGen.g:1338:1: ( ( rule__BinaryBoolExp__LeftAssignment_0 ) )
            {
            // InternalStoryGen.g:1338:1: ( ( rule__BinaryBoolExp__LeftAssignment_0 ) )
            // InternalStoryGen.g:1339:2: ( rule__BinaryBoolExp__LeftAssignment_0 )
            {
             before(grammarAccess.getBinaryBoolExpAccess().getLeftAssignment_0()); 
            // InternalStoryGen.g:1340:2: ( rule__BinaryBoolExp__LeftAssignment_0 )
            // InternalStoryGen.g:1340:3: rule__BinaryBoolExp__LeftAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BinaryBoolExp__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBinaryBoolExpAccess().getLeftAssignment_0()); 

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
    // $ANTLR end "rule__BinaryBoolExp__Group__0__Impl"


    // $ANTLR start "rule__BinaryBoolExp__Group__1"
    // InternalStoryGen.g:1348:1: rule__BinaryBoolExp__Group__1 : rule__BinaryBoolExp__Group__1__Impl rule__BinaryBoolExp__Group__2 ;
    public final void rule__BinaryBoolExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1352:1: ( rule__BinaryBoolExp__Group__1__Impl rule__BinaryBoolExp__Group__2 )
            // InternalStoryGen.g:1353:2: rule__BinaryBoolExp__Group__1__Impl rule__BinaryBoolExp__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__BinaryBoolExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryBoolExp__Group__2();

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
    // $ANTLR end "rule__BinaryBoolExp__Group__1"


    // $ANTLR start "rule__BinaryBoolExp__Group__1__Impl"
    // InternalStoryGen.g:1360:1: rule__BinaryBoolExp__Group__1__Impl : ( ( rule__BinaryBoolExp__BoolOpAssignment_1 ) ) ;
    public final void rule__BinaryBoolExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1364:1: ( ( ( rule__BinaryBoolExp__BoolOpAssignment_1 ) ) )
            // InternalStoryGen.g:1365:1: ( ( rule__BinaryBoolExp__BoolOpAssignment_1 ) )
            {
            // InternalStoryGen.g:1365:1: ( ( rule__BinaryBoolExp__BoolOpAssignment_1 ) )
            // InternalStoryGen.g:1366:2: ( rule__BinaryBoolExp__BoolOpAssignment_1 )
            {
             before(grammarAccess.getBinaryBoolExpAccess().getBoolOpAssignment_1()); 
            // InternalStoryGen.g:1367:2: ( rule__BinaryBoolExp__BoolOpAssignment_1 )
            // InternalStoryGen.g:1367:3: rule__BinaryBoolExp__BoolOpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BinaryBoolExp__BoolOpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBinaryBoolExpAccess().getBoolOpAssignment_1()); 

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
    // $ANTLR end "rule__BinaryBoolExp__Group__1__Impl"


    // $ANTLR start "rule__BinaryBoolExp__Group__2"
    // InternalStoryGen.g:1375:1: rule__BinaryBoolExp__Group__2 : rule__BinaryBoolExp__Group__2__Impl ;
    public final void rule__BinaryBoolExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1379:1: ( rule__BinaryBoolExp__Group__2__Impl )
            // InternalStoryGen.g:1380:2: rule__BinaryBoolExp__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryBoolExp__Group__2__Impl();

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
    // $ANTLR end "rule__BinaryBoolExp__Group__2"


    // $ANTLR start "rule__BinaryBoolExp__Group__2__Impl"
    // InternalStoryGen.g:1386:1: rule__BinaryBoolExp__Group__2__Impl : ( ( rule__BinaryBoolExp__RightAssignment_2 ) ) ;
    public final void rule__BinaryBoolExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1390:1: ( ( ( rule__BinaryBoolExp__RightAssignment_2 ) ) )
            // InternalStoryGen.g:1391:1: ( ( rule__BinaryBoolExp__RightAssignment_2 ) )
            {
            // InternalStoryGen.g:1391:1: ( ( rule__BinaryBoolExp__RightAssignment_2 ) )
            // InternalStoryGen.g:1392:2: ( rule__BinaryBoolExp__RightAssignment_2 )
            {
             before(grammarAccess.getBinaryBoolExpAccess().getRightAssignment_2()); 
            // InternalStoryGen.g:1393:2: ( rule__BinaryBoolExp__RightAssignment_2 )
            // InternalStoryGen.g:1393:3: rule__BinaryBoolExp__RightAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BinaryBoolExp__RightAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBinaryBoolExpAccess().getRightAssignment_2()); 

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
    // $ANTLR end "rule__BinaryBoolExp__Group__2__Impl"


    // $ANTLR start "rule__BinaryQntyExp__Group__0"
    // InternalStoryGen.g:1402:1: rule__BinaryQntyExp__Group__0 : rule__BinaryQntyExp__Group__0__Impl rule__BinaryQntyExp__Group__1 ;
    public final void rule__BinaryQntyExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1406:1: ( rule__BinaryQntyExp__Group__0__Impl rule__BinaryQntyExp__Group__1 )
            // InternalStoryGen.g:1407:2: rule__BinaryQntyExp__Group__0__Impl rule__BinaryQntyExp__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__BinaryQntyExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryQntyExp__Group__1();

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
    // $ANTLR end "rule__BinaryQntyExp__Group__0"


    // $ANTLR start "rule__BinaryQntyExp__Group__0__Impl"
    // InternalStoryGen.g:1414:1: rule__BinaryQntyExp__Group__0__Impl : ( ( rule__BinaryQntyExp__LeftAssignment_0 ) ) ;
    public final void rule__BinaryQntyExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1418:1: ( ( ( rule__BinaryQntyExp__LeftAssignment_0 ) ) )
            // InternalStoryGen.g:1419:1: ( ( rule__BinaryQntyExp__LeftAssignment_0 ) )
            {
            // InternalStoryGen.g:1419:1: ( ( rule__BinaryQntyExp__LeftAssignment_0 ) )
            // InternalStoryGen.g:1420:2: ( rule__BinaryQntyExp__LeftAssignment_0 )
            {
             before(grammarAccess.getBinaryQntyExpAccess().getLeftAssignment_0()); 
            // InternalStoryGen.g:1421:2: ( rule__BinaryQntyExp__LeftAssignment_0 )
            // InternalStoryGen.g:1421:3: rule__BinaryQntyExp__LeftAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BinaryQntyExp__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBinaryQntyExpAccess().getLeftAssignment_0()); 

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
    // $ANTLR end "rule__BinaryQntyExp__Group__0__Impl"


    // $ANTLR start "rule__BinaryQntyExp__Group__1"
    // InternalStoryGen.g:1429:1: rule__BinaryQntyExp__Group__1 : rule__BinaryQntyExp__Group__1__Impl rule__BinaryQntyExp__Group__2 ;
    public final void rule__BinaryQntyExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1433:1: ( rule__BinaryQntyExp__Group__1__Impl rule__BinaryQntyExp__Group__2 )
            // InternalStoryGen.g:1434:2: rule__BinaryQntyExp__Group__1__Impl rule__BinaryQntyExp__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__BinaryQntyExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryQntyExp__Group__2();

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
    // $ANTLR end "rule__BinaryQntyExp__Group__1"


    // $ANTLR start "rule__BinaryQntyExp__Group__1__Impl"
    // InternalStoryGen.g:1441:1: rule__BinaryQntyExp__Group__1__Impl : ( ( rule__BinaryQntyExp__NumOpAssignment_1 ) ) ;
    public final void rule__BinaryQntyExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1445:1: ( ( ( rule__BinaryQntyExp__NumOpAssignment_1 ) ) )
            // InternalStoryGen.g:1446:1: ( ( rule__BinaryQntyExp__NumOpAssignment_1 ) )
            {
            // InternalStoryGen.g:1446:1: ( ( rule__BinaryQntyExp__NumOpAssignment_1 ) )
            // InternalStoryGen.g:1447:2: ( rule__BinaryQntyExp__NumOpAssignment_1 )
            {
             before(grammarAccess.getBinaryQntyExpAccess().getNumOpAssignment_1()); 
            // InternalStoryGen.g:1448:2: ( rule__BinaryQntyExp__NumOpAssignment_1 )
            // InternalStoryGen.g:1448:3: rule__BinaryQntyExp__NumOpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BinaryQntyExp__NumOpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBinaryQntyExpAccess().getNumOpAssignment_1()); 

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
    // $ANTLR end "rule__BinaryQntyExp__Group__1__Impl"


    // $ANTLR start "rule__BinaryQntyExp__Group__2"
    // InternalStoryGen.g:1456:1: rule__BinaryQntyExp__Group__2 : rule__BinaryQntyExp__Group__2__Impl ;
    public final void rule__BinaryQntyExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1460:1: ( rule__BinaryQntyExp__Group__2__Impl )
            // InternalStoryGen.g:1461:2: rule__BinaryQntyExp__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryQntyExp__Group__2__Impl();

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
    // $ANTLR end "rule__BinaryQntyExp__Group__2"


    // $ANTLR start "rule__BinaryQntyExp__Group__2__Impl"
    // InternalStoryGen.g:1467:1: rule__BinaryQntyExp__Group__2__Impl : ( ( rule__BinaryQntyExp__RightAssignment_2 ) ) ;
    public final void rule__BinaryQntyExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1471:1: ( ( ( rule__BinaryQntyExp__RightAssignment_2 ) ) )
            // InternalStoryGen.g:1472:1: ( ( rule__BinaryQntyExp__RightAssignment_2 ) )
            {
            // InternalStoryGen.g:1472:1: ( ( rule__BinaryQntyExp__RightAssignment_2 ) )
            // InternalStoryGen.g:1473:2: ( rule__BinaryQntyExp__RightAssignment_2 )
            {
             before(grammarAccess.getBinaryQntyExpAccess().getRightAssignment_2()); 
            // InternalStoryGen.g:1474:2: ( rule__BinaryQntyExp__RightAssignment_2 )
            // InternalStoryGen.g:1474:3: rule__BinaryQntyExp__RightAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BinaryQntyExp__RightAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBinaryQntyExpAccess().getRightAssignment_2()); 

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
    // $ANTLR end "rule__BinaryQntyExp__Group__2__Impl"


    // $ANTLR start "rule__NegateBoolExp__Group__0"
    // InternalStoryGen.g:1483:1: rule__NegateBoolExp__Group__0 : rule__NegateBoolExp__Group__0__Impl rule__NegateBoolExp__Group__1 ;
    public final void rule__NegateBoolExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1487:1: ( rule__NegateBoolExp__Group__0__Impl rule__NegateBoolExp__Group__1 )
            // InternalStoryGen.g:1488:2: rule__NegateBoolExp__Group__0__Impl rule__NegateBoolExp__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__NegateBoolExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NegateBoolExp__Group__1();

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
    // $ANTLR end "rule__NegateBoolExp__Group__0"


    // $ANTLR start "rule__NegateBoolExp__Group__0__Impl"
    // InternalStoryGen.g:1495:1: rule__NegateBoolExp__Group__0__Impl : ( 'not' ) ;
    public final void rule__NegateBoolExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1499:1: ( ( 'not' ) )
            // InternalStoryGen.g:1500:1: ( 'not' )
            {
            // InternalStoryGen.g:1500:1: ( 'not' )
            // InternalStoryGen.g:1501:2: 'not'
            {
             before(grammarAccess.getNegateBoolExpAccess().getNotKeyword_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getNegateBoolExpAccess().getNotKeyword_0()); 

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
    // $ANTLR end "rule__NegateBoolExp__Group__0__Impl"


    // $ANTLR start "rule__NegateBoolExp__Group__1"
    // InternalStoryGen.g:1510:1: rule__NegateBoolExp__Group__1 : rule__NegateBoolExp__Group__1__Impl ;
    public final void rule__NegateBoolExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1514:1: ( rule__NegateBoolExp__Group__1__Impl )
            // InternalStoryGen.g:1515:2: rule__NegateBoolExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NegateBoolExp__Group__1__Impl();

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
    // $ANTLR end "rule__NegateBoolExp__Group__1"


    // $ANTLR start "rule__NegateBoolExp__Group__1__Impl"
    // InternalStoryGen.g:1521:1: rule__NegateBoolExp__Group__1__Impl : ( ruleBoolExp ) ;
    public final void rule__NegateBoolExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1525:1: ( ( ruleBoolExp ) )
            // InternalStoryGen.g:1526:1: ( ruleBoolExp )
            {
            // InternalStoryGen.g:1526:1: ( ruleBoolExp )
            // InternalStoryGen.g:1527:2: ruleBoolExp
            {
             before(grammarAccess.getNegateBoolExpAccess().getBoolExpParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleBoolExp();

            state._fsp--;

             after(grammarAccess.getNegateBoolExpAccess().getBoolExpParserRuleCall_1()); 

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
    // $ANTLR end "rule__NegateBoolExp__Group__1__Impl"


    // $ANTLR start "rule__Story__WorldAssignment_0"
    // InternalStoryGen.g:1537:1: rule__Story__WorldAssignment_0 : ( ruleWorld ) ;
    public final void rule__Story__WorldAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1541:1: ( ( ruleWorld ) )
            // InternalStoryGen.g:1542:2: ( ruleWorld )
            {
            // InternalStoryGen.g:1542:2: ( ruleWorld )
            // InternalStoryGen.g:1543:3: ruleWorld
            {
             before(grammarAccess.getStoryAccess().getWorldWorldParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleWorld();

            state._fsp--;

             after(grammarAccess.getStoryAccess().getWorldWorldParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Story__WorldAssignment_0"


    // $ANTLR start "rule__Story__EventsAssignment_1"
    // InternalStoryGen.g:1552:1: rule__Story__EventsAssignment_1 : ( ruleEvent ) ;
    public final void rule__Story__EventsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1556:1: ( ( ruleEvent ) )
            // InternalStoryGen.g:1557:2: ( ruleEvent )
            {
            // InternalStoryGen.g:1557:2: ( ruleEvent )
            // InternalStoryGen.g:1558:3: ruleEvent
            {
             before(grammarAccess.getStoryAccess().getEventsEventParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getStoryAccess().getEventsEventParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Story__EventsAssignment_1"


    // $ANTLR start "rule__World__AttributesAssignment_3"
    // InternalStoryGen.g:1567:1: rule__World__AttributesAssignment_3 : ( ruleAttribute ) ;
    public final void rule__World__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1571:1: ( ( ruleAttribute ) )
            // InternalStoryGen.g:1572:2: ( ruleAttribute )
            {
            // InternalStoryGen.g:1572:2: ( ruleAttribute )
            // InternalStoryGen.g:1573:3: ruleAttribute
            {
             before(grammarAccess.getWorldAccess().getAttributesAttributeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getWorldAccess().getAttributesAttributeParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__World__AttributesAssignment_3"


    // $ANTLR start "rule__Attribute__AttrTypeAssignment_0"
    // InternalStoryGen.g:1582:1: rule__Attribute__AttrTypeAssignment_0 : ( ruleAttrType ) ;
    public final void rule__Attribute__AttrTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1586:1: ( ( ruleAttrType ) )
            // InternalStoryGen.g:1587:2: ( ruleAttrType )
            {
            // InternalStoryGen.g:1587:2: ( ruleAttrType )
            // InternalStoryGen.g:1588:3: ruleAttrType
            {
             before(grammarAccess.getAttributeAccess().getAttrTypeAttrTypeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAttrType();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getAttrTypeAttrTypeEnumRuleCall_0_0()); 

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
    // $ANTLR end "rule__Attribute__AttrTypeAssignment_0"


    // $ANTLR start "rule__Attribute__NameAssignment_1"
    // InternalStoryGen.g:1597:1: rule__Attribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1601:1: ( ( RULE_ID ) )
            // InternalStoryGen.g:1602:2: ( RULE_ID )
            {
            // InternalStoryGen.g:1602:2: ( RULE_ID )
            // InternalStoryGen.g:1603:3: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Attribute__NameAssignment_1"


    // $ANTLR start "rule__Event__AbstractAssignment_0"
    // InternalStoryGen.g:1612:1: rule__Event__AbstractAssignment_0 : ( ( 'abstract' ) ) ;
    public final void rule__Event__AbstractAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1616:1: ( ( ( 'abstract' ) ) )
            // InternalStoryGen.g:1617:2: ( ( 'abstract' ) )
            {
            // InternalStoryGen.g:1617:2: ( ( 'abstract' ) )
            // InternalStoryGen.g:1618:3: ( 'abstract' )
            {
             before(grammarAccess.getEventAccess().getAbstractAbstractKeyword_0_0()); 
            // InternalStoryGen.g:1619:3: ( 'abstract' )
            // InternalStoryGen.g:1620:4: 'abstract'
            {
             before(grammarAccess.getEventAccess().getAbstractAbstractKeyword_0_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getEventAccess().getAbstractAbstractKeyword_0_0()); 

            }

             after(grammarAccess.getEventAccess().getAbstractAbstractKeyword_0_0()); 

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
    // $ANTLR end "rule__Event__AbstractAssignment_0"


    // $ANTLR start "rule__Event__NameAssignment_2"
    // InternalStoryGen.g:1631:1: rule__Event__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Event__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1635:1: ( ( RULE_ID ) )
            // InternalStoryGen.g:1636:2: ( RULE_ID )
            {
            // InternalStoryGen.g:1636:2: ( RULE_ID )
            // InternalStoryGen.g:1637:3: RULE_ID
            {
             before(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Event__NameAssignment_2"


    // $ANTLR start "rule__Event__SuperTypeAssignment_3_1"
    // InternalStoryGen.g:1646:1: rule__Event__SuperTypeAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Event__SuperTypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1650:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:1651:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:1651:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:1652:3: ( RULE_ID )
            {
             before(grammarAccess.getEventAccess().getSuperTypeEventCrossReference_3_1_0()); 
            // InternalStoryGen.g:1653:3: ( RULE_ID )
            // InternalStoryGen.g:1654:4: RULE_ID
            {
             before(grammarAccess.getEventAccess().getSuperTypeEventIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEventAccess().getSuperTypeEventIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getEventAccess().getSuperTypeEventCrossReference_3_1_0()); 

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
    // $ANTLR end "rule__Event__SuperTypeAssignment_3_1"


    // $ANTLR start "rule__Event__ConditionsAssignment_5"
    // InternalStoryGen.g:1665:1: rule__Event__ConditionsAssignment_5 : ( ruleCondition ) ;
    public final void rule__Event__ConditionsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1669:1: ( ( ruleCondition ) )
            // InternalStoryGen.g:1670:2: ( ruleCondition )
            {
            // InternalStoryGen.g:1670:2: ( ruleCondition )
            // InternalStoryGen.g:1671:3: ruleCondition
            {
             before(grammarAccess.getEventAccess().getConditionsConditionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getEventAccess().getConditionsConditionParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__Event__ConditionsAssignment_5"


    // $ANTLR start "rule__Condition__BoolExpAssignment_1"
    // InternalStoryGen.g:1680:1: rule__Condition__BoolExpAssignment_1 : ( ruleBoolExp ) ;
    public final void rule__Condition__BoolExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1684:1: ( ( ruleBoolExp ) )
            // InternalStoryGen.g:1685:2: ( ruleBoolExp )
            {
            // InternalStoryGen.g:1685:2: ( ruleBoolExp )
            // InternalStoryGen.g:1686:3: ruleBoolExp
            {
             before(grammarAccess.getConditionAccess().getBoolExpBoolExpParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBoolExp();

            state._fsp--;

             after(grammarAccess.getConditionAccess().getBoolExpBoolExpParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Condition__BoolExpAssignment_1"


    // $ANTLR start "rule__BoolExp__LeftAssignment_0_1"
    // InternalStoryGen.g:1695:1: rule__BoolExp__LeftAssignment_0_1 : ( ruleBoolExp ) ;
    public final void rule__BoolExp__LeftAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1699:1: ( ( ruleBoolExp ) )
            // InternalStoryGen.g:1700:2: ( ruleBoolExp )
            {
            // InternalStoryGen.g:1700:2: ( ruleBoolExp )
            // InternalStoryGen.g:1701:3: ruleBoolExp
            {
             before(grammarAccess.getBoolExpAccess().getLeftBoolExpParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBoolExp();

            state._fsp--;

             after(grammarAccess.getBoolExpAccess().getLeftBoolExpParserRuleCall_0_1_0()); 

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
    // $ANTLR end "rule__BoolExp__LeftAssignment_0_1"


    // $ANTLR start "rule__BoolExp__BoolOpAssignment_0_3"
    // InternalStoryGen.g:1710:1: rule__BoolExp__BoolOpAssignment_0_3 : ( ruleBoolOp ) ;
    public final void rule__BoolExp__BoolOpAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1714:1: ( ( ruleBoolOp ) )
            // InternalStoryGen.g:1715:2: ( ruleBoolOp )
            {
            // InternalStoryGen.g:1715:2: ( ruleBoolOp )
            // InternalStoryGen.g:1716:3: ruleBoolOp
            {
             before(grammarAccess.getBoolExpAccess().getBoolOpBoolOpEnumRuleCall_0_3_0()); 
            pushFollow(FOLLOW_2);
            ruleBoolOp();

            state._fsp--;

             after(grammarAccess.getBoolExpAccess().getBoolOpBoolOpEnumRuleCall_0_3_0()); 

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
    // $ANTLR end "rule__BoolExp__BoolOpAssignment_0_3"


    // $ANTLR start "rule__BoolExp__RightAssignment_0_5"
    // InternalStoryGen.g:1725:1: rule__BoolExp__RightAssignment_0_5 : ( ruleBoolExp ) ;
    public final void rule__BoolExp__RightAssignment_0_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1729:1: ( ( ruleBoolExp ) )
            // InternalStoryGen.g:1730:2: ( ruleBoolExp )
            {
            // InternalStoryGen.g:1730:2: ( ruleBoolExp )
            // InternalStoryGen.g:1731:3: ruleBoolExp
            {
             before(grammarAccess.getBoolExpAccess().getRightBoolExpParserRuleCall_0_5_0()); 
            pushFollow(FOLLOW_2);
            ruleBoolExp();

            state._fsp--;

             after(grammarAccess.getBoolExpAccess().getRightBoolExpParserRuleCall_0_5_0()); 

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
    // $ANTLR end "rule__BoolExp__RightAssignment_0_5"


    // $ANTLR start "rule__BoolExp__BinaryBoolAssignment_1"
    // InternalStoryGen.g:1740:1: rule__BoolExp__BinaryBoolAssignment_1 : ( ruleBinaryBoolExp ) ;
    public final void rule__BoolExp__BinaryBoolAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1744:1: ( ( ruleBinaryBoolExp ) )
            // InternalStoryGen.g:1745:2: ( ruleBinaryBoolExp )
            {
            // InternalStoryGen.g:1745:2: ( ruleBinaryBoolExp )
            // InternalStoryGen.g:1746:3: ruleBinaryBoolExp
            {
             before(grammarAccess.getBoolExpAccess().getBinaryBoolBinaryBoolExpParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryBoolExp();

            state._fsp--;

             after(grammarAccess.getBoolExpAccess().getBinaryBoolBinaryBoolExpParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__BoolExp__BinaryBoolAssignment_1"


    // $ANTLR start "rule__BoolExp__BinaryQntyAssignment_2"
    // InternalStoryGen.g:1755:1: rule__BoolExp__BinaryQntyAssignment_2 : ( ruleBinaryQntyExp ) ;
    public final void rule__BoolExp__BinaryQntyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1759:1: ( ( ruleBinaryQntyExp ) )
            // InternalStoryGen.g:1760:2: ( ruleBinaryQntyExp )
            {
            // InternalStoryGen.g:1760:2: ( ruleBinaryQntyExp )
            // InternalStoryGen.g:1761:3: ruleBinaryQntyExp
            {
             before(grammarAccess.getBoolExpAccess().getBinaryQntyBinaryQntyExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryQntyExp();

            state._fsp--;

             after(grammarAccess.getBoolExpAccess().getBinaryQntyBinaryQntyExpParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__BoolExp__BinaryQntyAssignment_2"


    // $ANTLR start "rule__BoolExp__NegateBoolExpAssignment_3"
    // InternalStoryGen.g:1770:1: rule__BoolExp__NegateBoolExpAssignment_3 : ( ruleNegateBoolExp ) ;
    public final void rule__BoolExp__NegateBoolExpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1774:1: ( ( ruleNegateBoolExp ) )
            // InternalStoryGen.g:1775:2: ( ruleNegateBoolExp )
            {
            // InternalStoryGen.g:1775:2: ( ruleNegateBoolExp )
            // InternalStoryGen.g:1776:3: ruleNegateBoolExp
            {
             before(grammarAccess.getBoolExpAccess().getNegateBoolExpNegateBoolExpParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleNegateBoolExp();

            state._fsp--;

             after(grammarAccess.getBoolExpAccess().getNegateBoolExpNegateBoolExpParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__BoolExp__NegateBoolExpAssignment_3"


    // $ANTLR start "rule__BoolExp__UnaryBoolAssignment_4"
    // InternalStoryGen.g:1785:1: rule__BoolExp__UnaryBoolAssignment_4 : ( ruleUnaryBoolExp ) ;
    public final void rule__BoolExp__UnaryBoolAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1789:1: ( ( ruleUnaryBoolExp ) )
            // InternalStoryGen.g:1790:2: ( ruleUnaryBoolExp )
            {
            // InternalStoryGen.g:1790:2: ( ruleUnaryBoolExp )
            // InternalStoryGen.g:1791:3: ruleUnaryBoolExp
            {
             before(grammarAccess.getBoolExpAccess().getUnaryBoolUnaryBoolExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryBoolExp();

            state._fsp--;

             after(grammarAccess.getBoolExpAccess().getUnaryBoolUnaryBoolExpParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__BoolExp__UnaryBoolAssignment_4"


    // $ANTLR start "rule__BinaryBoolExp__LeftAssignment_0"
    // InternalStoryGen.g:1800:1: rule__BinaryBoolExp__LeftAssignment_0 : ( ruleUnaryBoolExp ) ;
    public final void rule__BinaryBoolExp__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1804:1: ( ( ruleUnaryBoolExp ) )
            // InternalStoryGen.g:1805:2: ( ruleUnaryBoolExp )
            {
            // InternalStoryGen.g:1805:2: ( ruleUnaryBoolExp )
            // InternalStoryGen.g:1806:3: ruleUnaryBoolExp
            {
             before(grammarAccess.getBinaryBoolExpAccess().getLeftUnaryBoolExpParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryBoolExp();

            state._fsp--;

             after(grammarAccess.getBinaryBoolExpAccess().getLeftUnaryBoolExpParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__BinaryBoolExp__LeftAssignment_0"


    // $ANTLR start "rule__BinaryBoolExp__BoolOpAssignment_1"
    // InternalStoryGen.g:1815:1: rule__BinaryBoolExp__BoolOpAssignment_1 : ( ruleBoolOp ) ;
    public final void rule__BinaryBoolExp__BoolOpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1819:1: ( ( ruleBoolOp ) )
            // InternalStoryGen.g:1820:2: ( ruleBoolOp )
            {
            // InternalStoryGen.g:1820:2: ( ruleBoolOp )
            // InternalStoryGen.g:1821:3: ruleBoolOp
            {
             before(grammarAccess.getBinaryBoolExpAccess().getBoolOpBoolOpEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBoolOp();

            state._fsp--;

             after(grammarAccess.getBinaryBoolExpAccess().getBoolOpBoolOpEnumRuleCall_1_0()); 

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
    // $ANTLR end "rule__BinaryBoolExp__BoolOpAssignment_1"


    // $ANTLR start "rule__BinaryBoolExp__RightAssignment_2"
    // InternalStoryGen.g:1830:1: rule__BinaryBoolExp__RightAssignment_2 : ( ruleUnaryBoolExp ) ;
    public final void rule__BinaryBoolExp__RightAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1834:1: ( ( ruleUnaryBoolExp ) )
            // InternalStoryGen.g:1835:2: ( ruleUnaryBoolExp )
            {
            // InternalStoryGen.g:1835:2: ( ruleUnaryBoolExp )
            // InternalStoryGen.g:1836:3: ruleUnaryBoolExp
            {
             before(grammarAccess.getBinaryBoolExpAccess().getRightUnaryBoolExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryBoolExp();

            state._fsp--;

             after(grammarAccess.getBinaryBoolExpAccess().getRightUnaryBoolExpParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__BinaryBoolExp__RightAssignment_2"


    // $ANTLR start "rule__BinaryQntyExp__LeftAssignment_0"
    // InternalStoryGen.g:1845:1: rule__BinaryQntyExp__LeftAssignment_0 : ( ruleUnaryQuantityExp ) ;
    public final void rule__BinaryQntyExp__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1849:1: ( ( ruleUnaryQuantityExp ) )
            // InternalStoryGen.g:1850:2: ( ruleUnaryQuantityExp )
            {
            // InternalStoryGen.g:1850:2: ( ruleUnaryQuantityExp )
            // InternalStoryGen.g:1851:3: ruleUnaryQuantityExp
            {
             before(grammarAccess.getBinaryQntyExpAccess().getLeftUnaryQuantityExpParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryQuantityExp();

            state._fsp--;

             after(grammarAccess.getBinaryQntyExpAccess().getLeftUnaryQuantityExpParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__BinaryQntyExp__LeftAssignment_0"


    // $ANTLR start "rule__BinaryQntyExp__NumOpAssignment_1"
    // InternalStoryGen.g:1860:1: rule__BinaryQntyExp__NumOpAssignment_1 : ( ruleNumOp ) ;
    public final void rule__BinaryQntyExp__NumOpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1864:1: ( ( ruleNumOp ) )
            // InternalStoryGen.g:1865:2: ( ruleNumOp )
            {
            // InternalStoryGen.g:1865:2: ( ruleNumOp )
            // InternalStoryGen.g:1866:3: ruleNumOp
            {
             before(grammarAccess.getBinaryQntyExpAccess().getNumOpNumOpEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleNumOp();

            state._fsp--;

             after(grammarAccess.getBinaryQntyExpAccess().getNumOpNumOpEnumRuleCall_1_0()); 

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
    // $ANTLR end "rule__BinaryQntyExp__NumOpAssignment_1"


    // $ANTLR start "rule__BinaryQntyExp__RightAssignment_2"
    // InternalStoryGen.g:1875:1: rule__BinaryQntyExp__RightAssignment_2 : ( ruleUnaryQuantityExp ) ;
    public final void rule__BinaryQntyExp__RightAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1879:1: ( ( ruleUnaryQuantityExp ) )
            // InternalStoryGen.g:1880:2: ( ruleUnaryQuantityExp )
            {
            // InternalStoryGen.g:1880:2: ( ruleUnaryQuantityExp )
            // InternalStoryGen.g:1881:3: ruleUnaryQuantityExp
            {
             before(grammarAccess.getBinaryQntyExpAccess().getRightUnaryQuantityExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryQuantityExp();

            state._fsp--;

             after(grammarAccess.getBinaryQntyExpAccess().getRightUnaryQuantityExpParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__BinaryQntyExp__RightAssignment_2"


    // $ANTLR start "rule__UnaryBoolExp__IdAssignment_0"
    // InternalStoryGen.g:1890:1: rule__UnaryBoolExp__IdAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__UnaryBoolExp__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1894:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:1895:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:1895:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:1896:3: ( RULE_ID )
            {
             before(grammarAccess.getUnaryBoolExpAccess().getIdAttributeCrossReference_0_0()); 
            // InternalStoryGen.g:1897:3: ( RULE_ID )
            // InternalStoryGen.g:1898:4: RULE_ID
            {
             before(grammarAccess.getUnaryBoolExpAccess().getIdAttributeIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getUnaryBoolExpAccess().getIdAttributeIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getUnaryBoolExpAccess().getIdAttributeCrossReference_0_0()); 

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
    // $ANTLR end "rule__UnaryBoolExp__IdAssignment_0"


    // $ANTLR start "rule__UnaryBoolExp__ValueAssignment_1"
    // InternalStoryGen.g:1909:1: rule__UnaryBoolExp__ValueAssignment_1 : ( ruleBooleanValue ) ;
    public final void rule__UnaryBoolExp__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1913:1: ( ( ruleBooleanValue ) )
            // InternalStoryGen.g:1914:2: ( ruleBooleanValue )
            {
            // InternalStoryGen.g:1914:2: ( ruleBooleanValue )
            // InternalStoryGen.g:1915:3: ruleBooleanValue
            {
             before(grammarAccess.getUnaryBoolExpAccess().getValueBooleanValueEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanValue();

            state._fsp--;

             after(grammarAccess.getUnaryBoolExpAccess().getValueBooleanValueEnumRuleCall_1_0()); 

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
    // $ANTLR end "rule__UnaryBoolExp__ValueAssignment_1"


    // $ANTLR start "rule__UnaryQuantityExp__IdAssignment_0"
    // InternalStoryGen.g:1924:1: rule__UnaryQuantityExp__IdAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__UnaryQuantityExp__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1928:1: ( ( ( RULE_ID ) ) )
            // InternalStoryGen.g:1929:2: ( ( RULE_ID ) )
            {
            // InternalStoryGen.g:1929:2: ( ( RULE_ID ) )
            // InternalStoryGen.g:1930:3: ( RULE_ID )
            {
             before(grammarAccess.getUnaryQuantityExpAccess().getIdAttributeCrossReference_0_0()); 
            // InternalStoryGen.g:1931:3: ( RULE_ID )
            // InternalStoryGen.g:1932:4: RULE_ID
            {
             before(grammarAccess.getUnaryQuantityExpAccess().getIdAttributeIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getUnaryQuantityExpAccess().getIdAttributeIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getUnaryQuantityExpAccess().getIdAttributeCrossReference_0_0()); 

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
    // $ANTLR end "rule__UnaryQuantityExp__IdAssignment_0"


    // $ANTLR start "rule__UnaryQuantityExp__ValueAssignment_1"
    // InternalStoryGen.g:1943:1: rule__UnaryQuantityExp__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__UnaryQuantityExp__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalStoryGen.g:1947:1: ( ( RULE_INT ) )
            // InternalStoryGen.g:1948:2: ( RULE_INT )
            {
            // InternalStoryGen.g:1948:2: ( RULE_INT )
            // InternalStoryGen.g:1949:3: RULE_INT
            {
             before(grammarAccess.getUnaryQuantityExpAccess().getValueINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getUnaryQuantityExpAccess().getValueINTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__UnaryQuantityExp__ValueAssignment_1"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\2\uffff\3\12\7\uffff";
    static final String dfa_3s = "\1\4\1\uffff\3\17\2\uffff\2\4\3\uffff";
    static final String dfa_4s = "\1\37\1\uffff\3\36\2\uffff\2\16\3\uffff";
    static final String dfa_5s = "\1\uffff\1\1\3\uffff\1\3\1\4\2\uffff\1\2\1\5\1\2";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\5\7\uffff\1\3\1\4\16\uffff\1\1\1\uffff\1\6",
            "",
            "\1\7\1\10\4\5\2\11\2\uffff\1\12\2\uffff\1\12\1\uffff\1\12",
            "\2\11\4\uffff\2\11\2\uffff\1\12\2\uffff\1\12\1\uffff\1\12",
            "\2\11\4\uffff\2\11\2\uffff\1\12\2\uffff\1\12\1\uffff\1\12",
            "",
            "",
            "\1\13\1\5\7\uffff\2\13",
            "\1\13\1\5\7\uffff\2\13",
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

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "391:1: rule__BoolExp__Alternatives : ( ( ( rule__BoolExp__Group_0__0 ) ) | ( ( rule__BoolExp__BinaryBoolAssignment_1 ) ) | ( ( rule__BoolExp__BinaryQntyAssignment_2 ) ) | ( ( rule__BoolExp__NegateBoolExpAssignment_3 ) ) | ( ( rule__BoolExp__UnaryBoolAssignment_4 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000104000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000104000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002001800L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000A0006030L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000618000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000006010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000001F8000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000030L});

}