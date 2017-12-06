package iristk.app.cards;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;
import iristk.situated.Location;
import application.TextToSpeech;

public class CardsFlow extends iristk.flow.Flow {

	private iristk.situated.SystemAgentFlow agent;
	private iristk.situated.SystemAgent system;
	private application.TextToSpeech tts;

	private void initVariables() {
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
		tts = (application.TextToSpeech) new TextToSpeech();
	}

	public iristk.situated.SystemAgent getSystem() {
		return this.system;
	}

	public void setSystem(iristk.situated.SystemAgent value) {
		this.system = value;
	}

	public application.TextToSpeech getTts() {
		return this.tts;
	}

	public void setTts(application.TextToSpeech value) {
		this.tts = value;
	}

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("system")) return this.system;
		if (name.equals("tts")) return this.tts;
		if (name.equals("agent")) return this.agent;
		return null;
	}


	public CardsFlow(iristk.situated.SystemAgentFlow agent) {
		this.agent = agent;
		initVariables();
	}

	@Override
	public State getInitialState() {return new Start();}


	public class Start extends Dialog implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 17
			try {
				EXECUTION: {
					int count = getCount(1212899836) + 1;
					incrCount(1212899836);
					// Line: 18
					tts.setVoice("dfki-ot-hsmm");
					// Line: 19
					lookCaretaker state0 = new lookCaretaker();
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 19, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state1 = agent.new say();
					StringCreator string2 = new StringCreator();
					string2.append("Hello there, do you want to learn or play a game?");
					state1.setText(string2.toString());
					if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 17, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 21
					lookChild state3 = new lookChild();
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 21, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 23
					tts.speak("Oyun oynamak ister misiniz?", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.listen state4 = agent.new listen();
					if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 17, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 17, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 26
			try {
				count = getCount(1588970020) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:learn")) {
						incrCount(1588970020);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 27
							Learn state5 = new Learn();
							flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 27, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 26, 60));
			}
			// Line: 29
			try {
				count = getCount(1940447180) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:play")) {
						incrCount(1940447180);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 30
							Play state6 = new Play();
							flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 30, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 29, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Play extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 37
			try {
				EXECUTION: {
					int count = getCount(1066376662) + 1;
					incrCount(1066376662);
					// Line: 38
					lookChild state7 = new lookChild();
					if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 38, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state8 = agent.new say();
					StringCreator string9 = new StringCreator();
					string9.append("Let's have some fun. Which subject would you like to play with?");
					state8.setText(string9.toString());
					if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 37, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state10 = agent.new listen();
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 37, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 37, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 43
			try {
				count = getCount(476402209) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(476402209);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 44
							PlayAnimals state11 = new PlayAnimals();
							flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 44, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 43, 61));
			}
			// Line: 46
			try {
				count = getCount(460332449) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(460332449);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 47
							PlayColors state12 = new PlayColors();
							flowThread.gotoState(state12, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 47, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 46, 60));
			}
			// Line: 49
			try {
				count = getCount(1143839598) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:body")) {
						incrCount(1143839598);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 50
							PlayBody state13 = new PlayBody();
							flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 50, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 49, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PlayBody extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 56
			try {
				EXECUTION: {
					int count = getCount(517938326) + 1;
					incrCount(517938326);
					iristk.situated.SystemAgentFlow.say state14 = agent.new say();
					StringCreator string15 = new StringCreator();
					string15.append("Alright. Let's see if you have learned your body.");
					state14.setText(string15.toString());
					if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 56, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 56, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PlayColors extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 62
			try {
				EXECUTION: {
					int count = getCount(110718392) + 1;
					incrCount(110718392);
					iristk.situated.SystemAgentFlow.say state16 = agent.new say();
					StringCreator string17 = new StringCreator();
					string17.append("Let's see if you have learned your colors.");
					state16.setText(string17.toString());
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 64
					iristk.flow.DialogFlow.wait waitState18 = new iristk.flow.DialogFlow.wait();
					waitState18.setMsec(3000);
					if (!flowThread.callState(waitState18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 64, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 65
					lookCaretaker state19 = new lookCaretaker();
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 65, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 66
					PlayPrepare state20 = new PlayPrepare();
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 66, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state21 = agent.new say();
					StringCreator string22 = new StringCreator();
					string22.append("Let's start the game.");
					state21.setText(string22.toString());
					if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 69
					tts.speak("Oyuna basliyoruz.", 1.0f, false, false);
					// Line: 71
					lookChild state23 = new lookChild();
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 71, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state24 = agent.new say();
					StringCreator string25 = new StringCreator();
					string25.append("Can you show me the color red?");
					state24.setText(string25.toString());
					if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 73
					tts.speak("Cocuga kirmizi rengini gostermesini istedim.", 1.0f, false, false);
					// Line: 74
					lookBoard state26 = new lookBoard();
					if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 74, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 75
					iristk.flow.DialogFlow.wait waitState27 = new iristk.flow.DialogFlow.wait();
					waitState27.setMsec(4000);
					if (!flowThread.callState(waitState27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 75, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 76
					Showing state28 = new Showing();
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 76, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 78
					lookChild state29 = new lookChild();
					if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 78, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state30 = agent.new say();
					StringCreator string31 = new StringCreator();
					string31.append("Can you show me the color purple?");
					state30.setText(string31.toString());
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 80
					tts.speak("Cocuga mor rengini gostermesini istedim.", 1.0f, false, false);
					// Line: 81
					lookBoard state32 = new lookBoard();
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 81, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 82
					iristk.flow.DialogFlow.wait waitState33 = new iristk.flow.DialogFlow.wait();
					waitState33.setMsec(4000);
					if (!flowThread.callState(waitState33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 82, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 83
					Showing state34 = new Showing();
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 83, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 85
					lookChild state35 = new lookChild();
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 85, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state36 = agent.new say();
					StringCreator string37 = new StringCreator();
					string37.append("Can you first show me the color orange then yellow?");
					state36.setText(string37.toString());
					if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 87
					tts.speak("Cocuga once turuncu sonra sari rengini.", 1.0f, false, false);
					// Line: 88
					lookBoard state38 = new lookBoard();
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 88, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 89
					iristk.flow.DialogFlow.wait waitState39 = new iristk.flow.DialogFlow.wait();
					waitState39.setMsec(4000);
					if (!flowThread.callState(waitState39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 89, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 90
					Showing state40 = new Showing();
					if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 90, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 92
					lookChild state41 = new lookChild();
					if (!flowThread.callState(state41, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 92, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state42 = agent.new say();
					StringCreator string43 = new StringCreator();
					string43.append("Can you show me the color of grass?");
					state42.setText(string43.toString());
					if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 94
					tts.speak("Cocuga yesil rengini gostermesini istedim.", 1.0f, false, false);
					// Line: 95
					lookBoard state44 = new lookBoard();
					if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 95, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 96
					iristk.flow.DialogFlow.wait waitState45 = new iristk.flow.DialogFlow.wait();
					waitState45.setMsec(4000);
					if (!flowThread.callState(waitState45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 96, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 97
					Showing state46 = new Showing();
					if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 97, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 99
					lookChild state47 = new lookChild();
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 99, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state48 = agent.new say();
					StringCreator string49 = new StringCreator();
					string49.append("Can you show me the color of firetruck?");
					state48.setText(string49.toString());
					if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 101
					tts.speak("Cocuga kirmizi rengini gostermesini istedim.", 1.0f, false, false);
					// Line: 102
					lookBoard state50 = new lookBoard();
					if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 102, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 103
					iristk.flow.DialogFlow.wait waitState51 = new iristk.flow.DialogFlow.wait();
					waitState51.setMsec(4000);
					if (!flowThread.callState(waitState51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 103, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 104
					Showing state52 = new Showing();
					if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 104, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 106
					CheckAgain state53 = new CheckAgain();
					flowThread.gotoState(state53, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 106, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PlayAnimals extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 112
			try {
				EXECUTION: {
					int count = getCount(1982791261) + 1;
					incrCount(1982791261);
					iristk.situated.SystemAgentFlow.say state54 = agent.new say();
					StringCreator string55 = new StringCreator();
					string55.append("Great choice. I love animals.");
					state54.setText(string55.toString());
					if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 114
					iristk.flow.DialogFlow.wait waitState56 = new iristk.flow.DialogFlow.wait();
					waitState56.setMsec(3000);
					if (!flowThread.callState(waitState56, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 114, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 115
					lookCaretaker state57 = new lookCaretaker();
					if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 115, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 116
					PlayPrepare state58 = new PlayPrepare();
					if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 116, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state59 = agent.new say();
					StringCreator string60 = new StringCreator();
					string60.append("Let's start the game.");
					state59.setText(string60.toString());
					if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 119
					tts.speak("Oyuna basliyoruz.", 1.0f, false, false);
					// Line: 121
					lookChild state61 = new lookChild();
					if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state62 = agent.new say();
					StringCreator string63 = new StringCreator();
					string63.append("Can you show me the dog on the board?");
					state62.setText(string63.toString());
					if (!flowThread.callState(state62, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 123
					tts.speak("Cocuga kopek fotografini gostermesini istedim.", 1.0f, false, false);
					// Line: 124
					lookBoard state64 = new lookBoard();
					if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 124, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 125
					iristk.flow.DialogFlow.wait waitState65 = new iristk.flow.DialogFlow.wait();
					waitState65.setMsec(4000);
					if (!flowThread.callState(waitState65, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 125, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 126
					Showing state66 = new Showing();
					if (!flowThread.callState(state66, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 126, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 128
					lookChild state67 = new lookChild();
					if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 128, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state68 = agent.new say();
					StringCreator string69 = new StringCreator();
					string69.append("Can you show me the fish on the board?");
					state68.setText(string69.toString());
					if (!flowThread.callState(state68, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 130
					tts.speak("Cocuktan balik fotografini gostermesini istedim.", 1.0f, false, false);
					// Line: 131
					lookBoard state70 = new lookBoard();
					if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 131, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 132
					iristk.flow.DialogFlow.wait waitState71 = new iristk.flow.DialogFlow.wait();
					waitState71.setMsec(4000);
					if (!flowThread.callState(waitState71, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 132, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 133
					Showing state72 = new Showing();
					if (!flowThread.callState(state72, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 133, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 135
					lookChild state73 = new lookChild();
					if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 135, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state74 = agent.new say();
					StringCreator string75 = new StringCreator();
					string75.append("Can you show me the animal that flies on the board?");
					state74.setText(string75.toString());
					if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 137
					tts.speak("Cocuga kus fotografini gostermesini istedim.", 1.0f, false, false);
					// Line: 138
					lookBoard state76 = new lookBoard();
					if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 138, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 139
					iristk.flow.DialogFlow.wait waitState77 = new iristk.flow.DialogFlow.wait();
					waitState77.setMsec(4000);
					if (!flowThread.callState(waitState77, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 139, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 140
					Showing state78 = new Showing();
					if (!flowThread.callState(state78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 140, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 142
					lookChild state79 = new lookChild();
					if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 142, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state80 = agent.new say();
					StringCreator string81 = new StringCreator();
					string81.append("Can you show me the animals that have four legs?");
					state80.setText(string81.toString());
					if (!flowThread.callState(state80, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 144
					tts.speak("Cocuga hem kedi hem de kopek fotografini gostermesini istedim.", 1.0f, false, false);
					// Line: 145
					lookBoard state82 = new lookBoard();
					if (!flowThread.callState(state82, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 145, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 146
					iristk.flow.DialogFlow.wait waitState83 = new iristk.flow.DialogFlow.wait();
					waitState83.setMsec(4000);
					if (!flowThread.callState(waitState83, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 146, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 147
					Showing state84 = new Showing();
					if (!flowThread.callState(state84, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 147, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 149
					lookChild state85 = new lookChild();
					if (!flowThread.callState(state85, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 149, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state86 = agent.new say();
					StringCreator string87 = new StringCreator();
					string87.append("Can you show me the animal that says meow?");
					state86.setText(string87.toString());
					if (!flowThread.callState(state86, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 151
					tts.speak("Cocuga kedi fotografini gostermesini istedim.", 1.0f, false, false);
					// Line: 152
					lookBoard state88 = new lookBoard();
					if (!flowThread.callState(state88, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 152, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 153
					iristk.flow.DialogFlow.wait waitState89 = new iristk.flow.DialogFlow.wait();
					waitState89.setMsec(4000);
					if (!flowThread.callState(waitState89, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 153, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 154
					Showing state90 = new Showing();
					if (!flowThread.callState(state90, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 154, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 156
					CheckAgain state91 = new CheckAgain();
					flowThread.gotoState(state91, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 156, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PlayPrepare extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 165
			try {
				EXECUTION: {
					int count = getCount(1552787810) + 1;
					incrCount(1552787810);
					// Line: 166
					tts.speak("Ilgili desteyi aliniz ve rastgele diziniz. Dizme bitince OKEY diyin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state92 = agent.new say();
					StringCreator string93 = new StringCreator();
					string93.append("Would you please distribute the cards to the board?");
					state92.setText(string93.toString());
					if (!flowThread.callState(state92, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 165, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state94 = agent.new listen();
					if (!flowThread.callState(state94, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 165, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 165, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 170
			try {
				count = getCount(739498517) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:okay")) {
						incrCount(739498517);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 171
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 171, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 170, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Showing extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 176
			try {
				EXECUTION: {
					int count = getCount(166239592) + 1;
					incrCount(166239592);
					// Line: 177
					lookCaretaker state95 = new lookCaretaker();
					if (!flowThread.callState(state95, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 177, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state96 = agent.new say();
					StringCreator string97 = new StringCreator();
					string97.append("Is that correct?");
					state96.setText(string97.toString());
					if (!flowThread.callState(state96, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 176, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 179
					tts.speak("Eger dogru karti gosterdiyse yes sesi cikarin, yoksa no sesi cikarin", 1.0f, false, false);
					// Line: 180
					iristk.flow.DialogFlow.wait waitState98 = new iristk.flow.DialogFlow.wait();
					waitState98.setMsec(4000);
					if (!flowThread.callState(waitState98, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 180, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state99 = agent.new listen();
					if (!flowThread.callState(state99, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 176, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 176, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 183
			try {
				count = getCount(248609774) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(248609774);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 184
							lookChild state100 = new lookChild();
							if (!flowThread.callState(state100, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 184, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state101 = agent.new say();
							StringCreator string102 = new StringCreator();
							string102.append("Good Job. You are doing great.");
							state101.setText(string102.toString());
							if (!flowThread.callState(state101, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 183, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 186
							iristk.flow.DialogFlow.wait waitState103 = new iristk.flow.DialogFlow.wait();
							waitState103.setMsec(3000);
							if (!flowThread.callState(waitState103, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 186, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 187
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 187, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 183, 58));
			}
			// Line: 190
			try {
				count = getCount(344560770) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(344560770);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 191
							lookChild state104 = new lookChild();
							if (!flowThread.callState(state104, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 191, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state105 = agent.new say();
							StringCreator string106 = new StringCreator();
							string106.append("It's alright. Let's see which one is the correct answer.");
							state105.setText(string106.toString());
							if (!flowThread.callState(state105, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 190, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 193
							lookCaretaker state107 = new lookCaretaker();
							if (!flowThread.callState(state107, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 193, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state108 = agent.new say();
							StringCreator string109 = new StringCreator();
							string109.append("Can you show me the correct answer please?");
							state108.setText(string109.toString());
							if (!flowThread.callState(state108, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 190, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 195
							tts.speak("Dogru cevabi cocuga gosteriniz.", 1.0f, false, false);
							// Line: 196
							iristk.flow.DialogFlow.wait waitState110 = new iristk.flow.DialogFlow.wait();
							waitState110.setMsec(4000);
							if (!flowThread.callState(waitState110, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 196, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state111 = agent.new say();
							StringCreator string112 = new StringCreator();
							string112.append("Let's continue.");
							state111.setText(string112.toString());
							if (!flowThread.callState(state111, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 190, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 198
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 198, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 190, 57));
			}
			// Line: 201
			try {
				count = getCount(1288141870) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1288141870);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state113 = agent.new say();
						StringCreator string114 = new StringCreator();
						string114.append("I did not get that.");
						state113.setText(string114.toString());
						if (!flowThread.callState(state113, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 201, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 203
						Showing state115 = new Showing();
						flowThread.gotoState(state115, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 203, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 201, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Learn extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 209
			try {
				EXECUTION: {
					int count = getCount(1908153060) + 1;
					incrCount(1908153060);
					iristk.situated.SystemAgentFlow.say state116 = agent.new say();
					StringCreator string117 = new StringCreator();
					string117.append("Let's start learning. What do you want to learn about?");
					state116.setText(string117.toString());
					if (!flowThread.callState(state116, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 209, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state118 = agent.new listen();
					if (!flowThread.callState(state118, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 209, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 209, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 213
			try {
				count = getCount(116211441) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(116211441);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 214
							tts.speak("Renk kartlarinin oldugu desteyi aliniz.", 1.0f, false, false);
							// Line: 215
							iristk.flow.DialogFlow.wait waitState119 = new iristk.flow.DialogFlow.wait();
							waitState119.setMsec(3000);
							if (!flowThread.callState(waitState119, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 215, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state120 = agent.new say();
							StringCreator string121 = new StringCreator();
							string121.append("Okay, let's learn about colors.");
							state120.setText(string121.toString());
							if (!flowThread.callState(state120, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 213, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 217
							TeachColors state122 = new TeachColors();
							flowThread.gotoState(state122, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 217, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 213, 60));
			}
			// Line: 219
			try {
				count = getCount(2065530879) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(2065530879);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 220
							tts.speak("Hayvan kartlarinin oldugu desteyi aliniz.", 1.0f, false, false);
							iristk.situated.SystemAgentFlow.say state123 = agent.new say();
							StringCreator string124 = new StringCreator();
							string124.append("Okay, let's learn about animals.");
							state123.setText(string124.toString());
							if (!flowThread.callState(state123, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 219, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 222
							TeachAnimals state125 = new TeachAnimals();
							flowThread.gotoState(state125, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 222, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 219, 61));
			}
			// Line: 224
			try {
				count = getCount(1807837413) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:body")) {
						incrCount(1807837413);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state126 = agent.new say();
							StringCreator string127 = new StringCreator();
							string127.append("Okay, let's learn about body parts.");
							state126.setText(string127.toString());
							if (!flowThread.callState(state126, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 224, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 226
							TeachBody state128 = new TeachBody();
							flowThread.gotoState(state128, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 226, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 224, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class TeachBody extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 232
			try {
				EXECUTION: {
					int count = getCount(325333723) + 1;
					incrCount(325333723);
					iristk.situated.SystemAgentFlow.say state129 = agent.new say();
					StringCreator string130 = new StringCreator();
					string130.append("Let's learn about our heads, shoulders, knees and toes.");
					state129.setText(string130.toString());
					if (!flowThread.callState(state129, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 235
					lookCaretaker state131 = new lookCaretaker();
					if (!flowThread.callState(state131, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 235, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 236
					lookChild state132 = new lookChild();
					if (!flowThread.callState(state132, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 236, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 237
					tts.speak("Kafanizi, sonra bebegin kafasini isaret edin.", 1.0f, false, false);
					// Line: 238
					iristk.flow.DialogFlow.wait waitState133 = new iristk.flow.DialogFlow.wait();
					waitState133.setMsec(3000);
					if (!flowThread.callState(waitState133, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 238, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state134 = agent.new say();
					StringCreator string135 = new StringCreator();
					string135.append("This is your head.");
					state134.setText(string135.toString());
					if (!flowThread.callState(state134, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 241
					tts.speak("Omuzlariniza, sonra bebegin omuzlarina dokunun.", 1.0f, false, false);
					// Line: 242
					iristk.flow.DialogFlow.wait waitState136 = new iristk.flow.DialogFlow.wait();
					waitState136.setMsec(3000);
					if (!flowThread.callState(waitState136, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 242, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state137 = agent.new say();
					StringCreator string138 = new StringCreator();
					string138.append("These are your shoulders.");
					state137.setText(string138.toString());
					if (!flowThread.callState(state137, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 245
					tts.speak("Dizlerinize, daha sonra bebegin dizlerine dokunun.", 1.0f, false, false);
					// Line: 246
					iristk.flow.DialogFlow.wait waitState139 = new iristk.flow.DialogFlow.wait();
					waitState139.setMsec(3000);
					if (!flowThread.callState(waitState139, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 246, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state140 = agent.new say();
					StringCreator string141 = new StringCreator();
					string141.append("These are your knees.");
					state140.setText(string141.toString());
					if (!flowThread.callState(state140, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 249
					tts.speak("Ayaklariniza, daha sonra bebegin ayaklarina dokunun.", 1.0f, false, false);
					// Line: 250
					iristk.flow.DialogFlow.wait waitState142 = new iristk.flow.DialogFlow.wait();
					waitState142.setMsec(3000);
					if (!flowThread.callState(waitState142, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 250, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state143 = agent.new say();
					StringCreator string144 = new StringCreator();
					string144.append("These are your toes.");
					state143.setText(string144.toString());
					if (!flowThread.callState(state143, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 253
					tts.speak("Gozlerinizi, daha sonra bebegin gozlerini isaret edin.", 1.0f, false, false);
					// Line: 254
					iristk.flow.DialogFlow.wait waitState145 = new iristk.flow.DialogFlow.wait();
					waitState145.setMsec(3000);
					if (!flowThread.callState(waitState145, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 254, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state146 = agent.new say();
					StringCreator string147 = new StringCreator();
					string147.append("These are your eyes.");
					state146.setText(string147.toString());
					if (!flowThread.callState(state146, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 256
					tts.speak("Iki parmaginizi gosterin.", 1.0f, false, false);
					// Line: 257
					iristk.flow.DialogFlow.wait waitState148 = new iristk.flow.DialogFlow.wait();
					waitState148.setMsec(2000);
					if (!flowThread.callState(waitState148, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 257, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state149 = agent.new say();
					StringCreator string150 = new StringCreator();
					string150.append("We have two eyes. Two eyes.");
					state149.setText(string150.toString());
					if (!flowThread.callState(state149, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 260
					tts.speak("Kulaklariniza, daha sonra bebegin kulaklarina dokunun.", 1.0f, false, false);
					// Line: 261
					iristk.flow.DialogFlow.wait waitState151 = new iristk.flow.DialogFlow.wait();
					waitState151.setMsec(3000);
					if (!flowThread.callState(waitState151, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 261, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state152 = agent.new say();
					StringCreator string153 = new StringCreator();
					string153.append("These are your ears.");
					state152.setText(string153.toString());
					if (!flowThread.callState(state152, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 263
					tts.speak("Iki parmaginizi gosterin.", 1.0f, false, false);
					// Line: 264
					iristk.flow.DialogFlow.wait waitState154 = new iristk.flow.DialogFlow.wait();
					waitState154.setMsec(2000);
					if (!flowThread.callState(waitState154, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 264, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state155 = agent.new say();
					StringCreator string156 = new StringCreator();
					string156.append("We have two ears. Two ears.");
					state155.setText(string156.toString());
					if (!flowThread.callState(state155, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 267
					tts.speak("Bebege opucuk atin ve agizinizi gosterin.", 1.0f, false, false);
					// Line: 268
					iristk.flow.DialogFlow.wait waitState157 = new iristk.flow.DialogFlow.wait();
					waitState157.setMsec(3000);
					if (!flowThread.callState(waitState157, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 268, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state158 = agent.new say();
					StringCreator string159 = new StringCreator();
					string159.append("This is your mouth.");
					state158.setText(string159.toString());
					if (!flowThread.callState(state158, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 270
					tts.speak("Bir parmaginizi kaldirin.", 1.0f, false, false);
					// Line: 271
					iristk.flow.DialogFlow.wait waitState160 = new iristk.flow.DialogFlow.wait();
					waitState160.setMsec(2000);
					if (!flowThread.callState(waitState160, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 271, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state161 = agent.new say();
					StringCreator string162 = new StringCreator();
					string162.append("We have one mouth. One mouth.");
					state161.setText(string162.toString());
					if (!flowThread.callState(state161, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 274
					tts.speak("Burnunuza, sonra bebegin burnuna dokunun.", 1.0f, false, false);
					// Line: 275
					iristk.flow.DialogFlow.wait waitState163 = new iristk.flow.DialogFlow.wait();
					waitState163.setMsec(4000);
					if (!flowThread.callState(waitState163, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 275, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state164 = agent.new say();
					StringCreator string165 = new StringCreator();
					string165.append("This is your nose.");
					state164.setText(string165.toString());
					if (!flowThread.callState(state164, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 277
					tts.speak("Bir parmaginizi kaldirin.", 1.0f, false, false);
					// Line: 278
					iristk.flow.DialogFlow.wait waitState166 = new iristk.flow.DialogFlow.wait();
					waitState166.setMsec(2000);
					if (!flowThread.callState(waitState166, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 278, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state167 = agent.new say();
					StringCreator string168 = new StringCreator();
					string168.append("We have one nose. One nose.");
					state167.setText(string168.toString());
					if (!flowThread.callState(state167, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 281
					tts.speak("Iki elinizi bebege dogru sallayin.", 1.0f, false, false);
					// Line: 282
					iristk.flow.DialogFlow.wait waitState169 = new iristk.flow.DialogFlow.wait();
					waitState169.setMsec(4000);
					if (!flowThread.callState(waitState169, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 282, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state170 = agent.new say();
					StringCreator string171 = new StringCreator();
					string171.append("These are our hands.");
					state170.setText(string171.toString());
					if (!flowThread.callState(state170, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 284
					tts.speak("Iki elinizi gosterin.", 1.0f, false, false);
					// Line: 285
					iristk.flow.DialogFlow.wait waitState172 = new iristk.flow.DialogFlow.wait();
					waitState172.setMsec(2000);
					if (!flowThread.callState(waitState172, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state173 = agent.new say();
					StringCreator string174 = new StringCreator();
					string174.append("We have two hands. Two hands.");
					state173.setText(string174.toString());
					if (!flowThread.callState(state173, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 288
					tts.speak("Parmaklarinizi bebegin onunde hareket ettirin.", 1.0f, false, false);
					// Line: 289
					iristk.flow.DialogFlow.wait waitState175 = new iristk.flow.DialogFlow.wait();
					waitState175.setMsec(4000);
					if (!flowThread.callState(waitState175, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 289, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state176 = agent.new say();
					StringCreator string177 = new StringCreator();
					string177.append("These are our fingers.");
					state176.setText(string177.toString());
					if (!flowThread.callState(state176, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 291
					tts.speak("On parmaginizi gosterin.", 1.0f, false, false);
					// Line: 292
					iristk.flow.DialogFlow.wait waitState178 = new iristk.flow.DialogFlow.wait();
					waitState178.setMsec(2000);
					if (!flowThread.callState(waitState178, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 292, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state179 = agent.new say();
					StringCreator string180 = new StringCreator();
					string180.append("We have ten fingers. Ten fingers.");
					state179.setText(string180.toString());
					if (!flowThread.callState(state179, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state181 = agent.new say();
					StringCreator string182 = new StringCreator();
					string182.append("That was fun. Now, let's listen to the song again.");
					state181.setText(string182.toString());
					if (!flowThread.callState(state181, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class TeachAnimals extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 303
			try {
				EXECUTION: {
					int count = getCount(1689843956) + 1;
					incrCount(1689843956);
					// Line: 304
					lookChild state183 = new lookChild();
					if (!flowThread.callState(state183, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 304, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 305
					tts.speak("Kopek kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 306
					iristk.flow.DialogFlow.wait waitState184 = new iristk.flow.DialogFlow.wait();
					waitState184.setMsec(3000);
					if (!flowThread.callState(waitState184, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 306, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state185 = agent.new say();
					StringCreator string186 = new StringCreator();
					string186.append("This is a dog. The dog says woof.");
					state185.setText(string186.toString());
					if (!flowThread.callState(state185, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 308
					lookCaretaker state187 = new lookCaretaker();
					if (!flowThread.callState(state187, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 308, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 309
					tts.speak("WUF WUF diyin bir kac kez ve sonraki sesle birlikte 4 parmak gosterin.", 1.0f, false, false);
					// Line: 310
					iristk.flow.DialogFlow.wait waitState188 = new iristk.flow.DialogFlow.wait();
					waitState188.setMsec(3000);
					if (!flowThread.callState(waitState188, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 310, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state189 = agent.new say();
					StringCreator string190 = new StringCreator();
					string190.append("The dog has 4 legs.");
					state189.setText(string190.toString());
					if (!flowThread.callState(state189, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 313
					lookChild state191 = new lookChild();
					if (!flowThread.callState(state191, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 313, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 314
					tts.speak("Kedi kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 315
					iristk.flow.DialogFlow.wait waitState192 = new iristk.flow.DialogFlow.wait();
					waitState192.setMsec(3000);
					if (!flowThread.callState(waitState192, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 315, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state193 = agent.new say();
					StringCreator string194 = new StringCreator();
					string194.append("This is a cat. The cat says meow.");
					state193.setText(string194.toString());
					if (!flowThread.callState(state193, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 317
					lookCaretaker state195 = new lookCaretaker();
					if (!flowThread.callState(state195, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 317, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 318
					tts.speak("MIAV MIAV diyin bir kac kez ve sonra elinizle 4 parmak gosterin.", 1.0f, false, false);
					// Line: 319
					iristk.flow.DialogFlow.wait waitState196 = new iristk.flow.DialogFlow.wait();
					waitState196.setMsec(3000);
					if (!flowThread.callState(waitState196, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 319, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state197 = agent.new say();
					StringCreator string198 = new StringCreator();
					string198.append("The cat also has 4 legs like dog.");
					state197.setText(string198.toString());
					if (!flowThread.callState(state197, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 322
					lookChild state199 = new lookChild();
					if (!flowThread.callState(state199, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 322, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 323
					tts.speak("Balik kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 324
					iristk.flow.DialogFlow.wait waitState200 = new iristk.flow.DialogFlow.wait();
					waitState200.setMsec(3000);
					if (!flowThread.callState(waitState200, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 324, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state201 = agent.new say();
					StringCreator string202 = new StringCreator();
					string202.append("This is a fish. The fish lives under the sea and swims.");
					state201.setText(string202.toString());
					if (!flowThread.callState(state201, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 326
					lookCaretaker state203 = new lookCaretaker();
					if (!flowThread.callState(state203, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 326, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 327
					tts.speak("Ellerinizi birlestirip balik gibi saga sola sallayin.", 1.0f, false, false);
					// Line: 328
					iristk.flow.DialogFlow.wait waitState204 = new iristk.flow.DialogFlow.wait();
					waitState204.setMsec(3000);
					if (!flowThread.callState(waitState204, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 328, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state205 = agent.new say();
					StringCreator string206 = new StringCreator();
					string206.append("The fish have fins and a tail.");
					state205.setText(string206.toString());
					if (!flowThread.callState(state205, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 331
					lookChild state207 = new lookChild();
					if (!flowThread.callState(state207, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 331, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 332
					tts.speak("Kus kartini gosterin.", 1.0f, false, false);
					// Line: 333
					iristk.flow.DialogFlow.wait waitState208 = new iristk.flow.DialogFlow.wait();
					waitState208.setMsec(3000);
					if (!flowThread.callState(waitState208, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 333, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state209 = agent.new say();
					StringCreator string210 = new StringCreator();
					string210.append("This is a bird. The bird flies in the sky.");
					state209.setText(string210.toString());
					if (!flowThread.callState(state209, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 335
					lookCaretaker state211 = new lookCaretaker();
					if (!flowThread.callState(state211, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 335, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 336
					tts.speak("Ucan kus gibi kollarinizi cirpin ve FILAY diyin bir kac kez.", 1.0f, false, false);
					// Line: 337
					iristk.flow.DialogFlow.wait waitState212 = new iristk.flow.DialogFlow.wait();
					waitState212.setMsec(3000);
					if (!flowThread.callState(waitState212, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 337, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state213 = agent.new say();
					StringCreator string214 = new StringCreator();
					string214.append("The bird lays eggs in its nest.");
					state213.setText(string214.toString());
					if (!flowThread.callState(state213, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 340
					lookChild state215 = new lookChild();
					if (!flowThread.callState(state215, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 340, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 341
					tts.speak("Ordek kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 342
					iristk.flow.DialogFlow.wait waitState216 = new iristk.flow.DialogFlow.wait();
					waitState216.setMsec(3000);
					if (!flowThread.callState(waitState216, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 342, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state217 = agent.new say();
					StringCreator string218 = new StringCreator();
					string218.append("This is a duck. The duck says quack.");
					state217.setText(string218.toString());
					if (!flowThread.callState(state217, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 344
					lookCaretaker state219 = new lookCaretaker();
					if (!flowThread.callState(state219, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 344, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 345
					tts.speak("VAK VAK diyin bir kac", 1.0f, false, false);
					// Line: 346
					iristk.flow.DialogFlow.wait waitState220 = new iristk.flow.DialogFlow.wait();
					waitState220.setMsec(3000);
					if (!flowThread.callState(waitState220, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 346, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state221 = agent.new say();
					StringCreator string222 = new StringCreator();
					string222.append("The duck can swim.");
					state221.setText(string222.toString());
					if (!flowThread.callState(state221, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 349
					lookChild state223 = new lookChild();
					if (!flowThread.callState(state223, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 349, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 350
					tts.speak("Kurbaga kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 351
					iristk.flow.DialogFlow.wait waitState224 = new iristk.flow.DialogFlow.wait();
					waitState224.setMsec(3000);
					if (!flowThread.callState(waitState224, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 351, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state225 = agent.new say();
					StringCreator string226 = new StringCreator();
					string226.append("This is a frog. The frog has a very long tongue.");
					state225.setText(string226.toString());
					if (!flowThread.callState(state225, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 353
					lookCaretaker state227 = new lookCaretaker();
					if (!flowThread.callState(state227, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 354
					tts.speak("Dilinizi cikartin kisa bir sure.", 1.0f, false, false);
					// Line: 355
					iristk.flow.DialogFlow.wait waitState228 = new iristk.flow.DialogFlow.wait();
					waitState228.setMsec(3000);
					if (!flowThread.callState(waitState228, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 355, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state229 = agent.new say();
					StringCreator string230 = new StringCreator();
					string230.append("The frog lives in both water and land.");
					state229.setText(string230.toString());
					if (!flowThread.callState(state229, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 358
					lookChild state231 = new lookChild();
					if (!flowThread.callState(state231, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 358, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 359
					tts.speak("At kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 360
					iristk.flow.DialogFlow.wait waitState232 = new iristk.flow.DialogFlow.wait();
					waitState232.setMsec(3000);
					if (!flowThread.callState(waitState232, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 360, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state233 = agent.new say();
					StringCreator string234 = new StringCreator();
					string234.append("This is a horse. The horse can run very fast.");
					state233.setText(string234.toString());
					if (!flowThread.callState(state233, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 363
					tts.speak("Ayi kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 364
					iristk.flow.DialogFlow.wait waitState235 = new iristk.flow.DialogFlow.wait();
					waitState235.setMsec(3000);
					if (!flowThread.callState(waitState235, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 364, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state236 = agent.new say();
					StringCreator string237 = new StringCreator();
					string237.append("This is a bear. The bear is very big.");
					state236.setText(string237.toString());
					if (!flowThread.callState(state236, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 366
					lookCaretaker state238 = new lookCaretaker();
					if (!flowThread.callState(state238, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 366, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 367
					tts.speak("Ellerinizi pence yapip, havaya kaldirin ve BIG BEIR diyin.", 1.0f, false, false);
					// Line: 368
					iristk.flow.DialogFlow.wait waitState239 = new iristk.flow.DialogFlow.wait();
					waitState239.setMsec(3000);
					if (!flowThread.callState(waitState239, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 368, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 370
					lookChild state240 = new lookChild();
					if (!flowThread.callState(state240, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 370, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state241 = agent.new say();
					StringCreator string242 = new StringCreator();
					string242.append("Now you know your animals.");
					state241.setText(string242.toString());
					if (!flowThread.callState(state241, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 372
					CheckAgain state243 = new CheckAgain();
					flowThread.gotoState(state243, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 372, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 303, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class TeachColors extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 379
			try {
				EXECUTION: {
					int count = getCount(1151020327) + 1;
					incrCount(1151020327);
					// Line: 380
					TeachRed state244 = new TeachRed();
					if (!flowThread.callState(state244, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 380, 28)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 381
					TeachBlue state245 = new TeachBlue();
					if (!flowThread.callState(state245, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 381, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 382
					TeachGreen state246 = new TeachGreen();
					if (!flowThread.callState(state246, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 382, 30)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 383
					TeachYellow state247 = new TeachYellow();
					if (!flowThread.callState(state247, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 383, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 384
					TeachOrange state248 = new TeachOrange();
					if (!flowThread.callState(state248, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 384, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 385
					TeachPurple state249 = new TeachPurple();
					if (!flowThread.callState(state249, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 385, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 387
					iristk.flow.DialogFlow.wait waitState250 = new iristk.flow.DialogFlow.wait();
					waitState250.setMsec(2000);
					if (!flowThread.callState(waitState250, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 387, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state251 = agent.new say();
					StringCreator string252 = new StringCreator();
					string252.append("Now you know your colors.");
					state251.setText(string252.toString());
					if (!flowThread.callState(state251, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 379, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 389
					CheckAgain state253 = new CheckAgain();
					flowThread.gotoState(state253, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 389, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 379, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class TeachRed extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 395
			try {
				EXECUTION: {
					int count = getCount(26117480) + 1;
					incrCount(26117480);
					// Line: 396
					lookChild state254 = new lookChild();
					if (!flowThread.callState(state254, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 396, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 397
					tts.speak("Kirmizi renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 398
					iristk.flow.DialogFlow.wait waitState255 = new iristk.flow.DialogFlow.wait();
					waitState255.setMsec(3000);
					if (!flowThread.callState(waitState255, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 398, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state256 = agent.new say();
					StringCreator string257 = new StringCreator();
					string257.append("This is red.");
					state256.setText(string257.toString());
					if (!flowThread.callState(state256, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 395, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 401
					lookCaretaker state258 = new lookCaretaker();
					if (!flowThread.callState(state258, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 401, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 402
					tts.speak("Kirmizi karti cevirip sirayla itfaiye araci, trafik levhasi ve elma resimlerine isaret edin.", 1.0f, false, false);
					// Line: 403
					iristk.flow.DialogFlow.wait waitState259 = new iristk.flow.DialogFlow.wait();
					waitState259.setMsec(3000);
					if (!flowThread.callState(waitState259, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 403, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state260 = agent.new say();
					StringCreator string261 = new StringCreator();
					string261.append("The firetruck, the stop sign and the apple are all red. Red");
					state260.setText(string261.toString());
					if (!flowThread.callState(state260, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 395, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 405
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 405, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 395, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class TeachBlue extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 410
			try {
				EXECUTION: {
					int count = getCount(1791930789) + 1;
					incrCount(1791930789);
					// Line: 411
					lookChild state262 = new lookChild();
					if (!flowThread.callState(state262, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 411, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 412
					tts.speak("Mavi renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 413
					iristk.flow.DialogFlow.wait waitState263 = new iristk.flow.DialogFlow.wait();
					waitState263.setMsec(3000);
					if (!flowThread.callState(waitState263, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 413, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state264 = agent.new say();
					StringCreator string265 = new StringCreator();
					string265.append("This is blue.");
					state264.setText(string265.toString());
					if (!flowThread.callState(state264, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 410, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 416
					lookCaretaker state266 = new lookCaretaker();
					if (!flowThread.callState(state266, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 416, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 417
					tts.speak("Mavi karti cevirip sirayla deniz, gokyuzu ve kelebek resimlerine isaret edin.", 1.0f, false, false);
					// Line: 418
					iristk.flow.DialogFlow.wait waitState267 = new iristk.flow.DialogFlow.wait();
					waitState267.setMsec(3000);
					if (!flowThread.callState(waitState267, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 418, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state268 = agent.new say();
					StringCreator string269 = new StringCreator();
					string269.append("The sea, the sky and the butterfly are all blue. Blue");
					state268.setText(string269.toString());
					if (!flowThread.callState(state268, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 410, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 420
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 420, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 410, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class TeachGreen extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 425
			try {
				EXECUTION: {
					int count = getCount(97730845) + 1;
					incrCount(97730845);
					// Line: 426
					lookChild state270 = new lookChild();
					if (!flowThread.callState(state270, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 426, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 427
					tts.speak("Yesil renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 428
					iristk.flow.DialogFlow.wait waitState271 = new iristk.flow.DialogFlow.wait();
					waitState271.setMsec(3000);
					if (!flowThread.callState(waitState271, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 428, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state272 = agent.new say();
					StringCreator string273 = new StringCreator();
					string273.append("This is green.");
					state272.setText(string273.toString());
					if (!flowThread.callState(state272, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 425, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 431
					lookCaretaker state274 = new lookCaretaker();
					if (!flowThread.callState(state274, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 431, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 432
					tts.speak("Yesil karti cevirip sirayla cimen, agac ve armut resimlerine isaret edin.", 1.0f, false, false);
					// Line: 433
					iristk.flow.DialogFlow.wait waitState275 = new iristk.flow.DialogFlow.wait();
					waitState275.setMsec(3000);
					if (!flowThread.callState(waitState275, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state276 = agent.new say();
					StringCreator string277 = new StringCreator();
					string277.append("The grass, the tree and the pear are all green. Green");
					state276.setText(string277.toString());
					if (!flowThread.callState(state276, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 425, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 435
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 425, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class TeachYellow extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 440
			try {
				EXECUTION: {
					int count = getCount(1348949648) + 1;
					incrCount(1348949648);
					// Line: 441
					lookChild state278 = new lookChild();
					if (!flowThread.callState(state278, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 441, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 442
					tts.speak("Sari renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 443
					iristk.flow.DialogFlow.wait waitState279 = new iristk.flow.DialogFlow.wait();
					waitState279.setMsec(3000);
					if (!flowThread.callState(waitState279, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 443, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state280 = agent.new say();
					StringCreator string281 = new StringCreator();
					string281.append("This is yellow.");
					state280.setText(string281.toString());
					if (!flowThread.callState(state280, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 440, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 446
					lookCaretaker state282 = new lookCaretaker();
					if (!flowThread.callState(state282, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 446, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 447
					tts.speak("Sari karti cevirip sirayla limon, ordek ve muz resimlerine isaret edin.", 1.0f, false, false);
					// Line: 448
					iristk.flow.DialogFlow.wait waitState283 = new iristk.flow.DialogFlow.wait();
					waitState283.setMsec(3000);
					if (!flowThread.callState(waitState283, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 448, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state284 = agent.new say();
					StringCreator string285 = new StringCreator();
					string285.append("The lemon, the duck and the banana are all yellow. Yellow");
					state284.setText(string285.toString());
					if (!flowThread.callState(state284, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 440, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 450
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 450, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 440, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class TeachOrange extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 455
			try {
				EXECUTION: {
					int count = getCount(575335780) + 1;
					incrCount(575335780);
					// Line: 456
					lookChild state286 = new lookChild();
					if (!flowThread.callState(state286, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 456, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 457
					tts.speak("Turuncu renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 458
					iristk.flow.DialogFlow.wait waitState287 = new iristk.flow.DialogFlow.wait();
					waitState287.setMsec(3000);
					if (!flowThread.callState(waitState287, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 458, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state288 = agent.new say();
					StringCreator string289 = new StringCreator();
					string289.append("This is orange.");
					state288.setText(string289.toString());
					if (!flowThread.callState(state288, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 455, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 461
					lookCaretaker state290 = new lookCaretaker();
					if (!flowThread.callState(state290, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 461, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 462
					tts.speak("Turunucu karti cevirip sirayla portakal, havuc ve top resimlerine isaret edin.", 1.0f, false, false);
					// Line: 463
					iristk.flow.DialogFlow.wait waitState291 = new iristk.flow.DialogFlow.wait();
					waitState291.setMsec(3000);
					if (!flowThread.callState(waitState291, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 463, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state292 = agent.new say();
					StringCreator string293 = new StringCreator();
					string293.append("The orange, the carrot and the basketball are all orange. Orange");
					state292.setText(string293.toString());
					if (!flowThread.callState(state292, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 455, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 465
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 465, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 455, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class TeachPurple extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 470
			try {
				EXECUTION: {
					int count = getCount(20671747) + 1;
					incrCount(20671747);
					// Line: 471
					lookChild state294 = new lookChild();
					if (!flowThread.callState(state294, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 471, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 472
					tts.speak("Mor renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 473
					iristk.flow.DialogFlow.wait waitState295 = new iristk.flow.DialogFlow.wait();
					waitState295.setMsec(3000);
					if (!flowThread.callState(waitState295, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 473, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state296 = agent.new say();
					StringCreator string297 = new StringCreator();
					string297.append("This is purple.");
					state296.setText(string297.toString());
					if (!flowThread.callState(state296, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 470, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 476
					lookCaretaker state298 = new lookCaretaker();
					if (!flowThread.callState(state298, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 476, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 477
					tts.speak("Mor karti cevirip sirayla uzum, patlican ve bot resimlerine isaret edin.", 1.0f, false, false);
					// Line: 478
					iristk.flow.DialogFlow.wait waitState299 = new iristk.flow.DialogFlow.wait();
					waitState299.setMsec(3000);
					if (!flowThread.callState(waitState299, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 478, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state300 = agent.new say();
					StringCreator string301 = new StringCreator();
					string301.append("The grapes, the eggplant and the boots are all purple. Purple");
					state300.setText(string301.toString());
					if (!flowThread.callState(state300, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 470, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 480
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 480, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 470, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 488
			try {
				EXECUTION: {
					int count = getCount(627150481) + 1;
					incrCount(627150481);
					iristk.situated.SystemAgentFlow.say state302 = agent.new say();
					StringCreator string303 = new StringCreator();
					string303.append("Do you want to continue?");
					state302.setText(string303.toString());
					if (!flowThread.callState(state302, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 488, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state304 = agent.new listen();
					if (!flowThread.callState(state304, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 488, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 488, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 492
			try {
				count = getCount(128526626) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(128526626);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state305 = agent.new say();
							StringCreator string306 = new StringCreator();
							string306.append("Okay, let's play again.");
							state305.setText(string306.toString());
							if (!flowThread.callState(state305, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 492, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 494
							Start state307 = new Start();
							flowThread.gotoState(state307, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 494, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 492, 58));
			}
			// Line: 496
			try {
				count = getCount(754666084) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(754666084);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state308 = agent.new say();
							StringCreator string309 = new StringCreator();
							string309.append("Okay, goodbye");
							state308.setText(string309.toString());
							if (!flowThread.callState(state308, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 496, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 498
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 496, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 503
			try {
				count = getCount(801197928) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(801197928);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state310 = agent.new say();
						StringCreator string311 = new StringCreator();
						string311.append("I am sorry, I didn't hear anything.");
						state310.setText(string311.toString());
						if (!flowThread.callState(state310, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 503, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 505
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 505, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 503, 38));
			}
			// Line: 507
			try {
				count = getCount(1631862159) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1631862159);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state312 = agent.new say();
						StringCreator string313 = new StringCreator();
						string313.append("I am sorry, I didn't get that.");
						state312.setText(string313.toString());
						if (!flowThread.callState(state312, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 507, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 509
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 509, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 507, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class lookAround extends State {

		final State currentState = this;
		public float degx = asFloat(0.0);
		public float degy = asFloat(0.0);
		public float degz = asFloat(0.0);

		public void setDegx(Object value) {
			if (value != null) {
				degx = asFloat(value);
				params.put("degx", value);
			}
		}

		public void setDegy(Object value) {
			if (value != null) {
				degy = asFloat(value);
				params.put("degy", value);
			}
		}

		public void setDegz(Object value) {
			if (value != null) {
				degz = asFloat(value);
				params.put("degz", value);
			}
		}


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 518
			try {
				EXECUTION: {
					int count = getCount(866191240) + 1;
					incrCount(866191240);
					// Line: 519
					Event sendEvent314 = new Event("action.gaze");
					sendEvent314.putIfNotNull("location", new Location(degx, degy, degz));
					flowRunner.sendEvent(sendEvent314, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 519, 76)));
					// Line: 520
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 520, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 518, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class lookCaretaker extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 525
			try {
				EXECUTION: {
					int count = getCount(2094777811) + 1;
					incrCount(2094777811);
					// Line: 526
					Event sendEvent315 = new Event("action.gaze");
					sendEvent315.putIfNotNull("location", new Location(-1, 0, 1));
					flowRunner.sendEvent(sendEvent315, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 526, 68)));
					// Line: 527
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 525, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class lookChild extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 532
			try {
				EXECUTION: {
					int count = getCount(451111351) + 1;
					incrCount(451111351);
					// Line: 533
					Event sendEvent316 = new Event("action.gaze");
					sendEvent316.putIfNotNull("location", new Location(1, 0, 1));
					flowRunner.sendEvent(sendEvent316, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 533, 67)));
					// Line: 534
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 534, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 532, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class lookBoard extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 539
			try {
				EXECUTION: {
					int count = getCount(729864207) + 1;
					incrCount(729864207);
					// Line: 540
					Event sendEvent317 = new Event("action.gaze");
					sendEvent317.putIfNotNull("location", new Location(0, -1, 1));
					flowRunner.sendEvent(sendEvent317, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 540, 68)));
					// Line: 541
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 541, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 539, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
