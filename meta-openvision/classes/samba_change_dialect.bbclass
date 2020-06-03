# Due to recent publicity about security vulnerabilities in the
# much older CIFS dialect, this moves the default dialect to the
# widely accepted (and quite secure) SMB3.0 dialect from the
# old default of the CIFS dialect.

# We do not want to be encouraging use of less secure dialects,
# and both Microsoft and CERT now strongly recommend not using the
# older CIFS dialect (SMB Security Best Practices
# "recommends disabling SMBv1").

# SMB3 is both secure and widely available: in Windows 8 and later,
# Samba and Macs.

# Users can still choose to explicitly mount with the less secure
# dialect (for old servers) by choosing "vers=1.0" on the cifs
# mount e.g. to take advantage of Samba's "CIFS POSIX Extensions".

do_openvisionsambachangedialect(){
    find ${S}/ -type f -name "connect.c" | xargs -L1 sed -i '0,/smb1_operations/! {0,/smb1_operations/ s/smb1_operations/smb30_operations/}'
    find ${S}/ -type f -name "connect.c" | xargs -L1 sed -i '0,/smb1_values/! {0,/smb1_values/ s/smb1_values/smb30_values/}'
}

addtask openvisionsambachangedialect before do_configure after do_unpack
