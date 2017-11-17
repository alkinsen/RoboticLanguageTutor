package iristk.app.readBear;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class ReadBearFlow extends iristk.flow.Flow {


	private void initVariables() {
	}

	@Override
	public Object getVariable(String name) {
		return null;
	}


	public ReadBearFlow() {
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
			// Line: 7
			try {
				EXECUTION: {
					int count = getCount(463345942) + 1;
					incrCount(463345942);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Brown Bear, Brown Bear. Brown Bear, Brown Bear what do you see? I see a red bird looking at me. Red bird, red bird what do you see? I see a yellow duck looking at me. Yellow duck, yellow duck, what do you see? I see a blue horse looking at me. Blue horse, blue horse what do you see? I see a green frog looking at me. Green frog, green frog what do you see? I see a purple cat looking at me. Purple cat, purple cat what do you see? I see a white dog looking at me. White dog, white dog what do you see? I see a black sheep looking at me. Black sheep, black sheep what do you see? I see a gold fish looking at me. Gold fish, gold fish what do you see? I see children looking at me. Children, children what do you see?  We see a human looking at us.");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readBear\\src\\iristk\\app\\readBear\\ReadBearFlow.xml"), 7, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readBear\\src\\iristk\\app\\readBear\\ReadBearFlow.xml"), 7, 12));
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
			// Line: 24
			try {
				count = getCount(997608398) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(997608398);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state2 = new iristk.flow.DialogFlow.say();
						StringCreator string3 = new StringCreator();
						string3.append("I am sorry, I didn't hear anything.");
						state2.setText(string3.toString());
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readBear\\src\\iristk\\app\\readBear\\ReadBearFlow.xml"), 24, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 26
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readBear\\src\\iristk\\app\\readBear\\ReadBearFlow.xml"), 26, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readBear\\src\\iristk\\app\\readBear\\ReadBearFlow.xml"), 24, 38));
			}
			// Line: 28
			try {
				count = getCount(1212899836) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1212899836);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state4 = new iristk.flow.DialogFlow.say();
						StringCreator string5 = new StringCreator();
						string5.append("I am sorry, I didn't get that.");
						state4.setText(string5.toString());
						if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readBear\\src\\iristk\\app\\readBear\\ReadBearFlow.xml"), 28, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 30
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readBear\\src\\iristk\\app\\readBear\\ReadBearFlow.xml"), 30, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readBear\\src\\iristk\\app\\readBear\\ReadBearFlow.xml"), 28, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
