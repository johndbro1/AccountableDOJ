# AccountableDOJ
Tracking the Pleadings of Lawyers at the Department of Justice

## Data Model

### User
* DatabaseID
* Username (String)
* UsernameType (String) (Bluesky, Email, TBD)
* Active (True/False)

### ApiKey
* UserID (User DatabaseID)
* AccessKey (String)
* SecretKey (String)
* Creation (Timestamp)
* Expiration (Timestamp)
* ExpirationType (Manual, Automatic)

### Role
* DatabaseID
* Key (String)
* Description (String)

### UserRole
* UserDatabaseID
* RoleDatabaseID
* Active (True/False)
* AssignedOn (Timestamp)
* AssignedBy (User DatabaseID)

### Case
* DatabaseID
* Number (String)
* Court (String)
* Judge (String)
* Title (String)
* PACERCaseID (String)
* Status (String) (Open, Closed, Appealed, TBD)
* Type (String) (Federal, TBD)
* FiledOn (Timestamp)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)



### Lawyer
* DatabaseID
* Name (String)
* Description (String)
* LegalStatus (String) (Active, Disbarred, Retired, Deceased)
* Membership (String) (DOJ, Other, TBD)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)

### Document
* DatabaseID
* Title (String)
* VersionNumber (String)
* IsLatest (True/False)
* URL (String)
* StorageType (String) (S3, Custom, TBD)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)

### ExternalLink
* DatabaseID
* Type (String) (WWW, TBD)
* URL (String)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)

### Commentary
* DatabaseID
* ReferenceType (String) (Pleading, EvaluationOrder, TBD)
* Summary (String)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)





### LawyerIdentifier
* DatabaseID
* Identity (String)
* Type (String) (Email, Bluesky, Twitter, BarNumber, CourtRegistrationNumber, TBD)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)
* Parent (Lawyer DatabaseID)

### LawyerNote
* DatabaseID
* Parent (Lawyer DatabaseID)
* Text (String)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)

; probably overkill
;### AdmittedCourt
;* DatabaseID
;* Parent (Lawyer DatabaseID)
;* CourtType (String)
;* CourtIdentity (String)
;* CreatedBy (User DatabaseID)
;* CreatedOn (Timestamp)
;* Active (True/False)

### CaseLawyer
* DatabaseID
* Parent (Case DatabaseID)
* Lawyer (Lawyer DatabaseID)
* Type (String) (Plaintiff, Defendant, TBD)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)


### Pleading
* DatabaseID
* Parent (Case DatabaseID)
* CaseLawyer (CaseLawyer DatabaseID)
* PACERPleadingID (String)
* Description (String)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)

### PleadingDocument
* DatabaseID
* Parent (Pleading DatabaseID)
* Document (Document DatabaseID)
* Active (True/False)

### PleadingExternalLink
* DatabaseID
* Parent (Pleading DatabaseID)
* ExternalLink (ExternalLink DatabaseID)
* Active (True/False)

### PleadingCommentary
* DatabaseID
* Parent (Pleading DatabaseID)
* Commentary (Commentary DatabaseID)
* Active (True/False)

### CourtOrder
* DatabaseID
* Identifier (String)
* Judge (String)
* Case (Case DatabaseID)
* Pleading (Pleading DatabaseID)
* CreatedBy (User DatabaseID)
* CreatedOn (Timestamp)
* Active (True/False)

### CourtOrderExternalLink
* DatabaseID
* Parent (CourtOrder DatabaseID)
* ExternalLink (ExternalLink DatabaseID)
* Active (True/False)

### CourtOrderDocument
* DatabaseID
* Parent (CourtOrder DatabaseID)
* Document (Document DatabaseID)
* Active (True/False)

### CourtOrderCommentary
* DatabaseID
* Parent (CourtOrder DatabaseID)
* Commentary (Commentary DatabaseID)
* Active (True/False)


### CommentaryDocument
* DatabaseID
* Parent (Commentary DatabaseID)
* Document (Document DatabaseID)
* Active (True/False)


### CommentaryExternalLink
* DatabaseID
* Parent (Commentary DatabaseID)
* ExternalLink (ExternalLink DatabaseID)
* Active (True/False)


