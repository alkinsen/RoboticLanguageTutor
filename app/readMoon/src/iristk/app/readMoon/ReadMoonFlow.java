package iristk.app.readMoon;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class ReadMoonFlow extends iristk.flow.Flow {


	private void initVariables() {
	}

	@Override
	public Object getVariable(String name) {
		return null;
	}


	public ReadMoonFlow() {
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
					string1.append("Goodnight Moon by Margaret Wise Brown. In the great green room, There was a telephone. And a red balloon. And a picture of, the cow jumping over the moon. And there were three little bears sitting on chairs. And two little kittens. And a pair of mittens. And a little toy house. And a young mouse. And a comb and a brush and a bowl full of mush. And a quiet old lady who was whispering, hush. Goodnight room. Goodnight moon. Goodnight cow jumping over the moon. Goodnight light. And the red balloon. Goodnight bears. Goodnight chairs. Goodnight kittens. And goodnight mittens. Goodnight clocks. And goodnight socks.  Goodnight little house. And goodnight mouse. Goodnight comb. And goodnight brush. Goodnight nobody. Goodnight mush.  And goodnight to the old lady whispering, hush . Goodnight stars. Goodnight air. Good night noises everywhere.");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readMoon\\src\\iristk\\app\\readMoon\\ReadMoonFlow.xml"), 7, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readMoon\\src\\iristk\\app\\readMoon\\ReadMoonFlow.xml"), 7, 12));
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
			// Line: 21
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
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readMoon\\src\\iristk\\app\\readMoon\\ReadMoonFlow.xml"), 21, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 23
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readMoon\\src\\iristk\\app\\readMoon\\ReadMoonFlow.xml"), 23, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readMoon\\src\\iristk\\app\\readMoon\\ReadMoonFlow.xml"), 21, 38));
			}
			// Line: 25
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
						if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readMoon\\src\\iristk\\app\\readMoon\\ReadMoonFlow.xml"), 25, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 27
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readMoon\\src\\iristk\\app\\readMoon\\ReadMoonFlow.xml"), 27, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readMoon\\src\\iristk\\app\\readMoon\\ReadMoonFlow.xml"), 25, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
