import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NvabarComponent } from './nvabar.component';

describe('NvabarComponent', () => {
  let component: NvabarComponent;
  let fixture: ComponentFixture<NvabarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NvabarComponent]
    });
    fixture = TestBed.createComponent(NvabarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
