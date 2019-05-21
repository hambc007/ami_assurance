import { TestBed } from '@angular/core/testing';

import { SecuriteService } from './securite.service';

describe('SecuriteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SecuriteService = TestBed.get(SecuriteService);
    expect(service).toBeTruthy();
  });
});
