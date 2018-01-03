package iristk.app.quizgame;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;
import iristk.situated.Location;

public class QuizgameFlow extends iristk.flow.Flow {

	private iristk.situated.SystemAgentFlow agent;
	private iristk.situated.SystemAgent system;
	private AudioPlayer audioplayer;

	private void initVariables() {
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
		audioplayer = (AudioPlayer) new AudioPlayer();
	}

	public iristk.situated.SystemAgent getSystem() {
		return this.system;
	}

	public void setSystem(iristk.situated.SystemAgent value) {
		this.system = value;
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
		if (name.equals("audioplayer")) return this.audioplayer;
		if (name.equals("agent")) return this.agent;
		return null;
	}


	public QuizgameFlow(iristk.situated.SystemAgentFlow agent) {
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
			// Line: 16
			try {
				EXECUTION: {
					int count = getCount(1973336893) + 1;
					incrCount(1973336893);
					// Line: 17
					audioplayer.playSound("audio/StartDemoInfo.wav");
					// Line: 18
					lookCaretaker state0 = new lookCaretaker();
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 18, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state1 = agent.new say();
					StringCreator string2 = new StringCreator();
					string2.append("Hello there, I am a robotic language tutor that helps children acquire the English language 			 with the help of a non English speaking caretaker.");
					state1.setText(string2.toString());
					if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 16, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 21
					lookChild state3 = new lookChild();
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 21, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 22
					iristk.flow.DialogFlow.wait waitState4 = new iristk.flow.DialogFlow.wait();
					waitState4.setMsec(1000);
					if (!flowThread.callState(waitState4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 22, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state5 = agent.new say();
					StringCreator string6 = new StringCreator();
					string6.append("Normally I have been designed to target children between 			zero to three years but for this demo I am going to ask you harder questions.");
					state5.setText(string6.toString());
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 16, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 25
					PlayAnimals state7 = new PlayAnimals();
					flowThread.gotoState(state7, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 25, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 16, 12));
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
			// Line: 32
			try {
				EXECUTION: {
					int count = getCount(1407343478) + 1;
					incrCount(1407343478);
					iristk.situated.SystemAgentFlow.say state8 = agent.new say();
					StringCreator string9 = new StringCreator();
					string9.append("Let's see if you know these interesting facts.");
					state8.setText(string9.toString());
					if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 32, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 34
					iristk.flow.DialogFlow.wait waitState10 = new iristk.flow.DialogFlow.wait();
					waitState10.setMsec(3000);
					if (!flowThread.callState(waitState10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 34, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 35
					lookCaretaker state11 = new lookCaretaker();
					if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 35, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 37
					audioplayer.playSound("audio/PlayAnimalStart.wav");
					iristk.situated.SystemAgentFlow.say state12 = agent.new say();
					StringCreator string13 = new StringCreator();
					string13.append("Let's start the game.");
					state12.setText(string13.toString());
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 32, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 40
					lookChild state14 = new lookChild();
					if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 40, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 41
					audioplayer.playSound("audio/PlayAnimalsCat.wav");
					iristk.situated.SystemAgentFlow.say state15 = agent.new say();
					StringCreator string16 = new StringCreator();
					string16.append("Can you show me the animal that sleeps 70 percent of the day?");
					state15.setText(string16.toString());
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 32, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 43
					lookBoard state17 = new lookBoard();
					if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 43, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 44
					iristk.flow.DialogFlow.wait waitState18 = new iristk.flow.DialogFlow.wait();
					waitState18.setMsec(6000);
					if (!flowThread.callState(waitState18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 44, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 45
					Showing state19 = new Showing();
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 45, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 47
					lookChild state20 = new lookChild();
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 47, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 48
					audioplayer.playSound("audio/PlayAnimalsDuck.wav");
					iristk.situated.SystemAgentFlow.say state21 = agent.new say();
					StringCreator string22 = new StringCreator();
					string22.append("Can you show me the animal that can sleep with one eye open?");
					state21.setText(string22.toString());
					if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 32, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 50
					lookBoard state23 = new lookBoard();
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 50, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 51
					iristk.flow.DialogFlow.wait waitState24 = new iristk.flow.DialogFlow.wait();
					waitState24.setMsec(6000);
					if (!flowThread.callState(waitState24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 51, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 52
					Showing state25 = new Showing();
					if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 52, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 54
					lookChild state26 = new lookChild();
					if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 54, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 55
					audioplayer.playSound("audio/PlayAnimalsBird.wav");
					iristk.situated.SystemAgentFlow.say state27 = agent.new say();
					StringCreator string28 = new StringCreator();
					string28.append("Can you show me the animal that is the closest relative of crocodiles?");
					state27.setText(string28.toString());
					if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 32, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 57
					lookBoard state29 = new lookBoard();
					if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 57, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 58
					iristk.flow.DialogFlow.wait waitState30 = new iristk.flow.DialogFlow.wait();
					waitState30.setMsec(6000);
					if (!flowThread.callState(waitState30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 58, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 59
					Showing state31 = new Showing();
					if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 59, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 61
					lookChild state32 = new lookChild();
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 61, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 62
					audioplayer.playSound("audio/PlayAnimalsFish.wav");
					iristk.situated.SystemAgentFlow.say state33 = agent.new say();
					StringCreator string34 = new StringCreator();
					string34.append("Can you show me the animal that has growth rings like trees?");
					state33.setText(string34.toString());
					if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 32, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 64
					lookBoard state35 = new lookBoard();
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 64, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 65
					iristk.flow.DialogFlow.wait waitState36 = new iristk.flow.DialogFlow.wait();
					waitState36.setMsec(6000);
					if (!flowThread.callState(waitState36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 65, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 66
					Showing state37 = new Showing();
					if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 66, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 68
					lookChild state38 = new lookChild();
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 68, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 69
					audioplayer.playSound("audio/PlayAnimalsMultiple.wav");
					iristk.situated.SystemAgentFlow.say state39 = agent.new say();
					StringCreator string40 = new StringCreator();
					string40.append("Can you show me the animals that have better eyesight than humans?");
					state39.setText(string40.toString());
					if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 32, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 71
					lookBoard state41 = new lookBoard();
					if (!flowThread.callState(state41, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 71, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 72
					iristk.flow.DialogFlow.wait waitState42 = new iristk.flow.DialogFlow.wait();
					waitState42.setMsec(6000);
					if (!flowThread.callState(waitState42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 72, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 73
					Showing state43 = new Showing();
					if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 73, 27)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 75
					CheckAgain state44 = new CheckAgain();
					flowThread.gotoState(state44, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 75, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 32, 12));
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
			// Line: 82
			try {
				EXECUTION: {
					int count = getCount(474675244) + 1;
					incrCount(474675244);
					iristk.situated.SystemAgentFlow.say state45 = agent.new say();
					StringCreator string46 = new StringCreator();
					string46.append("Do you want to continue?");
					state45.setText(string46.toString());
					if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 82, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state47 = agent.new listen();
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 82, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 82, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 86
			try {
				count = getCount(932583850) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(932583850);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state48 = agent.new say();
							StringCreator string49 = new StringCreator();
							string49.append("Okay, let's play again.");
							state48.setText(string49.toString());
							if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 86, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 88
							Start state50 = new Start();
							flowThread.gotoState(state50, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 88, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 86, 58));
			}
			// Line: 90
			try {
				count = getCount(1579572132) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1579572132);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state51 = agent.new say();
							StringCreator string52 = new StringCreator();
							string52.append("Okay, goodbye");
							state51.setText(string52.toString());
							if (!flowThread.callState(state51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 90, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 92
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 90, 57));
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
			// Line: 97
			try {
				count = getCount(2111991224) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(2111991224);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state53 = agent.new say();
						StringCreator string54 = new StringCreator();
						string54.append("I am sorry, I didn't hear anything.");
						state53.setText(string54.toString());
						if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 97, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 99
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 99, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 97, 38));
			}
			// Line: 101
			try {
				count = getCount(917142466) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(917142466);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state55 = agent.new say();
						StringCreator string56 = new StringCreator();
						string56.append("I am sorry, I didn't get that.");
						state55.setText(string56.toString());
						if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 101, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 103
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 103, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 101, 36));
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
			// Line: 107
			try {
				EXECUTION: {
					int count = getCount(1130478920) + 1;
					incrCount(1130478920);
					// Line: 108
					lookCaretaker state57 = new lookCaretaker();
					if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 108, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 109
					audioplayer.playSound("audio/ShowingCheck.wav");
					// Line: 110
					iristk.flow.DialogFlow.wait waitState58 = new iristk.flow.DialogFlow.wait();
					waitState58.setMsec(1000);
					if (!flowThread.callState(waitState58, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 110, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state59 = agent.new say();
					StringCreator string60 = new StringCreator();
					string60.append("Is that correct?");
					state59.setText(string60.toString());
					if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 107, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 112
					iristk.flow.DialogFlow.wait waitState61 = new iristk.flow.DialogFlow.wait();
					waitState61.setMsec(3000);
					if (!flowThread.callState(waitState61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 112, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state62 = agent.new listen();
					if (!flowThread.callState(state62, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 107, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 107, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 115
			try {
				count = getCount(1101288798) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1101288798);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 116
							lookChild state63 = new lookChild();
							if (!flowThread.callState(state63, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 116, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state64 = agent.new say();
							StringCreator string65 = new StringCreator();
							string65.append("Good Job. You are doing great.");
							state64.setText(string65.toString());
							if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 115, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 118
							iristk.flow.DialogFlow.wait waitState66 = new iristk.flow.DialogFlow.wait();
							waitState66.setMsec(3000);
							if (!flowThread.callState(waitState66, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 118, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 119
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 119, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 115, 58));
			}
			// Line: 122
			try {
				count = getCount(305623748) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(305623748);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 123
							lookChild state67 = new lookChild();
							if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 123, 29)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 124
							audioplayer.playSound("audio/ShowingCorrect.wav");
							iristk.situated.SystemAgentFlow.say state68 = agent.new say();
							StringCreator string69 = new StringCreator();
							string69.append("It's alright. Let's see which one is the correct answer.");
							state68.setText(string69.toString());
							if (!flowThread.callState(state68, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 122, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 126
							lookCaretaker state70 = new lookCaretaker();
							if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 126, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state71 = agent.new say();
							StringCreator string72 = new StringCreator();
							string72.append("Can you show me the correct answer please?");
							state71.setText(string72.toString());
							if (!flowThread.callState(state71, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 122, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 128
							iristk.flow.DialogFlow.wait waitState73 = new iristk.flow.DialogFlow.wait();
							waitState73.setMsec(4000);
							if (!flowThread.callState(waitState73, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 128, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state74 = agent.new say();
							StringCreator string75 = new StringCreator();
							string75.append("Let's continue.");
							state74.setText(string75.toString());
							if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 122, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 130
							flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 130, 13)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 122, 57));
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
			// Line: 138
			try {
				EXECUTION: {
					int count = getCount(1068824137) + 1;
					incrCount(1068824137);
					// Line: 139
					Event sendEvent76 = new Event("action.gaze");
					sendEvent76.putIfNotNull("location", new Location(degx, degy, degz));
					flowRunner.sendEvent(sendEvent76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 139, 76)));
					// Line: 140
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 140, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 138, 12));
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
			// Line: 145
			try {
				EXECUTION: {
					int count = getCount(237852351) + 1;
					incrCount(237852351);
					// Line: 146
					Event sendEvent77 = new Event("action.gaze");
					sendEvent77.putIfNotNull("location", new Location(-1, 1, 1));
					flowRunner.sendEvent(sendEvent77, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 146, 68)));
					// Line: 147
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 147, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 145, 12));
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
			// Line: 152
			try {
				EXECUTION: {
					int count = getCount(992136656) + 1;
					incrCount(992136656);
					// Line: 153
					Event sendEvent78 = new Event("action.gaze");
					sendEvent78.putIfNotNull("location", new Location(1, 1, 1));
					flowRunner.sendEvent(sendEvent78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 153, 67)));
					// Line: 154
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 154, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 152, 12));
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
			// Line: 159
			try {
				EXECUTION: {
					int count = getCount(1221555852) + 1;
					incrCount(1221555852);
					// Line: 160
					Event sendEvent79 = new Event("action.gaze");
					sendEvent79.putIfNotNull("location", new Location(0, -1, 1));
					flowRunner.sendEvent(sendEvent79, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 160, 68)));
					// Line: 161
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 161, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 159, 12));
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
			// Line: 166
			try {
				EXECUTION: {
					int count = getCount(2036368507) + 1;
					incrCount(2036368507);
					// Line: 167
					Event sendEvent80 = new Event("action.gaze");
					sendEvent80.putIfNotNull("location", new Location(0, 1, 1));
					flowRunner.sendEvent(sendEvent80, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 167, 67)));
					// Line: 168
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 168, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\quizgame\\src\\iristk\\app\\quizgame\\QuizgameFlow.xml"), 166, 12));
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
