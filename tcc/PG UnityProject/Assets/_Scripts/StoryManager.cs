using System;
using System.Collections.Generic;
using System.Linq;
 
namespace StoryManager
{
	public static class Story
    {
        public static Space space;
		public static Plot plot;
		private static Selector selector;
		
		public static bool __isOver;
        public static List<Plot.Event> pastEvents;


        public static void Init()
        {
			plot = new Plot();
			space = new Space();
			selector = new Selector();
			
			plot.SetEventsRefs();

			__isOver = false;
			pastEvents = new List<Plot.Event>();
        }

        public static List<Plot.Event> Begin()
        {
            return selector.ApplyOpening();
        }
        
        public static List<Plot.Event> Tick(Plot.Event playerAction)
        {
            return selector.ApplyNext(playerAction);;
        }
        
        public static IDictionary<string, string> GetAttributes()
		{
			var attrs = new Dictionary<string, string>();
			

			return attrs;
		}

        public static List<Plot.ActionEvent> GetPossiblePlayerActions()
        {
            if(Story.__isOver) return new List<Plot.ActionEvent>();
			
            else return space.player.GetPossibleActions();
        }

        public static bool HasEventOcurred(Plot.Event consideredEvent)
        {
            return pastEvents.Any(e => e.Equals(consideredEvent));
        }

        //-----
        #region Story Selector

        public class Selector
        {
            Random random;

            //
            // Constructor
            public Selector()
            {
                random = new Random();
            }

            public List<Plot.Event> ApplyOpening()
            {
                return ApplyEventChanges(plot.opening);
            }

            public List<Plot.Event> ApplyNext(Plot.Event playerAction)
            {
                List<Plot.Event> eventsApplied = new List<Plot.Event>();

                if (playerAction != null)
                {
                    eventsApplied.AddRange(ApplyEventChanges(playerAction));
                }

                if(Story.__isOver) return eventsApplied;

                var actionsToApply = CheckForOtherActorsActions();
                foreach (var action in actionsToApply)
                {
                    if(Story.__isOver) return eventsApplied;

					if(!action.PreconditionsMet()) continue;

                    eventsApplied.AddRange(ApplyEventChanges(action));
                }

                var happeningsToApply = CheckForHappenings();
				foreach (var happening in happeningsToApply)
				{
					if(Story.__isOver) return eventsApplied;
					
					if(!happening.PreconditionsMet()) continue;

					eventsApplied.AddRange(ApplyEventChanges(happening));
				}

                return eventsApplied;
            }


            private List<Plot.Event> ApplyEventChanges(Plot.Event er)
            {
                List<Plot.Event> appliedEvents = new List<Plot.Event>();
                
                er.ApplyChanges();
                Story.pastEvents.Add(er);

				appliedEvents.Add(er);

				// Increments every event

				if(er is Plot.HappeningEvent)
				{
					// Increments every happening event
				}
				else if(er is Plot.ActionEvent)
				{
					// Increments every action event

					if(Story.space.player.actions.Contains(er))
					{
						// Increments every player action event
					}
				}
                
                if(Story.plot.IsEnding(er)) 
				{
					Story.__isOver = true;
					
					return appliedEvents;
				}
				
				if(er.eventToTrigger != null)
				{
					appliedEvents.AddRange(ApplyEventChanges(er.eventToTrigger));
				}
				if(er.eventsThatMayTrigger != null)
				{
					var possibleTriggers = er.eventsThatMayTrigger.Where(t => t.PreconditionsMet(true));
					var triggers = ResolveEventsToHappen(possibleTriggers.ToList());

					foreach(var trigger in triggers)
					{
						appliedEvents.AddRange(ApplyEventChanges(trigger));
					}
				}

				return appliedEvents;
	        }

	        public List<Plot.Event> CheckForHappenings()
	        {
				return ResolveEventsToHappen(
					plot.GetPossibleHappenings()
					.Select(a => (Plot.Event) a).ToList()
				);
	        }
	        
	        public List<Plot.Event> CheckForOtherActorsActions()
	        {
	            var actors = space.actors;
	
	            List<Plot.Event> actionsToHappen = new List<Plot.Event>();
	
	            foreach (var actor in actors)
	            {
					actionsToHappen.AddRange(
						ResolveEventsToHappen(actor.GetPossibleActions()
						.Select(a => (Plot.Event) a).ToList())
					);
	            }
	
	            return actionsToHappen;
	        }
	
			private List<Plot.Event> ResolveEventsToHappen(List<Plot.Event> candidateEvents)
			{
				List<Plot.Event> eventsToHappen = new List<Plot.Event>();
	
				var highPriorEvents = candidateEvents.Where(e => e.priority == EventPriority.High).ToList();
				var veryHighPriorEvents = highPriorEvents.Where(e => e.priority == EventPriority.VeryHigh).ToList();
	
				if(veryHighPriorEvents.Count > 0)
				{
					// One or more veryhigh events
					eventsToHappen.AddRange(veryHighPriorEvents);
				}
				else if(highPriorEvents.Count > 0)
				{
					// One or more high events
					eventsToHappen.AddRange(highPriorEvents);
				}
	            else if (candidateEvents.Count > 0)
	            {
					// One random normal event
	                int r = random.Next(0, candidateEvents.Count);
	                eventsToHappen.Add(candidateEvents[r]);
	            }
	
				return eventsToHappen;
			}

        }

