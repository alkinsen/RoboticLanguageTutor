package iristk.app.readCaterpillar;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class ReadCaterpillarFlow extends iristk.flow.Flow {

	private String name;

	private void initVariables() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("name")) return this.name;
		return null;
	}


	public ReadCaterpillarFlow() {
		initVariables();
	}

	@Override
	public State getInitialState() {return new Start();}


	public class Start extends State implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 9
			try {
				EXECUTION: {
					int count = getCount(1334729950) + 1;
					incrCount(1334729950);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("The Very Hungry Caterpillar by Eric Carle");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state2 = new iristk.flow.DialogFlow.say();
					StringCreator string3 = new StringCreator();
					string3.append("In the light of the moon a little egg lay on a leaf.");
					state2.setText(string3.toString());
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state4 = new iristk.flow.DialogFlow.say();
					StringCreator string5 = new StringCreator();
					string5.append("One Sunday morning the warm sun came up and - pop! - out of the egg came a tiny and very hungry caterpillar.");
					state4.setText(string5.toString());
					if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state6 = new iristk.flow.DialogFlow.say();
					StringCreator string7 = new StringCreator();
					string7.append("He started to look for some food. I am so hungry!");
					state6.setText(string7.toString());
					if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state8 = new iristk.flow.DialogFlow.say();
					StringCreator string9 = new StringCreator();
					string9.append("On Monday he ate through 1 apple, but he was still hungry.");
					state8.setText(string9.toString());
					if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state10 = new iristk.flow.DialogFlow.say();
					StringCreator string11 = new StringCreator();
					string11.append("On Tuesday he ate through 2 pears, but he was still hungry.");
					state10.setText(string11.toString());
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state12 = new iristk.flow.DialogFlow.say();
					StringCreator string13 = new StringCreator();
					string13.append("On Wednesday he ate through 3 plums, but he was still hungry.");
					state12.setText(string13.toString());
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state14 = new iristk.flow.DialogFlow.say();
					StringCreator string15 = new StringCreator();
					string15.append("On Thursday he ate through 4 strawberries, but he was still hungry.");
					state14.setText(string15.toString());
					if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state16 = new iristk.flow.DialogFlow.say();
					StringCreator string17 = new StringCreator();
					string17.append("On Friday he ate through 5 oranges, but he was still hungry.");
					state16.setText(string17.toString());
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state18 = new iristk.flow.DialogFlow.say();
					StringCreator string19 = new StringCreator();
					string19.append("On Saturday he ate through 1 piece of chocolate cake,");
					state18.setText(string19.toString());
					if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state20 = new iristk.flow.DialogFlow.say();
					StringCreator string21 = new StringCreator();
					string21.append("1 icecream cone,");
					state20.setText(string21.toString());
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state22 = new iristk.flow.DialogFlow.say();
					StringCreator string23 = new StringCreator();
					string23.append("1 pickle,");
					state22.setText(string23.toString());
					if (!flowThread.callState(state22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state24 = new iristk.flow.DialogFlow.say();
					StringCreator string25 = new StringCreator();
					string25.append("One slice of Swiss cheese,");
					state24.setText(string25.toString());
					if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state26 = new iristk.flow.DialogFlow.say();
					StringCreator string27 = new StringCreator();
					string27.append("1 slice of salami,");
					state26.setText(string27.toString());
					if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state28 = new iristk.flow.DialogFlow.say();
					StringCreator string29 = new StringCreator();
					string29.append("1 lollipop,");
					state28.setText(string29.toString());
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state30 = new iristk.flow.DialogFlow.say();
					StringCreator string31 = new StringCreator();
					string31.append("1 piece of cherry pie,");
					state30.setText(string31.toString());
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state32 = new iristk.flow.DialogFlow.say();
					StringCreator string33 = new StringCreator();
					string33.append("1 sausage,");
					state32.setText(string33.toString());
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state34 = new iristk.flow.DialogFlow.say();
					StringCreator string35 = new StringCreator();
					string35.append("1 cupcake,");
					state34.setText(string35.toString());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state36 = new iristk.flow.DialogFlow.say();
					StringCreator string37 = new StringCreator();
					string37.append("And 1 slice of watermelon. That night he had a stomachache!");
					state36.setText(string37.toString());
					if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state38 = new iristk.flow.DialogFlow.say();
					StringCreator string39 = new StringCreator();
					string39.append("The very hungry caterpillar then ate through one green leaf. He started to feel better.");
					state38.setText(string39.toString());
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state40 = new iristk.flow.DialogFlow.say();
					StringCreator string41 = new StringCreator();
					string41.append("Now, the caterpillar was no longer small. He was a big, fat caterpillar.");
					state40.setText(string41.toString());
					if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state42 = new iristk.flow.DialogFlow.say();
					StringCreator string43 = new StringCreator();
					string43.append("He built a small house, called a cocoon around himself. He stayed inside for more than 2 weeks. Then he nibbled a small hole in the cocoon, pushed his way out and...");
					state42.setText(string43.toString());
					if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state44 = new iristk.flow.DialogFlow.say();
					StringCreator string45 = new StringCreator();
					string45.append("He was a beautiful butterfly!");
					state44.setText(string45.toString());
					if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 9, 12));
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
			// Line: 37
			try {
				count = getCount(1174290147) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1174290147);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state46 = new iristk.flow.DialogFlow.say();
						StringCreator string47 = new StringCreator();
						string47.append("I am sorry, I didn't hear anything.");
						state46.setText(string47.toString());
						if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 37, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 39
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 39, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 37, 38));
			}
			// Line: 41
			try {
				count = getCount(1285044316) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1285044316);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state48 = new iristk.flow.DialogFlow.say();
						StringCreator string49 = new StringCreator();
						string49.append("I am sorry, I didn't get that.");
						state48.setText(string49.toString());
						if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 41, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 43
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 43, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readCaterpillar\\src\\iristk\\app\\readCaterpillar\\ReadCaterpillarFlow.xml"), 41, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
