import { ChangeDetectorRef, inject, Pipe, PipeTransform } from '@angular/core';
import { ReferenceName, ReferenceLoaderService } from './references.service';

@Pipe({
  name: 'reference',
  pure: false,
  standalone: true,
})
export class ReferencePipe implements PipeTransform {
  value: string | number | boolean | undefined;
  private readonly referenceService = inject(ReferenceLoaderService);
  private readonly _ref = inject(ChangeDetectorRef);

  transform(value: string | undefined, reference: ReferenceName): string | number | boolean {
    if (!value) return '';
    return this.referenceService.getLabel(value, reference) ?? '';
  }
}
