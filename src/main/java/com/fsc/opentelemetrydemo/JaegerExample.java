package com.fsc.opentelemetrydemo;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.stereotype.Service;

@Service
public final class JaegerExample {

  private final OpenTelemetry openTelemetry;

  private final Tracer tracer;

  public JaegerExample(OpenTelemetry openTelemetry, Tracer tracer) {
    this.openTelemetry = openTelemetry;

    this.tracer = tracer;
  }

  private void myWonderfulUseCase() {
    // Generate a span
    Span span = this.tracer.spanBuilder("Start my wonderful use case").startSpan();
    span.addEvent("Event 0");
    // execute my use case - here we simulate a wait
    doWork();
    span.addEvent("Event 1");
    span.end();
  }

  private void doWork() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // do the right thing here
    }
  }

  public void run() {
    // generate a few sample spans
    for (int i = 0; i < 10; i++) {
      this.myWonderfulUseCase();
    }

    System.out.println("Bye");
  }
}
