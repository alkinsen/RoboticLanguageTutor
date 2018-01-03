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
					audioplayer.playSound("audio/StartLevel.wav");
					// Line: 21
					lookChild state1 = new lookChild();
					if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 21, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 22
					iristk.flow.DialogFlow.wait waitState2 = new iristk.flow.DialogFlow.wait();
					waitState2.setMsec(3000);
					if (!flowThread.callState(waitState2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 22, 23)))) {
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
					// Line: 24
					lookCaretaker state5 = new lookCaretaker();
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 24, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state6 = agent.new listen();
					if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 18, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 18, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 28
			try {
				count = getCount(1940447180) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:one")) {
						incrCount(1940447180);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 29
							EasyLearn state7 = new EasyLearn();
							flowThread.gotoState(state7, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 29, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 28, 58));
			}
			// Line: 31
			try {
				count = getCount(2121744517) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:two")) {
						incrCount(2121744517);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 32
							Learn state8 = new Learn();
							flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 32, 25)));
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
				count = getCount(183264084) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:three")) {
						incrCount(183264084);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 35
							Play state9 = new Play();
							flowThread.gotoState(state9, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 35, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 34, 60));
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
			// Line: 41
			try {
				EXECUTION: {
					int count = getCount(460332449) + 1;
					incrCount(460332449);
					// Line: 42
					lookChild state10 = new lookChild();
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 42, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state11 = agent.new say();
					StringCreator string12 = new StringCreator();
					string12.append("Which subject would you like to learn about?");
					state11.setText(string12.toString());
					if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 41, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state13 = agent.new listen();
					if (!flowThread.callState(state13, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 41, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 41, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 47
			try {
				count = getCount(1143839598) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(1143839598);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 48
							EasyLearnAnimals state14 = new EasyLearnAnimals();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 48, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 47, 61));
			}
			// Line: 50
			try {
				count = getCount(358699161) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(358699161);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 51
							EasyLearnColors state15 = new EasyLearnColors();
							flowThread.gotoState(state15, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 51, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 50, 60));
			}
			// Line: 53
			try {
				count = getCount(914424520) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:body")) {
						incrCount(914424520);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 54
							EasyLearnBody state16 = new EasyLearnBody();
							flowThread.gotoState(state16, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 54, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 53, 59));
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
			// Line: 60
			try {
				EXECUTION: {
					int count = getCount(2143192188) + 1;
					incrCount(2143192188);
					iristk.situated.SystemAgentFlow.say state17 = agent.new say();
					StringCreator string18 = new StringCreator();
					string18.append("Let's read a book. The book is Brown Bear, Brown Bear.");
					state17.setText(string18.toString());
					if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 62
					iristk.flow.DialogFlow.wait waitState19 = new iristk.flow.DialogFlow.wait();
					waitState19.setMsec(3000);
					if (!flowThread.callState(waitState19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 64
					tts.speak("Ayıyı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state20 = agent.new say();
					StringCreator string21 = new StringCreator();
					string21.append("Brown bear, brown bear, what do you see?");
					state20.setText(string21.toString());
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 66
					iristk.flow.DialogFlow.wait waitState22 = new iristk.flow.DialogFlow.wait();
					waitState22.setMsec(1000);
					if (!flowThread.callState(waitState22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 66, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 67
					tts.speak("Kuşu gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state23 = agent.new say();
					StringCreator string24 = new StringCreator();
					string24.append("I see a red bird looking at me.");
					state23.setText(string24.toString());
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 69
					iristk.flow.DialogFlow.wait waitState25 = new iristk.flow.DialogFlow.wait();
					waitState25.setMsec(1000);
					if (!flowThread.callState(waitState25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 69, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state26 = agent.new say();
					StringCreator string27 = new StringCreator();
					string27.append("Red bird, red bird, what do you see?");
					state26.setText(string27.toString());
					if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 71
					iristk.flow.DialogFlow.wait waitState28 = new iristk.flow.DialogFlow.wait();
					waitState28.setMsec(1000);
					if (!flowThread.callState(waitState28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 71, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 72
					tts.speak("Ördeği gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state29 = agent.new say();
					StringCreator string30 = new StringCreator();
					string30.append("I see a yellow duck looking at me.");
					state29.setText(string30.toString());
					if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 74
					iristk.flow.DialogFlow.wait waitState31 = new iristk.flow.DialogFlow.wait();
					waitState31.setMsec(1000);
					if (!flowThread.callState(waitState31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 74, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state32 = agent.new say();
					StringCreator string33 = new StringCreator();
					string33.append("Yellow duck, yellow duck, what do you see?");
					state32.setText(string33.toString());
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 76
					iristk.flow.DialogFlow.wait waitState34 = new iristk.flow.DialogFlow.wait();
					waitState34.setMsec(1000);
					if (!flowThread.callState(waitState34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 76, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 77
					tts.speak("Atı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state35 = agent.new say();
					StringCreator string36 = new StringCreator();
					string36.append("I see a blue horse looking at me.");
					state35.setText(string36.toString());
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 79
					iristk.flow.DialogFlow.wait waitState37 = new iristk.flow.DialogFlow.wait();
					waitState37.setMsec(1000);
					if (!flowThread.callState(waitState37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 79, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state38 = agent.new say();
					StringCreator string39 = new StringCreator();
					string39.append("Blue horse, blue horse, what do you see?");
					state38.setText(string39.toString());
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 81
					iristk.flow.DialogFlow.wait waitState40 = new iristk.flow.DialogFlow.wait();
					waitState40.setMsec(1000);
					if (!flowThread.callState(waitState40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 81, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 82
					tts.speak("Kurbağayı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state41 = agent.new say();
					StringCreator string42 = new StringCreator();
					string42.append("I see a green frog looking at me.");
					state41.setText(string42.toString());
					if (!flowThread.callState(state41, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 84
					iristk.flow.DialogFlow.wait waitState43 = new iristk.flow.DialogFlow.wait();
					waitState43.setMsec(1000);
					if (!flowThread.callState(waitState43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 84, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state44 = agent.new say();
					StringCreator string45 = new StringCreator();
					string45.append("Green frog, green frog, what do you see?");
					state44.setText(string45.toString());
					if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 86
					iristk.flow.DialogFlow.wait waitState46 = new iristk.flow.DialogFlow.wait();
					waitState46.setMsec(1000);
					if (!flowThread.callState(waitState46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 86, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 87
					tts.speak("Kediyi gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state47 = agent.new say();
					StringCreator string48 = new StringCreator();
					string48.append("I see a purple cat looking at me.");
					state47.setText(string48.toString());
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 89
					iristk.flow.DialogFlow.wait waitState49 = new iristk.flow.DialogFlow.wait();
					waitState49.setMsec(1000);
					if (!flowThread.callState(waitState49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 89, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state50 = agent.new say();
					StringCreator string51 = new StringCreator();
					string51.append("Purple cat, purple cat, what do you see?");
					state50.setText(string51.toString());
					if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 91
					iristk.flow.DialogFlow.wait waitState52 = new iristk.flow.DialogFlow.wait();
					waitState52.setMsec(1000);
					if (!flowThread.callState(waitState52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 91, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 92
					tts.speak("Köpeği gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state53 = agent.new say();
					StringCreator string54 = new StringCreator();
					string54.append("I see a white dog looking at me.");
					state53.setText(string54.toString());
					if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 94
					iristk.flow.DialogFlow.wait waitState55 = new iristk.flow.DialogFlow.wait();
					waitState55.setMsec(1000);
					if (!flowThread.callState(waitState55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 94, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state56 = agent.new say();
					StringCreator string57 = new StringCreator();
					string57.append("White dog, white dog, what do you see?");
					state56.setText(string57.toString());
					if (!flowThread.callState(state56, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 96
					iristk.flow.DialogFlow.wait waitState58 = new iristk.flow.DialogFlow.wait();
					waitState58.setMsec(1000);
					if (!flowThread.callState(waitState58, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 96, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 97
					tts.speak("Kuzuyu gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state59 = agent.new say();
					StringCreator string60 = new StringCreator();
					string60.append("I see a black sheep looking at me.");
					state59.setText(string60.toString());
					if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 99
					iristk.flow.DialogFlow.wait waitState61 = new iristk.flow.DialogFlow.wait();
					waitState61.setMsec(1000);
					if (!flowThread.callState(waitState61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 99, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state62 = agent.new say();
					StringCreator string63 = new StringCreator();
					string63.append("Black sheep, black sheep what do you see?");
					state62.setText(string63.toString());
					if (!flowThread.callState(state62, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 101
					iristk.flow.DialogFlow.wait waitState64 = new iristk.flow.DialogFlow.wait();
					waitState64.setMsec(1000);
					if (!flowThread.callState(waitState64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 101, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 102
					tts.speak("Balığı gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state65 = agent.new say();
					StringCreator string66 = new StringCreator();
					string66.append("I see a gold fish looking at me.");
					state65.setText(string66.toString());
					if (!flowThread.callState(state65, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 104
					iristk.flow.DialogFlow.wait waitState67 = new iristk.flow.DialogFlow.wait();
					waitState67.setMsec(1000);
					if (!flowThread.callState(waitState67, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 104, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state68 = agent.new say();
					StringCreator string69 = new StringCreator();
					string69.append("Gold fish, gold fish, what do you see?");
					state68.setText(string69.toString());
					if (!flowThread.callState(state68, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 106
					iristk.flow.DialogFlow.wait waitState70 = new iristk.flow.DialogFlow.wait();
					waitState70.setMsec(1000);
					if (!flowThread.callState(waitState70, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 106, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 107
					tts.speak("Kendinizi gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state71 = agent.new say();
					StringCreator string72 = new StringCreator();
					string72.append("I see a nanny looking at me.");
					state71.setText(string72.toString());
					if (!flowThread.callState(state71, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 109
					iristk.flow.DialogFlow.wait waitState73 = new iristk.flow.DialogFlow.wait();
					waitState73.setMsec(1000);
					if (!flowThread.callState(waitState73, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 109, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state74 = agent.new say();
					StringCreator string75 = new StringCreator();
					string75.append("Nanny, nanny, what do you see?");
					state74.setText(string75.toString());
					if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 111
					iristk.flow.DialogFlow.wait waitState76 = new iristk.flow.DialogFlow.wait();
					waitState76.setMsec(1000);
					if (!flowThread.callState(waitState76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 111, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 112
					tts.speak("Bebeği gösterin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state77 = agent.new say();
					StringCreator string78 = new StringCreator();
					string78.append("I see a baby looking at me.");
					state77.setText(string78.toString());
					if (!flowThread.callState(state77, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 114
					iristk.flow.DialogFlow.wait waitState79 = new iristk.flow.DialogFlow.wait();
					waitState79.setMsec(1000);
					if (!flowThread.callState(waitState79, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 114, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state80 = agent.new say();
					StringCreator string81 = new StringCreator();
					string81.append("Well done! I love this book!");
					state80.setText(string81.toString());
					if (!flowThread.callState(state80, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 12));
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
			// Line: 120
			try {
				EXECUTION: {
					int count = getCount(305623748) + 1;
					incrCount(305623748);
					// Line: 121
					lookCaretaker state82 = new lookCaretaker();
					if (!flowThread.callState(state82, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 122
					tts.speak("Kırmızı kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 123
					iristk.flow.DialogFlow.wait waitState83 = new iristk.flow.DialogFlow.wait();
					waitState83.setMsec(3000);
					if (!flowThread.callState(waitState83, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 123, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state84 = agent.new say();
					StringCreator string85 = new StringCreator();
					string85.append("This is red.");
					state84.setText(string85.toString());
					if (!flowThread.callState(state84, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 126
					lookChild state86 = new lookChild();
					if (!flowThread.callState(state86, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 126, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 127
					tts.speak("Kırmızı kartı çevirip elmaya işaret edin.", 1.0f, false, false);
					// Line: 128
					iristk.flow.DialogFlow.wait waitState87 = new iristk.flow.DialogFlow.wait();
					waitState87.setMsec(3000);
					if (!flowThread.callState(waitState87, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 128, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state88 = agent.new say();
					StringCreator string89 = new StringCreator();
					string89.append("What is red? Apple is red. Apple is red.");
					state88.setText(string89.toString());
					if (!flowThread.callState(state88, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 131
					lookChild state90 = new lookChild();
					if (!flowThread.callState(state90, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 131, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 132
					tts.speak("Mavi kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 133
					iristk.flow.DialogFlow.wait waitState91 = new iristk.flow.DialogFlow.wait();
					waitState91.setMsec(3000);
					if (!flowThread.callState(waitState91, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 133, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state92 = agent.new say();
					StringCreator string93 = new StringCreator();
					string93.append("This is blue.");
					state92.setText(string93.toString());
					if (!flowThread.callState(state92, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 136
					lookCaretaker state94 = new lookCaretaker();
					if (!flowThread.callState(state94, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 136, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 137
					tts.speak("Mavi kartı çevirip gök yüzüne işaret edin.", 1.0f, false, false);
					// Line: 138
					iristk.flow.DialogFlow.wait waitState95 = new iristk.flow.DialogFlow.wait();
					waitState95.setMsec(3000);
					if (!flowThread.callState(waitState95, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 138, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state96 = agent.new say();
					StringCreator string97 = new StringCreator();
					string97.append("What is blue? The sky is blue. The sky is blue.");
					state96.setText(string97.toString());
					if (!flowThread.callState(state96, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 141
					lookChild state98 = new lookChild();
					if (!flowThread.callState(state98, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 141, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 142
					tts.speak("Yeşil kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 143
					iristk.flow.DialogFlow.wait waitState99 = new iristk.flow.DialogFlow.wait();
					waitState99.setMsec(3000);
					if (!flowThread.callState(waitState99, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 143, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state100 = agent.new say();
					StringCreator string101 = new StringCreator();
					string101.append("This is green.");
					state100.setText(string101.toString());
					if (!flowThread.callState(state100, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 146
					lookCaretaker state102 = new lookCaretaker();
					if (!flowThread.callState(state102, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 146, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 147
					tts.speak("Yeşil kartı çevirip çimene işaret edin.", 1.0f, false, false);
					// Line: 148
					iristk.flow.DialogFlow.wait waitState103 = new iristk.flow.DialogFlow.wait();
					waitState103.setMsec(3000);
					if (!flowThread.callState(waitState103, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 148, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state104 = agent.new say();
					StringCreator string105 = new StringCreator();
					string105.append("What is green? The grass is green. The grass is green.");
					state104.setText(string105.toString());
					if (!flowThread.callState(state104, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 151
					lookChild state106 = new lookChild();
					if (!flowThread.callState(state106, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 151, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 152
					tts.speak("Sarı kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 153
					iristk.flow.DialogFlow.wait waitState107 = new iristk.flow.DialogFlow.wait();
					waitState107.setMsec(3000);
					if (!flowThread.callState(waitState107, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 153, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state108 = agent.new say();
					StringCreator string109 = new StringCreator();
					string109.append("This is yellow.");
					state108.setText(string109.toString());
					if (!flowThread.callState(state108, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 156
					lookCaretaker state110 = new lookCaretaker();
					if (!flowThread.callState(state110, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 156, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 157
					tts.speak("Sarı kartı çevirip limona işaret edin.", 1.0f, false, false);
					// Line: 158
					iristk.flow.DialogFlow.wait waitState111 = new iristk.flow.DialogFlow.wait();
					waitState111.setMsec(3000);
					if (!flowThread.callState(waitState111, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 158, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state112 = agent.new say();
					StringCreator string113 = new StringCreator();
					string113.append("What is yellow? Lemon is yellow. Lemon is yellow.");
					state112.setText(string113.toString());
					if (!flowThread.callState(state112, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 161
					lookChild state114 = new lookChild();
					if (!flowThread.callState(state114, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 161, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 162
					tts.speak("Turuncu kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 163
					iristk.flow.DialogFlow.wait waitState115 = new iristk.flow.DialogFlow.wait();
					waitState115.setMsec(3000);
					if (!flowThread.callState(waitState115, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 163, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state116 = agent.new say();
					StringCreator string117 = new StringCreator();
					string117.append("This is orange.");
					state116.setText(string117.toString());
					if (!flowThread.callState(state116, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 166
					lookCaretaker state118 = new lookCaretaker();
					if (!flowThread.callState(state118, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 166, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 167
					tts.speak("Turunucu kartı çevirip havuca işaret edin.", 1.0f, false, false);
					// Line: 168
					iristk.flow.DialogFlow.wait waitState119 = new iristk.flow.DialogFlow.wait();
					waitState119.setMsec(3000);
					if (!flowThread.callState(waitState119, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 168, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state120 = agent.new say();
					StringCreator string121 = new StringCreator();
					string121.append("What is orange? Carrot is orange. Carrot is orange.");
					state120.setText(string121.toString());
					if (!flowThread.callState(state120, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 171
					lookChild state122 = new lookChild();
					if (!flowThread.callState(state122, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 171, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 172
					tts.speak("Kahverengi kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 173
					iristk.flow.DialogFlow.wait waitState123 = new iristk.flow.DialogFlow.wait();
					waitState123.setMsec(3000);
					if (!flowThread.callState(waitState123, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 173, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state124 = agent.new say();
					StringCreator string125 = new StringCreator();
					string125.append("This is brown.");
					state124.setText(string125.toString());
					if (!flowThread.callState(state124, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 176
					lookCaretaker state126 = new lookCaretaker();
					if (!flowThread.callState(state126, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 176, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 177
					tts.speak("Kahverengi kartı çevirip ayıya işaret edin.", 1.0f, false, false);
					// Line: 178
					iristk.flow.DialogFlow.wait waitState127 = new iristk.flow.DialogFlow.wait();
					waitState127.setMsec(3000);
					if (!flowThread.callState(waitState127, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 178, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state128 = agent.new say();
					StringCreator string129 = new StringCreator();
					string129.append("What is brown? Bear is brown. Bear is brown.");
					state128.setText(string129.toString());
					if (!flowThread.callState(state128, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 181
					lookChild state130 = new lookChild();
					if (!flowThread.callState(state130, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 181, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 182
					tts.speak("Mor renkli kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 183
					iristk.flow.DialogFlow.wait waitState131 = new iristk.flow.DialogFlow.wait();
					waitState131.setMsec(3000);
					if (!flowThread.callState(waitState131, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 183, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state132 = agent.new say();
					StringCreator string133 = new StringCreator();
					string133.append("This is purple.");
					state132.setText(string133.toString());
					if (!flowThread.callState(state132, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 186
					lookCaretaker state134 = new lookCaretaker();
					if (!flowThread.callState(state134, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 186, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 187
					tts.speak("Mor kartı çevirip patlıcana işaret edin.", 1.0f, false, false);
					// Line: 188
					iristk.flow.DialogFlow.wait waitState135 = new iristk.flow.DialogFlow.wait();
					waitState135.setMsec(3000);
					if (!flowThread.callState(waitState135, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 188, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state136 = agent.new say();
					StringCreator string137 = new StringCreator();
					string137.append("What is purple? Eggplant is purple. Eggplant is purple.");
					state136.setText(string137.toString());
					if (!flowThread.callState(state136, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 191
					lookChild state138 = new lookChild();
					if (!flowThread.callState(state138, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 191, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 192
					tts.speak("Beyaz kartı gösterin ve sallayın.", 1.0f, false, false);
					// Line: 193
					iristk.flow.DialogFlow.wait waitState139 = new iristk.flow.DialogFlow.wait();
					waitState139.setMsec(3000);
					if (!flowThread.callState(waitState139, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 193, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state140 = agent.new say();
					StringCreator string141 = new StringCreator();
					string141.append("This is white.");
					state140.setText(string141.toString());
					if (!flowThread.callState(state140, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 196
					lookCaretaker state142 = new lookCaretaker();
					if (!flowThread.callState(state142, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 196, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 197
					tts.speak("Beyaz kartı çevirip kara işaret edin.", 1.0f, false, false);
					// Line: 198
					iristk.flow.DialogFlow.wait waitState143 = new iristk.flow.DialogFlow.wait();
					waitState143.setMsec(3000);
					if (!flowThread.callState(waitState143, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 198, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state144 = agent.new say();
					StringCreator string145 = new StringCreator();
					string145.append("What is white? Snow is white. Snow is white.");
					state144.setText(string145.toString());
					if (!flowThread.callState(state144, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 120, 12));
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
			// Line: 204
			try {
				EXECUTION: {
					int count = getCount(116211441) + 1;
					incrCount(116211441);
					iristk.situated.SystemAgentFlow.say state146 = agent.new say();
					StringCreator string147 = new StringCreator();
					string147.append("Let's learn a song.");
					state146.setText(string147.toString());
					if (!flowThread.callState(state146, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 206
					iristk.flow.DialogFlow.wait waitState148 = new iristk.flow.DialogFlow.wait();
					waitState148.setMsec(3000);
					if (!flowThread.callState(waitState148, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 206, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 208
					lookCaretaker state149 = new lookCaretaker();
					if (!flowThread.callState(state149, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 208, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 209
					tts.speak("Ellerinizi çırpın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state150 = agent.new say();
					StringCreator string151 = new StringCreator();
					string151.append("Clap your hands.");
					state150.setText(string151.toString());
					if (!flowThread.callState(state150, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 211
					lookChild state152 = new lookChild();
					if (!flowThread.callState(state152, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 211, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 212
					iristk.flow.DialogFlow.wait waitState153 = new iristk.flow.DialogFlow.wait();
					waitState153.setMsec(3000);
					if (!flowThread.callState(waitState153, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 212, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 213
					tts.speak("Bebeğin ellerini çırpın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state154 = agent.new say();
					StringCreator string155 = new StringCreator();
					string155.append("Clap your hands.");
					state154.setText(string155.toString());
					if (!flowThread.callState(state154, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 215
					iristk.flow.DialogFlow.wait waitState156 = new iristk.flow.DialogFlow.wait();
					waitState156.setMsec(3000);
					if (!flowThread.callState(waitState156, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 215, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 217
					lookCaretaker state157 = new lookCaretaker();
					if (!flowThread.callState(state157, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 217, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 218
					tts.speak("Ellerinizi sallayın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state158 = agent.new say();
					StringCreator string159 = new StringCreator();
					string159.append("Wave hello.");
					state158.setText(string159.toString());
					if (!flowThread.callState(state158, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 220
					lookChild state160 = new lookChild();
					if (!flowThread.callState(state160, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 220, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 221
					iristk.flow.DialogFlow.wait waitState161 = new iristk.flow.DialogFlow.wait();
					waitState161.setMsec(3000);
					if (!flowThread.callState(waitState161, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 221, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 222
					tts.speak("Bebeğin ellerini sallayın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state162 = agent.new say();
					StringCreator string163 = new StringCreator();
					string163.append("Wave hello.");
					state162.setText(string163.toString());
					if (!flowThread.callState(state162, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 224
					iristk.flow.DialogFlow.wait waitState164 = new iristk.flow.DialogFlow.wait();
					waitState164.setMsec(3000);
					if (!flowThread.callState(waitState164, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 224, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 226
					lookCaretaker state165 = new lookCaretaker();
					if (!flowThread.callState(state165, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 226, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 227
					tts.speak("Ayağa kalkın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state166 = agent.new say();
					StringCreator string167 = new StringCreator();
					string167.append("Stand up.");
					state166.setText(string167.toString());
					if (!flowThread.callState(state166, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 229
					lookChild state168 = new lookChild();
					if (!flowThread.callState(state168, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 229, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 230
					iristk.flow.DialogFlow.wait waitState169 = new iristk.flow.DialogFlow.wait();
					waitState169.setMsec(3000);
					if (!flowThread.callState(waitState169, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 230, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 231
					tts.speak("Bebeği ayağa kaldırın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state170 = agent.new say();
					StringCreator string171 = new StringCreator();
					string171.append("Stand up.");
					state170.setText(string171.toString());
					if (!flowThread.callState(state170, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 233
					iristk.flow.DialogFlow.wait waitState172 = new iristk.flow.DialogFlow.wait();
					waitState172.setMsec(3000);
					if (!flowThread.callState(waitState172, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 233, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 235
					lookCaretaker state173 = new lookCaretaker();
					if (!flowThread.callState(state173, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 235, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 236
					tts.speak("Oturun.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state174 = agent.new say();
					StringCreator string175 = new StringCreator();
					string175.append("Sit down.");
					state174.setText(string175.toString());
					if (!flowThread.callState(state174, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 238
					lookChild state176 = new lookChild();
					if (!flowThread.callState(state176, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 238, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 239
					iristk.flow.DialogFlow.wait waitState177 = new iristk.flow.DialogFlow.wait();
					waitState177.setMsec(3000);
					if (!flowThread.callState(waitState177, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 239, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 240
					tts.speak("Bebeği oturtun.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state178 = agent.new say();
					StringCreator string179 = new StringCreator();
					string179.append("Sit down.");
					state178.setText(string179.toString());
					if (!flowThread.callState(state178, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 242
					iristk.flow.DialogFlow.wait waitState180 = new iristk.flow.DialogFlow.wait();
					waitState180.setMsec(3000);
					if (!flowThread.callState(waitState180, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 242, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 244
					lookCaretaker state181 = new lookCaretaker();
					if (!flowThread.callState(state181, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 244, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 245
					tts.speak("Ellerinizi yürür gibi hareket ettirin.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state182 = agent.new say();
					StringCreator string183 = new StringCreator();
					string183.append("Let's go.");
					state182.setText(string183.toString());
					if (!flowThread.callState(state182, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 247
					lookChild state184 = new lookChild();
					if (!flowThread.callState(state184, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 247, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 248
					iristk.flow.DialogFlow.wait waitState185 = new iristk.flow.DialogFlow.wait();
					waitState185.setMsec(3000);
					if (!flowThread.callState(waitState185, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 248, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 249
					tts.speak("Bebeğin ellerini çırpın.", 1.0f, false, false);
					iristk.situated.SystemAgentFlow.say state186 = agent.new say();
					StringCreator string187 = new StringCreator();
					string187.append("Let's go.");
					state186.setText(string187.toString());
					if (!flowThread.callState(state186, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 251
					iristk.flow.DialogFlow.wait waitState188 = new iristk.flow.DialogFlow.wait();
					waitState188.setMsec(3000);
					if (!flowThread.callState(waitState188, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 251, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state189 = agent.new say();
					StringCreator string190 = new StringCreator();
					string190.append("That was fun! Great job!");
					state189.setText(string190.toString());
					if (!flowThread.callState(state189, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 204, 12));
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
			// Line: 260
			try {
				EXECUTION: {
					int count = getCount(1395089624) + 1;
					incrCount(1395089624);
					iristk.situated.SystemAgentFlow.say state191 = agent.new say();
					StringCreator string192 = new StringCreator();
					string192.append("Let's start learning. What do you want to learn about?");
					state191.setText(string192.toString());
					if (!flowThread.callState(state191, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 260, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state193 = agent.new listen();
					if (!flowThread.callState(state193, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 260, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 260, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 264
			try {
				count = getCount(1476011703) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(1476011703);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state194 = agent.new say();
							StringCreator string195 = new StringCreator();
							string195.append("Okay, let's learn about colors.");
							state194.setText(string195.toString());
							if (!flowThread.callState(state194, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 264, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 266
							LearnColors state196 = new LearnColors();
							flowThread.gotoState(state196, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 266, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 264, 60));
			}
			// Line: 268
			try {
				count = getCount(792791759) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(792791759);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state197 = agent.new say();
							StringCreator string198 = new StringCreator();
							string198.append("Okay, let's learn about animals.");
							state197.setText(string198.toString());
							if (!flowThread.callState(state197, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 268, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 270
							LearnAnimals state199 = new LearnAnimals();
							flowThread.gotoState(state199, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 270, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 268, 61));
			}
			// Line: 272
			try {
				count = getCount(1094834071) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:body")) {
						incrCount(1094834071);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state200 = agent.new say();
							StringCreator string201 = new StringCreator();
							string201.append("Okay, let's learn about body parts.");
							state200.setText(string201.toString());
							if (!flowThread.callState(state200, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 272, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 274
							LearnBody state202 = new LearnBody();
							flowThread.gotoState(state202, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 274, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 272, 59));
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
			// Line: 281
			try {
				EXECUTION: {
					int count = getCount(1279149968) + 1;
					incrCount(1279149968);
					iristk.situated.SystemAgentFlow.say state203 = agent.new say();
					StringCreator string204 = new StringCreator();
					string204.append("Let's learn about our heads, shoulders, knees and toes.");
					state203.setText(string204.toString());
					if (!flowThread.callState(state203, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 285
					lookCaretaker state205 = new lookCaretaker();
					if (!flowThread.callState(state205, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 285, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 286
					lookChild state206 = new lookChild();
					if (!flowThread.callState(state206, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 286, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 287
					tts.speak("Kafanıza, sonra çoçuğun kafasına yavaşça dokunun.", 1.0f, false, false);
					// Line: 288
					iristk.flow.DialogFlow.wait waitState207 = new iristk.flow.DialogFlow.wait();
					waitState207.setMsec(3000);
					if (!flowThread.callState(waitState207, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 288, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state208 = agent.new say();
					StringCreator string209 = new StringCreator();
					string209.append("This is your head.");
					state208.setText(string209.toString());
					if (!flowThread.callState(state208, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 291
					tts.speak("Omuzlariniza, sonra bebegin omuzlarina dokunun.", 1.0f, false, false);
					// Line: 292
					iristk.flow.DialogFlow.wait waitState210 = new iristk.flow.DialogFlow.wait();
					waitState210.setMsec(3000);
					if (!flowThread.callState(waitState210, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 292, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state211 = agent.new say();
					StringCreator string212 = new StringCreator();
					string212.append("These are your shoulders.");
					state211.setText(string212.toString());
					if (!flowThread.callState(state211, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 295
					tts.speak("Dizlerinize, daha sonra bebegin dizlerine dokunun.", 1.0f, false, false);
					// Line: 296
					iristk.flow.DialogFlow.wait waitState213 = new iristk.flow.DialogFlow.wait();
					waitState213.setMsec(3000);
					if (!flowThread.callState(waitState213, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 296, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state214 = agent.new say();
					StringCreator string215 = new StringCreator();
					string215.append("These are your knees.");
					state214.setText(string215.toString());
					if (!flowThread.callState(state214, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 299
					tts.speak("Ayaklariniza, daha sonra bebegin ayaklarina dokunun.", 1.0f, false, false);
					// Line: 300
					iristk.flow.DialogFlow.wait waitState216 = new iristk.flow.DialogFlow.wait();
					waitState216.setMsec(3000);
					if (!flowThread.callState(waitState216, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 300, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state217 = agent.new say();
					StringCreator string218 = new StringCreator();
					string218.append("These are your toes.");
					state217.setText(string218.toString());
					if (!flowThread.callState(state217, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 303
					tts.speak("Gozlerinizi, daha sonra bebegin gozlerini isaret edin.", 1.0f, false, false);
					// Line: 304
					iristk.flow.DialogFlow.wait waitState219 = new iristk.flow.DialogFlow.wait();
					waitState219.setMsec(3000);
					if (!flowThread.callState(waitState219, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 304, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state220 = agent.new say();
					StringCreator string221 = new StringCreator();
					string221.append("These are your eyes.");
					state220.setText(string221.toString());
					if (!flowThread.callState(state220, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 306
					tts.speak("Iki parmaginizi gosterin.", 1.0f, false, false);
					// Line: 307
					iristk.flow.DialogFlow.wait waitState222 = new iristk.flow.DialogFlow.wait();
					waitState222.setMsec(2000);
					if (!flowThread.callState(waitState222, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 307, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state223 = agent.new say();
					StringCreator string224 = new StringCreator();
					string224.append("We have two eyes. Two eyes.");
					state223.setText(string224.toString());
					if (!flowThread.callState(state223, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 310
					tts.speak("Kulaklariniza, daha sonra bebegin kulaklarina dokunun.", 1.0f, false, false);
					// Line: 311
					iristk.flow.DialogFlow.wait waitState225 = new iristk.flow.DialogFlow.wait();
					waitState225.setMsec(3000);
					if (!flowThread.callState(waitState225, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 311, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state226 = agent.new say();
					StringCreator string227 = new StringCreator();
					string227.append("These are your ears.");
					state226.setText(string227.toString());
					if (!flowThread.callState(state226, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 313
					tts.speak("Iki parmaginizi gosterin.", 1.0f, false, false);
					// Line: 314
					iristk.flow.DialogFlow.wait waitState228 = new iristk.flow.DialogFlow.wait();
					waitState228.setMsec(2000);
					if (!flowThread.callState(waitState228, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 314, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state229 = agent.new say();
					StringCreator string230 = new StringCreator();
					string230.append("We have two ears. Two ears.");
					state229.setText(string230.toString());
					if (!flowThread.callState(state229, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 317
					tts.speak("Bebege opucuk atin ve agizinizi gosterin.", 1.0f, false, false);
					// Line: 318
					iristk.flow.DialogFlow.wait waitState231 = new iristk.flow.DialogFlow.wait();
					waitState231.setMsec(3000);
					if (!flowThread.callState(waitState231, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 318, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state232 = agent.new say();
					StringCreator string233 = new StringCreator();
					string233.append("This is your mouth.");
					state232.setText(string233.toString());
					if (!flowThread.callState(state232, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 320
					tts.speak("Bir parmaginizi kaldirin.", 1.0f, false, false);
					// Line: 321
					iristk.flow.DialogFlow.wait waitState234 = new iristk.flow.DialogFlow.wait();
					waitState234.setMsec(2000);
					if (!flowThread.callState(waitState234, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 321, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state235 = agent.new say();
					StringCreator string236 = new StringCreator();
					string236.append("We have one mouth. One mouth.");
					state235.setText(string236.toString());
					if (!flowThread.callState(state235, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 324
					tts.speak("Burnunuza, sonra bebegin burnuna dokunun.", 1.0f, false, false);
					// Line: 325
					iristk.flow.DialogFlow.wait waitState237 = new iristk.flow.DialogFlow.wait();
					waitState237.setMsec(4000);
					if (!flowThread.callState(waitState237, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 325, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state238 = agent.new say();
					StringCreator string239 = new StringCreator();
					string239.append("This is your nose.");
					state238.setText(string239.toString());
					if (!flowThread.callState(state238, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 327
					tts.speak("Bir parmaginizi kaldirin.", 1.0f, false, false);
					// Line: 328
					iristk.flow.DialogFlow.wait waitState240 = new iristk.flow.DialogFlow.wait();
					waitState240.setMsec(2000);
					if (!flowThread.callState(waitState240, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 328, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state241 = agent.new say();
					StringCreator string242 = new StringCreator();
					string242.append("We have one nose. One nose.");
					state241.setText(string242.toString());
					if (!flowThread.callState(state241, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 331
					tts.speak("Iki elinizi bebege dogru sallayin.", 1.0f, false, false);
					// Line: 332
					iristk.flow.DialogFlow.wait waitState243 = new iristk.flow.DialogFlow.wait();
					waitState243.setMsec(4000);
					if (!flowThread.callState(waitState243, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 332, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state244 = agent.new say();
					StringCreator string245 = new StringCreator();
					string245.append("These are our hands.");
					state244.setText(string245.toString());
					if (!flowThread.callState(state244, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 334
					tts.speak("Iki elinizi gosterin.", 1.0f, false, false);
					// Line: 335
					iristk.flow.DialogFlow.wait waitState246 = new iristk.flow.DialogFlow.wait();
					waitState246.setMsec(2000);
					if (!flowThread.callState(waitState246, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 335, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state247 = agent.new say();
					StringCreator string248 = new StringCreator();
					string248.append("We have two hands. Two hands.");
					state247.setText(string248.toString());
					if (!flowThread.callState(state247, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 338
					tts.speak("Parmaklarinizi bebegin onunde hareket ettirin.", 1.0f, false, false);
					// Line: 339
					iristk.flow.DialogFlow.wait waitState249 = new iristk.flow.DialogFlow.wait();
					waitState249.setMsec(4000);
					if (!flowThread.callState(waitState249, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 339, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state250 = agent.new say();
					StringCreator string251 = new StringCreator();
					string251.append("These are our fingers.");
					state250.setText(string251.toString());
					if (!flowThread.callState(state250, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 341
					tts.speak("On parmaginizi gosterin.", 1.0f, false, false);
					// Line: 342
					iristk.flow.DialogFlow.wait waitState252 = new iristk.flow.DialogFlow.wait();
					waitState252.setMsec(2000);
					if (!flowThread.callState(waitState252, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 342, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state253 = agent.new say();
					StringCreator string254 = new StringCreator();
					string254.append("We have ten fingers. Ten fingers.");
					state253.setText(string254.toString());
					if (!flowThread.callState(state253, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state255 = agent.new say();
					StringCreator string256 = new StringCreator();
					string256.append("That was fun. Now, let's listen to the song again.");
					state255.setText(string256.toString());
					if (!flowThread.callState(state255, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 281, 12));
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
			// Line: 353
			try {
				EXECUTION: {
					int count = getCount(1058025095) + 1;
					incrCount(1058025095);
					// Line: 354
					lookChild state257 = new lookChild();
					if (!flowThread.callState(state257, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 354, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 355
					audioplayer.playSound("audio/LearnAnimalsDog.wav");
					// Line: 356
					iristk.flow.DialogFlow.wait waitState258 = new iristk.flow.DialogFlow.wait();
					waitState258.setMsec(3000);
					if (!flowThread.callState(waitState258, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 356, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state259 = agent.new say();
					StringCreator string260 = new StringCreator();
					string260.append("This is a dog. Dogs are very friendly.");
					state259.setText(string260.toString());
					if (!flowThread.callState(state259, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 358
					lookCaretaker state261 = new lookCaretaker();
					if (!flowThread.callState(state261, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 358, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 359
					audioplayer.playSound("audio/LearnAnimalsDogAct.wav");
					iristk.situated.SystemAgentFlow.say state262 = agent.new say();
					StringCreator string263 = new StringCreator();
					string263.append("The dog says woof.");
					state262.setText(string263.toString());
					if (!flowThread.callState(state262, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 361
					iristk.flow.DialogFlow.wait waitState264 = new iristk.flow.DialogFlow.wait();
					waitState264.setMsec(6000);
					if (!flowThread.callState(waitState264, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 361, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state265 = agent.new say();
					StringCreator string266 = new StringCreator();
					string266.append("The dog has 4 legs.");
					state265.setText(string266.toString());
					if (!flowThread.callState(state265, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 364
					lookChild state267 = new lookChild();
					if (!flowThread.callState(state267, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 364, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 365
					audioplayer.playSound("audio/LearnAnimalsCat.wav");
					// Line: 366
					iristk.flow.DialogFlow.wait waitState268 = new iristk.flow.DialogFlow.wait();
					waitState268.setMsec(3000);
					if (!flowThread.callState(waitState268, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 366, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state269 = agent.new say();
					StringCreator string270 = new StringCreator();
					string270.append("This is a cat. Cats sleep a lot.");
					state269.setText(string270.toString());
					if (!flowThread.callState(state269, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 368
					lookCaretaker state271 = new lookCaretaker();
					if (!flowThread.callState(state271, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 368, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 369
					audioplayer.playSound("audio/LearnAnimalsCatAct.wav");
					iristk.situated.SystemAgentFlow.say state272 = agent.new say();
					StringCreator string273 = new StringCreator();
					string273.append("The cat says meow.");
					state272.setText(string273.toString());
					if (!flowThread.callState(state272, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 371
					iristk.flow.DialogFlow.wait waitState274 = new iristk.flow.DialogFlow.wait();
					waitState274.setMsec(6000);
					if (!flowThread.callState(waitState274, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 371, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state275 = agent.new say();
					StringCreator string276 = new StringCreator();
					string276.append("The cat also has 4 legs like the dog.");
					state275.setText(string276.toString());
					if (!flowThread.callState(state275, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 374
					lookChild state277 = new lookChild();
					if (!flowThread.callState(state277, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 374, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 375
					audioplayer.playSound("audio/LearnAnimalsFish.wav");
					// Line: 376
					iristk.flow.DialogFlow.wait waitState278 = new iristk.flow.DialogFlow.wait();
					waitState278.setMsec(3000);
					if (!flowThread.callState(waitState278, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 376, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state279 = agent.new say();
					StringCreator string280 = new StringCreator();
					string280.append("This is a fish. The fish lives under the sea and swims.");
					state279.setText(string280.toString());
					if (!flowThread.callState(state279, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 378
					lookCaretaker state281 = new lookCaretaker();
					if (!flowThread.callState(state281, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 378, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 379
					audioplayer.playSound("audio/LearnAnimalsFishAct.wav");
					// Line: 380
					iristk.flow.DialogFlow.wait waitState282 = new iristk.flow.DialogFlow.wait();
					waitState282.setMsec(4500);
					if (!flowThread.callState(waitState282, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 380, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state283 = agent.new say();
					StringCreator string284 = new StringCreator();
					string284.append("The fish have fins and a tail.");
					state283.setText(string284.toString());
					if (!flowThread.callState(state283, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 383
					lookChild state285 = new lookChild();
					if (!flowThread.callState(state285, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 383, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 384
					audioplayer.playSound("audio/LearnAnimalsBird.wav");
					// Line: 385
					iristk.flow.DialogFlow.wait waitState286 = new iristk.flow.DialogFlow.wait();
					waitState286.setMsec(3000);
					if (!flowThread.callState(waitState286, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 385, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state287 = agent.new say();
					StringCreator string288 = new StringCreator();
					string288.append("This is a bird. The bird flies in the sky.");
					state287.setText(string288.toString());
					if (!flowThread.callState(state287, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 387
					lookCaretaker state289 = new lookCaretaker();
					if (!flowThread.callState(state289, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 387, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 388
					audioplayer.playSound("audio/LearnAnimalsBirdAct.wav");
					iristk.situated.SystemAgentFlow.say state290 = agent.new say();
					StringCreator string291 = new StringCreator();
					string291.append("Let's see how a bird flies?");
					state290.setText(string291.toString());
					if (!flowThread.callState(state290, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 390
					iristk.flow.DialogFlow.wait waitState292 = new iristk.flow.DialogFlow.wait();
					waitState292.setMsec(6500);
					if (!flowThread.callState(waitState292, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 390, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state293 = agent.new say();
					StringCreator string294 = new StringCreator();
					string294.append("The bird lays eggs in its nest.");
					state293.setText(string294.toString());
					if (!flowThread.callState(state293, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 393
					lookChild state295 = new lookChild();
					if (!flowThread.callState(state295, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 393, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 394
					audioplayer.playSound("audio/LearnAnimalsDuck.wav");
					// Line: 395
					iristk.flow.DialogFlow.wait waitState296 = new iristk.flow.DialogFlow.wait();
					waitState296.setMsec(3000);
					if (!flowThread.callState(waitState296, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 395, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state297 = agent.new say();
					StringCreator string298 = new StringCreator();
					string298.append("This is a duck. The duck says quack.");
					state297.setText(string298.toString());
					if (!flowThread.callState(state297, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 397
					lookCaretaker state299 = new lookCaretaker();
					if (!flowThread.callState(state299, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 397, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 398
					audioplayer.playSound("audio/LearnAnimalsDuckAct.wav");
					// Line: 399
					iristk.flow.DialogFlow.wait waitState300 = new iristk.flow.DialogFlow.wait();
					waitState300.setMsec(5000);
					if (!flowThread.callState(waitState300, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 399, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state301 = agent.new say();
					StringCreator string302 = new StringCreator();
					string302.append("The duck can swim.");
					state301.setText(string302.toString());
					if (!flowThread.callState(state301, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 402
					lookChild state303 = new lookChild();
					if (!flowThread.callState(state303, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 402, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 403
					audioplayer.playSound("audio/LearnAnimalsFrog.wav");
					// Line: 404
					iristk.flow.DialogFlow.wait waitState304 = new iristk.flow.DialogFlow.wait();
					waitState304.setMsec(3000);
					if (!flowThread.callState(waitState304, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 404, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state305 = agent.new say();
					StringCreator string306 = new StringCreator();
					string306.append("This is a frog. The frog has a very long tongue.");
					state305.setText(string306.toString());
					if (!flowThread.callState(state305, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 406
					lookCaretaker state307 = new lookCaretaker();
					if (!flowThread.callState(state307, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 406, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 407
					audioplayer.playSound("audio/LearnAnimalsFrogAct.wav");
					// Line: 408
					iristk.flow.DialogFlow.wait waitState308 = new iristk.flow.DialogFlow.wait();
					waitState308.setMsec(5000);
					if (!flowThread.callState(waitState308, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 408, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state309 = agent.new say();
					StringCreator string310 = new StringCreator();
					string310.append("The frog lives in both water and land.");
					state309.setText(string310.toString());
					if (!flowThread.callState(state309, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 411
					lookChild state311 = new lookChild();
					if (!flowThread.callState(state311, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 411, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 412
					audioplayer.playSound("audio/LearnAnimalsHorse.wav");
					// Line: 413
					iristk.flow.DialogFlow.wait waitState312 = new iristk.flow.DialogFlow.wait();
					waitState312.setMsec(3000);
					if (!flowThread.callState(waitState312, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 413, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state313 = agent.new say();
					StringCreator string314 = new StringCreator();
					string314.append("This is a horse. The horse can run very fast.");
					state313.setText(string314.toString());
					if (!flowThread.callState(state313, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 415
					lookCaretaker state315 = new lookCaretaker();
					if (!flowThread.callState(state315, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 415, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 416
					audioplayer.playSound("audio/LearnAnimalsHorseAct.wav");
					// Line: 417
					iristk.flow.DialogFlow.wait waitState316 = new iristk.flow.DialogFlow.wait();
					waitState316.setMsec(5000);
					if (!flowThread.callState(waitState316, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 417, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state317 = agent.new say();
					StringCreator string318 = new StringCreator();
					string318.append("Horses eat carrot.");
					state317.setText(string318.toString());
					if (!flowThread.callState(state317, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 420
					lookChild state319 = new lookChild();
					if (!flowThread.callState(state319, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 420, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 421
					audioplayer.playSound("audio/LearnAnimalsBear.wav");
					// Line: 422
					iristk.flow.DialogFlow.wait waitState320 = new iristk.flow.DialogFlow.wait();
					waitState320.setMsec(3000);
					if (!flowThread.callState(waitState320, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 422, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state321 = agent.new say();
					StringCreator string322 = new StringCreator();
					string322.append("This is a bear. The bear is very big.");
					state321.setText(string322.toString());
					if (!flowThread.callState(state321, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 424
					lookCaretaker state323 = new lookCaretaker();
					if (!flowThread.callState(state323, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 424, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 425
					audioplayer.playSound("audio/LearnAnimalsBearAct.wav");
					// Line: 426
					iristk.flow.DialogFlow.wait waitState324 = new iristk.flow.DialogFlow.wait();
					waitState324.setMsec(8500);
					if (!flowThread.callState(waitState324, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 426, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 428
					lookChild state325 = new lookChild();
					if (!flowThread.callState(state325, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 428, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state326 = agent.new say();
					StringCreator string327 = new StringCreator();
					string327.append("Now you know your animals.");
					state326.setText(string327.toString());
					if (!flowThread.callState(state326, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 430
					CheckAgain state328 = new CheckAgain();
					flowThread.gotoState(state328, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 430, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 353, 12));
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
			// Line: 437
			try {
				EXECUTION: {
					int count = getCount(736709391) + 1;
					incrCount(736709391);
					// Line: 438
					lookChild state329 = new lookChild();
					if (!flowThread.callState(state329, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 438, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 439
					audioplayer.playSound("audio/LearnColorsRed.wav");
					// Line: 440
					iristk.flow.DialogFlow.wait waitState330 = new iristk.flow.DialogFlow.wait();
					waitState330.setMsec(3000);
					if (!flowThread.callState(waitState330, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 440, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state331 = agent.new say();
					StringCreator string332 = new StringCreator();
					string332.append("This is red.");
					state331.setText(string332.toString());
					if (!flowThread.callState(state331, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 443
					lookCaretaker state333 = new lookCaretaker();
					if (!flowThread.callState(state333, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 443, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 444
					audioplayer.playSound("audio/LearnColorsRedEx.wav");
					// Line: 445
					iristk.flow.DialogFlow.wait waitState334 = new iristk.flow.DialogFlow.wait();
					waitState334.setMsec(3000);
					if (!flowThread.callState(waitState334, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 445, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state335 = agent.new say();
					StringCreator string336 = new StringCreator();
					string336.append("The firetruck, the stop sign and the apple are all red. Red");
					state335.setText(string336.toString());
					if (!flowThread.callState(state335, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 448
					lookChild state337 = new lookChild();
					if (!flowThread.callState(state337, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 448, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 449
					audioplayer.playSound("audio/LearnColorsBlue.wav");
					// Line: 450
					iristk.flow.DialogFlow.wait waitState338 = new iristk.flow.DialogFlow.wait();
					waitState338.setMsec(3000);
					if (!flowThread.callState(waitState338, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 450, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state339 = agent.new say();
					StringCreator string340 = new StringCreator();
					string340.append("This is blue.");
					state339.setText(string340.toString());
					if (!flowThread.callState(state339, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 453
					lookCaretaker state341 = new lookCaretaker();
					if (!flowThread.callState(state341, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 453, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 454
					audioplayer.playSound("audio/LearnColorsBlueEx.wav");
					// Line: 455
					iristk.flow.DialogFlow.wait waitState342 = new iristk.flow.DialogFlow.wait();
					waitState342.setMsec(3000);
					if (!flowThread.callState(waitState342, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 455, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state343 = agent.new say();
					StringCreator string344 = new StringCreator();
					string344.append("The sea, the sky and the butterfly are all blue. Blue");
					state343.setText(string344.toString());
					if (!flowThread.callState(state343, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 458
					lookChild state345 = new lookChild();
					if (!flowThread.callState(state345, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 458, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 459
					audioplayer.playSound("audio/LearnColorsGreen.wav");
					// Line: 460
					iristk.flow.DialogFlow.wait waitState346 = new iristk.flow.DialogFlow.wait();
					waitState346.setMsec(3000);
					if (!flowThread.callState(waitState346, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 460, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state347 = agent.new say();
					StringCreator string348 = new StringCreator();
					string348.append("This is green.");
					state347.setText(string348.toString());
					if (!flowThread.callState(state347, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 463
					lookCaretaker state349 = new lookCaretaker();
					if (!flowThread.callState(state349, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 463, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 464
					audioplayer.playSound("audio/LearnColorsGreenEx.wav");
					// Line: 465
					iristk.flow.DialogFlow.wait waitState350 = new iristk.flow.DialogFlow.wait();
					waitState350.setMsec(3000);
					if (!flowThread.callState(waitState350, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 465, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state351 = agent.new say();
					StringCreator string352 = new StringCreator();
					string352.append("The grass, the tree and the pear are all green. Green");
					state351.setText(string352.toString());
					if (!flowThread.callState(state351, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 468
					lookChild state353 = new lookChild();
					if (!flowThread.callState(state353, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 468, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 469
					audioplayer.playSound("audio/LearnColorsYellow.wav");
					// Line: 470
					iristk.flow.DialogFlow.wait waitState354 = new iristk.flow.DialogFlow.wait();
					waitState354.setMsec(3000);
					if (!flowThread.callState(waitState354, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 470, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state355 = agent.new say();
					StringCreator string356 = new StringCreator();
					string356.append("This is yellow.");
					state355.setText(string356.toString());
					if (!flowThread.callState(state355, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 473
					lookCaretaker state357 = new lookCaretaker();
					if (!flowThread.callState(state357, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 473, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 474
					audioplayer.playSound("audio/LearnColorsYellowEx.wav");
					// Line: 475
					iristk.flow.DialogFlow.wait waitState358 = new iristk.flow.DialogFlow.wait();
					waitState358.setMsec(3000);
					if (!flowThread.callState(waitState358, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 475, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state359 = agent.new say();
					StringCreator string360 = new StringCreator();
					string360.append("The lemon, the duck and the banana are all yellow. Yellow");
					state359.setText(string360.toString());
					if (!flowThread.callState(state359, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 478
					lookChild state361 = new lookChild();
					if (!flowThread.callState(state361, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 478, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 479
					audioplayer.playSound("audio/LearnColorsOrange.wav");
					// Line: 480
					iristk.flow.DialogFlow.wait waitState362 = new iristk.flow.DialogFlow.wait();
					waitState362.setMsec(3000);
					if (!flowThread.callState(waitState362, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 480, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state363 = agent.new say();
					StringCreator string364 = new StringCreator();
					string364.append("This is orange.");
					state363.setText(string364.toString());
					if (!flowThread.callState(state363, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 483
					lookCaretaker state365 = new lookCaretaker();
					if (!flowThread.callState(state365, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 483, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 484
					audioplayer.playSound("audio/LearnColorsOrangeEx.wav");
					// Line: 485
					iristk.flow.DialogFlow.wait waitState366 = new iristk.flow.DialogFlow.wait();
					waitState366.setMsec(3000);
					if (!flowThread.callState(waitState366, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 485, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state367 = agent.new say();
					StringCreator string368 = new StringCreator();
					string368.append("The orange, the carrot and the basketball are all orange. Orange");
					state367.setText(string368.toString());
					if (!flowThread.callState(state367, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 488
					lookChild state369 = new lookChild();
					if (!flowThread.callState(state369, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 488, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 489
					audioplayer.playSound("audio/LearnColorsPurple.wav");
					// Line: 490
					iristk.flow.DialogFlow.wait waitState370 = new iristk.flow.DialogFlow.wait();
					waitState370.setMsec(3000);
					if (!flowThread.callState(waitState370, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 490, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state371 = agent.new say();
					StringCreator string372 = new StringCreator();
					string372.append("This is purple.");
					state371.setText(string372.toString());
					if (!flowThread.callState(state371, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 493
					lookCaretaker state373 = new lookCaretaker();
					if (!flowThread.callState(state373, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 493, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 494
					audioplayer.playSound("audio/LearnColorsPurpleEx.wav");
					// Line: 495
					iristk.flow.DialogFlow.wait waitState374 = new iristk.flow.DialogFlow.wait();
					waitState374.setMsec(3000);
					if (!flowThread.callState(waitState374, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 495, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state375 = agent.new say();
					StringCreator string376 = new StringCreator();
					string376.append("The grapes, the eggplant and the boots are all purple. Purple");
					state375.setText(string376.toString());
					if (!flowThread.callState(state375, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 498
					iristk.flow.DialogFlow.wait waitState377 = new iristk.flow.DialogFlow.wait();
					waitState377.setMsec(2000);
					if (!flowThread.callState(waitState377, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 498, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state378 = agent.new say();
					StringCreator string379 = new StringCreator();
					string379.append("Now you know your colors.");
					state378.setText(string379.toString());
					if (!flowThread.callState(state378, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 500
					CheckAgain state380 = new CheckAgain();
					flowThread.gotoState(state380, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 500, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 437, 12));
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
			// Line: 510
			try {
				EXECUTION: {
					int count = getCount(1711574013) + 1;
					incrCount(1711574013);
					// Line: 511
					lookChild state381 = new lookChild();
					if (!flowThread.callState(state381, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 511, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 512
					audioplayer.playSound("audio/PlaySubject.wav");
					iristk.situated.SystemAgentFlow.say state382 = agent.new say();
					StringCreator string383 = new StringCreator();
					string383.append("Let's have some fun. We are going to play some games. Which subject would you like to play with?");
					state382.setText(string383.toString());
					if (!flowThread.callState(state382, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 510, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state384 = agent.new listen();
					if (!flowThread.callState(state384, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 510, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 510, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 517
			try {
				count = getCount(1638215613) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(1638215613);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 518
							PlayAnimals state385 = new PlayAnimals();
							flowThread.gotoState(state385, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 518, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 517, 61));
			}
			// Line: 520
			try {
				count = getCount(1674896058) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(1674896058);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 521
							PlayColors state386 = new PlayColors();
							flowThread.gotoState(state386, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 521, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 520, 60));
			}
			// Line: 523
			try {
				count = getCount(866191240) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:object")) {
						incrCount(866191240);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 524
							PlayObjects state387 = new PlayObjects();
							flowThread.gotoState(state387, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 524, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 523, 61));
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
			// Line: 529
			try {
				EXECUTION: {
					int count = getCount(1207769059) + 1;
					incrCount(1207769059);
					iristk.situated.SystemAgentFlow.say state388 = agent.new say();
					StringCreator string389 = new StringCreator();
					string389.append("Let's see if you have learned your colors.");
					state388.setText(string389.toString());
					if (!flowThread.callState(state388, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 529, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 531
					iristk.flow.DialogFlow.wait waitState390 = new iristk.flow.DialogFlow.wait();
					waitState390.setMsec(3000);
					if (!flowThread.callState(waitState390, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 531, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 532
					lookCaretaker state391 = new lookCaretaker();
					if (!flowThread.callState(state391, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 532, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 533
					PlayPrepare state392 = new PlayPrepare();
					if (!flowThread.callState(state392, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 533, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state393 = agent.new say();
					StringCreator string394 = new StringCreator();
					string394.append("Let's start the game.");
					state393.setText(string394.toString());
					if (!flowThread.callState(state393, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 529, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 537
					lookChild state395 = new lookChild();
					if (!flowThread.callState(state395, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 537, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state396 = agent.new say();
					StringCreator string397 = new StringCreator();
					string397.append("Can you show me the color red?");
					state396.setText(string397.toString());
					if (!flowThread.callState(state396, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 529, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 539
					audioplayer.playSound("audio/PlayColorsRed.wav");
					// Line: 540
					lookBoard state398 = new lookBoard();
					if (!flowThread.callState(state398, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 540, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 541
					iristk.flow.DialogFlow.wait waitState399 = new iristk.flow.DialogFlow.wait();
					waitState399.setMsec(4000);
					if (!flowThread.callState(waitState399, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 541, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 542
					Showing state400 = new Showing();
					if (!flowThread.callState(state400, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 542, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 544
					lookChild state401 = new lookChild();
					if (!flowThread.callState(state401, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 544, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state402 = agent.new say();
					StringCreator string403 = new StringCreator();
					string403.append("Can you show me the color purple?");
					state402.setText(string403.toString());
					if (!flowThread.callState(state402, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 529, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 546
					audioplayer.playSound("audio/PlayColorsPurple.wav");
					// Line: 547
					lookBoard state404 = new lookBoard();
					if (!flowThread.callState(state404, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 547, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 548
					iristk.flow.DialogFlow.wait waitState405 = new iristk.flow.DialogFlow.wait();
					waitState405.setMsec(4000);
					if (!flowThread.callState(waitState405, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 548, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 549
					Showing state406 = new Showing();
					if (!flowThread.callState(state406, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 549, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 551
					lookChild state407 = new lookChild();
					if (!flowThread.callState(state407, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 551, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state408 = agent.new say();
					StringCreator string409 = new StringCreator();
					string409.append("Can you first show me the color orange then yellow?");
					state408.setText(string409.toString());
					if (!flowThread.callState(state408, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 529, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 553
					audioplayer.playSound("audio/PlayColorsOrangeYellow.wav");
					// Line: 554
					lookBoard state410 = new lookBoard();
					if (!flowThread.callState(state410, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 554, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 555
					iristk.flow.DialogFlow.wait waitState411 = new iristk.flow.DialogFlow.wait();
					waitState411.setMsec(4000);
					if (!flowThread.callState(waitState411, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 555, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 556
					Showing state412 = new Showing();
					if (!flowThread.callState(state412, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 556, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 558
					lookChild state413 = new lookChild();
					if (!flowThread.callState(state413, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 558, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state414 = agent.new say();
					StringCreator string415 = new StringCreator();
					string415.append("Can you show me the color of grass?");
					state414.setText(string415.toString());
					if (!flowThread.callState(state414, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 529, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 560
					audioplayer.playSound("audio/PlayColorsGreen.wav");
					// Line: 561
					lookBoard state416 = new lookBoard();
					if (!flowThread.callState(state416, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 561, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 562
					iristk.flow.DialogFlow.wait waitState417 = new iristk.flow.DialogFlow.wait();
					waitState417.setMsec(4000);
					if (!flowThread.callState(waitState417, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 562, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 563
					Showing state418 = new Showing();
					if (!flowThread.callState(state418, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 563, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 565
					lookChild state419 = new lookChild();
					if (!flowThread.callState(state419, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 565, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state420 = agent.new say();
					StringCreator string421 = new StringCreator();
					string421.append("Can you show me the color of firetruck?");
					state420.setText(string421.toString());
					if (!flowThread.callState(state420, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 529, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 567
					audioplayer.playSound("audio/PlayColorsRed.wav");
					// Line: 568
					lookBoard state422 = new lookBoard();
					if (!flowThread.callState(state422, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 568, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 569
					iristk.flow.DialogFlow.wait waitState423 = new iristk.flow.DialogFlow.wait();
					waitState423.setMsec(4000);
					if (!flowThread.callState(waitState423, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 569, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 570
					Showing state424 = new Showing();
					if (!flowThread.callState(state424, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 570, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 572
					CheckAgain state425 = new CheckAgain();
					flowThread.gotoState(state425, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 572, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 529, 12));
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
			// Line: 578
			try {
				EXECUTION: {
					int count = getCount(381707837) + 1;
					incrCount(381707837);
					iristk.situated.SystemAgentFlow.say state426 = agent.new say();
					StringCreator string427 = new StringCreator();
					string427.append("Great choice. I love animals.");
					state426.setText(string427.toString());
					if (!flowThread.callState(state426, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 578, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 580
					iristk.flow.DialogFlow.wait waitState428 = new iristk.flow.DialogFlow.wait();
					waitState428.setMsec(3000);
					if (!flowThread.callState(waitState428, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 580, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 581
					lookCaretaker state429 = new lookCaretaker();
					if (!flowThread.callState(state429, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 581, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 582
					PlayPrepare state430 = new PlayPrepare();
					if (!flowThread.callState(state430, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 582, 31)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 584
					audioplayer.playSound("audio/PlayAnimalStart.wav");
					iristk.situated.SystemAgentFlow.say state431 = agent.new say();
					StringCreator string432 = new StringCreator();
					string432.append("Let's start the game.");
					state431.setText(string432.toString());
					if (!flowThread.callState(state431, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 578, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 587
					lookChild state433 = new lookChild();
					if (!flowThread.callState(state433, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 587, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 588
					audioplayer.playSound("audio/PlayAnimalDog.wav");
					iristk.situated.SystemAgentFlow.say state434 = agent.new say();
					StringCreator string435 = new StringCreator();
					string435.append("Can you show me the dog on the board?");
					state434.setText(string435.toString());
					if (!flowThread.callState(state434, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 578, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 590
					lookBoard state436 = new lookBoard();
					if (!flowThread.callState(state436, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 590, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 591
					iristk.flow.DialogFlow.wait waitState437 = new iristk.flow.DialogFlow.wait();
					waitState437.setMsec(4000);
					if (!flowThread.callState(waitState437, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 591, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 592
					Showing state438 = new Showing();
					if (!flowThread.callState(state438, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 592, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 594
					lookChild state439 = new lookChild();
					if (!flowThread.callState(state439, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 594, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 595
					audioplayer.playSound("audio/PlayAnimalFish.wav");
					iristk.situated.SystemAgentFlow.say state440 = agent.new say();
					StringCreator string441 = new StringCreator();
					string441.append("Can you show me the fish on the board?");
					state440.setText(string441.toString());
					if (!flowThread.callState(state440, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 578, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 597
					lookBoard state442 = new lookBoard();
					if (!flowThread.callState(state442, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 597, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 598
					iristk.flow.DialogFlow.wait waitState443 = new iristk.flow.DialogFlow.wait();
					waitState443.setMsec(4000);
					if (!flowThread.callState(waitState443, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 598, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 599
					Showing state444 = new Showing();
					if (!flowThread.callState(state444, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 599, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 601
					lookChild state445 = new lookChild();
					if (!flowThread.callState(state445, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 601, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 602
					audioplayer.playSound("audio/PlayAnimalBird.wav");
					iristk.situated.SystemAgentFlow.say state446 = agent.new say();
					StringCreator string447 = new StringCreator();
					string447.append("Can you show me the animal that flies on the board?");
					state446.setText(string447.toString());
					if (!flowThread.callState(state446, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 578, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 604
					lookBoard state448 = new lookBoard();
					if (!flowThread.callState(state448, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 604, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 605
					iristk.flow.DialogFlow.wait waitState449 = new iristk.flow.DialogFlow.wait();
					waitState449.setMsec(4000);
					if (!flowThread.callState(waitState449, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 605, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 606
					Showing state450 = new Showing();
					if (!flowThread.callState(state450, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 606, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 608
					lookChild state451 = new lookChild();
					if (!flowThread.callState(state451, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 608, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 609
					audioplayer.playSound("audio/PlayAnimalCatDog.wav");
					iristk.situated.SystemAgentFlow.say state452 = agent.new say();
					StringCreator string453 = new StringCreator();
					string453.append("Can you show me the animals that have four legs?");
					state452.setText(string453.toString());
					if (!flowThread.callState(state452, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 578, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 611
					lookBoard state454 = new lookBoard();
					if (!flowThread.callState(state454, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 611, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 612
					iristk.flow.DialogFlow.wait waitState455 = new iristk.flow.DialogFlow.wait();
					waitState455.setMsec(4000);
					if (!flowThread.callState(waitState455, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 612, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 613
					Showing state456 = new Showing();
					if (!flowThread.callState(state456, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 613, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 615
					lookChild state457 = new lookChild();
					if (!flowThread.callState(state457, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 615, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 616
					audioplayer.playSound("audio/PlayAnimalCat.wav");
					iristk.situated.SystemAgentFlow.say state458 = agent.new say();
					StringCreator string459 = new StringCreator();
					string459.append("Can you show me the animal that says meow?");
					state458.setText(string459.toString());
					if (!flowThread.callState(state458, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 578, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 618
					lookBoard state460 = new lookBoard();
					if (!flowThread.callState(state460, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 618, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 619
					iristk.flow.DialogFlow.wait waitState461 = new iristk.flow.DialogFlow.wait();
					waitState461.setMsec(4000);
					if (!flowThread.callState(waitState461, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 619, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 620
					Showing state462 = new Showing();
					if (!flowThread.callState(state462, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 620, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 622
					CheckAgain state463 = new CheckAgain();
					flowThread.gotoState(state463, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 622, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 578, 12));
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
					int count = getCount(13648335) + 1;
					incrCount(13648335);
					// Line: 631
					audioplayer.playSound("audio/PlayPrepareDistribute.wav");
					iristk.situated.SystemAgentFlow.say state464 = agent.new say();
					StringCreator string465 = new StringCreator();
					string465.append("Would you please distribute the cards to the board?");
					state464.setText(string465.toString());
					if (!flowThread.callState(state464, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 630, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 633
					iristk.flow.DialogFlow.wait waitState466 = new iristk.flow.DialogFlow.wait();
					waitState466.setMsec(2000);
					if (!flowThread.callState(waitState466, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 633, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state467 = agent.new listen();
					if (!flowThread.callState(state467, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 630, 12)))) {
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
				count = getCount(796684896) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:okay")) {
						incrCount(796684896);
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
					int count = getCount(1802598046) + 1;
					incrCount(1802598046);
					// Line: 643
					lookCaretaker state468 = new lookCaretaker();
					if (!flowThread.callState(state468, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 643, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 644
					audioplayer.playSound("audio/ShowingCheck.wav");
					// Line: 645
					iristk.flow.DialogFlow.wait waitState469 = new iristk.flow.DialogFlow.wait();
					waitState469.setMsec(1000);
					if (!flowThread.callState(waitState469, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 645, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state470 = agent.new say();
					StringCreator string471 = new StringCreator();
					string471.append("Is that correct?");
					state470.setText(string471.toString());
					if (!flowThread.callState(state470, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 642, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 647
					iristk.flow.DialogFlow.wait waitState472 = new iristk.flow.DialogFlow.wait();
					waitState472.setMsec(3000);
					if (!flowThread.callState(waitState472, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 647, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state473 = agent.new listen();
					if (!flowThread.callState(state473, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 642, 12)))) {
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
				count = getCount(1277181601) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1277181601);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 651
							lookChild state474 = new lookChild();
							if (!flowThread.callState(state474, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 651, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state475 = agent.new say();
							StringCreator string476 = new StringCreator();
							string476.append("Good Job. You are doing great.");
							state475.setText(string476.toString());
							if (!flowThread.callState(state475, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 650, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 653
							iristk.flow.DialogFlow.wait waitState477 = new iristk.flow.DialogFlow.wait();
							waitState477.setMsec(3000);
							if (!flowThread.callState(waitState477, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 653, 23)))) {
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
				count = getCount(93122545) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(93122545);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 658
							lookChild state478 = new lookChild();
							if (!flowThread.callState(state478, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 658, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 659
							audioplayer.playSound("audio/ShowingCorrect.wav");
							iristk.situated.SystemAgentFlow.say state479 = agent.new say();
							StringCreator string480 = new StringCreator();
							string480.append("It's alright. Let's see which one is the correct answer.");
							state479.setText(string480.toString());
							if (!flowThread.callState(state479, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 657, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 661
							lookCaretaker state481 = new lookCaretaker();
							if (!flowThread.callState(state481, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 661, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state482 = agent.new say();
							StringCreator string483 = new StringCreator();
							string483.append("Can you show me the correct answer please?");
							state482.setText(string483.toString());
							if (!flowThread.callState(state482, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 657, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 663
							iristk.flow.DialogFlow.wait waitState484 = new iristk.flow.DialogFlow.wait();
							waitState484.setMsec(4000);
							if (!flowThread.callState(waitState484, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 663, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state485 = agent.new say();
							StringCreator string486 = new StringCreator();
							string486.append("Let's continue.");
							state485.setText(string486.toString());
							if (!flowThread.callState(state485, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 657, 57)))) {
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
					int count = getCount(1784662007) + 1;
					incrCount(1784662007);
					iristk.situated.SystemAgentFlow.say state487 = agent.new say();
					StringCreator string488 = new StringCreator();
					string488.append("Great choice. This is going to be fun!");
					state487.setText(string488.toString());
					if (!flowThread.callState(state487, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 670, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 672
					iristk.flow.DialogFlow.wait waitState489 = new iristk.flow.DialogFlow.wait();
					waitState489.setMsec(1000);
					if (!flowThread.callState(waitState489, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 672, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 673
					lookCaretaker state490 = new lookCaretaker();
					if (!flowThread.callState(state490, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 673, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state491 = agent.new say();
					StringCreator string492 = new StringCreator();
					string492.append("Let's start the game.");
					state491.setText(string492.toString());
					if (!flowThread.callState(state491, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 670, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 676
					audioplayer.playSound("audio/PlayObjectsHat.wav");
					// Line: 677
					FindObject state493 = new FindObject();
					state493.setObject("hat");
					if (!flowThread.callState(state493, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 677, 47)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 678
					audioplayer.playSound("audio/PlayObjectsChair.wav");
					// Line: 679
					FindObject state494 = new FindObject();
					state494.setObject("chair");
					if (!flowThread.callState(state494, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 679, 49)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 680
					audioplayer.playSound("audio/PlayObjectsTomato.wav");
					// Line: 681
					FindObject state495 = new FindObject();
					state495.setObject("tomato");
					if (!flowThread.callState(state495, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 681, 50)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 682
					audioplayer.playSound("audio/PlayObjectsCar.wav");
					// Line: 683
					FindObject state496 = new FindObject();
					state496.setObject("car");
					if (!flowThread.callState(state496, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 683, 47)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 684
					audioplayer.playSound("audio/PlayObjectsButterfly.wav");
					// Line: 685
					FindObject state497 = new FindObject();
					state497.setObject("butterfly");
					if (!flowThread.callState(state497, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 685, 53)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 687
					CheckAgain state498 = new CheckAgain();
					flowThread.gotoState(state498, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 687, 30)));
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
					int count = getCount(398887205) + 1;
					incrCount(398887205);
					// Line: 695
					lookChild state499 = new lookChild();
					if (!flowThread.callState(state499, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 695, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 696
					iristk.flow.DialogFlow.wait waitState500 = new iristk.flow.DialogFlow.wait();
					waitState500.setMsec(1000);
					if (!flowThread.callState(waitState500, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 696, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state501 = agent.new say();
					StringCreator string502 = new StringCreator();
					string502.append("Look around you and try to find a");
					// Line: 696
					string502.append(object);
					string502.append(".");
					state501.setText(string502.toString());
					if (!flowThread.callState(state501, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 694, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 698
					lookUp state503 = new lookUp();
					if (!flowThread.callState(state503, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 698, 26)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 699
					iristk.flow.DialogFlow.wait waitState504 = new iristk.flow.DialogFlow.wait();
					waitState504.setMsec(1000);
					if (!flowThread.callState(waitState504, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 699, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 700
					audioplayer.playSound("audio/FindObjectExplain.wav");
					// Line: 701
					lookCaretaker state505 = new lookCaretaker();
					if (!flowThread.callState(state505, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 701, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 702
					iristk.flow.DialogFlow.wait waitState506 = new iristk.flow.DialogFlow.wait();
					waitState506.setMsec(1500);
					if (!flowThread.callState(waitState506, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 702, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 703
					lookChild state507 = new lookChild();
					if (!flowThread.callState(state507, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 703, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 704
					iristk.flow.DialogFlow.wait waitState508 = new iristk.flow.DialogFlow.wait();
					waitState508.setMsec(1500);
					if (!flowThread.callState(waitState508, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 704, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state509 = agent.new say();
					StringCreator string510 = new StringCreator();
					string510.append("Could you find it?");
					state509.setText(string510.toString());
					if (!flowThread.callState(state509, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 694, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state511 = agent.new listen();
					if (!flowThread.callState(state511, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 694, 12)))) {
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
				count = getCount(1349414238) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1349414238);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 711
							lookChild state512 = new lookChild();
							if (!flowThread.callState(state512, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 711, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state513 = agent.new say();
							StringCreator string514 = new StringCreator();
							string514.append("Great job! You found it.");
							state513.setText(string514.toString());
							if (!flowThread.callState(state513, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 710, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 713
							iristk.flow.DialogFlow.wait waitState515 = new iristk.flow.DialogFlow.wait();
							waitState515.setMsec(1000);
							if (!flowThread.callState(waitState515, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 713, 23)))) {
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
				count = getCount(1142020464) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1142020464);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 718
							lookChild state516 = new lookChild();
							if (!flowThread.callState(state516, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 718, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state517 = agent.new say();
							StringCreator string518 = new StringCreator();
							string518.append("Where could it be?");
							state517.setText(string518.toString());
							if (!flowThread.callState(state517, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 717, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 720
							iristk.flow.DialogFlow.wait waitState519 = new iristk.flow.DialogFlow.wait();
							waitState519.setMsec(2000);
							if (!flowThread.callState(waitState519, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 720, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 721
							lookCaretaker state520 = new lookCaretaker();
							if (!flowThread.callState(state520, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 721, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 722
							audioplayer.playSound("audio/FindObjectCaretakerQuestion.wav");
							iristk.situated.SystemAgentFlow.say state521 = agent.new say();
							StringCreator string522 = new StringCreator();
							string522.append("Hmmm... Do you see the");
							// Line: 722
							string522.append( object );
							state521.setText(string522.toString());
							if (!flowThread.callState(state521, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 717, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 724
							iristk.flow.DialogFlow.wait waitState523 = new iristk.flow.DialogFlow.wait();
							waitState523.setMsec(2000);
							if (!flowThread.callState(waitState523, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 724, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 725
							ShowObject state524 = new ShowObject();
							state524.setObject(object);
							if (!flowThread.callState(state524, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 725, 48)))) {
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
					int count = getCount(1811044090) + 1;
					incrCount(1811044090);
					iristk.situated.SystemAgentFlow.listen state525 = agent.new listen();
					if (!flowThread.callState(state525, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 732, 12)))) {
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
				count = getCount(114132791) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(114132791);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 736
							lookChild state526 = new lookChild();
							if (!flowThread.callState(state526, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 736, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state527 = agent.new say();
							StringCreator string528 = new StringCreator();
							string528.append("Ahhh... There it is. That's a");
							// Line: 736
							string528.append( object );
							state527.setText(string528.toString());
							if (!flowThread.callState(state527, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 735, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 738
							iristk.flow.DialogFlow.wait waitState529 = new iristk.flow.DialogFlow.wait();
							waitState529.setMsec(1000);
							if (!flowThread.callState(waitState529, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 738, 23)))) {
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
				count = getCount(3447021) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(3447021);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 743
							lookChild state530 = new lookChild();
							if (!flowThread.callState(state530, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 743, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state531 = agent.new say();
							StringCreator string532 = new StringCreator();
							string532.append("I can't see a");
							// Line: 743
							string532.append( object );
							state531.setText(string532.toString());
							if (!flowThread.callState(state531, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 742, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state533 = agent.new say();
							StringCreator string534 = new StringCreator();
							string534.append("Let's find something else.");
							state533.setText(string534.toString());
							if (!flowThread.callState(state533, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 742, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 746
							iristk.flow.DialogFlow.wait waitState535 = new iristk.flow.DialogFlow.wait();
							waitState535.setMsec(2000);
							if (!flowThread.callState(waitState535, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 746, 23)))) {
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
					int count = getCount(940553268) + 1;
					incrCount(940553268);
					iristk.situated.SystemAgentFlow.say state536 = agent.new say();
					StringCreator string537 = new StringCreator();
					string537.append("Do you want to continue?");
					state536.setText(string537.toString());
					if (!flowThread.callState(state536, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 755, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state538 = agent.new listen();
					if (!flowThread.callState(state538, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 755, 12)))) {
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
				count = getCount(1720435669) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1720435669);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state539 = agent.new say();
							StringCreator string540 = new StringCreator();
							string540.append("Okay, let's play again.");
							state539.setText(string540.toString());
							if (!flowThread.callState(state539, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 759, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 761
							Start state541 = new Start();
							flowThread.gotoState(state541, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 761, 25)));
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
				count = getCount(2052915500) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2052915500);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state542 = agent.new say();
							StringCreator string543 = new StringCreator();
							string543.append("Okay, goodbye");
							state542.setText(string543.toString());
							if (!flowThread.callState(state542, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 763, 57)))) {
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
				count = getCount(1798286609) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1798286609);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state544 = agent.new say();
						StringCreator string545 = new StringCreator();
						string545.append("I am sorry, I didn't hear anything.");
						state544.setText(string545.toString());
						if (!flowThread.callState(state544, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 770, 38)))) {
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
				count = getCount(1945604815) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1945604815);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state546 = agent.new say();
						StringCreator string547 = new StringCreator();
						string547.append("I am sorry, I didn't get that.");
						state546.setText(string547.toString());
						if (!flowThread.callState(state546, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 774, 36)))) {
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
					int count = getCount(1595953398) + 1;
					incrCount(1595953398);
					// Line: 786
					Event sendEvent548 = new Event("action.gaze");
					sendEvent548.putIfNotNull("location", new Location(degx, degy, degz));
					flowRunner.sendEvent(sendEvent548, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 786, 76)));
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
					int count = getCount(1308927845) + 1;
					incrCount(1308927845);
					// Line: 793
					Event sendEvent549 = new Event("action.gaze");
					sendEvent549.putIfNotNull("location", new Location(-1, 0, 1));
					flowRunner.sendEvent(sendEvent549, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 793, 68)));
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
					int count = getCount(403424356) + 1;
					incrCount(403424356);
					// Line: 800
					Event sendEvent550 = new Event("action.gaze");
					sendEvent550.putIfNotNull("location", new Location(1, 0, 1));
					flowRunner.sendEvent(sendEvent550, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 800, 67)));
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
					int count = getCount(1644443712) + 1;
					incrCount(1644443712);
					// Line: 807
					Event sendEvent551 = new Event("action.gaze");
					sendEvent551.putIfNotNull("location", new Location(0, -1, 1));
					flowRunner.sendEvent(sendEvent551, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 807, 68)));
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
					int count = getCount(510113906) + 1;
					incrCount(510113906);
					// Line: 814
					Event sendEvent552 = new Event("action.gaze");
					sendEvent552.putIfNotNull("location", new Location(0, 1, 1));
					flowRunner.sendEvent(sendEvent552, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 814, 67)));
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
