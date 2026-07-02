import { TestBed } from '@angular/core/testing';
import { DisplayText } from './display-text';

describe('DisplayText', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DisplayText],
    }).compileComponents();
  });

  it('renders label and value', () => {
    const fixture = TestBed.createComponent(DisplayText);
    fixture.componentRef.setInput('label', 'Nom');
    fixture.componentRef.setInput('value', 'Dupont');
    fixture.detectChanges();

    const element = fixture.nativeElement as HTMLElement;
    expect(element.querySelector('.field-label')?.textContent).toBe('Nom');
    expect(element.querySelector('.field-value')?.textContent).toBe('Dupont');
  });

  it('shows em dash placeholder when value is undefined', () => {
    const fixture = TestBed.createComponent(DisplayText);
    fixture.componentRef.setInput('label', 'Nom');
    fixture.componentRef.setInput('value', undefined);
    fixture.detectChanges();

    expect(fixture.nativeElement.querySelector('.field-value')?.textContent).toBe('—');
  });
});
