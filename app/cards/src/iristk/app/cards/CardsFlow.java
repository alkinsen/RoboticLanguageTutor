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
					lookCaretaker state0 = new lookCaretaker();
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 18, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 19
					tts.setVoice("dfki-ot-hsmm");
					// Line: 20
					tts.speak("bir, iki, üç seviyelerin birini sırasıyla van, tu, tri seslerinden birini çıkararak seçin.", 1.0f, false, false);
					// Line: 21
					lookChild state1 = new lookChild();
					if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 21, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state2 = agent.new say();
					StringCreator string3 = new StringCreator();
					string3.append("Hello there, which level do you want to play?");
					state2.setText(string3.toString());
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 17, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 23
					lookCaretaker state4 = new lookCaretaker();
					if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 23, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state5 = agent.new listen();
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 17, 12)))) {
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
			// Line: 29
			try {
				count = getCount(1407343478) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:one")) {
						incrCount(1407343478);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 30
							EasyLearn state6 = new EasyLearn();
							flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 30, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 29, 58));
			}
			// Line: 32
			try {
				count = getCount(245565335) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:two")) {
						incrCount(245565335);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 33
							Learn state7 = new Learn();
							flowThread.gotoState(state7, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 33, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 32, 58));
			}
			// Line: 35
			try {
				count = getCount(1066376662) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:three")) {
						incrCount(1066376662);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 36
							Play state8 = new Play();
							flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 36, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 35, 60));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class EasyLearn extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 42
			try {
				EXECUTION: {
					int count = getCount(1490180672) + 1;
					incrCount(1490180672);
					// Line: 43
					lookChild state9 = new lookChild();
					if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 43, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state10 = agent.new say();
					StringCreator string11 = new StringCreator();
					string11.append("Which subject would you like to learn about?");
					state10.setText(string11.toString());
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 42, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state12 = agent.new listen();
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 42, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 42, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 48
			try {
				count = getCount(1919892312) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(1919892312);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 49
							EasyLearnAnimals state13 = new EasyLearnAnimals();
							flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 49, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 48, 61));
			}
			// Line: 51
			try {
				count = getCount(250075633) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(250075633);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 52
							EasyLearnColors state14 = new EasyLearnColors();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 52, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 51, 60));
			}
			// Line: 54
			try {
				count = getCount(517938326) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:body")) {
						incrCount(517938326);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 55
							EasyLearnBody state15 = new EasyLearnBody();
							flowThread.gotoState(state15, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 55, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 54, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class EasyLearnAnimals extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 61
			try {
				EXECUTION: {
					int count = getCount(425918570) + 1;
					incrCount(425918570);
					iristk.situated.SystemAgentFlow.say state16 = agent.new say();
					StringCreator string17 = new StringCreator();
					string17.append("Let's read a book. The book is Brown Bear, Brown Bear.");
					state16.setText(string17.toString());
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 63
					iristk.flow.DialogFlow.wait waitState18 = new iristk.flow.DialogFlow.wait();
					waitState18.setMsec(3000);
					if (!flowThread.callState(waitState18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 65
					tts.speak("Ayıyı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state19 = agent.new say();
					StringCreator string20 = new StringCreator();
					string20.append("Brown bear, brown bear, what do you see?");
					state19.setText(string20.toString());
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 67
					iristk.flow.DialogFlow.wait waitState21 = new iristk.flow.DialogFlow.wait();
					waitState21.setMsec(1000);
					if (!flowThread.callState(waitState21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 67, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 68
					tts.speak("Kuşu gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state22 = agent.new say();
					StringCreator string23 = new StringCreator();
					string23.append("I see a red bird looking at me.");
					state22.setText(string23.toString());
					if (!flowThread.callState(state22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 70
					iristk.flow.DialogFlow.wait waitState24 = new iristk.flow.DialogFlow.wait();
					waitState24.setMsec(1000);
					if (!flowThread.callState(waitState24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 70, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state25 = agent.new say();
					StringCreator string26 = new StringCreator();
					string26.append("Red bird, red bird, what do you see?");
					state25.setText(string26.toString());
					if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 72
					iristk.flow.DialogFlow.wait waitState27 = new iristk.flow.DialogFlow.wait();
					waitState27.setMsec(1000);
					if (!flowThread.callState(waitState27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 72, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 73
					tts.speak("Ördeği gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state28 = agent.new say();
					StringCreator string29 = new StringCreator();
					string29.append("I see a yellow duck looking at me.");
					state28.setText(string29.toString());
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 75
					iristk.flow.DialogFlow.wait waitState30 = new iristk.flow.DialogFlow.wait();
					waitState30.setMsec(1000);
					if (!flowThread.callState(waitState30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 75, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state31 = agent.new say();
					StringCreator string32 = new StringCreator();
					string32.append("Yellow duck, yellow duck, what do you see?");
					state31.setText(string32.toString());
					if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 77
					iristk.flow.DialogFlow.wait waitState33 = new iristk.flow.DialogFlow.wait();
					waitState33.setMsec(1000);
					if (!flowThread.callState(waitState33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 77, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 78
					tts.speak("Atı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state34 = agent.new say();
					StringCreator string35 = new StringCreator();
					string35.append("I see a blue horse looking at me.");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 80
					iristk.flow.DialogFlow.wait waitState36 = new iristk.flow.DialogFlow.wait();
					waitState36.setMsec(1000);
					if (!flowThread.callState(waitState36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 80, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state37 = agent.new say();
					StringCreator string38 = new StringCreator();
					string38.append("Blue horse, blue horse, what do you see?");
					state37.setText(string38.toString());
					if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 82
					iristk.flow.DialogFlow.wait waitState39 = new iristk.flow.DialogFlow.wait();
					waitState39.setMsec(1000);
					if (!flowThread.callState(waitState39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 82, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 83
					tts.speak("Kurbağayı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state40 = agent.new say();
					StringCreator string41 = new StringCreator();
					string41.append("I see a green frog looking at me.");
					state40.setText(string41.toString());
					if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 85
					iristk.flow.DialogFlow.wait waitState42 = new iristk.flow.DialogFlow.wait();
					waitState42.setMsec(1000);
					if (!flowThread.callState(waitState42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 85, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state43 = agent.new say();
					StringCreator string44 = new StringCreator();
					string44.append("Green frog, green frog, what do you see?");
					state43.setText(string44.toString());
					if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 87
					iristk.flow.DialogFlow.wait waitState45 = new iristk.flow.DialogFlow.wait();
					waitState45.setMsec(1000);
					if (!flowThread.callState(waitState45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 87, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 88
					tts.speak("Kediyi gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state46 = agent.new say();
					StringCreator string47 = new StringCreator();
					string47.append("I see a purple cat looking at me.");
					state46.setText(string47.toString());
					if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 90
					iristk.flow.DialogFlow.wait waitState48 = new iristk.flow.DialogFlow.wait();
					waitState48.setMsec(1000);
					if (!flowThread.callState(waitState48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 90, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state49 = agent.new say();
					StringCreator string50 = new StringCreator();
					string50.append("Purple cat, purple cat, what do you see?");
					state49.setText(string50.toString());
					if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 92
					iristk.flow.DialogFlow.wait waitState51 = new iristk.flow.DialogFlow.wait();
					waitState51.setMsec(1000);
					if (!flowThread.callState(waitState51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 92, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 93
					tts.speak("Köpeği gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state52 = agent.new say();
					StringCreator string53 = new StringCreator();
					string53.append("I see a white dog looking at me.");
					state52.setText(string53.toString());
					if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 95
					iristk.flow.DialogFlow.wait waitState54 = new iristk.flow.DialogFlow.wait();
					waitState54.setMsec(1000);
					if (!flowThread.callState(waitState54, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 95, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state55 = agent.new say();
					StringCreator string56 = new StringCreator();
					string56.append("White dog, white dog, what do you see?");
					state55.setText(string56.toString());
					if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 97
					iristk.flow.DialogFlow.wait waitState57 = new iristk.flow.DialogFlow.wait();
					waitState57.setMsec(1000);
					if (!flowThread.callState(waitState57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 97, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 98
					tts.speak("Kuzuyu gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state58 = agent.new say();
					StringCreator string59 = new StringCreator();
					string59.append("I see a black sheep looking at me.");
					state58.setText(string59.toString());
					if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 100
					iristk.flow.DialogFlow.wait waitState60 = new iristk.flow.DialogFlow.wait();
					waitState60.setMsec(1000);
					if (!flowThread.callState(waitState60, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 100, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state61 = agent.new say();
					StringCreator string62 = new StringCreator();
					string62.append("Black sheep, black sheep what do you see?");
					state61.setText(string62.toString());
					if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 102
					iristk.flow.DialogFlow.wait waitState63 = new iristk.flow.DialogFlow.wait();
					waitState63.setMsec(1000);
					if (!flowThread.callState(waitState63, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 102, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 103
					tts.speak("Balığı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state64 = agent.new say();
					StringCreator string65 = new StringCreator();
					string65.append("I see a gold fish looking at me.");
					state64.setText(string65.toString());
					if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 105
					iristk.flow.DialogFlow.wait waitState66 = new iristk.flow.DialogFlow.wait();
					waitState66.setMsec(1000);
					if (!flowThread.callState(waitState66, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 105, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state67 = agent.new say();
					StringCreator string68 = new StringCreator();
					string68.append("Gold fish, gold fish, what do you see?");
					state67.setText(string68.toString());
					if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 107
					iristk.flow.DialogFlow.wait waitState69 = new iristk.flow.DialogFlow.wait();
					waitState69.setMsec(1000);
					if (!flowThread.callState(waitState69, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 107, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 108
					tts.speak("Kendinizi gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state70 = agent.new say();
					StringCreator string71 = new StringCreator();
					string71.append("I see a nanny looking at me.");
					state70.setText(string71.toString());
					if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 110
					iristk.flow.DialogFlow.wait waitState72 = new iristk.flow.DialogFlow.wait();
					waitState72.setMsec(1000);
					if (!flowThread.callState(waitState72, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 110, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state73 = agent.new say();
					StringCreator string74 = new StringCreator();
					string74.append("Nanny, nanny, what do you see?");
					state73.setText(string74.toString());
					if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 112
					iristk.flow.DialogFlow.wait waitState75 = new iristk.flow.DialogFlow.wait();
					waitState75.setMsec(1000);
					if (!flowThread.callState(waitState75, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 113
					tts.speak("Bebeği gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state76 = agent.new say();
					StringCreator string77 = new StringCreator();
					string77.append("I see a baby looking at me.");
					state76.setText(string77.toString());
					if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 115
					iristk.flow.DialogFlow.wait waitState78 = new iristk.flow.DialogFlow.wait();
					waitState78.setMsec(1000);
					if (!flowThread.callState(waitState78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 115, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state79 = agent.new say();
					StringCreator string80 = new StringCreator();
					string80.append("Well done! I love this book!");
					state79.setText(string80.toString());
					if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 61, 12));
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


	private class EasyLearnColors extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 121
			try {
				EXECUTION: {
					int count = getCount(1910163204) + 1;
					incrCount(1910163204);
					// Line: 122
					lookCaretaker state81 = new lookCaretaker();
					if (!flowThread.callState(state81, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 122, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 123
					tts.speak("Kırmızı kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 124
					iristk.flow.DialogFlow.wait waitState82 = new iristk.flow.DialogFlow.wait();
					waitState82.setMsec(3000);
					if (!flowThread.callState(waitState82, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 124, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state83 = agent.new say();
					StringCreator string84 = new StringCreator();
					string84.append("This is red.");
					state83.setText(string84.toString());
					if (!flowThread.callState(state83, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 127
					lookChild state85 = new lookChild();
					if (!flowThread.callState(state85, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 127, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 128
					tts.speak("Kırmızı kartı çevirip elmaya işaret edin.", 1.0f, false, false);
					// Line: 129
					iristk.flow.DialogFlow.wait waitState86 = new iristk.flow.DialogFlow.wait();
					waitState86.setMsec(3000);
					if (!flowThread.callState(waitState86, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 129, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state87 = agent.new say();
					StringCreator string88 = new StringCreator();
					string88.append("What is red? Apple is red. Apple is red.");
					state87.setText(string88.toString());
					if (!flowThread.callState(state87, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 132
					lookChild state89 = new lookChild();
					if (!flowThread.callState(state89, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 132, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 133
					tts.speak("Mavi kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 134
					iristk.flow.DialogFlow.wait waitState90 = new iristk.flow.DialogFlow.wait();
					waitState90.setMsec(3000);
					if (!flowThread.callState(waitState90, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 134, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state91 = agent.new say();
					StringCreator string92 = new StringCreator();
					string92.append("This is blue.");
					state91.setText(string92.toString());
					if (!flowThread.callState(state91, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 137
					lookCaretaker state93 = new lookCaretaker();
					if (!flowThread.callState(state93, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 137, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 138
					tts.speak("Mavi kartı çevirip gök yüzüne işaret edin.", 1.0f, false, false);
					// Line: 139
					iristk.flow.DialogFlow.wait waitState94 = new iristk.flow.DialogFlow.wait();
					waitState94.setMsec(3000);
					if (!flowThread.callState(waitState94, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 139, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state95 = agent.new say();
					StringCreator string96 = new StringCreator();
					string96.append("What is blue? The sky is blue. The sky is blue.");
					state95.setText(string96.toString());
					if (!flowThread.callState(state95, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 142
					lookChild state97 = new lookChild();
					if (!flowThread.callState(state97, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 142, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 143
					tts.speak("Yeşil kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 144
					iristk.flow.DialogFlow.wait waitState98 = new iristk.flow.DialogFlow.wait();
					waitState98.setMsec(3000);
					if (!flowThread.callState(waitState98, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 144, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state99 = agent.new say();
					StringCreator string100 = new StringCreator();
					string100.append("This is green.");
					state99.setText(string100.toString());
					if (!flowThread.callState(state99, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 147
					lookCaretaker state101 = new lookCaretaker();
					if (!flowThread.callState(state101, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 147, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 148
					tts.speak("Yeşil kartı çevirip çimene işaret edin.", 1.0f, false, false);
					// Line: 149
					iristk.flow.DialogFlow.wait waitState102 = new iristk.flow.DialogFlow.wait();
					waitState102.setMsec(3000);
					if (!flowThread.callState(waitState102, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 149, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state103 = agent.new say();
					StringCreator string104 = new StringCreator();
					string104.append("What is green? The grass is green. The grass is green.");
					state103.setText(string104.toString());
					if (!flowThread.callState(state103, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 152
					lookChild state105 = new lookChild();
					if (!flowThread.callState(state105, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 152, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 153
					tts.speak("Sarı kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 154
					iristk.flow.DialogFlow.wait waitState106 = new iristk.flow.DialogFlow.wait();
					waitState106.setMsec(3000);
					if (!flowThread.callState(waitState106, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 154, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state107 = agent.new say();
					StringCreator string108 = new StringCreator();
					string108.append("This is yellow.");
					state107.setText(string108.toString());
					if (!flowThread.callState(state107, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 157
					lookCaretaker state109 = new lookCaretaker();
					if (!flowThread.callState(state109, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 157, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 158
					tts.speak("Sarı kartı çevirip limona işaret edin.", 1.0f, false, false);
					// Line: 159
					iristk.flow.DialogFlow.wait waitState110 = new iristk.flow.DialogFlow.wait();
					waitState110.setMsec(3000);
					if (!flowThread.callState(waitState110, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 159, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state111 = agent.new say();
					StringCreator string112 = new StringCreator();
					string112.append("What is yellow? Lemon is yellow. Lemon is yellow.");
					state111.setText(string112.toString());
					if (!flowThread.callState(state111, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 162
					lookChild state113 = new lookChild();
					if (!flowThread.callState(state113, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 162, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 163
					tts.speak("Turuncu kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 164
					iristk.flow.DialogFlow.wait waitState114 = new iristk.flow.DialogFlow.wait();
					waitState114.setMsec(3000);
					if (!flowThread.callState(waitState114, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 164, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state115 = agent.new say();
					StringCreator string116 = new StringCreator();
					string116.append("This is orange.");
					state115.setText(string116.toString());
					if (!flowThread.callState(state115, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 167
					lookCaretaker state117 = new lookCaretaker();
					if (!flowThread.callState(state117, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 167, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 168
					tts.speak("Turunucu kartı çevirip havuca işaret edin.", 1.0f, false, false);
					// Line: 169
					iristk.flow.DialogFlow.wait waitState118 = new iristk.flow.DialogFlow.wait();
					waitState118.setMsec(3000);
					if (!flowThread.callState(waitState118, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 169, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state119 = agent.new say();
					StringCreator string120 = new StringCreator();
					string120.append("What is orange? Carrot is orange. Carrot is orange.");
					state119.setText(string120.toString());
					if (!flowThread.callState(state119, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 172
					lookChild state121 = new lookChild();
					if (!flowThread.callState(state121, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 172, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 173
					tts.speak("Kahverengi kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 174
					iristk.flow.DialogFlow.wait waitState122 = new iristk.flow.DialogFlow.wait();
					waitState122.setMsec(3000);
					if (!flowThread.callState(waitState122, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 174, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state123 = agent.new say();
					StringCreator string124 = new StringCreator();
					string124.append("This is brown.");
					state123.setText(string124.toString());
					if (!flowThread.callState(state123, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 177
					lookCaretaker state125 = new lookCaretaker();
					if (!flowThread.callState(state125, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 177, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 178
					tts.speak("Kahverengi kartı çevirip ayıya işaret edin.", 1.0f, false, false);
					// Line: 179
					iristk.flow.DialogFlow.wait waitState126 = new iristk.flow.DialogFlow.wait();
					waitState126.setMsec(3000);
					if (!flowThread.callState(waitState126, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 179, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state127 = agent.new say();
					StringCreator string128 = new StringCreator();
					string128.append("What is brown? Bear is brown. Bear is brown.");
					state127.setText(string128.toString());
					if (!flowThread.callState(state127, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 182
					lookChild state129 = new lookChild();
					if (!flowThread.callState(state129, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 182, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 183
					tts.speak("Mor renkli kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 184
					iristk.flow.DialogFlow.wait waitState130 = new iristk.flow.DialogFlow.wait();
					waitState130.setMsec(3000);
					if (!flowThread.callState(waitState130, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 184, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state131 = agent.new say();
					StringCreator string132 = new StringCreator();
					string132.append("This is purple.");
					state131.setText(string132.toString());
					if (!flowThread.callState(state131, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 187
					lookCaretaker state133 = new lookCaretaker();
					if (!flowThread.callState(state133, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 187, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 188
					tts.speak("Mor kartı çevirip patlıcana işaret edin.", 1.0f, false, false);
					// Line: 189
					iristk.flow.DialogFlow.wait waitState134 = new iristk.flow.DialogFlow.wait();
					waitState134.setMsec(3000);
					if (!flowThread.callState(waitState134, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 189, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state135 = agent.new say();
					StringCreator string136 = new StringCreator();
					string136.append("What is purple? Eggplant is purple. Eggplant is purple.");
					state135.setText(string136.toString());
					if (!flowThread.callState(state135, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 192
					lookChild state137 = new lookChild();
					if (!flowThread.callState(state137, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 192, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 193
					tts.speak("Beyaz kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 194
					iristk.flow.DialogFlow.wait waitState138 = new iristk.flow.DialogFlow.wait();
					waitState138.setMsec(3000);
					if (!flowThread.callState(waitState138, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 194, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state139 = agent.new say();
					StringCreator string140 = new StringCreator();
					string140.append("This is white.");
					state139.setText(string140.toString());
					if (!flowThread.callState(state139, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 197
					lookCaretaker state141 = new lookCaretaker();
					if (!flowThread.callState(state141, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 197, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 198
					tts.speak("Beyaz kartı çevirip kara işaret edin.", 1.0f, false, false);
					// Line: 199
					iristk.flow.DialogFlow.wait waitState142 = new iristk.flow.DialogFlow.wait();
					waitState142.setMsec(3000);
					if (!flowThread.callState(waitState142, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 199, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state143 = agent.new say();
					StringCreator string144 = new StringCreator();
					string144.append("What is white? Snow is white. Snow is white.");
					state143.setText(string144.toString());
					if (!flowThread.callState(state143, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 12));
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


	private class EasyLearnBody extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 205
			try {
				EXECUTION: {
					int count = getCount(1908153060) + 1;
					incrCount(1908153060);
					iristk.situated.SystemAgentFlow.say state145 = agent.new say();
					StringCreator string146 = new StringCreator();
					string146.append("Let's learn a song.");
					state145.setText(string146.toString());
					if (!flowThread.callState(state145, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 207
					iristk.flow.DialogFlow.wait waitState147 = new iristk.flow.DialogFlow.wait();
					waitState147.setMsec(3000);
					if (!flowThread.callState(waitState147, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 209
					lookCaretaker state148 = new lookCaretaker();
					if (!flowThread.callState(state148, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 209, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 210
					tts.speak("Ellerinizi çırpın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state149 = agent.new say();
					StringCreator string150 = new StringCreator();
					string150.append("Clap your hands.");
					state149.setText(string150.toString());
					if (!flowThread.callState(state149, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 212
					lookChild state151 = new lookChild();
					if (!flowThread.callState(state151, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 212, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 213
					iristk.flow.DialogFlow.wait waitState152 = new iristk.flow.DialogFlow.wait();
					waitState152.setMsec(3000);
					if (!flowThread.callState(waitState152, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 213, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 214
					tts.speak("Bebeğin ellerini çırpın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state153 = agent.new say();
					StringCreator string154 = new StringCreator();
					string154.append("Clap your hands.");
					state153.setText(string154.toString());
					if (!flowThread.callState(state153, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 216
					iristk.flow.DialogFlow.wait waitState155 = new iristk.flow.DialogFlow.wait();
					waitState155.setMsec(3000);
					if (!flowThread.callState(waitState155, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 216, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 218
					lookCaretaker state156 = new lookCaretaker();
					if (!flowThread.callState(state156, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 218, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 219
					tts.speak("Ellerinizi sallayın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state157 = agent.new say();
					StringCreator string158 = new StringCreator();
					string158.append("Wave hello.");
					state157.setText(string158.toString());
					if (!flowThread.callState(state157, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 221
					lookChild state159 = new lookChild();
					if (!flowThread.callState(state159, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 221, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 222
					iristk.flow.DialogFlow.wait waitState160 = new iristk.flow.DialogFlow.wait();
					waitState160.setMsec(3000);
					if (!flowThread.callState(waitState160, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 222, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 223
					tts.speak("Bebeğin ellerini sallayın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state161 = agent.new say();
					StringCreator string162 = new StringCreator();
					string162.append("Wave hello.");
					state161.setText(string162.toString());
					if (!flowThread.callState(state161, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 225
					iristk.flow.DialogFlow.wait waitState163 = new iristk.flow.DialogFlow.wait();
					waitState163.setMsec(3000);
					if (!flowThread.callState(waitState163, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 225, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 227
					lookCaretaker state164 = new lookCaretaker();
					if (!flowThread.callState(state164, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 227, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 228
					tts.speak("Ayağa kalkın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state165 = agent.new say();
					StringCreator string166 = new StringCreator();
					string166.append("Stand up.");
					state165.setText(string166.toString());
					if (!flowThread.callState(state165, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 230
					lookChild state167 = new lookChild();
					if (!flowThread.callState(state167, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 230, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 231
					iristk.flow.DialogFlow.wait waitState168 = new iristk.flow.DialogFlow.wait();
					waitState168.setMsec(3000);
					if (!flowThread.callState(waitState168, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 231, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 232
					tts.speak("Bebeği ayağa kaldırın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state169 = agent.new say();
					StringCreator string170 = new StringCreator();
					string170.append("Stand up.");
					state169.setText(string170.toString());
					if (!flowThread.callState(state169, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 234
					iristk.flow.DialogFlow.wait waitState171 = new iristk.flow.DialogFlow.wait();
					waitState171.setMsec(3000);
					if (!flowThread.callState(waitState171, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 234, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 236
					lookCaretaker state172 = new lookCaretaker();
					if (!flowThread.callState(state172, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 236, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 237
					tts.speak("Oturun.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state173 = agent.new say();
					StringCreator string174 = new StringCreator();
					string174.append("Sit down.");
					state173.setText(string174.toString());
					if (!flowThread.callState(state173, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 239
					lookChild state175 = new lookChild();
					if (!flowThread.callState(state175, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 239, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 240
					iristk.flow.DialogFlow.wait waitState176 = new iristk.flow.DialogFlow.wait();
					waitState176.setMsec(3000);
					if (!flowThread.callState(waitState176, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 240, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 241
					tts.speak("Bebeği oturtun.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state177 = agent.new say();
					StringCreator string178 = new StringCreator();
					string178.append("Sit down.");
					state177.setText(string178.toString());
					if (!flowThread.callState(state177, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 243
					iristk.flow.DialogFlow.wait waitState179 = new iristk.flow.DialogFlow.wait();
					waitState179.setMsec(3000);
					if (!flowThread.callState(waitState179, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 243, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 245
					lookCaretaker state180 = new lookCaretaker();
					if (!flowThread.callState(state180, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 245, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 246
					tts.speak("Ellerinizi yürür gibi hareket ettirin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state181 = agent.new say();
					StringCreator string182 = new StringCreator();
					string182.append("Let's go.");
					state181.setText(string182.toString());
					if (!flowThread.callState(state181, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 248
					lookChild state183 = new lookChild();
					if (!flowThread.callState(state183, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 248, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 249
					iristk.flow.DialogFlow.wait waitState184 = new iristk.flow.DialogFlow.wait();
					waitState184.setMsec(3000);
					if (!flowThread.callState(waitState184, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 249, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 250
					tts.speak("Bebeğin ellerini çırpın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state185 = agent.new say();
					StringCreator string186 = new StringCreator();
					string186.append("Let's go.");
					state185.setText(string186.toString());
					if (!flowThread.callState(state185, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 252
					iristk.flow.DialogFlow.wait waitState187 = new iristk.flow.DialogFlow.wait();
					waitState187.setMsec(3000);
					if (!flowThread.callState(waitState187, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 252, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state188 = agent.new say();
					StringCreator string189 = new StringCreator();
					string189.append("That was fun! Great job!");
					state188.setText(string189.toString());
					if (!flowThread.callState(state188, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 205, 12));
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
			// Line: 261
			try {
				EXECUTION: {
					int count = getCount(370988149) + 1;
					incrCount(370988149);
					iristk.situated.SystemAgentFlow.say state190 = agent.new say();
					StringCreator string191 = new StringCreator();
					string191.append("Let's start learning. What do you want to learn about?");
					state190.setText(string191.toString());
					if (!flowThread.callState(state190, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 261, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state192 = agent.new listen();
					if (!flowThread.callState(state192, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 261, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 261, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 265
			try {
				count = getCount(1395089624) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(1395089624);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 266
							tts.speak("Renk kartlarının olduğu desteyi alınız.", 1.0f, false, false);
							// Line: 267
							iristk.flow.DialogFlow.wait waitState193 = new iristk.flow.DialogFlow.wait();
							waitState193.setMsec(3000);
							if (!flowThread.callState(waitState193, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 267, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state194 = agent.new say();
							StringCreator string195 = new StringCreator();
							string195.append("Okay, let's learn about colors.");
							state194.setText(string195.toString());
							if (!flowThread.callState(state194, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 265, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 269
							LearnColors state196 = new LearnColors();
							flowThread.gotoState(state196, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 269, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 265, 60));
			}
			// Line: 271
			try {
				count = getCount(1191747167) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(1191747167);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 272
							tts.speak("Hayvan kartlarının olduğu desteyi alınız.", 1.0f, false, false);
							iristk.situated.SystemAgentFlow.say state197 = agent.new say();
							StringCreator string198 = new StringCreator();
							string198.append("Okay, let's learn about animals.");
							state197.setText(string198.toString());
							if (!flowThread.callState(state197, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 271, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 274
							LearnAnimals state199 = new LearnAnimals();
							flowThread.gotoState(state199, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 274, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 271, 61));
			}
			// Line: 276
			try {
				count = getCount(1330106945) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:body")) {
						incrCount(1330106945);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state200 = agent.new say();
							StringCreator string201 = new StringCreator();
							string201.append("Okay, let's learn about body parts.");
							state200.setText(string201.toString());
							if (!flowThread.callState(state200, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 276, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 278
							LearnBody state202 = new LearnBody();
							flowThread.gotoState(state202, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 278, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 276, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class LearnBody extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 285
			try {
				EXECUTION: {
					int count = getCount(1450821318) + 1;
					incrCount(1450821318);
					iristk.situated.SystemAgentFlow.say state203 = agent.new say();
					StringCreator string204 = new StringCreator();
					string204.append("Let's learn about our heads, shoulders, knees and toes.");
					state203.setText(string204.toString());
					if (!flowThread.callState(state203, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 289
					lookCaretaker state205 = new lookCaretaker();
					if (!flowThread.callState(state205, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 289, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 290
					lookChild state206 = new lookChild();
					if (!flowThread.callState(state206, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 290, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 291
					tts.speak("Kafanıza, sonra çoçuğun kafasına yavaşça dokunun.", 1.0f, false, false);
					// Line: 292
					iristk.flow.DialogFlow.wait waitState207 = new iristk.flow.DialogFlow.wait();
					waitState207.setMsec(3000);
					if (!flowThread.callState(waitState207, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 292, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state208 = agent.new say();
					StringCreator string209 = new StringCreator();
					string209.append("This is your head.");
					state208.setText(string209.toString());
					if (!flowThread.callState(state208, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 295
					tts.speak("Omuzlariniza, sonra bebegin omuzlarina dokunun.", 1.0f, false, false);
					// Line: 296
					iristk.flow.DialogFlow.wait waitState210 = new iristk.flow.DialogFlow.wait();
					waitState210.setMsec(3000);
					if (!flowThread.callState(waitState210, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 296, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state211 = agent.new say();
					StringCreator string212 = new StringCreator();
					string212.append("These are your shoulders.");
					state211.setText(string212.toString());
					if (!flowThread.callState(state211, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 299
					tts.speak("Dizlerinize, daha sonra bebegin dizlerine dokunun.", 1.0f, false, false);
					// Line: 300
					iristk.flow.DialogFlow.wait waitState213 = new iristk.flow.DialogFlow.wait();
					waitState213.setMsec(3000);
					if (!flowThread.callState(waitState213, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 300, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state214 = agent.new say();
					StringCreator string215 = new StringCreator();
					string215.append("These are your knees.");
					state214.setText(string215.toString());
					if (!flowThread.callState(state214, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 303
					tts.speak("Ayaklariniza, daha sonra bebegin ayaklarina dokunun.", 1.0f, false, false);
					// Line: 304
					iristk.flow.DialogFlow.wait waitState216 = new iristk.flow.DialogFlow.wait();
					waitState216.setMsec(3000);
					if (!flowThread.callState(waitState216, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 304, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state217 = agent.new say();
					StringCreator string218 = new StringCreator();
					string218.append("These are your toes.");
					state217.setText(string218.toString());
					if (!flowThread.callState(state217, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 307
					tts.speak("Gozlerinizi, daha sonra bebegin gozlerini isaret edin.", 1.0f, false, false);
					// Line: 308
					iristk.flow.DialogFlow.wait waitState219 = new iristk.flow.DialogFlow.wait();
					waitState219.setMsec(3000);
					if (!flowThread.callState(waitState219, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 308, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state220 = agent.new say();
					StringCreator string221 = new StringCreator();
					string221.append("These are your eyes.");
					state220.setText(string221.toString());
					if (!flowThread.callState(state220, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 310
					tts.speak("Iki parmaginizi gosterin.", 1.0f, false, false);
					// Line: 311
					iristk.flow.DialogFlow.wait waitState222 = new iristk.flow.DialogFlow.wait();
					waitState222.setMsec(2000);
					if (!flowThread.callState(waitState222, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 311, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state223 = agent.new say();
					StringCreator string224 = new StringCreator();
					string224.append("We have two eyes. Two eyes.");
					state223.setText(string224.toString());
					if (!flowThread.callState(state223, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 314
					tts.speak("Kulaklariniza, daha sonra bebegin kulaklarina dokunun.", 1.0f, false, false);
					// Line: 315
					iristk.flow.DialogFlow.wait waitState225 = new iristk.flow.DialogFlow.wait();
					waitState225.setMsec(3000);
					if (!flowThread.callState(waitState225, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 315, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state226 = agent.new say();
					StringCreator string227 = new StringCreator();
					string227.append("These are your ears.");
					state226.setText(string227.toString());
					if (!flowThread.callState(state226, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 317
					tts.speak("Iki parmaginizi gosterin.", 1.0f, false, false);
					// Line: 318
					iristk.flow.DialogFlow.wait waitState228 = new iristk.flow.DialogFlow.wait();
					waitState228.setMsec(2000);
					if (!flowThread.callState(waitState228, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 318, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state229 = agent.new say();
					StringCreator string230 = new StringCreator();
					string230.append("We have two ears. Two ears.");
					state229.setText(string230.toString());
					if (!flowThread.callState(state229, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 321
					tts.speak("Bebege opucuk atin ve agizinizi gosterin.", 1.0f, false, false);
					// Line: 322
					iristk.flow.DialogFlow.wait waitState231 = new iristk.flow.DialogFlow.wait();
					waitState231.setMsec(3000);
					if (!flowThread.callState(waitState231, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 322, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state232 = agent.new say();
					StringCreator string233 = new StringCreator();
					string233.append("This is your mouth.");
					state232.setText(string233.toString());
					if (!flowThread.callState(state232, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 324
					tts.speak("Bir parmaginizi kaldirin.", 1.0f, false, false);
					// Line: 325
					iristk.flow.DialogFlow.wait waitState234 = new iristk.flow.DialogFlow.wait();
					waitState234.setMsec(2000);
					if (!flowThread.callState(waitState234, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 325, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state235 = agent.new say();
					StringCreator string236 = new StringCreator();
					string236.append("We have one mouth. One mouth.");
					state235.setText(string236.toString());
					if (!flowThread.callState(state235, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 328
					tts.speak("Burnunuza, sonra bebegin burnuna dokunun.", 1.0f, false, false);
					// Line: 329
					iristk.flow.DialogFlow.wait waitState237 = new iristk.flow.DialogFlow.wait();
					waitState237.setMsec(4000);
					if (!flowThread.callState(waitState237, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 329, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state238 = agent.new say();
					StringCreator string239 = new StringCreator();
					string239.append("This is your nose.");
					state238.setText(string239.toString());
					if (!flowThread.callState(state238, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 331
					tts.speak("Bir parmaginizi kaldirin.", 1.0f, false, false);
					// Line: 332
					iristk.flow.DialogFlow.wait waitState240 = new iristk.flow.DialogFlow.wait();
					waitState240.setMsec(2000);
					if (!flowThread.callState(waitState240, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 332, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state241 = agent.new say();
					StringCreator string242 = new StringCreator();
					string242.append("We have one nose. One nose.");
					state241.setText(string242.toString());
					if (!flowThread.callState(state241, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 335
					tts.speak("Iki elinizi bebege dogru sallayin.", 1.0f, false, false);
					// Line: 336
					iristk.flow.DialogFlow.wait waitState243 = new iristk.flow.DialogFlow.wait();
					waitState243.setMsec(4000);
					if (!flowThread.callState(waitState243, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 336, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state244 = agent.new say();
					StringCreator string245 = new StringCreator();
					string245.append("These are our hands.");
					state244.setText(string245.toString());
					if (!flowThread.callState(state244, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 338
					tts.speak("Iki elinizi gosterin.", 1.0f, false, false);
					// Line: 339
					iristk.flow.DialogFlow.wait waitState246 = new iristk.flow.DialogFlow.wait();
					waitState246.setMsec(2000);
					if (!flowThread.callState(waitState246, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 339, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state247 = agent.new say();
					StringCreator string248 = new StringCreator();
					string248.append("We have two hands. Two hands.");
					state247.setText(string248.toString());
					if (!flowThread.callState(state247, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 342
					tts.speak("Parmaklarinizi bebegin onunde hareket ettirin.", 1.0f, false, false);
					// Line: 343
					iristk.flow.DialogFlow.wait waitState249 = new iristk.flow.DialogFlow.wait();
					waitState249.setMsec(4000);
					if (!flowThread.callState(waitState249, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 343, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state250 = agent.new say();
					StringCreator string251 = new StringCreator();
					string251.append("These are our fingers.");
					state250.setText(string251.toString());
					if (!flowThread.callState(state250, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 345
					tts.speak("On parmaginizi gosterin.", 1.0f, false, false);
					// Line: 346
					iristk.flow.DialogFlow.wait waitState252 = new iristk.flow.DialogFlow.wait();
					waitState252.setMsec(2000);
					if (!flowThread.callState(waitState252, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 346, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state253 = agent.new say();
					StringCreator string254 = new StringCreator();
					string254.append("We have ten fingers. Ten fingers.");
					state253.setText(string254.toString());
					if (!flowThread.callState(state253, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state255 = agent.new say();
					StringCreator string256 = new StringCreator();
					string256.append("That was fun. Now, let's listen to the song again.");
					state255.setText(string256.toString());
					if (!flowThread.callState(state255, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 12));
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


	private class LearnAnimals extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 357
			try {
				EXECUTION: {
					int count = getCount(1599771323) + 1;
					incrCount(1599771323);
					// Line: 358
					lookChild state257 = new lookChild();
					if (!flowThread.callState(state257, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 358, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 359
					tts.speak("Kopek kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 360
					iristk.flow.DialogFlow.wait waitState258 = new iristk.flow.DialogFlow.wait();
					waitState258.setMsec(3000);
					if (!flowThread.callState(waitState258, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 360, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state259 = agent.new say();
					StringCreator string260 = new StringCreator();
					string260.append("This is a dog. The dog says woof.");
					state259.setText(string260.toString());
					if (!flowThread.callState(state259, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 362
					lookCaretaker state261 = new lookCaretaker();
					if (!flowThread.callState(state261, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 362, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 363
					tts.speak("WUF WUF diyin bir kac kez ve sonraki sesle birlikte 4 parmak gosterin.", 1.0f, false, false);
					// Line: 364
					iristk.flow.DialogFlow.wait waitState262 = new iristk.flow.DialogFlow.wait();
					waitState262.setMsec(3000);
					if (!flowThread.callState(waitState262, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 364, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state263 = agent.new say();
					StringCreator string264 = new StringCreator();
					string264.append("The dog has 4 legs.");
					state263.setText(string264.toString());
					if (!flowThread.callState(state263, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 367
					lookChild state265 = new lookChild();
					if (!flowThread.callState(state265, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 367, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 368
					tts.speak("Kedi kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 369
					iristk.flow.DialogFlow.wait waitState266 = new iristk.flow.DialogFlow.wait();
					waitState266.setMsec(3000);
					if (!flowThread.callState(waitState266, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 369, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state267 = agent.new say();
					StringCreator string268 = new StringCreator();
					string268.append("This is a cat. The cat says meow.");
					state267.setText(string268.toString());
					if (!flowThread.callState(state267, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 371
					lookCaretaker state269 = new lookCaretaker();
					if (!flowThread.callState(state269, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 371, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 372
					tts.speak("MIAV MIAV diyin bir kac kez ve sonra elinizle 4 parmak gosterin.", 1.0f, false, false);
					// Line: 373
					iristk.flow.DialogFlow.wait waitState270 = new iristk.flow.DialogFlow.wait();
					waitState270.setMsec(3000);
					if (!flowThread.callState(waitState270, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 373, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state271 = agent.new say();
					StringCreator string272 = new StringCreator();
					string272.append("The cat also has 4 legs like dog.");
					state271.setText(string272.toString());
					if (!flowThread.callState(state271, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 376
					lookChild state273 = new lookChild();
					if (!flowThread.callState(state273, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 376, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 377
					tts.speak("Balik kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 378
					iristk.flow.DialogFlow.wait waitState274 = new iristk.flow.DialogFlow.wait();
					waitState274.setMsec(3000);
					if (!flowThread.callState(waitState274, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 378, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state275 = agent.new say();
					StringCreator string276 = new StringCreator();
					string276.append("This is a fish. The fish lives under the sea and swims.");
					state275.setText(string276.toString());
					if (!flowThread.callState(state275, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 380
					lookCaretaker state277 = new lookCaretaker();
					if (!flowThread.callState(state277, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 380, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 381
					tts.speak("Ellerinizi birlestirip balik gibi saga sola sallayin.", 1.0f, false, false);
					// Line: 382
					iristk.flow.DialogFlow.wait waitState278 = new iristk.flow.DialogFlow.wait();
					waitState278.setMsec(3000);
					if (!flowThread.callState(waitState278, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 382, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state279 = agent.new say();
					StringCreator string280 = new StringCreator();
					string280.append("The fish have fins and a tail.");
					state279.setText(string280.toString());
					if (!flowThread.callState(state279, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 385
					lookChild state281 = new lookChild();
					if (!flowThread.callState(state281, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 385, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 386
					tts.speak("Kus kartini gosterin.", 1.0f, false, false);
					// Line: 387
					iristk.flow.DialogFlow.wait waitState282 = new iristk.flow.DialogFlow.wait();
					waitState282.setMsec(3000);
					if (!flowThread.callState(waitState282, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 387, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state283 = agent.new say();
					StringCreator string284 = new StringCreator();
					string284.append("This is a bird. The bird flies in the sky.");
					state283.setText(string284.toString());
					if (!flowThread.callState(state283, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 389
					lookCaretaker state285 = new lookCaretaker();
					if (!flowThread.callState(state285, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 389, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 390
					tts.speak("Ucan kus gibi kollarinizi cirpin ve FILAY diyin bir kac kez.", 1.0f, false, false);
					// Line: 391
					iristk.flow.DialogFlow.wait waitState286 = new iristk.flow.DialogFlow.wait();
					waitState286.setMsec(3000);
					if (!flowThread.callState(waitState286, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 391, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state287 = agent.new say();
					StringCreator string288 = new StringCreator();
					string288.append("The bird lays eggs in its nest.");
					state287.setText(string288.toString());
					if (!flowThread.callState(state287, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 394
					lookChild state289 = new lookChild();
					if (!flowThread.callState(state289, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 394, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 395
					tts.speak("Ordek kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 396
					iristk.flow.DialogFlow.wait waitState290 = new iristk.flow.DialogFlow.wait();
					waitState290.setMsec(3000);
					if (!flowThread.callState(waitState290, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 396, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state291 = agent.new say();
					StringCreator string292 = new StringCreator();
					string292.append("This is a duck. The duck says quack.");
					state291.setText(string292.toString());
					if (!flowThread.callState(state291, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 398
					lookCaretaker state293 = new lookCaretaker();
					if (!flowThread.callState(state293, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 398, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 399
					tts.speak("VAK VAK diyin bir kac", 1.0f, false, false);
					// Line: 400
					iristk.flow.DialogFlow.wait waitState294 = new iristk.flow.DialogFlow.wait();
					waitState294.setMsec(3000);
					if (!flowThread.callState(waitState294, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 400, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state295 = agent.new say();
					StringCreator string296 = new StringCreator();
					string296.append("The duck can swim.");
					state295.setText(string296.toString());
					if (!flowThread.callState(state295, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 403
					lookChild state297 = new lookChild();
					if (!flowThread.callState(state297, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 403, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 404
					tts.speak("Kurbaga kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 405
					iristk.flow.DialogFlow.wait waitState298 = new iristk.flow.DialogFlow.wait();
					waitState298.setMsec(3000);
					if (!flowThread.callState(waitState298, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 405, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state299 = agent.new say();
					StringCreator string300 = new StringCreator();
					string300.append("This is a frog. The frog has a very long tongue.");
					state299.setText(string300.toString());
					if (!flowThread.callState(state299, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 407
					lookCaretaker state301 = new lookCaretaker();
					if (!flowThread.callState(state301, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 407, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 408
					tts.speak("Dilinizi cikartin kisa bir sure.", 1.0f, false, false);
					// Line: 409
					iristk.flow.DialogFlow.wait waitState302 = new iristk.flow.DialogFlow.wait();
					waitState302.setMsec(3000);
					if (!flowThread.callState(waitState302, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 409, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state303 = agent.new say();
					StringCreator string304 = new StringCreator();
					string304.append("The frog lives in both water and land.");
					state303.setText(string304.toString());
					if (!flowThread.callState(state303, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 412
					lookChild state305 = new lookChild();
					if (!flowThread.callState(state305, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 412, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 413
					tts.speak("At kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 414
					iristk.flow.DialogFlow.wait waitState306 = new iristk.flow.DialogFlow.wait();
					waitState306.setMsec(3000);
					if (!flowThread.callState(waitState306, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 414, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state307 = agent.new say();
					StringCreator string308 = new StringCreator();
					string308.append("This is a horse. The horse can run very fast.");
					state307.setText(string308.toString());
					if (!flowThread.callState(state307, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 417
					tts.speak("Ayi kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 418
					iristk.flow.DialogFlow.wait waitState309 = new iristk.flow.DialogFlow.wait();
					waitState309.setMsec(3000);
					if (!flowThread.callState(waitState309, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 418, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state310 = agent.new say();
					StringCreator string311 = new StringCreator();
					string311.append("This is a bear. The bear is very big.");
					state310.setText(string311.toString());
					if (!flowThread.callState(state310, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 420
					lookCaretaker state312 = new lookCaretaker();
					if (!flowThread.callState(state312, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 420, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 421
					tts.speak("Ellerinizi pence yapip, havaya kaldirin ve BIG BEIR diyin.", 1.0f, false, false);
					// Line: 422
					iristk.flow.DialogFlow.wait waitState313 = new iristk.flow.DialogFlow.wait();
					waitState313.setMsec(3000);
					if (!flowThread.callState(waitState313, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 422, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 424
					lookChild state314 = new lookChild();
					if (!flowThread.callState(state314, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 424, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state315 = agent.new say();
					StringCreator string316 = new StringCreator();
					string316.append("Now you know your animals.");
					state315.setText(string316.toString());
					if (!flowThread.callState(state315, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 426
					CheckAgain state317 = new CheckAgain();
					flowThread.gotoState(state317, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 426, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 357, 12));
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


	private class LearnColors extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 433
			try {
				EXECUTION: {
					int count = getCount(1983747920) + 1;
					incrCount(1983747920);
					// Line: 434
					lookChild state318 = new lookChild();
					if (!flowThread.callState(state318, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 434, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 435
					tts.speak("Kirmizi renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 436
					iristk.flow.DialogFlow.wait waitState319 = new iristk.flow.DialogFlow.wait();
					waitState319.setMsec(3000);
					if (!flowThread.callState(waitState319, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 436, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state320 = agent.new say();
					StringCreator string321 = new StringCreator();
					string321.append("This is red.");
					state320.setText(string321.toString());
					if (!flowThread.callState(state320, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 439
					lookCaretaker state322 = new lookCaretaker();
					if (!flowThread.callState(state322, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 439, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 440
					tts.speak("Kirmizi karti cevirip sirayla itfaiye araci, trafik levhasi ve elma resimlerine isaret edin.", 1.0f, false, false);
					// Line: 441
					iristk.flow.DialogFlow.wait waitState323 = new iristk.flow.DialogFlow.wait();
					waitState323.setMsec(3000);
					if (!flowThread.callState(waitState323, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 441, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state324 = agent.new say();
					StringCreator string325 = new StringCreator();
					string325.append("The firetruck, the stop sign and the apple are all red. Red");
					state324.setText(string325.toString());
					if (!flowThread.callState(state324, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 444
					lookChild state326 = new lookChild();
					if (!flowThread.callState(state326, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 444, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 445
					tts.speak("Mavi renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 446
					iristk.flow.DialogFlow.wait waitState327 = new iristk.flow.DialogFlow.wait();
					waitState327.setMsec(3000);
					if (!flowThread.callState(waitState327, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 446, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state328 = agent.new say();
					StringCreator string329 = new StringCreator();
					string329.append("This is blue.");
					state328.setText(string329.toString());
					if (!flowThread.callState(state328, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 449
					lookCaretaker state330 = new lookCaretaker();
					if (!flowThread.callState(state330, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 449, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 450
					tts.speak("Mavi karti cevirip sirayla deniz, gokyuzu ve kelebek resimlerine isaret edin.", 1.0f, false, false);
					// Line: 451
					iristk.flow.DialogFlow.wait waitState331 = new iristk.flow.DialogFlow.wait();
					waitState331.setMsec(3000);
					if (!flowThread.callState(waitState331, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 451, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state332 = agent.new say();
					StringCreator string333 = new StringCreator();
					string333.append("The sea, the sky and the butterfly are all blue. Blue");
					state332.setText(string333.toString());
					if (!flowThread.callState(state332, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 454
					lookChild state334 = new lookChild();
					if (!flowThread.callState(state334, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 454, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 455
					tts.speak("Yesil renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 456
					iristk.flow.DialogFlow.wait waitState335 = new iristk.flow.DialogFlow.wait();
					waitState335.setMsec(3000);
					if (!flowThread.callState(waitState335, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 456, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state336 = agent.new say();
					StringCreator string337 = new StringCreator();
					string337.append("This is green.");
					state336.setText(string337.toString());
					if (!flowThread.callState(state336, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 459
					lookCaretaker state338 = new lookCaretaker();
					if (!flowThread.callState(state338, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 459, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 460
					tts.speak("Yesil karti cevirip sirayla cimen, agac ve armut resimlerine isaret edin.", 1.0f, false, false);
					// Line: 461
					iristk.flow.DialogFlow.wait waitState339 = new iristk.flow.DialogFlow.wait();
					waitState339.setMsec(3000);
					if (!flowThread.callState(waitState339, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 461, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state340 = agent.new say();
					StringCreator string341 = new StringCreator();
					string341.append("The grass, the tree and the pear are all green. Green");
					state340.setText(string341.toString());
					if (!flowThread.callState(state340, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 464
					lookChild state342 = new lookChild();
					if (!flowThread.callState(state342, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 464, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 465
					tts.speak("Sari renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 466
					iristk.flow.DialogFlow.wait waitState343 = new iristk.flow.DialogFlow.wait();
					waitState343.setMsec(3000);
					if (!flowThread.callState(waitState343, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 466, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state344 = agent.new say();
					StringCreator string345 = new StringCreator();
					string345.append("This is yellow.");
					state344.setText(string345.toString());
					if (!flowThread.callState(state344, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 469
					lookCaretaker state346 = new lookCaretaker();
					if (!flowThread.callState(state346, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 469, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 470
					tts.speak("Sari karti cevirip sirayla limon, ordek ve muz resimlerine isaret edin.", 1.0f, false, false);
					// Line: 471
					iristk.flow.DialogFlow.wait waitState347 = new iristk.flow.DialogFlow.wait();
					waitState347.setMsec(3000);
					if (!flowThread.callState(waitState347, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 471, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state348 = agent.new say();
					StringCreator string349 = new StringCreator();
					string349.append("The lemon, the duck and the banana are all yellow. Yellow");
					state348.setText(string349.toString());
					if (!flowThread.callState(state348, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 474
					lookChild state350 = new lookChild();
					if (!flowThread.callState(state350, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 474, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 475
					tts.speak("Turuncu renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 476
					iristk.flow.DialogFlow.wait waitState351 = new iristk.flow.DialogFlow.wait();
					waitState351.setMsec(3000);
					if (!flowThread.callState(waitState351, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 476, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state352 = agent.new say();
					StringCreator string353 = new StringCreator();
					string353.append("This is orange.");
					state352.setText(string353.toString());
					if (!flowThread.callState(state352, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 479
					lookCaretaker state354 = new lookCaretaker();
					if (!flowThread.callState(state354, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 479, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 480
					tts.speak("Turunucu karti cevirip sirayla portakal, havuc ve top resimlerine isaret edin.", 1.0f, false, false);
					// Line: 481
					iristk.flow.DialogFlow.wait waitState355 = new iristk.flow.DialogFlow.wait();
					waitState355.setMsec(3000);
					if (!flowThread.callState(waitState355, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 481, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state356 = agent.new say();
					StringCreator string357 = new StringCreator();
					string357.append("The orange, the carrot and the basketball are all orange. Orange");
					state356.setText(string357.toString());
					if (!flowThread.callState(state356, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 484
					lookChild state358 = new lookChild();
					if (!flowThread.callState(state358, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 484, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 485
					tts.speak("Mor renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 486
					iristk.flow.DialogFlow.wait waitState359 = new iristk.flow.DialogFlow.wait();
					waitState359.setMsec(3000);
					if (!flowThread.callState(waitState359, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 486, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state360 = agent.new say();
					StringCreator string361 = new StringCreator();
					string361.append("This is purple.");
					state360.setText(string361.toString());
					if (!flowThread.callState(state360, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 489
					lookCaretaker state362 = new lookCaretaker();
					if (!flowThread.callState(state362, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 489, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 490
					tts.speak("Mor karti cevirip sirayla uzum, patlican ve bot resimlerine isaret edin.", 1.0f, false, false);
					// Line: 491
					iristk.flow.DialogFlow.wait waitState363 = new iristk.flow.DialogFlow.wait();
					waitState363.setMsec(3000);
					if (!flowThread.callState(waitState363, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 491, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state364 = agent.new say();
					StringCreator string365 = new StringCreator();
					string365.append("The grapes, the eggplant and the boots are all purple. Purple");
					state364.setText(string365.toString());
					if (!flowThread.callState(state364, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 494
					iristk.flow.DialogFlow.wait waitState366 = new iristk.flow.DialogFlow.wait();
					waitState366.setMsec(2000);
					if (!flowThread.callState(waitState366, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 494, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state367 = agent.new say();
					StringCreator string368 = new StringCreator();
					string368.append("Now you know your colors.");
					state367.setText(string368.toString());
					if (!flowThread.callState(state367, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 496
					CheckAgain state369 = new CheckAgain();
					flowThread.gotoState(state369, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 496, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 433, 12));
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
			// Line: 506
			try {
				EXECUTION: {
					int count = getCount(801197928) + 1;
					incrCount(801197928);
					// Line: 507
					lookChild state370 = new lookChild();
					if (!flowThread.callState(state370, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 507, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state371 = agent.new say();
					StringCreator string372 = new StringCreator();
					string372.append("Let's have some fun. Which subject would you like to play with?");
					state371.setText(string372.toString());
					if (!flowThread.callState(state371, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 506, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state373 = agent.new listen();
					if (!flowThread.callState(state373, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 506, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 506, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 512
			try {
				count = getCount(1711574013) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(1711574013);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 513
							PlayAnimals state374 = new PlayAnimals();
							flowThread.gotoState(state374, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 513, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 512, 61));
			}
			// Line: 515
			try {
				count = getCount(1146848448) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(1146848448);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 516
							PlayColors state375 = new PlayColors();
							flowThread.gotoState(state375, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 516, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 515, 60));
			}
			// Line: 518
			try {
				count = getCount(591137559) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:object")) {
						incrCount(591137559);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 519
							PlayObjects state376 = new PlayObjects();
							flowThread.gotoState(state376, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 519, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 518, 61));
			}
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
			// Line: 524
			try {
				EXECUTION: {
					int count = getCount(866191240) + 1;
					incrCount(866191240);
					iristk.situated.SystemAgentFlow.say state377 = agent.new say();
					StringCreator string378 = new StringCreator();
					string378.append("Let's see if you have learned your colors.");
					state377.setText(string378.toString());
					if (!flowThread.callState(state377, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 524, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 526
					iristk.flow.DialogFlow.wait waitState379 = new iristk.flow.DialogFlow.wait();
					waitState379.setMsec(3000);
					if (!flowThread.callState(waitState379, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 526, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 527
					lookCaretaker state380 = new lookCaretaker();
					if (!flowThread.callState(state380, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 528
					PlayPrepare state381 = new PlayPrepare();
					if (!flowThread.callState(state381, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 528, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state382 = agent.new say();
					StringCreator string383 = new StringCreator();
					string383.append("Let's start the game.");
					state382.setText(string383.toString());
					if (!flowThread.callState(state382, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 524, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 531
					tts.speak("Oyuna başlıyoruz.", 1.0f, false, false);
					// Line: 533
					lookChild state384 = new lookChild();
					if (!flowThread.callState(state384, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 533, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state385 = agent.new say();
					StringCreator string386 = new StringCreator();
					string386.append("Can you show me the color red?");
					state385.setText(string386.toString());
					if (!flowThread.callState(state385, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 524, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 535
					tts.speak("Cocuğa kırmızı rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 536
					lookBoard state387 = new lookBoard();
					if (!flowThread.callState(state387, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 536, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 537
					iristk.flow.DialogFlow.wait waitState388 = new iristk.flow.DialogFlow.wait();
					waitState388.setMsec(4000);
					if (!flowThread.callState(waitState388, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 537, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 538
					Showing state389 = new Showing();
					if (!flowThread.callState(state389, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 538, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 540
					lookChild state390 = new lookChild();
					if (!flowThread.callState(state390, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 540, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state391 = agent.new say();
					StringCreator string392 = new StringCreator();
					string392.append("Can you show me the color purple?");
					state391.setText(string392.toString());
					if (!flowThread.callState(state391, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 524, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 542
					tts.speak("Cocuğa mor rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 543
					lookBoard state393 = new lookBoard();
					if (!flowThread.callState(state393, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 543, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 544
					iristk.flow.DialogFlow.wait waitState394 = new iristk.flow.DialogFlow.wait();
					waitState394.setMsec(4000);
					if (!flowThread.callState(waitState394, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 544, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 545
					Showing state395 = new Showing();
					if (!flowThread.callState(state395, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 545, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 547
					lookChild state396 = new lookChild();
					if (!flowThread.callState(state396, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 547, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state397 = agent.new say();
					StringCreator string398 = new StringCreator();
					string398.append("Can you first show me the color orange then yellow?");
					state397.setText(string398.toString());
					if (!flowThread.callState(state397, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 524, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 549
					tts.speak("Cocuğa önce turuncu sonra sari rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 550
					lookBoard state399 = new lookBoard();
					if (!flowThread.callState(state399, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 550, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 551
					iristk.flow.DialogFlow.wait waitState400 = new iristk.flow.DialogFlow.wait();
					waitState400.setMsec(4000);
					if (!flowThread.callState(waitState400, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 551, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 552
					Showing state401 = new Showing();
					if (!flowThread.callState(state401, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 552, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 554
					lookChild state402 = new lookChild();
					if (!flowThread.callState(state402, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 554, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state403 = agent.new say();
					StringCreator string404 = new StringCreator();
					string404.append("Can you show me the color of grass?");
					state403.setText(string404.toString());
					if (!flowThread.callState(state403, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 524, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 556
					tts.speak("Cocuğa yeşil rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 557
					lookBoard state405 = new lookBoard();
					if (!flowThread.callState(state405, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 557, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 558
					iristk.flow.DialogFlow.wait waitState406 = new iristk.flow.DialogFlow.wait();
					waitState406.setMsec(4000);
					if (!flowThread.callState(waitState406, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 558, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 559
					Showing state407 = new Showing();
					if (!flowThread.callState(state407, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 559, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 561
					lookChild state408 = new lookChild();
					if (!flowThread.callState(state408, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 561, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state409 = agent.new say();
					StringCreator string410 = new StringCreator();
					string410.append("Can you show me the color of firetruck?");
					state409.setText(string410.toString());
					if (!flowThread.callState(state409, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 524, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 563
					tts.speak("Cocuğa kırmızı rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 564
					lookBoard state411 = new lookBoard();
					if (!flowThread.callState(state411, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 564, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 565
					iristk.flow.DialogFlow.wait waitState412 = new iristk.flow.DialogFlow.wait();
					waitState412.setMsec(4000);
					if (!flowThread.callState(waitState412, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 565, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 566
					Showing state413 = new Showing();
					if (!flowThread.callState(state413, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 566, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 568
					CheckAgain state414 = new CheckAgain();
					flowThread.gotoState(state414, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 568, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 524, 12));
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
			// Line: 574
			try {
				EXECUTION: {
					int count = getCount(706277948) + 1;
					incrCount(706277948);
					iristk.situated.SystemAgentFlow.say state415 = agent.new say();
					StringCreator string416 = new StringCreator();
					string416.append("Great choice. I love animals.");
					state415.setText(string416.toString());
					if (!flowThread.callState(state415, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 574, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 576
					iristk.flow.DialogFlow.wait waitState417 = new iristk.flow.DialogFlow.wait();
					waitState417.setMsec(3000);
					if (!flowThread.callState(waitState417, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 576, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 577
					lookCaretaker state418 = new lookCaretaker();
					if (!flowThread.callState(state418, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 577, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 578
					PlayPrepare state419 = new PlayPrepare();
					if (!flowThread.callState(state419, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 578, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state420 = agent.new say();
					StringCreator string421 = new StringCreator();
					string421.append("Let's start the game.");
					state420.setText(string421.toString());
					if (!flowThread.callState(state420, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 574, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 581
					tts.speak("Oyuna başlıyoruz.", 1.0f, false, false);
					// Line: 583
					lookChild state422 = new lookChild();
					if (!flowThread.callState(state422, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 583, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state423 = agent.new say();
					StringCreator string424 = new StringCreator();
					string424.append("Can you show me the dog on the board?");
					state423.setText(string424.toString());
					if (!flowThread.callState(state423, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 574, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 585
					tts.speak("Cocuğa köpek fotoğrafını göstermesini istedim.", 1.0f, false, false);
					// Line: 586
					lookBoard state425 = new lookBoard();
					if (!flowThread.callState(state425, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 586, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 587
					iristk.flow.DialogFlow.wait waitState426 = new iristk.flow.DialogFlow.wait();
					waitState426.setMsec(4000);
					if (!flowThread.callState(waitState426, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 587, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 588
					Showing state427 = new Showing();
					if (!flowThread.callState(state427, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 588, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 590
					lookChild state428 = new lookChild();
					if (!flowThread.callState(state428, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 590, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state429 = agent.new say();
					StringCreator string430 = new StringCreator();
					string430.append("Can you show me the fish on the board?");
					state429.setText(string430.toString());
					if (!flowThread.callState(state429, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 574, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 592
					tts.speak("Cocuğa balık fotoğrafını göstermesini istedim.", 1.0f, false, false);
					// Line: 593
					lookBoard state431 = new lookBoard();
					if (!flowThread.callState(state431, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 593, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 594
					iristk.flow.DialogFlow.wait waitState432 = new iristk.flow.DialogFlow.wait();
					waitState432.setMsec(4000);
					if (!flowThread.callState(waitState432, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 594, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 595
					Showing state433 = new Showing();
					if (!flowThread.callState(state433, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 595, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 597
					lookChild state434 = new lookChild();
					if (!flowThread.callState(state434, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 597, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state435 = agent.new say();
					StringCreator string436 = new StringCreator();
					string436.append("Can you show me the animal that flies on the board?");
					state435.setText(string436.toString());
					if (!flowThread.callState(state435, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 574, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 599
					tts.speak("Cocuğa kuş fotoğrafını göstermesini istedim.", 1.0f, false, false);
					// Line: 600
					lookBoard state437 = new lookBoard();
					if (!flowThread.callState(state437, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 600, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 601
					iristk.flow.DialogFlow.wait waitState438 = new iristk.flow.DialogFlow.wait();
					waitState438.setMsec(4000);
					if (!flowThread.callState(waitState438, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 601, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 602
					Showing state439 = new Showing();
					if (!flowThread.callState(state439, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 602, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 604
					lookChild state440 = new lookChild();
					if (!flowThread.callState(state440, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 604, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state441 = agent.new say();
					StringCreator string442 = new StringCreator();
					string442.append("Can you show me the animals that have four legs?");
					state441.setText(string442.toString());
					if (!flowThread.callState(state441, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 574, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 606
					tts.speak("Cocuğa hem kedi hem de köpek fotoğrafını göstermesini istedim.", 1.0f, false, false);
					// Line: 607
					lookBoard state443 = new lookBoard();
					if (!flowThread.callState(state443, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 607, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 608
					iristk.flow.DialogFlow.wait waitState444 = new iristk.flow.DialogFlow.wait();
					waitState444.setMsec(4000);
					if (!flowThread.callState(waitState444, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 608, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 609
					Showing state445 = new Showing();
					if (!flowThread.callState(state445, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 609, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 611
					lookChild state446 = new lookChild();
					if (!flowThread.callState(state446, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 611, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state447 = agent.new say();
					StringCreator string448 = new StringCreator();
					string448.append("Can you show me the animal that says meow?");
					state447.setText(string448.toString());
					if (!flowThread.callState(state447, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 574, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 613
					tts.speak("Cocuğa kedi fotoğrafını göstermesini istedim.", 1.0f, false, false);
					// Line: 614
					lookBoard state449 = new lookBoard();
					if (!flowThread.callState(state449, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 614, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 615
					iristk.flow.DialogFlow.wait waitState450 = new iristk.flow.DialogFlow.wait();
					waitState450.setMsec(4000);
					if (!flowThread.callState(waitState450, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 615, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 616
					Showing state451 = new Showing();
					if (!flowThread.callState(state451, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 616, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 618
					CheckAgain state452 = new CheckAgain();
					flowThread.gotoState(state452, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 618, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 574, 12));
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
			// Line: 627
			try {
				EXECUTION: {
					int count = getCount(1456208737) + 1;
					incrCount(1456208737);
					// Line: 628
					tts.speak("Ilgili desteyi alınız ve rastgele diziniz. Dizme bitince OKEY sesi çıkarın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state453 = agent.new say();
					StringCreator string454 = new StringCreator();
					string454.append("Would you please distribute the cards to the board?");
					state453.setText(string454.toString());
					if (!flowThread.callState(state453, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 627, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state455 = agent.new listen();
					if (!flowThread.callState(state455, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 627, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 627, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 632
			try {
				count = getCount(13648335) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:okay")) {
						incrCount(13648335);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 633
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 633, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 632, 59));
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
			// Line: 638
			try {
				EXECUTION: {
					int count = getCount(796684896) + 1;
					incrCount(796684896);
					// Line: 639
					lookCaretaker state456 = new lookCaretaker();
					if (!flowThread.callState(state456, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 639, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state457 = agent.new say();
					StringCreator string458 = new StringCreator();
					string458.append("Is that correct?");
					state457.setText(string458.toString());
					if (!flowThread.callState(state457, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 638, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 641
					tts.speak("Eğer çocuk doğru kartı gösterdiyse YES sesi çıkarın, yanlış göstediyse NO sesi çıkarın.", 1.0f, false, false);
					// Line: 642
					iristk.flow.DialogFlow.wait waitState459 = new iristk.flow.DialogFlow.wait();
					waitState459.setMsec(4000);
					if (!flowThread.callState(waitState459, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 642, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state460 = agent.new listen();
					if (!flowThread.callState(state460, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 638, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 638, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 645
			try {
				count = getCount(659748578) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(659748578);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 646
							lookChild state461 = new lookChild();
							if (!flowThread.callState(state461, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 646, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state462 = agent.new say();
							StringCreator string463 = new StringCreator();
							string463.append("Good Job. You are doing great.");
							state462.setText(string463.toString());
							if (!flowThread.callState(state462, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 645, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 648
							iristk.flow.DialogFlow.wait waitState464 = new iristk.flow.DialogFlow.wait();
							waitState464.setMsec(3000);
							if (!flowThread.callState(waitState464, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 648, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 649
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 649, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 645, 58));
			}
			// Line: 652
			try {
				count = getCount(1277181601) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1277181601);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 653
							lookChild state465 = new lookChild();
							if (!flowThread.callState(state465, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 653, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state466 = agent.new say();
							StringCreator string467 = new StringCreator();
							string467.append("It's alright. Let's see which one is the correct answer.");
							state466.setText(string467.toString());
							if (!flowThread.callState(state466, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 652, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 655
							lookCaretaker state468 = new lookCaretaker();
							if (!flowThread.callState(state468, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 655, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state469 = agent.new say();
							StringCreator string470 = new StringCreator();
							string470.append("Can you show me the correct answer please?");
							state469.setText(string470.toString());
							if (!flowThread.callState(state469, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 652, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 657
							tts.speak("Doğru cevabı cocuğa gösteriniz.", 1.0f, false, false);
							// Line: 658
							iristk.flow.DialogFlow.wait waitState471 = new iristk.flow.DialogFlow.wait();
							waitState471.setMsec(4000);
							if (!flowThread.callState(waitState471, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 658, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state472 = agent.new say();
							StringCreator string473 = new StringCreator();
							string473.append("Let's continue.");
							state472.setText(string473.toString());
							if (!flowThread.callState(state472, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 652, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 660
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 660, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 652, 57));
			}
			// Line: 663
			try {
				count = getCount(557041912) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(557041912);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state474 = agent.new say();
						StringCreator string475 = new StringCreator();
						string475.append("I did not get that.");
						state474.setText(string475.toString());
						if (!flowThread.callState(state474, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 663, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 665
						Showing state476 = new Showing();
						flowThread.gotoState(state476, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 665, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 663, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PlayObjects extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 670
			try {
				EXECUTION: {
					int count = getCount(1435804085) + 1;
					incrCount(1435804085);
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 670, 12));
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
			// Line: 678
			try {
				EXECUTION: {
					int count = getCount(1854778591) + 1;
					incrCount(1854778591);
					iristk.situated.SystemAgentFlow.say state477 = agent.new say();
					StringCreator string478 = new StringCreator();
					string478.append("Do you want to continue?");
					state477.setText(string478.toString());
					if (!flowThread.callState(state477, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 678, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state479 = agent.new listen();
					if (!flowThread.callState(state479, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 678, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 678, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 682
			try {
				count = getCount(2054798982) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(2054798982);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state480 = agent.new say();
							StringCreator string481 = new StringCreator();
							string481.append("Okay, let's play again.");
							state480.setText(string481.toString());
							if (!flowThread.callState(state480, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 682, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 684
							Start state482 = new Start();
							flowThread.gotoState(state482, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 684, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 682, 58));
			}
			// Line: 686
			try {
				count = getCount(191382150) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(191382150);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state483 = agent.new say();
							StringCreator string484 = new StringCreator();
							string484.append("Okay, goodbye");
							state483.setText(string484.toString());
							if (!flowThread.callState(state483, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 686, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 688
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 686, 57));
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
			// Line: 693
			try {
				count = getCount(2137211482) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(2137211482);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state485 = agent.new say();
						StringCreator string486 = new StringCreator();
						string486.append("I am sorry, I didn't hear anything.");
						state485.setText(string486.toString());
						if (!flowThread.callState(state485, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 693, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 695
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 695, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 693, 38));
			}
			// Line: 697
			try {
				count = getCount(968514068) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(968514068);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state487 = agent.new say();
						StringCreator string488 = new StringCreator();
						string488.append("I am sorry, I didn't get that.");
						state487.setText(string488.toString());
						if (!flowThread.callState(state487, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 697, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 699
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 699, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 697, 36));
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
			// Line: 708
			try {
				EXECUTION: {
					int count = getCount(434091818) + 1;
					incrCount(434091818);
					// Line: 709
					Event sendEvent489 = new Event("action.gaze");
					sendEvent489.putIfNotNull("location", new Location(degx, degy, degz));
					flowRunner.sendEvent(sendEvent489, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 709, 76)));
					// Line: 710
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 710, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 708, 12));
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
			// Line: 715
			try {
				EXECUTION: {
					int count = getCount(1504109395) + 1;
					incrCount(1504109395);
					// Line: 716
					Event sendEvent490 = new Event("action.gaze");
					sendEvent490.putIfNotNull("location", new Location(-1, 0, 1));
					flowRunner.sendEvent(sendEvent490, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 716, 68)));
					// Line: 717
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 717, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 715, 12));
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
			// Line: 722
			try {
				EXECUTION: {
					int count = getCount(25126016) + 1;
					incrCount(25126016);
					// Line: 723
					Event sendEvent491 = new Event("action.gaze");
					sendEvent491.putIfNotNull("location", new Location(1, 0, 1));
					flowRunner.sendEvent(sendEvent491, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 723, 67)));
					// Line: 724
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 724, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 722, 12));
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
			// Line: 729
			try {
				EXECUTION: {
					int count = getCount(1349414238) + 1;
					incrCount(1349414238);
					// Line: 730
					Event sendEvent492 = new Event("action.gaze");
					sendEvent492.putIfNotNull("location", new Location(0, -1, 1));
					flowRunner.sendEvent(sendEvent492, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 730, 68)));
					// Line: 731
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 731, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 729, 12));
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
