SUMMARY  = "pysmb is an experimental SMB/CIFS library written in Python"
DESCRIPTION = "pysmb is an experimental SMB/CIFS library written in Python to support file sharing between Windows and Linux machines. It implements the client-side SMB/CIFS protocol which allows your Python application to access and transfer files to/from SMB/CIFS shared folders like your Windows file sharing and Samba folders."
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f696da4bf6c34ef3b926285a84dfa60c"

inherit setuptools

SRCNAME = "pysmb"
SRC_URI = "https://files.pythonhosted.org/packages/30/4f/e587e716d7fede081a49cb50189b07943892629bd4b63f0fafc981a5b2cc/pysmb-${PV}.zip"

S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[md5sum] = "72bb3b08a3ae3ff34eda519a49afff3f"
SRC_URI[sha256sum] = "f16e5e796b9dcc1d17ee76f87d53dd471f205fa19b4045eeda5bc7558a57d579"

include python-package-split.inc
