import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DisplayText } from './display-text';

describe('DisplayText', () => {
  let fixture: ComponentFixture<DisplayText>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DisplayText],
    }).compileComponents();

    fixture = TestBed.createComponent(DisplayText);
    fixture.componentRef.setInput('label', 'Nom');
    fixture.componentRef.setInput('value', 'Dupont');
    fixture.detectChanges();
  });

  it('renders signal inputs in the template', () => {
    const element = fixture.nativeElement as HTMLElement;
    expect(element.querySelector('.field-label')?.textContent).toBe('Nom');
    expect(element.querySelector('.field-value')?.textContent).toBe('Dupont');
  });

  it('shows an em dash when value is undefined', () => {
    fixture.componentRef.setInput('value', undefined);
    fixture.detectChanges();

    const element = fixture.nativeElement as HTMLElement;
    expect(element.querySelector('.field-value')?.textContent).toBe('—');
  });
});