        #endregion
    }
	
	public class Plot
	{
		// Plot opening & endings
	    public HappeningEvent opening;
		public List<HappeningEvent> endings;
	
		// Happenings
		public HappeningEvent abertura;
		public HappeningEvent desceuDoAviao;
		public HappeningEvent encontrarCrocodilo;
		public HappeningEvent crocodiloIntimidado;
		public HappeningEvent esgueirarCrocodilo;
		public HappeningEvent aposConfrontoCrocodilo;
		public HappeningEvent desvioNoRio;
		public HappeningEvent nadarAFavor;
		public HappeningEvent falharEmEnfrentarCorrenteza;
		public HappeningEvent sairDoRio;
		public HappeningEvent encontrarAcampamento;
		public HappeningEvent encontrarMacacos;
		public HappeningEvent correrEMachucar;
		public HappeningEvent encontrarPrecipicio;
		public HappeningEvent cairNoPrecipicio;
		public HappeningEvent atravessouUsandoCipo;
		public HappeningEvent proximoADoutora;
		public HappeningEvent presoNoPrecipicio;
		public HappeningEvent incapacitadoDeAndar;
		public HappeningEvent ilhadoAposCorrenteza;
		public HappeningEvent encontrouDoutura;
	
		// Actions
		public ActionEvent bearGryllsDP_GanchoOuEstiligue;
		public ActionEvent bearGryllsEscolherGancho;
		public ActionEvent bearGryllsEscolherEstilingue;
		public ActionEvent bearGryllsDP_FlorestaOuRio;
		public ActionEvent bearGryllsEscolherFloresta;
		public ActionEvent bearGryllsEscolherRio;
		public ActionEvent bearGryllsEspantarCrocodiloEstilingue;
		public ActionEvent bearGryllsDP_EsgueirarOuIntimidarCrocodilo;
		public ActionEvent bearGryllsEscolherEsgueirar;
		public ActionEvent bearGryllsEscolherIntimidar;
		public ActionEvent bearGryllsJogarCrocodiloLonge;
		public ActionEvent bearGryllsDP_EnfrentarCorrentezaOuIrAFavor;
		public ActionEvent bearGryllsEscolherEnfrentarCorrenteza;
		public ActionEvent bearGryllsEscolherIrAFavor;
		public ActionEvent bearGryllsComentarioNaIlha;
		public ActionEvent bearGryllsDP_CupinsOuLarva;
		public ActionEvent bearGryllsEscolherCupins;
		public ActionEvent bearGryllsEscolherLarva;
		public ActionEvent bearGryllsDP_ArvoreOuMacacos;
		public ActionEvent bearGryllsEscolherArvore;
		public ActionEvent bearGryllsEscolherMacacos;
		public ActionEvent bearGryllsEspantarMacaco;
		public ActionEvent bearGryllsPerseguirMacaco;
		public ActionEvent bearGryllsRecuperarBolsa;
		public ActionEvent bearGryllsEncontrarFumaca;
		public ActionEvent bearGryllsDP_TroncoOuCipo;
		public ActionEvent bearGryllsEscolherTronco;
		public ActionEvent bearGryllsEscolherCipo;
		public ActionEvent bearGryllsEscalarPrecipicio;
		public ActionEvent bearGryllsTentarEscalarPrecipicio;
	
