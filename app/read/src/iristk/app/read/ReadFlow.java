package iristk.app.read;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;
import iristk.situated.Location;

public class ReadFlow extends iristk.flow.Flow {

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


	public ReadFlow(iristk.situated.SystemAgentFlow agent) {
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
			// Line: 14
			try {
				EXECUTION: {
					int count = getCount(997608398) + 1;
					incrCount(997608398);
					// Line: 15
					lookChild state0 = new lookChild();
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 15, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state1 = agent.new say();
					StringCreator string2 = new StringCreator();
					string2.append("Hello there! Which book would you like to read, Bear of Butterfly?");
					state1.setText(string2.toString());
					state1.setGesture("smile");
					if (!flowThread.callState(state1, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 14, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state3 = agent.new listen();
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 14, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 14, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 19
			try {
				count = getCount(1174290147) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:bear")) {
						incrCount(1174290147);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 20
							Bear state4 = new Bear();
							flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 20, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 19, 59));
			}
			// Line: 22
			try {
				count = getCount(1285044316) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:butterfly")) {
						incrCount(1285044316);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 23
							Butterfly state5 = new Butterfly();
							flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 23, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 22, 64));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Butterfly extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 28
			try {
				EXECUTION: {
					int count = getCount(1588970020) + 1;
					incrCount(1588970020);
					// Line: 29
					lookChild state6 = new lookChild();
					if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 29, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state7 = agent.new say();
					StringCreator string8 = new StringCreator();
					string8.append("I love this book! It is called The Very Hungry Caterpillar by Eric Carle.");
					state7.setText(string8.toString());
					state7.setGesture("smile");
					if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 31
					System.out.println("Hikaye icin yesil corabi ve yemek resimlerini hazirlayin.");
					// Line: 32
					iristk.flow.DialogFlow.wait waitState9 = new iristk.flow.DialogFlow.wait();
					waitState9.setMsec(3000);
					if (!flowThread.callState(waitState9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 32, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state10 = agent.new say();
					StringCreator string11 = new StringCreator();
					string11.append("Are you ready? Let's start.");
					state10.setText(string11.toString());
					state10.setGesture("smile");
					if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state12 = agent.new say();
					StringCreator string13 = new StringCreator();
					string13.append("In the light of the moon a little egg lay on a leaf.");
					state12.setText(string13.toString());
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 35
					iristk.flow.DialogFlow.wait waitState14 = new iristk.flow.DialogFlow.wait();
					waitState14.setMsec(1000);
					if (!flowThread.callState(waitState14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 35, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 36
					System.out.println("Corabi kutusundan cikarin ve pop sesi cikarin. Corabi elinize gecirin.");
					iristk.situated.SystemAgentFlow.say state15 = agent.new say();
					StringCreator string16 = new StringCreator();
					string16.append("One Sunday morning the warm sun came up and - pop! - out of the egg came a tiny and very hungry caterpillar.");
					state15.setText(string16.toString());
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 38
					lookCaretaker state17 = new lookCaretaker();
					if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 38, 33)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 39
					iristk.flow.DialogFlow.wait waitState18 = new iristk.flow.DialogFlow.wait();
					waitState18.setMsec(4000);
					if (!flowThread.callState(waitState18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 39, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 40
					lookChild state19 = new lookChild();
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 40, 29)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state20 = agent.new say();
					StringCreator string21 = new StringCreator();
					string21.append("He started to look for some food. I am so hungry!");
					state20.setText(string21.toString());
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 42
					System.out.println("- SO HUNGRY - sesi cikarin.");
					// Line: 43
					iristk.flow.DialogFlow.wait waitState22 = new iristk.flow.DialogFlow.wait();
					waitState22.setMsec(3000);
					if (!flowThread.callState(waitState22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 43, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 44
					System.out.println("Elinizle elmayi alin ve - nam nam - sesi çıkarın.");
					iristk.situated.SystemAgentFlow.say state23 = agent.new say();
					StringCreator string24 = new StringCreator();
					string24.append("On Monday he ate through 1 apple");
					state23.setText(string24.toString());
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 46
					iristk.flow.DialogFlow.wait waitState25 = new iristk.flow.DialogFlow.wait();
					waitState25.setMsec(5000);
					if (!flowThread.callState(waitState25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 46, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 47
					Hungry state26 = new Hungry();
					if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 47, 26)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 50
					System.out.println("Elinizle armutlari alin ve - nam nam - sesi çıkarın.");
					iristk.situated.SystemAgentFlow.say state27 = agent.new say();
					StringCreator string28 = new StringCreator();
					string28.append("On Tuesday he ate through 2 pears");
					state27.setText(string28.toString());
					if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 52
					iristk.flow.DialogFlow.wait waitState29 = new iristk.flow.DialogFlow.wait();
					waitState29.setMsec(5000);
					if (!flowThread.callState(waitState29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 52, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 53
					Hungry state30 = new Hungry();
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 53, 26)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 55
					System.out.println("Elinizle erikleri alin ve - nam nam - sesi çıkarın.");
					iristk.situated.SystemAgentFlow.say state31 = agent.new say();
					StringCreator string32 = new StringCreator();
					string32.append("On Wednesday he ate through 3 plums");
					state31.setText(string32.toString());
					if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 57
					iristk.flow.DialogFlow.wait waitState33 = new iristk.flow.DialogFlow.wait();
					waitState33.setMsec(5000);
					if (!flowThread.callState(waitState33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 57, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 58
					Hungry state34 = new Hungry();
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 58, 26)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 60
					System.out.println("Elinizle cilekleri alin ve - nam nam - sesi çıkarın.");
					iristk.situated.SystemAgentFlow.say state35 = agent.new say();
					StringCreator string36 = new StringCreator();
					string36.append("On Thursday he ate through 4 strawberries");
					state35.setText(string36.toString());
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 62
					iristk.flow.DialogFlow.wait waitState37 = new iristk.flow.DialogFlow.wait();
					waitState37.setMsec(5000);
					if (!flowThread.callState(waitState37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 62, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 63
					Hungry state38 = new Hungry();
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 63, 26)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 65
					System.out.println("Elinizle portakallari alin ve - nam nam - sesi çıkarın.");
					iristk.situated.SystemAgentFlow.say state39 = agent.new say();
					StringCreator string40 = new StringCreator();
					string40.append("On Friday he ate through 5 oranges");
					state39.setText(string40.toString());
					if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 67
					iristk.flow.DialogFlow.wait waitState41 = new iristk.flow.DialogFlow.wait();
					waitState41.setMsec(5000);
					if (!flowThread.callState(waitState41, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 67, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 68
					Hungry state42 = new Hungry();
					if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 68, 26)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state43 = agent.new say();
					StringCreator string44 = new StringCreator();
					string44.append("On Saturday he ate through 1 piece of chocolate cake,");
					state43.setText(string44.toString());
					if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 72
					iristk.flow.DialogFlow.wait waitState45 = new iristk.flow.DialogFlow.wait();
					waitState45.setMsec(1500);
					if (!flowThread.callState(waitState45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 72, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state46 = agent.new say();
					StringCreator string47 = new StringCreator();
					string47.append("1 icecream cone,");
					state46.setText(string47.toString());
					if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 74
					iristk.flow.DialogFlow.wait waitState48 = new iristk.flow.DialogFlow.wait();
					waitState48.setMsec(1500);
					if (!flowThread.callState(waitState48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 74, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state49 = agent.new say();
					StringCreator string50 = new StringCreator();
					string50.append("1 pickle,");
					state49.setText(string50.toString());
					if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 76
					iristk.flow.DialogFlow.wait waitState51 = new iristk.flow.DialogFlow.wait();
					waitState51.setMsec(1500);
					if (!flowThread.callState(waitState51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 76, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state52 = agent.new say();
					StringCreator string53 = new StringCreator();
					string53.append("One slice of Swiss cheese,");
					state52.setText(string53.toString());
					if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 78
					iristk.flow.DialogFlow.wait waitState54 = new iristk.flow.DialogFlow.wait();
					waitState54.setMsec(1500);
					if (!flowThread.callState(waitState54, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 78, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state55 = agent.new say();
					StringCreator string56 = new StringCreator();
					string56.append("1 slice of salami,");
					state55.setText(string56.toString());
					if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 80
					iristk.flow.DialogFlow.wait waitState57 = new iristk.flow.DialogFlow.wait();
					waitState57.setMsec(1500);
					if (!flowThread.callState(waitState57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 80, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state58 = agent.new say();
					StringCreator string59 = new StringCreator();
					string59.append("1 lollipop,");
					state58.setText(string59.toString());
					if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 82
					iristk.flow.DialogFlow.wait waitState60 = new iristk.flow.DialogFlow.wait();
					waitState60.setMsec(1500);
					if (!flowThread.callState(waitState60, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 82, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state61 = agent.new say();
					StringCreator string62 = new StringCreator();
					string62.append("1 piece of cherry pie,");
					state61.setText(string62.toString());
					if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 84
					iristk.flow.DialogFlow.wait waitState63 = new iristk.flow.DialogFlow.wait();
					waitState63.setMsec(1500);
					if (!flowThread.callState(waitState63, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 84, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state64 = agent.new say();
					StringCreator string65 = new StringCreator();
					string65.append("1 sausage,");
					state64.setText(string65.toString());
					if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 86
					iristk.flow.DialogFlow.wait waitState66 = new iristk.flow.DialogFlow.wait();
					waitState66.setMsec(1500);
					if (!flowThread.callState(waitState66, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 86, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state67 = agent.new say();
					StringCreator string68 = new StringCreator();
					string68.append("1 cupcake,");
					state67.setText(string68.toString());
					if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 88
					iristk.flow.DialogFlow.wait waitState69 = new iristk.flow.DialogFlow.wait();
					waitState69.setMsec(1500);
					if (!flowThread.callState(waitState69, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 88, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state70 = agent.new say();
					StringCreator string71 = new StringCreator();
					string71.append("And 1 slice of watermelon. That night he had a stomach ache!");
					state70.setText(string71.toString());
					if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 90
					System.out.println("Karninizi ovalayin ve agri hissini canlandirin.");
					// Line: 91
					iristk.flow.DialogFlow.wait waitState72 = new iristk.flow.DialogFlow.wait();
					waitState72.setMsec(3000);
					if (!flowThread.callState(waitState72, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 91, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state73 = agent.new say();
					StringCreator string74 = new StringCreator();
					string74.append("The very hungry caterpillar then ate through one green leaf. He started to feel better.");
					state73.setText(string74.toString());
					state73.setGesture("smile");
					if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 93
					System.out.println("Karninizi ovalayin ve iyi hissettiginizi gosterin.");
					// Line: 94
					iristk.flow.DialogFlow.wait waitState75 = new iristk.flow.DialogFlow.wait();
					waitState75.setMsec(3000);
					if (!flowThread.callState(waitState75, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 94, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state76 = agent.new say();
					StringCreator string77 = new StringCreator();
					string77.append("Now, the caterpillar was no longer small. He was a big, fat caterpillar.");
					state76.setText(string77.toString());
					if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 96
					System.out.println("- Big - diyerek buyuklugunu vurgulayin.");
					// Line: 97
					iristk.flow.DialogFlow.wait waitState78 = new iristk.flow.DialogFlow.wait();
					waitState78.setMsec(3000);
					if (!flowThread.callState(waitState78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 97, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state79 = agent.new say();
					StringCreator string80 = new StringCreator();
					string80.append("He built a small house, called a cocoon around himself. He stayed inside for more than 2 weeks. Then he nibbled a small hole in the cocoon, pushed his way out and");
					state79.setText(string80.toString());
					if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 99
					System.out.println("Sasirin!");
					// Line: 100
					iristk.flow.DialogFlow.wait waitState81 = new iristk.flow.DialogFlow.wait();
					waitState81.setMsec(3000);
					if (!flowThread.callState(waitState81, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 100, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state82 = agent.new say();
					StringCreator string83 = new StringCreator();
					string83.append("He was a beautiful butterfly!");
					state82.setText(string83.toString());
					if (!flowThread.callState(state82, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 102
					System.out.println("Kelebek oyuncagini cikarin.");
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 28, 12));
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


	private class Hungry extends State {

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
					int count = getCount(123961122) + 1;
					incrCount(123961122);
					iristk.situated.SystemAgentFlow.say state84 = agent.new say();
					StringCreator string85 = new StringCreator();
					string85.append("but he was still hungry.");
					state84.setText(string85.toString());
					if (!flowThread.callState(state84, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 107, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 109
					System.out.println("So hungry! sesi cikarin.");
					// Line: 110
					iristk.flow.DialogFlow.wait waitState86 = new iristk.flow.DialogFlow.wait();
					waitState86.setMsec(1500);
					if (!flowThread.callState(waitState86, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 110, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 111
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 111, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 107, 12));
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


	private class Bear extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 118
			try {
				EXECUTION: {
					int count = getCount(942731712) + 1;
					incrCount(942731712);
					iristk.situated.SystemAgentFlow.say state87 = agent.new say();
					StringCreator string88 = new StringCreator();
					string88.append("Brown Bear, Brown Bear.");
					state87.setText(string88.toString());
					if (!flowThread.callState(state87, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 120
					iristk.flow.DialogFlow.wait waitState89 = new iristk.flow.DialogFlow.wait();
					waitState89.setMsec(2000);
					if (!flowThread.callState(waitState89, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 120, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state90 = agent.new say();
					StringCreator string91 = new StringCreator();
					string91.append("Brown Bear, Brown Bear what do you see? I see a red bird looking at me.");
					state90.setText(string91.toString());
					if (!flowThread.callState(state90, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 122
					iristk.flow.DialogFlow.wait waitState92 = new iristk.flow.DialogFlow.wait();
					waitState92.setMsec(2000);
					if (!flowThread.callState(waitState92, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 122, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state93 = agent.new say();
					StringCreator string94 = new StringCreator();
					string94.append("Red bird, red bird what do you see? I see a yellow duck looking at me.");
					state93.setText(string94.toString());
					if (!flowThread.callState(state93, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 124
					iristk.flow.DialogFlow.wait waitState95 = new iristk.flow.DialogFlow.wait();
					waitState95.setMsec(2000);
					if (!flowThread.callState(waitState95, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 124, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state96 = agent.new say();
					StringCreator string97 = new StringCreator();
					string97.append("Yellow duck, yellow duck, what do you see? I see a blue horse looking at me.");
					state96.setText(string97.toString());
					if (!flowThread.callState(state96, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 126
					iristk.flow.DialogFlow.wait waitState98 = new iristk.flow.DialogFlow.wait();
					waitState98.setMsec(2000);
					if (!flowThread.callState(waitState98, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 126, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state99 = agent.new say();
					StringCreator string100 = new StringCreator();
					string100.append("Blue horse, blue horse what do you see? I see a green frog looking at me.");
					state99.setText(string100.toString());
					if (!flowThread.callState(state99, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 128
					iristk.flow.DialogFlow.wait waitState101 = new iristk.flow.DialogFlow.wait();
					waitState101.setMsec(2000);
					if (!flowThread.callState(waitState101, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 128, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state102 = agent.new say();
					StringCreator string103 = new StringCreator();
					string103.append("Green frog, green frog what do you see? I see a purple cat looking at me.");
					state102.setText(string103.toString());
					if (!flowThread.callState(state102, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 130
					iristk.flow.DialogFlow.wait waitState104 = new iristk.flow.DialogFlow.wait();
					waitState104.setMsec(2000);
					if (!flowThread.callState(waitState104, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 130, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state105 = agent.new say();
					StringCreator string106 = new StringCreator();
					string106.append("Purple cat, purple cat what do you see? I see a white dog looking at me.");
					state105.setText(string106.toString());
					if (!flowThread.callState(state105, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 132
					iristk.flow.DialogFlow.wait waitState107 = new iristk.flow.DialogFlow.wait();
					waitState107.setMsec(2000);
					if (!flowThread.callState(waitState107, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 132, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state108 = agent.new say();
					StringCreator string109 = new StringCreator();
					string109.append("White dog, white dog what do you see? I see a black sheep looking at me.");
					state108.setText(string109.toString());
					if (!flowThread.callState(state108, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 134
					iristk.flow.DialogFlow.wait waitState110 = new iristk.flow.DialogFlow.wait();
					waitState110.setMsec(2000);
					if (!flowThread.callState(waitState110, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 134, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state111 = agent.new say();
					StringCreator string112 = new StringCreator();
					string112.append("Black sheep, black sheep what do you see? I see a gold fish looking at me.");
					state111.setText(string112.toString());
					if (!flowThread.callState(state111, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 136
					iristk.flow.DialogFlow.wait waitState113 = new iristk.flow.DialogFlow.wait();
					waitState113.setMsec(2000);
					if (!flowThread.callState(waitState113, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 136, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state114 = agent.new say();
					StringCreator string115 = new StringCreator();
					string115.append("Gold fish, gold fish what do you see? I see children looking at me.");
					state114.setText(string115.toString());
					if (!flowThread.callState(state114, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 138
					iristk.flow.DialogFlow.wait waitState116 = new iristk.flow.DialogFlow.wait();
					waitState116.setMsec(2000);
					if (!flowThread.callState(waitState116, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 138, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state117 = agent.new say();
					StringCreator string118 = new StringCreator();
					string118.append("Children, children what do you see?");
					state117.setText(string118.toString());
					if (!flowThread.callState(state117, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 140
					iristk.flow.DialogFlow.wait waitState119 = new iristk.flow.DialogFlow.wait();
					waitState119.setMsec(2000);
					if (!flowThread.callState(waitState119, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 140, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state120 = agent.new say();
					StringCreator string121 = new StringCreator();
					string121.append("We see a human looking at us.");
					state120.setText(string121.toString());
					if (!flowThread.callState(state120, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 118, 12));
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
			// Line: 146
			try {
				EXECUTION: {
					int count = getCount(1068824137) + 1;
					incrCount(1068824137);
					iristk.situated.SystemAgentFlow.say state122 = agent.new say();
					StringCreator string123 = new StringCreator();
					string123.append("Do you want to continue?");
					state122.setText(string123.toString());
					if (!flowThread.callState(state122, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 146, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state124 = agent.new listen();
					if (!flowThread.callState(state124, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 146, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 146, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 150
			try {
				count = getCount(537548559) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(537548559);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state125 = agent.new say();
							StringCreator string126 = new StringCreator();
							string126.append("Okay, let's read again.");
							state125.setText(string126.toString());
							if (!flowThread.callState(state125, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 150, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 152
							Start state127 = new Start();
							flowThread.gotoState(state127, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 152, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 150, 58));
			}
			// Line: 154
			try {
				count = getCount(237852351) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(237852351);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state128 = agent.new say();
							StringCreator string129 = new StringCreator();
							string129.append("Okay, goodbye");
							state128.setText(string129.toString());
							if (!flowThread.callState(state128, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 154, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 156
							System.exit(0);
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 154, 57));
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
			// Line: 161
			try {
				count = getCount(1608446010) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1608446010);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state130 = agent.new say();
						StringCreator string131 = new StringCreator();
						string131.append("I am sorry, I didn't hear anything.");
						state130.setText(string131.toString());
						if (!flowThread.callState(state130, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 161, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 163
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 163, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 161, 38));
			}
			// Line: 165
			try {
				count = getCount(511833308) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(511833308);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state132 = agent.new say();
						StringCreator string133 = new StringCreator();
						string133.append("I am sorry, I didn't get that.");
						state132.setText(string133.toString());
						if (!flowThread.callState(state132, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 165, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 167
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 167, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 165, 36));
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
			// Line: 176
			try {
				EXECUTION: {
					int count = getCount(1252585652) + 1;
					incrCount(1252585652);
					// Line: 177
					Event sendEvent134 = new Event("action.gaze");
					sendEvent134.putIfNotNull("location", new Location(degx, degy, degz));
					flowRunner.sendEvent(sendEvent134, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 177, 76)));
					// Line: 178
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 178, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 176, 12));
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
			// Line: 183
			try {
				EXECUTION: {
					int count = getCount(1361960727) + 1;
					incrCount(1361960727);
					// Line: 184
					Event sendEvent135 = new Event("action.gaze");
					sendEvent135.putIfNotNull("location", new Location(-1, 0, 1));
					flowRunner.sendEvent(sendEvent135, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 184, 68)));
					// Line: 185
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 185, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 183, 12));
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
			// Line: 190
			try {
				EXECUTION: {
					int count = getCount(166239592) + 1;
					incrCount(166239592);
					// Line: 191
					Event sendEvent136 = new Event("action.gaze");
					sendEvent136.putIfNotNull("location", new Location(1, 0, 1));
					flowRunner.sendEvent(sendEvent136, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 191, 67)));
					// Line: 192
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 192, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 190, 12));
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
			// Line: 197
			try {
				EXECUTION: {
					int count = getCount(2085857771) + 1;
					incrCount(2085857771);
					// Line: 198
					Event sendEvent137 = new Event("action.gaze");
					sendEvent137.putIfNotNull("location", new Location(0, -1, 1));
					flowRunner.sendEvent(sendEvent137, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 198, 68)));
					// Line: 199
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 199, 14)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ASEN14\\Desktop\\bitirme\\IrisTK\\app\\read\\src\\iristk\\app\\read\\ReadFlow.xml"), 197, 12));
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
