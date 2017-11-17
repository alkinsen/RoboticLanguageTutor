package iristk.app.readPigs;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class ReadPigsFlow extends iristk.flow.Flow {


	private void initVariables() {
	}

	@Override
	public Object getVariable(String name) {
		return null;
	}


	public ReadPigsFlow() {
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
					string1.append("The Three Little Pigs. Once upon a time, there lived three little pigs. Each little pig built a house. The first little pig built a straw house. A wolf knocked on the door. Let me come in, said the wolf. No!, said the little pig. Then I will blow your house in!, said the wolf. The wolf blew the house in. The little pig ran to his brothers house. The second little pig built a house of sticks. He was not afraid of the wolf. Let me come in, said the wolf. No!, yelled the pigs. The wolf blew the house in. The little pigs ran to their brothers house. The third little pig built a brick house. His brothers warned him about the wolf. Let me come in, yelled the wolf. No!, shouted the little pigs. The wolf huffed and puffed. But the wolf could not blow down the brick house. The three little pigs lived happily ever after.");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readPigs\\src\\iristk\\app\\readPigs\\ReadPigsFlow.xml"), 7, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readPigs\\src\\iristk\\app\\readPigs\\ReadPigsFlow.xml"), 7, 12));
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
			// Line: 34
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
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readPigs\\src\\iristk\\app\\readPigs\\ReadPigsFlow.xml"), 34, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 36
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readPigs\\src\\iristk\\app\\readPigs\\ReadPigsFlow.xml"), 36, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readPigs\\src\\iristk\\app\\readPigs\\ReadPigsFlow.xml"), 34, 38));
			}
			// Line: 38
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
						if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readPigs\\src\\iristk\\app\\readPigs\\ReadPigsFlow.xml"), 38, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 40
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readPigs\\src\\iristk\\app\\readPigs\\ReadPigsFlow.xml"), 40, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\romialsaid\\Desktop\\RoboticLanguageTutor\\app\\readPigs\\src\\iristk\\app\\readPigs\\ReadPigsFlow.xml"), 38, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