		// Collections of Events
		public List<Event> events;
		public List<HappeningEvent> happenings;
		public List<ActionEvent> actions;
		
		
		public Plot()
		{
			abertura = new Abertura();
			desceuDoAviao = new DesceuDoAviao();
			encontrarCrocodilo = new EncontrarCrocodilo();
			crocodiloIntimidado = new CrocodiloIntimidado();
			esgueirarCrocodilo = new EsgueirarCrocodilo();
			aposConfrontoCrocodilo = new AposConfrontoCrocodilo();
			desvioNoRio = new DesvioNoRio();
			nadarAFavor = new NadarAFavor();
			falharEmEnfrentarCorrenteza = new FalharEmEnfrentarCorrenteza();
			sairDoRio = new SairDoRio();
			encontrarAcampamento = new EncontrarAcampamento();
			encontrarMacacos = new EncontrarMacacos();
			correrEMachucar = new CorrerEMachucar();
			encontrarPrecipicio = new EncontrarPrecipicio();
			cairNoPrecipicio = new CairNoPrecipicio();
			atravessouUsandoCipo = new AtravessouUsandoCipo();
			proximoADoutora = new ProximoADoutora();
			presoNoPrecipicio = new PresoNoPrecipicio();
			incapacitadoDeAndar = new IncapacitadoDeAndar();
			ilhadoAposCorrenteza = new IlhadoAposCorrenteza();
			encontrouDoutura = new EncontrouDoutura();
		
			bearGryllsDP_GanchoOuEstiligue = new BearGryllsDP_GanchoOuEstiligue();
			bearGryllsEscolherGancho = new BearGryllsEscolherGancho();
			bearGryllsEscolherEstilingue = new BearGryllsEscolherEstilingue();
			bearGryllsDP_FlorestaOuRio = new BearGryllsDP_FlorestaOuRio();
			bearGryllsEscolherFloresta = new BearGryllsEscolherFloresta();
			bearGryllsEscolherRio = new BearGryllsEscolherRio();
			bearGryllsEspantarCrocodiloEstilingue = new BearGryllsEspantarCrocodiloEstilingue();
			bearGryllsDP_EsgueirarOuIntimidarCrocodilo = new BearGryllsDP_EsgueirarOuIntimidarCrocodilo();
			bearGryllsEscolherEsgueirar = new BearGryllsEscolherEsgueirar();
			bearGryllsEscolherIntimidar = new BearGryllsEscolherIntimidar();
			bearGryllsJogarCrocodiloLonge = new BearGryllsJogarCrocodiloLonge();
			bearGryllsDP_EnfrentarCorrentezaOuIrAFavor = new BearGryllsDP_EnfrentarCorrentezaOuIrAFavor();
			bearGryllsEscolherEnfrentarCorrenteza = new BearGryllsEscolherEnfrentarCorrenteza();
			bearGryllsEscolherIrAFavor = new BearGryllsEscolherIrAFavor();
			bearGryllsComentarioNaIlha = new BearGryllsComentarioNaIlha();
			bearGryllsDP_CupinsOuLarva = new BearGryllsDP_CupinsOuLarva();
			bearGryllsEscolherCupins = new BearGryllsEscolherCupins();
			bearGryllsEscolherLarva = new BearGryllsEscolherLarva();
			bearGryllsDP_ArvoreOuMacacos = new BearGryllsDP_ArvoreOuMacacos();
			bearGryllsEscolherArvore = new BearGryllsEscolherArvore();
			bearGryllsEscolherMacacos = new BearGryllsEscolherMacacos();
			bearGryllsEspantarMacaco = new BearGryllsEspantarMacaco();
			bearGryllsPerseguirMacaco = new BearGryllsPerseguirMacaco();
			bearGryllsRecuperarBolsa = new BearGryllsRecuperarBolsa();
			bearGryllsEncontrarFumaca = new BearGryllsEncontrarFumaca();
			bearGryllsDP_TroncoOuCipo = new BearGryllsDP_TroncoOuCipo();
			bearGryllsEscolherTronco = new BearGryllsEscolherTronco();
			bearGryllsEscolherCipo = new BearGryllsEscolherCipo();
			bearGryllsEscalarPrecipicio = new BearGryllsEscalarPrecipicio();
			bearGryllsTentarEscalarPrecipicio = new BearGryllsTentarEscalarPrecipicio();
			
			opening = abertura;
			endings = new List<HappeningEvent>() { presoNoPrecipicio, incapacitadoDeAndar, ilhadoAposCorrenteza, encontrouDoutura,  };
		
			happenings = new List<HappeningEvent>() { desceuDoAviao, encontrarCrocodilo, crocodiloIntimidado, esgueirarCrocodilo, aposConfrontoCrocodilo, desvioNoRio, nadarAFavor, falharEmEnfrentarCorrenteza, sairDoRio, encontrarAcampamento, encontrarMacacos, correrEMachucar, encontrarPrecipicio, cairNoPrecipicio, atravessouUsandoCipo, proximoADoutora, presoNoPrecipicio, incapacitadoDeAndar, ilhadoAposCorrenteza, encontrouDoutura,  };
			actions = new List<ActionEvent>() { bearGryllsDP_GanchoOuEstiligue, bearGryllsEscolherGancho, bearGryllsEscolherEstilingue, bearGryllsDP_FlorestaOuRio, bearGryllsEscolherFloresta, bearGryllsEscolherRio, bearGryllsEspantarCrocodiloEstilingue, bearGryllsDP_EsgueirarOuIntimidarCrocodilo, bearGryllsEscolherEsgueirar, bearGryllsEscolherIntimidar, bearGryllsJogarCrocodiloLonge, bearGryllsDP_EnfrentarCorrentezaOuIrAFavor, bearGryllsEscolherEnfrentarCorrenteza, bearGryllsEscolherIrAFavor, bearGryllsComentarioNaIlha, bearGryllsDP_CupinsOuLarva, bearGryllsEscolherCupins, bearGryllsEscolherLarva, bearGryllsDP_ArvoreOuMacacos, bearGryllsEscolherArvore, bearGryllsEscolherMacacos, bearGryllsEspantarMacaco, bearGryllsPerseguirMacaco, bearGryllsRecuperarBolsa, bearGryllsEncontrarFumaca, bearGryllsDP_TroncoOuCipo, bearGryllsEscolherTronco, bearGryllsEscolherCipo, bearGryllsEscalarPrecipicio, bearGryllsTentarEscalarPrecipicio,  };
			
			events = new List<Event>() { opening };
			events.AddRange(happenings);
			events.AddRange(actions);
			events.AddRange(endings);
		}
		
		public void SetEventsRefs()
		{
			foreach (var e in events)
			{
				e.SetReferences();
			}
		}
		
		public List<HappeningEvent> GetPossibleHappenings()
		{
			return happenings.Where(e => e.PreconditionsMet()).ToList();
		}
		
		public bool IsEnding(Event e)
		{
			if(e is ActionEvent) return false;
			
			return endings.Contains(e as HappeningEvent);
		}
		
		//-----
		#region Event Definitions
	
		public abstract class Event
		{
			public string name;
			public string description;
			public string shortDescription;
			
			public EventPriority priority;
			
			public Plot.Event eventToTrigger;
			public List<Plot.Event> eventsThatMayTrigger;
			
