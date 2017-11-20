package iristk.app.learnColors;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class LearnColorsFlow extends iristk.flow.Flow {


	private void initVariables() {
	}

	@Override
	public Object getVariable(String name) {
		return null;
	}


	public LearnColorsFlow() {
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
			// Line: 7
			try {
				EXECUTION: {
					int count = getCount(463345942) + 1;
					incrCount(463345942);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Hello there, do you want to learn or play a game?");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 7, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 7, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 7, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 11
			try {
				count = getCount(1347137144) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:learn")) {
						incrCount(1347137144);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 12
							Learn state3 = new Learn();
							flowThread.gotoState(state3, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 12, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 11, 60));
			}
			// Line: 14
			try {
				count = getCount(1973336893) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:play")) {
						incrCount(1973336893);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 15
							Play state4 = new Play();
							flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 15, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 14, 59));
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
			// Line: 21
			try {
				EXECUTION: {
					int count = getCount(1289696681) + 1;
					incrCount(1289696681);
					iristk.flow.DialogFlow.say state5 = new iristk.flow.DialogFlow.say();
					StringCreator string6 = new StringCreator();
					string6.append("Let's have some fun. Which subject would you like to play with?");
					state5.setText(string6.toString());
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 21, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state7 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 21, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 21, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 25
			try {
				count = getCount(1285044316) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(1285044316);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 26
							System.out.println("Hayvan kartlarinin oldugu desteyi aliniz ve cocugun onune rastgele diziniz.");
							// Line: 27
							iristk.flow.DialogFlow.wait waitState8 = new iristk.flow.DialogFlow.wait();
							waitState8.setMsec(3000);
							if (!flowThread.callState(waitState8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 27, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state9 = new iristk.flow.DialogFlow.say();
							StringCreator string10 = new StringCreator();
							string10.append("Great choice. I love animals. Let's wait for the caretaker to finish.");
							state9.setText(string10.toString());
							if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 25, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 25, 61));
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
			// Line: 36
			try {
				EXECUTION: {
					int count = getCount(1407343478) + 1;
					incrCount(1407343478);
					iristk.flow.DialogFlow.say state11 = new iristk.flow.DialogFlow.say();
					StringCreator string12 = new StringCreator();
					string12.append("Let's start learning. What do you want to learn about?");
					state11.setText(string12.toString());
					if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 36, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state13 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state13, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 36, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 36, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 40
			try {
				count = getCount(1940447180) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:color")) {
						incrCount(1940447180);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 41
							System.out.println("Renk kartlarinin oldugu desteyi aliniz.");
							// Line: 42
							iristk.flow.DialogFlow.wait waitState14 = new iristk.flow.DialogFlow.wait();
							waitState14.setMsec(3000);
							if (!flowThread.callState(waitState14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 42, 23)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state15 = new iristk.flow.DialogFlow.say();
							StringCreator string16 = new StringCreator();
							string16.append("Okay, let's learn about colors.");
							state15.setText(string16.toString());
							if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 40, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 44
							TeachRed state17 = new TeachRed();
							flowThread.gotoState(state17, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 44, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 40, 60));
			}
			// Line: 46
			try {
				count = getCount(183264084) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:animal")) {
						incrCount(183264084);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 47
							System.out.println("Hayvan kartlarinin oldugu desteyi aliniz.");
							iristk.flow.DialogFlow.say state18 = new iristk.flow.DialogFlow.say();
							StringCreator string19 = new StringCreator();
							string19.append("Okay, let's learn about animals.");
							state18.setText(string19.toString());
							if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 46, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 49
							TeachAnimals state20 = new TeachAnimals();
							flowThread.gotoState(state20, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 49, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 46, 61));
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
			// Line: 56
			try {
				EXECUTION: {
					int count = getCount(1919892312) + 1;
					incrCount(1919892312);
					// Line: 57
					System.out.println("Kopek oyuncagini gosterin ve sallayin.");
					// Line: 58
					iristk.flow.DialogFlow.wait waitState21 = new iristk.flow.DialogFlow.wait();
					waitState21.setMsec(3000);
					if (!flowThread.callState(waitState21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 58, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state22 = new iristk.flow.DialogFlow.say();
					StringCreator string23 = new StringCreator();
					string23.append("This is a dog. The dog says woof. The dog has 4 legs.");
					state22.setText(string23.toString());
					if (!flowThread.callState(state22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 56, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 61
					System.out.println("Kedi oyuncagini gosterin ve sallayin.");
					// Line: 62
					iristk.flow.DialogFlow.wait waitState24 = new iristk.flow.DialogFlow.wait();
					waitState24.setMsec(3000);
					if (!flowThread.callState(waitState24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 62, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state25 = new iristk.flow.DialogFlow.say();
					StringCreator string26 = new StringCreator();
					string26.append("This is a cat. The says meow. The cat also has 4 legs like dog.");
					state25.setText(string26.toString());
					if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 56, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 65
					System.out.println("At oyuncagini gosterin ve sallayin.");
					// Line: 66
					iristk.flow.DialogFlow.wait waitState27 = new iristk.flow.DialogFlow.wait();
					waitState27.setMsec(3000);
					if (!flowThread.callState(waitState27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 66, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state28 = new iristk.flow.DialogFlow.say();
					StringCreator string29 = new StringCreator();
					string29.append("This is a horse. The horse can run very fast.");
					state28.setText(string29.toString());
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 56, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 56, 12));
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
			// Line: 73
			try {
				EXECUTION: {
					int count = getCount(2143192188) + 1;
					incrCount(2143192188);
					// Line: 74
					System.out.println("Kirmizi renkli karti gosterin ve sallayin.");
					// Line: 75
					iristk.flow.DialogFlow.wait waitState30 = new iristk.flow.DialogFlow.wait();
					waitState30.setMsec(3000);
					if (!flowThread.callState(waitState30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 75, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state31 = new iristk.flow.DialogFlow.say();
					StringCreator string32 = new StringCreator();
					string32.append("This is red.");
					state31.setText(string32.toString());
					if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 73, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 78
					System.out.println("kirmizi karti cevirip sirayla itfaiye araci, trafik levhasi ve dil fotosunu parmaginizla gosterin.");
					// Line: 79
					iristk.flow.DialogFlow.wait waitState33 = new iristk.flow.DialogFlow.wait();
					waitState33.setMsec(3000);
					if (!flowThread.callState(waitState33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 79, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state34 = new iristk.flow.DialogFlow.say();
					StringCreator string35 = new StringCreator();
					string35.append("Firetrucks, stop signs and fire are all red.");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 73, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 81
					TeachBlue state36 = new TeachBlue();
					flowThread.gotoState(state36, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 81, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 73, 12));
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
			// Line: 86
			try {
				EXECUTION: {
					int count = getCount(1023487453) + 1;
					incrCount(1023487453);
					// Line: 87
					System.out.println("Mavi renkli karti gosterin ve sallayin.");
					// Line: 88
					iristk.flow.DialogFlow.wait waitState37 = new iristk.flow.DialogFlow.wait();
					waitState37.setMsec(3000);
					if (!flowThread.callState(waitState37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 88, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state38 = new iristk.flow.DialogFlow.say();
					StringCreator string39 = new StringCreator();
					string39.append("This is blue.");
					state38.setText(string39.toString());
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 86, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 91
					System.out.println("Mavi karti çevirip sirayla denizi, gokyuzu ve dil fotosuna isaret edin.");
					// Line: 92
					iristk.flow.DialogFlow.wait waitState40 = new iristk.flow.DialogFlow.wait();
					waitState40.setMsec(3000);
					if (!flowThread.callState(waitState40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 92, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state41 = new iristk.flow.DialogFlow.say();
					StringCreator string42 = new StringCreator();
					string42.append("The sea, the sky and the ball are all blue. Blue");
					state41.setText(string42.toString());
					if (!flowThread.callState(state41, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 86, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 94
					TeachGreen state43 = new TeachGreen();
					flowThread.gotoState(state43, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 94, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 86, 12));
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
			// Line: 99
			try {
				EXECUTION: {
					int count = getCount(212628335) + 1;
					incrCount(212628335);
					// Line: 100
					System.out.println("Yesil renkli karti gosterin ve sallayin.");
					// Line: 101
					iristk.flow.DialogFlow.wait waitState44 = new iristk.flow.DialogFlow.wait();
					waitState44.setMsec(3000);
					if (!flowThread.callState(waitState44, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 101, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state45 = new iristk.flow.DialogFlow.say();
					StringCreator string46 = new StringCreator();
					string46.append("This is green.");
					state45.setText(string46.toString());
					if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 99, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 104
					System.out.println("Yesil karti cevirip sirayla cimen, agac ve elma fotosuna işaret edin.");
					// Line: 105
					iristk.flow.DialogFlow.wait waitState47 = new iristk.flow.DialogFlow.wait();
					waitState47.setMsec(3000);
					if (!flowThread.callState(waitState47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 105, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state48 = new iristk.flow.DialogFlow.say();
					StringCreator string49 = new StringCreator();
					string49.append("The grass, the tree and the apple are all green. Green");
					state48.setText(string49.toString());
					if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 99, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 107
					CheckAgain state50 = new CheckAgain();
					flowThread.gotoState(state50, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 107, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 99, 12));
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
			// Line: 112
			try {
				EXECUTION: {
					int count = getCount(1993134103) + 1;
					incrCount(1993134103);
					iristk.flow.DialogFlow.say state51 = new iristk.flow.DialogFlow.say();
					StringCreator string52 = new StringCreator();
					string52.append("Do you want to continue?");
					state51.setText(string52.toString());
					if (!flowThread.callState(state51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state53 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 112, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 116
			try {
				count = getCount(405662939) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(405662939);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state54 = new iristk.flow.DialogFlow.say();
							StringCreator string55 = new StringCreator();
							string55.append("Okay, let's play again.");
							state54.setText(string55.toString());
							if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 116, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 118
							Start state56 = new Start();
							flowThread.gotoState(state56, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 118, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 116, 58));
			}
			// Line: 120
			try {
				count = getCount(1130478920) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1130478920);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state57 = new iristk.flow.DialogFlow.say();
							StringCreator string58 = new StringCreator();
							string58.append("Okay, goodbye");
							state57.setText(string58.toString());
							if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 120, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 122
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 120, 57));
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
			// Line: 127
			try {
				count = getCount(123961122) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(123961122);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state59 = new iristk.flow.DialogFlow.say();
						StringCreator string60 = new StringCreator();
						string60.append("I am sorry, I didn't hear anything.");
						state59.setText(string60.toString());
						if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 127, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 129
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 129, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 127, 38));
			}
			// Line: 131
			try {
				count = getCount(1982791261) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1982791261);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state61 = new iristk.flow.DialogFlow.say();
						StringCreator string62 = new StringCreator();
						string62.append("I am sorry, I didn't get that.");
						state61.setText(string62.toString());
						if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 131, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 133
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 133, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\learnColors\\src\\iristk\\app\\learnColors\\LearnColorsFlow.xml"), 131, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
