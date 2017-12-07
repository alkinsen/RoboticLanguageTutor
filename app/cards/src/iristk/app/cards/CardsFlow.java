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
	private AudioPlayer audioplayer;

	private void initVariables() {
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
		tts = (application.TextToSpeech) new TextToSpeech();
		audioplayer = (AudioPlayer) new AudioPlayer();
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

	public AudioPlayer getAudioplayer() {
		return this.audioplayer;
	}

	public void setAudioplayer(AudioPlayer value) {
		this.audioplayer = value;
	}

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("system")) return this.system;
		if (name.equals("tts")) return this.tts;
		if (name.equals("audioplayer")) return this.audioplayer;
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
			// Line: 18
			try {
				EXECUTION: {
					int count = getCount(1174290147) + 1;
					incrCount(1174290147);
					// Line: 19
					lookCaretaker state0 = new lookCaretaker();
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 19, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 20
					tts.setVoice("dfki-ot-hsmm");
					// Line: 21
					audioplayer.playSound("audio/StartLevel.wav");
					// Line: 22
					lookChild state1 = new lookChild();
					if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 22, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 23
					iristk.flow.DialogFlow.wait waitState2 = new iristk.flow.DialogFlow.wait();
					waitState2.setMsec(3000);
					if (!flowThread.callState(waitState2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 23, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state3 = agent.new say();
					StringCreator string4 = new StringCreator();
					string4.append("Hello there I am Furhat, which level do you want to play?");
					state3.setText(string4.toString());
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 18, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 25
					Play state5 = new Play();
					flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 25, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 18, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 31
			try {
				count = getCount(245565335) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:one")) {
						incrCount(245565335);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 32
							EasyLearn state6 = new EasyLearn();
							flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 32, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 31, 58));
			}
			// Line: 34
			try {
				count = getCount(1066376662) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:two")) {
						incrCount(1066376662);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 35
							Learn state7 = new Learn();
							flowThread.gotoState(state7, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 35, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 34, 58));
			}
			// Line: 37
			try {
				count = getCount(476402209) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:three")) {
						incrCount(476402209);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 38
							Play state8 = new Play();
							flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 38, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 37, 60));
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
			// Line: 44
			try {
				EXECUTION: {
					int count = getCount(1919892312) + 1;
					incrCount(1919892312);
					// Line: 45
					lookChild state9 = new lookChild();
					if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 45, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state10 = agent.new say();
					StringCreator string11 = new StringCreator();
					string11.append("Which subject would you like to learn about?");
					state10.setText(string11.toString());
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 44, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state12 = agent.new listen();
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 44, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 44, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 50
			try {
				count = getCount(250075633) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(250075633);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 51
							EasyLearnAnimals state13 = new EasyLearnAnimals();
							flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 51, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 50, 61));
			}
			// Line: 53
			try {
				count = getCount(517938326) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(517938326);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 54
							EasyLearnColors state14 = new EasyLearnColors();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 54, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 53, 60));
			}
			// Line: 56
			try {
				count = getCount(110718392) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:body")) {
						incrCount(110718392);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 57
							EasyLearnBody state15 = new EasyLearnBody();
							flowThread.gotoState(state15, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 57, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 56, 59));
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
			// Line: 63
			try {
				EXECUTION: {
					int count = getCount(1100439041) + 1;
					incrCount(1100439041);
					iristk.situated.SystemAgentFlow.say state16 = agent.new say();
					StringCreator string17 = new StringCreator();
					string17.append("Let's read a book. The book is Brown Bear, Brown Bear.");
					state16.setText(string17.toString());
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 65
					iristk.flow.DialogFlow.wait waitState18 = new iristk.flow.DialogFlow.wait();
					waitState18.setMsec(3000);
					if (!flowThread.callState(waitState18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 65, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 67
					tts.speak("Ayıyı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state19 = agent.new say();
					StringCreator string20 = new StringCreator();
					string20.append("Brown bear, brown bear, what do you see?");
					state19.setText(string20.toString());
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 69
					iristk.flow.DialogFlow.wait waitState21 = new iristk.flow.DialogFlow.wait();
					waitState21.setMsec(1000);
					if (!flowThread.callState(waitState21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 69, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 70
					tts.speak("Kuşu gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state22 = agent.new say();
					StringCreator string23 = new StringCreator();
					string23.append("I see a red bird looking at me.");
					state22.setText(string23.toString());
					if (!flowThread.callState(state22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 72
					iristk.flow.DialogFlow.wait waitState24 = new iristk.flow.DialogFlow.wait();
					waitState24.setMsec(1000);
					if (!flowThread.callState(waitState24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 72, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state25 = agent.new say();
					StringCreator string26 = new StringCreator();
					string26.append("Red bird, red bird, what do you see?");
					state25.setText(string26.toString());
					if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 74
					iristk.flow.DialogFlow.wait waitState27 = new iristk.flow.DialogFlow.wait();
					waitState27.setMsec(1000);
					if (!flowThread.callState(waitState27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 74, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 75
					tts.speak("Ördeği gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state28 = agent.new say();
					StringCreator string29 = new StringCreator();
					string29.append("I see a yellow duck looking at me.");
					state28.setText(string29.toString());
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 77
					iristk.flow.DialogFlow.wait waitState30 = new iristk.flow.DialogFlow.wait();
					waitState30.setMsec(1000);
					if (!flowThread.callState(waitState30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 77, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state31 = agent.new say();
					StringCreator string32 = new StringCreator();
					string32.append("Yellow duck, yellow duck, what do you see?");
					state31.setText(string32.toString());
					if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 79
					iristk.flow.DialogFlow.wait waitState33 = new iristk.flow.DialogFlow.wait();
					waitState33.setMsec(1000);
					if (!flowThread.callState(waitState33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 79, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 80
					tts.speak("Atı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state34 = agent.new say();
					StringCreator string35 = new StringCreator();
					string35.append("I see a blue horse looking at me.");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 82
					iristk.flow.DialogFlow.wait waitState36 = new iristk.flow.DialogFlow.wait();
					waitState36.setMsec(1000);
					if (!flowThread.callState(waitState36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 82, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state37 = agent.new say();
					StringCreator string38 = new StringCreator();
					string38.append("Blue horse, blue horse, what do you see?");
					state37.setText(string38.toString());
					if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 84
					iristk.flow.DialogFlow.wait waitState39 = new iristk.flow.DialogFlow.wait();
					waitState39.setMsec(1000);
					if (!flowThread.callState(waitState39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 84, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 85
					tts.speak("Kurbağayı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state40 = agent.new say();
					StringCreator string41 = new StringCreator();
					string41.append("I see a green frog looking at me.");
					state40.setText(string41.toString());
					if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 87
					iristk.flow.DialogFlow.wait waitState42 = new iristk.flow.DialogFlow.wait();
					waitState42.setMsec(1000);
					if (!flowThread.callState(waitState42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 87, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state43 = agent.new say();
					StringCreator string44 = new StringCreator();
					string44.append("Green frog, green frog, what do you see?");
					state43.setText(string44.toString());
					if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 89
					iristk.flow.DialogFlow.wait waitState45 = new iristk.flow.DialogFlow.wait();
					waitState45.setMsec(1000);
					if (!flowThread.callState(waitState45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 89, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 90
					tts.speak("Kediyi gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state46 = agent.new say();
					StringCreator string47 = new StringCreator();
					string47.append("I see a purple cat looking at me.");
					state46.setText(string47.toString());
					if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 92
					iristk.flow.DialogFlow.wait waitState48 = new iristk.flow.DialogFlow.wait();
					waitState48.setMsec(1000);
					if (!flowThread.callState(waitState48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 92, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state49 = agent.new say();
					StringCreator string50 = new StringCreator();
					string50.append("Purple cat, purple cat, what do you see?");
					state49.setText(string50.toString());
					if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 94
					iristk.flow.DialogFlow.wait waitState51 = new iristk.flow.DialogFlow.wait();
					waitState51.setMsec(1000);
					if (!flowThread.callState(waitState51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 94, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 95
					tts.speak("Köpeği gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state52 = agent.new say();
					StringCreator string53 = new StringCreator();
					string53.append("I see a white dog looking at me.");
					state52.setText(string53.toString());
					if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 97
					iristk.flow.DialogFlow.wait waitState54 = new iristk.flow.DialogFlow.wait();
					waitState54.setMsec(1000);
					if (!flowThread.callState(waitState54, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 97, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state55 = agent.new say();
					StringCreator string56 = new StringCreator();
					string56.append("White dog, white dog, what do you see?");
					state55.setText(string56.toString());
					if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 99
					iristk.flow.DialogFlow.wait waitState57 = new iristk.flow.DialogFlow.wait();
					waitState57.setMsec(1000);
					if (!flowThread.callState(waitState57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 99, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 100
					tts.speak("Kuzuyu gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state58 = agent.new say();
					StringCreator string59 = new StringCreator();
					string59.append("I see a black sheep looking at me.");
					state58.setText(string59.toString());
					if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 102
					iristk.flow.DialogFlow.wait waitState60 = new iristk.flow.DialogFlow.wait();
					waitState60.setMsec(1000);
					if (!flowThread.callState(waitState60, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 102, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state61 = agent.new say();
					StringCreator string62 = new StringCreator();
					string62.append("Black sheep, black sheep what do you see?");
					state61.setText(string62.toString());
					if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 104
					iristk.flow.DialogFlow.wait waitState63 = new iristk.flow.DialogFlow.wait();
					waitState63.setMsec(1000);
					if (!flowThread.callState(waitState63, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 104, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 105
					tts.speak("Balığı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state64 = agent.new say();
					StringCreator string65 = new StringCreator();
					string65.append("I see a gold fish looking at me.");
					state64.setText(string65.toString());
					if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 107
					iristk.flow.DialogFlow.wait waitState66 = new iristk.flow.DialogFlow.wait();
					waitState66.setMsec(1000);
					if (!flowThread.callState(waitState66, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 107, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state67 = agent.new say();
					StringCreator string68 = new StringCreator();
					string68.append("Gold fish, gold fish, what do you see?");
					state67.setText(string68.toString());
					if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 109
					iristk.flow.DialogFlow.wait waitState69 = new iristk.flow.DialogFlow.wait();
					waitState69.setMsec(1000);
					if (!flowThread.callState(waitState69, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 109, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 110
					tts.speak("Kendinizi gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state70 = agent.new say();
					StringCreator string71 = new StringCreator();
					string71.append("I see a nanny looking at me.");
					state70.setText(string71.toString());
					if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 112
					iristk.flow.DialogFlow.wait waitState72 = new iristk.flow.DialogFlow.wait();
					waitState72.setMsec(1000);
					if (!flowThread.callState(waitState72, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state73 = agent.new say();
					StringCreator string74 = new StringCreator();
					string74.append("Nanny, nanny, what do you see?");
					state73.setText(string74.toString());
					if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 114
					iristk.flow.DialogFlow.wait waitState75 = new iristk.flow.DialogFlow.wait();
					waitState75.setMsec(1000);
					if (!flowThread.callState(waitState75, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 114, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 115
					tts.speak("Bebeği gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state76 = agent.new say();
					StringCreator string77 = new StringCreator();
					string77.append("I see a baby looking at me.");
					state76.setText(string77.toString());
					if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 117
					iristk.flow.DialogFlow.wait waitState78 = new iristk.flow.DialogFlow.wait();
					waitState78.setMsec(1000);
					if (!flowThread.callState(waitState78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 117, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state79 = agent.new say();
					StringCreator string80 = new StringCreator();
					string80.append("Well done! I love this book!");
					state79.setText(string80.toString());
					if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 63, 12));
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
			// Line: 123
			try {
				EXECUTION: {
					int count = getCount(758529971) + 1;
					incrCount(758529971);
					// Line: 124
					lookCaretaker state81 = new lookCaretaker();
					if (!flowThread.callState(state81, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 124, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 125
					tts.speak("Kırmızı kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 126
					iristk.flow.DialogFlow.wait waitState82 = new iristk.flow.DialogFlow.wait();
					waitState82.setMsec(3000);
					if (!flowThread.callState(waitState82, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 126, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state83 = agent.new say();
					StringCreator string84 = new StringCreator();
					string84.append("This is red.");
					state83.setText(string84.toString());
					if (!flowThread.callState(state83, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 129
					lookChild state85 = new lookChild();
					if (!flowThread.callState(state85, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 129, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 130
					tts.speak("Kırmızı kartı çevirip elmaya işaret edin.", 1.0f, false, false);
					// Line: 131
					iristk.flow.DialogFlow.wait waitState86 = new iristk.flow.DialogFlow.wait();
					waitState86.setMsec(3000);
					if (!flowThread.callState(waitState86, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 131, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state87 = agent.new say();
					StringCreator string88 = new StringCreator();
					string88.append("What is red? Apple is red. Apple is red.");
					state87.setText(string88.toString());
					if (!flowThread.callState(state87, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 134
					lookChild state89 = new lookChild();
					if (!flowThread.callState(state89, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 134, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 135
					tts.speak("Mavi kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 136
					iristk.flow.DialogFlow.wait waitState90 = new iristk.flow.DialogFlow.wait();
					waitState90.setMsec(3000);
					if (!flowThread.callState(waitState90, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 136, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state91 = agent.new say();
					StringCreator string92 = new StringCreator();
					string92.append("This is blue.");
					state91.setText(string92.toString());
					if (!flowThread.callState(state91, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 139
					lookCaretaker state93 = new lookCaretaker();
					if (!flowThread.callState(state93, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 139, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 140
					tts.speak("Mavi kartı çevirip gök yüzüne işaret edin.", 1.0f, false, false);
					// Line: 141
					iristk.flow.DialogFlow.wait waitState94 = new iristk.flow.DialogFlow.wait();
					waitState94.setMsec(3000);
					if (!flowThread.callState(waitState94, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 141, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state95 = agent.new say();
					StringCreator string96 = new StringCreator();
					string96.append("What is blue? The sky is blue. The sky is blue.");
					state95.setText(string96.toString());
					if (!flowThread.callState(state95, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 144
					lookChild state97 = new lookChild();
					if (!flowThread.callState(state97, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 144, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 145
					tts.speak("Yeşil kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 146
					iristk.flow.DialogFlow.wait waitState98 = new iristk.flow.DialogFlow.wait();
					waitState98.setMsec(3000);
					if (!flowThread.callState(waitState98, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 146, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state99 = agent.new say();
					StringCreator string100 = new StringCreator();
					string100.append("This is green.");
					state99.setText(string100.toString());
					if (!flowThread.callState(state99, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 149
					lookCaretaker state101 = new lookCaretaker();
					if (!flowThread.callState(state101, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 149, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 150
					tts.speak("Yeşil kartı çevirip çimene işaret edin.", 1.0f, false, false);
					// Line: 151
					iristk.flow.DialogFlow.wait waitState102 = new iristk.flow.DialogFlow.wait();
					waitState102.setMsec(3000);
					if (!flowThread.callState(waitState102, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 151, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state103 = agent.new say();
					StringCreator string104 = new StringCreator();
					string104.append("What is green? The grass is green. The grass is green.");
					state103.setText(string104.toString());
					if (!flowThread.callState(state103, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 154
					lookChild state105 = new lookChild();
					if (!flowThread.callState(state105, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 154, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 155
					tts.speak("Sarı kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 156
					iristk.flow.DialogFlow.wait waitState106 = new iristk.flow.DialogFlow.wait();
					waitState106.setMsec(3000);
					if (!flowThread.callState(waitState106, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 156, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state107 = agent.new say();
					StringCreator string108 = new StringCreator();
					string108.append("This is yellow.");
					state107.setText(string108.toString());
					if (!flowThread.callState(state107, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 159
					lookCaretaker state109 = new lookCaretaker();
					if (!flowThread.callState(state109, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 159, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 160
					tts.speak("Sarı kartı çevirip limona işaret edin.", 1.0f, false, false);
					// Line: 161
					iristk.flow.DialogFlow.wait waitState110 = new iristk.flow.DialogFlow.wait();
					waitState110.setMsec(3000);
					if (!flowThread.callState(waitState110, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 161, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state111 = agent.new say();
					StringCreator string112 = new StringCreator();
					string112.append("What is yellow? Lemon is yellow. Lemon is yellow.");
					state111.setText(string112.toString());
					if (!flowThread.callState(state111, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 164
					lookChild state113 = new lookChild();
					if (!flowThread.callState(state113, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 164, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 165
					tts.speak("Turuncu kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 166
					iristk.flow.DialogFlow.wait waitState114 = new iristk.flow.DialogFlow.wait();
					waitState114.setMsec(3000);
					if (!flowThread.callState(waitState114, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 166, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state115 = agent.new say();
					StringCreator string116 = new StringCreator();
					string116.append("This is orange.");
					state115.setText(string116.toString());
					if (!flowThread.callState(state115, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 169
					lookCaretaker state117 = new lookCaretaker();
					if (!flowThread.callState(state117, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 169, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 170
					tts.speak("Turunucu kartı çevirip havuca işaret edin.", 1.0f, false, false);
					// Line: 171
					iristk.flow.DialogFlow.wait waitState118 = new iristk.flow.DialogFlow.wait();
					waitState118.setMsec(3000);
					if (!flowThread.callState(waitState118, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 171, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state119 = agent.new say();
					StringCreator string120 = new StringCreator();
					string120.append("What is orange? Carrot is orange. Carrot is orange.");
					state119.setText(string120.toString());
					if (!flowThread.callState(state119, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 174
					lookChild state121 = new lookChild();
					if (!flowThread.callState(state121, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 174, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 175
					tts.speak("Kahverengi kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 176
					iristk.flow.DialogFlow.wait waitState122 = new iristk.flow.DialogFlow.wait();
					waitState122.setMsec(3000);
					if (!flowThread.callState(waitState122, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 176, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state123 = agent.new say();
					StringCreator string124 = new StringCreator();
					string124.append("This is brown.");
					state123.setText(string124.toString());
					if (!flowThread.callState(state123, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 179
					lookCaretaker state125 = new lookCaretaker();
					if (!flowThread.callState(state125, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 179, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 180
					tts.speak("Kahverengi kartı çevirip ayıya işaret edin.", 1.0f, false, false);
					// Line: 181
					iristk.flow.DialogFlow.wait waitState126 = new iristk.flow.DialogFlow.wait();
					waitState126.setMsec(3000);
					if (!flowThread.callState(waitState126, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 181, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state127 = agent.new say();
					StringCreator string128 = new StringCreator();
					string128.append("What is brown? Bear is brown. Bear is brown.");
					state127.setText(string128.toString());
					if (!flowThread.callState(state127, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 184
					lookChild state129 = new lookChild();
					if (!flowThread.callState(state129, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 184, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 185
					tts.speak("Mor renkli kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 186
					iristk.flow.DialogFlow.wait waitState130 = new iristk.flow.DialogFlow.wait();
					waitState130.setMsec(3000);
					if (!flowThread.callState(waitState130, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 186, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state131 = agent.new say();
					StringCreator string132 = new StringCreator();
					string132.append("This is purple.");
					state131.setText(string132.toString());
					if (!flowThread.callState(state131, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 189
					lookCaretaker state133 = new lookCaretaker();
					if (!flowThread.callState(state133, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 189, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 190
					tts.speak("Mor kartı çevirip patlıcana işaret edin.", 1.0f, false, false);
					// Line: 191
					iristk.flow.DialogFlow.wait waitState134 = new iristk.flow.DialogFlow.wait();
					waitState134.setMsec(3000);
					if (!flowThread.callState(waitState134, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 191, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state135 = agent.new say();
					StringCreator string136 = new StringCreator();
					string136.append("What is purple? Eggplant is purple. Eggplant is purple.");
					state135.setText(string136.toString());
					if (!flowThread.callState(state135, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 194
					lookChild state137 = new lookChild();
					if (!flowThread.callState(state137, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 194, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 195
					tts.speak("Beyaz kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 196
					iristk.flow.DialogFlow.wait waitState138 = new iristk.flow.DialogFlow.wait();
					waitState138.setMsec(3000);
					if (!flowThread.callState(waitState138, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 196, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state139 = agent.new say();
					StringCreator string140 = new StringCreator();
					string140.append("This is white.");
					state139.setText(string140.toString());
					if (!flowThread.callState(state139, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 199
					lookCaretaker state141 = new lookCaretaker();
					if (!flowThread.callState(state141, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 199, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 200
					tts.speak("Beyaz kartı çevirip kara işaret edin.", 1.0f, false, false);
					// Line: 201
					iristk.flow.DialogFlow.wait waitState142 = new iristk.flow.DialogFlow.wait();
					waitState142.setMsec(3000);
					if (!flowThread.callState(waitState142, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 201, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state143 = agent.new say();
					StringCreator string144 = new StringCreator();
					string144.append("What is white? Snow is white. Snow is white.");
					state143.setText(string144.toString());
					if (!flowThread.callState(state143, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 12));
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
			// Line: 207
			try {
				EXECUTION: {
					int count = getCount(607635164) + 1;
					incrCount(607635164);
					iristk.situated.SystemAgentFlow.say state145 = agent.new say();
					StringCreator string146 = new StringCreator();
					string146.append("Let's learn a song.");
					state145.setText(string146.toString());
					if (!flowThread.callState(state145, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 209
					iristk.flow.DialogFlow.wait waitState147 = new iristk.flow.DialogFlow.wait();
					waitState147.setMsec(3000);
					if (!flowThread.callState(waitState147, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 209, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 211
					lookCaretaker state148 = new lookCaretaker();
					if (!flowThread.callState(state148, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 211, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 212
					tts.speak("Ellerinizi çırpın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state149 = agent.new say();
					StringCreator string150 = new StringCreator();
					string150.append("Clap your hands.");
					state149.setText(string150.toString());
					if (!flowThread.callState(state149, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 214
					lookChild state151 = new lookChild();
					if (!flowThread.callState(state151, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 214, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 215
					iristk.flow.DialogFlow.wait waitState152 = new iristk.flow.DialogFlow.wait();
					waitState152.setMsec(3000);
					if (!flowThread.callState(waitState152, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 215, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 216
					tts.speak("Bebeğin ellerini çırpın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state153 = agent.new say();
					StringCreator string154 = new StringCreator();
					string154.append("Clap your hands.");
					state153.setText(string154.toString());
					if (!flowThread.callState(state153, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 218
					iristk.flow.DialogFlow.wait waitState155 = new iristk.flow.DialogFlow.wait();
					waitState155.setMsec(3000);
					if (!flowThread.callState(waitState155, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 218, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 220
					lookCaretaker state156 = new lookCaretaker();
					if (!flowThread.callState(state156, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 220, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 221
					tts.speak("Ellerinizi sallayın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state157 = agent.new say();
					StringCreator string158 = new StringCreator();
					string158.append("Wave hello.");
					state157.setText(string158.toString());
					if (!flowThread.callState(state157, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 223
					lookChild state159 = new lookChild();
					if (!flowThread.callState(state159, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 223, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 224
					iristk.flow.DialogFlow.wait waitState160 = new iristk.flow.DialogFlow.wait();
					waitState160.setMsec(3000);
					if (!flowThread.callState(waitState160, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 224, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 225
					tts.speak("Bebeğin ellerini sallayın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state161 = agent.new say();
					StringCreator string162 = new StringCreator();
					string162.append("Wave hello.");
					state161.setText(string162.toString());
					if (!flowThread.callState(state161, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 227
					iristk.flow.DialogFlow.wait waitState163 = new iristk.flow.DialogFlow.wait();
					waitState163.setMsec(3000);
					if (!flowThread.callState(waitState163, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 227, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 229
					lookCaretaker state164 = new lookCaretaker();
					if (!flowThread.callState(state164, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 229, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 230
					tts.speak("Ayağa kalkın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state165 = agent.new say();
					StringCreator string166 = new StringCreator();
					string166.append("Stand up.");
					state165.setText(string166.toString());
					if (!flowThread.callState(state165, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 232
					lookChild state167 = new lookChild();
					if (!flowThread.callState(state167, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 232, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 233
					iristk.flow.DialogFlow.wait waitState168 = new iristk.flow.DialogFlow.wait();
					waitState168.setMsec(3000);
					if (!flowThread.callState(waitState168, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 233, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 234
					tts.speak("Bebeği ayağa kaldırın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state169 = agent.new say();
					StringCreator string170 = new StringCreator();
					string170.append("Stand up.");
					state169.setText(string170.toString());
					if (!flowThread.callState(state169, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 236
					iristk.flow.DialogFlow.wait waitState171 = new iristk.flow.DialogFlow.wait();
					waitState171.setMsec(3000);
					if (!flowThread.callState(waitState171, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 236, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 238
					lookCaretaker state172 = new lookCaretaker();
					if (!flowThread.callState(state172, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 238, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 239
					tts.speak("Oturun.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state173 = agent.new say();
					StringCreator string174 = new StringCreator();
					string174.append("Sit down.");
					state173.setText(string174.toString());
					if (!flowThread.callState(state173, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 241
					lookChild state175 = new lookChild();
					if (!flowThread.callState(state175, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 241, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 242
					iristk.flow.DialogFlow.wait waitState176 = new iristk.flow.DialogFlow.wait();
					waitState176.setMsec(3000);
					if (!flowThread.callState(waitState176, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 242, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 243
					tts.speak("Bebeği oturtun.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state177 = agent.new say();
					StringCreator string178 = new StringCreator();
					string178.append("Sit down.");
					state177.setText(string178.toString());
					if (!flowThread.callState(state177, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 245
					iristk.flow.DialogFlow.wait waitState179 = new iristk.flow.DialogFlow.wait();
					waitState179.setMsec(3000);
					if (!flowThread.callState(waitState179, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 245, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 247
					lookCaretaker state180 = new lookCaretaker();
					if (!flowThread.callState(state180, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 247, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 248
					tts.speak("Ellerinizi yürür gibi hareket ettirin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state181 = agent.new say();
					StringCreator string182 = new StringCreator();
					string182.append("Let's go.");
					state181.setText(string182.toString());
					if (!flowThread.callState(state181, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 250
					lookChild state183 = new lookChild();
					if (!flowThread.callState(state183, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 250, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 251
					iristk.flow.DialogFlow.wait waitState184 = new iristk.flow.DialogFlow.wait();
					waitState184.setMsec(3000);
					if (!flowThread.callState(waitState184, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 251, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 252
					tts.speak("Bebeğin ellerini çırpın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state185 = agent.new say();
					StringCreator string186 = new StringCreator();
					string186.append("Let's go.");
					state185.setText(string186.toString());
					if (!flowThread.callState(state185, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 254
					iristk.flow.DialogFlow.wait waitState187 = new iristk.flow.DialogFlow.wait();
					waitState187.setMsec(3000);
					if (!flowThread.callState(waitState187, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 254, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state188 = agent.new say();
					StringCreator string189 = new StringCreator();
					string189.append("That was fun! Great job!");
					state188.setText(string189.toString());
					if (!flowThread.callState(state188, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 207, 12));
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
			// Line: 263
			try {
				EXECUTION: {
					int count = getCount(1476011703) + 1;
					incrCount(1476011703);
					iristk.situated.SystemAgentFlow.say state190 = agent.new say();
					StringCreator string191 = new StringCreator();
					string191.append("Let's start learning. What do you want to learn about?");
					state190.setText(string191.toString());
					if (!flowThread.callState(state190, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 263, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state192 = agent.new listen();
					if (!flowThread.callState(state192, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 263, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 263, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 267
			try {
				count = getCount(1603195447) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(1603195447);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 268
							tts.speak("Renk kartlarının olduğu desteyi alınız.", 1.0f, false, false);
							// Line: 269
							iristk.flow.DialogFlow.wait waitState193 = new iristk.flow.DialogFlow.wait();
							waitState193.setMsec(3000);
							if (!flowThread.callState(waitState193, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 269, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state194 = agent.new say();
							StringCreator string195 = new StringCreator();
							string195.append("Okay, let's learn about colors.");
							state194.setText(string195.toString());
							if (!flowThread.callState(state194, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 267, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 271
							LearnColors state196 = new LearnColors();
							flowThread.gotoState(state196, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 271, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 267, 60));
			}
			// Line: 273
			try {
				count = getCount(1761061602) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(1761061602);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 274
							tts.speak("Hayvan kartlarının olduğu desteyi alınız.", 1.0f, false, false);
							iristk.situated.SystemAgentFlow.say state197 = agent.new say();
							StringCreator string198 = new StringCreator();
							string198.append("Okay, let's learn about animals.");
							state197.setText(string198.toString());
							if (!flowThread.callState(state197, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 273, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 276
							LearnAnimals state199 = new LearnAnimals();
							flowThread.gotoState(state199, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 276, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 273, 61));
			}
			// Line: 278
			try {
				count = getCount(59559151) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:body")) {
						incrCount(59559151);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state200 = agent.new say();
							StringCreator string201 = new StringCreator();
							string201.append("Okay, let's learn about body parts.");
							state200.setText(string201.toString());
							if (!flowThread.callState(state200, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 278, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 280
							LearnBody state202 = new LearnBody();
							flowThread.gotoState(state202, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 280, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 278, 59));
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
			// Line: 287
			try {
				EXECUTION: {
					int count = getCount(434176574) + 1;
					incrCount(434176574);
					iristk.situated.SystemAgentFlow.say state203 = agent.new say();
					StringCreator string204 = new StringCreator();
					string204.append("Let's learn about our heads, shoulders, knees and toes.");
					state203.setText(string204.toString());
					if (!flowThread.callState(state203, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 291
					lookCaretaker state205 = new lookCaretaker();
					if (!flowThread.callState(state205, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 291, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 292
					lookChild state206 = new lookChild();
					if (!flowThread.callState(state206, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 292, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 293
					tts.speak("Kafanıza, sonra çoçuğun kafasına yavaşça dokunun.", 1.0f, false, false);
					// Line: 294
					iristk.flow.DialogFlow.wait waitState207 = new iristk.flow.DialogFlow.wait();
					waitState207.setMsec(3000);
					if (!flowThread.callState(waitState207, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 294, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state208 = agent.new say();
					StringCreator string209 = new StringCreator();
					string209.append("This is your head.");
					state208.setText(string209.toString());
					if (!flowThread.callState(state208, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 297
					tts.speak("Omuzlariniza, sonra bebegin omuzlarina dokunun.", 1.0f, false, false);
					// Line: 298
					iristk.flow.DialogFlow.wait waitState210 = new iristk.flow.DialogFlow.wait();
					waitState210.setMsec(3000);
					if (!flowThread.callState(waitState210, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 298, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state211 = agent.new say();
					StringCreator string212 = new StringCreator();
					string212.append("These are your shoulders.");
					state211.setText(string212.toString());
					if (!flowThread.callState(state211, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 301
					tts.speak("Dizlerinize, daha sonra bebegin dizlerine dokunun.", 1.0f, false, false);
					// Line: 302
					iristk.flow.DialogFlow.wait waitState213 = new iristk.flow.DialogFlow.wait();
					waitState213.setMsec(3000);
					if (!flowThread.callState(waitState213, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 302, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state214 = agent.new say();
					StringCreator string215 = new StringCreator();
					string215.append("These are your knees.");
					state214.setText(string215.toString());
					if (!flowThread.callState(state214, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 305
					tts.speak("Ayaklariniza, daha sonra bebegin ayaklarina dokunun.", 1.0f, false, false);
					// Line: 306
					iristk.flow.DialogFlow.wait waitState216 = new iristk.flow.DialogFlow.wait();
					waitState216.setMsec(3000);
					if (!flowThread.callState(waitState216, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 306, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state217 = agent.new say();
					StringCreator string218 = new StringCreator();
					string218.append("These are your toes.");
					state217.setText(string218.toString());
					if (!flowThread.callState(state217, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 309
					tts.speak("Gozlerinizi, daha sonra bebegin gozlerini isaret edin.", 1.0f, false, false);
					// Line: 310
					iristk.flow.DialogFlow.wait waitState219 = new iristk.flow.DialogFlow.wait();
					waitState219.setMsec(3000);
					if (!flowThread.callState(waitState219, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 310, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state220 = agent.new say();
					StringCreator string221 = new StringCreator();
					string221.append("These are your eyes.");
					state220.setText(string221.toString());
					if (!flowThread.callState(state220, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 312
					tts.speak("Iki parmaginizi gosterin.", 1.0f, false, false);
					// Line: 313
					iristk.flow.DialogFlow.wait waitState222 = new iristk.flow.DialogFlow.wait();
					waitState222.setMsec(2000);
					if (!flowThread.callState(waitState222, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 313, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state223 = agent.new say();
					StringCreator string224 = new StringCreator();
					string224.append("We have two eyes. Two eyes.");
					state223.setText(string224.toString());
					if (!flowThread.callState(state223, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 316
					tts.speak("Kulaklariniza, daha sonra bebegin kulaklarina dokunun.", 1.0f, false, false);
					// Line: 317
					iristk.flow.DialogFlow.wait waitState225 = new iristk.flow.DialogFlow.wait();
					waitState225.setMsec(3000);
					if (!flowThread.callState(waitState225, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 317, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state226 = agent.new say();
					StringCreator string227 = new StringCreator();
					string227.append("These are your ears.");
					state226.setText(string227.toString());
					if (!flowThread.callState(state226, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 319
					tts.speak("Iki parmaginizi gosterin.", 1.0f, false, false);
					// Line: 320
					iristk.flow.DialogFlow.wait waitState228 = new iristk.flow.DialogFlow.wait();
					waitState228.setMsec(2000);
					if (!flowThread.callState(waitState228, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 320, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state229 = agent.new say();
					StringCreator string230 = new StringCreator();
					string230.append("We have two ears. Two ears.");
					state229.setText(string230.toString());
					if (!flowThread.callState(state229, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 323
					tts.speak("Bebege opucuk atin ve agizinizi gosterin.", 1.0f, false, false);
					// Line: 324
					iristk.flow.DialogFlow.wait waitState231 = new iristk.flow.DialogFlow.wait();
					waitState231.setMsec(3000);
					if (!flowThread.callState(waitState231, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 324, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state232 = agent.new say();
					StringCreator string233 = new StringCreator();
					string233.append("This is your mouth.");
					state232.setText(string233.toString());
					if (!flowThread.callState(state232, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 326
					tts.speak("Bir parmaginizi kaldirin.", 1.0f, false, false);
					// Line: 327
					iristk.flow.DialogFlow.wait waitState234 = new iristk.flow.DialogFlow.wait();
					waitState234.setMsec(2000);
					if (!flowThread.callState(waitState234, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 327, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state235 = agent.new say();
					StringCreator string236 = new StringCreator();
					string236.append("We have one mouth. One mouth.");
					state235.setText(string236.toString());
					if (!flowThread.callState(state235, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 330
					tts.speak("Burnunuza, sonra bebegin burnuna dokunun.", 1.0f, false, false);
					// Line: 331
					iristk.flow.DialogFlow.wait waitState237 = new iristk.flow.DialogFlow.wait();
					waitState237.setMsec(4000);
					if (!flowThread.callState(waitState237, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 331, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state238 = agent.new say();
					StringCreator string239 = new StringCreator();
					string239.append("This is your nose.");
					state238.setText(string239.toString());
					if (!flowThread.callState(state238, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 333
					tts.speak("Bir parmaginizi kaldirin.", 1.0f, false, false);
					// Line: 334
					iristk.flow.DialogFlow.wait waitState240 = new iristk.flow.DialogFlow.wait();
					waitState240.setMsec(2000);
					if (!flowThread.callState(waitState240, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 334, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state241 = agent.new say();
					StringCreator string242 = new StringCreator();
					string242.append("We have one nose. One nose.");
					state241.setText(string242.toString());
					if (!flowThread.callState(state241, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 337
					tts.speak("Iki elinizi bebege dogru sallayin.", 1.0f, false, false);
					// Line: 338
					iristk.flow.DialogFlow.wait waitState243 = new iristk.flow.DialogFlow.wait();
					waitState243.setMsec(4000);
					if (!flowThread.callState(waitState243, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 338, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state244 = agent.new say();
					StringCreator string245 = new StringCreator();
					string245.append("These are our hands.");
					state244.setText(string245.toString());
					if (!flowThread.callState(state244, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 340
					tts.speak("Iki elinizi gosterin.", 1.0f, false, false);
					// Line: 341
					iristk.flow.DialogFlow.wait waitState246 = new iristk.flow.DialogFlow.wait();
					waitState246.setMsec(2000);
					if (!flowThread.callState(waitState246, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 341, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state247 = agent.new say();
					StringCreator string248 = new StringCreator();
					string248.append("We have two hands. Two hands.");
					state247.setText(string248.toString());
					if (!flowThread.callState(state247, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 344
					tts.speak("Parmaklarinizi bebegin onunde hareket ettirin.", 1.0f, false, false);
					// Line: 345
					iristk.flow.DialogFlow.wait waitState249 = new iristk.flow.DialogFlow.wait();
					waitState249.setMsec(4000);
					if (!flowThread.callState(waitState249, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 345, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state250 = agent.new say();
					StringCreator string251 = new StringCreator();
					string251.append("These are our fingers.");
					state250.setText(string251.toString());
					if (!flowThread.callState(state250, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 347
					tts.speak("On parmaginizi gosterin.", 1.0f, false, false);
					// Line: 348
					iristk.flow.DialogFlow.wait waitState252 = new iristk.flow.DialogFlow.wait();
					waitState252.setMsec(2000);
					if (!flowThread.callState(waitState252, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 348, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state253 = agent.new say();
					StringCreator string254 = new StringCreator();
					string254.append("We have ten fingers. Ten fingers.");
					state253.setText(string254.toString());
					if (!flowThread.callState(state253, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state255 = agent.new say();
					StringCreator string256 = new StringCreator();
					string256.append("That was fun. Now, let's listen to the song again.");
					state255.setText(string256.toString());
					if (!flowThread.callState(state255, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 287, 12));
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
			// Line: 359
			try {
				EXECUTION: {
					int count = getCount(1359044626) + 1;
					incrCount(1359044626);
					// Line: 360
					lookChild state257 = new lookChild();
					if (!flowThread.callState(state257, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 360, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 361
					tts.speak("Kopek kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 362
					iristk.flow.DialogFlow.wait waitState258 = new iristk.flow.DialogFlow.wait();
					waitState258.setMsec(3000);
					if (!flowThread.callState(waitState258, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 362, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state259 = agent.new say();
					StringCreator string260 = new StringCreator();
					string260.append("This is a dog. The dog says woof.");
					state259.setText(string260.toString());
					if (!flowThread.callState(state259, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 364
					lookCaretaker state261 = new lookCaretaker();
					if (!flowThread.callState(state261, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 364, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 365
					tts.speak("WUF WUF diyin bir kac kez ve sonraki sesle birlikte 4 parmak gosterin.", 1.0f, false, false);
					// Line: 366
					iristk.flow.DialogFlow.wait waitState262 = new iristk.flow.DialogFlow.wait();
					waitState262.setMsec(3000);
					if (!flowThread.callState(waitState262, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 366, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state263 = agent.new say();
					StringCreator string264 = new StringCreator();
					string264.append("The dog has 4 legs.");
					state263.setText(string264.toString());
					if (!flowThread.callState(state263, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 369
					lookChild state265 = new lookChild();
					if (!flowThread.callState(state265, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 369, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 370
					tts.speak("Kedi kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 371
					iristk.flow.DialogFlow.wait waitState266 = new iristk.flow.DialogFlow.wait();
					waitState266.setMsec(3000);
					if (!flowThread.callState(waitState266, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 371, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state267 = agent.new say();
					StringCreator string268 = new StringCreator();
					string268.append("This is a cat. The cat says meow.");
					state267.setText(string268.toString());
					if (!flowThread.callState(state267, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 373
					lookCaretaker state269 = new lookCaretaker();
					if (!flowThread.callState(state269, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 373, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 374
					tts.speak("MIAV MIAV diyin bir kac kez ve sonra elinizle 4 parmak gosterin.", 1.0f, false, false);
					// Line: 375
					iristk.flow.DialogFlow.wait waitState270 = new iristk.flow.DialogFlow.wait();
					waitState270.setMsec(3000);
					if (!flowThread.callState(waitState270, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 375, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state271 = agent.new say();
					StringCreator string272 = new StringCreator();
					string272.append("The cat also has 4 legs like dog.");
					state271.setText(string272.toString());
					if (!flowThread.callState(state271, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 378
					lookChild state273 = new lookChild();
					if (!flowThread.callState(state273, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 378, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 379
					tts.speak("Balik kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 380
					iristk.flow.DialogFlow.wait waitState274 = new iristk.flow.DialogFlow.wait();
					waitState274.setMsec(3000);
					if (!flowThread.callState(waitState274, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 380, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state275 = agent.new say();
					StringCreator string276 = new StringCreator();
					string276.append("This is a fish. The fish lives under the sea and swims.");
					state275.setText(string276.toString());
					if (!flowThread.callState(state275, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 382
					lookCaretaker state277 = new lookCaretaker();
					if (!flowThread.callState(state277, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 382, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 383
					tts.speak("Ellerinizi birlestirip balik gibi saga sola sallayin.", 1.0f, false, false);
					// Line: 384
					iristk.flow.DialogFlow.wait waitState278 = new iristk.flow.DialogFlow.wait();
					waitState278.setMsec(3000);
					if (!flowThread.callState(waitState278, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 384, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state279 = agent.new say();
					StringCreator string280 = new StringCreator();
					string280.append("The fish have fins and a tail.");
					state279.setText(string280.toString());
					if (!flowThread.callState(state279, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 387
					lookChild state281 = new lookChild();
					if (!flowThread.callState(state281, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 387, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 388
					tts.speak("Kus kartini gosterin.", 1.0f, false, false);
					// Line: 389
					iristk.flow.DialogFlow.wait waitState282 = new iristk.flow.DialogFlow.wait();
					waitState282.setMsec(3000);
					if (!flowThread.callState(waitState282, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 389, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state283 = agent.new say();
					StringCreator string284 = new StringCreator();
					string284.append("This is a bird. The bird flies in the sky.");
					state283.setText(string284.toString());
					if (!flowThread.callState(state283, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 391
					lookCaretaker state285 = new lookCaretaker();
					if (!flowThread.callState(state285, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 391, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 392
					tts.speak("Ucan kus gibi kollarinizi cirpin ve FILAY diyin bir kac kez.", 1.0f, false, false);
					// Line: 393
					iristk.flow.DialogFlow.wait waitState286 = new iristk.flow.DialogFlow.wait();
					waitState286.setMsec(3000);
					if (!flowThread.callState(waitState286, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 393, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state287 = agent.new say();
					StringCreator string288 = new StringCreator();
					string288.append("The bird lays eggs in its nest.");
					state287.setText(string288.toString());
					if (!flowThread.callState(state287, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 396
					lookChild state289 = new lookChild();
					if (!flowThread.callState(state289, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 396, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 397
					tts.speak("Ordek kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 398
					iristk.flow.DialogFlow.wait waitState290 = new iristk.flow.DialogFlow.wait();
					waitState290.setMsec(3000);
					if (!flowThread.callState(waitState290, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 398, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state291 = agent.new say();
					StringCreator string292 = new StringCreator();
					string292.append("This is a duck. The duck says quack.");
					state291.setText(string292.toString());
					if (!flowThread.callState(state291, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 400
					lookCaretaker state293 = new lookCaretaker();
					if (!flowThread.callState(state293, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 400, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 401
					tts.speak("VAK VAK diyin bir kac", 1.0f, false, false);
					// Line: 402
					iristk.flow.DialogFlow.wait waitState294 = new iristk.flow.DialogFlow.wait();
					waitState294.setMsec(3000);
					if (!flowThread.callState(waitState294, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 402, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state295 = agent.new say();
					StringCreator string296 = new StringCreator();
					string296.append("The duck can swim.");
					state295.setText(string296.toString());
					if (!flowThread.callState(state295, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 405
					lookChild state297 = new lookChild();
					if (!flowThread.callState(state297, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 405, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 406
					tts.speak("Kurbaga kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 407
					iristk.flow.DialogFlow.wait waitState298 = new iristk.flow.DialogFlow.wait();
					waitState298.setMsec(3000);
					if (!flowThread.callState(waitState298, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 407, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state299 = agent.new say();
					StringCreator string300 = new StringCreator();
					string300.append("This is a frog. The frog has a very long tongue.");
					state299.setText(string300.toString());
					if (!flowThread.callState(state299, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 409
					lookCaretaker state301 = new lookCaretaker();
					if (!flowThread.callState(state301, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 409, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 410
					tts.speak("Dilinizi cikartin kisa bir sure.", 1.0f, false, false);
					// Line: 411
					iristk.flow.DialogFlow.wait waitState302 = new iristk.flow.DialogFlow.wait();
					waitState302.setMsec(3000);
					if (!flowThread.callState(waitState302, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 411, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state303 = agent.new say();
					StringCreator string304 = new StringCreator();
					string304.append("The frog lives in both water and land.");
					state303.setText(string304.toString());
					if (!flowThread.callState(state303, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 414
					lookChild state305 = new lookChild();
					if (!flowThread.callState(state305, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 414, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 415
					tts.speak("At kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 416
					iristk.flow.DialogFlow.wait waitState306 = new iristk.flow.DialogFlow.wait();
					waitState306.setMsec(3000);
					if (!flowThread.callState(waitState306, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 416, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state307 = agent.new say();
					StringCreator string308 = new StringCreator();
					string308.append("This is a horse. The horse can run very fast.");
					state307.setText(string308.toString());
					if (!flowThread.callState(state307, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 419
					tts.speak("Ayi kartini gosterin ve sallayin.", 1.0f, false, false);
					// Line: 420
					iristk.flow.DialogFlow.wait waitState309 = new iristk.flow.DialogFlow.wait();
					waitState309.setMsec(3000);
					if (!flowThread.callState(waitState309, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 420, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state310 = agent.new say();
					StringCreator string311 = new StringCreator();
					string311.append("This is a bear. The bear is very big.");
					state310.setText(string311.toString());
					if (!flowThread.callState(state310, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 422
					lookCaretaker state312 = new lookCaretaker();
					if (!flowThread.callState(state312, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 422, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 423
					tts.speak("Ellerinizi pence yapip, havaya kaldirin ve BIG BEIR diyin.", 1.0f, false, false);
					// Line: 424
					iristk.flow.DialogFlow.wait waitState313 = new iristk.flow.DialogFlow.wait();
					waitState313.setMsec(3000);
					if (!flowThread.callState(waitState313, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 424, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 426
					lookChild state314 = new lookChild();
					if (!flowThread.callState(state314, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 426, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state315 = agent.new say();
					StringCreator string316 = new StringCreator();
					string316.append("Now you know your animals.");
					state315.setText(string316.toString());
					if (!flowThread.callState(state315, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 428
					CheckAgain state317 = new CheckAgain();
					flowThread.gotoState(state317, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 428, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 359, 12));
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
			// Line: 435
			try {
				EXECUTION: {
					int count = getCount(736709391) + 1;
					incrCount(736709391);
					// Line: 436
					lookChild state318 = new lookChild();
					if (!flowThread.callState(state318, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 436, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 437
					tts.speak("Kirmizi renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 438
					iristk.flow.DialogFlow.wait waitState319 = new iristk.flow.DialogFlow.wait();
					waitState319.setMsec(3000);
					if (!flowThread.callState(waitState319, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 438, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state320 = agent.new say();
					StringCreator string321 = new StringCreator();
					string321.append("This is red.");
					state320.setText(string321.toString());
					if (!flowThread.callState(state320, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 441
					lookCaretaker state322 = new lookCaretaker();
					if (!flowThread.callState(state322, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 441, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 442
					tts.speak("Kirmizi karti cevirip sirayla itfaiye araci, trafik levhasi ve elma resimlerine isaret edin.", 1.0f, false, false);
					// Line: 443
					iristk.flow.DialogFlow.wait waitState323 = new iristk.flow.DialogFlow.wait();
					waitState323.setMsec(3000);
					if (!flowThread.callState(waitState323, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 443, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state324 = agent.new say();
					StringCreator string325 = new StringCreator();
					string325.append("The firetruck, the stop sign and the apple are all red. Red");
					state324.setText(string325.toString());
					if (!flowThread.callState(state324, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 446
					lookChild state326 = new lookChild();
					if (!flowThread.callState(state326, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 446, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 447
					tts.speak("Mavi renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 448
					iristk.flow.DialogFlow.wait waitState327 = new iristk.flow.DialogFlow.wait();
					waitState327.setMsec(3000);
					if (!flowThread.callState(waitState327, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 448, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state328 = agent.new say();
					StringCreator string329 = new StringCreator();
					string329.append("This is blue.");
					state328.setText(string329.toString());
					if (!flowThread.callState(state328, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 451
					lookCaretaker state330 = new lookCaretaker();
					if (!flowThread.callState(state330, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 451, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 452
					tts.speak("Mavi karti cevirip sirayla deniz, gokyuzu ve kelebek resimlerine isaret edin.", 1.0f, false, false);
					// Line: 453
					iristk.flow.DialogFlow.wait waitState331 = new iristk.flow.DialogFlow.wait();
					waitState331.setMsec(3000);
					if (!flowThread.callState(waitState331, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 453, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state332 = agent.new say();
					StringCreator string333 = new StringCreator();
					string333.append("The sea, the sky and the butterfly are all blue. Blue");
					state332.setText(string333.toString());
					if (!flowThread.callState(state332, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 456
					lookChild state334 = new lookChild();
					if (!flowThread.callState(state334, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 456, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 457
					tts.speak("Yesil renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 458
					iristk.flow.DialogFlow.wait waitState335 = new iristk.flow.DialogFlow.wait();
					waitState335.setMsec(3000);
					if (!flowThread.callState(waitState335, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 458, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state336 = agent.new say();
					StringCreator string337 = new StringCreator();
					string337.append("This is green.");
					state336.setText(string337.toString());
					if (!flowThread.callState(state336, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 461
					lookCaretaker state338 = new lookCaretaker();
					if (!flowThread.callState(state338, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 461, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 462
					tts.speak("Yesil karti cevirip sirayla cimen, agac ve armut resimlerine isaret edin.", 1.0f, false, false);
					// Line: 463
					iristk.flow.DialogFlow.wait waitState339 = new iristk.flow.DialogFlow.wait();
					waitState339.setMsec(3000);
					if (!flowThread.callState(waitState339, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 463, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state340 = agent.new say();
					StringCreator string341 = new StringCreator();
					string341.append("The grass, the tree and the pear are all green. Green");
					state340.setText(string341.toString());
					if (!flowThread.callState(state340, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 466
					lookChild state342 = new lookChild();
					if (!flowThread.callState(state342, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 466, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 467
					tts.speak("Sari renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 468
					iristk.flow.DialogFlow.wait waitState343 = new iristk.flow.DialogFlow.wait();
					waitState343.setMsec(3000);
					if (!flowThread.callState(waitState343, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 468, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state344 = agent.new say();
					StringCreator string345 = new StringCreator();
					string345.append("This is yellow.");
					state344.setText(string345.toString());
					if (!flowThread.callState(state344, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 471
					lookCaretaker state346 = new lookCaretaker();
					if (!flowThread.callState(state346, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 471, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 472
					tts.speak("Sari karti cevirip sirayla limon, ordek ve muz resimlerine isaret edin.", 1.0f, false, false);
					// Line: 473
					iristk.flow.DialogFlow.wait waitState347 = new iristk.flow.DialogFlow.wait();
					waitState347.setMsec(3000);
					if (!flowThread.callState(waitState347, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 473, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state348 = agent.new say();
					StringCreator string349 = new StringCreator();
					string349.append("The lemon, the duck and the banana are all yellow. Yellow");
					state348.setText(string349.toString());
					if (!flowThread.callState(state348, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 476
					lookChild state350 = new lookChild();
					if (!flowThread.callState(state350, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 476, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 477
					tts.speak("Turuncu renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 478
					iristk.flow.DialogFlow.wait waitState351 = new iristk.flow.DialogFlow.wait();
					waitState351.setMsec(3000);
					if (!flowThread.callState(waitState351, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 478, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state352 = agent.new say();
					StringCreator string353 = new StringCreator();
					string353.append("This is orange.");
					state352.setText(string353.toString());
					if (!flowThread.callState(state352, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 481
					lookCaretaker state354 = new lookCaretaker();
					if (!flowThread.callState(state354, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 481, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 482
					tts.speak("Turunucu karti cevirip sirayla portakal, havuc ve top resimlerine isaret edin.", 1.0f, false, false);
					// Line: 483
					iristk.flow.DialogFlow.wait waitState355 = new iristk.flow.DialogFlow.wait();
					waitState355.setMsec(3000);
					if (!flowThread.callState(waitState355, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 483, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state356 = agent.new say();
					StringCreator string357 = new StringCreator();
					string357.append("The orange, the carrot and the basketball are all orange. Orange");
					state356.setText(string357.toString());
					if (!flowThread.callState(state356, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 486
					lookChild state358 = new lookChild();
					if (!flowThread.callState(state358, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 486, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 487
					tts.speak("Mor renkli karti gosterin ve sallayin.", 1.0f, false, false);
					// Line: 488
					iristk.flow.DialogFlow.wait waitState359 = new iristk.flow.DialogFlow.wait();
					waitState359.setMsec(3000);
					if (!flowThread.callState(waitState359, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 488, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state360 = agent.new say();
					StringCreator string361 = new StringCreator();
					string361.append("This is purple.");
					state360.setText(string361.toString());
					if (!flowThread.callState(state360, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 491
					lookCaretaker state362 = new lookCaretaker();
					if (!flowThread.callState(state362, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 491, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 492
					tts.speak("Mor karti cevirip sirayla uzum, patlican ve bot resimlerine isaret edin.", 1.0f, false, false);
					// Line: 493
					iristk.flow.DialogFlow.wait waitState363 = new iristk.flow.DialogFlow.wait();
					waitState363.setMsec(3000);
					if (!flowThread.callState(waitState363, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 493, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state364 = agent.new say();
					StringCreator string365 = new StringCreator();
					string365.append("The grapes, the eggplant and the boots are all purple. Purple");
					state364.setText(string365.toString());
					if (!flowThread.callState(state364, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 496
					iristk.flow.DialogFlow.wait waitState366 = new iristk.flow.DialogFlow.wait();
					waitState366.setMsec(2000);
					if (!flowThread.callState(waitState366, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 496, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state367 = agent.new say();
					StringCreator string368 = new StringCreator();
					string368.append("Now you know your colors.");
					state367.setText(string368.toString());
					if (!flowThread.callState(state367, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 498
					CheckAgain state369 = new CheckAgain();
					flowThread.gotoState(state369, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 498, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 435, 12));
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
			// Line: 508
			try {
				EXECUTION: {
					int count = getCount(1711574013) + 1;
					incrCount(1711574013);
					// Line: 509
					lookChild state370 = new lookChild();
					if (!flowThread.callState(state370, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 509, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 510
					audioplayer.playSound("audio/PlaySubject.wav");
					iristk.situated.SystemAgentFlow.say state371 = agent.new say();
					StringCreator string372 = new StringCreator();
					string372.append("Let's have some fun. Which subject would you like to play with?");
					state371.setText(string372.toString());
					if (!flowThread.callState(state371, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 508, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state373 = agent.new listen();
					if (!flowThread.callState(state373, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 508, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 508, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 515
			try {
				count = getCount(1638215613) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(1638215613);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 516
							PlayAnimals state374 = new PlayAnimals();
							flowThread.gotoState(state374, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 516, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 515, 61));
			}
			// Line: 518
			try {
				count = getCount(1674896058) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(1674896058);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 519
							PlayColors state375 = new PlayColors();
							flowThread.gotoState(state375, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 519, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 518, 60));
			}
			// Line: 521
			try {
				count = getCount(866191240) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:object")) {
						incrCount(866191240);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 522
							PlayObjects state376 = new PlayObjects();
							flowThread.gotoState(state376, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 522, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 521, 61));
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
			// Line: 527
			try {
				EXECUTION: {
					int count = getCount(1207769059) + 1;
					incrCount(1207769059);
					iristk.situated.SystemAgentFlow.say state377 = agent.new say();
					StringCreator string378 = new StringCreator();
					string378.append("Let's see if you have learned your colors.");
					state377.setText(string378.toString());
					if (!flowThread.callState(state377, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 529
					iristk.flow.DialogFlow.wait waitState379 = new iristk.flow.DialogFlow.wait();
					waitState379.setMsec(3000);
					if (!flowThread.callState(waitState379, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 529, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 530
					lookCaretaker state380 = new lookCaretaker();
					if (!flowThread.callState(state380, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 530, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 531
					PlayPrepare state381 = new PlayPrepare();
					if (!flowThread.callState(state381, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 531, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state382 = agent.new say();
					StringCreator string383 = new StringCreator();
					string383.append("Let's start the game.");
					state382.setText(string383.toString());
					if (!flowThread.callState(state382, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 534
					tts.speak("Oyuna başlıyoruz.", 1.0f, false, false);
					// Line: 536
					lookChild state384 = new lookChild();
					if (!flowThread.callState(state384, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 536, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state385 = agent.new say();
					StringCreator string386 = new StringCreator();
					string386.append("Can you show me the color red?");
					state385.setText(string386.toString());
					if (!flowThread.callState(state385, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 538
					tts.speak("Cocuğa kırmızı rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 539
					lookBoard state387 = new lookBoard();
					if (!flowThread.callState(state387, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 539, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 540
					iristk.flow.DialogFlow.wait waitState388 = new iristk.flow.DialogFlow.wait();
					waitState388.setMsec(4000);
					if (!flowThread.callState(waitState388, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 540, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 541
					Showing state389 = new Showing();
					if (!flowThread.callState(state389, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 541, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 543
					lookChild state390 = new lookChild();
					if (!flowThread.callState(state390, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 543, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state391 = agent.new say();
					StringCreator string392 = new StringCreator();
					string392.append("Can you show me the color purple?");
					state391.setText(string392.toString());
					if (!flowThread.callState(state391, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 545
					tts.speak("Cocuğa mor rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 546
					lookBoard state393 = new lookBoard();
					if (!flowThread.callState(state393, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 546, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 547
					iristk.flow.DialogFlow.wait waitState394 = new iristk.flow.DialogFlow.wait();
					waitState394.setMsec(4000);
					if (!flowThread.callState(waitState394, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 547, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 548
					Showing state395 = new Showing();
					if (!flowThread.callState(state395, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 548, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 550
					lookChild state396 = new lookChild();
					if (!flowThread.callState(state396, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 550, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state397 = agent.new say();
					StringCreator string398 = new StringCreator();
					string398.append("Can you first show me the color orange then yellow?");
					state397.setText(string398.toString());
					if (!flowThread.callState(state397, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 552
					tts.speak("Cocuğa önce turuncu sonra sari rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 553
					lookBoard state399 = new lookBoard();
					if (!flowThread.callState(state399, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 553, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 554
					iristk.flow.DialogFlow.wait waitState400 = new iristk.flow.DialogFlow.wait();
					waitState400.setMsec(4000);
					if (!flowThread.callState(waitState400, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 554, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 555
					Showing state401 = new Showing();
					if (!flowThread.callState(state401, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 555, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 557
					lookChild state402 = new lookChild();
					if (!flowThread.callState(state402, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 557, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state403 = agent.new say();
					StringCreator string404 = new StringCreator();
					string404.append("Can you show me the color of grass?");
					state403.setText(string404.toString());
					if (!flowThread.callState(state403, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 559
					tts.speak("Cocuğa yeşil rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 560
					lookBoard state405 = new lookBoard();
					if (!flowThread.callState(state405, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 560, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 561
					iristk.flow.DialogFlow.wait waitState406 = new iristk.flow.DialogFlow.wait();
					waitState406.setMsec(4000);
					if (!flowThread.callState(waitState406, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 561, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 562
					Showing state407 = new Showing();
					if (!flowThread.callState(state407, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 562, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 564
					lookChild state408 = new lookChild();
					if (!flowThread.callState(state408, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 564, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state409 = agent.new say();
					StringCreator string410 = new StringCreator();
					string410.append("Can you show me the color of firetruck?");
					state409.setText(string410.toString());
					if (!flowThread.callState(state409, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 566
					tts.speak("Cocuğa kırmızı rengini göstermesini istedim.", 1.0f, false, false);
					// Line: 567
					lookBoard state411 = new lookBoard();
					if (!flowThread.callState(state411, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 567, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 568
					iristk.flow.DialogFlow.wait waitState412 = new iristk.flow.DialogFlow.wait();
					waitState412.setMsec(4000);
					if (!flowThread.callState(waitState412, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 568, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 569
					Showing state413 = new Showing();
					if (!flowThread.callState(state413, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 569, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 571
					CheckAgain state414 = new CheckAgain();
					flowThread.gotoState(state414, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 571, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 527, 12));
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
			// Line: 577
			try {
				EXECUTION: {
					int count = getCount(1321640594) + 1;
					incrCount(1321640594);
					iristk.situated.SystemAgentFlow.say state415 = agent.new say();
					StringCreator string416 = new StringCreator();
					string416.append("Great choice. I love animals.");
					state415.setText(string416.toString());
					if (!flowThread.callState(state415, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 577, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 579
					iristk.flow.DialogFlow.wait waitState417 = new iristk.flow.DialogFlow.wait();
					waitState417.setMsec(3000);
					if (!flowThread.callState(waitState417, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 579, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 580
					lookCaretaker state418 = new lookCaretaker();
					if (!flowThread.callState(state418, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 580, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 581
					PlayPrepare state419 = new PlayPrepare();
					if (!flowThread.callState(state419, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 581, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 583
					audioplayer.playSound("audio/PlayAnimalStart.wav");
					iristk.situated.SystemAgentFlow.say state420 = agent.new say();
					StringCreator string421 = new StringCreator();
					string421.append("Let's start the game.");
					state420.setText(string421.toString());
					if (!flowThread.callState(state420, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 577, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 586
					lookChild state422 = new lookChild();
					if (!flowThread.callState(state422, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 586, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 587
					audioplayer.playSound("audio/PlayAnimalDog.wav");
					iristk.situated.SystemAgentFlow.say state423 = agent.new say();
					StringCreator string424 = new StringCreator();
					string424.append("Can you show me the dog on the board?");
					state423.setText(string424.toString());
					if (!flowThread.callState(state423, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 577, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 589
					lookBoard state425 = new lookBoard();
					if (!flowThread.callState(state425, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 589, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 590
					iristk.flow.DialogFlow.wait waitState426 = new iristk.flow.DialogFlow.wait();
					waitState426.setMsec(4000);
					if (!flowThread.callState(waitState426, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 590, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 591
					Showing state427 = new Showing();
					if (!flowThread.callState(state427, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 591, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 593
					lookChild state428 = new lookChild();
					if (!flowThread.callState(state428, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 593, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 594
					audioplayer.playSound("audio/PlayAnimalFish.wav");
					iristk.situated.SystemAgentFlow.say state429 = agent.new say();
					StringCreator string430 = new StringCreator();
					string430.append("Can you show me the fish on the board?");
					state429.setText(string430.toString());
					if (!flowThread.callState(state429, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 577, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 596
					lookBoard state431 = new lookBoard();
					if (!flowThread.callState(state431, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 596, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 597
					iristk.flow.DialogFlow.wait waitState432 = new iristk.flow.DialogFlow.wait();
					waitState432.setMsec(4000);
					if (!flowThread.callState(waitState432, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 597, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 598
					Showing state433 = new Showing();
					if (!flowThread.callState(state433, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 598, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 600
					lookChild state434 = new lookChild();
					if (!flowThread.callState(state434, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 600, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 601
					audioplayer.playSound("audio/PlayAnimalBird.wav");
					iristk.situated.SystemAgentFlow.say state435 = agent.new say();
					StringCreator string436 = new StringCreator();
					string436.append("Can you show me the animal that flies on the board?");
					state435.setText(string436.toString());
					if (!flowThread.callState(state435, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 577, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 603
					lookBoard state437 = new lookBoard();
					if (!flowThread.callState(state437, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 603, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 604
					iristk.flow.DialogFlow.wait waitState438 = new iristk.flow.DialogFlow.wait();
					waitState438.setMsec(4000);
					if (!flowThread.callState(waitState438, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 604, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 605
					Showing state439 = new Showing();
					if (!flowThread.callState(state439, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 605, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 607
					lookChild state440 = new lookChild();
					if (!flowThread.callState(state440, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 607, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 608
					audioplayer.playSound("audio/PlayAnimalCatDog.wav");
					iristk.situated.SystemAgentFlow.say state441 = agent.new say();
					StringCreator string442 = new StringCreator();
					string442.append("Can you show me the animals that have four legs?");
					state441.setText(string442.toString());
					if (!flowThread.callState(state441, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 577, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 610
					lookBoard state443 = new lookBoard();
					if (!flowThread.callState(state443, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 610, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 611
					iristk.flow.DialogFlow.wait waitState444 = new iristk.flow.DialogFlow.wait();
					waitState444.setMsec(4000);
					if (!flowThread.callState(waitState444, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 611, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 612
					Showing state445 = new Showing();
					if (!flowThread.callState(state445, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 612, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 614
					lookChild state446 = new lookChild();
					if (!flowThread.callState(state446, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 614, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 615
					audioplayer.playSound("audio/PlayAnimalCat.wav");
					iristk.situated.SystemAgentFlow.say state447 = agent.new say();
					StringCreator string448 = new StringCreator();
					string448.append("Can you show me the animal that says meow?");
					state447.setText(string448.toString());
					if (!flowThread.callState(state447, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 577, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 617
					lookBoard state449 = new lookBoard();
					if (!flowThread.callState(state449, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 617, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 618
					iristk.flow.DialogFlow.wait waitState450 = new iristk.flow.DialogFlow.wait();
					waitState450.setMsec(4000);
					if (!flowThread.callState(waitState450, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 618, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 619
					Showing state451 = new Showing();
					if (!flowThread.callState(state451, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 619, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 621
					CheckAgain state452 = new CheckAgain();
					flowThread.gotoState(state452, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 621, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 577, 12));
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
			// Line: 630
			try {
				EXECUTION: {
					int count = getCount(312116338) + 1;
					incrCount(312116338);
					// Line: 631
					audioplayer.playSound("audio/PlayPrepareDistribute.wav");
					iristk.situated.SystemAgentFlow.say state453 = agent.new say();
					StringCreator string454 = new StringCreator();
					string454.append("Would you please distribute the cards to the board?");
					state453.setText(string454.toString());
					if (!flowThread.callState(state453, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 630, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 633
					iristk.flow.DialogFlow.wait waitState455 = new iristk.flow.DialogFlow.wait();
					waitState455.setMsec(2000);
					if (!flowThread.callState(waitState455, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 633, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state456 = agent.new listen();
					if (!flowThread.callState(state456, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 630, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 630, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 636
			try {
				count = getCount(757108857) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:okay")) {
						incrCount(757108857);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 637
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 637, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 636, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Showing extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 642
			try {
				EXECUTION: {
					int count = getCount(659748578) + 1;
					incrCount(659748578);
					// Line: 643
					lookCaretaker state457 = new lookCaretaker();
					if (!flowThread.callState(state457, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 643, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 644
					audioplayer.playSound("audio/ShowingCheck.wav");
					// Line: 645
					iristk.flow.DialogFlow.wait waitState458 = new iristk.flow.DialogFlow.wait();
					waitState458.setMsec(1000);
					if (!flowThread.callState(waitState458, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 645, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state459 = agent.new say();
					StringCreator string460 = new StringCreator();
					string460.append("Is that correct?");
					state459.setText(string460.toString());
					if (!flowThread.callState(state459, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 642, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 647
					iristk.flow.DialogFlow.wait waitState461 = new iristk.flow.DialogFlow.wait();
					waitState461.setMsec(3000);
					if (!flowThread.callState(waitState461, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 647, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state462 = agent.new listen();
					if (!flowThread.callState(state462, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 642, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 642, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 650
			try {
				count = getCount(41903949) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(41903949);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 651
							lookChild state463 = new lookChild();
							if (!flowThread.callState(state463, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 651, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state464 = agent.new say();
							StringCreator string465 = new StringCreator();
							string465.append("Good Job. You are doing great.");
							state464.setText(string465.toString());
							if (!flowThread.callState(state464, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 650, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 653
							iristk.flow.DialogFlow.wait waitState466 = new iristk.flow.DialogFlow.wait();
							waitState466.setMsec(3000);
							if (!flowThread.callState(waitState466, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 653, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 654
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 654, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 650, 58));
			}
			// Line: 657
			try {
				count = getCount(2083562754) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2083562754);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 658
							lookChild state467 = new lookChild();
							if (!flowThread.callState(state467, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 658, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 659
							audioplayer.playSound("audio/ShowingCorrect.wav");
							iristk.situated.SystemAgentFlow.say state468 = agent.new say();
							StringCreator string469 = new StringCreator();
							string469.append("It's alright. Let's see which one is the correct answer.");
							state468.setText(string469.toString());
							if (!flowThread.callState(state468, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 657, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 661
							lookCaretaker state470 = new lookCaretaker();
							if (!flowThread.callState(state470, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 661, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state471 = agent.new say();
							StringCreator string472 = new StringCreator();
							string472.append("Can you show me the correct answer please?");
							state471.setText(string472.toString());
							if (!flowThread.callState(state471, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 657, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 663
							iristk.flow.DialogFlow.wait waitState473 = new iristk.flow.DialogFlow.wait();
							waitState473.setMsec(4000);
							if (!flowThread.callState(waitState473, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 663, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state474 = agent.new say();
							StringCreator string475 = new StringCreator();
							string475.append("Let's continue.");
							state474.setText(string475.toString());
							if (!flowThread.callState(state474, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 657, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 665
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 665, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 657, 57));
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
					int count = getCount(997110508) + 1;
					incrCount(997110508);
					iristk.situated.SystemAgentFlow.say state476 = agent.new say();
					StringCreator string477 = new StringCreator();
					string477.append("Great choice. This is going to be fun!");
					state476.setText(string477.toString());
					if (!flowThread.callState(state476, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 670, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 672
					iristk.flow.DialogFlow.wait waitState478 = new iristk.flow.DialogFlow.wait();
					waitState478.setMsec(1000);
					if (!flowThread.callState(waitState478, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 672, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 673
					lookCaretaker state479 = new lookCaretaker();
					if (!flowThread.callState(state479, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 673, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state480 = agent.new say();
					StringCreator string481 = new StringCreator();
					string481.append("Let's start the game.");
					state480.setText(string481.toString());
					if (!flowThread.callState(state480, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 670, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 676
					audioplayer.playSound("audio/PlayObjectsHat.wav");
					// Line: 677
					FindObject state482 = new FindObject();
					state482.setObject("hat");
					if (!flowThread.callState(state482, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 677, 47)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 678
					audioplayer.playSound("audio/PlayObjectsChair.wav");
					// Line: 679
					FindObject state483 = new FindObject();
					state483.setObject("chair");
					if (!flowThread.callState(state483, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 679, 49)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 680
					audioplayer.playSound("audio/PlayObjectsTomato.wav");
					// Line: 681
					FindObject state484 = new FindObject();
					state484.setObject("tomato");
					if (!flowThread.callState(state484, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 681, 50)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 682
					audioplayer.playSound("audio/PlayObjectsCar.wav");
					// Line: 683
					FindObject state485 = new FindObject();
					state485.setObject("car");
					if (!flowThread.callState(state485, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 683, 47)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 684
					audioplayer.playSound("audio/PlayObjectsButterfly.wav");
					// Line: 685
					FindObject state486 = new FindObject();
					state486.setObject("butterfly");
					if (!flowThread.callState(state486, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 685, 53)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 687
					CheckAgain state487 = new CheckAgain();
					flowThread.gotoState(state487, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 687, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
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


	private class FindObject extends Dialog {

		final State currentState = this;
		public String object = asString("");

		public void setObject(Object value) {
			if (value != null) {
				object = asString(value);
				params.put("object", value);
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
			// Line: 694
			try {
				EXECUTION: {
					int count = getCount(2114889273) + 1;
					incrCount(2114889273);
					// Line: 695
					lookChild state488 = new lookChild();
					if (!flowThread.callState(state488, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 695, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 696
					iristk.flow.DialogFlow.wait waitState489 = new iristk.flow.DialogFlow.wait();
					waitState489.setMsec(1000);
					if (!flowThread.callState(waitState489, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 696, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state490 = agent.new say();
					StringCreator string491 = new StringCreator();
					string491.append("Look around you and try to find a");
					// Line: 696
					string491.append(object);
					string491.append(".");
					state490.setText(string491.toString());
					if (!flowThread.callState(state490, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 694, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 698
					lookUp state492 = new lookUp();
					if (!flowThread.callState(state492, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 698, 26)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 699
					iristk.flow.DialogFlow.wait waitState493 = new iristk.flow.DialogFlow.wait();
					waitState493.setMsec(1000);
					if (!flowThread.callState(waitState493, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 699, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 700
					audioplayer.playSound("audio/FindObjectExplain.wav");
					// Line: 701
					lookCaretaker state494 = new lookCaretaker();
					if (!flowThread.callState(state494, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 701, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 702
					iristk.flow.DialogFlow.wait waitState495 = new iristk.flow.DialogFlow.wait();
					waitState495.setMsec(1500);
					if (!flowThread.callState(waitState495, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 702, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 703
					lookChild state496 = new lookChild();
					if (!flowThread.callState(state496, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 703, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 704
					iristk.flow.DialogFlow.wait waitState497 = new iristk.flow.DialogFlow.wait();
					waitState497.setMsec(1500);
					if (!flowThread.callState(waitState497, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 704, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state498 = agent.new say();
					StringCreator string499 = new StringCreator();
					string499.append("Could you find it?");
					state498.setText(string499.toString());
					if (!flowThread.callState(state498, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 694, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state500 = agent.new listen();
					if (!flowThread.callState(state500, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 694, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 694, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 710
			try {
				count = getCount(157627094) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(157627094);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 711
							lookChild state501 = new lookChild();
							if (!flowThread.callState(state501, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 711, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state502 = agent.new say();
							StringCreator string503 = new StringCreator();
							string503.append("Great job! You found it.");
							state502.setText(string503.toString());
							if (!flowThread.callState(state502, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 710, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 713
							iristk.flow.DialogFlow.wait waitState504 = new iristk.flow.DialogFlow.wait();
							waitState504.setMsec(1000);
							if (!flowThread.callState(waitState504, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 713, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 714
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 714, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 710, 58));
			}
			// Line: 717
			try {
				count = getCount(1682092198) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1682092198);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 718
							lookChild state505 = new lookChild();
							if (!flowThread.callState(state505, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 718, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state506 = agent.new say();
							StringCreator string507 = new StringCreator();
							string507.append("Where could it be?");
							state506.setText(string507.toString());
							if (!flowThread.callState(state506, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 717, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 720
							iristk.flow.DialogFlow.wait waitState508 = new iristk.flow.DialogFlow.wait();
							waitState508.setMsec(2000);
							if (!flowThread.callState(waitState508, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 720, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 721
							lookCaretaker state509 = new lookCaretaker();
							if (!flowThread.callState(state509, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 721, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 722
							audioplayer.playSound("audio/FindObjectCaretakerQuestion.wav");
							iristk.situated.SystemAgentFlow.say state510 = agent.new say();
							StringCreator string511 = new StringCreator();
							string511.append("Hmmm... Do you see the");
							// Line: 722
							string511.append( object );
							state510.setText(string511.toString());
							if (!flowThread.callState(state510, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 717, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 724
							iristk.flow.DialogFlow.wait waitState512 = new iristk.flow.DialogFlow.wait();
							waitState512.setMsec(2000);
							if (!flowThread.callState(waitState512, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 724, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 725
							ShowObject state513 = new ShowObject();
							state513.setObject(object);
							if (!flowThread.callState(state513, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 725, 48)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 726
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 726, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 717, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class ShowObject extends Dialog {

		final State currentState = this;
		public String object = asString("");

		public void setObject(Object value) {
			if (value != null) {
				object = asString(value);
				params.put("object", value);
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
			// Line: 732
			try {
				EXECUTION: {
					int count = getCount(114132791) + 1;
					incrCount(114132791);
					iristk.situated.SystemAgentFlow.listen state514 = agent.new listen();
					if (!flowThread.callState(state514, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 732, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 732, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 735
			try {
				count = getCount(586617651) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(586617651);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 736
							lookChild state515 = new lookChild();
							if (!flowThread.callState(state515, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 736, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state516 = agent.new say();
							StringCreator string517 = new StringCreator();
							string517.append("Ahhh... There it is. That's a");
							// Line: 736
							string517.append( object );
							state516.setText(string517.toString());
							if (!flowThread.callState(state516, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 735, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 738
							iristk.flow.DialogFlow.wait waitState518 = new iristk.flow.DialogFlow.wait();
							waitState518.setMsec(1000);
							if (!flowThread.callState(waitState518, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 738, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 739
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 739, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 735, 58));
			}
			// Line: 742
			try {
				count = getCount(440434003) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(440434003);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 743
							lookChild state519 = new lookChild();
							if (!flowThread.callState(state519, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 743, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state520 = agent.new say();
							StringCreator string521 = new StringCreator();
							string521.append("I can't see a");
							// Line: 743
							string521.append( object );
							state520.setText(string521.toString());
							if (!flowThread.callState(state520, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 742, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state522 = agent.new say();
							StringCreator string523 = new StringCreator();
							string523.append("Let's find something else.");
							state522.setText(string523.toString());
							if (!flowThread.callState(state522, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 742, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 746
							iristk.flow.DialogFlow.wait waitState524 = new iristk.flow.DialogFlow.wait();
							waitState524.setMsec(2000);
							if (!flowThread.callState(waitState524, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 746, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 747
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 747, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 742, 57));
			}
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
			// Line: 755
			try {
				EXECUTION: {
					int count = getCount(1720435669) + 1;
					incrCount(1720435669);
					iristk.situated.SystemAgentFlow.say state525 = agent.new say();
					StringCreator string526 = new StringCreator();
					string526.append("Do you want to continue?");
					state525.setText(string526.toString());
					if (!flowThread.callState(state525, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 755, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state527 = agent.new listen();
					if (!flowThread.callState(state527, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 755, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 755, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 759
			try {
				count = getCount(1020923989) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1020923989);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state528 = agent.new say();
							StringCreator string529 = new StringCreator();
							string529.append("Okay, let's play again.");
							state528.setText(string529.toString());
							if (!flowThread.callState(state528, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 759, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 761
							Start state530 = new Start();
							flowThread.gotoState(state530, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 761, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 759, 58));
			}
			// Line: 763
			try {
				count = getCount(1068934215) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1068934215);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state531 = agent.new say();
							StringCreator string532 = new StringCreator();
							string532.append("Okay, goodbye");
							state531.setText(string532.toString());
							if (!flowThread.callState(state531, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 763, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 765
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 763, 57));
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
			// Line: 770
			try {
				count = getCount(2036958521) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(2036958521);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state533 = agent.new say();
						StringCreator string534 = new StringCreator();
						string534.append("I am sorry, I didn't hear anything.");
						state533.setText(string534.toString());
						if (!flowThread.callState(state533, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 770, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 772
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 772, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 770, 38));
			}
			// Line: 774
			try {
				count = getCount(785992331) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(785992331);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state535 = agent.new say();
						StringCreator string536 = new StringCreator();
						string536.append("I am sorry, I didn't get that.");
						state535.setText(string536.toString());
						if (!flowThread.callState(state535, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 774, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 776
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 776, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 774, 36));
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
			// Line: 785
			try {
				EXECUTION: {
					int count = getCount(998351292) + 1;
					incrCount(998351292);
					// Line: 786
					Event sendEvent537 = new Event("action.gaze");
					sendEvent537.putIfNotNull("location", new Location(degx, degy, degz));
					flowRunner.sendEvent(sendEvent537, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 786, 76)));
					// Line: 787
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 787, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 785, 12));
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
			// Line: 792
			try {
				EXECUTION: {
					int count = getCount(2017354584) + 1;
					incrCount(2017354584);
					// Line: 793
					Event sendEvent538 = new Event("action.gaze");
					sendEvent538.putIfNotNull("location", new Location(-1, 0, 1));
					flowRunner.sendEvent(sendEvent538, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 793, 68)));
					// Line: 794
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 794, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 792, 12));
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
			// Line: 799
			try {
				EXECUTION: {
					int count = getCount(321142942) + 1;
					incrCount(321142942);
					// Line: 800
					Event sendEvent539 = new Event("action.gaze");
					sendEvent539.putIfNotNull("location", new Location(1, 0, 1));
					flowRunner.sendEvent(sendEvent539, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 800, 67)));
					// Line: 801
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 801, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 799, 12));
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
			// Line: 806
			try {
				EXECUTION: {
					int count = getCount(1393931310) + 1;
					incrCount(1393931310);
					// Line: 807
					Event sendEvent540 = new Event("action.gaze");
					sendEvent540.putIfNotNull("location", new Location(0, -1, 1));
					flowRunner.sendEvent(sendEvent540, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 807, 68)));
					// Line: 808
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 808, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 806, 12));
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


	private class lookUp extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 813
			try {
				EXECUTION: {
					int count = getCount(1622006612) + 1;
					incrCount(1622006612);
					// Line: 814
					Event sendEvent541 = new Event("action.gaze");
					sendEvent541.putIfNotNull("location", new Location(0, 1, 1));
					flowRunner.sendEvent(sendEvent541, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 814, 67)));
					// Line: 815
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 815, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 813, 12));
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