			public abstract bool PreconditionsMet(bool isTriggerCheck = false);
			public abstract void ApplyChanges();
			public abstract void SetReferences();
	
	   		// override object.Equals
	        public override bool Equals(object obj)
	        {
	            if (obj == null || GetType() != obj.GetType())
	            {
	                return false;
	            }
	
	            return (obj as Event).name == this.name;
	        }
	
	        // override object.GetHashCode
	        public override int GetHashCode()
	        {
	            return base.GetHashCode();
	        }
	    }
	
	    //-----
	    #region Happenings
	
	    public abstract class HappeningEvent : Event
	    {
	    }
	    
	    public class Abertura : HappeningEvent
	    {	
	    	public Abertura()
	    	{
	    		name = "Abertura";
	    		description = "A missão é resgatar a doutora que está perdida nesta floresta amazônica.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.bearGryllsDP_GanchoOuEstiligue;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ( true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class DesceuDoAviao : HappeningEvent
	    {	
	    	public DesceuDoAviao()
	    	{
	    		name = "DesceuDoAviao";
	    		description = "Bear Grylls desce do avião e se encontra às margens da floresta.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.bearGryllsDP_FlorestaOuRio;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class EncontrarCrocodilo : HappeningEvent
	    {	
	    	public EncontrarCrocodilo()
	    	{
	    		name = "EncontrarCrocodilo";
	    		description = "Andando pelo rio, um crocodilo aparece bloqueando o caminho.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = new List<Plot.Event>() { Story.plot.bearGryllsDP_EsgueirarOuIntimidarCrocodilo, Story.plot.bearGryllsEspantarCrocodiloEstilingue,  };
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class CrocodiloIntimidado : HappeningEvent
	    {	
	    	public CrocodiloIntimidado()
	    	{
	    		name = "CrocodiloIntimidado";
	    		description = "Fazendo barulho, e agitando a água na direção do crocodilo, Bear Grylls o assusta e o predador foge para os arbustros, liberando o caminho.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.sairDoRio;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class EsgueirarCrocodilo : HappeningEvent
	    {	
	    	public EsgueirarCrocodilo()
	    	{
	    		name = "EsgueirarCrocodilo";
	    		description = "Bear Grylls tenta se esgueirar por baixo da água, mas o crocodilo avança em sua direção. Após uma confusão na água, Bear Grylls se levanta, com o crocodilo dominado.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.bearGryllsJogarCrocodiloLonge;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class AposConfrontoCrocodilo : HappeningEvent
	    {	
	    	public AposConfrontoCrocodilo()
	    	{
	    		name = "AposConfrontoCrocodilo";
	    		description = "Seguindo caminho, Bear Grylls se depara com mais vários crocodilos, que devem ter vindo por causa da confusão anterior. Agitos prolongados na água são sinal de presa e isso deve ter atraído mais deles.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.desvioNoRio;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class DesvioNoRio : HappeningEvent
	    {	
	    	public DesvioNoRio()
	    	{
	    		name = "DesvioNoRio";
	    		description = "Sendo forçado a desviar por outro ramo do rio, Bear Grylls se vê sendo puxado pela correnteza do rio. Em pouco tempo, é arrastado com força e expelido até o mar.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.bearGryllsDP_EnfrentarCorrentezaOuIrAFavor;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class NadarAFavor : HappeningEvent
	    {	
	    	public NadarAFavor()
	    	{
	    		name = "NadarAFavor";
	    		description = "Nadando a favor da correnteza, Bear Grylls consegue voltar a margem eventualmente, e sem muito esforço. Agora o caminho é pela floresta.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.encontrarAcampamento;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class FalharEmEnfrentarCorrenteza : HappeningEvent
	    {	
	    	public FalharEmEnfrentarCorrenteza()
	    	{
	    		name = "FalharEmEnfrentarCorrenteza";
	    		description = "Após tentar por minutos, a correnteza exaure o Bear Grylls e o arrasta para longe. Desistindo, ele começa a nadar a favor da correnteza e em direção a uma ilha.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.bearGryllsComentarioNaIlha;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class SairDoRio : HappeningEvent
	    {	
	    	public SairDoRio()
	    	{
	    		name = "SairDoRio";
	    		description = "Seguindo pelo rio, Bear Grylls chega em um ponto onde deve continuar pela floresta, já que o rio desvia por outras direções.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.bearGryllsDP_CupinsOuLarva;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class EncontrarAcampamento : HappeningEvent
	    {	
	    	public EncontrarAcampamento()
	    	{
	    		name = "EncontrarAcampamento";
	    		description = "Após andar e cortar seu caminho pela floresta, Bear Grylls encontra sinais de um acampamento.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.bearGryllsDP_ArvoreOuMacacos;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class EncontrarMacacos : HappeningEvent
	    {	
	    	public EncontrarMacacos()
	    	{
	    		name = "EncontrarMacacos";
	    		description = "Seguindo os sons dos macacos, Bear Grylls encontra uma mochila no chão, e um macaco está mexendo nela.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = new List<Plot.Event>() { Story.plot.bearGryllsEspantarMacaco, Story.plot.bearGryllsPerseguirMacaco,  };
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class CorrerEMachucar : HappeningEvent
	    {	
	    	public CorrerEMachucar()
	    	{
	    		name = "CorrerEMachucar";
	    		description = "Correndo atrás do macaco, Bear Grylls tropeça, desliza em um desfiladeiro e torce o tornozelo.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.incapacitadoDeAndar;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class EncontrarPrecipicio : HappeningEvent
	    {	
	    	public EncontrarPrecipicio()
	    	{
	    		name = "EncontrarPrecipicio";
	    		description = "Após prosseguir mais um tempo, Bear Grylls se depara com um grande precipício no caminho, que se estende largamente para todos os lados.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.bearGryllsDP_TroncoOuCipo;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class CairNoPrecipicio : HappeningEvent
	    {	
	    	public CairNoPrecipicio()
	    	{
	    		name = "CairNoPrecipicio";
	    		description = "Bear Grylss tenta atravessar pelo tronco mas ele cede. O cipó salva Bear Grylls de uma queda livre, mas ainda cai no fundo do precipício.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = new List<Plot.Event>() { Story.plot.bearGryllsEscalarPrecipicio, Story.plot.bearGryllsTentarEscalarPrecipicio,  };
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class AtravessouUsandoCipo : HappeningEvent
	    {	
	    	public AtravessouUsandoCipo()
	    	{
	    		name = "AtravessouUsandoCipo";
	    		description = "O cipó é bastante resistente e Bear Grylls consegue atravessar sem problemas.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.proximoADoutora;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class ProximoADoutora : HappeningEvent
	    {	
	    	public ProximoADoutora()
	    	{
	    		name = "ProximoADoutora";
	    		description = "Continuando no caminho, Bear Grylls encontra uma construção antiga, e grita pela doutura. Ela responde!";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = Story.plot.encontrouDoutura;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class PresoNoPrecipicio : HappeningEvent
	    {	
	    	public PresoNoPrecipicio()
	    	{
	    		name = "PresoNoPrecipicio";
	    		description = "Preso neste precipício e sem ter como subir, a missão falhou.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class IncapacitadoDeAndar : HappeningEvent
	    {	
	    	public IncapacitadoDeAndar()
	    	{
	    		name = "IncapacitadoDeAndar";
	    		description = "Com o tornozelo ferido desta forma, a missão falhou.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class IlhadoAposCorrenteza : HappeningEvent
	    {	
	    	public IlhadoAposCorrenteza()
	    	{
	    		name = "IlhadoAposCorrenteza";
	    		description = "Ilhado e muito longe do objetivo, a missão falhou.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class EncontrouDoutura : HappeningEvent
	    {	
	    	public EncontrouDoutura()
	    	{
	    		name = "EncontrouDoutura";
	    		description = "A doutora foi resgatada, missão cumprida!";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	
	    #endregion
	
	    //-----
	    #region Actions
	
	    public abstract class ActionEvent : Event
	    {
	    	public ActionType type;
	    	public Space.StoryActor actor;
	    }
	    
	    public class BearGryllsDP_GanchoOuEstiligue : ActionEvent
	    {
	    	public BearGryllsDP_GanchoOuEstiligue()
	    	{
	    		name = "DP_GanchoOuEstiligue";
	    		description = "Tenho espaço para mais um item. O gancho pode me ajudar caso eu fique preso em algum lugar, e o estilingue é ótimo para lidar com animais indesejados. O que acha? Devo levar o gancho ou o estilingue?";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherGancho : ActionEvent
	    {
	    	public BearGryllsEscolherGancho()
	    	{
	    		name = "EscolherGancho";
	    		description = "Ok, vou levar o gancho.";
	    		shortDescription = "Gancho.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.desceuDoAviao;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_GanchoOuEstiligue
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherGancho
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherEstilingue
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    		Story.space.bearGrylls.PossuiGancho 
	    		=
	    		 true;
	    	}
	    }
	    public class BearGryllsEscolherEstilingue : ActionEvent
	    {
	    	public BearGryllsEscolherEstilingue()
	    	{
	    		name = "EscolherEstilingue";
	    		description = "Ok, vou levar o estilingue.";
	    		shortDescription = "Estilingue.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.desceuDoAviao;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_GanchoOuEstiligue
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherGancho
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherEstilingue
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    		Story.space.bearGrylls.PossuiEstilingue 
	    		=
	    		 true;
	    	}
	    }
	    public class BearGryllsDP_FlorestaOuRio : ActionEvent
	    {
	    	public BearGryllsDP_FlorestaOuRio()
	    	{
	    		name = "DP_FlorestaOuRio";
	    		description = "Acha que eu devo seguir pelo rio ou cortar meu caminho pela floresta?";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherFloresta : ActionEvent
	    {
	    	public BearGryllsEscolherFloresta()
	    	{
	    		name = "EscolherFloresta";
	    		description = "Ok, vou cortar meu caminho pela densa floresta.";
	    		shortDescription = "Floresta.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.encontrarAcampamento;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_FlorestaOuRio
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherFloresta
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherRio
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherRio : ActionEvent
	    {
	    	public BearGryllsEscolherRio()
	    	{
	    		name = "EscolherRio";
	    		description = "Você quer que eu vá pelo rio perigoso? Tudo bem, realmente pode ser mais rápido dessa forma.";
	    		shortDescription = "Rio.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.encontrarCrocodilo;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_FlorestaOuRio
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherFloresta
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherRio
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEspantarCrocodiloEstilingue : ActionEvent
	    {
	    	public BearGryllsEspantarCrocodiloEstilingue()
	    	{
	    		name = "EspantarCrocodiloEstilingue";
	    		description = "É por isso que você deve ter cuidado nesses rios, olha só esses dentes. Ainda bem que tenho este estilingue. Vou usá-lo para espantar o crocodilo.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Combat;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.sairDoRio;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) && (Story.space.bearGrylls.PossuiEstilingue
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsDP_EsgueirarOuIntimidarCrocodilo : ActionEvent
	    {
	    	public BearGryllsDP_EsgueirarOuIntimidarCrocodilo()
	    	{
	    		name = "DP_EsgueirarOuIntimidarCrocodilo";
	    		description = "É por isso que você deve ter cuidado nesses rios, olha só esses dentes. Posso tentar me esgueirar pelo rio, nadando embaixo da água ou ir pra cima dele, fazendo barulho e batendo na água para intimidá-lo. Então, qual você escolhe?";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) && (!Story.space.bearGrylls.PossuiEstilingue
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherEsgueirar : ActionEvent
	    {
	    	public BearGryllsEscolherEsgueirar()
	    	{
	    		name = "EscolherEsgueirar";
	    		description = "Você acha que devo me esgueirar? Ok, pode ser a melhor opção mesmo.";
	    		shortDescription = "Esgueirar-se pela água.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.esgueirarCrocodilo;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_EsgueirarOuIntimidarCrocodilo
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherEsgueirar
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherIntimidar
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherIntimidar : ActionEvent
	    {
	    	public BearGryllsEscolherIntimidar()
	    	{
	    		name = "EscolherIntimidar";
	    		description = "Ir pra cima dele? Espero que ele fique assustado, se não vou ter problemas.";
	    		shortDescription = "Encarar o crocodilo.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.crocodiloIntimidado;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_EsgueirarOuIntimidarCrocodilo
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherEsgueirar
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherIntimidar
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsJogarCrocodiloLonge : ActionEvent
	    {
	    	public BearGryllsJogarCrocodiloLonge()
	    	{
	    		name = "JogarCrocodiloLonge";
	    		description = "Ufa! Essa foi por pouco. Consegui fechar a mandíbula dele e o segurar. Olha só, um bom tamanho pra um crocodilo! Vou jogá-lo atrás daquele tronco e prosseguir.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.aposConfrontoCrocodilo;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsDP_EnfrentarCorrentezaOuIrAFavor : ActionEvent
	    {
	    	public BearGryllsDP_EnfrentarCorrentezaOuIrAFavor()
	    	{
	    		name = "DP_EnfrentarCorrentezaOuIrAFavor";
	    		description = "Essa correnteza está muito forte e me levando cada vez mais pra longe. O que acha que devo fazer, tentar enfrentar a correnteza e voltar ou nadar a favor tentando chegar em outro ponto da costa?";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherEnfrentarCorrenteza : ActionEvent
	    {
	    	public BearGryllsEscolherEnfrentarCorrenteza()
	    	{
	    		name = "EscolherEnfrentarCorrenteza";
	    		description = "Enfrentar a correnteza? Isso pode ser difícil. Vou ter que me livar da minha mochila, ela está me pesando.";
	    		shortDescription = "Nadar contra a correnteza.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.falharEmEnfrentarCorrenteza;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_EnfrentarCorrentezaOuIrAFavor
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherEnfrentarCorrenteza
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherIrAFavor
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherIrAFavor : ActionEvent
	    {
	    	public BearGryllsEscolherIrAFavor()
	    	{
	    		name = "EscolherIrAFavor";
	    		description = "Nadar a favor da correnteza? Ok, é uma boa ideia. Vamos ver onde vou parar.";
	    		shortDescription = "Nadar a favor.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.nadarAFavor;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_EnfrentarCorrentezaOuIrAFavor
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherEnfrentarCorrenteza
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherIrAFavor
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsComentarioNaIlha : ActionEvent
	    {
	    	public BearGryllsComentarioNaIlha()
	    	{
	    		name = "ComentarioNaIlha";
	    		description = "Pra falar a verdade, dei sorte em ter vindo parar nessa ilha. Tentar enfrentar a correnteza nunca é uma boa ideia. Sem equipamentos e muito distante do objetivo, não posso continuar a busca. Agora eu estou no modo sobrevivência também. Vou sinalizar com fogo para ser resgatado.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.ilhadoAposCorrenteza;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsDP_CupinsOuLarva : ActionEvent
	    {
	    	public BearGryllsDP_CupinsOuLarva()
	    	{
	    		name = "DP_CupinsOuLarva";
	    		description = "Certamente sentindo que preciso comer um pouco agora. Olha só, um ninho de cupins. Estes pequenos podem encher a barriga se conseguir vários. Ou então essa larva grande aqui, que está certamente cheia de energia. Qual delas devo comer?";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherCupins : ActionEvent
	    {
	    	public BearGryllsEscolherCupins()
	    	{
	    		name = "EscolherCupins";
	    		description = "Cupins é? Vou fazer como os macacos. Eles usam um graveto, enfiando no ninho e esperando encher de cupins... e aí é só colocar na boca, assim. Ok, vamos continuar.";
	    		shortDescription = "Comer cupins.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.encontrarPrecipicio;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_CupinsOuLarva
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherCupins
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherLarva
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherLarva : ActionEvent
	    {
	    	public BearGryllsEscolherLarva()
	    	{
	    		name = "EscolherLarva";
	    		description = "A larva... claro que você escolheu a larva. Vou tirar a cabeça, porque não quero essas presas medievais na minha boca... Ugh. Ok, vamos continuar.";
	    		shortDescription = "Comer a larva.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.encontrarPrecipicio;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_CupinsOuLarva
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherCupins
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherLarva
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsDP_ArvoreOuMacacos : ActionEvent
	    {
	    	public BearGryllsDP_ArvoreOuMacacos()
	    	{
	    		name = "DP_ArvoreOuMacacos";
	    		description = "Este acampamento é recente, e com certeza é da doutura. Daqui eu posso subir em uma árvore para obter uma visão melhor ou seguir os sons dos macacos, que podem indicam estresse e provavelmente pode haver algo. O que acha, subir na árvore ou seguir os macacos?";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherArvore : ActionEvent
	    {
	    	public BearGryllsEscolherArvore()
	    	{
	    		name = "EscolherArvore";
	    		description = "Então vou subir na árvore usando essa corda.";
	    		shortDescription = "Subir na árvore.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.bearGryllsEncontrarFumaca;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_ArvoreOuMacacos
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherArvore
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherMacacos
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherMacacos : ActionEvent
	    {
	    	public BearGryllsEscolherMacacos()
	    	{
	    		name = "EscolherMacacos";
	    		description = "Ok, vou seguir os sons dos macacos.";
	    		shortDescription = "Seguir os macacos.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.encontrarMacacos;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_ArvoreOuMacacos
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherArvore
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherMacacos
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEspantarMacaco : ActionEvent
	    {
	    	public BearGryllsEspantarMacaco()
	    	{
	    		name = "EspantarMacaco";
	    		description = "Ele provavelmente está procurando comida. Parece inofensivo, mas pode ser bem feroz. Ainda bem que tenho este estilingue, vou usá-lo para espantar o macaco.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Combat;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.bearGryllsRecuperarBolsa;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((Story.space.bearGrylls.PossuiEstilingue
	    		) && (true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsPerseguirMacaco : ActionEvent
	    {
	    	public BearGryllsPerseguirMacaco()
	    	{
	    		name = "PerseguirMacaco";
	    		description = "Ele provavelmente está procurando comida. Parece inofensivo, mas pode ser bem feroz. Se eu tivesse um estilingue poderia espatá-lo facilmente... Ah! Ele está fugindo com a mochila, vou correr atrás dele!";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Movement;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.correrEMachucar;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((!Story.space.bearGrylls.PossuiEstilingue
	    		) && (true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsRecuperarBolsa : ActionEvent
	    {
	    	public BearGryllsRecuperarBolsa()
	    	{
	    		name = "RecuperarBolsa";
	    		description = "Ok, consegui pegar a bolsa. Tem suprimentos médicos aqui, com certeza é da doutora. Ela não deve estar muito longe. Vou continuar andando e gritar por ela.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Interaction;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.proximoADoutora;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEncontrarFumaca : ActionEvent
	    {
	    	public BearGryllsEncontrarFumaca()
	    	{
	    		name = "EncontrarFumaca";
	    		description = "Olha lá, fumaça subindo naquela direção. Deve ser onde a doutora está. Vou seguir nessa direção.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.encontrarPrecipicio;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsDP_TroncoOuCipo : ActionEvent
	    {
	    	public BearGryllsDP_TroncoOuCipo()
	    	{
	    		name = "DP_TroncoOuCipo";
	    		description = "Não tem jeito, preciso atravessar esse precipício. Posso tentar caminhar por aquele tronco ou usar um cipó estilo Tarzan. O que você acha?";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = null;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherTronco : ActionEvent
	    {
	    	public BearGryllsEscolherTronco()
	    	{
	    		name = "EscolherTronco";
	    		description = "Você acha melhor eu tentar o tronco? Não dá pra saber se vai aguentar, e só vou descobrir tentando. Vou me segurar a esse cipó aqui por segurança.";
	    		shortDescription = "Passar pelo tronco.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.cairNoPrecipicio;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_TroncoOuCipo
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherTronco
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherCipo
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscolherCipo : ActionEvent
	    {
	    	public BearGryllsEscolherCipo()
	    	{
	    		name = "EscolherCipo";
	    		description = "Ok, vou seguir os sons dos macacos.";
	    		shortDescription = "Usar cipó.";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Communication;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.atravessouUsandoCipo;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		return ((Story.HasEventOcurred(Story.plot.
	    		bearGryllsDP_TroncoOuCipo
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherTronco
	    		)
	    		) && (!Story.HasEventOcurred(Story.plot.
	    		bearGryllsEscolherCipo
	    		)
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsEscalarPrecipicio : ActionEvent
	    {
	    	public BearGryllsEscalarPrecipicio()
	    	{
	    		name = "EscalarPrecipicio";
	    		description = "Ainda bem que você escolheu o gancho de escalada. Com ele consigo escalar o precipício.";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Interaction;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.proximoADoutora;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((Story.space.bearGrylls.PossuiGancho
	    		) && (true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	    public class BearGryllsTentarEscalarPrecipicio : ActionEvent
	    {
	    	public BearGryllsTentarEscalarPrecipicio()
	    	{
	    		name = "TentarEscalarPrecipicio";
	    		description = "As paredes são muito escorregadias. Sem equipamento apropriado, não vou conseguir sair daqui...";
	    		shortDescription = "";
	    		priority = EventPriority.Normal;
	    		type = ActionType.Idle;
	    	}
	    	
	    	public override void SetReferences()
	    	{
	    		actor = Story.space.bearGrylls;
	    
	    		eventToTrigger = Story.plot.presoNoPrecipicio;
	    
	    		eventsThatMayTrigger = null;
	    	}
	    	
	    	public override bool PreconditionsMet(bool isTriggerCheck = false)
	    	{
	    		if(!isTriggerCheck) return false;
	    		return ((!Story.space.bearGrylls.PossuiGancho
	    		) && (true
	    		) &&  true);
	    	}
	    	
	    	public override void ApplyChanges()
	    	{
	    	}
	    }
	
	    #endregion
	
	    #endregion
	}
	
	public class Space
	{
		// Player
		public BearGrylls player;
		
	    // Actors
	    public BearGrylls bearGrylls;
	    
	    // Objects
	
	    // Collections of Existents
	    public List<StoryExistent> existents;
	    public List<StoryActor> actors;
	    public List<StoryObject> objects;
	
		public Space()
		{
		    bearGrylls = new BearGrylls();
	
	
		    player = bearGrylls;
	
		    existents = new List<StoryExistent>() { bearGrylls,  };
		    actors = new List<StoryActor>() {  };
		    objects = new List<StoryObject>() {  };
		}
	
	
	    //-----
	    #region Existent Definitions
	
	    public abstract class StoryExistent
	    {
	    	public abstract IDictionary<string, string> GetAttributes();
	    }
	
	    //-----
	    #region Actors
	
	    public abstract class StoryActor : StoryExistent
	    {
	    	public string displayName;
	        public List<Plot.ActionEvent> actions;
	
	        public List<Plot.ActionEvent> GetPossibleActions()
	        {
	            return actions.Where(a => a.PreconditionsMet()).ToList();
	        }
	    }
	    
	    public class BearGrylls : StoryActor
	    {   	
	    	public BearGrylls()
	    	{
	    		displayName = "Bear Grylls";
	    		actions = new List<Plot.ActionEvent>() { Story.plot.bearGryllsDP_GanchoOuEstiligue, Story.plot.bearGryllsEscolherGancho, Story.plot.bearGryllsEscolherEstilingue, Story.plot.bearGryllsDP_FlorestaOuRio, Story.plot.bearGryllsEscolherFloresta, Story.plot.bearGryllsEscolherRio, Story.plot.bearGryllsEspantarCrocodiloEstilingue, Story.plot.bearGryllsDP_EsgueirarOuIntimidarCrocodilo, Story.plot.bearGryllsEscolherEsgueirar, Story.plot.bearGryllsEscolherIntimidar, Story.plot.bearGryllsJogarCrocodiloLonge, Story.plot.bearGryllsDP_EnfrentarCorrentezaOuIrAFavor, Story.plot.bearGryllsEscolherEnfrentarCorrenteza, Story.plot.bearGryllsEscolherIrAFavor, Story.plot.bearGryllsComentarioNaIlha, Story.plot.bearGryllsDP_CupinsOuLarva, Story.plot.bearGryllsEscolherCupins, Story.plot.bearGryllsEscolherLarva, Story.plot.bearGryllsDP_ArvoreOuMacacos, Story.plot.bearGryllsEscolherArvore, Story.plot.bearGryllsEscolherMacacos, Story.plot.bearGryllsEspantarMacaco, Story.plot.bearGryllsPerseguirMacaco, Story.plot.bearGryllsRecuperarBolsa, Story.plot.bearGryllsEncontrarFumaca, Story.plot.bearGryllsDP_TroncoOuCipo, Story.plot.bearGryllsEscolherTronco, Story.plot.bearGryllsEscolherCipo, Story.plot.bearGryllsEscalarPrecipicio, Story.plot.bearGryllsTentarEscalarPrecipicio,  };
	    	}
	    	
	    	public override IDictionary<string, string> GetAttributes()
	    	{
	    		var attrs = new Dictionary<string, string>();
	    		
	    		attrs.Add("PossuiGancho", PossuiGancho + "");
	    		attrs.Add("PossuiEstilingue", PossuiEstilingue + "");
	    
	    		return attrs;
	    	}
	    	
	        	private  bool possuiGancho = false;
	        	public  bool PossuiGancho
	        	{
	        		get { return possuiGancho; }
	        		set { possuiGancho = value; }
	        	}
	        	private  bool possuiEstilingue = false;
	        	public  bool PossuiEstilingue
	        	{
	        		get { return possuiEstilingue; }
	        		set { possuiEstilingue = value; }
	        	}
	    }
	
	    #endregion
	
	    //-----
	    #region Objects
	
	    public abstract class StoryObject : StoryExistent
	    {
	    }
	    
	
	    #endregion
	
	    #endregion
	}
	
	public enum ActionType
	{
		Idle,
		Visual,
		Interaction,
		Movement,
		Communication,
		Combat,
	}
	
	public enum EventPriority
	{
		Normal,
		High,
		VeryHigh
	}
}

