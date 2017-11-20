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

public class CardsFlow extends iristk.flow.Flow {

	private iristk.situated.SystemAgentFlow agent;
	private iristk.situated.SystemAgent system;

	private void initVariables() {
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
	}

	public iristk.situated.SystemAgent getSystem() {
		return this.system;
	}

	public void setSystem(iristk.situated.SystemAgent value) {
		this.system = value;
	}

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("system")) return this.system;
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
			// Line: 15
			try {
				EXECUTION: {
					int count = getCount(997608398) + 1;
					incrCount(997608398);
					iristk.situated.SystemAgentFlow.say state0 = agent.new say();
					StringCreator string1 = new StringCreator();
					string1.append("Hello there, do you want to learn or play a game?");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 15, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 17
					lookAround state2 = new lookAround();
					state2.setDegz(1);
					state2.setDegx(-1);
					state2.setDegy(0);
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 17, 66)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state3 = agent.new listen();
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 15, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 15, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 20
			try {
				count = getCount(1174290147) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:learn")) {
						incrCount(1174290147);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 21
							Learn state4 = new Learn();
							flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 21, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 20, 60));
			}
			// Line: 23
			try {
				count = getCount(1285044316) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:play")) {
						incrCount(1285044316);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 24
							Play state5 = new Play();
							flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 24, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 23, 59));
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
			// Line: 32
			try {
				EXECUTION: {
					int count = getCount(245565335) + 1;
					incrCount(245565335);
					// Line: 33
					Event sendEvent6 = new Event("action.gaze");
					sendEvent6.putIfNotNull("location", new Location(degx, degy, degz));
					flowRunner.sendEvent(sendEvent6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 33, 76)));
					// Line: 34
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 34, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 32, 12));
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
			// Line: 41
			try {
				EXECUTION: {
					int count = getCount(476402209) + 1;
					incrCount(476402209);
					iristk.situated.SystemAgentFlow.say state7 = agent.new say();
					StringCreator string8 = new StringCreator();
					string8.append("Let's have some fun. Which subject would you like to play with?");
					state7.setText(string8.toString());
					if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 41, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state9 = agent.new listen();
					if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 41, 12)))) {
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
			// Line: 45
			try {
				count = getCount(1490180672) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(1490180672);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 46
							System.out.println("Hayvan kartlarinin oldugu desteyi aliniz ve cocugun onune rastgele diziniz.");
							// Line: 47
							iristk.flow.DialogFlow.wait waitState10 = new iristk.flow.DialogFlow.wait();
							waitState10.setMsec(3000);
							if (!flowThread.callState(waitState10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 47, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state11 = agent.new say();
							StringCreator string12 = new StringCreator();
							string12.append("Great choice. I love animals. Let's wait for the caretaker to finish.");
							state11.setText(string12.toString());
							if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 45, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 45, 61));
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
			// Line: 56
			try {
				EXECUTION: {
					int count = getCount(250075633) + 1;
					incrCount(250075633);
					iristk.situated.SystemAgentFlow.say state13 = agent.new say();
					StringCreator string14 = new StringCreator();
					string14.append("Let's start learning. What do you want to learn about?");
					state13.setText(string14.toString());
					if (!flowThread.callState(state13, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 56, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state15 = agent.new listen();
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 56, 12)))) {
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
			// Line: 60
			try {
				count = getCount(517938326) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(517938326);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 61
							System.out.println("Renk kartlarinin oldugu desteyi aliniz.");
							// Line: 62
							iristk.flow.DialogFlow.wait waitState16 = new iristk.flow.DialogFlow.wait();
							waitState16.setMsec(3000);
							if (!flowThread.callState(waitState16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 62, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state17 = agent.new say();
							StringCreator string18 = new StringCreator();
							string18.append("Okay, let's learn about colors.");
							state17.setText(string18.toString());
							if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 64
							TeachRed state19 = new TeachRed();
							flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 64, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 60, 60));
			}
			// Line: 66
			try {
				count = getCount(2143192188) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(2143192188);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 67
							System.out.println("Hayvan kartlarinin oldugu desteyi aliniz.");
							iristk.situated.SystemAgentFlow.say state20 = agent.new say();
							StringCreator string21 = new StringCreator();
							string21.append("Okay, let's learn about animals.");
							state20.setText(string21.toString());
							if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 66, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 69
							TeachAnimals state22 = new TeachAnimals();
							flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 69, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 66, 61));
			}
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
			// Line: 76
			try {
				EXECUTION: {
					int count = getCount(114935352) + 1;
					incrCount(114935352);
					// Line: 77
					System.out.println("Kopek oyuncagini gosterin ve sallayin.");
					// Line: 78
					iristk.flow.DialogFlow.wait waitState23 = new iristk.flow.DialogFlow.wait();
					waitState23.setMsec(3000);
					if (!flowThread.callState(waitState23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 78, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state24 = agent.new say();
					StringCreator string25 = new StringCreator();
					string25.append("This is a dog. The dog says woof. The dog has 4 legs.");
					state24.setText(string25.toString());
					if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 76, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 81
					System.out.println("Kedi oyuncagini gosterin ve sallayin.");
					// Line: 82
					iristk.flow.DialogFlow.wait waitState26 = new iristk.flow.DialogFlow.wait();
					waitState26.setMsec(3000);
					if (!flowThread.callState(waitState26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 82, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state27 = agent.new say();
					StringCreator string28 = new StringCreator();
					string28.append("This is a cat. The says meow. The cat also has 4 legs like dog.");
					state27.setText(string28.toString());
					if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 76, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 85
					System.out.println("At oyuncagini gosterin ve sallayin.");
					// Line: 86
					iristk.flow.DialogFlow.wait waitState29 = new iristk.flow.DialogFlow.wait();
					waitState29.setMsec(3000);
					if (!flowThread.callState(waitState29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 86, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state30 = agent.new say();
					StringCreator string31 = new StringCreator();
					string31.append("This is a horse. The horse can run very fast.");
					state30.setText(string31.toString());
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 76, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 76, 12));
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
			// Line: 93
			try {
				EXECUTION: {
					int count = getCount(1365202186) + 1;
					incrCount(1365202186);
					// Line: 94
					System.out.println("Kirmizi renkli karti gosterin ve sallayin.");
					// Line: 95
					iristk.flow.DialogFlow.wait waitState32 = new iristk.flow.DialogFlow.wait();
					waitState32.setMsec(3000);
					if (!flowThread.callState(waitState32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 95, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state33 = agent.new say();
					StringCreator string34 = new StringCreator();
					string34.append("This is red.");
					state33.setText(string34.toString());
					if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 93, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 98
					System.out.println("kirmizi karti cevirip sirayla itfaiye araci, trafik levhasi ve dil fotosunu parmaginizla gosterin.");
					// Line: 99
					iristk.flow.DialogFlow.wait waitState35 = new iristk.flow.DialogFlow.wait();
					waitState35.setMsec(3000);
					if (!flowThread.callState(waitState35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 99, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state36 = agent.new say();
					StringCreator string37 = new StringCreator();
					string37.append("Firetrucks, stop signs and fire are all red.");
					state36.setText(string37.toString());
					if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 93, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 101
					TeachBlue state38 = new TeachBlue();
					flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 101, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 93, 12));
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
			// Line: 106
			try {
				EXECUTION: {
					int count = getCount(359023572) + 1;
					incrCount(359023572);
					// Line: 107
					System.out.println("Mavi renkli karti gosterin ve sallayin.");
					// Line: 108
					iristk.flow.DialogFlow.wait waitState39 = new iristk.flow.DialogFlow.wait();
					waitState39.setMsec(3000);
					if (!flowThread.callState(waitState39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 108, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state40 = agent.new say();
					StringCreator string41 = new StringCreator();
					string41.append("This is blue.");
					state40.setText(string41.toString());
					if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 106, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 111
					System.out.println("Mavi karti çevirip sirayla denizi, gokyuzu ve dil fotosuna isaret edin.");
					// Line: 112
					iristk.flow.DialogFlow.wait waitState42 = new iristk.flow.DialogFlow.wait();
					waitState42.setMsec(3000);
					if (!flowThread.callState(waitState42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 112, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state43 = agent.new say();
					StringCreator string44 = new StringCreator();
					string44.append("The sea, the sky and the ball are all blue. Blue");
					state43.setText(string44.toString());
					if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 106, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 114
					TeachGreen state45 = new TeachGreen();
					flowThread.gotoState(state45, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 114, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 106, 12));
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
			// Line: 119
			try {
				EXECUTION: {
					int count = getCount(1404928347) + 1;
					incrCount(1404928347);
					// Line: 120
					System.out.println("Yesil renkli karti gosterin ve sallayin.");
					// Line: 121
					iristk.flow.DialogFlow.wait waitState46 = new iristk.flow.DialogFlow.wait();
					waitState46.setMsec(3000);
					if (!flowThread.callState(waitState46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 121, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state47 = agent.new say();
					StringCreator string48 = new StringCreator();
					string48.append("This is green.");
					state47.setText(string48.toString());
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 119, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 124
					System.out.println("Yesil karti cevirip sirayla cimen, agac ve elma fotosuna işaret edin.");
					// Line: 125
					iristk.flow.DialogFlow.wait waitState49 = new iristk.flow.DialogFlow.wait();
					waitState49.setMsec(3000);
					if (!flowThread.callState(waitState49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 125, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state50 = agent.new say();
					StringCreator string51 = new StringCreator();
					string51.append("The grass, the tree and the apple are all green. Green");
					state50.setText(string51.toString());
					if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 119, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 127
					CheckAgain state52 = new CheckAgain();
					flowThread.gotoState(state52, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 127, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 119, 12));
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
			// Line: 132
			try {
				EXECUTION: {
					int count = getCount(942731712) + 1;
					incrCount(942731712);
					iristk.situated.SystemAgentFlow.say state53 = agent.new say();
					StringCreator string54 = new StringCreator();
					string54.append("Do you want to continue?");
					state53.setText(string54.toString());
					if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 132, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state55 = agent.new listen();
					if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 132, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 132, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 136
			try {
				count = getCount(971848845) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(971848845);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state56 = agent.new say();
							StringCreator string57 = new StringCreator();
							string57.append("Okay, let's play again.");
							state56.setText(string57.toString());
							if (!flowThread.callState(state56, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 136, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 138
							Start state58 = new Start();
							flowThread.gotoState(state58, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 138, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 136, 58));
			}
			// Line: 140
			try {
				count = getCount(305623748) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(305623748);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state59 = agent.new say();
							StringCreator string60 = new StringCreator();
							string60.append("Okay, goodbye");
							state59.setText(string60.toString());
							if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 140, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 142
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 140, 57));
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
			// Line: 147
			try {
				count = getCount(1521118594) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1521118594);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state61 = agent.new say();
						StringCreator string62 = new StringCreator();
						string62.append("I am sorry, I didn't hear anything.");
						state61.setText(string62.toString());
						if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 147, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 149
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 149, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 147, 38));
			}
			// Line: 151
			try {
				count = getCount(1869997857) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1869997857);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state63 = agent.new say();
						StringCreator string64 = new StringCreator();
						string64.append("I am sorry, I didn't get that.");
						state63.setText(string64.toString());
						if (!flowThread.callState(state63, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 151, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 153
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 153, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\cards\\src\\iristk\\app\\cards\\CardsFlow.xml"), 151, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
